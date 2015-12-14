// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.view.View;
import com.socialin.android.constants.EventParam;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class a
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        i.a(a, "ad_remover", EventParam.NOTIFICATIONS.getName(), com.socialin.android.constants.onConstants.InviteMode.AD_REMOVER);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
