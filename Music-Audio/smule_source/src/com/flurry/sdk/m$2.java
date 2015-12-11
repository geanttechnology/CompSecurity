// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

// Referenced classes of package com.flurry.sdk:
//            hq, m

class init> extends hq
{

    final ImageView a;
    final String b;
    final m c;

    public void safeRun()
    {
        a.setImageBitmap(BitmapFactory.decodeFile(b));
    }

    eView(m m1, ImageView imageview, String s)
    {
        c = m1;
        a = imageview;
        b = s;
        super();
    }
}
