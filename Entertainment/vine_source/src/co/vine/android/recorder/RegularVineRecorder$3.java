// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder

class this._cls0
    implements Runnable
{

    final RegularVineRecorder this$0;

    public void run()
    {
        mHandler.post(new Runnable() {

            final RegularVineRecorder._cls3 this$1;

            public void run()
            {
                if (mActivity != null)
                {
                    Toast.makeText(mActivity, mDeviceNotSupportedString, 0).show();
                    mActivity.finish();
                }
            }

            
            {
                this$1 = RegularVineRecorder._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = RegularVineRecorder.this;
        super();
    }
}
