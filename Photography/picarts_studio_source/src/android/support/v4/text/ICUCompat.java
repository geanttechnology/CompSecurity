// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import java.util.Locale;

public class ICUCompat
{

    private static final ICUCompatImpl IMPL;

    public ICUCompat()
    {
    }

    public static String maximizeAndGetScript(Locale locale)
    {
        return IMPL.maximizeAndGetScript(locale);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            IMPL = new ICUCompatImplLollipop();
        } else
        if (i >= 14)
        {
            IMPL = new ICUCompatImplIcs();
        } else
        {
            IMPL = new ICUCompatImplBase();
        }
    }

    private class ICUCompatImpl
    {

        public abstract String maximizeAndGetScript(Locale locale);
    }


    private class ICUCompatImplLollipop
        implements ICUCompatImpl
    {

        public String maximizeAndGetScript(Locale locale)
        {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }

        ICUCompatImplLollipop()
        {
        }
    }


    private class ICUCompatImplIcs
        implements ICUCompatImpl
    {

        public String maximizeAndGetScript(Locale locale)
        {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }

        ICUCompatImplIcs()
        {
        }
    }


    private class ICUCompatImplBase
        implements ICUCompatImpl
    {

        public String maximizeAndGetScript(Locale locale)
        {
            return null;
        }

        ICUCompatImplBase()
        {
        }
    }

}
