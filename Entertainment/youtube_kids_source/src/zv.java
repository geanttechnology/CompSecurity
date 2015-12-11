// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.WatchActivity;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;

public final class zv
    implements Runnable
{

    private bum a;
    private WatchActivity b;

    public zv(WatchActivity watchactivity, bum bum)
    {
        b = watchactivity;
        a = bum;
        super();
    }

    public final void run()
    {
        WatchActivity.c(b).a(a);
    }
}
