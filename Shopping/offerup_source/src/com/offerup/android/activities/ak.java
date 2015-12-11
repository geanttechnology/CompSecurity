// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.Button;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity

final class ak
    implements android.view.View.OnClickListener
{

    private ChangeLocationActivity a;

    ak(ChangeLocationActivity changelocationactivity)
    {
        a = changelocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.c = false;
        a.j.setText("Save");
    }
}
