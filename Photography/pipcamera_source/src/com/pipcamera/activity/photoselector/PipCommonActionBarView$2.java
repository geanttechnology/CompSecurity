// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.view.View;
import st;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            PipCommonActionBarView

class a
    implements android.view.ipCommonActionBarView._cls2
{

    final PipCommonActionBarView a;

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.b();
        }
    }

    (PipCommonActionBarView pipcommonactionbarview)
    {
        a = pipcommonactionbarview;
        super();
    }
}
