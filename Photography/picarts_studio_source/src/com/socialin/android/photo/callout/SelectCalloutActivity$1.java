// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a
    implements android.content.Listener
{

    private SelectCalloutActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }

    (SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
