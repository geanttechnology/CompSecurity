// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ViewAnimator;
import it.sephiroth.android.library.picasso.Callback;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

class this._cls1
    implements Callback
{

    final is._cls0 this$1;

    public void onError()
    {
        PackDetailLayout.logger._mth1("onError");
    }

    public void onSuccess()
    {
        if (isValidContext() && cess._mth200(this._cls1.this) == getPackId() && PackDetailLayout.access$000(_fld0).getDisplayedChild() == 1)
        {
            if (isChildVisible(_fld0))
            {
                PackDetailLayout.access$000(_fld0).setInAnimation(getContext(), com.aviary.android.feather.sdk.Task.this._fld0);
                PackDetailLayout.access$000(_fld0).setOutAnimation(getContext(), com.aviary.android.feather.sdk.Task.this._fld0);
            } else
            {
                PackDetailLayout.logger._mth0("downloadDetailImage, skip animation..");
                PackDetailLayout.access$000(_fld0).setInAnimation(null);
                PackDetailLayout.access$000(_fld0).setOutAnimation(null);
            }
            PackDetailLayout.access$000(_fld0).setDisplayedChild(2);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
