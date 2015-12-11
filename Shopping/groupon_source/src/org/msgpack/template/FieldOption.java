// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;


public final class FieldOption extends Enum
{

    private static final FieldOption $VALUES[];
    public static final FieldOption DEFAULT;
    public static final FieldOption IGNORE;
    public static final FieldOption NULLABLE;
    public static final FieldOption OPTIONAL;
    public static final FieldOption REQUIRED;

    private FieldOption(String s, int i)
    {
        super(s, i);
    }

    public static FieldOption valueOf(String s)
    {
        return (FieldOption)Enum.valueOf(org/msgpack/template/FieldOption, s);
    }

    public static FieldOption[] values()
    {
        return (FieldOption[])$VALUES.clone();
    }

    static 
    {
        IGNORE = new FieldOption("IGNORE", 0);
        REQUIRED = new FieldOption("REQUIRED", 1);
        OPTIONAL = new FieldOption("OPTIONAL", 2);
        NULLABLE = new FieldOption("NULLABLE", 3);
        DEFAULT = new FieldOption("DEFAULT", 4);
        $VALUES = (new FieldOption[] {
            IGNORE, REQUIRED, OPTIONAL, NULLABLE, DEFAULT
        });
    }
}
