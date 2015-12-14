// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.moreview.e;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            VideoPlaybackActivity

class a
    implements p
{

    final VideoPlaybackActivity a;

    public void a(AdapterView adapterview, View view, int i, long l)
    {
        if (com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.b(a) == null)
        {
            return;
        } else
        {
            VideoPlaybackActivity.a(a, i);
            VideoPlaybackActivity.c(a).a(i, true);
            adapterview = (b)com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.b(a).getItem(i);
            StatusManager.j().a(adapterview);
            VideoPlaybackActivity.a(a, adapterview);
            return;
        }
    }

    dapterView(VideoPlaybackActivity videoplaybackactivity)
    {
        a = videoplaybackactivity;
        super();
    }
}
