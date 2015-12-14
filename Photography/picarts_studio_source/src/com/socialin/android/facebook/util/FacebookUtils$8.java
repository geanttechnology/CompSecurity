// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.socialin.android.facebook.l;
import com.socialin.android.facebook.p;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class b
    implements p
{

    private Activity a;
    private Bundle b;

    public final void a()
    {
        if (a == null || a.isFinishing())
        {
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClassName(a.getPackageName(), "com.socialin.android.facebook.FacebookPageListActivity");
            intent.setFlags(0x24000000);
            b.putString("userId", FacebookUtils.access$300().a);
            b.putString("userScreenName", FacebookUtils.access$300().d);
            intent.putExtras(b);
            a.startActivity(intent);
            a.finish();
            return;
        }
    }

    (Activity activity, Bundle bundle)
    {
        a = activity;
        b = bundle;
        super();
    }
}
