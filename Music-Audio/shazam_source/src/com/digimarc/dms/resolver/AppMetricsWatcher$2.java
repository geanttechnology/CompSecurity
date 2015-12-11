// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.digimarc.dms.resolver:
//            AppMetricsWatcher, ResolverService, AppMetricsReporter

class this._cls0
    implements ServiceConnection
{

    final AppMetricsWatcher this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        try
        {
            mResolver = ((lverBinder)ibinder).getService();
            if (mResolver != null)
            {
                mResolver.setOnResolvedListener(AppMetricsWatcher.access$000(AppMetricsWatcher.this));
                AppMetricsReporter.reportOneTimeAppMetrics(mContext, mResolver);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            String _tmp = AppMetricsWatcher.access$100(AppMetricsWatcher.this);
        }
        (new StringBuilder("DMSAppMetricsWatcher.ServiceConnection.onServiceConnected:")).append(componentname.getMessage());
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        mResolver = null;
    }

    lverBinder()
    {
        this$0 = AppMetricsWatcher.this;
        super();
    }
}
