// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            akh, alh

static final class a
    implements Runnable
{

    final alh a;

    public void run()
    {
        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(a.a()).append(" returned input Bitmap but recycled it.").toString());
    }

    eption(alh alh1)
    {
        a = alh1;
        super();
    }
}
