// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.f;

import android.graphics.Bitmap;
import com.google.a.a.e;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.f:
//            d, f, c, a

public class b
{

    public static final String TAG = com/target/ui/f/b.getSimpleName();
    private final c mNavigationFragmentManager;

    public b(c c1)
    {
        mNavigationFragmentManager = c1;
    }

    private void a(Bitmap bitmap, BaseNavigationFragment basenavigationfragment, d d1)
    {
        basenavigationfragment.a(bitmap, d1.h());
        b(basenavigationfragment, d1);
    }

    private void a(BaseNavigationFragment basenavigationfragment, d d1)
    {
        b(basenavigationfragment, d1);
    }

    private void b(BaseNavigationFragment basenavigationfragment, d d1)
    {
        BaseNavigationFragment basenavigationfragment1 = d1.e();
        if (basenavigationfragment1 != null && (basenavigationfragment1.getView() == null || basenavigationfragment1.Z()))
        {
            q.a(TAG, "Attempted to add fragment when current fragment is backgrounded.");
            return;
        }
        d1.a((f)d1.e().W().d());
        d1.b((f)basenavigationfragment.W().d());
        this;
        JVM INSTR monitorenter ;
        mNavigationFragmentManager.a(basenavigationfragment, d1);
        this;
        JVM INSTR monitorexit ;
        return;
        basenavigationfragment;
        this;
        JVM INSTR monitorexit ;
        throw basenavigationfragment;
    }

    public void a(BaseNavigationFragment basenavigationfragment, a a1)
    {
        BitmapImageView bitmapimageview = a1.a();
        if (bitmapimageview != null && bitmapimageview.getBitmap().d() != null)
        {
            a((Bitmap)bitmapimageview.getBitmap().c(), basenavigationfragment, ((d) (a1)));
            return;
        } else
        {
            a(basenavigationfragment, ((d) (a1)));
            return;
        }
    }

}
