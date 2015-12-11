// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.view.View;

// Referenced classes of package co.vine.android:
//            NotificationSettingsFragment, NotificationAlertsSettingsActivity

class this._cls0
    implements android.view.._cls1
{

    final NotificationSettingsFragment this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), co/vine/android/NotificationAlertsSettingsActivity);
        startActivity(view);
    }

    ity()
    {
        this$0 = NotificationSettingsFragment.this;
        super();
    }
}
