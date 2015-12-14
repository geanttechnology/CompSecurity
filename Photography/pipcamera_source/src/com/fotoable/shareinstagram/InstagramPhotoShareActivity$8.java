// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

// Referenced classes of package com.fotoable.shareinstagram:
//            InstagramPhotoShareActivity, ImageView_Color

class a
    implements android.view.hareActivity._cls8
{

    final InstagramPhotoShareActivity a;

    public void onClick(View view)
    {
        a.j.setVisibility(0);
        a.f.setSelected(true);
        a.k.setVisibility(4);
        a.g.setSelected(false);
        a.l.setVisibility(4);
        a.h.setSelected(false);
        a.o.setVisibility(0);
    }

    (InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }
}
