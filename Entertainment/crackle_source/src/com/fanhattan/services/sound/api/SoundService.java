// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.sound.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.fanhattan.services.api.BaseServiceBinder;

// Referenced classes of package com.fanhattan.services.sound.api:
//            ISoundService

public final class SoundService extends BaseServiceBinder
{

    public static final int ALL = 2;
    public static final int NONE = 0;
    public static final int SOME = 1;
    public static final int SOUND_ID_BACK = 3;
    public static final int SOUND_ID_BUMP = 4;
    public static final int SOUND_ID_CURSOR = 0;
    public static final int SOUND_ID_ERROR = 6;
    public static final int SOUND_ID_NOTIFICATION = 8;
    public static final int SOUND_ID_POPUP = 5;
    public static final int SOUND_ID_SUCCESS = 7;
    public static final int SOUND_ID_SWIPE = 1;
    public static final int SOUND_ID_TAP = 2;
    public static final int SOUND_ID_WATCHLIST = 9;
    private static final String TAG = "SoundService";

    public SoundService(Context context)
    {
        super(context, false, "SoundService");
    }

    protected ISoundService castService(IBinder ibinder)
    {
        return ISoundService.Stub.asInterface(ibinder);
    }

    protected volatile Object castService(IBinder ibinder)
    {
        return castService(ibinder);
    }

    protected Intent getIntent()
    {
        Intent intent = new Intent("sound");
        intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
        return intent;
    }

    public int getMode()
    {
        int i = -1;
        ISoundService isoundservice = (ISoundService)getService();
        if (isoundservice != null)
        {
            try
            {
                i = isoundservice.getMode();
            }
            catch (Exception exception)
            {
                Log.e("SoundService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return -1;
            }
        }
        return i;
    }

    public void onPause()
    {
        unbind();
    }

    public void onResume()
    {
        bind();
    }

    public void play(int i)
    {
        ISoundService isoundservice;
        isoundservice = (ISoundService)getService();
        if (isoundservice == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        isoundservice.play(i);
        return;
        Exception exception;
        exception;
        Log.e("SoundService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
        return;
    }

    public void setMode(int i)
    {
        ISoundService isoundservice;
        isoundservice = (ISoundService)getService();
        if (isoundservice == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        isoundservice.setMode(i);
        return;
        Exception exception;
        exception;
        Log.e("SoundService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
        return;
    }

    public void setVolume(float f)
    {
        ISoundService isoundservice;
        isoundservice = (ISoundService)getService();
        if (isoundservice == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        isoundservice.setVolume(f);
        return;
        Exception exception;
        exception;
        Log.e("SoundService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
        return;
    }
}
