// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.DiscoverTabItem;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            ObservableHorizontalScrollView

public class DiscoverTabScrollView extends ObservableHorizontalScrollView
{

    private LinearLayout a;
    private int b;
    private android.view.View.OnLayoutChangeListener c;

    public DiscoverTabScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = 0;
        c = new android.view.View.OnLayoutChangeListener() {

            final DiscoverTabScrollView a;

            public void onLayoutChange(View view, int l, int i1, int j1, int k1, int l1, int i2, 
                    int j2, int k2)
            {
                if (DiscoverTabScrollView.a(a) != DiscoverTabScrollView.b(a))
                {
                    DiscoverTabScrollView.a(a, DiscoverTabScrollView.b(a));
                    view.post(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            int j1 = DiscoverTabScrollView.c(a.a).getChildCount();
                            if (j1 > 0)
                            {
                                int l;
                                int i1;
                                if (j1 <= 4)
                                {
                                    l = DiscoverTabScrollView.a(a.a) / j1;
                                } else
                                {
                                    l = (int)((float)DiscoverTabScrollView.a(a.a) / 3.5F);
                                }
                                for (i1 = 0; i1 < j1; i1++)
                                {
                                    ((android.widget.LinearLayout.LayoutParams)((LinearLayout)DiscoverTabScrollView.c(a.a).getChildAt(i1)).getLayoutParams()).width = l;
                                }

                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
            }

            
            {
                a = DiscoverTabScrollView.this;
                super();
            }
        };
        a(context);
    }

    static int a(DiscoverTabScrollView discovertabscrollview)
    {
        return discovertabscrollview.b;
    }

    static int a(DiscoverTabScrollView discovertabscrollview, int l)
    {
        discovertabscrollview.b = l;
        return l;
    }

    private ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        if (arraylist == null)
        {
            return arraylist1;
        }
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            Object obj = (String)arraylist.next();
            if (obj != null)
            {
                if (((String) (obj)).equals("BEAUTYIST"))
                {
                    obj = new DiscoverTabItem();
                    obj.type = "BEAUTYIST";
                    obj.displayImage = i.bc_banner_discovery_beautyist;
                    obj.displayName = getResources().getString(m.bc_discovery_celebrities);
                    arraylist1.add(obj);
                } else
                if (((String) (obj)).equals("BRAND"))
                {
                    obj = new DiscoverTabItem();
                    obj.type = "BRAND";
                    obj.displayImage = i.bc_banner_discovery_brand;
                    obj.displayName = getResources().getString(m.bc_discovery_brand);
                    arraylist1.add(obj);
                } else
                if (((String) (obj)).equals("BEAUTY_TIP"))
                {
                    obj = new DiscoverTabItem();
                    obj.type = "BEAUTY_TIP";
                    obj.displayImage = i.bc_banner_discovery_tips;
                    obj.displayName = getResources().getString(m.bc_discovery_makeuptip);
                    arraylist1.add(obj);
                } else
                if (((String) (obj)).equals("EDITORIAL"))
                {
                    obj = new DiscoverTabItem();
                    obj.type = "EDITORIAL";
                    obj.displayImage = i.bc_banner_discovery_editor;
                    obj.displayName = getResources().getString(m.bc_discovery_editorial);
                    arraylist1.add(obj);
                } else
                if (((String) (obj)).equals("FREE_SAMPLE"))
                {
                    obj = new DiscoverTabItem();
                    obj.type = "FREE_SAMPLE";
                    obj.displayImage = i.bc_banner_discovery_sample;
                    obj.displayName = getResources().getString(m.bc_discovery_sample);
                    arraylist1.add(obj);
                } else
                if (((String) (obj)).equals("CONTEST"))
                {
                    DiscoverTabItem discovertabitem = new DiscoverTabItem();
                    discovertabitem.type = "CONTEST";
                    discovertabitem.displayImage = i.bc_banner_discovery_contest;
                    discovertabitem.displayName = getResources().getString(m.bc_discovery_contest);
                    arraylist1.add(discovertabitem);
                }
            }
        } while (true);
        return arraylist1;
    }

    private void a(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_widget_discover_tab_srcoll_view, this);
        addOnLayoutChangeListener(c);
        a = (LinearLayout)findViewById(j.tab_container);
    }

    static int b(DiscoverTabScrollView discovertabscrollview)
    {
        return discovertabscrollview.getWidthWithoutPadding();
    }

    static LinearLayout c(DiscoverTabScrollView discovertabscrollview)
    {
        return discovertabscrollview.a;
    }

    private int getWidthWithoutPadding()
    {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    public void a(ArrayList arraylist, android.view.View.OnClickListener onclicklistener)
    {
        if (arraylist != null && a != null)
        {
            arraylist = a(arraylist);
            a.removeAllViews();
            b = getWidthWithoutPadding();
            int l;
            int i1;
            if (arraylist.size() <= 4)
            {
                l = b / arraylist.size();
            } else
            {
                l = (int)((float)b / 3.5F);
            }
            if (arraylist.size() > 1)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                DiscoverTabItem discovertabitem = (DiscoverTabItem)arraylist.next();
                LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getContext().getSystemService("layout_inflater")).inflate(k.bc_view_item_beauty_opton, a, false);
                ((android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams()).width = l;
                ((LinearLayout)linearlayout.findViewById(j.bc_beauty_option_panel)).setOrientation(i1);
                ((ImageView)linearlayout.findViewById(j.bc_beauty_option_image)).setImageResource(discovertabitem.displayImage);
                ((TextView)linearlayout.findViewById(j.bc_beauty_option_text)).setText(discovertabitem.displayName);
                linearlayout.setTag(discovertabitem);
                linearlayout.setOnClickListener(onclicklistener);
                a.addView(linearlayout);
            }
        }
    }
}
