// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;

// Referenced classes of package co.vine.android:
//            ActivityAdapter, ProfileActivity

class this._cls0
    implements android.view.er
{

    final ActivityAdapter this$0;

    public void onClick(View view)
    {
        long l = ((Long)view.getTag()).longValue();
        ProfileActivity.start(ActivityAdapter.access$000(ActivityAdapter.this), l, null);
    }

    ()
    {
        this$0 = ActivityAdapter.this;
        super();
    }
}
