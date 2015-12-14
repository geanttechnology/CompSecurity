// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i

final class a
    implements android.view..OnClickListener
{

    private Dialog a;

    public final void onClick(View view)
    {
        a.dismiss();
    }

    (Dialog dialog)
    {
        a = dialog;
        super();
    }
}
