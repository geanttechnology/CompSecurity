// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.util.FwLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class EbayBroadcast
{
    public static interface SynchronousReceiver
    {

        public abstract void onReceive(Context context, Intent intent);
    }


    private static final String ACTION = "com.ebay.common.intent.action.EBAY_";
    public static final String ACTION_APPBACKGROUND = "com.ebay.common.intent.action.EBAY_APPBACKGROUND";
    public static final String ACTION_APPFOREGROUND = "com.ebay.common.intent.action.EBAY_APPFOREGROUND";
    public static final String ACTION_COUNTRY_CHANGED = "com.ebay.common.intent.action.EBAY_COUNTRY_CHANGED";
    public static final String ACTION_DCS_CHANGED = "com.ebay.common.intent.action.EBAY_DCS_CHANGED";
    public static final String ACTION_SITE_CHANGED = "com.ebay.common.intent.action.EBAY_SITE_CHANGED";
    public static final String ACTION_SYMBAN_UPDATE = "com.ebay.common.intent.action.EBAY_SYMBAN_UPDATE";
    public static final String ACTION_UI_INITIALIZED = "com.ebay.common.intent.action.EBAY_UI_INITIALIZED";
    public static final String EXTRA_IS_USER_SIGNED_IN = "com.ebay.common.content.EbayBroadcast.IS_USER_SIGNED_IN";
    public static final String EXTRA_NEW_COUNTRY = "com.ebay.common.content.EbayBroadcast.NEW_COUNTRY";
    public static final String EXTRA_NEW_SITE = "com.ebay.common.content.EbayBroadcast.NEW_SITE";
    public static final String EXTRA_SENDING_PROCESS_ID = "com.ebay.common.content.EbayBroadcast.SENDING_PROCESS_ID";
    public static final String PERMISSION = ".permission.EBAY_USER_CONFIG";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EbayBroadcast", 3, "Log eBay broadcast events");
    private static final ArrayList receivers = new ArrayList();

    private EbayBroadcast()
    {
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastreceiver, String s)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Registering ").append(broadcastreceiver.getClass().getCanonicalName()).append(" for ").append(s).toString());
        }
        return context.registerReceiver(broadcastreceiver, new IntentFilter(s), (new StringBuilder()).append(context.getPackageName()).append(".permission.EBAY_USER_CONFIG").toString(), null);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastreceiver, String s, int i)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Registering ").append(broadcastreceiver.getClass().getCanonicalName()).append(" for ").append(s).toString());
        }
        s = new IntentFilter(s);
        s.setPriority(i);
        return context.registerReceiver(broadcastreceiver, s, (new StringBuilder()).append(context.getPackageName()).append(".permission.EBAY_USER_CONFIG").toString(), null);
    }

    public static void registerSynchronousReceiver(SynchronousReceiver synchronousreceiver)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Registering ").append(synchronousreceiver.getClass().getCanonicalName()).append(" for in-process synchronous delivery").toString());
        }
        ArrayList arraylist = receivers;
        arraylist;
        JVM INSTR monitorenter ;
        int i = receivers.size() - 1;
_L2:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        SynchronousReceiver synchronousreceiver1 = (SynchronousReceiver)((WeakReference)receivers.get(i)).get();
        if (synchronousreceiver1 != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        receivers.remove(i);
        break MISSING_BLOCK_LABEL_127;
        if (synchronousreceiver1 != synchronousreceiver)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        receivers.add(new WeakReference(synchronousreceiver));
        arraylist;
        JVM INSTR monitorexit ;
        return;
        synchronousreceiver;
        arraylist;
        JVM INSTR monitorexit ;
        throw synchronousreceiver;
        i--;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final void sendAppBackgroundBroadcast(Context context)
    {
        sendBroadcast(context, new Intent("com.ebay.common.intent.action.EBAY_APPBACKGROUND"));
    }

    public static final void sendAppForegroundBroadcast(Context context)
    {
        sendBroadcast(context, new Intent("com.ebay.common.intent.action.EBAY_APPFOREGROUND"));
    }

    public static final void sendBroadcast(Context context, Intent intent)
    {
        intent.putExtra("com.ebay.common.content.EbayBroadcast.SENDING_PROCESS_ID", Process.myPid());
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Sending synchronous handlers for ").append(intent.getAction()).toString());
        }
        sendSynchronous(context, intent);
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Sending broadcast ").append(intent.getAction()).toString());
        }
        context.sendOrderedBroadcast(intent, (new StringBuilder()).append(context.getPackageName()).append(".permission.EBAY_USER_CONFIG").toString());
    }

    public static final void sendCountryChangedBroadcast(Context context, EbayCountry ebaycountry)
    {
        Intent intent = new Intent("com.ebay.common.intent.action.EBAY_COUNTRY_CHANGED");
        if (ebaycountry != null)
        {
            intent.putExtra("com.ebay.common.content.EbayBroadcast.NEW_COUNTRY", ebaycountry);
        }
        sendBroadcast(context, intent);
    }

    public static final void sendDcsChangedBroadcast(Context context)
    {
        sendBroadcast(context, new Intent("com.ebay.common.intent.action.EBAY_DCS_CHANGED"));
    }

    public static final void sendSiteChangedBroadcast(Context context, EbaySite ebaysite)
    {
        Intent intent = new Intent("com.ebay.common.intent.action.EBAY_SITE_CHANGED");
        ebaysite = toCompatibleSite(ebaysite);
        if (ebaysite != null)
        {
            intent.putExtra("com.ebay.common.content.EbayBroadcast.NEW_SITE", ebaysite);
        }
        sendBroadcast(context, intent);
    }

    public static final void sendSymbanUpdateBroadcast(Context context)
    {
        sendBroadcast(context, new Intent("com.ebay.common.intent.action.EBAY_SYMBAN_UPDATE"));
    }

    private static void sendSynchronous(Context context, Intent intent)
    {
        int i;
label0:
        {
            synchronized (receivers)
            {
                if (!receivers.isEmpty())
                {
                    break label0;
                }
            }
            return;
        }
        i = 0;
        ArrayList arraylist1 = new ArrayList(receivers.size());
_L3:
        if (i >= receivers.size()) goto _L2; else goto _L1
_L1:
        SynchronousReceiver synchronousreceiver = (SynchronousReceiver)((WeakReference)receivers.get(i)).get();
        if (synchronousreceiver == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        arraylist1.add(synchronousreceiver);
        i++;
          goto _L3
        receivers.remove(i);
          goto _L3
        context;
_L5:
        arraylist;
        JVM INSTR monitorexit ;
        throw context;
_L2:
        arraylist;
        JVM INSTR monitorexit ;
        for (Iterator iterator = arraylist1.iterator(); iterator.hasNext(); ((SynchronousReceiver)iterator.next()).onReceive(context, new Intent(intent))) { }
        return;
        context;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static final com.ebay.common.model.EbaySite toCompatibleSite(EbaySite ebaysite)
    {
        com.ebay.common.model.EbaySite ebaysite1 = null;
        if (ebaysite != null)
        {
            try
            {
                ebaysite1 = com.ebay.common.model.EbaySite.getSiteFromId(ebaysite.idInt);
            }
            // Misplaced declaration of an exception variable
            catch (EbaySite ebaysite)
            {
                return null;
            }
        }
        return ebaysite1;
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastreceiver)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Unregistering ").append(broadcastreceiver.getClass().getCanonicalName()).toString());
        }
        context.unregisterReceiver(broadcastreceiver);
    }

    public static void unregisterSynchronousReceiver(SynchronousReceiver synchronousreceiver)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Unregistering ").append(synchronousreceiver.getClass().getCanonicalName()).append(" for in-process synchronous delivery").toString());
        }
        ArrayList arraylist = receivers;
        arraylist;
        JVM INSTR monitorenter ;
        int i = receivers.size() - 1;
_L2:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        SynchronousReceiver synchronousreceiver1 = (SynchronousReceiver)((WeakReference)receivers.get(i)).get();
        if (synchronousreceiver1 != null && synchronousreceiver1 != synchronousreceiver)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        receivers.remove(i);
        break MISSING_BLOCK_LABEL_109;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        synchronousreceiver;
        arraylist;
        JVM INSTR monitorexit ;
        throw synchronousreceiver;
        i--;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
