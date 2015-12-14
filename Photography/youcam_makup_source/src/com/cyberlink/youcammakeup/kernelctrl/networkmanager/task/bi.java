// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageLayoutType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.database.more.types.a;
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
//            ax, bh, bn, bj

public class bi extends ax
{

    private final NetworkManager a;
    private final a b;
    private final int c;
    private final int d;
    private final bj e;

    public bi(NetworkManager networkmanager, a a1, int i, int j, bj bj1)
    {
        a = networkmanager;
        b = a1;
        c = i + 1;
        i = j;
        if (j > 30)
        {
            i = 30;
        }
        d = i;
        e = bj1;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        OrderType ordertype = b.a();
        CategoryType categorytype = b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.i()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        arraylist.add(new BasicNameValuePair("sindex", String.valueOf(c)));
        arraylist.add(new BasicNameValuePair("count", String.valueOf(d)));
        arraylist.add(new BasicNameValuePair("ordertype", ordertype.name()));
        arraylist.add(new BasicNameValuePair("categorytype", categorytype.name()));
        if (categorytype == CategoryType.h)
        {
            Object obj = b.c();
            if (obj != CollageLayoutType.c)
            {
                obj = ((CollageLayoutType) (obj)).name();
            } else
            {
                obj = null;
            }
            arraylist.add(new BasicNameValuePair("collagelayout", ((String) (obj))));
        }
        obj = "";
        if (categorytype == CategoryType.h)
        {
            obj = String.valueOf(4F);
        }
        arraylist.add(new BasicNameValuePair("contentVer", ((String) (obj))));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        bh bh1;
        bh1 = new bh(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = bh1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e.b(new bn(responsestatus, null));
            return;
        }
        e.a(bh1);
        return;
        Object obj;
        obj;
        e.b(new bn(null, ((Exception) (obj))));
        return;
        obj;
        throw obj;
    }

    public void a(bn bn1)
    {
        e.b(bn1);
    }
}
