// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            iy

class a
    implements Runnable
{

    final long a;
    final iy b;

    public void run()
    {
        b.e(a);
        iy.a(b, false);
    }

    (iy iy1, long l)
    {
        b = iy1;
        a = l;
        super();
    }
}
