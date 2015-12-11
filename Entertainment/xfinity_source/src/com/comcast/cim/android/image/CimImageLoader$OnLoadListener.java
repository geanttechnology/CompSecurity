// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.comcast.cim.android.image:
//            CimImageLoader

public static interface A
{

    public abstract void onLoad(ImageView imageview, String s, Bitmap bitmap);

    public abstract void onLoadError(ImageView imageview, String s);
}
