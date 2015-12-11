// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7.media:
//            RegisteredMediaRouteProvider, MediaRouter

final class RegisteredMediaRouteProviderWatcher
{

    private final Context mContext;
    private final PackageManager mPackageManager;
    private final ArrayList mProviders = new ArrayList();
    private final MediaRouter mRouter;

    public RegisteredMediaRouteProviderWatcher(Context context, MediaRouter mediarouter)
    {
        mContext = context;
        mRouter = mediarouter;
        mPackageManager = context.getPackageManager();
    }

    private int findProvider(String s, String s1)
    {
        int j = mProviders.size();
        for (int i = 0; i < j; i++)
        {
            if (((RegisteredMediaRouteProvider)mProviders.get(i)).hasComponentName(s, s1))
            {
                return i;
            }
        }

        return -1;
    }

    private void scanPackages()
    {
        int i = 0;
        Object obj = new Intent("android.media.MediaRouteProviderService");
        obj = mPackageManager.queryIntentServices(((Intent) (obj)), 0).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = ((ResolveInfo)((Iterator) (obj)).next()).serviceInfo;
            if (obj1 != null)
            {
                int j = findProvider(((ServiceInfo) (obj1)).packageName, ((ServiceInfo) (obj1)).name);
                if (j < 0)
                {
                    obj1 = new RegisteredMediaRouteProvider(mContext, new ComponentName(((ServiceInfo) (obj1)).packageName, ((ServiceInfo) (obj1)).name));
                    ((RegisteredMediaRouteProvider) (obj1)).start();
                    mProviders.add(i, obj1);
                    mRouter.addProvider(((MediaRouteProvider) (obj1)));
                    i++;
                } else
                if (j >= i)
                {
                    ((RegisteredMediaRouteProvider)mProviders.get(j)).rebindIfDisconnected();
                    Collections.swap(mProviders, j, i);
                    i++;
                }
            }
        } while (true);
        if (i < mProviders.size())
        {
            for (int k = mProviders.size() - 1; k >= i; k--)
            {
                RegisteredMediaRouteProvider registeredmediarouteprovider = (RegisteredMediaRouteProvider)mProviders.get(k);
                mRouter.removeProvider(registeredmediarouteprovider);
                mProviders.remove(registeredmediarouteprovider);
                registeredmediarouteprovider.stop();
            }

        }
    }

    public void start()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
        mContext.registerReceiver(new BroadcastReceiver() {

            final RegisteredMediaRouteProviderWatcher this$0;

            public void onReceive(Context context, Intent intent)
            {
                scanPackages();
            }

            
            {
                this$0 = RegisteredMediaRouteProviderWatcher.this;
                super();
            }
        }, intentfilter);
        scanPackages();
    }

}
