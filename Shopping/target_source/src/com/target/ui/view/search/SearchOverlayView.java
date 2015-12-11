// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.k.b;
import com.target.ui.util.al;

public class SearchOverlayView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        View backButton;
        View clearButton;
        View scanButton;
        EditText searchField;
        View voiceSearchButton;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s);

        public abstract void b_(String s);

        public abstract void w_();

        public abstract void x_();
    }


    private a mListener;
    private Views mViews;

    public SearchOverlayView(Context context)
    {
        super(context);
        a();
    }

    public SearchOverlayView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public SearchOverlayView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(SearchOverlayView searchoverlayview)
    {
        return searchoverlayview.mListener;
    }

    private void a()
    {
        setBackgroundColor(getResources().getColor(0x106000b));
        inflate(getContext(), 0x7f0301ed, this);
        mViews = new Views(this);
        b();
        c();
    }

    static void a(SearchOverlayView searchoverlayview, boolean flag)
    {
        searchoverlayview.a(flag);
    }

    private void a(boolean flag)
    {
        boolean flag2 = true;
        int i = 0;
        View view = mViews.scanButton;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        al.a(view, flag1);
        view = mViews.voiceSearchButton;
        if (!flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        al.a(view, flag1);
        view = mViews.clearButton;
        if (!flag)
        {
            i = 4;
        }
        al.a(view, i);
    }

    static Views b(SearchOverlayView searchoverlayview)
    {
        return searchoverlayview.mViews;
    }

    private void b()
    {
        mViews.backButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchOverlayView this$0;

            public void onClick(View view)
            {
                if (SearchOverlayView.a(SearchOverlayView.this) == null)
                {
                    return;
                } else
                {
                    SearchOverlayView.a(SearchOverlayView.this).a();
                    return;
                }
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
        mViews.clearButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchOverlayView this$0;

            public void onClick(View view)
            {
                com.target.ui.view.search.SearchOverlayView.b(SearchOverlayView.this).searchField.setText("");
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
        mViews.scanButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchOverlayView this$0;

            public void onClick(View view)
            {
                if (SearchOverlayView.a(SearchOverlayView.this) == null)
                {
                    return;
                } else
                {
                    SearchOverlayView.a(SearchOverlayView.this).w_();
                    return;
                }
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
        mViews.voiceSearchButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchOverlayView this$0;

            public void onClick(View view)
            {
                if (SearchOverlayView.a(SearchOverlayView.this) == null)
                {
                    return;
                } else
                {
                    SearchOverlayView.a(SearchOverlayView.this).x_();
                    return;
                }
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
    }

    private void c()
    {
        mViews.searchField.addTextChangedListener(new b() {

            final SearchOverlayView this$0;

            public void a(Editable editable)
            {
                editable = editable.toString();
                SearchOverlayView searchoverlayview = SearchOverlayView.this;
                boolean flag;
                if (editable.length() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SearchOverlayView.a(searchoverlayview, flag);
                if (SearchOverlayView.a(SearchOverlayView.this) != null)
                {
                    SearchOverlayView.a(SearchOverlayView.this).b_(editable);
                }
            }

            public void a(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void b(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
        mViews.searchField.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SearchOverlayView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                i;
                JVM INSTR tableswitch 3 3: default 20
            //                           3 22;
                   goto _L1 _L2
_L1:
                return false;
_L2:
                if (SearchOverlayView.a(SearchOverlayView.this) != null)
                {
                    SearchOverlayView.a(SearchOverlayView.this).a(com.target.ui.view.search.SearchOverlayView.b(SearchOverlayView.this).searchField.getText().toString());
                    return true;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = SearchOverlayView.this;
                super();
            }
        });
    }

    public void setSearchOverlayViewListener(a a1)
    {
        mListener = a1;
    }

    public void setSearchTerm(String s)
    {
        mViews.searchField.setText(s);
        int i;
        if (o.d(s))
        {
            i = s.length();
        } else
        {
            i = 0;
        }
        mViews.searchField.setSelection(i);
    }
}
