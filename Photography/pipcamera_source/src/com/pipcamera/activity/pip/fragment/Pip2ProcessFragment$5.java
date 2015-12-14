// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;
import ye;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            Pip2ProcessFragment

class a
    implements ye
{

    final Bitmap a;
    final Pip2ProcessFragment b;

    public void a(Bitmap bitmap, int i)
    {
        Pip2ProcessFragment.a(b).b();
        if (a != null && !a.isRecycled())
        {
            a.recycle();
        }
        Pip2ProcessFragment.b(b).setImageBitmap(bitmap);
    }

    public void a(Exception exception)
    {
        Pip2ProcessFragment.a(b).b();
    }

    public void a_(int i)
    {
    }

    iewTouch(Pip2ProcessFragment pip2processfragment, Bitmap bitmap)
    {
        b = pip2processfragment;
        a = bitmap;
        super();
    }
}
