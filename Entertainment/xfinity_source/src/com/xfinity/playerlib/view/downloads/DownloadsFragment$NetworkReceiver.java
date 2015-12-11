// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsFragment

public class this._cls0 extends BroadcastReceiver
{

    final DownloadsFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (loadingViewDelegate.resourcesLoaded())
        {
            DownloadsFragment.access$100(DownloadsFragment.this);
        }
    }

    public te()
    {
        this$0 = DownloadsFragment.this;
        super();
    }
}
