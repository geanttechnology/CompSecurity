// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.AudioManager;

final class es extends eo
{

    private AudioManager c;

    public es(Context context)
    {
        super(context);
        c = (AudioManager)a.getSystemService("audio");
    }

    public final void d()
    {
        c.startBluetoothSco();
    }

    public final void e()
    {
        c.stopBluetoothSco();
    }

    public final int f()
    {
        return !b() ? 3 : 0;
    }

    public final int g()
    {
        if (b())
        {
            return en.a;
        } else
        {
            return 6;
        }
    }
}
