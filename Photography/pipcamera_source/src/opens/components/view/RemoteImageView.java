// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package opens.components.view;

import ahl;
import ahw;
import ahx;
import aib;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;

public class RemoteImageView extends ImageView
{

    private Animation appearAnimation;
    private ahx request;

    public RemoteImageView(Context context)
    {
        super(context);
    }

    public RemoteImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void loadFromUrl(String s, ahl ahl)
    {
        ahw ahw1 = new ahw();
        ahw1.a(this, "onImageRequestSuccess");
        ahw1.a(ahl);
        request = ahw1;
        aib.a().a(request.a(s));
    }

    public void onImageRequestSuccess(ahw ahw1)
    {
        setImageBitmap((Bitmap)ahw1.a());
        if (appearAnimation != null)
        {
            startAnimation(appearAnimation);
        }
        request = null;
    }

    public void setAppearAnimation(Animation animation)
    {
        appearAnimation = animation;
    }
}
