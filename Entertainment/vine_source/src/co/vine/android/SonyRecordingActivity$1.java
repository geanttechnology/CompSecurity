// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;

// Referenced classes of package co.vine.android:
//            SonyRecordingActivity, RecordingFragment

class this._cls0
    implements android.view.._cls1
{

    final SonyRecordingActivity this$0;

    public void onClick(View view)
    {
        boolean flag;
label0:
        {
            if (SonyRecordingActivity.access$000(SonyRecordingActivity.this) != null)
            {
                view = (RecordingFragment)mCurrentFragment;
                if (view != null)
                {
                    flag = view.isEditing();
                    if (flag || view.isSessionModified())
                    {
                        break label0;
                    }
                    view.setDiscardChangesOnStop();
                    SonyRecordingActivity.access$100(SonyRecordingActivity.this);
                }
            }
            return;
        }
        if (flag && !view.isEditingDirty())
        {
            view.discardEditing();
            SonyRecordingActivity.access$100(SonyRecordingActivity.this);
            return;
        } else
        {
            showUnSavedChangesDialog(0, view);
            return;
        }
    }

    ()
    {
        this$0 = SonyRecordingActivity.this;
        super();
    }
}
