// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SimpleSearchView extends LinearLayout
{

    private Context a;
    private android.support.v4.widget.s.a b;
    private android.support.v4.view.q.e c;
    private EditText d;
    private ImageButton e;
    private ImageButton f;
    private InputMethodManager g;

    public SimpleSearchView(Context context)
    {
        super(context);
        a = context;
        g = (InputMethodManager)a.getSystemService("input_method");
    }

    public SimpleSearchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = context;
        g = (InputMethodManager)a.getSystemService("input_method");
    }

    static void a(SimpleSearchView simplesearchview)
    {
        simplesearchview.b();
    }

    static ImageButton b(SimpleSearchView simplesearchview)
    {
        return simplesearchview.f;
    }

    private void b()
    {
        c();
        d.setVisibility(0);
        e.setVisibility(8);
        d.requestFocus();
        c.a(null);
    }

    static android.support.v4.widget.s.a c(SimpleSearchView simplesearchview)
    {
        return simplesearchview.b;
    }

    private void c()
    {
        d.requestFocus();
        d.postDelayed(new Runnable() {

            final SimpleSearchView a;

            public void run()
            {
                SimpleSearchView.f(a).showSoftInput(SimpleSearchView.d(a), 0);
            }

            
            {
                a = SimpleSearchView.this;
                super();
            }
        }, 200L);
    }

    static EditText d(SimpleSearchView simplesearchview)
    {
        return simplesearchview.d;
    }

    private void d()
    {
        d.clearFocus();
        g.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    static void e(SimpleSearchView simplesearchview)
    {
        simplesearchview.c();
    }

    static InputMethodManager f(SimpleSearchView simplesearchview)
    {
        return simplesearchview.g;
    }

    public void a()
    {
        d();
        d.setVisibility(8);
        f.setVisibility(8);
        e.setVisibility(0);
        d.setText("");
        c.b(null);
    }

    public void clearFocus()
    {
        d();
    }

    public String getQuery()
    {
        return d.getText().toString();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        d = (EditText)findViewById(com.helpshift.b.c.N);
        e = (ImageButton)findViewById(com.helpshift.b.c.O);
        f = (ImageButton)findViewById(com.helpshift.b.c.P);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleSearchView a;

            public void onClick(View view)
            {
                SimpleSearchView.a(a);
            }

            
            {
                a = SimpleSearchView.this;
                super();
            }
        });
        d.addTextChangedListener(new TextWatcher() {

            final SimpleSearchView a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (charsequence.length() > 0)
                {
                    SimpleSearchView.b(a).setVisibility(0);
                } else
                {
                    SimpleSearchView.b(a).setVisibility(8);
                }
                SimpleSearchView.c(a).b(charsequence.toString());
            }

            
            {
                a = SimpleSearchView.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleSearchView a;

            public void onClick(View view)
            {
                SimpleSearchView.d(a).setText("");
                SimpleSearchView.e(a);
            }

            
            {
                a = SimpleSearchView.this;
                super();
            }
        });
    }

    public void setOnActionExpandListener(android.support.v4.view.q.e e1)
    {
        c = e1;
    }

    public void setQueryTextListener(android.support.v4.widget.s.a a1)
    {
        b = a1;
    }
}
