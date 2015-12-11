// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            MapSlice

class this._cls0
    implements Function1
{

    final MapSlice this$0;

    public void execute(Boolean boolean1)
    {
        Ln.d("DETAILS: directions success = %s", new Object[] {
            boolean1
        });
        animateIn();
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Boolean)obj);
    }

    ()
    {
        this$0 = MapSlice.this;
        super();
    }
}
