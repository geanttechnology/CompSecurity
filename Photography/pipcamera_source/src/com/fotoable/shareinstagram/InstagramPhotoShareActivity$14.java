// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.widget.SeekBar;

// Referenced classes of package com.fotoable.shareinstagram:
//            InstagramPhotoShareActivity, HandleBmpView

class a
    implements android.widget.
{

    final InstagramPhotoShareActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.r = i;
        if (a.n != null)
        {
            a.n.setBorderRadius(a.r);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }
}
