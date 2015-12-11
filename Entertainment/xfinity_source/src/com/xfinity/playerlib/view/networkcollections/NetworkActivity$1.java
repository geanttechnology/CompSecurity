// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkActivity

class this._cls0
    implements com.comcast.cim.android.image.oadListener
{

    final NetworkActivity this$0;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
        title.setVisibility(8);
        imageview.setVisibility(0);
    }

    public void onLoadError(ImageView imageview, String s)
    {
        title.setVisibility(0);
    }

    ()
    {
        this$0 = NetworkActivity.this;
        super();
    }
}
