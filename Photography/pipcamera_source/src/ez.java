// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.comlib.util.AsyncTask;
import java.lang.ref.WeakReference;

class ez extends AsyncTask
{

    final ex a;
    private final WeakReference b;
    private Object c;
    private int d;
    private int e;
    private Context f;

    public ez(ex ex1, Context context, ImageView imageview, int i, int j)
    {
        a = ex1;
        super();
        c = Integer.valueOf(0);
        f = context;
        d = i;
        e = j;
        b = new WeakReference(imageview);
    }

    static Object a(ez ez1)
    {
        return ez1.c;
    }

    protected transient Bitmap a(Object aobj[])
    {
        c = aobj[0];
        if (c instanceof String)
        {
            return ev.a((String)c, d, e);
        }
        if (c instanceof Integer)
        {
            return ev.a(f.getResources(), ((Integer)c).intValue(), d, e);
        } else
        {
            return null;
        }
    }

    protected void a(Bitmap bitmap)
    {
        if (isCancelled())
        {
            bitmap = null;
        }
        if (b != null && bitmap != null)
        {
            ImageView imageview = (ImageView)b.get();
            if (this == ex.a(imageview) && imageview != null)
            {
                imageview.setImageBitmap(bitmap);
            }
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }
}
