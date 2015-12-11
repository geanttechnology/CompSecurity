// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.settings:
//            PreferredCountryFragment

final class sections extends ArrayAdapter
    implements SectionIndexer
{

    Map alphaIndexer;
    List displayNames;
    List items;
    String sections[];
    final PreferredCountryFragment this$0;

    public int getPositionForSection(int i)
    {
        String s = sections[i];
        return ((Integer)alphaIndexer.get(s)).intValue();
    }

    public int getSectionForPosition(int i)
    {
        return 0;
    }

    public Object[] getSections()
    {
        return sections;
    }

    public int getSelectedPosition()
    {
        int i;
        for (i = 0; i < items.size() && !((com.ebay.common.view.util.tems)items.get(i)).ry(PreferredCountryFragment.access$100(PreferredCountryFragment.this)); i++) { }
        int j = i;
        if (i == items.size())
        {
            j = 0;
        }
        return j;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        viewgroup = (com.ebay.common.view.util.tems)getItem(i);
        ((ImageView)view.findViewById(0x1020006)).setImageResource(viewgroup.eId());
        ImageView imageview = (ImageView)view.findViewById(0x7f100121);
        if (viewgroup.ry(PreferredCountryFragment.access$100(PreferredCountryFragment.this)))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        imageview.setVisibility(i);
        return view;
    }

    public (Context context, int i, int j, List list)
    {
        this$0 = PreferredCountryFragment.this;
        super(context, i, j, list);
        items = list;
        alphaIndexer = new HashMap();
        preferredcountryfragment = Collator.getInstance(Locale.getDefault());
        setStrength(0);
        Collections.sort(items, new com.ebay.common.view.util.it>(PreferredCountryFragment.this));
        i = list.size();
        context = new ArrayList();
        for (i--; i >= 0; i--)
        {
            String s = ((com.ebay.common.view.util.it>)list.get(i)).().substring(0, 1);
            alphaIndexer.put(s, Integer.valueOf(i));
            context.add(s);
        }

        Collections.sort(context, PreferredCountryFragment.this);
        sections = new String[context.size()];
        context.toArray(sections);
    }
}
