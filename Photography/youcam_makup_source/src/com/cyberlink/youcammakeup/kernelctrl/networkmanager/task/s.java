// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
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
//            ax, a, q, bn, 
//            t

public class s extends ax
{

    private String a;
    private final NetworkManager b;
    private final t c;
    private Collection d;

    public s(NetworkManager networkmanager, Collection collection, t t1)
    {
        a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/s.getName();
        b = networkmanager;
        d = collection;
        c = t1;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = b.G();
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.A()));
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("names", com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.a.a(d)));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        q q1;
        q1 = new q(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = q1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            c.b(new bn(responsestatus, null));
            return;
        }
        c.a(q1);
        return;
        Object obj;
        obj;
        c.b(new bn(null, ((Exception) (obj))));
        return;
        obj;
        throw obj;
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }
}
