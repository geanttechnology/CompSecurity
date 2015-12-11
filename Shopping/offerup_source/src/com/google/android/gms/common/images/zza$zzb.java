// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlu;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.common.images:
//            zza

public final class zzaee extends zza
{

    private WeakReference zzaee;

    private void zza(ImageView imageview, Drawable drawable, boolean flag, boolean flag1, boolean flag2)
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
        if (!flag3 || !(imageview instanceof zzlu)) goto _L2; else goto _L1
_L1:
        j = ((zzlu)imageview).zzoH();
        if (zzadX == 0 || j != zzadX) goto _L2; else goto _L3
_L3:
        return;
_L2:
        flag = zzb(flag, flag1);
        if (zzadY && drawable != null)
        {
            drawable = drawable.getConstantState().newDrawable();
        }
        Object obj = drawable;
        if (flag)
        {
            obj = zza(imageview.getDrawable(), drawable);
        }
        imageview.setImageDrawable(((Drawable) (obj)));
        if (imageview instanceof zzlu)
        {
            drawable = (zzlu)imageview;
            int i;
            if (flag2)
            {
                imageview = zzadV.uri;
            } else
            {
                imageview = null;
            }
            drawable.zzj(imageview);
            if (flag3)
            {
                i = zzadX;
            } else
            {
                i = 0;
            }
            drawable.zzbA(i);
        }
        if (flag)
        {
            ((zzls)obj).startTransition(250);
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof nsition))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        Object obj1 = (nsition)obj;
        obj = (ImageView)zzaee.get();
        obj1 = (ImageView)((zzaee) (obj1)).zzaee.get();
        return obj1 != null && obj != null && zzw.equal(obj1, obj);
    }

    public final int hashCode()
    {
        return 0;
    }

    protected final void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
    {
        ImageView imageview = (ImageView)zzaee.get();
        if (imageview != null)
        {
            zza(imageview, drawable, flag, flag1, flag2);
        }
    }

    public ate(ImageView imageview, int i)
    {
        super(null, i);
        zzb.zzs(imageview);
        zzaee = new WeakReference(imageview);
    }

    public zzaee(ImageView imageview, Uri uri)
    {
        super(uri, 0);
        zzb.zzs(imageview);
        zzaee = new WeakReference(imageview);
    }
}
