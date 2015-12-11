// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.groupon.activity:
//            PreconfiguredAbTests

class this._cls0
    implements android.widget.Listener
{

    final PreconfiguredAbTests this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)adapterview.getItemAtPosition(i);
        PreconfiguredAbTests.access$100(PreconfiguredAbTests.this, adapterview);
    }

    er()
    {
        this$0 = PreconfiguredAbTests.this;
        super();
    }
}
