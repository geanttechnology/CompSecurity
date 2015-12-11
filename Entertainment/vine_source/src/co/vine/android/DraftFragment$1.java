// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android:
//            DraftFragment

class this._cls0
    implements Runnable
{

    final DraftFragment this$0;

    public void run()
    {
        if (DraftFragment.access$000(DraftFragment.this).getVisibility() != 0 && mCanUnhide)
        {
            DraftFragment.access$000(DraftFragment.this).setVisibility(0);
        }
    }

    iew()
    {
        this$0 = DraftFragment.this;
        super();
    }
}
