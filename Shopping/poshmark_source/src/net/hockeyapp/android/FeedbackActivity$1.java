// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import net.hockeyapp.android.utils.PrefsUtil;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity

class this._cls0
    implements Runnable
{

    final FeedbackActivity this$0;

    public void run()
    {
        PrefsUtil.getInstance().saveFeedbackTokenToPrefs(FeedbackActivity.this, null);
        configureFeedbackView(false);
    }

    ()
    {
        this$0 = FeedbackActivity.this;
        super();
    }
}
