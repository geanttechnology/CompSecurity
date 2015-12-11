// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.target.ui.util.al;
import java.util.List;

// Referenced classes of package com.target.ui.view.list:
//            RecentItemsCardView

public class ListItemSuggestionsView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        RecentItemsCardView autoCompleteView;
        View listSuggestionView;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(String s);

        public abstract void a(boolean flag);
    }


    private static final int HIDE_ALL = 1;
    private static final int SHOW_AUTOCOMPLETE = 2;
    private a mListener;
    private int mState;
    private Views mViews;

    public ListItemSuggestionsView(Context context)
    {
        super(context);
        mState = 1;
        a(context);
    }

    public ListItemSuggestionsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mState = 1;
        a(context);
    }

    public ListItemSuggestionsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mState = 1;
        a(context);
    }

    static a a(ListItemSuggestionsView listitemsuggestionsview)
    {
        return listitemsuggestionsview.mListener;
    }

    private void a()
    {
        mViews.autoCompleteView.a(false);
        mViews.autoCompleteView.setSearchHistoryListener(new RecentItemsCardView.b() {

            final ListItemSuggestionsView this$0;

            public void a(String s)
            {
                if (ListItemSuggestionsView.a(ListItemSuggestionsView.this) == null)
                {
                    return;
                } else
                {
                    ListItemSuggestionsView.a(ListItemSuggestionsView.this).a(s);
                    return;
                }
            }

            public void b(String s)
            {
                com.target.ui.fragment.product.search.a.c(getContext(), s);
            }

            
            {
                this$0 = ListItemSuggestionsView.this;
                super();
            }
        });
    }

    private void a(int i)
    {
        mState = i;
        switch (mState)
        {
        default:
            return;

        case 1: // '\001'
            al.a(new View[] {
                mViews.listSuggestionView, mViews.autoCompleteView
            });
            return;

        case 2: // '\002'
            al.b(new View[] {
                mViews.listSuggestionView, mViews.autoCompleteView
            });
            break;
        }
    }

    private void a(Context context)
    {
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030166, this, true));
        a();
    }

    public void a(List list)
    {
        boolean flag = true;
        mViews.autoCompleteView.setData(list);
        if (!list.isEmpty())
        {
            a(2);
        } else
        {
            a(1);
        }
        if (mListener != null)
        {
            a a1 = mListener;
            if (list.size() != 0)
            {
                flag = false;
            }
            a1.a(flag);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int)getContext().getResources().getDimension(0x7f0a01e0), 0x80000000));
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }
}
