// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.target.ui.adapter.search.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.search:
//            ExtendedSearchHistoryFooterView

public class ExtendedSearchHistoryView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        ExtendedSearchHistoryFooterView footer;
        ListView listView;

        Views(View view)
        {
            super(view);
            footer = new ExtendedSearchHistoryFooterView(view.getContext());
        }
    }

    public static interface a
    {

        public abstract void a_(String s);

        public abstract void b(String s);

        public abstract void u_();
    }

    private class b
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ExtendedSearchHistoryView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this) == null)
            {
                return;
            } else
            {
                adapterview = (String)adapterview.getItemAtPosition(i);
                ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this).a_(adapterview);
                return;
            }
        }

        private b()
        {
            this$0 = ExtendedSearchHistoryView.this;
            super();
        }

    }


    private com.target.ui.adapter.search.b mAdapter;
    private a mListener;
    private Views mViews;

    public ExtendedSearchHistoryView(Context context)
    {
        super(context);
        a();
    }

    public ExtendedSearchHistoryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ExtendedSearchHistoryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(ExtendedSearchHistoryView extendedsearchhistoryview)
    {
        return extendedsearchhistoryview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301e8, this);
        mViews = new Views(this);
        mViews.footer.setExtendedSearchHistoryFooterViewClickListener(new ExtendedSearchHistoryFooterView.a() {

            final ExtendedSearchHistoryView this$0;

            public void a()
            {
                if (ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this) == null)
                {
                    return;
                } else
                {
                    ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this).u_();
                    return;
                }
            }

            
            {
                this$0 = ExtendedSearchHistoryView.this;
                super();
            }
        });
        mAdapter = new com.target.ui.adapter.search.b(getContext(), new ArrayList());
        mAdapter.b(true);
        mAdapter.a(true);
        mAdapter.a(new com.target.ui.adapter.search.SearchHistoryItemsAdapter.a() {

            final ExtendedSearchHistoryView this$0;

            public void a(String s)
            {
                if (ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this) == null)
                {
                    return;
                } else
                {
                    ExtendedSearchHistoryView.a(ExtendedSearchHistoryView.this).b(s);
                    return;
                }
            }

            
            {
                this$0 = ExtendedSearchHistoryView.this;
                super();
            }
        });
        mViews.listView.addFooterView(mViews.footer);
        mViews.listView.setAdapter(mAdapter);
        mViews.listView.setOnItemClickListener(new b());
    }

    public void setData(List list)
    {
        mAdapter.a(list);
    }

    public void setExtendedSearchHistoryClickListener(a a1)
    {
        mListener = a1;
    }
}
