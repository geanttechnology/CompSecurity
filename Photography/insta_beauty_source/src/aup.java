// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.fotoable.shareinstagram.ImageView_Color;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class aup
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public aup(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        a.l.setVisibility(4);
        a.h.setSelected(false);
        a.m.setVisibility(4);
        a.i.setSelected(false);
        a.n.setVisibility(0);
        a.j.setSelected(true);
    }
}
