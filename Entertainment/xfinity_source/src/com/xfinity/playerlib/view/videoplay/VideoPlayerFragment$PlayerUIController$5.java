// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls1
    implements com.comcast.cim.android.image.ller._cls5
{

    final is._cls0 this$1;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
        VideoPlayerFragment.access$3600(_fld0).setVisibility(8);
        VideoPlayerFragment.access$3700(_fld0).setVisibility(0);
    }

    public void onLoadError(ImageView imageview, String s)
    {
        VideoPlayerFragment.access$3700(_fld0).setVisibility(8);
        VideoPlayerFragment.access$3600(_fld0).setVisibility(0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
