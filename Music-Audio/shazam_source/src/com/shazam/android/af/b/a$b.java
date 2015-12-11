// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;


// Referenced classes of package com.shazam.android.af.b:
//            a

public static final class b extends Enum
{

    public static final a a;
    private static final a c[];
    private final String b;

    static String a(b b1)
    {
        return b1.b;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/shazam/android/af/b/a$b, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    static 
    {
        a = new <init>("TRACK_DETAILS_SCREEN", "tagresult");
        c = (new c[] {
            a
        });
    }

    private (String s, String s1)
    {
        super(s, 0);
        b = s1;
    }
}
