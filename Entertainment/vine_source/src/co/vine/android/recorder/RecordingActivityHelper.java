// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import co.vine.android.service.ResourceService;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;

public class RecordingActivityHelper
{

    private ServiceConnection mConnection;
    public boolean mIsBound;

    public RecordingActivityHelper()
    {
        mConnection = new ServiceConnection() {

            final RecordingActivityHelper this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                SLog.i("Camera service connected.");
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                SLog.i("Camera service disconnected.");
            }

            
            {
                this$0 = RecordingActivityHelper.this;
                super();
            }
        };
    }

    public void bindCameraService(Activity activity)
    {
        if (!mIsBound)
        {
            if (activity.bindService(new Intent(activity, co/vine/android/service/ResourceService), mConnection, 1))
            {
                mIsBound = true;
                return;
            } else
            {
                CrashUtil.log("Failed to bind camera service.");
                return;
            }
        } else
        {
            SLog.d("Camera service already binded. ");
            return;
        }
    }

    public void unBindCameraService(Activity activity)
    {
        if (mIsBound)
        {
            activity.unbindService(mConnection);
            mIsBound = false;
        }
    }
}
