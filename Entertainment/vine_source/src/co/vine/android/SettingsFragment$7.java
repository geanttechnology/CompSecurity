// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package co.vine.android:
//            SettingsFragment

class val.verified
    implements Runnable
{

    final SettingsFragment this$0;
    final ScrollView val$scrollView;
    final View val$verified;

    public void run()
    {
        val$scrollView.smoothScrollTo(0, val$verified.getBottom());
    }

    ()
    {
        this$0 = final_settingsfragment;
        val$scrollView = scrollview;
        val$verified = View.this;
        super();
    }
}
