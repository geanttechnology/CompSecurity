// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.fp;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.hx;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.common.images:
//            e

public final class d
{

    final e a;
    int b;
    int c;
    private int d;
    private WeakReference e;
    private WeakReference f;
    private WeakReference g;
    private int h;
    private boolean i;

    private static fp a(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof fp)
            {
                drawable2 = ((fp)drawable).a;
            }
        } else
        {
            drawable2 = null;
        }
        return new fp(drawable2, drawable1);
    }

    private boolean a()
    {
        return i;
    }

    final void a(Drawable drawable, boolean flag)
    {
        int j = 1;
        c;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 42
    //                   3 202;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        e.get();
        return;
_L3:
        ImageView imageview = (ImageView)f.get();
        if (imageview == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ft ft1;
        int l;
        boolean flag1;
        if (flag)
        {
            j = 0;
        }
        if (j == 0 || !(imageview instanceof ft))
        {
            break; /* Loop/switch isn't completed */
        }
        l = ((ft)imageview).b;
        if (b != 0 && l == b) goto _L1; else goto _L5
_L5:
        flag1 = a();
        if (flag1)
        {
            drawable = a(imageview.getDrawable(), drawable);
        }
        imageview.setImageDrawable(drawable);
        if (imageview instanceof ft)
        {
            ft1 = (ft)imageview;
            android.net.Uri uri;
            if (flag)
            {
                uri = a.a;
            } else
            {
                uri = null;
            }
            ft1.a = uri;
            if (j != 0)
            {
                j = b;
            } else
            {
                j = 0;
            }
            ft1.b = j;
        }
        if (flag1)
        {
            ((fp)drawable).a();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        TextView textview = (TextView)g.get();
        if (textview != null)
        {
            int k = h;
            flag = a();
            Object obj;
            Drawable drawable1;
            Drawable drawable2;
            Drawable drawable3;
            if (hx.a(17))
            {
                obj = textview.getCompoundDrawablesRelative();
            } else
            {
                obj = textview.getCompoundDrawables();
            }
            drawable1 = obj[k];
            if (flag)
            {
                drawable = a(drawable1, drawable);
            }
            if (k == 0)
            {
                drawable1 = drawable;
            } else
            {
                drawable1 = obj[0];
            }
            if (k == 1)
            {
                drawable2 = drawable;
            } else
            {
                drawable2 = obj[1];
            }
            if (k == 2)
            {
                drawable3 = drawable;
            } else
            {
                drawable3 = obj[2];
            }
            if (k == 3)
            {
                obj = drawable;
            } else
            {
                obj = obj[3];
            }
            if (hx.a(17))
            {
                textview.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
            } else
            {
                textview.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, ((Drawable) (obj)));
            }
            if (flag)
            {
                ((fp)drawable).a();
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof d)
        {
            if (this == obj)
            {
                return true;
            }
            if (((d)obj).hashCode() == hashCode())
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return d;
    }
}
