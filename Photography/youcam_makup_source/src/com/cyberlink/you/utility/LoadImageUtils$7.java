// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import com.cyberlink.you.g;
import com.nostra13.universalimageloader.core.e.a;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

final class b
    implements a
{

    final int a;
    final int b;

    public Bitmap a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            return com.cyberlink.you.pages.photoimport.a.a.a(g.a(), bitmap, a / 10, a / 10, 0.0F, 0.0F, a, b);
        } else
        {
            return null;
        }
    }

    (int i, int j)
    {
        a = i;
        b = j;
        super();
    }
}
