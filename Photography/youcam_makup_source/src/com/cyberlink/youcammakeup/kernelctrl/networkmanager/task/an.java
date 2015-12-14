// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity;
import com.cyberlink.youcammakeup.database.more.a.a;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.pages.moreview.ac;
import com.cyberlink.youcammakeup.pages.moreview.d;
import com.cyberlink.youcammakeup.pages.moreview.f;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, ao, ap, bn

public class an extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/an.getSimpleName();
    private final Context b;
    private final NetworkManager c;
    private final ao d;
    private final int e = 5;

    public an(Context context, NetworkManager networkmanager, ao ao1)
    {
        b = context;
        c = networkmanager;
        d = ao1;
    }

    private void a(Collection collection, Map map)
    {
        if (collection != null && map != null)
        {
            collection = collection.iterator();
            do
            {
                if (!collection.hasNext())
                {
                    break;
                }
                Object obj = (b)collection.next();
                long l = ((b) (obj)).d();
                map.put(Long.valueOf(((b) (obj)).a()), Long.valueOf(l));
                obj = ((b) (obj)).f();
                if (obj != null)
                {
                    a(((Collection) (obj)), map);
                }
            } while (true);
        }
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = c.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.k()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()));
        JSONArray jsonarray = new JSONArray();
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.accumulate("type", "categoryList");
            jsonobject.accumulate("ver", Float.valueOf(f.c));
            jsonarray.put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "film");
            jsonobject.accumulate("ver", Float.valueOf(d.a));
            jsonarray.put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "mkCategoryList");
            jsonobject.accumulate("ver", Float.valueOf(ac.a));
            jsonarray.put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "mk");
            jsonobject.accumulate("ver", Float.valueOf(14F));
            jsonarray.put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "sku");
            jsonobject.accumulate("ver", Float.valueOf(14F));
            jsonarray.put(jsonobject);
            jsonobject = new JSONObject();
            jsonobject.accumulate("type", "skuFormat");
            jsonobject.accumulate("ver", Float.valueOf(3F));
            jsonarray.put(jsonobject);
            arraylist.add(new BasicNameValuePair("ymkVer", jsonarray.toString()));
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
label0:
        {
            long l = System.currentTimeMillis() / 1000L;
            obj = Globals.d().K();
            if (obj != null && !com.cyberlink.youcammakeup.utility.f.a(a, TimeUnit.MINUTES.toMillis(5L)) && NetworkManager.L() && ((Pair) (obj)).second != null)
            {
                d.a(((Pair) (obj)).second);
                return;
            }
            try
            {
                obj = new ap(b());
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ((ap) (obj)).d();
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
        HashMap hashmap;
        Object obj1;
        long l1;
        l1 = System.currentTimeMillis() / 1000L;
        Globals.d().a(l1, ((ap) (obj)));
        com.cyberlink.youcammakeup.utility.f.a(a);
        d.a(obj);
        l1 = ((ap) (obj)).a();
        hashmap = new HashMap();
        obj1 = ((ap) (obj)).b();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        a a1;
        long l2;
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); hashmap.put(Long.valueOf(a1.a()), Long.valueOf(l2)))
        {
            a1 = (a)((Iterator) (obj1)).next();
            l2 = a1.d();
        }

        c.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeDataType.b, l1, BeautyTipCategoryActivity.a, hashmap);
        l1 = ((ap) (obj)).f();
        hashmap = new HashMap();
        a(((Collection) (((ap) (obj)).i().b())), ((Map) (hashmap)));
        c.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeDataType.c, l1);
        return;
    }

    public void a(bn bn1)
    {
        d.b(bn1);
    }

}
