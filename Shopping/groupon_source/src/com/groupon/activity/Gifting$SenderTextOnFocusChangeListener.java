// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            Gifting

private class <init>
    implements android.view.istener
{

    final Gifting this$0;

    public void onFocusChange(View view, boolean flag)
    {
        view = fromIcon;
        Resources resources = getResources();
        int i;
        if (flag)
        {
            i = 0x7f020077;
        } else
        {
            i = 0x7f020076;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i), null, null, null);
    }

    private ()
    {
        this$0 = Gifting.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
