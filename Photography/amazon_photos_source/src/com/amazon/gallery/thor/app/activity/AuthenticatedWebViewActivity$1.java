// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

class this._cls0 extends VisibilityAnimator
{

    final AuthenticatedWebViewActivity this$0;

    protected long getDuration()
    {
        return 750L;
    }

    protected ObjectAnimator getHideAnimator()
    {
        return ObjectAnimator.ofFloat(getWebView(), "alpha", new float[] {
            0.0F
        });
    }

    protected volatile ValueAnimator getHideAnimator()
    {
        return getHideAnimator();
    }

    protected ObjectAnimator getShowAnimator()
    {
        return ObjectAnimator.ofFloat(getWebView(), "alpha", new float[] {
            1.0F
        });
    }

    protected volatile ValueAnimator getShowAnimator()
    {
        return getShowAnimator();
    }

    I()
    {
        this$0 = AuthenticatedWebViewActivity.this;
        super();
    }
}
