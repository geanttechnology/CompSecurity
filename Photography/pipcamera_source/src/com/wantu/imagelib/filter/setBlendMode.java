// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class setBlendMode extends commenProcess
{

    public android.graphics.PorterDuff.Mode mode;

    setBlendMode()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        paint.setXfermode(new PorterDuffXfermode(mode));
    }
}
