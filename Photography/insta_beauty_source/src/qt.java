// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.PhotoViewerPagerAdapter;

public class qt
    implements pr
{

    final PhotoViewerPagerAdapter a;

    public qt(PhotoViewerPagerAdapter photoviewerpageradapter)
    {
        a = photoviewerpageradapter;
        super();
    }

    public void a(Bitmap bitmap, ImageView imageview)
    {
        imageview.setImageBitmap(bitmap);
    }
}
