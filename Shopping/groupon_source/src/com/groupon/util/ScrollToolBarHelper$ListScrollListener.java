// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            ScrollChangeListener, ScrollToolBarHelper

protected class this._cls0
    implements ScrollChangeListener
{

    final ScrollToolBarHelper this$0;

    public void onScrollDelta(float f)
    {
        scrollToolbar(f);
    }

    public void onScrollFinish(float f)
    {
        snapToolBar(f);
    }

    protected ()
    {
        this$0 = ScrollToolBarHelper.this;
        super();
    }
}
