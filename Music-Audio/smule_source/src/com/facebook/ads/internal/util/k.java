// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.view.e;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.facebook.ads.internal.util:
//            l, m, g, r, 
//            b, c

public class k extends AsyncTask
{

    private static final String a = com/facebook/ads/internal/util/k.getSimpleName();
    private final Context b;
    private final ImageView c;
    private final e d;
    private l e;

    public k(Context context)
    {
        b = context;
        d = null;
        c = null;
    }

    public k(ImageView imageview)
    {
        b = imageview.getContext();
        d = null;
        c = imageview;
    }

    public k(e e1)
    {
        b = e1.getContext();
        d = e1;
        c = null;
    }

    public k a(l l1)
    {
        e = l1;
        return this;
    }

    protected void a(Bitmap abitmap[])
    {
        if (c != null)
        {
            c.setImageBitmap(abitmap[0]);
        }
        if (d != null)
        {
            d.a(abitmap[0], abitmap[1]);
        }
        if (e != null)
        {
            e.a();
        }
    }

    protected transient Bitmap[] a(String as[])
    {
        Object obj;
        String s = as[0];
        obj = m.a(b, s);
        as = ((String []) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        Object obj1 = g.b();
        HttpGet httpget = new HttpGet(s);
        as = ((String []) (obj));
        byte abyte0[];
        try
        {
            obj1 = ((HttpClient) (obj1)).execute(httpget).getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(a, (new StringBuilder()).append("Error downloading image: ").append(s).toString(), ((Throwable) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        as = ((String []) (obj));
        abyte0 = EntityUtils.toByteArray(((HttpEntity) (obj1)));
        as = ((String []) (obj));
        obj = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        as = ((String []) (obj));
        ((HttpEntity) (obj1)).consumeContent();
        as = ((String []) (obj));
        m.a(b, s, ((Bitmap) (obj)));
        as = ((String []) (obj));
_L7:
        if (d == null) goto _L2; else goto _L1
_L1:
        if (as == null) goto _L4; else goto _L3
_L3:
        obj = new r(as);
        ((r) (obj)).a(Math.round((float)as.getWidth() / 40F));
        obj = ((r) (obj)).a();
_L5:
        return (new Bitmap[] {
            as, obj
        });
        obj;
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(((Throwable) (obj)), null));
_L4:
        obj = as;
        if (true) goto _L5; else goto _L2
_L2:
        return (new Bitmap[] {
            as
        });
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap[])obj);
    }

}
