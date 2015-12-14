// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import com.aviary.android.feather.common.AviaryIntent;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.ThrowableUtils;
import com.aviary.android.feather.receipt.ReceiptManager;
import it.sephiroth.android.library.ab.AB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

public class MonitoredActivity extends Activity
{
    public static class LifeCycleAdapter
        implements LifeCycleListener
    {

        public void onActivityCreated(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityDestroyed(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityPaused(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityResumed(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityStarted(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityStopped(MonitoredActivity monitoredactivity)
        {
        }

        public LifeCycleAdapter()
        {
        }
    }

    public static interface LifeCycleListener
    {

        public abstract void onActivityCreated(MonitoredActivity monitoredactivity);

        public abstract void onActivityDestroyed(MonitoredActivity monitoredactivity);

        public abstract void onActivityPaused(MonitoredActivity monitoredactivity);

        public abstract void onActivityResumed(MonitoredActivity monitoredactivity);

        public abstract void onActivityStarted(MonitoredActivity monitoredactivity);

        public abstract void onActivityStopped(MonitoredActivity monitoredactivity);
    }


    private static final String ACTION_KILL = "aviary.intent.action.KILL";
    private static final String LOG_TAG = "MonitoredActivity";
    private BroadcastReceiver mBroadcastReceiver;
    private final ArrayList mListeners = new ArrayList();
    protected AviaryTracker mTracker;

    public MonitoredActivity()
    {
    }

    private AlertDialog generateAlertDialog(Bundle bundle)
    {
        Log.i("MonitoredActivity", "generateAlertDialog");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s1;
        java.io.Serializable serializable;
        s1 = bundle.getString("android.intent.extra.TITLE");
        serializable = bundle.getSerializable("EXTRA_EXCEPTIONS");
        if (s1 == null || !bundle.containsKey("EXTRA_EXCEPTIONS") && !bundle.containsKey("android.intent.extra.TEXT")) goto _L1; else goto _L3
_L3:
        Object obj = null;
        if (!bundle.containsKey("EXTRA_EXCEPTIONS")) goto _L5; else goto _L4
_L4:
        String s;
        s = obj;
        if (serializable != null)
        {
            s = obj;
            if (serializable instanceof ArrayList)
            {
                s = ThrowableUtils.getLocalizedMessage((Collection)serializable, "\n\n");
            }
        }
_L7:
        bundle = new android.app.AlertDialog.Builder(this);
        bundle.setTitle(s1);
        bundle.setIcon(0x1080027);
        if (s != null)
        {
            bundle.setMessage(s);
        }
        bundle.setPositiveButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

            final MonitoredActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MonitoredActivity.this;
                super();
            }
        });
        return bundle.create();
_L5:
        s = obj;
        if (bundle.containsKey("android.intent.extra.TEXT"))
        {
            s = bundle.getString("android.intent.extra.TEXT");
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void initializeBroadcastReceivers()
    {
        IntentFilter intentfilter = new IntentFilter("aviary.intent.action.ALERT");
        if (!PackageManagerUtils.isStandalone(this))
        {
            intentfilter.addAction("aviary.intent.action.KILL");
        }
        mBroadcastReceiver = new BroadcastReceiver() {

            final MonitoredActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                Log.i("MonitoredActivity", (new StringBuilder()).append("onReceive: ").append(intent).toString());
                if (intent != null && context != null)
                {
                    context = intent.getAction();
                    if ("aviary.intent.action.KILL".equals(context))
                    {
                        onKill();
                    } else
                    if ("aviary.intent.action.ALERT".equals(context))
                    {
                        onAlertMessageReceived(intent);
                        return;
                    }
                }
            }

            
            {
                this$0 = MonitoredActivity.this;
                super();
            }
        };
        registerReceiver(mBroadcastReceiver, intentfilter);
    }

    private void initializeCDS()
    {
        Intent intent = getIntent();
        String s = null;
        Object obj = null;
        if (intent != null)
        {
            s = intent.getStringExtra("extra-api-key-secret");
            obj = intent.getStringExtra("extra-billing-public-key");
        }
        obj = startService(AviaryIntent.createCdsInitIntent(getBaseContext(), s, ((String) (obj))));
        if (obj == null)
        {
            LoggerFactory.printDeveloperError("'AviaryCdsService' not found, did you forget to add to your AndroidManifest.xml file?");
        }
        Assert.assertNotNull(obj);
    }

    private void lazyInitialize()
    {
        Thread thread = new Thread(new Runnable() {

            final MonitoredActivity this$0;

            public void run()
            {
                initializeBroadcastReceivers();
                initializeCDS();
                ReceiptManager receiptmanager = ReceiptManager.getInstance(getApplicationContext());
                receiptmanager.open();
                receiptmanager.upload();
            }

            
            {
                this$0 = MonitoredActivity.this;
                super();
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    private void onAlertMessageReceived(Intent intent)
    {
        Log.i("MonitoredActivity", (new StringBuilder()).append("onAlertMessage: ").append(intent).toString());
        if (intent != null)
        {
            String s = intent.getAction();
            intent = intent.getExtras();
            if (intent != null && "aviary.intent.action.ALERT".equals(s))
            {
                intent = generateAlertDialog(intent);
                if (intent != null)
                {
                    intent.show();
                }
            }
        }
    }

    private void onKill()
    {
        Log.w("MonitoredActivity", (new StringBuilder()).append("onKill: ").append(getPackageName()).toString());
        (new android.app.AlertDialog.Builder(this)).setTitle("Removed").setMessage("We're sorry but the application has been banned. Please contact the developer.").setCancelable(false).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final MonitoredActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = MonitoredActivity.this;
                super();
            }
        }).show();
    }

    public void addLifeCycleListener(LifeCycleListener lifecyclelistener)
    {
        if (mListeners.contains(lifecyclelistener))
        {
            return;
        } else
        {
            mListeners.add(lifecyclelistener);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (bundle = mListeners.iterator(); bundle.hasNext(); ((LifeCycleListener)bundle.next()).onActivityCreated(this)) { }
        bundle = AB.getInstance(this).getGroup();
        mTracker = AviaryTracker.getInstance(this);
        mTracker.putCustomAttribute("ab-group", bundle.name());
        mTracker.open();
        mTracker.upload();
        lazyInitialize();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((LifeCycleListener)iterator.next()).onActivityDestroyed(this)) { }
        if (mBroadcastReceiver != null)
        {
            unregisterReceiver(mBroadcastReceiver);
            mBroadcastReceiver = null;
        }
    }

    protected void onPause()
    {
        mTracker.close();
        mTracker.upload();
        ReceiptManager.getInstance(this).close();
        ReceiptManager.getInstance(this).upload();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mTracker.open();
        ReceiptManager.getInstance(this).open();
    }

    protected void onStart()
    {
        super.onStart();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((LifeCycleListener)iterator.next()).onActivityStarted(this)) { }
    }

    protected void onStop()
    {
        super.onStop();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((LifeCycleListener)iterator.next()).onActivityStopped(this)) { }
    }

    public void removeLifeCycleListener(LifeCycleListener lifecyclelistener)
    {
        mListeners.remove(lifecyclelistener);
    }




}
