// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import com.amazon.gallery.foundation.utils.DebugAssert;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

class this._cls0
    implements bugSelectedCheck
{

    final DebugPopup this$0;

    public boolean check(String s, Boolean boolean1)
    {
        if (s.equals("Enabled"))
        {
            return DebugAssert.isDebugBuild;
        }
        return !DebugAssert.isDebugBuild;
    }

    public volatile boolean check(String s, Object obj)
    {
        return check(s, (Boolean)obj);
    }

    bugSelectedCheck()
    {
        this$0 = DebugPopup.this;
        super();
    }
}
