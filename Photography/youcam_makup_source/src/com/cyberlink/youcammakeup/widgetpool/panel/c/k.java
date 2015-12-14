// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.common.a.f;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class k extends BaseAdapter
{

    private int a;
    private Context b;
    private List c;
    private List d;
    private Bitmap e;
    private int f;
    private boolean g;

    public k(Context context, BeautyMode beautymode)
    {
        a = 0;
        e = null;
        f = 0;
        g = true;
        b = context;
        c = new ArrayList();
        d = new ArrayList();
        context = Arrays.asList(new String[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b.toString()
        });
        beautymode = PanelDataCenter.a().a(context, beautymode).iterator();
        while (beautymode.hasNext()) 
        {
            aw aw1 = (aw)beautymode.next();
            context = aw1.i();
            if (context.size() > 0)
            {
                context = (at)context.get(0);
            } else
            {
                context = new at(0);
            }
            c.add(context);
            d.add(aw1.a());
        }
        b();
    }

    static int a(k k1, int i)
    {
        k1.f = i;
        return i;
    }

    static Bitmap a(k k1)
    {
        return k1.e;
    }

    static Bitmap a(k k1, Bitmap bitmap)
    {
        k1.e = bitmap;
        return bitmap;
    }

    static int b(k k1)
    {
        return k1.f;
    }

    private void b()
    {
        Object obj = null;
        if (e != null || "assets://makeup/texture_color_general.png" == null) goto _L2; else goto _L1
_L1:
        if ("assets://makeup/texture_color_general.png".indexOf("assets://") != 0) goto _L4; else goto _L3
_L3:
        Object obj1 = new BufferedInputStream(b.getAssets().open("assets://makeup/texture_color_general.png".substring("assets://".length())));
        BufferedInputStream bufferedinputstream;
        obj = obj1;
        bufferedinputstream = ((BufferedInputStream) (obj1));
        e = BitmapFactory.decodeStream(((InputStream) (obj1)));
_L6:
        obj = obj1;
        bufferedinputstream = ((BufferedInputStream) (obj1));
        f = 0;
        if (obj1 == null) goto _L2; else goto _L5
_L5:
        ((InputStream) (obj1)).close();
_L2:
        return;
_L4:
        e = BitmapFactory.decodeFile("assets://makeup/texture_color_general.png");
        obj1 = null;
          goto _L6
        obj;
        m.e("LiveColorAdapter", ((IOException) (obj)).toString());
        return;
        Object obj2;
        obj2;
        bufferedinputstream = null;
_L10:
        obj = bufferedinputstream;
        m.e("LiveColorAdapter", ((IOException) (obj2)).toString());
        if (bufferedinputstream == null) goto _L2; else goto _L7
_L7:
        try
        {
            bufferedinputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            m.e("LiveColorAdapter", ((IOException) (obj)).toString());
        }
        return;
        Exception exception;
        exception;
        obj2 = obj;
        obj = exception;
_L9:
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                m.e("LiveColorAdapter", ((IOException) (obj2)).toString());
            }
        }
        throw obj;
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
          goto _L10
    }

    public int a()
    {
        return a;
    }

    public String a(int i)
    {
        if (d != null && i > 0)
        {
            return (String)d.get(i - 1);
        } else
        {
            return null;
        }
    }

    public boolean areAllItemsEnabled()
    {
        return g;
    }

    public at b(int i)
    {
        if (c != null && i > 0)
        {
            return (at)c.get(i - 1);
        } else
        {
            return null;
        }
    }

    public void c(int i)
    {
        if (i <= 0 || i >= getCount())
        {
            a = 0;
            return;
        } else
        {
            a = i;
            return;
        }
    }

    public int getCount()
    {
        if (c != null)
        {
            return c.size() + 1;
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return b(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getItemViewType(int i)
    {
        return i != 0 ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (f)view;
        } else
        {
            view = new f(b, StatusManager.j().s());
            if (i == 0)
            {
                view.setImage(b.getResources().getDrawable(0x7f0208df));
            } else
            {
                view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(view) {

                    final f a;
                    final k b;

                    public void onLayoutChange(View view1, int j, int l, int i1, int j1, int k1, int l1, 
                            int i2, int j2)
                    {
                        if (k.a(b) == null)
                        {
                            return;
                        }
                        if (k.b(b) != view1.getWidth())
                        {
                            k.a(b, Bitmap.createScaledBitmap(k.a(b), view1.getWidth(), view1.getHeight(), true));
                            k.a(b, view1.getWidth());
                        }
                        a.setImage(k.a(b));
                    }

            
            {
                b = k.this;
                a = f1;
                super();
            }
                });
            }
        }
        if (i != 0)
        {
            view.setColor(b(i));
            if (e != null)
            {
                view.setImage(e);
                return view;
            }
        }
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
