// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.database.more.a.c;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.pages.moreview.d;
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
//            ax, be, bg, bn

public class bf extends ax
{

    private String a;
    private final NetworkManager b;
    private final bg c;
    private final int d;
    private final int e;
    private final long f;
    private final boolean g;
    private final long h;

    public bf(NetworkManager networkmanager, int i, int j, long l, boolean flag, long l1, bg bg1)
    {
        a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bf.getName();
        b = networkmanager;
        c = bg1;
        d = i;
        e = j;
        f = l;
        g = flag;
        h = l1;
    }

    private HttpEntity a(int i, int j)
    {
        AndroidHttpClient androidhttpclient = b.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.m()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", s));
        arraylist.add(new BasicNameValuePair("contentVer", String.valueOf(d.a)));
        arraylist.add(new BasicNameValuePair("categoryId", String.valueOf(f)));
        arraylist.add(new BasicNameValuePair("sindex", String.valueOf(i)));
        arraylist.add(new BasicNameValuePair("count", String.valueOf(j)));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
        Object obj1;
        be be1;
        int i;
label0:
        {
            int j = d;
            obj1 = com.cyberlink.youcammakeup.h.t();
            obj = new ArrayList();
            i = j;
            if (obj1 == null)
            {
                break label0;
            }
            i = j;
            if (g)
            {
                break label0;
            }
            Collection collection = ((c) (obj1)).a(f);
            i = j;
            if (collection == null)
            {
                break label0;
            }
            i = j;
            if (collection.isEmpty())
            {
                break label0;
            }
            i = j;
            if (!NetworkManager.L())
            {
                break label0;
            }
            i = 0;
            do
            {
                if (i >= e)
                {
                    break;
                }
                com.cyberlink.youcammakeup.database.more.a.b b1 = ((c) (obj1)).a(j, f);
                if (b1 == null)
                {
                    break;
                }
                ((Collection) (obj)).add(b1);
                j++;
                i++;
            } while (true);
            if (j != d + e)
            {
                i = j;
                if (h <= 0L)
                {
                    break label0;
                }
                i = j;
                if ((long)j != h + 1L)
                {
                    break label0;
                }
            }
            obj1 = new be();
            ((be) (obj1)).a(((Collection) (obj)));
            c.a(obj1);
            return;
        }
label1:
        {
            int k = d;
            int l = e;
            try
            {
                be1 = new be(a(i, l - (i - k)), ((Collection) (obj)));
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = be1.d();
                if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
                {
                    c.b(new bn(responsestatus, null));
                    return;
                }
                break label1;
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
        Iterator iterator;
        if (g)
        {
            ((c) (obj1)).b(f);
        }
        iterator = be1.b().iterator();
_L3:
        com.cyberlink.youcammakeup.database.more.a.b b2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_375;
        }
        b2 = (com.cyberlink.youcammakeup.database.more.a.b)iterator.next();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((Collection) (obj)).contains(b2)) goto _L3; else goto _L2
_L2:
        ((c) (obj1)).a(i, f, b2);
        i++;
          goto _L3
        c.a(be1);
        return;
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }
}
