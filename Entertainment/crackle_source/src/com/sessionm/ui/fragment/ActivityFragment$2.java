// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui.fragment;


// Referenced classes of package com.sessionm.ui.fragment:
//            ActivityFragment

class this._cls0
    implements com.sessionm.ui.PrepareListener
{

    final ActivityFragment this$0;

    public void onFailure(Throwable throwable)
    {
        throwable = getListener();
        if (throwable != null)
        {
            throwable.onViewPreloadFailed(ActivityFragment.this);
        }
    }

    public void onPrepared()
    {
        er er = getListener();
        if (er != null)
        {
            er.onViewPreloadSucceeded(ActivityFragment.this);
        }
    }

    er()
    {
        this$0 = ActivityFragment.this;
        super();
    }
}
