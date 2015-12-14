// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            CommentImageZoomActivity

final class c
    implements d
{

    private CommentImageZoomActivity a;

    private c(CommentImageZoomActivity commentimagezoomactivity)
    {
        a = commentimagezoomactivity;
        super();
    }

    c(CommentImageZoomActivity commentimagezoomactivity, byte byte0)
    {
        this(commentimagezoomactivity);
    }

    public final boolean a(Object obj)
    {
        obj = (Bitmap)obj;
        if (CommentImageZoomActivity.a(a) != null)
        {
            CommentImageZoomActivity.a(a).getLayoutParams().width = ((Bitmap) (obj)).getWidth();
            CommentImageZoomActivity.a(a).getLayoutParams().height = ((Bitmap) (obj)).getHeight();
        }
        return false;
    }
}
