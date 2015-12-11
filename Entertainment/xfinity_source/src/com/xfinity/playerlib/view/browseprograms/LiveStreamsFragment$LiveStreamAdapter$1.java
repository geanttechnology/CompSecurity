// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class val.holder
    implements com.comcast.cim.android.image.amAdapter._cls1
{

    final ceholderTitle this$1;
    final ceholderTitle val$holder;
    final boolean val$placeHolderTitleIsPresent;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
        if (val$placeHolderTitleIsPresent)
        {
            val$holder.ceholderTitle.setText(null);
        }
    }

    public void onLoadError(ImageView imageview, String s)
    {
    }

    ()
    {
        this$1 = final_;
        val$placeHolderTitleIsPresent = flag;
        val$holder = val.holder.this;
        super();
    }
}
