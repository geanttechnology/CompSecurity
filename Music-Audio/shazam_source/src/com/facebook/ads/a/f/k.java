// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.a.g.c;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.facebook.ads.a.f:
//            g, r, j, b, 
//            c, l

public class k extends AsyncTask
{

    private static final String b = com/facebook/ads/a/f/k.getSimpleName();
    l a;
    private final Context c;
    private final ImageView d;
    private final c e;

    public k(Context context)
    {
        c = context;
        e = null;
        d = null;
    }

    public k(c c1)
    {
        c = c1.getContext();
        e = c1;
        d = null;
    }

    private transient Bitmap[] a(String as[])
    {
        Object obj2;
        String s;
        obj2 = null;
        s = as[0];
        as = BitmapFactory.decodeFile((new File(c.getCacheDir(), String.format("%d.png", new Object[] {
            Integer.valueOf(s.hashCode())
        }))).getAbsolutePath());
        Object obj = as;
        if (as != null) goto _L2; else goto _L1
_L1:
        obj = as;
        Object obj1 = g.b().execute(new HttpGet(s)).getEntity();
        obj = as;
        byte abyte0[] = EntityUtils.toByteArray(((HttpEntity) (obj1)));
        obj = as;
        as = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        obj = as;
        ((HttpEntity) (obj1)).consumeContent();
        obj = as;
        obj1 = new File(c.getCacheDir(), String.format("%d.png", new Object[] {
            Integer.valueOf(s.hashCode())
        }));
        obj = as;
        obj1 = new FileOutputStream(((File) (obj1)));
        obj = as;
        as.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj1)));
        obj = as;
        ((FileOutputStream) (obj1)).flush();
        obj = as;
        ((FileOutputStream) (obj1)).close();
_L3:
        c c1 = e;
        obj = obj2;
        obj1 = as;
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        obj = obj2;
        obj1 = as;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        obj = new r(as);
        int i = Math.round((float)as.getWidth() / 40F);
        obj.d = ((r) (obj)).e.a(((r) (obj)).c, i);
        obj1 = ((r) (obj)).d;
        obj = ((r) (obj)).d;
        obj1 = as;
_L4:
        return (new Bitmap[] {
            obj1, obj
        });
        obj;
        obj = as;
_L2:
        as = ((String []) (obj));
          goto _L3
        Throwable throwable;
        throwable;
        obj = null;
        as = null;
_L5:
        Log.e(b, (new StringBuilder("Error downloading image: ")).append(s).toString(), throwable);
        com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(throwable, null));
        throwable = ((Throwable) (obj));
        obj = as;
          goto _L4
        throwable;
        as = null;
          goto _L5
        throwable;
        obj = as;
        as = null;
          goto _L5
        throwable;
        obj = as;
          goto _L5
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        obj = (Bitmap[])obj;
        if (d != null)
        {
            d.setImageBitmap(obj[0]);
        }
        if (e != null)
        {
            e.a(obj[0], obj[1]);
        }
        if (a != null)
        {
            a.a();
        }
    }

}
