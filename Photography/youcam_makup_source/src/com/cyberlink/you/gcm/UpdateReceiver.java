// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.gcm:
//            b

public class UpdateReceiver extends BroadcastReceiver
{

    public UpdateReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = intent.getAction();
        Log.i("UpdateReceiver", (new StringBuilder()).append("onReceive: ").append(s).toString());
        ULogUtility.b((new StringBuilder()).append("onReceive: ").append(s).toString(), "UpdateReceiver");
        if (!s.equals("android.intent.action.PACKAGE_REPLACED")) goto _L1; else goto _L3
_L3:
        intent = intent.getData().getSchemeSpecificPart();
        s = g.I().getPackageName();
        if (intent == null) goto _L1; else goto _L4
_L4:
        if (intent.isEmpty() || s == null) goto _L1; else goto _L5
_L5:
        if (s.isEmpty()) goto _L1; else goto _L6
_L6:
        Log.i("UpdateReceiver", (new StringBuilder()).append("PackageName: ").append(intent).append(" ").append(s).toString());
        ULogUtility.b((new StringBuilder()).append("PackageName: ").append(intent).append(" ").append(s).toString(), "UpdateReceiver");
        if (s.equals(intent))
        {
            b.a(context);
            return;
        }
          goto _L1
        context;
        context.printStackTrace();
        return;
    }
}
