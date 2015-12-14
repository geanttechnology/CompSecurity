// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.database.more.i.c;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
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
//            ax, ak, am, bn

public class al extends ax
{

    private final NetworkManager a;
    private final Collection b;
    private final Collection c;
    private final am d;
    private final boolean e;
    private final boolean f;

    public al(NetworkManager networkmanager, Collection collection, Collection collection1, boolean flag, boolean flag1, am am1)
    {
        a = networkmanager;
        b = collection;
        c = collection1;
        e = flag;
        f = flag1;
        d = am1;
    }

    private String a(Collection collection)
    {
        if (collection.size() <= 0)
        {
            return "";
        }
        collection = collection.iterator();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((String)collection.next());
        for (; collection.hasNext(); stringbuilder.append((String)collection.next()))
        {
            stringbuilder.append(",");
        }

        return stringbuilder.toString();
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.s()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", s));
        arraylist.add(new BasicNameValuePair("makeupVer", String.valueOf(14F)));
        arraylist.add(new BasicNameValuePair("secretIds", a(b)));
        arraylist.add(new BasicNameValuePair("type", a(c)));
        arraylist.add(new BasicNameValuePair("skuFormatVer", String.valueOf(3F)));
        if (TestConfigHelper.h().d())
        {
            String s1 = TestConfigHelper.h().j();
            if (!s1.isEmpty())
            {
                arraylist.add(new BasicNameValuePair("country", s1));
            }
        }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
        ak ak1;
label0:
        {
            obj = h.w();
            if (obj != null && !e && !f)
            {
                long l = System.currentTimeMillis();
                ArrayList arraylist = new ArrayList();
                Iterator iterator = c.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Collection collection = ((c) (obj)).a((String)iterator.next(), l);
                    if (collection != null)
                    {
                        arraylist.addAll(collection);
                    }
                } while (true);
                obj = new ak();
                ((ak) (obj)).a(arraylist);
                d.a(obj);
                return;
            }
            try
            {
                ak1 = new ak(b());
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ak1.d();
                if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
                {
                    d.b(new bn(responsestatus, null));
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
        d.b(new bn(null, ((Exception) (obj))));
        return;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        Iterator iterator1 = ak1.a().iterator();
_L2:
        d d1;
        d d2;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_302;
            }
            d1 = (d)iterator1.next();
            d2 = ((c) (obj)).a(d1.b(), d1.a(), d1);
        } while (d2 == null);
        if (d2.k() == d1.k() && !f) goto _L2; else goto _L1
_L1:
        ((c) (obj)).c(d1.b(), d1.a());
        ((c) (obj)).a(d1.b(), d1.a(), d1);
        ak1.a(d1.a(), d2);
          goto _L2
        d.a(ak1);
        return;
    }

    public void a(bn bn1)
    {
        d.b(bn1);
    }
}
