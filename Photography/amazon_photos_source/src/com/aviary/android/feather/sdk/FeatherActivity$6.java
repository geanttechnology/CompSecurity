// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.content.DialogInterface;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

class this._cls0
    implements android.content.ClickListener
{

    final FeatherActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = FeatherActivity.this;
        super();
    }
}
