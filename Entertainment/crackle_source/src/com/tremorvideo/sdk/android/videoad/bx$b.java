// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TableLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bd, bx, bv

class b extends TableLayout
    implements bd
{

    View a;
    bv b;
    int c;
    final bx d;

    private int c()
    {
        int i = c;
        if (c == 0)
        {
            i = bx.a(d, getContext());
        }
        return i - b.a(H).getWidth() - b.a(J).getWidth() - 10;
    }

    public void a()
    {
        b();
    }

    public void a(View view)
    {
        a = view;
    }

    public void b()
    {
        int i = c();
        int j = b.a(J).getHeight();
        a.setLayoutParams(new android.widget.Row.LayoutParams(i, j));
    }

    (bx bx1, Context context, bv bv1, int i)
    {
        d = bx1;
        super(context);
        c = i;
        b = bv1;
    }
}
