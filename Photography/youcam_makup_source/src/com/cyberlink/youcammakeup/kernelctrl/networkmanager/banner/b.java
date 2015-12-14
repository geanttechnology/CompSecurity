// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.pf.common.utility.m;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner:
//            GetPromotionBannerResponse, c

public class b extends ax
{

    private final NetworkManager a;
    private final c b;

    public b(NetworkManager networkmanager, c c1)
    {
        a = networkmanager;
        b = c1;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.r()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        arraylist.add(new BasicNameValuePair("contentVer", String.valueOf(4F)));
        if (TestConfigHelper.h().d())
        {
            String s = TestConfigHelper.h().j();
            if (!s.isEmpty())
            {
                arraylist.add(new BasicNameValuePair("country", s));
            }
        }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        GetPromotionBannerResponse getpromotionbannerresponse;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus;
        getpromotionbannerresponse = new GetPromotionBannerResponse(b());
        responsestatus = getpromotionbannerresponse.d();
        if (responsestatus == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a) goto _L2; else goto _L1
_L1:
        m.e("GetPromotionBannerTask", "call mCallback.error");
        b.b(new bn(responsestatus, null));
_L4:
        m.b("GetPromotionBannerTask", "finally");
        return;
_L2:
        m.b("GetPromotionBannerTask", "call mCallback.complete()");
        b.a(getpromotionbannerresponse);
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        m.b("GetPromotionBannerTask", "", ((Throwable) (obj)));
        b.b(new bn(null, ((Exception) (obj))));
        m.b("GetPromotionBannerTask", "finally");
        return;
        obj;
        m.b("GetPromotionBannerTask", "finally");
        throw obj;
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }
}
