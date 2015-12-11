// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements Runnable
{

    final RecordingFragment this$0;

    public void run()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            Util.showCenteredToast(fragmentactivity, 0x7f0e00c1);
        }
        if (!RecordingFragment.access$1400(RecordingFragment.this))
        {
            RecordingFragment.access$1402(RecordingFragment.this, true);
            onDraftUpgradeNumberChanged(RecordingFragment.access$1500(RecordingFragment.this));
        }
    }

    ()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
