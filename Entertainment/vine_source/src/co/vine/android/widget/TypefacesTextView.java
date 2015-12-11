// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import co.vine.android.views.SdkTextView;

// Referenced classes of package co.vine.android.widget:
//            Typefaces

public class TypefacesTextView extends SdkTextView
{

    private int mWeight;

    public TypefacesTextView(Context context)
    {
        super(context);
    }

    public TypefacesTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TypefacesTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.VineTextView, i, 0);
        i = attributeset.getInt(1, 0);
        mWeight = attributeset.getInt(0, 2);
        attributeset.recycle();
        setTypeface(Typefaces.get(context).getContentTypeface(i, mWeight), i);
        setPaintFlags(getPaintFlags() | 1);
    }

    public void setTypeface(Typeface typeface, int i)
    {
        super.setTypeface(Typefaces.get(getContext()).getContentTypeface(i, mWeight));
    }

    public void setWeight(int i)
    {
        mWeight = i;
    }
}
