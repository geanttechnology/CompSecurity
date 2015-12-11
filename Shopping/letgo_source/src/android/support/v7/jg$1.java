// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            jg

static final class c
    implements Runnable
{

    final jg a;
    final long b;
    final String c;

    public void run()
    {
        jg.a(a, b, c);
    }

    (jg jg1, long l, String s)
    {
        a = jg1;
        b = l;
        c = s;
        super();
    }
}
