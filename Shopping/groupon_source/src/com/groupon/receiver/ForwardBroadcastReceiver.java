// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;
import roboguice.util.Ln;

public class ForwardBroadcastReceiver extends BroadcastReceiver
{

    public ForwardBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Ln.d("ForwardBroadcastReceiver: Received intent", new Object[0]);
        try
        {
            Bundle bundle = context.getPackageManager().getReceiverInfo(new ComponentName(context, com/groupon/receiver/ForwardBroadcastReceiver.getName()), 128).metaData;
            String s;
            for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); ((BroadcastReceiver)Class.forName(s).newInstance()).onReceive(context, intent))
            {
                s = bundle.getString((String)iterator.next());
                Ln.d("ForwardBroadcastReceiver: Forward broadcast to %s", new Object[] {
                    s
                });
            }

        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Ln.d((new StringBuilder()).append("ForwardBroadcastReceiver: Forward failed: ").append(context.getMessage()).toString(), new Object[0]);
        }
    }
}
