// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, a

public class bk
{

    protected final Collection a;
    private final NetworkManager b;

    public bk(NetworkManager networkmanager, Collection collection)
    {
        b = networkmanager;
        a = collection;
    }

    private HttpEntity d()
    {
        AndroidHttpClient androidhttpclient = b.G();
        b.H();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(b()));
        httppost.setEntity(new UrlEncodedFormEntity(c()));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus1;
        try
        {
            responsestatus = (new b(d())).d();
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

    protected String b()
    {
        return NetworkManager.j();
    }

    protected List c()
    {
        Long long1 = b.H();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("mid", String.valueOf(long1)));
        arraylist.add(new BasicNameValuePair("tids", com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.a.a(a)));
        return arraylist;
    }
}
