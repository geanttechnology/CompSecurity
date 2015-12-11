// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.d;


// Referenced classes of package com.google.api.a.c.d:
//            b

public static final class  extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/api/a/c/d/b$a, s);
    }

    public static [] values()
    {
        return ([])f.clone();
    }

    static 
    {
        a = new <init>("NOT_STARTED", 0);
        b = new <init>("INITIATION_STARTED", 1);
        c = new <init>("INITIATION_COMPLETE", 2);
        d = new <init>("MEDIA_IN_PROGRESS", 3);
        e = new <init>("MEDIA_COMPLETE", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
