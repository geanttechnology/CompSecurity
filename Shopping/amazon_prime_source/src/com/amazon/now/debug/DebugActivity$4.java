// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.view.View;
import android.widget.EditText;
import com.amazon.now.location.Location;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

class this._cls0
    implements android.view.ener
{

    final DebugActivity this$0;

    public void onClick(View view)
    {
        DebugActivity.access$000(DebugActivity.this, DebugActivity.access$200(DebugActivity.this).getText().toString(), "OVERRIDE", "Service URL OVERRIDDEN!");
        Location.resetLocation();
    }

    ()
    {
        this$0 = DebugActivity.this;
        super();
    }
}
