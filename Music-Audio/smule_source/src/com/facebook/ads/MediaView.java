// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.view.e;

// Referenced classes of package com.facebook.ads:
//            NativeAd

public class MediaView extends RelativeLayout
{

    private final e a;
    private boolean b;

    public MediaView(Context context)
    {
        this(context, null);
    }

    public MediaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        a = new e(context);
        a.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(a);
    }

    public void setNativeAd(NativeAd nativead)
    {
        nativead.b(true);
        if (b)
        {
            a.a(null, null);
            b = false;
        }
        if (nativead != null && nativead.getAdCoverImage() != null)
        {
            b = true;
            (new k(a)).execute(new String[] {
                nativead.getAdCoverImage().getUrl()
            });
        }
    }
}
