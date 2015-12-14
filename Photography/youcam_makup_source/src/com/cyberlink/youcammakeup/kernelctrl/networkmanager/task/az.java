// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.u;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, ay, bn, ba

public class az extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/az.getSimpleName();
    private final Context b;
    private final NetworkManager c;
    private final ba d;
    private boolean e;

    public az(Context context, NetworkManager networkmanager, ba ba1)
    {
        b = context;
        c = networkmanager;
        d = ba1;
        e = false;
    }

    private HttpEntity b()
    {
        Context context = b;
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.g()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("phoneid", u.a(context, c)));
        arraylist.add(new BasicNameValuePair("timezone", u.b()));
        arraylist.add(new BasicNameValuePair("sr", u.a(context)));
        arraylist.add(new BasicNameValuePair("lang", u.c()));
        arraylist.add(new BasicNameValuePair("model", u.a));
        arraylist.add(new BasicNameValuePair("vendor", u.b));
        arraylist.add(new BasicNameValuePair("resolution", u.c(context)));
        arraylist.add(new BasicNameValuePair("hwid", u.d(context)));
        arraylist.add(new BasicNameValuePair("appversion", u.a()));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        return c.G().execute(httppost).getEntity();
    }

    public void a()
    {
        boolean flag = true;
        Object obj;
        obj = new ay(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ((ay) (obj)).d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d.b(new bn(responsestatus, null));
            return;
        }
        NetworkManager.a(((ay) (obj)));
        if (!"on".equalsIgnoreCase(((ay) (obj)).m))
        {
            flag = false;
        }
        Globals.f = flag;
        if (NetworkManager.e() && !e)
        {
            e = true;
            a();
            return;
        }
        break MISSING_BLOCK_LABEL_116;
        obj;
        d.b(new bn(null, ((Exception) (obj))));
        return;
        obj;
        throw obj;
        d.a(obj);
        return;
    }

    public void a(bn bn1)
    {
        d.b(bn1);
    }

}
