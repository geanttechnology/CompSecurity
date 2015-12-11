// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import co.vine.android.VineLoggingException;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.view.tener
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
                mSwitchCameraTask = new RegularVineRecorder.ResumeCameraAsyncTask(true) {

                    final VineRecorder._cls3 this$1;

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        VineRecorder.access$000(this$0);
                    }

            
            {
                this$1 = VineRecorder._cls3.this;
                super(this$0, flag);
            }
                };
                mSwitchCameraTask.execute(new Void[0]);
            }
            return;
        }
        CrashUtil.logException(new VineLoggingException("You can not switch camera after recording has started."), "Person trying to record and switch? not cool.", new Object[0]);
    }

    rder()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
