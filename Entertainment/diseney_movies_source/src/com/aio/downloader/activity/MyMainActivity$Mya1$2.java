// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.widget.CompoundButton;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls1
    implements android.widget.edChangeListener
{

    final  this$1;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            cess._mth2(this._cls1.this).callerD = false;
            return;
        } else
        {
            cess._mth2(this._cls1.this).callerD = true;
            return;
        }
    }

    ner()
    {
        this$1 = this._cls1.this;
        super();
    }
}
