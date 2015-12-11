// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.view.ener
{

    final VineRecorder this$0;

    public void onClick(View view)
    {
        if (!VineRecorder.access$500(VineRecorder.this))
        {
            view = VineRecorder.this;
            ProgressView progressview = mProgressView;
            boolean flag;
            if (!VineRecorder.access$4000(VineRecorder.this))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setEditMode(progressview, flag, false);
        }
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
