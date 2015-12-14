// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package opens.components.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import cem;
import cfd;
import cfe;
import cfi;

public class RemoteImageView extends ImageView
{

    private Animation appearAnimation;
    private cfe request;

    public RemoteImageView(Context context)
    {
        super(context);
    }

    public RemoteImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void loadFromUrl(String s, cem cem)
    {
        cfd cfd1 = new cfd();
        cfd1.a(this, "onImageRequestSuccess");
        cfd1.a(cem);
        request = cfd1;
        cfi.a().a(request.a(s));
    }

    public void onImageRequestSuccess(cfd cfd1)
    {
        setImageBitmap((Bitmap)cfd1.a());
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
