// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.widget.ProgressBar;

// Referenced classes of package com.livemixtapes:
//            Login

class Callback extends Callback
{

    final Login this$0;

    public void always()
    {
        Login.access$14(Login.this, Boolean.valueOf(false));
        Login.access$15(Login.this).setVisibility(8);
    }

    public void failure(int i, Exception exception)
    {
    }

    public void success(Data data)
    {
        Login.access$12(Login.this);
    }

    Data()
    {
        this$0 = Login.this;
        super();
    }
}
