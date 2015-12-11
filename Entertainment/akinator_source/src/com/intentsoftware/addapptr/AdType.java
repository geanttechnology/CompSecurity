// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;

import java.lang.reflect.Field;
import java.util.Locale;

// Referenced classes of package com.intentsoftware.addapptr:
//            AdTypeInfo

public final class AdType extends Enum
{

    private static final AdType $VALUES[];
    public static final AdType BANNER;
    public static final AdType FULLSCREEN;

    private AdType(String s, int i)
    {
        super(s, i);
    }

    public static boolean contains(String s)
    {
        boolean flag = false;
        AdType aadtype[] = values();
        int j = aadtype.length;
        for (int i = 0; i < j; i++)
        {
            if (aadtype[i].name().equals(s))
            {
                flag = true;
            }
        }

        return flag;
    }

    public static AdType valueOf(String s)
    {
        return (AdType)Enum.valueOf(com/intentsoftware/addapptr/AdType, s);
    }

    public static AdType[] values()
    {
        return (AdType[])$VALUES.clone();
    }

    public String getReportPrefix()
    {
        AdTypeInfo adtypeinfo;
        try
        {
            adtypeinfo = (AdTypeInfo)getClass().getField(name()).getAnnotation(com/intentsoftware/addapptr/AdTypeInfo);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new RuntimeException(String.format(Locale.US, "%s is missing %s field.", new Object[] {
                getClass().getName(), name()
            }));
        }
        if (adtypeinfo != null)
        {
            return adtypeinfo.reportPrefix();
        } else
        {
            throw new RuntimeException(String.format(Locale.US, "%s ad size is missing AdTypeInfo annotation.", new Object[] {
                name()
            }));
        }
    }

    static 
    {
        FULLSCREEN = new AdType("FULLSCREEN", 0);
        BANNER = new AdType("BANNER", 1);
        $VALUES = (new AdType[] {
            FULLSCREEN, BANNER
        });
    }
}
