// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v7.app.e;
import android.support.v7.aqo;
import android.support.v7.cu;
import android.support.v7.fl;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.abtnprojects.ambatana.ui.fragments.AddPhotoSelectSourceDialog;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana:
//            d

public class h extends fl
{

    private Bitmap e;

    public h(e e1, ViewSwitcher viewswitcher, ImageView imageview)
    {
        super(e1, viewswitcher, imageview);
    }

    static Bitmap a(h h1)
    {
        return h1.e;
    }

    static Bitmap a(h h1, Bitmap bitmap)
    {
        h1.e = bitmap;
        return bitmap;
    }

    static void a(h h1, int j)
    {
        h1.a(j);
    }

    public Bitmap a()
    {
        return e;
    }

    public Void a(cu cu1)
        throws Exception
    {
        cu1 = (d)cu1.e();
        aqo.a("onPostImageProcessing", new Object[0]);
        Runnable runnable = new Runnable(cu1) {

            final d a;
            final h b;

            public void run()
            {
                Object obj1 = null;
                h h1 = b;
                Object obj;
                if (a == null)
                {
                    obj = null;
                } else
                {
                    obj = a.a;
                }
                h.a(h1, ((Bitmap) (obj)));
                if (a == null)
                {
                    obj = obj1;
                } else
                {
                    obj = a.b;
                }
                if (h.a(b) != null && obj != null)
                {
                    b.a(((android.net.Uri) (obj)));
                    return;
                } else
                {
                    h.a(b, 0x7f0900a0);
                    return;
                }
            }

            
            {
                b = h.this;
                a = d1;
                super();
            }
        };
        if (a == null)
        {
            cu1 = null;
        } else
        {
            cu1 = (e)a.get();
        }
        if (cu1 != null)
        {
            cu1.runOnUiThread(runnable);
            return null;
        } else
        {
            aqo.a("activity is null", new Object[0]);
            return null;
        }
    }

    protected void b()
    {
        aqo.a("showImageView", new Object[0]);
        if (d.getCurrentView().getId() != c.getId())
        {
            d.showNext();
        }
    }

    public void c()
    {
        Object obj;
        Object obj1;
        if (a == null)
        {
            obj = null;
        } else
        {
            obj = (e)a.get();
        }
        obj1 = ((e) (obj)).f();
        obj = ((i) (obj1)).a();
        obj1 = ((i) (obj1)).a("dialog");
        if (obj1 != null)
        {
            ((m) (obj)).a(((android.support.v4.app.Fragment) (obj1)));
        }
        (new AddPhotoSelectSourceDialog()).a(((m) (obj)), "dialog");
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }
}
