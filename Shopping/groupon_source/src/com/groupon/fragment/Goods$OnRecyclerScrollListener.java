// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.support.v7.widget.RecyclerView;

// Referenced classes of package com.groupon.fragment:
//            Goods

private class <init> extends android.support.v7.widget.>
{

    final Goods this$0;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        boolean flag = true;
        recyclerview = Goods.this;
        if (i == 1)
        {
            flag = false;
        }
        recyclerview.setPullToRefreshEnabled(flag);
    }

    private ner()
    {
        this$0 = Goods.this;
        super();
    }

    ner(ner ner)
    {
        this();
    }
}
