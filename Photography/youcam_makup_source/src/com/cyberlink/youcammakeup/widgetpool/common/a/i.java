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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            h

public class i extends BaseAdapter
{

    protected Context a;
    d b;
    protected ag c;
    private final List d;
    private Bitmap e;
    private int f;
    private boolean g;

    public i(Context context, String s, List list, d d1)
    {
        Object obj;
        obj = null;
        super();
        e = null;
        f = 0;
        g = true;
        c = null;
        a = context;
        d = list;
        b = d1;
        c = new ag(a);
        context = new k(a, null);
        context.g = false;
        context.a(0.15F);
        c.a(((Activity)a).getFragmentManager(), context);
        if (e != null || s == null) goto _L2; else goto _L1
_L1:
        if (s.indexOf("assets://") != 0) goto _L4; else goto _L3
_L3:
        s = new BufferedInputStream(a.getAssets().open(s.substring("assets://".length())));
        context = s;
        list = s;
        e = BitmapFactory.decodeStream(s);
_L6:
        context = s;
        list = s;
        f = 0;
        if (s == null) goto _L2; else goto _L5
_L5:
        s.close();
_L2:
        return;
_L4:
        e = BitmapFactory.decodeFile(s);
        s = null;
          goto _L6
        context;
        m.e("PaletteAdapter", context.toString());
        return;
        s;
        list = null;
_L10:
        context = list;
        m.e("PaletteAdapter", s.toString());
        if (list == null) goto _L2; else goto _L7
_L7:
        try
        {
            list.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.e("PaletteAdapter", context.toString());
        }
        return;
        context;
        s = obj;
_L9:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("PaletteAdapter", s.toString());
            }
        }
        throw context;
        list;
        s = context;
        context = list;
        if (true) goto _L9; else goto _L8
_L8:
        s;
          goto _L10
    }

    static int a(i j, int l)
    {
        j.f = l;
        return l;
    }

    static Bitmap a(i j)
    {
        return j.e;
    }

    static Bitmap a(i j, Bitmap bitmap)
    {
        j.e = bitmap;
        return bitmap;
    }

    static int b(i j)
    {
        return j.f;
    }

    public aw a(int j)
    {
        if (d != null)
        {
            return (aw)d.get(j);
        } else
        {
            return null;
        }
    }

    public void a()
    {
        if (d != null)
        {
            d.clear();
        }
    }

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
        e = BitmapFactory.decodeStream(bufferedinputstream);
_L6:
        s = bufferedinputstream;
        bufferedinputstream1 = bufferedinputstream;
        f = 0;
        if (bufferedinputstream == null) goto _L2; else goto _L5
_L5:
        bufferedinputstream.close();
_L2:
        return;
_L4:
        e = BitmapFactory.decodeFile(s);
        bufferedinputstream = null;
          goto _L6
        s;
        m.e("PaletteAdapter", s.toString());
        return;
        Object obj;
        obj;
        bufferedinputstream1 = null;
_L10:
        s = bufferedinputstream1;
        m.e("PaletteAdapter", ((IOException) (obj)).toString());
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
            m.e("PaletteAdapter", s.toString());
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
                m.e("PaletteAdapter", ((IOException) (obj)).toString());
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
        g = flag;
    }

    public boolean areAllItemsEnabled()
    {
        return g;
    }

    public int getCount()
    {
        if (d != null)
        {
            return d.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int j)
    {
        return a(j);
    }

    public long getItemId(int j)
    {
        return 0L;
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        viewgroup = StatusManager.j().s();
        aw aw1;
        List list;
        if (view != null)
        {
            view = (com.cyberlink.youcammakeup.widgetpool.common.a.h)view;
        } else
        {
            view = new com.cyberlink.youcammakeup.widgetpool.common.a.h(a, StatusManager.j().s(), ((aw)d.get(j)).a(), b);
            view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(view) {

                final com.cyberlink.youcammakeup.widgetpool.common.a.h a;
                final i b;

                public void onLayoutChange(View view1, int l, int i1, int j1, int k1, int l1, int i2, 
                        int j2, int k2)
                {
                    if (i.a(b) == null)
                    {
                        return;
                    }
                    if (i.b(b) != view1.getWidth())
                    {
                        i.a(b, Bitmap.createScaledBitmap(i.a(b), view1.getWidth(), view1.getHeight(), true));
                        i.a(b, view1.getWidth());
                    }
                    a.setImage(i.a(b));
                }

            
            {
                b = i.this;
                a = h1;
                super();
            }
            });
        }
        aw1 = a(j);
        list = aw1.i();
        if (aw1 != null && aw1.a().equalsIgnoreCase("default_original_hair_dye"))
        {
            view.b(true);
        } else
        {
            view.b(false);
            if (viewgroup == BeautyMode.y)
            {
                ag ag1 = c;
                VenusHelper venushelper = VenusHelper.a();
                if (list != null && list.size() > 0)
                {
                    viewgroup = (at)list.get(0);
                } else
                {
                    viewgroup = new at(0);
                }
                view.a(ag1, venushelper.a(viewgroup));
            } else
            {
                view.setColors(list);
            }
        }
        view.setColorNumber(aw1.f());
        if (b != null)
        {
            viewgroup = b.b();
            String s = b.d();
            String s1 = ((aw)d.get(j)).a();
            viewgroup = h.b().a(viewgroup, s, s1);
            boolean flag;
            if (viewgroup != null)
            {
                flag = viewgroup.e();
            } else
            {
                flag = false;
            }
            view.a(flag);
        }
        if (e != null)
        {
            view.setImage(e);
        }
        return view;
    }
}
