// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.module;


public final class ModuleDimension extends Enum
{

    private static final ModuleDimension $VALUES[];
    public static final ModuleDimension CARD;
    public static final ModuleDimension FOURxONE;
    public static final ModuleDimension FOURxONEDOTTHIRTYSEVEN;
    public static final ModuleDimension FOURxTWO;
    public static final ModuleDimension RAIL;
    public static final ModuleDimension TWOxONE;
    public static final ModuleDimension TWOxTWO;
    private final int columns;
    private final boolean isFullWidth;
    private final int rows;
    private final String stringRepresentation;

    private ModuleDimension(String s, int i, int j, int k, String s1, boolean flag)
    {
        super(s, i);
        columns = j;
        rows = k;
        stringRepresentation = s1;
        isFullWidth = flag;
    }

    public static ModuleDimension from(String s)
    {
        ModuleDimension amoduledimension[] = values();
        int j = amoduledimension.length;
        for (int i = 0; i < j; i++)
        {
            ModuleDimension moduledimension = amoduledimension[i];
            if (moduledimension.stringRepresentation.equals(s))
            {
                return moduledimension;
            }
        }

        return TWOxTWO;
    }

    public static ModuleDimension valueOf(String s)
    {
        return (ModuleDimension)Enum.valueOf(com/shazam/model/module/ModuleDimension, s);
    }

    public static ModuleDimension[] values()
    {
        return (ModuleDimension[])$VALUES.clone();
    }

    public final int getColumns()
    {
        return columns;
    }

    public final int getRows()
    {
        return rows;
    }

    public final String getStringRepresentation()
    {
        return stringRepresentation;
    }

    public final boolean isFullWidth()
    {
        return isFullWidth;
    }

    static 
    {
        TWOxONE = new ModuleDimension("TWOxONE", 0, 2, 1, "2x1", false);
        TWOxTWO = new ModuleDimension("TWOxTWO", 1, 2, 2, "2x2", false);
        FOURxTWO = new ModuleDimension("FOURxTWO", 2, 4, 2, "4x2", true);
        FOURxONE = new ModuleDimension("FOURxONE", 3, 4, 1, "4x1", true);
        FOURxONEDOTTHIRTYSEVEN = new ModuleDimension("FOURxONEDOTTHIRTYSEVEN", 4, 4, 1, "4x1.37", true);
        CARD = new ModuleDimension("CARD", 5, 4, 4, "CARD", true);
        RAIL = new ModuleDimension("RAIL", 6, 4, 2, "RAIL", true);
        $VALUES = (new ModuleDimension[] {
            TWOxONE, TWOxTWO, FOURxTWO, FOURxONE, FOURxONEDOTTHIRTYSEVEN, CARD, RAIL
        });
    }
}
