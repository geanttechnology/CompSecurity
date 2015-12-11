// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public final class ckq extends ckx
    implements android.view.SurfaceHolder.Callback, cke
{

    public ckq(Context context)
    {
        super(context);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            c.setSecure(true);
            return;
        } else
        {
            throw new UnsupportedOperationException();
        }
    }
}
