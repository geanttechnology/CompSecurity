// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;

// Referenced classes of package android.support.v7:
//            ajj

public static final class oString extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g j[];
    private String h;
    private String i;

    public static oString a(String s)
    {
        if (s != null)
        {
            oString aostring[] = values();
            int l = aostring.length;
            for (int k = 0; k < l; k++)
            {
                oString ostring = aostring[k];
                if (ostring.d(s))
                {
                    return ostring;
                }
            }

        }
        return g;
    }

    private boolean d(String s)
    {
        return s.toLowerCase(Locale.US).startsWith(i);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(android/support/v7/ajj$a, s);
    }

    public static i[] values()
    {
        return (i[])j.clone();
    }

    public String b(String s)
    {
        return (new StringBuilder()).append(i).append(s).toString();
    }

    public String c(String s)
    {
        if (!d(s))
        {
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] {
                s, h
            }));
        } else
        {
            return s.substring(i.length());
        }
    }

    static 
    {
        a = new <init>("HTTP", 0, "http");
        b = new <init>("HTTPS", 1, "https");
        c = new <init>("FILE", 2, "file");
        d = new <init>("CONTENT", 3, "content");
        e = new <init>("ASSETS", 4, "assets");
        f = new <init>("DRAWABLE", 5, "drawable");
        g = new <init>("UNKNOWN", 6, "");
        j = (new j[] {
            a, b, c, d, e, f, g
        });
    }

    private Exception(String s, int k, String s1)
    {
        super(s, k);
        h = s1;
        i = (new StringBuilder()).append(s1).append("://").toString();
    }
}
