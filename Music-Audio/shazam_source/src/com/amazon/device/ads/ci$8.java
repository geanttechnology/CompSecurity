// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;

// Referenced classes of package com.amazon.device.ads:
//            ci, bs, dq

final class a
    implements android.content.gInterface.OnClickListener
{

    final Bitmap a;
    final ci b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        ci.c(b);
        dialoginterface = bs.a(ci.b(b), a, "AdImage", "Image created by rich media ad.");
        if (dq.a(dialoginterface))
        {
            ci.a(b, "Picture could not be stored to device.", "storePicture");
            return;
        } else
        {
            MediaScannerConnection.scanFile(ci.b(b), new String[] {
                dialoginterface
            }, null, null);
            return;
        }
    }

    face(ci ci1, Bitmap bitmap)
    {
        b = ci1;
        a = bitmap;
        super();
    }
}
