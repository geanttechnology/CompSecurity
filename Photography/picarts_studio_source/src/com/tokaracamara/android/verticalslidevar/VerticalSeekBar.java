// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tokaracamara.android.verticalslidevar;

import android.content.Context;
import android.util.AttributeSet;
import com.melnykov.fab.a;

// Referenced classes of package com.tokaracamara.android.verticalslidevar:
//            AbsVerticalSeekBar

public class VerticalSeekBar extends AbsVerticalSeekBar
{

    private a g;

    public VerticalSeekBar(Context context)
    {
        this(context, null);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101007b);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    final void a(float f, boolean flag)
    {
        super.a(f, flag);
        if (g != null)
        {
            a();
        }
    }

    public void setOnSeekBarChangeListener$3081df52(a a1)
    {
        g = a1;
    }
}
