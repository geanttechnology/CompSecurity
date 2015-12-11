// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity, DebugWebActivity

class this._cls0
    implements android.view.ener
{

    final DebugActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(DebugActivity.this, com/amazon/now/debug/DebugWebActivity);
        startActivity(view);
    }

    ()
    {
        this$0 = DebugActivity.this;
        super();
    }
}
