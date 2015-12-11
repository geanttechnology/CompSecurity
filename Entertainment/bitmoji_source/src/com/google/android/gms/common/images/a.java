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
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fr;
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
            return ep.hashCode(new Object[] {
                uri
            });
        }

        public a(Uri uri1)
        {
            uri = uri1;
        }
    }


    final a AF;
    private int AG;
    private int AH;
    int AI;
    private int AJ;
    private WeakReference AK;
    private WeakReference AL;
    private WeakReference AM;
    private int AN;
    private boolean AO;
    private boolean AP;
    private int AQ;

    public com.google.android.gms.common.images.a(int i)
    {
        AG = 0;
        AH = 0;
        AN = -1;
        AO = true;
        AP = false;
        AF = new a(null);
        AH = i;
    }

    public com.google.android.gms.common.images.a(Uri uri)
    {
        AG = 0;
        AH = 0;
        AN = -1;
        AO = true;
        AP = false;
        AF = new a(uri);
        AH = 0;
    }

    private ea a(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof ea)
            {
                drawable2 = ((ea)drawable).dO();
            }
        } else
        {
            drawable2 = null;
        }
        return new ea(drawable2, drawable1);
    }

    private void a(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
    {
        AI;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 72
    //                   3 101;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        ImageManager.OnImageLoadedListener onimageloadedlistener;
        if (!flag1 && (onimageloadedlistener = (ImageManager.OnImageLoadedListener)AK.get()) != null)
        {
            onimageloadedlistener.onImageLoaded(AF.uri, drawable, flag2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ImageView imageview = (ImageView)AL.get();
        if (imageview != null)
        {
            a(imageview, drawable, flag, flag1, flag2);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        TextView textview = (TextView)AM.get();
        if (textview != null)
        {
            a(textview, AN, drawable, flag, flag1);
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
        if (!flag3 || !(imageview instanceof ec)) goto _L2; else goto _L1
_L1:
        j = ((ec)imageview).dQ();
        if (AH == 0 || j != AH) goto _L2; else goto _L3
_L3:
        return;
_L2:
        flag = b(flag, flag1);
        if (flag)
        {
            drawable = a(imageview.getDrawable(), drawable);
        }
        imageview.setImageDrawable(drawable);
        if (imageview instanceof ec)
        {
            ec ec1 = (ec)imageview;
            int i;
            if (flag2)
            {
                imageview = AF.uri;
            } else
            {
                imageview = null;
            }
            ec1.d(imageview);
            if (flag3)
            {
                i = AH;
            } else
            {
                i = 0;
            }
            ec1.N(i);
        }
        if (flag)
        {
            ((ea)drawable).startTransition(250);
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    private void a(TextView textview, int i, Drawable drawable, boolean flag, boolean flag1)
    {
        flag = b(flag, flag1);
        Object obj;
        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        if (fr.eO())
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
        if (fr.eO())
        {
            textview.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
        } else
        {
            textview.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
        }
        if (flag)
        {
            ((ea)drawable).startTransition(250);
        }
    }

    private boolean b(boolean flag, boolean flag1)
    {
        return AO && !flag1 && (!flag || AP);
    }

    public void L(int i)
    {
        AH = i;
    }

    void a(Context context, Bitmap bitmap, boolean flag)
    {
        ed.d(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((AQ & 1) != 0)
        {
            bitmap1 = eb.a(bitmap);
        }
        a(((Drawable) (new BitmapDrawable(context.getResources(), bitmap1))), flag, false, true);
    }

    public void a(ImageView imageview)
    {
        ed.d(imageview);
        AK = null;
        AL = new WeakReference(imageview);
        AM = null;
        AN = -1;
        AI = 2;
        AJ = imageview.hashCode();
    }

    public void a(ImageManager.OnImageLoadedListener onimageloadedlistener)
    {
        ed.d(onimageloadedlistener);
        AK = new WeakReference(onimageloadedlistener);
        AL = null;
        AM = null;
        AN = -1;
        AI = 1;
        AJ = ep.hashCode(new Object[] {
            onimageloadedlistener, AF
        });
    }

    void b(Context context, boolean flag)
    {
        Object obj = null;
        if (AH != 0)
        {
            Resources resources = context.getResources();
            context = resources.getDrawable(AH);
            obj = context;
            if ((AQ & 1) != 0)
            {
                obj = eb.a(resources, context);
            }
        }
        a(((Drawable) (obj)), flag, false, false);
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
        return AJ;
    }

    void x(Context context)
    {
        Object obj = null;
        if (AG != 0)
        {
            Resources resources = context.getResources();
            context = resources.getDrawable(AG);
            obj = context;
            if ((AQ & 1) != 0)
            {
                obj = eb.a(resources, context);
            }
        }
        a(((Drawable) (obj)), false, true, false);
    }
}
