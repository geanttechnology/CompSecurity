// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

class this._cls0
    implements android.view.istener
{

    final SeeAllList this$0;

    public void onClick(View view)
    {
        getActivity().onBackPressed();
    }

    ()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
