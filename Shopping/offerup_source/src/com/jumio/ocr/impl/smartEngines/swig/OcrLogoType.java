// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public final class OcrLogoType
{

    public static final OcrLogoType OcrLogoTypeAmericanExpress;
    public static final OcrLogoType OcrLogoTypeDinersClub;
    public static final OcrLogoType OcrLogoTypeDiscover;
    public static final OcrLogoType OcrLogoTypeMasterCard;
    public static final OcrLogoType OcrLogoTypeUnknown;
    public static final OcrLogoType OcrLogoTypeVisa;
    private static OcrLogoType a[];
    private static int b = 0;
    private final int c;
    private final String d;

    private OcrLogoType(String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }

    private OcrLogoType(String s, int i)
    {
        d = s;
        c = i;
        b = i + 1;
    }

    public static OcrLogoType swigToEnum(int i)
    {
        if (i < a.length && i >= 0 && a[i].c == i)
        {
            return a[i];
        }
        for (int j = 0; j < a.length; j++)
        {
            if (a[j].c == i)
            {
                return a[j];
            }
        }

        throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/ocr/impl/smartEngines/swig/OcrLogoType).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        OcrLogoTypeUnknown = new OcrLogoType("OcrLogoTypeUnknown", jniInterfaceJNI.OcrLogoTypeUnknown_get());
        OcrLogoTypeVisa = new OcrLogoType("OcrLogoTypeVisa");
        OcrLogoTypeMasterCard = new OcrLogoType("OcrLogoTypeMasterCard");
        OcrLogoTypeAmericanExpress = new OcrLogoType("OcrLogoTypeAmericanExpress");
        OcrLogoTypeDiscover = new OcrLogoType("OcrLogoTypeDiscover");
        OcrLogoTypeDinersClub = new OcrLogoType("OcrLogoTypeDinersClub");
        a = (new OcrLogoType[] {
            OcrLogoTypeUnknown, OcrLogoTypeVisa, OcrLogoTypeMasterCard, OcrLogoTypeAmericanExpress, OcrLogoTypeDiscover, OcrLogoTypeDinersClub
        });
    }
}
