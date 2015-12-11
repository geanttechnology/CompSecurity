// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class PendingIntentWrapper
{
    public static final class PendingIntentType extends Enum
    {

        private static final PendingIntentType $VALUES[];
        public static final PendingIntentType Activity;
        public static final PendingIntentType Broadcast;
        public static final PendingIntentType Service;

        public static PendingIntentType valueOf(String s)
        {
            return (PendingIntentType)Enum.valueOf(com/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType, s);
        }

        public static PendingIntentType[] values()
        {
            return (PendingIntentType[])$VALUES.clone();
        }

        static 
        {
            Broadcast = new PendingIntentType("Broadcast", 0);
            Service = new PendingIntentType("Service", 1);
            Activity = new PendingIntentType("Activity", 2);
            $VALUES = (new PendingIntentType[] {
                Broadcast, Service, Activity
            });
        }

        private PendingIntentType(String s, int i)
        {
            super(s, i);
        }
    }


    public final Intent intent;
    public final PendingIntent pendingIntent;
    public final PendingIntentType pendingIntentType;

    private PendingIntentWrapper(PendingIntent pendingintent, PendingIntentType pendingintenttype, Intent intent1)
    {
        pendingIntent = pendingintent;
        pendingIntentType = pendingintenttype;
        intent = intent1;
    }

    private static PendingIntentWrapper constructWrapper(PendingIntent pendingintent, PendingIntentType pendingintenttype, Intent intent1)
    {
        if (pendingintent == null)
        {
            return null;
        } else
        {
            return new PendingIntentWrapper(pendingintent, pendingintenttype, intent1);
        }
    }

    public static PendingIntentWrapper getActivity(Context context, int i, Intent intent1, int j)
    {
        return constructWrapper(PendingIntent.getActivity(context, i, intent1, j), PendingIntentType.Activity, intent1);
    }

    public static PendingIntentWrapper getBroadcast(Context context, int i, Intent intent1, int j)
    {
        return constructWrapper(PendingIntent.getBroadcast(context, i, intent1, j), PendingIntentType.Broadcast, intent1);
    }

    public static PendingIntentWrapper getService(Context context, int i, Intent intent1, int j)
    {
        return constructWrapper(PendingIntent.getService(context, i, intent1, j), PendingIntentType.Service, intent1);
    }
}
