// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import com.smule.magicpiano.h;

// Referenced classes of package com.smule.pianoandroid.utils:
//            z

public class FontButton extends Button
{

    private final String a;

    public FontButton(Context context)
    {
        super(context);
        a = getClass().getName();
    }

    public FontButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = getClass().getName();
        a(context, attributeset);
    }

    public FontButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = getClass().getName();
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, h.FontView);
        String s = attributeset.getString(0);
        if (s == null)
        {
            Log.e(a, (new StringBuilder()).append("no font attribute set for ").append(a).append("instance").toString());
        } else
        {
            setTypeface(z.a(context, s));
        }
        attributeset.recycle();
    }
}
