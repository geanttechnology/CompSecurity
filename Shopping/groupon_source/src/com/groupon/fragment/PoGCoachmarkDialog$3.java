// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            PoGCoachmarkDialog

class this._cls0
    implements android.view.ialog._cls3
{

    final PoGCoachmarkDialog this$0;

    public void onClick(View view)
    {
        LoggingUtils loggingutils = loggingUtils;
        if (PoGCoachmarkDialog.access$000(PoGCoachmarkDialog.this) == alogType.CAMERA)
        {
            view = "pog_modal_one_close";
        } else
        {
            view = "pog_modal_two_close";
        }
        loggingutils.logClickWithMetadata("", view, Channel.GLOBAL_SEARCH.name().toLowerCase(), null);
        dismiss();
    }

    alogType()
    {
        this$0 = PoGCoachmarkDialog.this;
        super();
    }
}
