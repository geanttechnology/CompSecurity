// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.pf.common.utility.m;
import java.net.URI;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            a, d

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
        httppost.setURI(new URI(NetworkManager.q()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        a a1;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus;
        a1 = new a(b());
        responsestatus = a1.d();
        if (responsestatus == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a) goto _L2; else goto _L1
_L1:
        m.e("GetPromotionListTask", "call mCallback.error");
        b.b(new bn(responsestatus, null));
_L4:
        m.b("GetPromotionListTask", "finally");
        return;
_L2:
        m.b("GetPromotionListTask", "call mCallback.complete()");
        b.a(a1);
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        m.b("GetPromotionListTask", "", ((Throwable) (obj)));
        b.b(new bn(null, ((Exception) (obj))));
        m.b("GetPromotionListTask", "finally");
        return;
        obj;
        m.b("GetPromotionListTask", "finally");
        throw obj;
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }
}
