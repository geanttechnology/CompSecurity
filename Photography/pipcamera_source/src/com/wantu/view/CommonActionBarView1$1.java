// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.view.View;
import yp;

// Referenced classes of package com.wantu.view:
//            CommonActionBarView1

class a
    implements android.view._cls1
{

    final CommonActionBarView1 a;

    public void onClick(View view)
    {
        a.layout_accept.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.b();
        }
        a.layout_accept.setEnabled(true);
    }

    (CommonActionBarView1 commonactionbarview1)
    {
        a = commonactionbarview1;
        super();
    }
}
