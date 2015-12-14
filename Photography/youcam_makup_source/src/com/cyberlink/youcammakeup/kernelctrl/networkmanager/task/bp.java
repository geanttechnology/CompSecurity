// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.net.URI;
import java.util.ArrayList;
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
//            ax, br, bn, bq

public class bp extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/bp.getSimpleName();
    private final NetworkManager b;
    private String c;
    private String d;
    private bq e;

    public bp(NetworkManager networkmanager, String s, String s1, bq bq1)
    {
        b = networkmanager;
        c = s;
        d = s1;
        e = bq1;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = b.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.k()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.b(arraylist);
        try
        {
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobject = new JSONObject();
            jsonobject.accumulate("type", c);
            jsonobject.accumulate("ver", d);
            jsonarray.put(jsonobject);
            arraylist.add(new BasicNameValuePair("templateVer", jsonarray.toString()));
        }
        catch (JSONException jsonexception) { }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        br br1;
        br1 = new br(b());
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = br1.d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            e.b(new bn(responsestatus, null));
            return;
        }
        e.a(br1);
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
