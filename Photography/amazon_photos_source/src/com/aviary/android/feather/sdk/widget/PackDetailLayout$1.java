// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ViewAnimator;
import it.sephiroth.android.library.picasso.Callback;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

class this._cls0
    implements Callback
{

    final PackDetailLayout this$0;

    public void onError()
    {
        PackDetailLayout.logger.error("failed to load local detail image");
    }

    public void onSuccess()
    {
        if (getContext() != null && PackDetailLayout.access$000(PackDetailLayout.this).getDisplayedChild() == 0)
        {
            PackDetailLayout.logger.verbose("detail image loaded from local path", new Object[0]);
            PackDetailLayout.access$000(PackDetailLayout.this).setInAnimation(getContext(), com.aviary.android.feather.sdk.l_banner_fade_in);
            PackDetailLayout.access$000(PackDetailLayout.this).setOutAnimation(getContext(), com.aviary.android.feather.sdk.l_banner_fade_out);
            PackDetailLayout.access$000(PackDetailLayout.this).setDisplayedChild(2);
        }
    }

    r()
    {
        this$0 = PackDetailLayout.this;
        super();
    }
}
