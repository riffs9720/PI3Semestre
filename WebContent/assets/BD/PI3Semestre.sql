-- MySQL Script generated by MySQL Workbench
-- Mon Nov  6 21:32:57 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PI3Semestre
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PI3Semestre
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PI3Semestre` DEFAULT CHARACTER SET utf8 ;
USE `PI3Semestre` ;

-- -----------------------------------------------------
-- Table `PI3Semestre`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI3Semestre`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR (35) NOT NULL,
  `genero` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI3Semestre`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI3Semestre`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id´_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI3Semestre`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI3Semestre`.`Empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `Categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Empresa_Categoria_idx` (`Categoria_id` ASC),
  CONSTRAINT `fk_Empresa_Categoria`
    FOREIGN KEY (`Categoria_id`)
    REFERENCES `PI3Semestre`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI3Semestre`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI3Semestre`.`Avaliacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nota1` INT(1) NULL,
  `nota2` INT(1) NULL,
  `nota3` INT(1) NULL,
  `nota4` INT(1) NULL,
  `comentario1` VARCHAR(140) NULL,
  `comentario2` VARCHAR(140) NULL,
  `comentario3` VARCHAR(140) NULL,
  `comentario4` VARCHAR(140) NULL,
  `Usuario_id` INT NOT NULL,
  `Empresa_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Avaliacao_Usuario1_idx` (`Usuario_id` ASC),
  INDEX `fk_Avaliacao_Empresa1_idx` (`Empresa_id` ASC),
  CONSTRAINT `fk_Avaliacao_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `PI3Semestre`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaliacao_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `PI3Semestre`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



select * from Usuario;
select * from Categoria;
select * from Empresa;
select * from avaliacao;

insert into Usuario (nome, email, senha, genero) values ("Ricardo Ferla Silva", "r@ferla.com", "12345", "m");

