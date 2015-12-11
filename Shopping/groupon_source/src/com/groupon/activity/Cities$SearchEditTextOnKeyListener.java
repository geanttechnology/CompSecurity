// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.KeyEvent;
import android.view.View;
import com.groupon.view.ActionBarClearableEditText;

// Referenced classes of package com.groupon.activity:
//            Cities

private class <init>
    implements android.view.istener
{

    final Cities this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            Cities.access$1300(Cities.this).clearFocus();
        }
        return false;
    }

    private ()
    {
        this$0 = Cities.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
