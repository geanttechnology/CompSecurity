// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.content.Context;
import android.view.SurfaceView;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

private class this._cls0 extends SurfaceView
{

    final MMVideoView this$0;

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1;
        int i2;
        i1 = getDefaultSize(MMVideoView.access$100(MMVideoView.this), i);
        i2 = getDefaultSize(MMVideoView.access$200(MMVideoView.this), j);
        k = i2;
        l = i1;
        if (MMVideoView.access$100(MMVideoView.this) <= 0) goto _L2; else goto _L1
_L1:
        k = i2;
        l = i1;
        if (MMVideoView.access$200(MMVideoView.this) <= 0) goto _L2; else goto _L3
_L3:
        int k2;
        int l2;
        k2 = android.view.View(i);
        i = android.view.View(i);
        l2 = android.view.View(j);
        j = android.view.View(j);
        if (k2 != 0x40000000 || l2 != 0x40000000) goto _L5; else goto _L4
_L4:
        if (MMVideoView.access$100(MMVideoView.this) * j >= MMVideoView.access$200(MMVideoView.this) * i) goto _L7; else goto _L6
_L6:
        l = (MMVideoView.access$100(MMVideoView.this) * j) / MMVideoView.access$200(MMVideoView.this);
        k = j;
_L2:
        setMeasuredDimension(l, k);
        return;
_L7:
        k = j;
        l = i;
        if (MMVideoView.access$100(MMVideoView.this) * j > MMVideoView.access$200(MMVideoView.this) * i)
        {
            k = (MMVideoView.access$200(MMVideoView.this) * i) / MMVideoView.access$100(MMVideoView.this);
            l = i;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (k2 == 0x40000000)
        {
            int j1 = (MMVideoView.access$200(MMVideoView.this) * i) / MMVideoView.access$100(MMVideoView.this);
            k = j1;
            l = i;
            if (l2 == 0x80000000)
            {
                k = j1;
                l = i;
                if (j1 > j)
                {
                    k = j;
                    l = i;
                }
            }
        } else
        if (l2 == 0x40000000)
        {
            int k1 = (MMVideoView.access$100(MMVideoView.this) * j) / MMVideoView.access$200(MMVideoView.this);
            k = j;
            l = k1;
            if (k2 == 0x80000000)
            {
                k = j;
                l = k1;
                if (k1 > i)
                {
                    k = j;
                    l = i;
                }
            }
        } else
        {
            k = MMVideoView.access$100(MMVideoView.this);
            l = MMVideoView.access$200(MMVideoView.this);
            int j2 = l;
            int l1 = k;
            if (l2 == 0x80000000)
            {
                j2 = l;
                l1 = k;
                if (l > j)
                {
                    l1 = (MMVideoView.access$100(MMVideoView.this) * j) / MMVideoView.access$200(MMVideoView.this);
                    j2 = j;
                }
            }
            k = j2;
            l = l1;
            if (k2 == 0x80000000)
            {
                k = j2;
                l = l1;
                if (l1 > i)
                {
                    k = (MMVideoView.access$200(MMVideoView.this) * i) / MMVideoView.access$100(MMVideoView.this);
                    l = i;
                }
            }
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    (Context context)
    {
        this$0 = MMVideoView.this;
        super(context);
    }
}
