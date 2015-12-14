// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.text.TextUtils;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ShareGroupActivity

final class a
    implements android.view.tener
{

    private View a;
    private ShareGroupActivity b;

    public final void onFocusChange(View view, boolean flag)
    {
        if (!flag && TextUtils.isEmpty(ShareGroupActivity.c(b)))
        {
            a.setVisibility(8);
        } else
        if (!TextUtils.isEmpty(ShareGroupActivity.c(b)))
        {
            a.setVisibility(0);
            return;
        }
    }

    (ShareGroupActivity sharegroupactivity, View view)
    {
        b = sharegroupactivity;
        a = view;
        super();
    }
}
