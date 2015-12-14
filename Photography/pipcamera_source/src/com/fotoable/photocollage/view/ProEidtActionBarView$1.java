// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view;

import android.view.View;
import ma;

// Referenced classes of package com.fotoable.photocollage.view:
//            ProEidtActionBarView

class a
    implements android.view.dtActionBarView._cls1
{

    final ProEidtActionBarView a;

    public void onClick(View view)
    {
        a.layout_accept.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.d();
        }
        a.layout_accept.setEnabled(true);
    }

    (ProEidtActionBarView proeidtactionbarview)
    {
        a = proeidtactionbarview;
        super();
    }
}
