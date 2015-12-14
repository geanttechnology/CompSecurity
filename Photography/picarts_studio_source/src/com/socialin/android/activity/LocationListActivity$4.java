// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.activity:
//            LocationListActivity

final class a
    implements android.content.Listener
{

    private LocationListActivity a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        a.finish();
    }

    (LocationListActivity locationlistactivity)
    {
        a = locationlistactivity;
        super();
    }
}
