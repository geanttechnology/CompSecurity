// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, b, bn

public class bm extends ax
{

    private String a;
    private NetworkManager b;
    private long c;

    public bm(NetworkManager networkmanager, long l)
    {
        a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bm.getName();
        b = networkmanager;
        c = l;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = b.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.n()));
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("filmIds", String.valueOf(c)));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus1;
        try
        {
            responsestatus = (new b(b())).d();
            responsestatus1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a;
        }
        catch (Exception exception1)
        {
            return;
        }
        finally
        {
            throw exception;
        }
        if (responsestatus == responsestatus1);
    }

    public void a(bn bn)
    {
    }
}
