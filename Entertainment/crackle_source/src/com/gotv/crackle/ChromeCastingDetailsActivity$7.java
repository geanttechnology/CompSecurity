// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import com.gotv.crackle.helpers.ChromeCastHelper;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class this._cls0
    implements android.content.
{

    final ChromeCastingDetailsActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        ChromeCastingDetailsActivity.access$2100(ChromeCastingDetailsActivity.this).loadMedia(ChromeCastingDetailsActivity.access$500(ChromeCastingDetailsActivity.this), false);
    }

    ()
    {
        this$0 = ChromeCastingDetailsActivity.this;
        super();
    }
}
