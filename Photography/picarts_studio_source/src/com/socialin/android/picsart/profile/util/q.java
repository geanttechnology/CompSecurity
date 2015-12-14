// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.d;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.util.w;
import myobfuscated.cd.a;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            p

final class q
    implements d
{

    private p a;

    private q(p p1)
    {
        a = p1;
        super();
    }

    q(p p1, byte byte0)
    {
        this(p1);
    }

    public final boolean a(Object obj)
    {
        obj = w.e((Bitmap)obj);
        if (obj != null)
        {
            a.f.setImageDrawable(new a(a.c.getResources(), ((Bitmap) (obj))));
        } else
        {
            a.f.setImageResource(0x7f020669);
        }
        return false;
    }
}
