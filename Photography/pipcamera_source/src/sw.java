// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import java.util.ArrayList;

public class sw
    implements tt
{

    PipRealTimeCameraActivity a;

    public sw(PipRealTimeCameraActivity piprealtimecameraactivity)
    {
        a = piprealtimecameraactivity;
    }

    public void a(float f, Object obj)
    {
        Log.v("aa", "downloadUploadData");
    }

    public void a(int i, Object obj)
    {
        Log.v("aa", "downloadFailed");
        a.b();
    }

    public void a(Object obj)
    {
        Log.v("aa", "downloadStarting");
    }

    public void a(tu tu)
    {
        Log.v("aa", "updateStarting");
    }

    public void a(tu tu, int i)
    {
    }

    public void a(tu tu, ArrayList arraylist)
    {
    }

    public void b(Object obj)
    {
        Log.v("aa", "downloadFinished");
        a.b();
    }

    public void b(tu tu, int i)
    {
    }
}
