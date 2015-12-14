// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class aui
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public aui(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        a.r = -1;
        a.e.setBackgroundColor(-1);
    }
}
