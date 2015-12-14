// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.d;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.pages.librarypicker.photopage.b;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            ItemView, b

public class a extends com.cyberlink.youcammakeup.pages.libraryview.a
{

    private static final p b = com.cyberlink.youcammakeup.c.f();
    private final ItemView c;
    private final long d;
    private final com.cyberlink.youcammakeup.d e;
    private final ViewEngine f;
    private Bitmap g;

    public a(ItemView itemview, long l)
    {
        this(itemview, l, new com.cyberlink.youcammakeup.d() {

            public void a()
            {
            }

            public void b()
            {
            }

            public void c()
            {
            }

        });
    }

    public a(ItemView itemview, long l, com.cyberlink.youcammakeup.d d1)
    {
        f = ViewEngine.a();
        c = itemview;
        d = l;
        e = d1;
    }

    private Bitmap a()
    {
        Object obj = b.c(d);
        if (obj == null)
        {
            return null;
        }
        long l = ((r) (obj)).f();
        obj = Globals.d().getContentResolver();
        Bitmap bitmap;
        try
        {
            bitmap = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((android.content.ContentResolver) (obj)), l, 1, null);
        }
        catch (Exception exception1)
        {
            Bitmap bitmap1;
            try
            {
                bitmap1 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((android.content.ContentResolver) (obj)), l, 1, null);
            }
            catch (Exception exception2)
            {
                try
                {
                    obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((android.content.ContentResolver) (obj)), l, 1, null);
                }
                catch (Exception exception)
                {
                    m.e("ImageLoadTask", "trySystemThumbnail::cannot load thumbnail");
                    return null;
                }
                return ((Bitmap) (obj));
            }
            return bitmap1;
        }
        return bitmap;
    }

    protected transient Boolean a(Void avoid[])
    {
        Bitmap bitmap;
        r r1;
        long l1;
        if (isCancelled())
        {
            return Boolean.valueOf(false);
        }
        l1 = d;
        r1 = b.c(l1);
        if (r1 == null)
        {
            return Boolean.valueOf(false);
        }
        bitmap = a();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        avoid = new Matrix();
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[UIImageOrientation.values().length];
                try
                {
                    a[UIImageOrientation.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[UIImageOrientation.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[UIImageOrientation.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[UIImageOrientation.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[UIImageOrientation.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[UIImageOrientation.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[UIImageOrientation.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[UIImageOrientation.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[UIImageOrientation.i.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[r1.d().ordinal()];
        JVM INSTR tableswitch 3 9: default 108
    //                   3 126
    //                   4 136
    //                   5 145
    //                   6 155
    //                   7 162
    //                   8 171
    //                   9 178;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_178;
_L1:
        avoid = null;
_L9:
        if (avoid == null)
        {
            avoid = bitmap;
        } else
        {
            avoid = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), avoid, false);
        }
        g = avoid;
        return Boolean.valueOf(true);
_L2:
        avoid.setScale(-1F, 1.0F);
          goto _L9
_L3:
        avoid.setRotate(180F);
          goto _L9
_L4:
        avoid.setScale(1.0F, -1F);
          goto _L9
_L5:
        avoid.setScale(-1F, 1.0F);
_L6:
        avoid.setRotate(90F);
          goto _L9
_L7:
        avoid.setScale(-1F, 1.0F);
        avoid.setRotate(270F);
          goto _L9
        long l;
        avoid = d.a;
        l = -1L;
        if (!(c instanceof b)) goto _L11; else goto _L10
_L10:
        l = 256L;
        avoid = d.c;
_L13:
        avoid = f.a(l1, a, l, avoid);
        if (avoid == null)
        {
            return Boolean.valueOf(false);
        }
        break; /* Loop/switch isn't completed */
_L11:
        if (c instanceof com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b)
        {
            l = 64L;
            avoid = d.d;
        }
        if (true) goto _L13; else goto _L12
_L12:
        if (isCancelled())
        {
            return Boolean.valueOf(false);
        }
        Bitmap bitmap1 = Bitmap.createBitmap((int)avoid.b(), (int)avoid.c(), android.graphics.Bitmap.Config.ARGB_8888);
        if (isCancelled())
        {
            return Boolean.valueOf(false);
        }
        avoid.c(bitmap1);
        avoid.m();
        if (bitmap1 != null)
        {
            g = bitmap1;
        }
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        com.cyberlink.youcammakeup.pages.librarypicker.b b1 = c.getItem();
        long l = b1.b();
        if (d != l)
        {
            e.b();
            return;
        }
        if (!boolean1.booleanValue())
        {
            b1.a(com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.e);
            e.b();
            return;
        } else
        {
            b1.a(com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.b);
            c.getImageView().setImageBitmap(g);
            e.a();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        c.getItem().a(com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.d);
        e.c();
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

}
