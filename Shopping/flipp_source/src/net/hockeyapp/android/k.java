// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;


// Referenced classes of package net.hockeyapp.android:
//            j, FeedbackActivity

final class k
    implements Runnable
{

    final j a;

    k(j j1)
    {
        a = j1;
        super();
    }

    public final void run()
    {
        a.a.b(true);
        a.a.showDialog(0);
    }
}
