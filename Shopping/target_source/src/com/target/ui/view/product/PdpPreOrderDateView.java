// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.view.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PdpPreOrderDateView extends LinearLayout
{
    static class Views extends a
    {

        TextView preOrderDate;

        public Views(View view)
        {
            super(view);
        }
    }


    private static final String DATE_FORMAT = "MMMM dd, yyyy";
    private Views mViews;

    public PdpPreOrderDateView(Context context)
    {
        super(context);
        a();
    }

    public PdpPreOrderDateView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpPreOrderDateView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301b5, this);
        mViews = new Views(this);
    }

    public void setPreOrderDate(Date date)
    {
        if (date == null)
        {
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(getContext().getString(0x7f090471));
            stringbuilder.append(" ");
            stringbuilder.append((new SimpleDateFormat("MMMM dd, yyyy", Locale.US)).format(date));
            mViews.preOrderDate.setText(stringbuilder.toString());
            return;
        }
    }
}
