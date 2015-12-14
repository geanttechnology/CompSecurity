// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, PromoteLooksDialog, DownloadItemUtility

class aj extends PagerAdapter
    implements q
{

    final PromoteLooksDialog a;
    private long b;
    private List c;
    private Map d;

    public aj(PromoteLooksDialog promotelooksdialog, long l, List list)
    {
        a = promotelooksdialog;
        super();
        b = l;
        c = list;
        d = new HashMap();
        for (promotelooksdialog = c.iterator(); promotelooksdialog.hasNext(); d.put(list, null))
        {
            list = (String)promotelooksdialog.next();
        }

    }

    private void a(View view, int i)
    {
        byte byte1 = 4;
        if (view == null)
        {
            return;
        }
        view.setTag(c.get(i));
        Object obj = b(i);
        Object obj1 = view.findViewById(0x7f0c058a);
        if (obj1 != null)
        {
            ((View) (obj1)).setOnClickListener(PromoteLooksDialog.b(a));
        }
        obj1 = view.findViewById(0x7f0c06bc);
        View view1 = view.findViewById(0x7f0c06bd);
        byte byte0;
        if (obj1 != null && view1 != null)
        {
            if (i == 0)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view1.setVisibility(byte0);
            if (i == 0)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            ((View) (obj1)).setVisibility(byte0);
            ((View) (obj1)).setOnClickListener(PromoteLooksDialog.c(a));
        }
        obj1 = view.findViewById(0x7f0c06be);
        view1 = view.findViewById(0x7f0c06bf);
        if (obj1 != null)
        {
            if (i == getCount() - 1)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view1.setVisibility(byte0);
            if (i == getCount() - 1)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            ((View) (obj1)).setVisibility(byte0);
            ((View) (obj1)).setOnClickListener(PromoteLooksDialog.d(a));
        }
        obj1 = (ImageView)view.findViewById(0x7f0c06bb);
        if (obj != null && obj1 != null)
        {
            ((ImageView) (obj1)).setTag(c.get(i));
            PromoteLooksDialog.e(a).a(((MakeupItemMetadata) (obj)), ((ImageView) (obj1)), com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.b);
        }
        obj1 = (TextView)view.findViewById(0x7f0c057e);
        if (obj != null && obj1 != null)
        {
            ((TextView) (obj1)).setText(((MakeupItemMetadata) (obj)).c());
        }
        obj1 = (TextView)view.findViewById(0x7f0c0589);
        if (obj != null && obj1 != null)
        {
            ((TextView) (obj1)).setText(((MakeupItemMetadata) (obj)).e());
        }
        obj1 = view.findViewById(0x7f0c0584);
        PromoteLooksDialog.a(a, view, PromoteLooksDialog.a(a, ((MakeupItemMetadata) (obj))));
        ((View) (obj1)).setOnClickListener(PromoteLooksDialog.f(a));
        obj1 = (TextView)view.findViewById(0x7f0c0588);
        PromoteLooksDialog.a(a, ((TextView) (obj1)), ((MakeupItemMetadata) (obj)));
        view.findViewById(0x7f0c0586);
        obj = view.findViewById(0x7f0c01b2);
        view = view.findViewById(0x7f0c01b1);
        ((View) (obj)).setOnClickListener(PromoteLooksDialog.g(a));
        view.setOnClickListener(PromoteLooksDialog.h(a));
    }

    public Context a()
    {
        return a.getContext();
    }

    public MakeupItemMetadata a(long l)
    {
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (MakeupItemMetadata)d.get(obj);
            if (((MakeupItemMetadata) (obj)).a() == l)
            {
                return ((MakeupItemMetadata) (obj));
            }
        }

        return null;
    }

    public void a(List list)
    {
    }

    public long b()
    {
        return b;
    }

    public MakeupItemMetadata b(int i)
    {
        if (c.size() < i || i < 0)
        {
            return null;
        } else
        {
            return (MakeupItemMetadata)d.get(c.get(i));
        }
    }

    public void b(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
            if (makeupitemmetadata != null)
            {
                d.put(makeupitemmetadata.m(), makeupitemmetadata);
            }
        } while (true);
    }

    public CategoryType d()
    {
        return null;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return c.size();
    }

    public Object instantiateItem(View view, int i)
    {
        view = ((LayoutInflater)Globals.d().getSystemService("layout_inflater")).inflate(0x7f030189, null);
        if (view == null)
        {
            return null;
        } else
        {
            a(view, i);
            PromoteLooksDialog.a(a).addView(view);
            return view;
        }
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
