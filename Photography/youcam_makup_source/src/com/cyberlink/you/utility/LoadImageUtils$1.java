// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.nostra13.universalimageloader.core.d.c;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

final class  extends c
{

    public void a(String s, View view, Bitmap bitmap)
    {
        Log.d("LoadImageUtils", (new StringBuilder()).append("[loadAvatar] loadedImage width=").append(bitmap.getWidth()).append(" height=").append(bitmap.getHeight()).toString());
    }

    ()
    {
    }
}
