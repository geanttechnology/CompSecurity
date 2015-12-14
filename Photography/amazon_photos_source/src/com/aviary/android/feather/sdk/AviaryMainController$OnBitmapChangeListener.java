// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController

public static interface 
{

    public abstract void onBitmapChange(Bitmap bitmap, boolean flag, Matrix matrix);

    public abstract void onInvalidateBitmap();

    public abstract void onPreviewChange(Bitmap bitmap, boolean flag);

    public abstract void onPreviewChange(Drawable drawable, boolean flag);
}
