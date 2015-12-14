// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.view.View;
import um;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            ResItemView

class a
    implements android.view.stener
{

    final ResItemView a;

    public void onClick(View view)
    {
        if (ResItemView.access$000(a) != null)
        {
            ResItemView.access$000(a).c(view.getTag());
        }
    }

    (ResItemView resitemview)
    {
        a = resitemview;
        super();
    }
}
