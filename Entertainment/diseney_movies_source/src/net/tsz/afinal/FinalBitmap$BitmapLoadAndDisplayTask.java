// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import net.tsz.afinal.bitmap.core.BitmapCache;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.display.Displayer;
import net.tsz.afinal.core.AsyncTask;

// Referenced classes of package net.tsz.afinal:
//            FinalBitmap

private class displayConfig extends AsyncTask
{

    private Object data;
    private final BitmapDisplayConfig displayConfig;
    private final WeakReference imageViewReference;
    final FinalBitmap this$0;

    private ImageView getAttachedImageView()
    {
        ImageView imageview = (ImageView)imageViewReference.get();
        if (this == FinalBitmap.access$15(imageview))
        {
            return imageview;
        } else
        {
            return null;
        }
    }

    protected transient Bitmap doInBackground(Object aobj[])
    {
        Object obj;
        String s;
        data = aobj[0];
        s = String.valueOf(data);
        obj = null;
        aobj = ((Object []) (FinalBitmap.access$9(FinalBitmap.this)));
        aobj;
        JVM INSTR monitorenter ;
_L2:
        if (FinalBitmap.access$10(FinalBitmap.this) && !isCancelled())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        aobj = ((Object []) (obj));
        if (FinalBitmap.access$11() != null)
        {
            aobj = ((Object []) (obj));
            if (!isCancelled())
            {
                aobj = ((Object []) (obj));
                if (getAttachedImageView() != null)
                {
                    aobj = ((Object []) (obj));
                    if (!FinalBitmap.access$12(FinalBitmap.this))
                    {
                        aobj = FinalBitmap.access$11().getBitmapFromDiskCache(s);
                    }
                }
            }
        }
        obj = ((Object) (aobj));
        if (aobj == null)
        {
            obj = ((Object) (aobj));
            if (!isCancelled())
            {
                obj = ((Object) (aobj));
                if (getAttachedImageView() != null)
                {
                    obj = ((Object) (aobj));
                    if (!FinalBitmap.access$12(FinalBitmap.this))
                    {
                        obj = FinalBitmap.access$13(FinalBitmap.this, s, displayConfig);
                    }
                }
            }
        }
        if (obj != null && FinalBitmap.access$11() != null)
        {
            FinalBitmap.access$11().addBitmapToCache(s, ((Bitmap) (obj)));
        }
        return ((Bitmap) (obj));
        Exception exception;
        try
        {
            FinalBitmap.access$9(FinalBitmap.this).wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L2; else goto _L1
_L1:
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Object[])aobj);
    }

    protected void onCancelled(Bitmap bitmap)
    {
        super.onCancelled(bitmap);
        synchronized (FinalBitmap.access$9(FinalBitmap.this))
        {
            FinalBitmap.access$9(FinalBitmap.this).notifyAll();
        }
        return;
        exception;
        bitmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Bitmap)obj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        if (isCancelled() || FinalBitmap.access$12(FinalBitmap.this))
        {
            bitmap = null;
        }
        ImageView imageview = getAttachedImageView();
        if (bitmap != null && imageview != null)
        {
            FinalBitmap.access$14(FinalBitmap.this).er.loadCompletedisplay(imageview, bitmap, displayConfig);
        } else
        if (bitmap == null && imageview != null)
        {
            FinalBitmap.access$14(FinalBitmap.this).er.loadFailDisplay(imageview, displayConfig.getLoadfailBitmap());
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }


    public _cls9(ImageView imageview, BitmapDisplayConfig bitmapdisplayconfig)
    {
        this$0 = FinalBitmap.this;
        super();
        imageViewReference = new WeakReference(imageview);
        displayConfig = bitmapdisplayconfig;
    }
}
