// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;

// Referenced classes of package com.a.b:
//            l, ao, d, ad, 
//            n, h, as, a

final class v extends l
{

    v(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(context, ad, n, h, as, a1);
    }

    final Bitmap a(ao ao1)
    {
        (new ExifInterface(ao1.a.getPath())).getAttributeInt("Orientation", 1);
        JVM INSTR tableswitch 3 8: default 60
    //                   3 79
    //                   4 60
    //                   5 60
    //                   6 73
    //                   7 60
    //                   8 86;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L4
_L1:
        int i = 0;
_L6:
        super.n = i;
        return super.a(ao1);
_L3:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 270;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
