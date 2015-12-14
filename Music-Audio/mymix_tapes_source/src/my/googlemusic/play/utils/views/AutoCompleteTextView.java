// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.content.Context;
import android.util.AttributeSet;

public class AutoCompleteTextView extends android.widget.AutoCompleteTextView
{

    public AutoCompleteTextView(Context context)
    {
        super(context);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void performFiltering(CharSequence charsequence, int i)
    {
        super.performFiltering("", i);
    }
}
