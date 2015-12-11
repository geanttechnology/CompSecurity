// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import roboguice.util.Ln;

public class GCReceiver extends BroadcastReceiver
{

    public GCReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            Ln.d("Taking out the trash", new Object[0]);
            System.gc();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Ln.d("Got an exception garbage collecting: %s", new Object[] {
                context.getMessage()
            });
        }
    }
}
