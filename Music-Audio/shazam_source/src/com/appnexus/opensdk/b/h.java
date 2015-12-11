// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

// Referenced classes of package com.appnexus.opensdk.b:
//            k, b

public final class h
{
    public final class a extends AsyncTask
    {

        WeakReference a;
        WeakReference b;
        String c;
        final h d;

        private transient Bitmap a()
        {
            if (isCancelled())
            {
                return null;
            }
            Bitmap bitmap;
            try
            {
                Object obj = (new URL(c)).openConnection();
                ((URLConnection) (obj)).setReadTimeout(10000);
                obj = (InputStream)((URLConnection) (obj)).getContent();
                bitmap = BitmapFactory.decodeStream(((InputStream) (obj)));
                ((InputStream) (obj)).close();
            }
            catch (Exception exception)
            {
                return null;
            }
            return bitmap;
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final void onCancelled()
        {
            super.onCancelled();
            b.clear();
            a.clear();
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (Bitmap)obj;
            b b1 = (b)b.get();
            h h1 = (h)a.get();
            if (b1 != null)
            {
                if (obj == null)
                {
                    b1.a();
                } else
                {
                    b1.a(((Bitmap) (obj)));
                }
            }
            if (h1 != null && h1.a != null && h1.a.containsKey(b1))
            {
                h1.a.remove(b1);
                if (h1.a.size() == 0)
                {
                    h1.b.d();
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, "Images downloading finished.");
                    h1.a();
                }
            }
        }

        public a(b b1, String s, h h2)
        {
            d = h.this;
            super();
            a = new WeakReference(h2);
            b = new WeakReference(b1);
            c = s;
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(Bitmap bitmap);
    }

    public static interface c
    {

        public abstract void d();
    }


    public HashMap a;
    public c b;

    public h()
    {
        a = new HashMap();
    }

    public final void a()
    {
        a = null;
        b = null;
    }

    public final void a(b b1, String s)
    {
        if (!k.a(s))
        {
            a.put(b1, s);
        }
    }
}
