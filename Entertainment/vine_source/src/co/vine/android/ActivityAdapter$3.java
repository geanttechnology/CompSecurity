// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import co.vine.android.api.VineEverydayNotification;

// Referenced classes of package co.vine.android:
//            ActivityAdapter, UsersActivity

class this._cls0
    implements android.view.er
{

    final ActivityAdapter this$0;

    public void onClick(View view)
    {
        view = (VineEverydayNotification)view.getTag();
        UsersActivity.launchUserListForNotification(ActivityAdapter.access$000(ActivityAdapter.this), ((VineEverydayNotification) (view)).notificationId, ((VineEverydayNotification) (view)).anchor);
    }

    tification()
    {
        this$0 = ActivityAdapter.this;
        super();
    }
}
