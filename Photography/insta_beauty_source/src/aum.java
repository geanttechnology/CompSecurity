// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class aum
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public aum(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        if (a.u)
        {
            return;
        } else
        {
            a.u = true;
            a.b();
            return;
        }
    }
}
