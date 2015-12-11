// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.customtypefacelib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

// Referenced classes of package com.comcast.cim.cmasl.customtypefacelib:
//            TextStylable, CustomTypefaceTextViewDelegate, TypefaceManager

public class CustomTypefaceButton extends Button
    implements TextStylable
{

    private final CustomTypefaceTextViewDelegate customTypefaceTextViewDelegate = new CustomTypefaceTextViewDelegate(this);

    public CustomTypefaceButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void setTypefaceFamilyName(String s)
    {
        customTypefaceTextViewDelegate.setTypefaceFamilyName(s);
    }

    public void setTypefaceStyle(int i)
    {
        customTypefaceTextViewDelegate.setTypefaceStyle(i);
    }

    public void setupDelegate(Context context, AttributeSet attributeset, int i, TypefaceManager typefacemanager)
    {
        customTypefaceTextViewDelegate.setup(context, attributeset, i, typefacemanager);
    }
}
