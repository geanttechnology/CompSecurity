// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.Button;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity

final class at
    implements android.view.View.OnClickListener
{

    private ChangePostLocationActivity a;

    at(ChangePostLocationActivity changepostlocationactivity)
    {
        a = changepostlocationactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.c = true;
        a.d = false;
        a.k.setText("Save");
    }
}
