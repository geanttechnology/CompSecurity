// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.database.more.a.d;
import com.cyberlink.youcammakeup.database.more.a.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.pages.moreview.f;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, bb, bd, bn

public class bc extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bc.getSimpleName();
    private final NetworkManager b;
    private final bd c;
    private final int d;
    private final int e;
    private final boolean f;

    public bc(NetworkManager networkmanager, int i, int j, boolean flag, bd bd1)
    {
        b = networkmanager;
        c = bd1;
        d = i;
        e = j;
        f = flag;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = b.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.l()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", s));
        arraylist.add(new BasicNameValuePair("contentVer", String.valueOf(f.c)));
        arraylist.add(new BasicNameValuePair("sindex", String.valueOf(d)));
        arraylist.add(new BasicNameValuePair("count", String.valueOf(e)));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
        bb bb1;
label0:
        {
            obj = h.s();
            if (!f && NetworkManager.L())
            {
                Collection collection = ((e) (obj)).a();
                if (collection != null && collection.size() > 0)
                {
                    obj = new bb();
                    ((bb) (obj)).a(collection);
                    ((bb) (obj)).a(collection.size());
                    c.a(obj);
                    return;
                }
            }
            try
            {
                bb1 = new bb(b());
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = bb1.d();
                if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
                {
                    c.b(new bn(responsestatus, null));
                    return;
                }
                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                throw obj;
            }
        }
        c.b(new bn(null, ((Exception) (obj))));
        return;
        Object obj1;
        obj1 = bb1.a();
        if (((Collection) (obj1)).size() > 0)
        {
            ((e) (obj)).b();
        }
        obj1 = ((Collection) (obj1)).iterator();
        int i = 1;
_L2:
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        d d1 = (d)((Iterator) (obj1)).next();
        ((e) (obj)).a(i, d1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        c.a(bb1);
        return;
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }

}
