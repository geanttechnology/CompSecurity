// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ArrayAdapter;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

private class add extends ArrayAdapter
{

    final String states[];
    final CVSDMapActivity this$0;

    public (Context context)
    {
        this$0 = CVSDMapActivity.this;
        super(context, 0x1090008);
        setDropDownViewResource(0x1090009);
        states = getResources().getStringArray(com.amazon.mShop.android.lib.DownViewResource);
        cvsdmapactivity = states;
        int j = CVSDMapActivity.this.length;
        for (int i = 0; i < j; i++)
        {
            add(CVSDMapActivity.this[i]);
        }

    }
}
