// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class this._cls1
    implements com.millennialmedia.internal.utils.tener
{

    final darListener this$1;

    public void onError(String s)
    {
        throwMraidError(s, "createCalendarEvent");
    }

    public void onSuccess()
    {
    }

    public void onUIDisplayed()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), "Calendar activity started");
        }
    }

    darListener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
