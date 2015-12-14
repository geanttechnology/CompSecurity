// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.app.Activity;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ViewUtils

class ner extends com.millennialmedia.internal.yListener
{

    final this._cls0 this$0;

    public void onPaused(Activity activity)
    {
        fecycleState = com.millennialmedia.internal.leState.PAUSED;
        cess._mth100(this._cls0.this);
    }

    public void onResumed(Activity activity)
    {
        fecycleState = com.millennialmedia.internal.leState.RESUMED;
        cess._mth100(this._cls0.this);
    }

    e()
    {
        this$0 = this._cls0.this;
        super();
    }
}
