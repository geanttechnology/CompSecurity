// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import co.vine.android.VineLoggingException;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class er extends er.ResumeCameraAsyncTask
{

    final is._cls0 this$1;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        VineRecorder.access$000(_fld0);
    }

    er(boolean flag)
    {
        this$1 = this._cls1.this;
        super(_fld0, flag);
    }

    // Unreferenced inner class co/vine/android/recorder/VineRecorder$3

/* anonymous class */
    class VineRecorder._cls3
        implements android.view.View.OnClickListener
    {

        final VineRecorder this$0;

        public void onClick(View view)
        {
label0:
            {
                if (!mIsSwitchingCamera && mCanKeepRecording)
                {
                    if (!canSwitchCamera())
                    {
                        break label0;
                    }
                    mSwitchCameraTask = new VineRecorder._cls3._cls1(true);
                    mSwitchCameraTask.execute(new Void[0]);
                }
                return;
            }
            CrashUtil.logException(new VineLoggingException("You can not switch camera after recording has started."), "Person trying to record and switch? not cool.", new Object[0]);
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    }

}
