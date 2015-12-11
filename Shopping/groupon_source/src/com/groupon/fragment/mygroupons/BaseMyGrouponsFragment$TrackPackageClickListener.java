// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.view.View;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

private class <init>
    implements android.view.ckageClickListener
{

    final BaseMyGrouponsFragment this$0;

    public void onClick(View view)
    {
        BaseMyGrouponsFragment.access$200(BaseMyGrouponsFragment.this, (MyGrouponItemSummary)view.getTag());
    }

    private ()
    {
        this$0 = BaseMyGrouponsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
