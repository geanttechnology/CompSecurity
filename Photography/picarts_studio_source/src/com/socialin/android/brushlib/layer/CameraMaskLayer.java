// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import java.nio.Buffer;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.layer:
//            a, b

public final class CameraMaskLayer
    implements a
{

    public final Bitmap a;
    public final Canvas b;
    public final MaskPlacement c;
    public final b d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    private final Paint i = new Paint();

    private CameraMaskLayer(b b1, MaskPlacement maskplacement)
    {
        a = Bitmap.createBitmap(b1.i(), b1.j(), android.graphics.Bitmap.Config.ALPHA_8);
        b = new Canvas(a);
        d = b1;
        c = maskplacement;
        i.setFilterBitmap(true);
        i.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        e = false;
        f = UUID.randomUUID().toString();
    }

    public static CameraMaskLayer a(b b1, MaskPlacement maskplacement)
    {
        try
        {
            b1 = new CameraMaskLayer(b1, maskplacement);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            return null;
        }
        return b1;
    }

    public final int a()
    {
        return a.getRowBytes() * a.getHeight();
    }

    public final void a(Canvas canvas)
    {
        canvas.drawBitmap(a, 0.0F, 0.0F, i);
    }

    public final void a(String s)
    {
        g = s;
    }

    public final void a(Buffer buffer)
    {
        g();
        a.copyPixelsToBuffer(buffer);
    }

    public final Canvas b()
    {
        return b;
    }

    public final void b(String s)
    {
        h = s;
    }

    public final void b(Buffer buffer)
    {
        a.copyPixelsFromBuffer(buffer);
    }

    public final void c()
    {
        a.eraseColor(0);
    }

    public final String d()
    {
        return h;
    }

    public final String e()
    {
        return g;
    }

    public final String f()
    {
        return f;
    }

    public final void g()
    {
        if (e)
        {
            throw new IllegalStateException("Cannot draw recycled layer");
        } else
        {
            return;
        }
    }
}
