// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.dnm.DNMPLPNarrowFacetFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMFacet;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class fe extends BaseExpandableListAdapter
{

    private ArrayList a;
    private Map b;
    private LayoutInflater c;
    private DNMPLPNarrowFacetFragment d;
    private Map e;
    private HashMap f;
    private List g;
    private Map h;

    public fe(Activity activity, DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment, ArrayList arraylist, Map map)
    {
        g = null;
        h = null;
        a = arraylist;
        b = map;
        d = dnmplpnarrowfacetfragment;
        e = dnmplpnarrowfacetfragment.b();
        h = dnmplpnarrowfacetfragment.c();
        c = activity.getLayoutInflater();
    }

    private boolean a(String s)
    {
        return h.keySet().contains(s);
    }

    private boolean a(List list, String s)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < list.size())
                {
                    if (!((DNMFacetFilter)list.get(i)).getFilterQuery().equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public String a(int i)
    {
        return ((DNMFacet)a.get(i)).getName();
    }

    public void a()
    {
        e = d.b();
        notifyDataSetChanged();
    }

    public Object getChild(int i, int j)
    {
        return (DNMFacetFilter)((ArrayList)b.get(((DNMFacet)a.get(i)).getName())).get(j);
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        DNMFacetFilter dnmfacetfilter = (DNMFacetFilter)getChild(i, j);
        String s = dnmfacetfilter.getDisplayText();
        List list = (List)e.get(a(i));
        View view1;
        boolean flag1;
        if (list == null || !a(list, dnmfacetfilter.getFilterQuery()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f != null)
        {
            g = (List)f.get(a(i));
        }
        if (view == null)
        {
            view1 = c.inflate(0x7f0300be, viewgroup, false);
            view = new ff();
            view.a = (BBYTextView)view1.findViewById(0x7f0c030a);
            view.c = (ImageView)view1.findViewById(0x7f0c030b);
            view.d = (RelativeLayout)view1.findViewById(0x7f0c0309);
            view.b = view1.findViewById(0x7f0c030c);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (ff)view.getTag();
            view1 = view;
        }
        if (list != null && a(list, dnmfacetfilter.getFilterQuery()))
        {
            ((ff) (viewgroup)).c.setVisibility(0);
        } else
        {
            ((ff) (viewgroup)).c.setVisibility(8);
        }
        if (h != null && a(dnmfacetfilter.getDisplayText()) && flag1)
        {
            ((ff) (viewgroup)).a.setText(s);
        } else
        {
            ((ff) (viewgroup)).a.setTextColor(Color.rgb(0, 103, 175));
            if (list != null && a(list, dnmfacetfilter.getFilterQuery()))
            {
                ((ff) (viewgroup)).a.setText(s);
            } else
            {
                ((ff) (viewgroup)).a.setText(s);
            }
            ((ff) (viewgroup)).a.setTag("Active");
        }
        if (j + 1 == getChildrenCount(i))
        {
            ((ff) (viewgroup)).d.setBackgroundResource(0x7f02002a);
            ((ff) (viewgroup)).b.setVisibility(0);
            return view1;
        } else
        {
            ((ff) (viewgroup)).d.setBackgroundResource(0x7f0b0063);
            ((ff) (viewgroup)).b.setVisibility(8);
            return view1;
        }
    }

    public int getChildrenCount(int i)
    {
        return ((ArrayList)b.get(((DNMFacet)a.get(i)).getName())).size();
    }

    public Object getGroup(int i)
    {
        return ((DNMFacet)a.get(i)).getName();
    }

    public int getGroupCount()
    {
        return a.size();
    }

    public long getGroupId(int i)
    {
        return (long)i;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        String s = (String)getGroup(i);
        View view1;
        if (view == null)
        {
            view1 = c.inflate(0x7f0300bd, viewgroup, false);
            view = new fg();
            view.a = (BBYTextView)view1.findViewById(0x7f0c0306);
            view.d = (RelativeLayout)view1.findViewById(0x7f0c0305);
            view.b = (ImageView)view1.findViewById(0x7f0c0307);
            view.c = view1.findViewById(0x7f0c0308);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (fg)view.getTag();
            view1 = view;
        }
        if (flag)
        {
            ((fg) (viewgroup)).d.setBackgroundResource(0x7f0200ce);
            ((fg) (viewgroup)).b.setImageResource(0x7f0201b6);
            ((fg) (viewgroup)).c.setVisibility(8);
        } else
        {
            ((fg) (viewgroup)).d.setBackgroundResource(0x7f020029);
            if (e.containsKey(a(i)))
            {
                ((fg) (viewgroup)).b.setImageResource(0x7f020077);
            } else
            {
                ((fg) (viewgroup)).b.setImageResource(0x7f0200b6);
            }
            ((fg) (viewgroup)).c.setVisibility(0);
        }
        ((fg) (viewgroup)).a.setText(s);
        return view1;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }
}
