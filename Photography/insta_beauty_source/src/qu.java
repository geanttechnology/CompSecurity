// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.PhotoViewerPagerAdapter;

public class qu
    implements android.view.View.OnClickListener
{

    final PhotoViewerPagerAdapter a;

    public qu(PhotoViewerPagerAdapter photoviewerpageradapter)
    {
        a = photoviewerpageradapter;
        super();
    }

    public void onClick(View view)
    {
        PhotoViewerPagerAdapter.a(a).a();
    }
}
