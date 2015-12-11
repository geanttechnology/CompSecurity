// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;

// Referenced classes of package com.comcast.cim.android.view.common:
//            BaseActivity

protected class this._cls0 extends DefaultSpeechListener
{

    final BaseActivity this$0;

    public boolean onSpeechResponseCancel()
    {
        getTalkDelegate().stopSpeaking();
        return true;
    }

    public boolean onSpeechResponseClose()
    {
        finish();
        return true;
    }

    protected ()
    {
        this$0 = BaseActivity.this;
        super();
    }
}
