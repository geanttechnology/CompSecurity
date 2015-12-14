// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.database.more.f.a;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.pages.moreview.ac;
import com.cyberlink.youcammakeup.pages.moreview.d;
import com.cyberlink.youcammakeup.pages.moreview.f;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, bo, aa, bn

public class z extends ax
{

    private String a;
    private final NetworkManager b;
    private final Date c;
    private final int d;
    private final int e;
    private final aa f;
    private final boolean g;
    private final long h;

    public z(NetworkManager networkmanager, Date date, int i, int j, boolean flag, long l, 
            aa aa1)
    {
        a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/z.getName();
        b = networkmanager;
        c = date;
        d = i;
        e = j;
        g = flag;
        f = aa1;
        h = l;
    }

    private HttpEntity a(int i, int j)
    {
        AndroidHttpClient androidhttpclient = b.G();
        b.H();
        Object obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.h()));
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("lang", ((String) (obj))));
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("sdate", NetworkManager.a.format(c)));
        arraylist.add(new BasicNameValuePair("sindex", String.valueOf(i)));
        arraylist.add(new BasicNameValuePair("count", String.valueOf(j)));
        obj = new JSONArray();
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.accumulate("type", "categoryList");
            jsonobject.accumulate("ver", Float.valueOf(f.c));
            ((JSONArray) (obj)).put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "film");
            jsonobject.accumulate("ver", Float.valueOf(d.a));
            ((JSONArray) (obj)).put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "mkCategoryList");
            jsonobject.accumulate("ver", Float.valueOf(ac.a));
            ((JSONArray) (obj)).put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "mk");
            jsonobject.accumulate("ver", Float.valueOf(14F));
            ((JSONArray) (obj)).put(jsonobject);
            arraylist.add(new BasicNameValuePair("ymkVer", ((JSONArray) (obj)).toString()));
        }
        catch (JSONException jsonexception) { }
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
        Object obj1;
        int j;
        int k;
        int l;
label0:
        {
            int i = d;
            obj = com.cyberlink.youcammakeup.h.e();
            obj1 = new ArrayList();
            k = i;
            if (g)
            {
                break label0;
            }
            k = i;
            if (!NetworkManager.L())
            {
                break label0;
            }
            k = 0;
            do
            {
                if (k >= e)
                {
                    break;
                }
                com.cyberlink.youcammakeup.database.more.f.b b1 = ((a) (obj)).a(i);
                if (b1 == null)
                {
                    break;
                }
                ((Collection) (obj1)).add(b1);
                i++;
                k++;
            } while (true);
            if (i != d + e)
            {
                k = i;
                if ((long)i != h + 1L)
                {
                    break label0;
                }
            }
            obj = new bo();
            obj.d = ((Collection) (obj1));
            f.a(obj);
            return;
        }
        j = e;
        l = d;
        obj1 = new bo(a(k, j - (k - l)), ((Collection) (obj1)));
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ((bo) (obj1)).d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            f.b(new bn(responsestatus, null));
            return;
        }
          goto _L1
_L4:
        f.b(new bn(null, ((Exception) (obj))));
        return;
_L1:
        Iterator iterator;
        if (g)
        {
            ((a) (obj)).a();
        }
        j = d;
        iterator = ((bo) (obj1)).a().iterator();
_L5:
        if (!iterator.hasNext()) goto _L3; else goto _L2
_L2:
        com.cyberlink.youcammakeup.database.more.f.b b2 = (com.cyberlink.youcammakeup.database.more.f.b)iterator.next();
        if (j < k)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        ((a) (obj)).a(j, b2);
        break MISSING_BLOCK_LABEL_309;
_L3:
        try
        {
            f.a(obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            throw obj;
        }
          goto _L4
        j++;
          goto _L5
    }

    public void a(bn bn1)
    {
        f.b(bn1);
    }
}
