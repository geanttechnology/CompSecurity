// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class a
    implements android.content.er
{

    private DeviantArtOAuthMainActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.setResult(1);
        a.finish();
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        a = deviantartoauthmainactivity;
        super();
    }
}
