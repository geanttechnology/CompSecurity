// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.webkit.URLUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.medialets.advertising:
//            af, AdManager, y, a, 
//            d, ae, ag, w, 
//            AdManagerService, x

abstract class DataSource
{
    protected abstract class AdvertListHandler
        implements ResponseHandler
    {

        abstract void createAdvertisements(HttpEntity httpentity, List list)
            throws HttpResponseException, IOException;

        public volatile Object handleResponse(HttpResponse httpresponse)
            throws ClientProtocolException, IOException
        {
            return handleResponse(httpresponse);
        }

        public List handleResponse(HttpResponse httpresponse)
            throws HttpResponseException, IOException
        {
            Object obj = httpresponse.getStatusLine();
            if (((StatusLine) (obj)).getStatusCode() >= 300)
            {
                throw new HttpResponseException(((StatusLine) (obj)).getStatusCode(), ((StatusLine) (obj)).getReasonPhrase());
            }
            obj = new ArrayList();
            httpresponse = httpresponse.getEntity();
            if (httpresponse != null)
            {
                createAdvertisements(httpresponse, ((List) (obj)));
                return ((List) (obj));
            } else
            {
                com.medialets.advertising.a.d("Empty response returned from the Medialets server");
                return ((List) (obj));
            }
        }

        protected AdvertListHandler()
        {
        }
    }


    private String a;
    private android.os.PowerManager.WakeLock b;
    private Context c;
    private boolean d;
    private ag e;
    private a f;
    private Runnable g;

    DataSource()
    {
        d = false;
        g = new af(this);
    }

    static void a(DataSource datasource)
    {
        Object obj2;
        d d1;
        AdManager admanager;
        admanager = AdManager.getInstance();
        if (datasource.a.startsWith("http") && !y.b())
        {
            com.medialets.advertising.a.a("No network connection. Cannot complete Medialets server request...");
            admanager.sendMessage(1, null);
            return;
        }
        obj2 = datasource.c();
        com.medialets.advertising.a.a((new StringBuilder()).append("Medialets Server URL: ").append(((String) (obj2))).toString());
        d1 = com.medialets.advertising.d.a(d.DEFAULT_USERAGENT, true);
        if (datasource.b == null || datasource.b.isHeld())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        datasource.b = ((PowerManager)datasource.c.getSystemService("power")).newWakeLock(1, "MedialetsUniversalSDK");
        datasource.b.acquire();
_L6:
        Object obj = new ArrayList();
        obj2 = (List)d1.execute(new HttpGet(((String) (obj2))), datasource.getResponseHandler());
        obj = obj2;
_L7:
        if (datasource.d)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        obj = ((List) (obj)).iterator();
_L5:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_416;
        }
        obj2 = (ae)((Iterator) (obj)).next();
        if (!URLUtil.isValidUrl(((ae) (obj2)).s())) goto _L2; else goto _L1
_L1:
        a a1 = datasource.f;
        if (a1.a.c(((ae) (obj2)))) goto _L4; else goto _L3
_L3:
        (new w(((ae) (obj2)))).a();
_L8:
        a1.a.a(((ae) (obj2)));
        com.medialets.advertising.a.d((new StringBuilder()).append("Loaded advertisement: ").append(((ae) (obj2)).d()).toString());
          goto _L5
        Object obj1;
        obj1;
        admanager.sendMessage(2, (new StringBuilder()).append("Error processing Medialets server response: ").append(((Exception) (obj1)).toString()).toString());
        d1.a();
        datasource.d();
_L9:
        admanager.sendMessage(3, null);
        return;
        obj1;
        com.medialets.advertising.a.c((new StringBuilder()).append("Unable to acquire the partial wake lock...").append(((SecurityException) (obj1)).toString()).toString());
          goto _L6
        obj1;
        d1.a();
        datasource.d();
        throw obj1;
        obj2;
        com.medialets.advertising.a.c((new StringBuilder()).append("Error processing Medialets server response: ").append(((Exception) (obj2)).toString()).toString());
          goto _L7
_L4:
        ((ae) (obj2)).a(true);
          goto _L8
_L2:
        com.medialets.advertising.a.c((new StringBuilder()).append("Invalid Bundle URL: ").append(((ae) (obj2)).s()).append(" , ignoring advertisement").toString());
          goto _L5
        d1.a();
        datasource.d();
          goto _L9
    }

    private String c()
    {
        Object obj = AdManager.getInstance();
        String s = ((AdManager) (obj)).mService.getApplicationId();
        obj = ((AdManager) (obj)).mService.getApplicationVersion();
        String s1 = y.a(y.d());
        Object obj1 = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj1)));
        obj1 = (new StringBuilder()).append(((DisplayMetrics) (obj1)).widthPixels).append("x").append(((DisplayMetrics) (obj1)).heightPixels).toString();
        double ad[] = y.e();
        try
        {
            if (a.startsWith("http"))
            {
                return a.concat(String.format("?appID=%s&appv=%s&p=2&build=%s&AR=%s&SR=%s&udid=%s&lat=%f&lon=%f&d=%s&v=%s", new Object[] {
                    s, URLEncoder.encode(((String) (obj)), "UTF-8"), "2.2.11", obj1, obj1, s1, Double.valueOf(ad[0]), Double.valueOf(ad[1]), URLEncoder.encode(x.ANDROID_DEVICE, "utf-8"), URLEncoder.encode(x.ANDROID_VERSION, "utf-8")
                }));
            }
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(a).toString();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            com.medialets.advertising.a.d((new StringBuilder()).append("UTF-8 is not a supported encoding on this device: ").append(unsupportedencodingexception.toString()).toString());
            return null;
        }
        return s;
    }

    private void d()
    {
        if (b != null && b.isHeld())
        {
            b.release();
        }
    }

    public final void a()
    {
        (new Thread(g)).start();
    }

    public final void a(String s)
    {
        a = s;
    }

    public final void b()
    {
        d = true;
    }

    abstract ResponseHandler getResponseHandler();

    protected void setContext(Context context)
    {
        c = context;
    }

    protected void setDataStore(ag ag1)
    {
        e = ag1;
        f = new a(e);
    }

    // Unreferenced inner class com/medialets/advertising/af
    final class af
        implements Runnable
    {

        private DataSource a;

        public final void run()
        {
            DataSource.a(a);
        }

            af()
            {
                a = DataSource.this;
                super();
            }
    }

}
