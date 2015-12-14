// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.TouchImageView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            AsyncTask, m

public class r extends AsyncTask
{

    private static final p d = c.f();
    private Bitmap e;
    private final TouchImageView f;
    private final long g;
    private final d h;

    public r(TouchImageView touchimageview, long l)
    {
        this(touchimageview, l, new d() {

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

    public r(TouchImageView touchimageview, long l, d d1)
    {
        f = touchimageview;
        g = l;
        h = d1;
    }

    protected transient Boolean a(Void avoid[])
    {
        if (c())
        {
            return Boolean.valueOf(false);
        }
        long l = g;
        avoid = c.f().g(l);
        if (avoid != null)
        {
            e = m.a(avoid, false);
        }
        return Boolean.valueOf(true);
    }

    protected volatile Object a(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void a(Boolean boolean1)
    {
        long l = f.getImageId();
        if (g != l)
        {
            h.b();
            return;
        }
        if (!boolean1.booleanValue())
        {
            h.b();
            return;
        } else
        {
            f.setImageBitmap(e);
            h.a();
            return;
        }
    }

    protected volatile void a(Object obj)
    {
        a((Boolean)obj);
    }

    protected void b()
    {
        h.c();
    }

}
