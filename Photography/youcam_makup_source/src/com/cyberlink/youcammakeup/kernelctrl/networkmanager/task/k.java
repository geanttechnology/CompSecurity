// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.beautycircle.utility.AccountManager;
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
//            ax, m, bn, l

public class k extends ax
{

    private final NetworkManager a;
    private final l b;

    public k(NetworkManager networkmanager, l l1)
    {
        a = networkmanager;
        b = l1;
    }

    private HttpEntity b()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("lang", AccountManager.a()));
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.E()));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return a.G().execute(httppost).getEntity();
    }

    public void a()
    {
        m m1;
        m1 = new m(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = m1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            b.b(new bn(responsestatus, null));
            return;
        }
        try
        {
            b.a(m1);
            return;
        }
        catch (Exception exception)
        {
            b.b(new bn(null, exception));
        }
        return;
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }
}
