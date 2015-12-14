// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView

class a
    implements Runnable
{

    private Animation a;
    private a b;

    public void run()
    {
        b.b.a.startAnimation(a);
    }

    ( , Animation animation)
    {
        b = ;
        a = animation;
        super();
    }
}
