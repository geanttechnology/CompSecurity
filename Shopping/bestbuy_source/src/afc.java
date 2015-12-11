// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class afc extends aid
{

    private Handler a;

    afc(ahx ahx, Looper looper)
    {
        if (looper == null)
        {
            ahx = new afb(ahx);
        } else
        {
            ahx = new afb(ahx, looper);
        }
        a = ahx;
    }

    public void a()
    {
        a = null;
    }

    public void a(Location location)
    {
        if (a == null)
        {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
            return;
        } else
        {
            Message message = Message.obtain();
            message.what = 1;
            message.obj = location;
            a.sendMessage(message);
            return;
        }
    }
}
