// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.pipcamera.activity.PIPCameraActivity;

public class rw
    implements Runnable
{

    public long a;
    final PIPCameraActivity b;

    public rw(PIPCameraActivity pipcameraactivity)
    {
        b = pipcameraactivity;
        super();
    }

    public void run()
    {
        try
        {
            PIPCameraActivity.a(b, a);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b.y.postDelayed(b.A, b.z);
    }
}
