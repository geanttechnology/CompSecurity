// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, a, y, x, 
//            bn

public class w extends ax
{

    private static String a = "GetMakeupItemByIdsTask";
    private final NetworkManager b;
    private final List c;
    private final x d;

    public w(NetworkManager networkmanager, List list, x x1)
    {
        b = networkmanager;
        c = list;
        d = x1;
    }

    private HttpEntity a(Collection collection)
    {
        AndroidHttpClient androidhttpclient = b.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.x()));
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("mkIds", com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.a.a(collection)));
        arraylist.add(new BasicNameValuePair("lang", s));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
        Object obj1;
label0:
        {
            boolean flag = false;
            obj = h.v();
            if (!z.b("MAKEUP_TEMPLATE_LANGUAGE", "", Globals.n()).equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
            {
                ((e) (obj)).a();
            }
            ArrayList arraylist = new ArrayList();
            obj1 = new ArrayList();
            Object obj2 = new HashMap();
            if (NetworkManager.L())
            {
                int k = c.size();
                for (int i = 0; i < k; i++)
                {
                    com.cyberlink.youcammakeup.kernelctrl.w w1 = (com.cyberlink.youcammakeup.kernelctrl.w)c.get(i);
                    MakeupItemMetadata makeupitemmetadata1 = ((e) (obj)).a(w1.a);
                    if (makeupitemmetadata1 != null)
                    {
                        ((List) (obj1)).add(makeupitemmetadata1);
                        arraylist.add(Long.valueOf(w1.a));
                        ((Map) (obj2)).put(Long.valueOf(w1.a), makeupitemmetadata1);
                    }
                }

                if (arraylist.size() == c.size())
                {
                    obj = new y();
                    ((y) (obj)).a(((List) (obj1)));
                    d.a(obj);
                    return;
                }
            }
            if (c != null && c.size() > 0)
            {
                obj2 = new ArrayList();
                ArrayList arraylist1 = new ArrayList();
                for (int j = ((flag) ? 1 : 0); j < c.size(); j++)
                {
                    com.cyberlink.youcammakeup.kernelctrl.w w2 = (com.cyberlink.youcammakeup.kernelctrl.w)c.get(j);
                    arraylist1.add(Long.valueOf(w2.a));
                    if (!arraylist.contains(Long.valueOf(w2.a)))
                    {
                        ((List) (obj2)).add(Long.valueOf(w2.a));
                    }
                }

            } else
            {
                a(new bn(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.b, new Exception("category Id list is empty, abort GetCategoryTask")));
                return;
            }
            try
            {
                obj1 = new y(a(((Collection) (obj2))), ((List) (obj1)));
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ((y) (obj1)).d();
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
        Iterator iterator = ((y) (obj1)).a().iterator();
_L1:
        MakeupItemMetadata makeupitemmetadata;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_480;
            }
            makeupitemmetadata = (MakeupItemMetadata)iterator.next();
        } while (makeupitemmetadata == null);
        ((e) (obj)).a(makeupitemmetadata.a(), makeupitemmetadata);
          goto _L1
        d.a(obj1);
        z.a("MAKEUP_TEMPLATE_LANGUAGE", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(), Globals.n());
        return;
    }

    public void a(bn bn1)
    {
        d.b(bn1);
    }

}
