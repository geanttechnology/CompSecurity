// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.SparseArray;
import android.view.View;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class this._cls0
    implements android.view.._cls3
{

    final AbstractRecordingActivity this$0;

    public void onClick(View view)
    {
        if (mCurrentPage != AbstractRecordingActivity.access$000(AbstractRecordingActivity.this).size())
        {
            AbstractRecordingActivity.access$102(AbstractRecordingActivity.this, false);
            showDeleteDialog();
        }
    }

    ()
    {
        this$0 = AbstractRecordingActivity.this;
        super();
    }
}
