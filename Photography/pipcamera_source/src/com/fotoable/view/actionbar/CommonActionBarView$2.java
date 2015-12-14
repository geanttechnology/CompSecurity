// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.view.actionbar;

import android.view.View;
import ph;

// Referenced classes of package com.fotoable.view.actionbar:
//            CommonActionBarView

class a
    implements android.view.ctionBarView._cls2
{

    final CommonActionBarView a;

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.g();
        }
    }

    (CommonActionBarView commonactionbarview)
    {
        a = commonactionbarview;
        super();
    }
}
