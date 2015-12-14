// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.request.d;

// Referenced classes of package com.picsart.shop:
//            m, n

final class 
    implements Runnable
{

    private a a;

    public final void run()
    {
        m.m(a.a).removeItemDecoration(m.l(a.a));
        m.l(a.a).a = m.h(a.a).getMeasuredHeight();
        m.m(a.a).addItemDecoration(m.l(a.a));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/picsart/shop/m$8

/* anonymous class */
    final class m._cls8
        implements d
    {

        final m a;

        public final boolean a(Object obj)
        {
            obj = (Bitmap)obj;
            Activity activity = a.getActivity();
            if (activity != null && !activity.isFinishing())
            {
                m m1 = a;
                int i;
                if (obj == null)
                {
                    i = 0;
                } else
                {
                    i = m.i(a);
                }
                m.b(m1, i);
                if (m.i(a) != m.k(a))
                {
                    m.g(a).getLayoutParams().height = m.i(a);
                    m.h(a).post(new m._cls8._cls1(this));
                    return false;
                }
            }
            return false;
        }

            
            {
                a = m1;
                super();
            }
    }

}
