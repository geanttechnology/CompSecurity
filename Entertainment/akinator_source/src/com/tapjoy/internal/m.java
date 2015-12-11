// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class m extends BroadcastReceiver
{

    public m()
    {
    }

    protected final int a(Context context, Intent intent)
    {
        int i;
        i = 0;
        Object obj = new ComponentName(context, getClass());
        Iterator iterator;
        String s;
        Object obj2;
        Intent intent1;
        try
        {
            obj = context.getPackageManager().getReceiverInfo(((ComponentName) (obj)), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        iterator = ((Bundle) (obj)).keySet().iterator();
        i = 0;
_L4:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((Bundle) (obj)).getString((String)iterator.next());
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = Class.forName(s).newInstance();
        if (!(obj2 instanceof BroadcastReceiver))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = (BroadcastReceiver)obj2;
        intent1 = new Intent(intent);
        intent1.setComponent(new ComponentName(context, s));
        ((BroadcastReceiver) (obj2)).onReceive(context, intent1);
        i++;
        continue; /* Loop/switch isn't completed */
        context;
_L2:
        return i;
        Object obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        return i;
    }

    public void onReceive(Context context, Intent intent)
    {
        a(context, intent);
    }
}
