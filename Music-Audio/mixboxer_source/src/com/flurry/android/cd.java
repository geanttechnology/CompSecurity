// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            AdSpaceLayout, fl

abstract class cd
{

    cd()
    {
        this((byte)0);
    }

    private cd(byte byte0)
    {
    }

    public abstract android.view.ViewGroup.LayoutParams a(Context context, AdSpaceLayout adspacelayout);

    public final int b(Context context, AdSpaceLayout adspacelayout)
    {
        boolean flag;
        if (adspacelayout.getAdWidth().intValue() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return fl.b(context, adspacelayout.getAdWidth().intValue());
        } else
        {
            return -1;
        }
    }

    public final int c(Context context, AdSpaceLayout adspacelayout)
    {
        boolean flag;
        if (adspacelayout.getAdHeight().intValue() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return fl.b(context, adspacelayout.getAdHeight().intValue());
        } else
        {
            return m();
        }
    }

    public int m()
    {
        return -2;
    }
}
