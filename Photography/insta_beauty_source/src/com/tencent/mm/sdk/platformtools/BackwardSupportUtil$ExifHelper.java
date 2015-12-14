// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.media.ExifInterface;
import java.io.IOException;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public class 
{

    public static int getExifOrientation(String s)
    {
        int i;
        try
        {
            s = new ExifInterface(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MicroMsg.SDK.BackwardSupportUtil", (new StringBuilder("cannot read exif")).append(s).toString());
            s = null;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        i = s.getAttributeInt("Orientation", -1);
        if (i == -1) goto _L2; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 3 8: default 64
    //                   3 96
    //                   4 64
    //                   5 64
    //                   6 93
    //                   7 64
    //                   8 100;
           goto _L2 _L4 _L2 _L2 _L5 _L2 _L6
_L2:
        return 0;
_L5:
        return 90;
_L4:
        return 180;
_L6:
        return 270;
    }

    public ()
    {
    }
}
