// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import java.util.ArrayList;

class val.results
    implements Runnable
{

    final fyDataSetInvalidated this$2;
    final android.widget.pter._cls1 val$results;

    public void run()
    {
        ss._mth1102(_fld1, (ArrayList)val$results.results);
        if (val$results != null && val$results.results > 0)
        {
            fyDataSetChanged();
            return;
        } else
        {
            fyDataSetInvalidated();
            return;
        }
    }

    ()
    {
        this$2 = final_;
        val$results = android.widget.pter._cls1._cls1.val.results.this;
        super();
    }
}
