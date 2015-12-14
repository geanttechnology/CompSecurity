// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.fotoable.fotobeauty.WantuActivity;

public class adb
    implements Runnable
{

    public long a;
    final WantuActivity b;

    public adb(WantuActivity wantuactivity)
    {
        b = wantuactivity;
        super();
    }

    public void run()
    {
        try
        {
            WantuActivity.a(b, a);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b.r.postDelayed(b.t, b.s);
    }
}
