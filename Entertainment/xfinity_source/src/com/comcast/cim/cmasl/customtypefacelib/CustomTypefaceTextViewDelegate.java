// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.customtypefacelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package com.comcast.cim.cmasl.customtypefacelib:
//            TextStylable, TypefaceManager, TypefaceFamily

public class CustomTypefaceTextViewDelegate
    implements TextStylable
{

    private String typefaceFamilyName;
    private TypefaceManager typefaceManager;
    private int typefaceStyle;
    private TextView view;

    public CustomTypefaceTextViewDelegate(TextView textview)
    {
        view = textview;
    }

    public void setCustomTypeface()
    {
        if (typefaceFamilyName != null && !typefaceFamilyName.isEmpty())
        {
            Typeface typeface = typefaceManager.getTypeface(typefaceFamilyName, typefaceStyle);
            if (typeface == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("A font for the \"").append(typefaceFamilyName).append("\" has not been defined.").toString());
            }
            view.setPaintFlags(view.getPaintFlags() | 0x80);
            view.setTypeface(typeface);
        }
    }

    public void setTypefaceFamilyName(String s)
    {
        if (!s.equals(typefaceFamilyName))
        {
            typefaceFamilyName = s;
            setCustomTypeface();
        }
    }

    public void setTypefaceStyle(int i)
    {
        if (typefaceStyle != i)
        {
            typefaceStyle = i;
            setCustomTypeface();
        }
    }

    public void setup(Context context, AttributeSet attributeset, int i, TypefaceManager typefacemanager)
    {
        typefaceManager = typefacemanager;
        if (typefacemanager == null)
        {
            throw new IllegalArgumentException("A non-null TypefaceManager must be provided");
        }
        context = context.obtainStyledAttributes(attributeset, R.styleable.com_comcast_cim_android_typeface_CustomTypefaceTextView, i, 0);
        if (context.hasValue(0))
        {
            typefaceFamilyName = context.getString(0);
        }
        attributeset = view.getTypeface();
        if (attributeset != null)
        {
            typefaceStyle = TypefaceFamily.getCustomStyleIdForAndroidStyle(attributeset.getStyle());
        }
        if (context.hasValue(1))
        {
            typefaceStyle = context.getInt(1, 0);
        }
        context.recycle();
        setCustomTypeface();
    }
}
