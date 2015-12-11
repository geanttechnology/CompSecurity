// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class afb extends Handler
{

    private final ahx a;

    public afb(ahx ahx1)
    {
        a = ahx1;
    }

    public afb(ahx ahx1, Looper looper)
    {
        super(looper);
        a = ahx1;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            return;

        case 1: // '\001'
            message = new Location((Location)message.obj);
            break;
        }
        a.onLocationChanged(message);
    }
}
