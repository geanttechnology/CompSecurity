// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            bq

final class br
    implements Runnable
{

    private bq a;

    br(bq bq1)
    {
        a = bq1;
        super();
    }

    public final void run()
    {
        bq.a(a);
    }
}
