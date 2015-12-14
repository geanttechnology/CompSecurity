// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            f

public abstract class c extends BaseAdapter
{

    protected Context a;
    protected Bitmap b;
    protected int c;
    protected ag d;
    private boolean e;

    public c(Context context, String s)
    {
        b = null;
        c = 0;
        d = null;
        e = true;
        a = context;
        a(s);
        d = new ag(a);
        context = new k(a, null);
        context.g = false;
        context.a(0.15F);
        d.a(((Activity)a).getFragmentManager(), context);
    }

    protected f a(View view, BeautyMode beautymode)
    {
        if (view != null)
        {
            view = (f)view;
        } else
        {
            view = a(beautymode);
            view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(view) {

                final f a;
                final c b;

                public void onLayoutChange(View view1, int i, int j, int l, int i1, int j1, int k1, 
                        int l1, int i2)
                {
                    if (b.b == null)
                    {
                        return;
                    }
                    if (b.c != view1.getWidth())
                    {
                        b.b = Bitmap.createScaledBitmap(b.b, view1.getWidth(), view1.getHeight(), true);
                        b.c = view1.getWidth();
                    }
                    a.setImage(b.b);
                }

            
            {
                b = c.this;
                a = f1;
                super();
            }
            });
        }
        if (b != null)
        {
            view.setImage(b);
        }
        return view;
    }

    protected abstract f a(BeautyMode beautymode);

    public abstract void a();

    public void a(String s)
    {
        BufferedInputStream bufferedinputstream1 = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.indexOf("assets://") != 0) goto _L4; else goto _L3
_L3:
        BufferedInputStream bufferedinputstream = new BufferedInputStream(a.getAssets().open(s.substring("assets://".length())));
        s = bufferedinputstream;
        bufferedinputstream1 = bufferedinputstream;
        b = BitmapFactory.decodeStream(bufferedinputstream);
_L6:
        s = bufferedinputstream;
        bufferedinputstream1 = bufferedinputstream;
        c = 0;
        if (bufferedinputstream == null) goto _L2; else goto _L5
_L5:
        bufferedinputstream.close();
_L2:
        return;
_L4:
        b = BitmapFactory.decodeFile(s);
        bufferedinputstream = null;
          goto _L6
        s;
        m.b("BaseColorAdapter", "setTexture::close", s);
        return;
        Object obj;
        obj;
        bufferedinputstream1 = null;
_L10:
        s = bufferedinputstream1;
        m.b("BaseColorAdapter", "setTexture::decode", ((Throwable) (obj)));
        if (bufferedinputstream1 == null) goto _L2; else goto _L7
_L7:
        try
        {
            bufferedinputstream1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.b("BaseColorAdapter", "setTexture::close", s);
        }
        return;
        s;
        obj = bufferedinputstream1;
_L9:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                m.b("BaseColorAdapter", "setTexture::close", ((Throwable) (obj)));
            }
        }
        throw s;
        Exception exception;
        exception;
        obj = s;
        s = exception;
        if (true) goto _L9; else goto _L8
_L8:
        obj;
          goto _L10
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public boolean areAllItemsEnabled()
    {
        return e;
    }
}
