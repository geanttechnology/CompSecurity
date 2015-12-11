// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingsNamespace, SettingsContract, SettingsMap

final class SettingsCacheUpdater
{

    private static final String TAG = com/amazon/dcp/settings/SettingsCacheUpdater.getName();
    private final List mListeners = new ArrayList();
    private final Object mListenersLock[] = new Object[0];
    private volatile SettingsMap mSettingsMap;
    private final Object mSyncLock[] = new Object[0];

    public SettingsCacheUpdater()
    {
        mSettingsMap = (new SettingsMap.Builder()).build();
    }

    private static int addSettings(ContentProviderClient contentproviderclient, Context context, SettingsNamespace settingsnamespace, SettingsMap.Builder builder)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[];

            static 
            {
                $SwitchMap$com$amazon$dcp$settings$SettingsNamespace = new int[SettingsNamespace.values().length];
                try
                {
                    $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[SettingsNamespace.AppLocal.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[SettingsNamespace.DeviceGlobal.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.dcp.settings.SettingsNamespace[settingsnamespace.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 107;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException();
_L2:
        String s = SettingsContract.getAppLocalNamespace(context);
_L5:
        Object obj;
        int i;
        int j;
        int k;
        obj = null;
        context = null;
        k = 0;
        i = 0;
        j = k;
        contentproviderclient = contentproviderclient.query(Uri.withAppendedPath(SettingsContract.VALUES_CONTENT_URI, s), new String[] {
            "key", "value"
        }, null, null, null);
        if (contentproviderclient == null)
        {
            if (contentproviderclient != null)
            {
                contentproviderclient.close();
            }
            return 0;
        }
        break; /* Loop/switch isn't completed */
_L3:
        s = "-device-";
        if (true) goto _L5; else goto _L4
_L4:
        j = k;
        context = contentproviderclient;
        obj = contentproviderclient;
        int l = contentproviderclient.getColumnIndex("key");
        j = k;
        context = contentproviderclient;
        obj = contentproviderclient;
        k = contentproviderclient.getColumnIndex("value");
_L7:
        j = i;
        context = contentproviderclient;
        obj = contentproviderclient;
        if (!contentproviderclient.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        context = contentproviderclient;
        obj = contentproviderclient;
        builder.setValue(settingsnamespace, contentproviderclient.getString(l), contentproviderclient.getString(k));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        k = i;
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
            k = i;
        }
_L9:
        return k;
        contentproviderclient;
        obj = context;
        Log.e(TAG, (new StringBuilder()).append("Remote Exception occurred when querying settings content provider because ").append(contentproviderclient.getMessage()).toString(), contentproviderclient);
        k = j;
        if (context != null)
        {
            context.close();
            k = j;
        }
        if (true) goto _L9; else goto _L8
_L8:
        contentproviderclient;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw contentproviderclient;
    }

    private void updateMap(SettingsMap settingsmap)
    {
        Handler handler;
        mSettingsMap = settingsmap;
        handler = new Handler(Looper.getMainLooper());
        settingsmap = ((SettingsMap) (mListenersLock));
        settingsmap;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); handler.post(new Runnable() {

        final SettingsCacheUpdater this$0;
        final SettingsCache.IListener val$listener;

        public void run()
        {
            listener.onCacheUpdated();
        }

            
            {
                this$0 = SettingsCacheUpdater.this;
                listener = ilistener;
                super();
            }
    })) { }
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        settingsmap;
        JVM INSTR monitorexit ;
        throw exception;
        settingsmap;
        JVM INSTR monitorexit ;
    }

    public void addListener(SettingsCache.IListener ilistener)
    {
        synchronized (mListenersLock)
        {
            mListeners.add(ilistener);
        }
        return;
        ilistener;
        aobj;
        JVM INSTR monitorexit ;
        throw ilistener;
    }

    public SettingsMap getMap()
    {
        return mSettingsMap;
    }

    public void updateFromContentProvider(Context context)
    {
        Object aobj[] = mSyncLock;
        aobj;
        JVM INSTR monitorenter ;
        ContentProviderClient contentproviderclient = null;
        ContentProviderClient contentproviderclient1 = context.getContentResolver().acquireContentProviderClient("com.amazon.dcp.settings");
        if (contentproviderclient1 != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        contentproviderclient = contentproviderclient1;
        Log.e(TAG, "Content provider for Device Settings not found, sync unable to start");
        if (contentproviderclient1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        contentproviderclient1.release();
        aobj;
        JVM INSTR monitorexit ;
        return;
        contentproviderclient = contentproviderclient1;
        Log.i(TAG, "Starting sync with content provider.");
        contentproviderclient = contentproviderclient1;
        SettingsMap.Builder builder = new SettingsMap.Builder();
        contentproviderclient = contentproviderclient1;
        int i = addSettings(contentproviderclient1, context, SettingsNamespace.AppLocal, builder);
        contentproviderclient = contentproviderclient1;
        int j = addSettings(contentproviderclient1, context, SettingsNamespace.DeviceGlobal, builder);
        contentproviderclient = contentproviderclient1;
        updateMap(builder.build());
        contentproviderclient = contentproviderclient1;
        Log.i(TAG, String.format("Sync with content provider complete. Values processed: %d", new Object[] {
            Integer.valueOf(0 + i + j)
        }));
        if (contentproviderclient1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        contentproviderclient1.release();
        aobj;
        JVM INSTR monitorexit ;
        return;
        context;
        aobj;
        JVM INSTR monitorexit ;
        throw context;
        context;
        if (contentproviderclient == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        contentproviderclient.release();
        throw context;
    }

}
