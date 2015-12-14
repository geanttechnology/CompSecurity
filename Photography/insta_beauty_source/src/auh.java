// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class auh
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public auh(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        a.r = 0xff7a7a7a;
        a.e.setBackgroundColor(0xff7a7a7a);
    }
}
