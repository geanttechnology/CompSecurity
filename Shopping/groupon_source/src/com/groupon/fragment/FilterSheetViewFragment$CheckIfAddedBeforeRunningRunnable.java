// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

private abstract class <init>
    implements Runnable
{

    final FilterSheetViewFragment this$0;

    public final void run()
    {
        if (!isAdded())
        {
            return;
        } else
        {
            runIfAdded();
            return;
        }
    }

    protected abstract void runIfAdded();

    private ()
    {
        this$0 = FilterSheetViewFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
