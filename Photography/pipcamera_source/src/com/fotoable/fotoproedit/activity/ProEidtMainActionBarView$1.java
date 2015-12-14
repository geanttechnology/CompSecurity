// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import gq;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEidtMainActionBarView

class a
    implements android.view.tMainActionBarView._cls1
{

    final ProEidtMainActionBarView a;

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.c();
        }
    }

    (ProEidtMainActionBarView proeidtmainactionbarview)
    {
        a = proeidtmainactionbarview;
        super();
    }
}
