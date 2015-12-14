// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.exporter;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.exporter:
//            SaveAndShareActivity

final class a
    implements android.content.lListener
{

    private SaveAndShareActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }

    (SaveAndShareActivity saveandshareactivity)
    {
        a = saveandshareactivity;
        super();
    }
}
