// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.utility.f;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, af, ah, bn

public class GetPromotionTask extends ax
{

    private final NetworkManager a;
    private final ah b;
    private final PromotionCategoryType c;

    public GetPromotionTask(NetworkManager networkmanager, PromotionCategoryType promotioncategorytype, ah ah1)
    {
        a = networkmanager;
        c = promotioncategorytype;
        b = ah1;
    }

    public static af a(String s)
    {
        if (!f.a(s, TimeUnit.DAYS.toMillis(1L)))
        {
            if ((s = f.b(s)) != null)
            {
                try
                {
                    s = new af(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    private HttpEntity b()
    {
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.y()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()));
        arraylist.add(new BasicNameValuePair("contentVer", String.valueOf(14F)));
        if (c != PromotionCategoryType.a)
        {
            arraylist.add(new BasicNameValuePair("type", c.name()));
        }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        return androidhttpclient.execute(httppost).getEntity();
    }

    public void a()
    {
        Object obj;
label0:
        {
            obj = a(c.a());
            if (obj != null)
            {
                b.a(obj);
                return;
            }
            try
            {
                obj = new af(b());
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus = ((af) (obj)).d();
                if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
                {
                    b.b(new bn(responsestatus, null));
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
        b.b(new bn(null, ((Exception) (obj))));
        return;
        b.a(obj);
        f.a(c.a(), ((af) (obj)).b());
        f.a(c.a());
        return;
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }

    private class PromotionCategoryType extends Enum
    {

        public static final PromotionCategoryType a;
        public static final PromotionCategoryType b;
        public static final PromotionCategoryType c;
        private static final PromotionCategoryType d[];

        public static PromotionCategoryType valueOf(String s)
        {
            return (PromotionCategoryType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/GetPromotionTask$PromotionCategoryType, s);
        }

        public static PromotionCategoryType[] values()
        {
            return (PromotionCategoryType[])d.clone();
        }

        public String a()
        {
            return (new StringBuilder()).append("GetPromotionTask").append(name()).toString();
        }

        static 
        {
            a = new PromotionCategoryType("Default", 0);
            b = new PromotionCategoryType("Costume_Looks", 1);
            c = new PromotionCategoryType("Natural_Looks", 2);
            d = (new PromotionCategoryType[] {
                a, b, c
            });
        }

        private PromotionCategoryType(String s, int i)
        {
            super(s, i);
        }
    }

}
