// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.Intent;
import android.view.View;
import com.offerup.android.activities.ChangePostLocationActivity;

// Referenced classes of package com.offerup.android.g.c:
//            z

final class ac
    implements android.view.View.OnClickListener
{

    private z a;

    ac(z z1)
    {
        a = z1;
        super();
    }

    public final void onClick(View view)
    {
        view = new Intent(a.getActivity(), com/offerup/android/activities/ChangePostLocationActivity);
        a.startActivityForResult(view, 4);
    }
}
