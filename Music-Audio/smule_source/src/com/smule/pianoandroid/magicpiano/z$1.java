// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.smule.android.f.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            z

class a
    implements android.view..OnLayoutChangeListener
{

    final Bitmap a;
    final z b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        c.a((ImageView)view, a, 0xff444444, true);
    }

    er(z z1, Bitmap bitmap)
    {
        b = z1;
        a = bitmap;
        super();
    }
}
