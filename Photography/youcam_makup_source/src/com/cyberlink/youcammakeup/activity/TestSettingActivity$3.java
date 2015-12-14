// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            TestSettingActivity

class a
    implements android.view..TestSettingActivity._cls3
{

    final TestSettingActivity a;

    public void onClick(View view)
    {
        TestSettingActivity.d(a, TestSettingActivity.e(a).getText().toString());
        TestSettingActivity.d(a, TestSettingActivity.b(a, TestSettingActivity.f(a)));
        TestSettingActivity.e(a).setText(TestSettingActivity.f(a));
    }

    (TestSettingActivity testsettingactivity)
    {
        a = testsettingactivity;
        super();
    }
}
