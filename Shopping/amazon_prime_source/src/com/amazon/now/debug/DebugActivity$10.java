// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.content.Intent;
import android.view.View;
import com.amazon.now.feature.DebugFeatureActivity;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

class this._cls0
    implements android.view.ner
{

    final DebugActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(DebugActivity.this, com/amazon/now/feature/DebugFeatureActivity));
    }

    ivity()
    {
        this$0 = DebugActivity.this;
        super();
    }
}
