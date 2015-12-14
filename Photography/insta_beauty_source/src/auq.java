// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.shareinstagram.HandleBmpView;
import com.fotoable.shareinstagram.ImageView_Color;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class auq
    implements android.view.View.OnClickListener
{

    final InstagramPhotoShareActivity a;

    public auq(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onClick(View view)
    {
        a.p.changeShadowMode();
        view = a.k;
        boolean flag;
        if (!a.k.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
    }
}
