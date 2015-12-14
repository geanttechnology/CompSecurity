// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class setColorFilter extends commenProcess
{

    public int add;
    public int mul;

    setColorFilter()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        paint.setColorFilter(new LightingColorFilter(mul, add));
    }
}
