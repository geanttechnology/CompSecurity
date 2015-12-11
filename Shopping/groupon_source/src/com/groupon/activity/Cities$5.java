// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.division.Division;

// Referenced classes of package com.groupon.activity:
//            Cities

class this._cls0
    implements android.view.ickListener
{

    final Cities this$0;

    public void onClick(View view)
    {
        view = ((View) (view.getTag()));
        Cities.access$1000(Cities.this, (Division)view);
    }

    vision()
    {
        this$0 = Cities.this;
        super();
    }
}
