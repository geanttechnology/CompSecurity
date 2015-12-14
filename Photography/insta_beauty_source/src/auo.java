// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.fotoable.shareinstagram.ImageView_Color;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class auo
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public auo(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        a.l.setVisibility(4);
        a.h.setSelected(false);
        a.m.setVisibility(0);
        a.i.setSelected(true);
        a.n.setVisibility(4);
        a.j.setSelected(false);
        a.q.setVisibility(4);
    }
}
