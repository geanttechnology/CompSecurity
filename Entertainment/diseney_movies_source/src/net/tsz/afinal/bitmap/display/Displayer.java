// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.widget.ImageView;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;

public interface Displayer
{

    public abstract void loadCompletedisplay(ImageView imageview, Bitmap bitmap, BitmapDisplayConfig bitmapdisplayconfig);

    public abstract void loadFailDisplay(ImageView imageview, Bitmap bitmap);
}
