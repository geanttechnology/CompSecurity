// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digimarc.dms.imagereader.Payload;

// Referenced classes of package com.digimarc.dms.resolver:
//            PayoffActionListener, AppMetricsReporter, ResolverService, ResolveResult

public class AppMetricsWatcher extends PayoffActionListener
{

    private String TAG;
    private ServiceConnection mConnection;
    private ResolverService.OnResolvedListener mResolveListener;

    public AppMetricsWatcher(Context context)
    {
        super(context);
        TAG = "DMSAppMetricsWatcher";
        mResolveListener = new ResolverService.OnResolvedListener() {

            final AppMetricsWatcher this$0;

            public void onError(Payload payload)
            {
            }

            public void onResolvedUnknown(ResolveResult resolveresult)
            {
            }

            public void onResolvedWithPayoff(ResolveResult resolveresult)
            {
                if (AppMetricsWatcher.isFakePayload(resolveresult.getPayload()))
                {
                    AppMetricsReporter.saveReportingCompletedCache();
                }
            }

            
            {
                this$0 = AppMetricsWatcher.this;
                super();
            }
        };
        mConnection = new ServiceConnection() {

            final AppMetricsWatcher this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                try
                {
                    mResolver = ((ResolverService.ResolverBinder)ibinder).getService();
                    if (mResolver != null)
                    {
                        mResolver.setOnResolvedListener(mResolveListener);
                        AppMetricsReporter.reportOneTimeAppMetrics(mContext, mResolver);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname)
                {
                    String _tmp = TAG;
                }
                (new StringBuilder("DMSAppMetricsWatcher.ServiceConnection.onServiceConnected:")).append(componentname.getMessage());
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mResolver = null;
            }

            
            {
                this$0 = AppMetricsWatcher.this;
                super();
            }
        };
        mContext = context;
    }

    public static boolean isFakePayload(Payload payload)
    {
        return payload.getCpmPath().contains(AppMetricsReporter.getFakePayload().getCpmPath());
    }

    public void start()
    {
        try
        {
            Activity activity = (Activity)mContext;
            ((Activity)mContext).bindService(new Intent(activity, com/digimarc/dms/resolver/ResolverService), mConnection, 1);
            return;
        }
        catch (Exception exception)
        {
            (new StringBuilder("DMSAppMetricsWatcher.start:")).append(exception.getMessage());
        }
    }

    public void stop()
    {
        try
        {
            mResolver.removeOnResolvedListener(mResolveListener);
            ((Activity)mContext).unbindService(mConnection);
            return;
        }
        catch (Exception exception)
        {
            (new StringBuilder("DMSAppMetricsWatcher.stop: ")).append(exception.getMessage());
        }
    }


}
