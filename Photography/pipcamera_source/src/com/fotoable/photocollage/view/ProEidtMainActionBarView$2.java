// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view;

import android.view.View;
import mb;

// Referenced classes of package com.fotoable.photocollage.view:
//            ProEidtMainActionBarView

class a
    implements android.view.inActionBarView._cls2
{

    final ProEidtMainActionBarView a;

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.b();
        }
    }

    (ProEidtMainActionBarView proeidtmainactionbarview)
    {
        a = proeidtmainactionbarview;
        super();
    }
}
