// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;


public final class FormFieldType extends Enum
{

    private static final FormFieldType $VALUES[];
    public static final FormFieldType DATE;
    public static final FormFieldType DATETIME;
    public static final FormFieldType HIDDEN;
    public static final FormFieldType MULTISELECT;
    public static final FormFieldType NUMBER;
    public static final FormFieldType SELECT;
    public static final FormFieldType TEXT;
    public static final FormFieldType TIME;

    private FormFieldType(String s, int i)
    {
        super(s, i);
    }

    public static FormFieldType parseType(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = valueOf(s.toUpperCase());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static FormFieldType valueOf(String s)
    {
        return (FormFieldType)Enum.valueOf(com/comcast/cim/microdata/model/FormFieldType, s);
    }

    public static FormFieldType[] values()
    {
        return (FormFieldType[])$VALUES.clone();
    }

    static 
    {
        TEXT = new FormFieldType("TEXT", 0);
        SELECT = new FormFieldType("SELECT", 1);
        MULTISELECT = new FormFieldType("MULTISELECT", 2);
        HIDDEN = new FormFieldType("HIDDEN", 3);
        NUMBER = new FormFieldType("NUMBER", 4);
        DATE = new FormFieldType("DATE", 5);
        TIME = new FormFieldType("TIME", 6);
        DATETIME = new FormFieldType("DATETIME", 7);
        $VALUES = (new FormFieldType[] {
            TEXT, SELECT, MULTISELECT, HIDDEN, NUMBER, DATE, TIME, DATETIME
        });
    }
}
