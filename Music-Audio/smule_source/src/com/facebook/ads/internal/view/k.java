// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;

// Referenced classes of package com.facebook.ads.internal.view:
//            j

public class k extends View
{

    private j a;

    public k(Context context, j j1)
    {
        super(context);
        a = j1;
        setLayoutParams(new android.view.ViewGroup.LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i)
    {
        if (a != null)
        {
            a.a(i);
        }
    }
}
