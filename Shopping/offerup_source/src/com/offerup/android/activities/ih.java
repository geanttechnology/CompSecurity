// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.view.View;
import com.offerup.android.network.UserRelationService;
import com.offerup.android.network.o;
import java.util.concurrent.Executors;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity, ir

final class ih
    implements android.view.View.OnClickListener
{

    private UserDetailActivity a;

    ih(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.g = ProgressDialog.show(a, "", a.getString(0x7f090219));
        long l = UserDetailActivity.b(a);
        view = new ir(a, (byte)0);
        o.b(o.c(Executors.newCachedThreadPool())).setUnfollow(l, view);
    }
}
