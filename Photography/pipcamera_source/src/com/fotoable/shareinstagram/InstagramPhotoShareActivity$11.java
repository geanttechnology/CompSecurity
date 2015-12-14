// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.view.View;

// Referenced classes of package com.fotoable.shareinstagram:
//            InstagramPhotoShareActivity, HandleBmpView, ImageView_Color

class a
    implements android.view.areActivity._cls11
{

    final InstagramPhotoShareActivity a;

    public void onClick(View view)
    {
        a.n.changeShadowMode();
        view = a.i;
        boolean flag;
        if (!a.i.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
    }

    (InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }
}
