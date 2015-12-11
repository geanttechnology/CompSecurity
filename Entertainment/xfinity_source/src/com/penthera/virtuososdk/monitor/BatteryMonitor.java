// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.util.Iterator;
import java.util.Vector;

public final class BatteryMonitor extends BroadcastReceiver
{
    private static final class Event extends Enum
    {

        public static final Event CONNECTED;
        public static final Event DISCONNECTED;
        private static final Event ENUM$VALUES[];
        public static final Event LEVEL_CHANGED;
        public static final Event NONE;

        public static Event valueOf(String s)
        {
            return (Event)Enum.valueOf(com/penthera/virtuososdk/monitor/BatteryMonitor$Event, s);
        }

        public static Event[] values()
        {
            Event aevent[] = ENUM$VALUES;
            int i = aevent.length;
            Event aevent1[] = new Event[i];
            System.arraycopy(aevent, 0, aevent1, 0, i);
            return aevent1;
        }

        static 
        {
            NONE = new Event("NONE", 0);
            CONNECTED = new Event("CONNECTED", 1);
            DISCONNECTED = new Event("DISCONNECTED", 2);
            LEVEL_CHANGED = new Event("LEVEL_CHANGED", 3);
            ENUM$VALUES = (new Event[] {
                NONE, CONNECTED, DISCONNECTED, LEVEL_CHANGED
            });
        }

        private Event(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface IBatteryObserver
    {

        public abstract void onBatteryLevelChanged(int i);

        public abstract void onPowerConnected();

        public abstract void onPowerDisconnected();
    }


    public static int BATTERY_LEVEL_LOW = 75;
    public static int BATTERY_LEVEL_VERY_LOW = 20;
    private static BatteryMonitor iInstance = null;
    private final String LOG_TAG = com/penthera/virtuososdk/monitor/BatteryMonitor.getName();
    private boolean iBatteryCharging;
    private boolean iBatteryConnected;
    private int iBatteryLevel;
    private int iBatteryPluggedState;
    private int iBatteryStatus;
    Event iEvent;
    private Vector iObservers;
    private int iPreviousRawLevel;
    boolean isInit;

    private BatteryMonitor()
    {
        iBatteryCharging = false;
        iBatteryLevel = -1;
        iBatteryStatus = 1;
        iBatteryPluggedState = 0;
        iBatteryConnected = false;
        iPreviousRawLevel = -1;
        iObservers = null;
        iEvent = Event.NONE;
        isInit = false;
        iObservers = new Vector();
    }

    public static BatteryMonitor getInstance()
    {
        com/penthera/virtuososdk/monitor/BatteryMonitor;
        JVM INSTR monitorenter ;
        BatteryMonitor batterymonitor = null;
        if (iInstance != null)
        {
            batterymonitor = iInstance;
        }
        BatteryMonitor batterymonitor1;
        batterymonitor1 = batterymonitor;
        if (batterymonitor != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        batterymonitor1 = new BatteryMonitor();
        iInstance = batterymonitor1;
        com/penthera/virtuososdk/monitor/BatteryMonitor;
        JVM INSTR monitorexit ;
        return batterymonitor1;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyObservers(Event event)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = iObservers.iterator();
_L2:
        boolean flag = iterator.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        IBatteryObserver ibatteryobserver = (IBatteryObserver)iterator.next();
        if (ibatteryobserver == null) goto _L2; else goto _L1
_L1:
        if (event != Event.CONNECTED)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        ibatteryobserver.onPowerConnected();
          goto _L2
        event;
        throw event;
label0:
        {
            if (event != Event.DISCONNECTED)
            {
                break label0;
            }
            ibatteryobserver.onPowerDisconnected();
        }
          goto _L2
label1:
        {
            if (event != Event.LEVEL_CHANGED)
            {
                break label1;
            }
            ibatteryobserver.onBatteryLevelChanged(iBatteryLevel);
        }
          goto _L2
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("notifyObservers(): Unhandled event: ")).append(event).toString());
          goto _L2
    }

    private void registerReceivers()
    {
        Context context = CommonUtil.getApplicationContext();
        context.registerReceiver(this, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private void updateInternalState()
    {
        boolean flag1 = false;
        boolean flag = false;
        switch (iBatteryStatus)
        {
        default:
            return;

        case 2: // '\002'
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Handling BATTERY_STATUS_CHARGING");
            iBatteryCharging = true;
            return;

        case 3: // '\003'
        case 4: // '\004'
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Handling BATTERY_STATUS_NOT_CHARGING and BATTERY_STATUS_DISCHARGING");
            if (iBatteryPluggedState == 1 || iBatteryPluggedState == 2)
            {
                flag = true;
            }
            iBatteryCharging = flag;
            return;

        case 1: // '\001'
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Handling BATTERY_STATUS_UNKNOWN");
            iBatteryCharging = false;
            iBatteryLevel = -1;
            return;

        case 5: // '\005'
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Handling BATTERY_STATUS_FULL");
            break;
        }
        if (iBatteryPluggedState != 1 && iBatteryPluggedState != 2)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        iBatteryCharging = flag;
        iBatteryLevel = 100;
    }

    public void addObserver(IBatteryObserver ibatteryobserver)
    {
        this;
        JVM INSTR monitorenter ;
        if (iObservers.size() == 0)
        {
            registerReceivers();
        }
        if (ibatteryobserver == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (!iObservers.contains(ibatteryobserver))
        {
            iObservers.add(ibatteryobserver);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ibatteryobserver;
        throw ibatteryobserver;
    }

    public int getLevel()
    {
        return iBatteryLevel;
    }

    public boolean isCharging()
    {
        return iBatteryCharging;
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        context = intent.getAction();
        if (context != null) goto _L2; else goto _L1
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "onReceive(): null action");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i;
        if (!context.equals("android.intent.action.BATTERY_CHANGED"))
        {
            break MISSING_BLOCK_LABEL_307;
        }
        i = intent.getIntExtra("level", -1);
        iBatteryPluggedState = intent.getIntExtra("plugged", 0);
        int j;
        if (iBatteryPluggedState <= 0)
        {
            flag = false;
        }
        if (i == iPreviousRawLevel && flag == iBatteryCharging) goto _L4; else goto _L3
_L3:
        iPreviousRawLevel = i;
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("+ Battery info level (")).append(iBatteryLevel).append(") status (").append(iBatteryStatus).append(") plugged (").append(iBatteryPluggedState).append(")").toString());
        isInit = true;
        j = intent.getIntExtra("scale", -1);
        iBatteryStatus = intent.getIntExtra("status", 1);
        intent.getIntExtra("health", -1);
        iBatteryLevel = -1;
        if (i < 0 || j <= 0)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        iBatteryLevel = (i * 100) / j;
        updateInternalState();
        notifyObservers(Event.LEVEL_CHANGED);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast("virtuoso.intent.action.BATTERY_CHANGE");
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("- Battery info charging (")).append(iBatteryCharging).append(") level (").append(iBatteryLevel).append(") status (").append(iBatteryStatus).append(") plugged (").append(iBatteryPluggedState).append(")").toString());
          goto _L4
        context;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Exception in battery monitor -- ignoring: ", context);
          goto _L4
        context;
        throw context;
        if (!context.equals("android.intent.action.ACTION_POWER_CONNECTED")) goto _L6; else goto _L5
_L5:
        if (!iBatteryConnected)
        {
            iBatteryConnected = true;
            notifyObservers(Event.CONNECTED);
        }
          goto _L4
_L6:
        if (!context.equals("android.intent.action.ACTION_POWER_DISCONNECTED") || !iBatteryConnected) goto _L4; else goto _L7
_L7:
        iBatteryConnected = false;
        notifyObservers(Event.DISCONNECTED);
          goto _L4
    }

}
