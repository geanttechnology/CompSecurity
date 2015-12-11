// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;

abstract class kb extends ii
{

    protected kb(Context context)
    {
        super(context, new il(new ComponentName("android", kb.getName())));
    }

    public static kb a(Context context, kl kl)
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            return new kh(context, kl);
        }
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            return new kg(context, kl);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new kc(context, kl);
        } else
        {
            return new ki(context);
        }
    }

    public void a(iz iz)
    {
    }

    public void b(iz iz)
    {
    }

    public void c(iz iz)
    {
    }

    public void d(iz iz)
    {
    }
}
