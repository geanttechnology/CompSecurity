// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.offerup.android.activities:
//            gf, ProfileImageActivity

final class gg
    implements android.content.DialogInterface.OnClickListener
{

    private gf a;

    gg(gf gf1)
    {
        a = gf1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        a.a.startActivityForResult(dialoginterface, 522);
    }
}
