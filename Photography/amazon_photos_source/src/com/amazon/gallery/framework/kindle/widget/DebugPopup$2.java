// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import com.amazon.gallery.foundation.utils.DebugAssert;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

class this._cls0
    implements bugCallback
{

    final DebugPopup this$0;

    public void run(String s, Boolean boolean1)
    {
        DebugAssert.isDebugBuild = boolean1.booleanValue();
    }

    public volatile void run(String s, Object obj)
    {
        run(s, (Boolean)obj);
    }

    bugCallback()
    {
        this$0 = DebugPopup.this;
        super();
    }
}
