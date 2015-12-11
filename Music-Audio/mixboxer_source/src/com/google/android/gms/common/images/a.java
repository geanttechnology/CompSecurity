// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fg;
import java.lang.ref.WeakReference;

public final class com.google.android.gms.common.images.a
{
    public static final class a
    {

        public final Uri uri;

        public boolean equals(Object obj)
        {
            boolean flag1 = true;
            boolean flag;
            if (!(obj instanceof a))
            {
                flag = false;
            } else
            {
                flag = flag1;
                if (this != obj)
                {
                    flag = flag1;
                    if (((a)obj).hashCode() != hashCode())
                    {
                        return false;
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return ee.hashCode(new Object[] {
                uri
            });
        }

        public a(Uri uri1)
        {
            uri = uri1;
        }
    }


    final a op;
    private int oq;
    private int or;
    int os;
    private int ot;
    private WeakReference ou;
    private WeakReference ov;
    private WeakReference ow;
    private int ox;
    private boolean oy;
    private boolean oz;

    public com.google.android.gms.common.images.a(int i)
    {
        oq = 0;
        or = 0;
        ox = -1;
        oy = true;
        oz = false;
        op = new a(null);
        or = i;
    }

    public com.google.android.gms.common.images.a(Uri uri)
    {
        oq = 0;
        or = 0;
        ox = -1;
        oy = true;
        oz = false;
        op = new a(uri);
        or = 0;
    }

    private dq a(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof dq)
            {
                drawable2 = ((dq)drawable).bC();
            }
        } else
        {
            drawable2 = null;
        }
        return new dq(drawable2, drawable1);
    }

    private void a(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
    {
        os;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 72
    //                   3 101;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        ImageManager.OnImageLoadedListener onimageloadedlistener;
        if (!flag1 && (onimageloadedlistener = (ImageManager.OnImageLoadedListener)ou.get()) != null)
        {
            onimageloadedlistener.onImageLoaded(op.uri, drawable, flag2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ImageView imageview = (ImageView)ov.get();
        if (imageview != null)
        {
            a(imageview, drawable, flag, flag1, flag2);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        TextView textview = (TextView)ow.get();
        if (textview != null)
        {
            a(textview, ox, drawable, flag, flag1);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(ImageView imageview, Drawable drawable, boolean flag, boolean flag1, boolean flag2)
    {
        boolean flag3;
        int j;
        if (!flag1 && !flag2)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (!flag3 || !(imageview instanceof dr)) goto _L2; else goto _L1
_L1:
        j = ((dr)imageview).bE();
        if (or == 0 || j != or) goto _L2; else goto _L3
_L3:
        return;
_L2:
        flag = a(flag, flag1);
        if (flag)
        {
            drawable = a(imageview.getDrawable(), drawable);
        }
        imageview.setImageDrawable(drawable);
        if (imageview instanceof dr)
        {
            dr dr1 = (dr)imageview;
            int i;
            if (flag2)
            {
                imageview = op.uri;
            } else
            {
                imageview = null;
            }
            dr1.d(imageview);
            if (flag3)
            {
                i = or;
            } else
            {
                i = 0;
            }
            dr1.H(i);
        }
        if (flag)
        {
            ((dq)drawable).startTransition(250);
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    private void a(TextView textview, int i, Drawable drawable, boolean flag, boolean flag1)
    {
        flag = a(flag, flag1);
        Object obj;
        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        if (fg.cI())
        {
            obj = textview.getCompoundDrawablesRelative();
        } else
        {
            obj = textview.getCompoundDrawables();
        }
        drawable1 = obj[i];
        if (flag)
        {
            drawable = a(drawable1, drawable);
        }
        if (i == 0)
        {
            drawable1 = drawable;
        } else
        {
            drawable1 = obj[0];
        }
        if (i == 1)
        {
            drawable2 = drawable;
        } else
        {
            drawable2 = obj[1];
        }
        if (i == 2)
        {
            drawable3 = drawable;
        } else
        {
            drawable3 = obj[2];
        }
        if (i == 3)
        {
            obj = drawable;
        } else
        {
            obj = obj[3];
        }
        if (fg.cI())
        {
            textview.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
        } else
        {
            textview.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
        }
        if (flag)
        {
            ((dq)drawable).startTransition(250);
        }
    }

    private boolean a(boolean flag, boolean flag1)
    {
        return oy && !flag1 && (!flag || oz);
    }

    public void F(int i)
    {
        or = i;
    }

    void a(Context context, Bitmap bitmap, boolean flag)
    {
        ds.d(bitmap);
        a(((Drawable) (new BitmapDrawable(context.getResources(), bitmap))), flag, false, true);
    }

    public void a(ImageView imageview)
    {
        ds.d(imageview);
        ou = null;
        ov = new WeakReference(imageview);
        ow = null;
        ox = -1;
        os = 2;
        ot = imageview.hashCode();
    }

    public void a(ImageManager.OnImageLoadedListener onimageloadedlistener)
    {
        ds.d(onimageloadedlistener);
        ou = new WeakReference(onimageloadedlistener);
        ov = null;
        ow = null;
        ox = -1;
        os = 1;
        ot = ee.hashCode(new Object[] {
            onimageloadedlistener, op
        });
    }

    void b(Context context, boolean flag)
    {
        Drawable drawable = null;
        if (or != 0)
        {
            drawable = context.getResources().getDrawable(or);
        }
        a(drawable, flag, false, false);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        boolean flag;
        if (!(obj instanceof com.google.android.gms.common.images.a))
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (this != obj)
            {
                flag = flag1;
                if (((com.google.android.gms.common.images.a)obj).hashCode() != hashCode())
                {
                    return false;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ot;
    }

    void r(Context context)
    {
        Drawable drawable = null;
        if (oq != 0)
        {
            drawable = context.getResources().getDrawable(oq);
        }
        a(drawable, false, true, false);
    }
}
