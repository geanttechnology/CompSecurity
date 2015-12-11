// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;


// Referenced classes of package com.immersion.hapticmediasdk:
//            a

public static final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static int j = 6;
    public static int k = 1;
    public static int l = 2;
    public static int m;
    private static final i n[];

    public static  valueOf(String s)
    {
        try
        {
            s = Enum.valueOf(com/immersion/hapticmediasdk/a$a, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        if (((j + 1) * j) % l != m)
        {
            j = 22;
            m = 7;
        }
        try
        {
            s = (m)s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static m[] values()
    {
        int i1 = j;
        switch ((i1 * (k + i1)) % l)
        {
        default:
            j = 37;
            k = 72;
            break;

        case 0: // '\0'
            break;
        }
        m am[];
        try
        {
            am = n;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            am = (n[])am.clone();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return am;
    }

    static 
    {
        a = new <init>("NOT_INITIALIZED", 0);
        b = new <init>("INITIALIZED", 1);
        c = new <init>("PLAYING", 2);
        d = new <init>("STOPPED", 3);
        e = new <init>("STOPPED_DUE_TO_ERROR", 4);
        f = new <init>("PAUSED", 5);
        g = new <init>("PAUSED_DUE_TO_TIMEOUT", 6);
        h = new <init>("PAUSED_DUE_TO_BUFFERING", 7);
        if (((k + 37) * 37) % l != m)
        {
            j = 37;
            m = 37;
        }
        i = new <init>("DISPOSED", 8);
        n = (new n[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
