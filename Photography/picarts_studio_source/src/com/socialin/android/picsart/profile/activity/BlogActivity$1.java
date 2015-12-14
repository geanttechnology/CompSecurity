// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BlogActivity

final class a
    implements android.view.tener
{

    private BlogActivity a;

    public final void onClick(View view)
    {
        if (BlogActivity.a(a) != null)
        {
            BlogActivity.a(a).smoothScrollToPosition(0);
        }
    }

    (BlogActivity blogactivity)
    {
        a = blogactivity;
        super();
    }
}
