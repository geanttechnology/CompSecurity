// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.bitstrips.imoji.ui:
//            RetrieveAvatarActivity

class val.image
    implements android.view.wListener
{

    final RetrieveAvatarActivity this$0;
    final ImageView val$image;
    final RelativeLayout val$parent;

    public boolean onPreDraw()
    {
        if (RetrieveAvatarActivity.avatarBitmap == null)
        {
            return true;
        } else
        {
            int i = RetrieveAvatarActivity.avatarBitmap.getWidth();
            int j = RetrieveAvatarActivity.avatarBitmap.getHeight();
            float f = ((float)val$parent.getMeasuredHeight() * 0.9F) / (float)j;
            val$image.getLayoutParams().dth = (int)((float)i * f);
            val$image.getLayoutParams().ight = (int)((float)j * f);
            val$image.setX(((float)val$parent.getMeasuredWidth() - (float)val$image.getLayoutParams().dth) / 2.0F);
            val$image.setY(((float)val$parent.getMeasuredHeight() - (float)val$image.getLayoutParams().ight) / 2.0F);
            return true;
        }
    }

    ()
    {
        this$0 = final_retrieveavataractivity;
        val$parent = relativelayout;
        val$image = ImageView.this;
        super();
    }
}
