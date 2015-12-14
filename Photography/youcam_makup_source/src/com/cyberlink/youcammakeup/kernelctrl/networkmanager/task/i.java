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
//            ax, h, bn, j

public class i extends ax
{

    private final NetworkManager a;
    private final j b;
    private final String c[];

    public i(NetworkManager networkmanager, j j1, String as[])
    {
        a = networkmanager;
        b = j1;
        c = as;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.t()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        String as[] = c;
        int l = as.length;
        for (int k = 0; k < l; k++)
        {
            arraylist.add(new BasicNameValuePair("groups", as[k]));
        }

        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        h h1;
        h1 = new h(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = h1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            b.b(new bn(responsestatus, null));
            return;
        }
        b.a(h1);
        return;
        Object obj;
        obj;
        b.b(new bn(null, ((Exception) (obj))));
        return;
        obj;
        throw obj;
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }
}
