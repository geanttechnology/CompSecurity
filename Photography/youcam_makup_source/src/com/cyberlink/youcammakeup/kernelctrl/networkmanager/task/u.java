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
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, a, y, v, 
//            bn

public class u extends ax
{

    private static String a = "GetMakeupItemByGuidsTask";
    private final NetworkManager b;
    private final List c;
    private final v d;

    public u(NetworkManager networkmanager, List list, v v1)
    {
        b = networkmanager;
        c = list;
        d = v1;
    }

    private HttpEntity a(Collection collection)
    {
        AndroidHttpClient androidhttpclient = b.G();
        String s = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.C()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("guids", com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.a.a(collection)));
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
            if (NetworkManager.L())
            {
                int k = c.size();
                for (int i = 0; i < k; i++)
                {
                    MakeupItemMetadata makeupitemmetadata = ((e) (obj)).a((String)c.get(i));
                    if (makeupitemmetadata != null)
                    {
                        ((List) (obj1)).add(makeupitemmetadata);
                        arraylist.add(makeupitemmetadata.m());
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
            ArrayList arraylist1;
            if (c != null && c.size() > 0)
            {
                arraylist1 = new ArrayList();
                ArrayList arraylist2 = new ArrayList();
                for (int j = ((flag) ? 1 : 0); j < c.size(); j++)
                {
                    String s = (String)c.get(j);
                    arraylist2.add(s);
                    if (!arraylist.contains(s))
                    {
                        arraylist1.add(s);
                    }
                }

            } else
            {
                a(new bn(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.b, new Exception("category Id list is empty, abort GetCategoryTask")));
                return;
            }
            try
            {
                obj1 = new y(a(((Collection) (arraylist1))), ((List) (obj1)));
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
        MakeupItemMetadata makeupitemmetadata1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_425;
            }
            makeupitemmetadata1 = (MakeupItemMetadata)iterator.next();
        } while (makeupitemmetadata1 == null);
        ((e) (obj)).a(makeupitemmetadata1.a(), makeupitemmetadata1);
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
