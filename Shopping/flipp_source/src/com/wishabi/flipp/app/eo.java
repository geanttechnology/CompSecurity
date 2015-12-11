// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.widget.dz;
import com.wishabi.flipp.widget.ec;

// Referenced classes of package com.wishabi.flipp.app:
//            ep

public final class eo
{

    public static dz a(Context context, int i, int j, int k, ec ec)
    {
        dz dz1 = new dz(context);
        dz1.setTabAdapter(new ep(context, j, k, i));
        dz1.setTabClickListener(ec);
        return dz1;
    }
}
