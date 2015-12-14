// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractPanel

public static interface 
{

    public abstract void onPreviewChange(Bitmap bitmap, boolean flag);

    public abstract void onPreviewChange(Drawable drawable, boolean flag);

    public abstract void onPreviewUpdated();
}
