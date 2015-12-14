// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.instamag.activity.view.TMaskScrollImageView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;

public class bfr
    implements bjg
{

    final boolean a;
    final TMaskScrollImageView b;

    public bfr(TMaskScrollImageView tmaskscrollimageview, boolean flag)
    {
        b = tmaskscrollimageview;
        a = flag;
        super();
    }

    public void a(int i)
    {
    }

    public void a(Bitmap bitmap, int i)
    {
        i = (int)TMaskScrollImageView.access$300(b).gaussianBlur;
        try
        {
            Bitmap bitmap1 = bfb.a(b.getContext(), bitmap, i);
            b.updateBackgroundImage(bitmap1, a);
            return;
        }
        catch (Exception exception)
        {
            Log.v("TMaskScrollImageView", (new StringBuilder()).append("TMaskScrollImageView ").append(exception.toString()).toString());
        }
        b.updateBackgroundImage(bitmap, a);
    }

    public void a(Exception exception)
    {
    }
}
