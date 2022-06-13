# Create database "crm" with UTF8 encoding
# Definition of a collation -> https://dev.mysql.com/doc/refman/8.0/en/adding-collation.html#:~:text=A%20collation%20is%20a%20set,orders%20characters%20based%20on%20weights.
CREATE DATABASE IF NOT EXISTS `crm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

# Create user "crm" with password "crm"
CREATE USER 'crm'@'localhost' IDENTIFIED BY 'crm';

# Granting access and privileges on "crm" db
GRANT ALL PRIVILEGES ON crm . * TO 'crm'@'localhost';

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 06 mai 2022 à 13:30
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `crm`
--
CREATE DATABASE IF NOT EXISTS `crm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `crm`;

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE `customer` (
                            `id` int(11) NOT NULL,
                            `company_name` varchar(100) NOT NULL,
                            `first_name` varchar(100) NOT NULL,
                            `last_name` varchar(100) NOT NULL,
                            `email` varchar(100) NOT NULL,
                            `phone` varchar(15) NOT NULL,
                            `address` text NOT NULL,
                            `zip_code` varchar(15) NOT NULL,
                            `city` varchar(15) NOT NULL,
                            `country` varchar(15) NOT NULL,
                            `state` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `company_name`, `first_name`, `last_name`, `email`, `phone`, `address`, `zip_code`, `city`, `country`, `state`) VALUES
                                                                                                                                              (1, 'Capgemini', 'Fabrice', 'Martin', 'martin@mail.com\r\n', '0656858433', 'Head Office - Capgemini Service - Place de Étoile - 11 rue de Tilsitt - 75017 Paris', '75017', 'Paris', 'France', 1),
                                                                                                                                              (2, 'M2I Formation', 'Julien', 'Lamard\r\n', 'lamard@mail.com', '0611223344', '17 r Chaillot, 75116 Paris\r\n', '75116', 'Paris', 'France', 0),
                                                                                                                                              (3, 'Atos', 'Jean-Paul', 'Pomodoro', 'jean.paul@mail.com\r\n', '0656853233', 'Laboratoire digital.security 50 avenue Daumesnil Immeuble B 75012 Paris', '76017', 'Paris', 'France', 1),
                                                                                                                                              (4, 'Sopra Steria', 'Alain', 'Lampard', 'alain@sopra.com', '0611298344', 'Paris Presbourg - Kléber. 6 avenue Kleber, 79016, Paris', '79016', 'Paris', 'France', 0);

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
                          `id` int(11) NOT NULL,
                          `customerId` int(11) NOT NULL,
                          `type_presta` varchar(100) NOT NULL,
                          `designation` varchar(100) NOT NULL,
                          `nb_days` int(11) NOT NULL,
                          `unit_price` float NOT NULL,
                          `state` tinyint(1) NOT NULL,
                          `total_exclude_taxe` float GENERATED ALWAYS AS (`nb_days` * `unit_price`) STORED,
                          `totalWithTaxe` float GENERATED ALWAYS AS (`nb_days` * `unit_price` * 1.2) STORED
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`id`, `customerId`, `type_presta`, `designation`, `nb_days`, `unit_price`, `state`)VALUES
                                                                                                           (1, 2, 'Formation', 'Angular Initiation', 3, 1200, 0),
                                                                                                           (2, 2, 'Formation', 'React.js avancé', 3, 1000, 2),
                                                                                                           (3, 1, 'Coaching', 'React Techlead', 20, 900, 2),
                                                                                                           (4, 1, 'Coaching', 'Nest.js Techlead', 50, 800, 1),
                                                                                                           (5, 3, 'Coaching', 'React Techlead', 30, 1100, 2),
                                                                                                           (6, 3, 'Coaching', 'Jakarta EE', 57, 1200, 2),
                                                                                                           (7, 4, 'Coaching', 'Angular Techlead', 25, 1000, 1);

--
-- Index pour la table `customer`
--
ALTER TABLE `customer`
    ADD PRIMARY KEY (`id`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
    ADD PRIMARY KEY (`id`),
    ADD KEY `customerId` (`customerId`);


--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
    ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;