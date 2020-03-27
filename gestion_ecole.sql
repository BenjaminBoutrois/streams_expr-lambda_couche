-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 27 mars 2020 à 11:25
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `Theme` varchar(64) NOT NULL,
  `Heures` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`Theme`, `Heures`) VALUES
('Francais', 6);

-- --------------------------------------------------------

--
-- Structure de la table `coursetudiant`
--

CREATE TABLE `coursetudiant` (
  `Cours` varchar(64) NOT NULL,
  `Etudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `coursetudiant`
--

INSERT INTO `coursetudiant` (`Cours`, `Etudiant`) VALUES
('Francais', 13);

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

CREATE TABLE `ecole` (
  `nom` varchar(64) NOT NULL,
  `mail` varchar(64) NOT NULL,
  `adresse` varchar(64) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `directeur` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `id` int(11) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `mail` varchar(64) NOT NULL,
  `adresse` varchar(64) NOT NULL,
  `numero` varchar(64) NOT NULL,
  `matiere` varchar(64) NOT NULL,
  `mdp` varchar(120) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id`, `nom`, `prenom`, `mail`, `adresse`, `numero`, `matiere`, `mdp`, `role`) VALUES
(555, 'Responsable', 'des Etudes', 'resp@ensup.fr', 'Ensup Guyancourt', '101010101', '23 janvier', 'resp', 'responsable'),
(666, 'Monsieur', 'Le Directeur', 'direct@ensup.fr', 'Ensup Guyancourt', '123456789', '22 janvier', 'admin', 'directeur');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `mail` varchar(64) NOT NULL,
  `adresse` varchar(64) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `dateNaissance` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `mail`, `adresse`, `numero`, `dateNaissance`) VALUES
(4, 'Simpson', 'Mr.', 'Springfield', '1 rue charles de gaulle', '2001', '2010-04-02'),
(6, 'Eric', 'mr', 'Springfield', 'ok', '2001', '2010-04-02'),
(13, 'Jean', 'Paul', 'jjj@jj.ff', 'Street', '123456789', '12 juillet'),
(90, 'KO', 'OK', 'papa@jj', '7 rue rip', '678593759', '13 janv'),
(123, 'jojo', 'bizarre', 'aventure', 'jeanbaptiste', '127287288', 'janvier'),
(777, 'jean', 'baptiste', 'jb@ensup.fr', 'ici', '904949449', '11 janvier 2019'),
(1001, 'Simpson', 'Mr.', 'Springfield', 'ok', '2001', '2010-04-02');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`Theme`);

--
-- Index pour la table `coursetudiant`
--
ALTER TABLE `coursetudiant`
  ADD KEY `Cours` (`Cours`),
  ADD KEY `Id` (`Etudiant`);

--
-- Index pour la table `ecole`
--
ALTER TABLE `ecole`
  ADD PRIMARY KEY (`nom`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `coursetudiant`
--
ALTER TABLE `coursetudiant`
  ADD CONSTRAINT `Cours` FOREIGN KEY (`Cours`) REFERENCES `cours` (`Theme`),
  ADD CONSTRAINT `Id` FOREIGN KEY (`Etudiant`) REFERENCES `etudiant` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
