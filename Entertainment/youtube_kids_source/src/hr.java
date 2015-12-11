// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class hr extends TextView
{

    public hr(Context context)
    {
        this(context, null);
    }

    public hr(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public hr(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, gl.f, i, 0);
        boolean flag = attributeset.getBoolean(0, false);
        attributeset.recycle();
        if (flag)
        {
            setTransformationMethod(new gm(context));
        }
    }
}
