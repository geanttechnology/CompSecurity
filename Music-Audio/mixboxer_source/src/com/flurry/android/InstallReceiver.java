// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            cc, cy, fl, ay

public final class InstallReceiver extends BroadcastReceiver
{

    private final Handler ar;
    private File iz;

    public InstallReceiver()
    {
        iz = null;
        HandlerThread handlerthread = new HandlerThread("InstallReceiver");
        handlerthread.start();
        ar = new Handler(handlerthread.getLooper());
    }

    private void L(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new cc(this, s);
        ar.post(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    static File a(InstallReceiver installreceiver)
    {
        return installreceiver.iz;
    }

    private static String b(File file)
    {
        Throwable throwable;
        Object obj1 = null;
        Object obj;
        byte abyte0[];
        FileInputStream fileinputstream;
        int i;
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            file = null;
            fileinputstream = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = null;
        }
_L3:
        obj = fileinputstream;
        file = new StringBuffer();
        obj = fileinputstream;
        abyte0 = new byte[1024];
_L2:
        obj = fileinputstream;
        i = fileinputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = fileinputstream;
        file.append(new String(abyte0, 0, i));
        if (true) goto _L2; else goto _L1
        throwable;
_L8:
        obj = fileinputstream;
        cy.b("InstallReceiver", "Error when loading persistent file", throwable);
        fl.a(fileinputstream);
_L4:
        obj = obj1;
        if (file != null)
        {
            obj = file.toString();
        }
        return ((String) (obj));
_L1:
        fl.a(fileinputstream);
        if (true) goto _L4; else goto _L3
_L6:
        fl.a(((java.io.Closeable) (obj)));
        throw file;
        file;
        if (true) goto _L6; else goto _L5
_L5:
        throwable;
        file = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static String c(File file)
    {
        return b(file);
    }

    static Map h(String s)
    {
        HashMap hashmap = new HashMap();
        String as[] = s.split("&");
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String as1[] = as[i].split("=");
            if (as1.length != 2)
            {
                cy.c("InstallReceiver", (new StringBuilder()).append("Invalid referrer Element: ").append(as[i]).append(" in referrer tag ").append(s).toString());
            } else
            {
                String s1 = URLDecoder.decode(as1[0]);
                String s2 = URLDecoder.decode(as1[1]);
                if (hashmap.get(s1) == null)
                {
                    hashmap.put(s1, new ArrayList());
                }
                ((List)hashmap.get(s1)).add(s2);
            }
            i++;
        }
        s = new StringBuilder();
        if (hashmap.get("utm_source") == null)
        {
            s.append("Campaign Source is missing.\n");
        }
        if (hashmap.get("utm_medium") == null)
        {
            s.append("Campaign Medium is missing.\n");
        }
        if (hashmap.get("utm_campaign") == null)
        {
            s.append("Campaign Name is missing.\n");
        }
        if (s.length() > 0)
        {
            Log.w("Detected missing referrer keys", s.toString());
        }
        return hashmap;
    }

    public final void onReceive(Context context, Intent intent)
    {
        ay.Y();
        cy.e("InstallReceiver", (new StringBuilder()).append("Received an Install nofication of ").append(intent.getAction()).toString());
        iz = context.getFileStreamPath(".flurryinstallreceiver.");
        cy.e("InstallReceiver", (new StringBuilder()).append("fInstallReceiverFile is ").append(iz).toString());
        String s = intent.getExtras().getString("referrer");
        cy.e("InstallReceiver", (new StringBuilder()).append("Received an Install referrer of ").append(s).toString());
        if (s == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            cy.e("InstallReceiver", "referrer is null");
            return;
        }
        context = s;
        if (!s.contains("="))
        {
            cy.e("InstallReceiver", (new StringBuilder()).append("referrer is before decoding: ").append(s).toString());
            context = URLDecoder.decode(s);
            cy.e("InstallReceiver", (new StringBuilder()).append("referrer is: ").append(context).toString());
        }
        L(context);
    }
}
