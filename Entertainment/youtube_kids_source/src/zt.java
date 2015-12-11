// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.WatchActivity;

public final class zt
    implements android.view.View.OnClickListener
{

    private WatchActivity a;

    public zt(WatchActivity watchactivity)
    {
        a = watchactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.g.b(0x7f08001d);
        WatchActivity.b(a).n();
    }
}
