// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, e, bn, g

public class f extends ax
{

    private final NetworkManager a;
    private final g b;
    private final List c;

    public f(NetworkManager networkmanager, g g1, List list)
    {
        a = networkmanager;
        b = g1;
        c = list;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.u()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        for (Iterator iterator = c.iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair("adUnitIDs", (String)iterator.next()))) { }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        e e1;
        e1 = new e(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = e1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            b.b(new bn(responsestatus, null));
            return;
        }
        b.a(e1);
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
