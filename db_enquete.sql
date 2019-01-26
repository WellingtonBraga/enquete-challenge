-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.33-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5291
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura para tabela enquete.options
DROP TABLE IF EXISTS `options`;
CREATE TABLE IF NOT EXISTS `options` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `qty` int(11) DEFAULT '0',
  `poll_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38ua6ecvr37aj9pj9nxjnxgr2` (`poll_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela enquete.polls
DROP TABLE IF EXISTS `polls`;
CREATE TABLE IF NOT EXISTS `polls` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela enquete.polls_options
DROP TABLE IF EXISTS `polls_options`;
CREATE TABLE IF NOT EXISTS `polls_options` (
  `poll_id` bigint(20) NOT NULL,
  `options_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_peon7uoob3c83yyf87ms1rm4y` (`options_id`),
  KEY `FK56g4y02cv7s71wet2dg8qiqtt` (`poll_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
