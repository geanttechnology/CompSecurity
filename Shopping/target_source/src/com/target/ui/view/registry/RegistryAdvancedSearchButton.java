// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegistryAdvancedSearchButton extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        Button searchButton;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchButton this$0;

        public void onClick(View view)
        {
            if (RegistryAdvancedSearchButton.a(RegistryAdvancedSearchButton.this) == null)
            {
                return;
            } else
            {
                RegistryAdvancedSearchButton.a(RegistryAdvancedSearchButton.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = RegistryAdvancedSearchButton.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();
    }


    private static final String TAG = com/target/ui/view/registry/RegistryAdvancedSearchButton.getSimpleName();
    private b mListener;
    private Views mViews;

    public RegistryAdvancedSearchButton(Context context)
    {
        super(context);
        a();
    }

    public RegistryAdvancedSearchButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public RegistryAdvancedSearchButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static b a(RegistryAdvancedSearchButton registryadvancedsearchbutton)
    {
        return registryadvancedsearchbutton.mListener;
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301d0, this);
        mViews = new Views(this);
        b();
    }

    private void b()
    {
        mViews.searchButton.setOnClickListener(new a());
    }

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

}
