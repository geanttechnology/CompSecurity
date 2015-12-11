// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;


// Referenced classes of package c.a.a.a.a.e:
//            c

final class b
{

    static final int a[];

    static 
    {
        a = new int[c.a().length];
        int ai[];
        ai = a;
        int i = c.a;
        ai[0] = 1;
_L6:
        ai = a;
        int j = c.b;
        ai[1] = 2;
_L4:
        ai = a;
        int k = c.c;
        ai[2] = 3;
_L2:
        int ai1[];
        try
        {
            ai1 = a;
            int l = c.d;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        ai1[3] = 4;
        return;
        NoSuchFieldError nosuchfielderror1;
        nosuchfielderror1;
        if (true) goto _L2; else goto _L1
_L1:
        nosuchfielderror1;
        if (true) goto _L4; else goto _L3
_L3:
        nosuchfielderror1;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
