// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsHelper

class this._cls0
    implements android.content.stener
{

    final er this$0;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        return i == 84 && keyevent.getRepeatCount() == 0;
    }

    er()
    {
        this$0 = this._cls0.this;
        super();
    }
}
