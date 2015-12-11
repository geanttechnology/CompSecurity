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
import com.bestbuy.android.activities.search.plp.SearchPLPNarrowResultsFilterFragment;
import com.bestbuy.android.api.lib.models.search.FacetValues;
import com.bestbuy.android.api.lib.models.search.Facets;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dj extends BaseExpandableListAdapter
{

    private Map a;
    private List b;
    private LayoutInflater c;
    private SearchPLPNarrowResultsFilterFragment d;
    private Map e;
    private HashMap f;
    private List g;
    private ArrayList h;
    private String i;
    private ArrayList j;

    public dj(Activity activity, SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment, List list, Map map, String s)
    {
        g = null;
        h = null;
        j = null;
        a = map;
        b = list;
        d = searchplpnarrowresultsfilterfragment;
        i = s;
        e = searchplpnarrowresultsfilterfragment.b();
        c = activity.getLayoutInflater();
    }

    public String a(int k)
    {
        return ((Facets)b.get(k)).getFacetField();
    }

    public void a(ArrayList arraylist)
    {
        j = arraylist;
        e = d.b();
        h = d.c();
        notifyDataSetChanged();
    }

    public void a(HashMap hashmap, List list, HashMap hashmap1)
    {
        a = hashmap1;
        b = list;
        f = hashmap;
        e = d.b();
        h = d.c();
        notifyDataSetChanged();
    }

    public Object getChild(int k, int l)
    {
        return (FacetValues)((List)a.get(((Facets)b.get(k)).getDisplayName())).get(l);
    }

    public long getChildId(int k, int l)
    {
        return (long)l;
    }

    public View getChildView(int k, int l, boolean flag, View view, ViewGroup viewgroup)
    {
        FacetValues facetvalues = (FacetValues)getChild(k, l);
        String s = facetvalues.getValue();
        List list = (List)e.get(a(k));
        String s1;
        boolean flag1;
        if (list == null || !list.contains(facetvalues.getValue()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f != null)
        {
            g = (List)f.get(a(k));
        }
        if (view == null)
        {
            view = c.inflate(0x7f0300be, viewgroup, false);
            viewgroup = new dk();
            viewgroup.a = (BBYTextView)view.findViewById(0x7f0c030a);
            viewgroup.c = (ImageView)view.findViewById(0x7f0c030b);
            viewgroup.d = (RelativeLayout)view.findViewById(0x7f0c0309);
            viewgroup.b = view.findViewById(0x7f0c030c);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (dk)view.getTag();
        }
        if (list != null && (list.contains(facetvalues.getValue()) || list.contains(facetvalues.getCategoryPath())))
        {
            ((dk) (viewgroup)).c.setVisibility(0);
        } else
        {
            ((dk) (viewgroup)).c.setVisibility(8);
        }
        s1 = a(k);
        if (j != null && j.contains(s1))
        {
            if (list != null && (list.contains(facetvalues.getValue()) || list.contains(facetvalues.getCategoryPath())))
            {
                ((dk) (viewgroup)).c.setVisibility(0);
                ((dk) (viewgroup)).a.setTextColor(Color.rgb(0, 103, 175));
                if (list != null && (list.contains(facetvalues.getValue()) || list.contains(facetvalues.getCategoryPath())))
                {
                    ((dk) (viewgroup)).a.setText(facetvalues.getValue());
                } else
                {
                    ((dk) (viewgroup)).a.setText(s);
                }
                ((dk) (viewgroup)).a.setTag("Active");
            } else
            {
                ((dk) (viewgroup)).a.setTextColor(Color.rgb(0, 103, 175));
                ((dk) (viewgroup)).c.setVisibility(8);
                ((dk) (viewgroup)).a.setText(facetvalues.getValue());
                ((dk) (viewgroup)).a.setTag("Active");
            }
        } else
        if (h != null && h.contains(facetvalues.getValue()) && flag1)
        {
            ((dk) (viewgroup)).a.setText(facetvalues.getValue());
        } else
        {
            ((dk) (viewgroup)).a.setTextColor(Color.rgb(0, 103, 175));
            if (list != null && (list.contains(facetvalues.getValue()) || list.contains(facetvalues.getCategoryPath())))
            {
                ((dk) (viewgroup)).a.setText(facetvalues.getValue());
            } else
            {
                ((dk) (viewgroup)).a.setText(s);
            }
            ((dk) (viewgroup)).a.setTag("Active");
        }
        if (l + 1 == getChildrenCount(k))
        {
            ((dk) (viewgroup)).d.setBackgroundResource(0x7f02002a);
            ((dk) (viewgroup)).b.setVisibility(0);
            return view;
        } else
        {
            ((dk) (viewgroup)).d.setBackgroundResource(0x7f0b0063);
            ((dk) (viewgroup)).b.setVisibility(8);
            return view;
        }
    }

    public int getChildrenCount(int k)
    {
        return ((List)a.get(((Facets)b.get(k)).getDisplayName())).size();
    }

    public Object getGroup(int k)
    {
        return ((Facets)b.get(k)).getDisplayName();
    }

    public int getGroupCount()
    {
        return b.size();
    }

    public long getGroupId(int k)
    {
        return (long)k;
    }

    public View getGroupView(int k, boolean flag, View view, ViewGroup viewgroup)
    {
        String s = (String)getGroup(k);
        View view1;
        if (view == null)
        {
            view1 = c.inflate(0x7f0300bd, viewgroup, false);
            view = new dl();
            view.a = (BBYTextView)view1.findViewById(0x7f0c0306);
            view.d = (RelativeLayout)view1.findViewById(0x7f0c0305);
            view.b = (ImageView)view1.findViewById(0x7f0c0307);
            view.c = view1.findViewById(0x7f0c0308);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (dl)view.getTag();
            view1 = view;
        }
        if (flag)
        {
            ((dl) (viewgroup)).d.setBackgroundResource(0x7f0200ce);
            ((dl) (viewgroup)).b.setImageResource(0x7f0201b6);
            ((dl) (viewgroup)).c.setVisibility(8);
        } else
        {
            ((dl) (viewgroup)).d.setBackgroundResource(0x7f020029);
            if (e.containsKey(a(k)))
            {
                ((dl) (viewgroup)).b.setImageResource(0x7f020077);
            } else
            {
                ((dl) (viewgroup)).b.setImageResource(0x7f0200b6);
            }
        }
        ((dl) (viewgroup)).c.setVisibility(0);
        ((dl) (viewgroup)).a.setText(s);
        return view1;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int k, int l)
    {
        return true;
    }
}
