// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class b
{

    private static final String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/b.getSimpleName();
    protected final String a;
    protected final JSONObject b;
    protected final com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus c;

    protected b()
    {
        a = null;
        b = null;
        c = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a;
    }

    protected b(HttpEntity httpentity)
    {
        a = EntityUtils.toString(httpentity);
        b = new JSONObject(a);
        httpentity = b.getString("status");
        if (httpentity == null)
        {
            c = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.b;
        } else
        {
            c = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.valueOf(httpentity.toUpperCase(Locale.US));
            if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
            {
                return;
            }
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus d()
    {
        return c;
    }

}
