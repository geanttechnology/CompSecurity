// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.other.SeperateMovieBar;

public class nk extends Handler
{

    final ActivityCameraNew a;

    public nk(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            ActivityCameraNew.b(a).processCapturing();
            return;

        case 1: // '\001'
            message = ActivityCameraNew.a(a, ActivityCameraNew.c(a));
            ActivityCameraNew.d(a).setText(message);
            ActivityCameraNew.d(a).invalidate();
            return;

        case 2: // '\002'
            ActivityCameraNew.a(a, true);
            ActivityCameraNew.e(a);
            return;

        case 3: // '\003'
            ActivityCameraNew.b(a, ((Boolean)message.obj).booleanValue());
            break;
        }
    }
}
