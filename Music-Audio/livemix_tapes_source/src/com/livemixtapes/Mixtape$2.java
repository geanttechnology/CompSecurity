// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            Mixtape

class this._cls0
    implements android.view.ckListener
{

    final Mixtape this$0;

    public void onClick(View view)
    {
        getActivity().onBackPressed();
    }

    stener()
    {
        this$0 = Mixtape.this;
        super();
    }
}
