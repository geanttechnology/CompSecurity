// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;

// Referenced classes of package android.support.v7:
//            aq

public class as
{

    public static final Locale a = new Locale("", "");
    private static String b = "Arab";
    private static String c = "Hebr";

    public static int a(Locale locale)
    {
        if (locale != null && !locale.equals(a))
        {
            String s = aq.a(aq.b(locale.toString()));
            if (s == null)
            {
                return b(locale);
            }
            if (s.equalsIgnoreCase(b) || s.equalsIgnoreCase(c))
            {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale)
    {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0)))
        {
        default:
            return 0;

        case 1: // '\001'
        case 2: // '\002'
            return 1;
        }
    }

}
