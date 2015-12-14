// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import java.util.Locale;

public final class uriPrefix extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];
    private String scheme;
    private String uriPrefix;

    public static uriPrefix a(String s)
    {
        if (s != null)
        {
            uriPrefix auriprefix[] = values();
            int j = auriprefix.length;
            for (int i = 0; i < j; i++)
            {
                uriPrefix uriprefix = auriprefix[i];
                if (uriprefix.d(s))
                {
                    return uriprefix;
                }
            }

        }
        return g;
    }

    private boolean d(String s)
    {
        return s.toLowerCase(Locale.US).startsWith(uriPrefix);
    }

    public static uriPrefix valueOf(String s)
    {
        return (uriPrefix)Enum.valueOf(com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme, s);
    }

    public static uriPrefix[] values()
    {
        return (uriPrefix[])h.clone();
    }

    public String b(String s)
    {
        return (new StringBuilder()).append(uriPrefix).append(s).toString();
    }

    public String c(String s)
    {
        if (!d(s))
        {
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] {
                s, scheme
            }));
        } else
        {
            return s.substring(uriPrefix.length());
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
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        scheme = s1;
        uriPrefix = (new StringBuilder()).append(s1).append("://").toString();
    }
}
