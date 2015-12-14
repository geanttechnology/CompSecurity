// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            DjBadgesView

class this._cls0
    implements android.view.tener
{

    final DjBadgesView this$0;

    public void onClick(View view)
    {
        if (DjBadgesView.access$0(DjBadgesView.this) != null)
        {
            DjBadgesView.access$0(DjBadgesView.this).onClickDj(((TextView)view).getText().toString());
        }
    }

    ClickListener()
    {
        this$0 = DjBadgesView.this;
        super();
    }
}
