// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class zy extends BitmapDrawable
{

    private int a;
    private int b;
    private boolean c;

    public zy(Resources resources, Bitmap bitmap)
    {
        super(resources, bitmap);
        a = 0;
        b = 0;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (a <= 0 && b <= 0 && c && c())
        {
            getBitmap().recycle();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = getBitmap();
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        boolean flag = bitmap.isRecycled();
        if (flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        b = b + 1;
        c = true;
_L1:
        this;
        JVM INSTR monitorexit ;
        b();
        return;
        b = b - 1;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        if (a > 0 || b > 0 || !c) goto _L2; else goto _L1
_L1:
        boolean flag = c();
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        a = a + 1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        a = a - 1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
