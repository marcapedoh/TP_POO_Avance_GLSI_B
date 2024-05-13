-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 13 mai 2024 à 12:14
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_mcapedoh`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(31) DEFAULT NULL,
  `prenom` varchar(63) DEFAULT NULL,
  `telephone` varchar(31) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `telephone`) VALUES
(1, 'APEDOH', 'Marc', '+22870344482'),
(2, 'DEBM', 'Mrc&Bititi', '+2289494745'),
(3, 'AGBA', 'Pam', '+2287985143558'),
(4, 'LEMOU', 'laelae', '+3376528155');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idProduit` int(11) NOT NULL,
  `libelle` varchar(123) DEFAULT NULL,
  `actif` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `libelle`, `actif`) VALUES
(1, 'Epargne', 'O'),
(2, 'Courant', 'N');

-- --------------------------------------------------------

--
-- Structure de la table `sms`
--

CREATE TABLE `sms` (
  `idSms` int(11) NOT NULL,
  `idClient` int(11) DEFAULT NULL,
  `libelle` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sms`
--

INSERT INTO `sms` (`idSms`, `idClient`, `libelle`) VALUES
(1, 1, 'cher client votre suscription est validé'),
(2, 2, 'cher client votre suscription est en attente');

-- --------------------------------------------------------

--
-- Structure de la table `souscription`
--

CREATE TABLE `souscription` (
  `idSous` int(11) NOT NULL,
  `idProduit` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `dateHeureSous` datetime DEFAULT NULL,
  `actif` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `souscription`
--

INSERT INTO `souscription` (`idSous`, `idProduit`, `idClient`, `dateHeureSous`, `actif`) VALUES
(1, 1, 1, '2024-05-13 12:06:25', 'o'),
(2, 2, 2, '2024-05-13 12:06:25', 'n');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD UNIQUE KEY `client_name_unique` (`nom`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idProduit`),
  ADD UNIQUE KEY `libelle_unique` (`libelle`);

--
-- Index pour la table `sms`
--
ALTER TABLE `sms`
  ADD PRIMARY KEY (`idSms`),
  ADD KEY `FK_association3` (`idClient`);

--
-- Index pour la table `souscription`
--
ALTER TABLE `souscription`
  ADD PRIMARY KEY (`idSous`),
  ADD KEY `FK_association1` (`idClient`),
  ADD KEY `FK_association2` (`idProduit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `souscription`
--
ALTER TABLE `souscription`
  MODIFY `idSous` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `sms`
--
ALTER TABLE `sms`
  ADD CONSTRAINT `FK_association3` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `souscription`
--
ALTER TABLE `souscription`
  ADD CONSTRAINT `FK_association1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `FK_association2` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
