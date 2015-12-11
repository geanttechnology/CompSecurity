// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import cdflynn.android.library.crossview.CrossView;

public class AddActionView extends FrameLayout
{
    private class a
    {

        private final CrossView crossView;
        final AddActionView this$0;

        static CrossView a(a a1)
        {
            return a1.crossView;
        }

        a(View view)
        {
            this$0 = AddActionView.this;
            super();
            crossView = (CrossView)view.findViewById(0x7f1002f2);
        }
    }


    public static final String TAG = com/target/ui/view/AddActionView.getSimpleName();
    private a mViews;

    public AddActionView(Context context)
    {
        super(context);
        a(context);
    }

    public AddActionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AddActionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300fd, this);
        mViews = new a(this);
    }

    public void a()
    {
        a.a(mViews).b();
    }

    public void a(long l)
    {
        a.a(mViews).c(l);
    }

    public void b()
    {
        a.a(mViews).a();
    }

    public void b(long l)
    {
        a.a(mViews).b(l);
    }

}
