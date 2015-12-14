// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.content.DialogInterface;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a
    implements android.content.e.OnCancelListener
{

    private MapActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }

    stener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
