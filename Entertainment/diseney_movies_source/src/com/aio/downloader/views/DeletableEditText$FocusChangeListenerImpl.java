// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.text.Editable;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            DeletableEditText

private class <init>
    implements android.view.istenerImpl
{

    final DeletableEditText this$0;

    public void onFocusChange(View view, boolean flag)
    {
        boolean flag1 = true;
        DeletableEditText.access$0(DeletableEditText.this, flag);
        if (DeletableEditText.access$1(DeletableEditText.this))
        {
            if (getText().toString().length() >= 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            setClearDrawableVisible(flag);
            return;
        } else
        {
            setClearDrawableVisible(false);
            return;
        }
    }

    private ()
    {
        this$0 = DeletableEditText.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
