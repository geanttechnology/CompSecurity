// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.view.View;
import com.socialin.android.dialog.a;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements android.view.r
{

    private ProfileActivity a;

    public final void onClick(View view)
    {
        ProfileActivity.u(a).dismiss();
        ProfileActivity.b(a);
    }

    (ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
