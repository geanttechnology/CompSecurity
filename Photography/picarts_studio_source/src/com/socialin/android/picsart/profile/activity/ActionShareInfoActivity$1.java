// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ActionShareInfoActivity

final class a
    implements p
{

    private ActionShareInfoActivity a;

    public final void a()
    {
        if (FacebookUtils.isSessionValid() && FacebookUtils.isUserConnected())
        {
            ActionShareInfoActivity.a(a);
            return;
        } else
        {
            a.finish();
            return;
        }
    }

    (ActionShareInfoActivity actionshareinfoactivity)
    {
        a = actionshareinfoactivity;
        super();
    }
}
