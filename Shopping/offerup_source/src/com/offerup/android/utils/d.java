// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.b.a.a.g;
import com.offerup.android.c.a;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

// Referenced classes of package com.offerup.android.utils:
//            g, e, j, h, 
//            f, al, i

public final class d
{

    Context a;
    private com.offerup.android.utils.g b;
    private e c;
    private j d;
    private Long e;
    private ArrayList f;
    private final Object g = new Object();

    public d(Context context, Long long1)
    {
        f = new ArrayList(com.offerup.android.c.a.a());
        a = context.getApplicationContext();
        e = long1;
    }

    private Bitmap a(Uri uri)
    {
        Object obj2 = null;
        Object obj = a.getApplicationContext().getContentResolver().openInputStream(uri);
        Object obj1 = obj;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        obj1 = obj;
        options.inJustDecodeBounds = true;
        obj1 = obj;
        BitmapFactory.decodeStream(((InputStream) (obj)), null, options);
        obj1 = obj;
        ((InputStream) (obj)).close();
        obj1 = obj;
        int i = Math.min(800, options.outWidth);
        obj1 = obj;
        int k = Math.min(800, options.outHeight);
        obj1 = obj;
        uri = Picasso.with(a).load(uri).resize(i, k).centerInside().skipMemoryCache().get();
        obj1 = uri;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.b.a.a.g.a(this, ((Throwable) (obj)));
                return uri;
            }
            obj1 = uri;
        }
_L2:
        return ((Bitmap) (obj1));
        uri;
        obj = null;
_L5:
        obj1 = obj;
        com.b.a.a.g.a(this, uri);
        obj1 = obj2;
        if (obj == null) goto _L2; else goto _L1
_L1:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.b.a.a.g.a(this, uri);
            return null;
        }
        return null;
        uri;
        obj1 = null;
_L4:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (IOException ioexception)
            {
                com.b.a.a.g.a(this, ioexception);
            }
        }
        throw uri;
        uri;
        if (true) goto _L4; else goto _L3
_L3:
        uri;
          goto _L5
    }

    private Bitmap a(Uri uri, int i, int k)
    {
        try
        {
            uri = Picasso.with(a).load(uri).resize(i, k).centerInside().get();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.b.a.a.g.a(this, uri);
            return null;
        }
        return uri;
    }

    static Bitmap a(d d1, Uri uri, int i)
    {
        return d1.a(uri);
    }

    static Bitmap a(d d1, Uri uri, int i, int k)
    {
        return d1.a(uri, i, k);
    }

    static Uri a(d d1, int i)
    {
        return d1.b(i);
    }

    private Uri b(int i)
    {
        Object obj1 = g;
        obj1;
        JVM INSTR monitorenter ;
        if (i >= f.size()) goto _L2; else goto _L1
_L1:
        Object obj = (Uri)f.get(i);
_L4:
        return ((Uri) (obj));
_L2:
        obj = a.getExternalFilesDir(null);
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        long l = 0L;
_L5:
        obj = Uri.fromFile(new File(((File) (obj)), String.format("%d_%s.jpg", new Object[] {
            Long.valueOf(l), UUID.randomUUID()
        })));
        f.add(obj);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        l = e.longValue();
          goto _L5
    }

    public final void a()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        Object obj1;
        if (i >= f.size())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj1 = (Uri)f.get(i);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj1 = new File(((Uri) (obj1)).getPath());
        if (((File) (obj1)).exists())
        {
            ((File) (obj1)).delete();
        }
        break MISSING_BLOCK_LABEL_78;
        f.clear();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(int i)
    {
        synchronized (g)
        {
            if (f.size() > i)
            {
                File file = new File(((Uri)f.get(i)).getPath());
                f.remove(i);
                file.delete();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, int k)
    {
        synchronized (g)
        {
            if (f.size() > 0 && k < f.size())
            {
                Collections.swap(f, 0, k);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            com.b.a.a.g.a(this, indexoutofboundsexception);
        }
        return;
    }

    public final void a(Uri uri, int i, int k, h h)
    {
        c();
        b = new com.offerup.android.utils.g(this, uri, i, k, h);
        b.execute(new Void[0]);
    }

    public final void a(Uri uri, int i, f f1)
    {
        d();
        c = new e(this, uri, i, f1);
        c.execute(new Void[0]);
    }

    public final void a(al al, i i)
    {
        e();
        d = new j(this, al, i);
        d.execute(new Object[0]);
    }

    public final void a(ArrayList arraylist)
    {
        synchronized (g)
        {
            f = arraylist;
        }
        return;
        arraylist;
        obj;
        JVM INSTR monitorexit ;
        throw arraylist;
    }

    public final ArrayList b()
    {
        ArrayList arraylist;
        synchronized (g)
        {
            arraylist = f;
        }
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c()
    {
        if (b != null && b.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            b.cancel(false);
        }
        b = null;
    }

    public final void d()
    {
        if (c != null && c.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            c.cancel(false);
        }
        c = null;
    }

    public final void e()
    {
        if (d != null && d.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            d.cancel(false);
        }
        d = null;
    }

    public final Long f()
    {
        return e;
    }
}
