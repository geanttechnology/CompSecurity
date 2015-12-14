// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.ac;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            ax, aw, ar, bn

public class av extends ax
{

    private final NetworkManager a;
    private final long b;
    private final aw c;
    private final com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType d;
    private final MKCategoryV2Status e;

    public av(NetworkManager networkmanager, long l, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, MKCategoryV2Status mkcategoryv2status, aw aw1)
    {
        a = networkmanager;
        b = l;
        d = displaymakeuptype;
        e = mkcategoryv2status;
        c = aw1;
    }

    private HttpEntity b()
    {
        boolean flag1 = true;
        AndroidHttpClient androidhttpclient = a.G();
        HttpPost httppost = new HttpPost();
        httppost.setURI(new URI(NetworkManager.v()));
        ArrayList arraylist = new ArrayList();
        NetworkManager.a(arraylist);
        arraylist.add(new BasicNameValuePair("lang", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()));
        arraylist.add(new BasicNameValuePair("contentVer", String.valueOf(14F)));
        arraylist.add(new BasicNameValuePair("categoryContentVer", String.valueOf(ac.a)));
        arraylist.add(new BasicNameValuePair("categoryId", String.valueOf(b)));
        if (d == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b || d == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c)
        {
            String s;
            boolean flag;
            if (d == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist.add(new BasicNameValuePair("editMode", String.valueOf(flag)));
            if (d == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            arraylist.add(new BasicNameValuePair("liveMode", String.valueOf(flag)));
        }
        if (TestConfigHelper.h().d())
        {
            s = TestConfigHelper.h().j();
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
        float f;
        Object obj1;
        obj1 = MakeupItemTreeManager.a();
        f = z.e("MAKEUP_TREE_VERSION", Globals.d().getApplicationContext());
        if (e == null) goto _L2; else goto _L1
_L1:
        long l = e.a();
_L4:
        Object obj;
        if (((MakeupItemTreeManager) (obj1)).a(d, l) && 14F <= f)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus;
            try
            {
                c.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                throw obj;
            }
            break MISSING_BLOCK_LABEL_110;
        }
        obj = new ar(b());
        responsestatus = ((ar) (obj)).d();
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            c.b(new bn(responsestatus, null));
            return;
        }
        break MISSING_BLOCK_LABEL_132;
        c.b(new bn(null, ((Exception) (obj))));
        return;
        ((MakeupItemTreeManager) (obj1)).a(d, ((ar) (obj)).a());
        ((MakeupItemTreeManager) (obj1)).c(d);
        ((MakeupItemTreeManager) (obj1)).a(d, e);
        ((MakeupItemTreeManager) (obj1)).b(d);
        z.a("MAKEUP_TREE_VERSION", 14F, Globals.d().getApplicationContext());
        obj1 = ((MakeupItemTreeManager) (obj1)).b();
        a.K().a(MoreMakeupActivity.a, ((java.util.Map) (obj1)));
        c.a(obj);
        return;
_L2:
        l = 0x7fffffffffffffffL;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(bn bn1)
    {
        c.b(bn1);
    }
}
