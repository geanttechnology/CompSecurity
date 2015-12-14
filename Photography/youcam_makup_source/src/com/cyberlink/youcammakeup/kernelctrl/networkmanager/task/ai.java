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
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, ak, aj, bn

public class ai extends ax
{

    private final NetworkManager a;
    private final Map b;
    private final aj c;
    private final boolean d;

    public ai(NetworkManager networkmanager, Map map, boolean flag, aj aj1)
    {
        a = networkmanager;
        b = map;
        d = flag;
        c = aj1;
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
        Object obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.z()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", ((String) (obj))));
        arraylist.add(new BasicNameValuePair("makeupVer", String.valueOf(14F)));
        arraylist.add(new BasicNameValuePair("skuFormatVer", String.valueOf(3F)));
        obj = new ArrayList();
        String s1;
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext(); ((Collection) (obj)).addAll((Collection)b.get(s1)))
        {
            s1 = (String)iterator.next();
        }

        arraylist.add(new BasicNameValuePair("guids", a(((Collection) (obj)))));
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
        Object obj;
        boolean flag;
        flag = false;
        obj = h.w();
        if (obj == null || d) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        long l;
        l = System.currentTimeMillis();
        obj1 = new ArrayList();
        obj2 = b.keySet().iterator();
_L8:
        if (!((Iterator) (obj2)).hasNext()) goto _L4; else goto _L3
_L3:
        Object obj3;
        Object obj4;
        obj3 = (String)((Iterator) (obj2)).next();
        obj4 = ((c) (obj)).a(((String) (obj3)), l);
        if (obj4 != null) goto _L6; else goto _L5
_L5:
        int i = ((flag) ? 1 : 0);
_L9:
        if (i != 0)
        {
            obj = new ak();
            ((ak) (obj)).a(((List) (obj1)));
            c.a(obj);
            return;
        }
          goto _L2
_L6:
        obj3 = (Collection)b.get(obj3);
        obj4 = ((Collection) (obj4)).iterator();
        int j;
        for (i = 0; ((Iterator) (obj4)).hasNext(); i = j)
        {
            d d1 = (d)((Iterator) (obj4)).next();
            j = i;
            if (((Collection) (obj3)).contains(d1.d()))
            {
                j = i + 1;
                ((List) (obj1)).add(d1);
            }
        }

        if (i == ((Collection) (obj3)).size()) goto _L8; else goto _L7
_L7:
        i = ((flag) ? 1 : 0);
          goto _L9
_L2:
        obj1 = new ak(b());
        obj2 = ((ak) (obj1)).d();
        if (obj2 != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            c.b(new bn(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus) (obj2)), null));
            return;
        }
          goto _L10
_L13:
        c.b(new bn(null, ((Exception) (obj))));
        return;
_L10:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        obj2 = ((ak) (obj1)).a().iterator();
_L12:
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_414;
            }
            obj3 = (d)((Iterator) (obj2)).next();
            obj4 = ((c) (obj)).a(((d) (obj3)).b(), ((d) (obj3)).a(), ((d) (obj3)));
        } while (obj4 == null);
        if (((d) (obj4)).k() != ((d) (obj3)).k() || d)
        {
            ((c) (obj)).c(((d) (obj3)).b(), ((d) (obj3)).a());
            ((c) (obj)).a(((d) (obj3)).b(), ((d) (obj3)).a(), ((d) (obj3)));
            ((ak) (obj1)).a(((d) (obj3)).a(), ((d) (obj4)));
        }
        if (true) goto _L12; else goto _L11
_L11:
        try
        {
            c.a(obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            throw obj;
        }
        if (true) goto _L13; else goto _L4
_L4:
        i = 1;
          goto _L9
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }
}
