// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.res.Resources;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            GridFragment

class init> extends android.support.v7.widget.er.SpanSizeLookup
{

    final GridFragment this$0;
    final boolean val$hasBanner;

    public int getSpanSize(int i)
    {
        if (val$hasBanner && i == 0)
        {
            return getResources().getInteger(0x7f0d0001);
        } else
        {
            return 1;
        }
    }

    A()
    {
        this$0 = final_gridfragment;
        val$hasBanner = Z.this;
        super();
    }
}
