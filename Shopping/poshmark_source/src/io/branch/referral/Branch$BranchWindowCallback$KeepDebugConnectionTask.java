// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package io.branch.referral:
//            Branch, PrefHelper

class this._cls1 extends TimerTask
{

    final this._cls1 this$1;

    public void run()
    {
        if (Branch.access$2800(_fld1) && !Branch.access$100(_fld1).keepDebugConnection() && this._mth1(this._cls1.this) != null)
        {
            Branch.access$200(_fld1).post(this._mth1(this._cls1.this));
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
