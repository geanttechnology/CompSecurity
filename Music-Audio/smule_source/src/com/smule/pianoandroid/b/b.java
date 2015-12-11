// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.b;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.smule.pianoandroid.b:
//            a

final class b extends android.graphics.drawable.Drawable.ConstantState
{

    Drawable a;
    int b;
    int c;
    int d;
    private boolean e;
    private boolean f;

    b(b b1, a a1, Resources resources)
    {
        c = 1;
        if (b1 != null)
        {
            if (resources != null)
            {
                a = b1.a.getConstantState().newDrawable(resources);
            } else
            {
                a = b1.a.getConstantState().newDrawable();
            }
            a.setCallback(a1);
            c = b1.c;
            d = b1.d;
            f = true;
            e = true;
        }
    }

    boolean a()
    {
        if (!e)
        {
            boolean flag;
            if (a.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            e = true;
        }
        return f;
    }

    public int getChangingConfigurations()
    {
        return b;
    }

    public Drawable newDrawable()
    {
        return new a(this, null, null);
    }

    public Drawable newDrawable(Resources resources)
    {
        return new a(this, resources, null);
    }
}
