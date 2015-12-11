// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            cd, AdSpaceLayout

final class bw extends cd
{

    bw()
    {
    }

    public final android.view.ViewGroup.LayoutParams a(Context context, AdSpaceLayout adspacelayout)
    {
        return new android.widget.LinearLayout.LayoutParams(b(context, adspacelayout), c(context, adspacelayout));
    }
}
