// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.view.View;
import nd;

// Referenced classes of package com.fotoable.photoselector.activity:
//            CommonActionBarView

class a
    implements android.view..CommonActionBarView._cls3
{

    final CommonActionBarView a;

    public void onClick(View view)
    {
        a.next_btn.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.a();
        }
        a.next_btn.setEnabled(true);
    }

    (CommonActionBarView commonactionbarview)
    {
        a = commonactionbarview;
        super();
    }
}
