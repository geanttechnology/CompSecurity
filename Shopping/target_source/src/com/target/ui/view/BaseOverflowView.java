// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import com.target.ui.util.j;

public abstract class BaseOverflowView extends ImageView
{

    private y mPopupMenu;

    public BaseOverflowView(Context context)
    {
        super(context);
        b();
    }

    public BaseOverflowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public BaseOverflowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private y a(int i, android.support.v7.widget.y.b b1)
    {
        y y1 = new y(getContext(), this);
        y1.b().inflate(i, y1.a());
        y1.a(b1);
        return y1;
    }

    private void a()
    {
        mPopupMenu.c();
    }

    static void a(BaseOverflowView baseoverflowview)
    {
        baseoverflowview.a();
    }

    private void b()
    {
        if (j.b())
        {
            setBackgroundResource(0x7f020047);
        } else
        {
            setBackgroundResource(0x7f020048);
        }
        setContentDescription(getResources().getString(0x7f090172));
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        setImageResource(0x7f020192);
        setOnClickListener(new android.view.View.OnClickListener() {

            final BaseOverflowView this$0;

            public void onClick(View view)
            {
                BaseOverflowView.a(BaseOverflowView.this);
            }

            
            {
                this$0 = BaseOverflowView.this;
                super();
            }
        });
        mPopupMenu = a(getMenuResource(), getOnMenuItemClickListener());
    }

    protected final void a(int i)
    {
        mPopupMenu = a(i, getOnMenuItemClickListener());
    }

    protected abstract int getMenuResource();

    protected abstract android.support.v7.widget.y.b getOnMenuItemClickListener();

    protected y getPopupMenu()
    {
        return mPopupMenu;
    }
}
