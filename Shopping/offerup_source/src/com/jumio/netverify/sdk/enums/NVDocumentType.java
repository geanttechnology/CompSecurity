// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;

import jumiomobile.hs;

public final class NVDocumentType extends Enum
{

    private static final NVDocumentType $VALUES[];
    public static final NVDocumentType DRIVER_LICENSE;
    public static final NVDocumentType IDENTITY_CARD;
    public static final NVDocumentType PASSPORT;
    private static final String TYPE_DRIVER_LICENSE = "DRIVER_LICENSE";
    private static final String TYPE_DRIVING_LICENSE = "DRIVING_LICENSE";
    private static final String TYPE_ID_CARD = "ID_CARD";
    private static final String TYPE_PASSPORT = "PASSPORT";
    private static final String TYPE_VISA = "VISA";
    public static final NVDocumentType VISA;

    private NVDocumentType(String s, int i)
    {
        super(s, i);
    }

    public static NVDocumentType fromString(String s)
    {
        NVDocumentType nvdocumenttype = null;
        if (s.equals("DRIVING_LICENSE") || s.equals("DRIVER_LICENSE"))
        {
            nvdocumenttype = DRIVER_LICENSE;
        } else
        {
            if (s.equals("ID_CARD"))
            {
                return IDENTITY_CARD;
            }
            if (s.equals("PASSPORT"))
            {
                return PASSPORT;
            }
            if (s.equals("VISA"))
            {
                return VISA;
            }
        }
        return nvdocumenttype;
    }

    public static NVDocumentType valueOf(String s)
    {
        return (NVDocumentType)Enum.valueOf(com/jumio/netverify/sdk/enums/NVDocumentType, s);
    }

    public static NVDocumentType[] values()
    {
        return (NVDocumentType[])$VALUES.clone();
    }

    public final String toString()
    {
        switch (hs.a[ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "PASSPORT";

        case 2: // '\002'
            return "VISA";

        case 3: // '\003'
            return "DRIVING_LICENSE";

        case 4: // '\004'
            return "ID_CARD";
        }
    }

    static 
    {
        PASSPORT = new NVDocumentType("PASSPORT", 0);
        VISA = new NVDocumentType("VISA", 1);
        DRIVER_LICENSE = new NVDocumentType("DRIVER_LICENSE", 2);
        IDENTITY_CARD = new NVDocumentType("IDENTITY_CARD", 3);
        $VALUES = (new NVDocumentType[] {
            PASSPORT, VISA, DRIVER_LICENSE, IDENTITY_CARD
        });
    }
}
