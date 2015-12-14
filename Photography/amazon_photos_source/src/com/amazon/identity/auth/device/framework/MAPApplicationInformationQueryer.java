// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            TrustedPackageManager, ServiceWrappingContext, RemoteMapInfo, RemoteMAPException

public class MAPApplicationInformationQueryer
{
    public static class MAPApplicationCacheInvalidator extends BroadcastReceiver
    {

        private static final AtomicReference CACHE_INVALIDATOR_RECIVER = new AtomicReference();

        public static boolean isRegistered()
        {
            return CACHE_INVALIDATOR_RECIVER.get() != null;
        }

        public static void registerReceiver(Context context)
        {
            MAPApplicationCacheInvalidator mapapplicationcacheinvalidator = new MAPApplicationCacheInvalidator();
            if (!CACHE_INVALIDATOR_RECIVER.compareAndSet(null, mapapplicationcacheinvalidator))
            {
                MAPLog.formattedInfo(MAPApplicationInformationQueryer.TAG, "%s is already registered", new Object[] {
                    com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator.getSimpleName()
                });
                return;
            }
            String _tmp = MAPApplicationInformationQueryer.TAG;
            com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator.getSimpleName();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentfilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentfilter.addDataScheme("package");
            try
            {
                context.getApplicationContext().registerReceiver(mapapplicationcacheinvalidator, intentfilter);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MAPLog.w(MAPApplicationInformationQueryer.TAG, "Failed to register receiver", context);
            }
        }

        public void onReceive(Context context, Intent intent)
        {
            String _tmp = MAPApplicationInformationQueryer.TAG;
            String.format("Notified by action %s to invalidate app cache", new Object[] {
                intent.getAction()
            });
            MAPApplicationInformationQueryer.getInstance(context).invalidateCache();
        }


        public MAPApplicationCacheInvalidator()
        {
        }
    }


    private static final Comparator NEWEST_REMOTE_MAP_INFO_COMPARATOR = new Comparator() {

        public int compare(RemoteMapInfo remotemapinfo, RemoteMapInfo remotemapinfo1)
        {
            return RemoteMapInfo.compare(remotemapinfo, remotemapinfo1) * -1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((RemoteMapInfo)obj, (RemoteMapInfo)obj1);
        }

    };
    private static final String TAG = com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer.getName();
    private static MAPApplicationInformationQueryer sTheOneAndTheOnly;
    private boolean mCacheContainsPartialResults;
    private final ServiceWrappingContext mContext;
    private Map mPackageNameToAppInfo;
    private final TrustedPackageManager mTrustedPackageManager;

    MAPApplicationInformationQueryer(Context context)
    {
        this(context, new TrustedPackageManager(context));
    }

    MAPApplicationInformationQueryer(Context context, TrustedPackageManager trustedpackagemanager)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mTrustedPackageManager = trustedpackagemanager;
        mPackageNameToAppInfo = new HashMap();
        mCacheContainsPartialResults = true;
    }

    private Map getAppInfos()
    {
        this;
        JVM INSTR monitorenter ;
        if (mPackageNameToAppInfo != null && !mCacheContainsPartialResults) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        RemoteMapInfo remotemapinfo;
        if (!MAPApplicationCacheInvalidator.isRegistered())
        {
            String s = TAG;
            MAPApplicationCacheInvalidator.registerReceiver(mContext);
        }
        obj = new HashMap();
        if (!PlatformUtils.isIsolatedApplication(mContext))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s1 = mContext.getPackageName();
        remotemapinfo = populateCacheForSinglePackage(s1);
        if (remotemapinfo == null) goto _L4; else goto _L3
_L3:
        ((Map) (obj)).put(s1, remotemapinfo);
_L5:
        mPackageNameToAppInfo = ((Map) (obj));
        mCacheContainsPartialResults = false;
_L2:
        obj = mPackageNameToAppInfo;
        this;
        JVM INSTR monitorexit ;
        return ((Map) (obj));
_L4:
        ((Map) (obj)).put(s1, new RemoteMapInfo(mContext));
          goto _L5
        obj;
        throw obj;
        Iterator iterator = getMAPContentProviders().iterator();
        while (iterator.hasNext()) 
        {
            ProviderInfo providerinfo = (ProviderInfo)iterator.next();
            ((Map) (obj)).put(providerinfo.packageName, new RemoteMapInfo(mContext, providerinfo));
        }
          goto _L5
    }

    public static MAPApplicationInformationQueryer getInstance(Context context)
    {
        com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new MAPApplicationInformationQueryer(context);
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private List getMAPContentProviders()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mTrustedPackageManager.queryTrustedContentProviders().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ProviderInfo providerinfo = (ProviderInfo)iterator.next();
            String s = providerinfo.authority;
            if (s != null && s.startsWith("com.amazon.identity.auth.device.MapInfoProvider."))
            {
                arraylist.add(providerinfo);
            }
        } while (true);
        return arraylist;
    }

    private RemoteMapInfo populateCacheForSinglePackage(String s)
    {
        this;
        JVM INSTR monitorenter ;
        PackageInfo packageinfo;
        ProviderInfo aproviderinfo1[];
        packageinfo = mTrustedPackageManager.getPackageInfoForTrustedPackage(s, 8);
        aproviderinfo1 = packageinfo.providers;
        if (aproviderinfo1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        ProviderInfo aproviderinfo[];
        int j;
        aproviderinfo = packageinfo.providers;
        j = aproviderinfo.length;
        RemoteMapInfo remotemapinfo;
        Object obj;
        ProviderInfo providerinfo;
        String s1;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_164;
        }

        providerinfo = aproviderinfo[i];
        if (providerinfo == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        s1 = providerinfo.authority;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (!s1.startsWith("com.amazon.identity.auth.device.MapInfoProvider."))
        {
            break MISSING_BLOCK_LABEL_169;
        }
        remotemapinfo = new RemoteMapInfo(mContext, providerinfo);
        mPackageNameToAppInfo.put(s, remotemapinfo);
        s = remotemapinfo;
        continue; /* Loop/switch isn't completed */
        obj;
        MAPLog.w(TAG, "Tried to get MAP info for non-existant package", ((Throwable) (obj)));
        MetricsHelper.incrementCounter("MAPPackageNameNotFound", new String[] {
            s
        });
        break MISSING_BLOCK_LABEL_164;
        obj;
        MAPLog.w(TAG, "Tried to get MAP info for untrusted package", ((Throwable) (obj)));
        MetricsHelper.incrementCounter("MAPPackageIncorrectlySigned", new String[] {
            s
        });
        break MISSING_BLOCK_LABEL_164;
        s;
        throw s;
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Collection getAllMapApplication()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(getAppInfos().values());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public RemoteMapInfo getAppInfo(String s)
    {
        this;
        JVM INSTR monitorenter ;
        RemoteMapInfo remotemapinfo1 = (RemoteMapInfo)mPackageNameToAppInfo.get(s);
        RemoteMapInfo remotemapinfo;
        remotemapinfo = remotemapinfo1;
        if (remotemapinfo1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        remotemapinfo = remotemapinfo1;
        if (mCacheContainsPartialResults)
        {
            remotemapinfo = populateCacheForSinglePackage(s);
        }
        this;
        JVM INSTR monitorexit ;
        return remotemapinfo;
        s;
        throw s;
    }

    public String getAppOverriddenDSN(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = getAppInfo(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        s = s.getOverrideDSN();
        flag = TextUtils.isEmpty(s);
        if (flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        MAPLog.e(TAG, String.format("Unable to get device serial number for %s.", new Object[] {
            mContext.getPackageName()
        }));
        s = null;
        continue; /* Loop/switch isn't completed */
_L2:
        s = null;
        if (true) goto _L3; else goto _L4
_L4:
        s;
        throw s;
    }

    public RemoteMapInfo getLatestMapApp()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = getAppInfos();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((RemoteMapInfo) (obj1));
_L2:
        Object obj = null;
        Iterator iterator = ((Map) (obj1)).values().iterator();
_L6:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        obj1 = (RemoteMapInfo)iterator.next();
        if (((RemoteMapInfo) (obj1)).compareLatest(((RemoteMapInfo) (obj))) <= 0) goto _L6; else goto _L5
_L5:
        String s;
        s = TAG;
        s = ((RemoteMapInfo) (obj1)).getPackageName();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = ((RemoteMapInfo) (obj)).getPackageName();
_L7:
        String.format("%s is newer than %s", new Object[] {
            s, obj
        });
        obj = obj1;
          goto _L6
        obj = "<None>";
          goto _L7
        Exception exception;
        exception;
        throw exception;
          goto _L6
    }

    public List getSortedByLatestMapApplications()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Map map = getAppInfos();
        arraylist = new ArrayList();
        arraylist.addAll(map.values());
        Collections.sort(arraylist, NEWEST_REMOTE_MAP_INFO_COMPARATOR);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public void invalidateCache()
    {
        this;
        JVM INSTR monitorenter ;
        mPackageNameToAppInfo = new HashMap();
        mCacheContainsPartialResults = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


}
