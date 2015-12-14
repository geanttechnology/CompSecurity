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
    }

    public void onSuccess()
    {
        if (PackDetailLayout.access$000(PackDetailLayout.this).getDisplayedChild() == 0)
        {
            PackDetailLayout.logger.verbose("loadTempDetailImage:onSuccess", new Object[0]);
            PackDetailLayout.access$000(PackDetailLayout.this).setInAnimation(null);
            PackDetailLayout.access$000(PackDetailLayout.this).setOutAnimation(null);
            PackDetailLayout.access$000(PackDetailLayout.this).setDisplayedChild(1);
        }
    }

    r()
    {
        this$0 = PackDetailLayout.this;
        super();
    }
}
