package com.spring.practice.model;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String SEQUENCE_POSTFIX = "_seq";
    private static final String TABLE_PREFIX = "tbl_";
    private static final String COLUMN_PREFIX = "c_";

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        String newName = String.format("%s%s", identifier.getText(), SEQUENCE_POSTFIX);
        return Identifier.toIdentifier(newName);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        String newName = String.format("%s%s", TABLE_PREFIX, logicalName.getText());
        return Identifier.toIdentifier(newName);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
        String newName = String.format("%s%s", COLUMN_PREFIX, logicalName.getText());
        return Identifier.toIdentifier(newName);
    }
}
