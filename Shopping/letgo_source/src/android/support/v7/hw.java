// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ad;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.abtnprojects.ambatana.models.product.RemoteImage;
import com.abtnprojects.ambatana.models.product.Thumb;
import com.abtnprojects.ambatana.ui.activities.ImageGalleryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ew, iv, aqo

public class hw extends ad
{

    private LayoutInflater a;
    private Context b;
    private List c;
    private final Thumb d;
    private boolean e;
    private ew f;

    public hw(Context context, List list, Thumb thumb)
    {
        c = new ArrayList();
        f = ew.a(0, null);
        d = thumb;
        a = LayoutInflater.from(context);
        b = context;
        if (list != null)
        {
            c.addAll(list);
        }
        e = false;
    }

    static void a(hw hw1, View view, int i)
    {
        hw1.b(view, i);
    }

    private void a(ImageView imageview, String s, ew.a a1)
    {
        f.a(s, imageview, a1);
    }

    private void b(View view, int i)
    {
        view = new Intent(b, com/abtnprojects/ambatana/ui/activities/ImageGalleryActivity);
        view.putExtra("ProductObjectId", c());
        view.putExtra("ImagePosition", i);
        if (!iv.a(21));
        b.startActivity(view);
    }

    private ArrayList c()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); arraylist.add(((RemoteImage)iterator.next()).getUrl())) { }
        return arraylist;
    }

    public Object a(ViewGroup viewgroup, int i)
    {
        return b(viewgroup, i);
    }

    public void a(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((ViewGroup)obj);
    }

    public boolean a(View view, Object obj)
    {
        return view == obj;
    }

    public int b()
    {
        return c.size();
    }

    public View b(ViewGroup viewgroup, int i)
    {
        Object obj = (RemoteImage)c.get(i);
        String s1 = d.getUrl();
        String s = ((RemoteImage) (obj)).getUrl();
        View view;
        boolean flag;
        if (i == 0 && !e && !TextUtils.isEmpty(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aqo.a("will load thumb", new Object[0]);
            e = true;
            view = a.inflate(0x7f040065, viewgroup, false);
            obj = (ImageView)view.findViewById(0x7f100086);
            ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            ImageView imageview = (ImageView)view.findViewById(0x7f100151);
            imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            ViewSwitcher viewswitcher = (ViewSwitcher)view.findViewById(0x7f1000d0);
            f.a(s1, imageview, null);
            a(((ImageView) (obj)), s, new ew.a(viewswitcher) {

                final ViewSwitcher a;
                final hw b;

                public void a()
                {
                    aqo.a("full image success", new Object[0]);
                    if (a.getCurrentView().getId() != 0x7f100086)
                    {
                        a.showNext();
                    }
                }

                public void b()
                {
                    aqo.d("full image failed", new Object[0]);
                }

            
            {
                b = hw.this;
                a = viewswitcher;
                super();
            }
            });
        } else
        {
            view = a.inflate(0x7f040064, viewgroup, false);
            obj = (ImageView)view.findViewById(0x7f100086);
            ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            a(((ImageView) (obj)), s, ((ew.a) (null)));
        }
        if (obj != null)
        {
            ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener(i) {

                final int a;
                final hw b;

                public void onClick(View view1)
                {
                    hw.a(b, view1, a);
                }

            
            {
                b = hw.this;
                a = i;
                super();
            }
            });
        }
        viewgroup.addView(view);
        return view;
    }
}
