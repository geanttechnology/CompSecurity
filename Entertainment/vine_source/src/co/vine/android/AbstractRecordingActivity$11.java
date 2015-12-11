// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, DraftFragment

class this._cls0
    implements Runnable
{

    final AbstractRecordingActivity this$0;

    public void run()
    {
        if (AbstractRecordingActivity.access$2500(AbstractRecordingActivity.this).getCount() != 1 && mCurrentPage != AbstractRecordingActivity.access$2500(AbstractRecordingActivity.this).getCount() - 1)
        {
            AbstractRecordingActivity.access$2602(AbstractRecordingActivity.this, (co.vine.android.recorder.ssionInfo)AbstractRecordingActivity.access$2700(AbstractRecordingActivity.this).get(mCurrentPage));
            Object obj = (WeakReference)AbstractRecordingActivity.access$000(AbstractRecordingActivity.this).get(mCurrentPage);
            if (obj != null)
            {
                obj = (DraftFragment)((WeakReference) (obj)).get();
                if (obj != null)
                {
                    ((DraftFragment) (obj)).setSelected(true);
                }
            }
        }
    }

    .RecordSessionInfo()
    {
        this$0 = AbstractRecordingActivity.this;
        super();
    }
}
