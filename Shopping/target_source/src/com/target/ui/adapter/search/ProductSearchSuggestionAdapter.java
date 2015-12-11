// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.common.product.d;
import com.target.ui.adapter.b.e;
import com.target.ui.model.search.a;
import com.target.ui.model.search.c;
import com.target.ui.util.al;
import com.target.ui.view.AisleBadgeView;

public class ProductSearchSuggestionAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        AisleBadgeView aisle;
        ImageView searchEditImage;
        TextView title;

        public ViewHolder(View view)
        {
            super(view);
        }
    }

    public class a
        implements android.view.View.OnClickListener
    {

        private String searchQuery;
        final ProductSearchSuggestionAdapter this$0;

        public void onClick(View view)
        {
            com.target.ui.adapter.search.ProductSearchSuggestionAdapter.a(ProductSearchSuggestionAdapter.this).a(searchQuery);
        }

        public a(String s)
        {
            this$0 = ProductSearchSuggestionAdapter.this;
            super();
            searchQuery = s;
        }
    }

    public static interface b
    {

        public abstract void a(String s);
    }


    private final int mCategorySuggestionTextLeftPadding;
    private final com.target.ui.model.search.c.a mSearchMode;
    private b mSearchSuggestionListener;

    public ProductSearchSuggestionAdapter(Context context, c c1, b b1)
    {
        super(context, c1.b());
        setNotifyOnChange(false);
        mCategorySuggestionTextLeftPadding = (int)context.getResources().getDimension(0x7f0a02a5);
        mSearchMode = c1.a();
        mSearchSuggestionListener = b1;
    }

    private ViewHolder a(View view)
    {
        return new ViewHolder(view);
    }

    static b a(ProductSearchSuggestionAdapter productsearchsuggestionadapter)
    {
        return productsearchsuggestionadapter.mSearchSuggestionListener;
    }

    private void a(ViewHolder viewholder, com.target.ui.model.search.a a1)
    {
        String s;
        s = a1.a();
        viewholder.title.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$model$search$SearchSuggestionModel$SearchSuggestionDisplayMode[];

            static 
            {
                $SwitchMap$com$target$ui$model$search$SearchSuggestionModel$SearchSuggestionDisplayMode = new int[com.target.ui.model.search.c.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$model$search$SearchSuggestionModel$SearchSuggestionDisplayMode[com.target.ui.model.search.c.a.ENTERPRISE_SEARCH_SUGGESTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$model$search$SearchSuggestionModel$SearchSuggestionDisplayMode[com.target.ui.model.search.c.a.PI_SEARCH_SUGGESTION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$model$search$SearchSuggestionModel$SearchSuggestionDisplayMode[com.target.ui.model.search.c.a.UNKNOWN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.model.search.SearchSuggestionModel.SearchSuggestionDisplayMode[mSearchMode.ordinal()];
        JVM INSTR tableswitch 1 1: default 56
    //                   1 112;
           goto _L1 _L2
_L1:
        int i;
        al.b(viewholder.searchEditImage);
        viewholder.searchEditImage.setOnClickListener(new a(s));
        i = 0;
        a1 = s;
_L4:
        viewholder.title.setText(a1);
        viewholder.title.setPadding(i, 0, 0, 0);
        al.b(viewholder.title);
        return;
_L2:
        if (a1.f().b() || a1.e().b())
        {
            a1 = a1.c();
            i = mCategorySuggestionTextLeftPadding;
            viewholder.title.setTextColor(getContext().getResources().getColor(0x7f0f00f6));
            al.c(viewholder.searchEditImage);
        } else
        {
            al.b(viewholder.searchEditImage);
            viewholder.searchEditImage.setOnClickListener(new a(s));
            i = 0;
            a1 = s;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(ViewHolder viewholder, com.target.ui.model.search.a a1)
    {
        al.d(viewholder.aisle);
        _cls1..SwitchMap.com.target.ui.model.search.SearchSuggestionModel.SearchSuggestionDisplayMode[mSearchMode.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 80
    //                   2 41;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (a1.d().b())
        {
            viewholder.aisle.setAisle((String)a1.d().c());
            al.b(viewholder.aisle);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((a1.e().b() || a1.f().b()) && !a1.b().equals(d.UNKNOWN))
        {
            viewholder.aisle.setDepartment(com.target.ui.util.f.a.a(a1.b()));
            al.b(viewholder.aisle);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected int a()
    {
        return 0x7f0301f1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        com.target.ui.model.search.a a1;
        if (view == null)
        {
            view = mInflater.inflate(a(), viewgroup, false);
            viewgroup = a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        a1 = (com.target.ui.model.search.a)getItem(i);
        a(viewgroup, a1);
        b(viewgroup, a1);
        return view;
    }
}
