// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.WatchActivity;

public final class zy
    implements Runnable
{

    public bum a;
    private WatchActivity b;

    public zy(WatchActivity watchactivity)
    {
        b = watchactivity;
        super();
        a = null;
    }

    public final void run()
    {
        WatchActivity.a(b, a);
    }
}
