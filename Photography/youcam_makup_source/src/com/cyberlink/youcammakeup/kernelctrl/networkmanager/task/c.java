// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, d, bn

public class c extends ax
{

    private final NetworkManager a;
    private final d b;

    public c(NetworkManager networkmanager, d d1)
    {
        a = networkmanager;
        b = d1;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.p()));
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("platform", "android"));
        arraylist.add(new BasicNameValuePair("product", "YoucamPerfect"));
        arraylist.add(new BasicNameValuePair("version", "1.0"));
        arraylist.add(new BasicNameValuePair("versiontype", "for Android"));
        arraylist.add(new BasicNameValuePair("lang", s));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        String s = EntityUtils.toString(b());
        b.a(s);
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
