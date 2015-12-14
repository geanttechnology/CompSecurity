// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.graphics.Bitmap;
import android.widget.ImageView;
import myobfuscated.cd.a;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class b
    implements Runnable
{

    private int a;
    private Bitmap b;
    private DeviantArtOAuthMainActivity c;

    public final void run()
    {
        DeviantArtOAuthMainActivity.g(c).getLayoutParams().c = a;
        DeviantArtOAuthMainActivity.g(c).setImageDrawable(new a(c.getResources(), b));
        DeviantArtOAuthMainActivity.g(c).setVisibility(0);
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity, int i, Bitmap bitmap)
    {
        c = deviantartoauthmainactivity;
        a = i;
        b = bitmap;
        super();
    }
}
