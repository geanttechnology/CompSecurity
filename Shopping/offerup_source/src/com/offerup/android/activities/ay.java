// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity

final class ay
    implements android.content.DialogInterface.OnClickListener
{

    private ChangePostLocationActivity a;

    ay(ChangePostLocationActivity changepostlocationactivity)
    {
        a = changepostlocationactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.i();
    }
}
