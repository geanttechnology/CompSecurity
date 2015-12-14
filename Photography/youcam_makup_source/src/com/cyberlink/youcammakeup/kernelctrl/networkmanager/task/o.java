// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.database.more.makeup.d;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.v;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, a, n, p, 
//            bn

public class o extends ax
{

    private final NetworkManager a;
    private final List b;
    private final p c;

    public o(NetworkManager networkmanager, List list, p p1)
    {
        a = networkmanager;
        b = list;
        c = p1;
    }

    private HttpEntity a(Collection collection)
    {
        AndroidHttpClient androidhttpclient = a.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.w()));
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("categoryIds", com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.a.a(collection)));
        arraylist.add(new BasicNameValuePair("lang", s));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
        ArrayList arraylist;
        Object obj1;
        Object obj2;
        ArrayList arraylist2;
        boolean flag = false;
        obj = h.u();
        if (!z.b("MAKEUP_CATEGORY_LANGUAGE", "", Globals.n()).equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            flag = true;
            ((d) (obj)).a();
        }
        obj2 = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        obj1 = new HashMap();
        arraylist = new ArrayList();
        if (NetworkManager.L())
        {
            int l = b.size();
            int k = 0;
            while (k < l) 
            {
                v v1 = (v)b.get(k);
                a a1 = ((d) (obj)).a(v1.a);
                if (a1 != null && a1.d() == v1.c && !flag)
                {
                    ((List) (obj2)).add(a1);
                    arraylist1.add(Long.valueOf(v1.a));
                    ((Map) (obj1)).put(Long.valueOf(v1.a), a1);
                } else
                if (a1 != null)
                {
                    arraylist.add(Long.valueOf(v1.a));
                }
                k++;
            }
            if (arraylist1.size() == b.size())
            {
                obj = new n();
                obj.d = ((List) (obj2));
                c.a(obj);
                return;
            }
        }
        if (b != null && b.size() > 0)
        {
            obj2 = new ArrayList();
            arraylist2 = new ArrayList();
            for (int i = 0; i < b.size(); i++)
            {
                v v2 = (v)b.get(i);
                arraylist2.add(Long.valueOf(v2.a));
                if (!arraylist1.contains(Long.valueOf(v2.a)))
                {
                    ((List) (obj2)).add(Long.valueOf(v2.a));
                }
            }

        } else
        {
            a(new bn(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.b, new Exception("category Id list is empty, abort GetCategoryTask")));
            return;
        }
        n n1;
        n1 = new n(a(((Collection) (obj2))), ((Map) (obj1)), arraylist2);
        obj1 = n1.d();
        if (obj1 != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            c.b(new bn(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus) (obj1)), null));
            return;
        }
          goto _L1
_L2:
        c.b(new bn(null, ((Exception) (obj))));
        return;
_L1:
        obj1 = n1.a();
        int j = 0;
_L3:
        if (j >= ((List) (obj1)).size())
        {
            break MISSING_BLOCK_LABEL_579;
        }
        obj2 = (a)((List) (obj1)).get(j);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_601;
        }
        if (arraylist.contains(Long.valueOf(((a) (obj2)).a())))
        {
            ((a) (obj2)).a(true);
            ((d) (obj)).a(((a) (obj2)));
            break MISSING_BLOCK_LABEL_601;
        }
        ((d) (obj)).a(((a) (obj2)).a(), ((a) (obj2)));
        break MISSING_BLOCK_LABEL_601;
        try
        {
            c.a(n1);
            z.a("MAKEUP_CATEGORY_LANGUAGE", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(), Globals.n());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            throw obj;
        }
          goto _L2
        j++;
          goto _L3
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }
}
