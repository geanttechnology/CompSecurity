// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.text.style.CharacterStyle;
import android.text.style.URLSpan;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

private class <init>
    implements com.boldchat.sdk.utils.
{

    final BoldChatSession this$0;

    public volatile CharacterStyle convert(CharacterStyle characterstyle)
    {
        return convert((URLSpan)characterstyle);
    }

    public convert convert(URLSpan urlspan)
    {
        return new nit>(BoldChatSession.this, urlspan.getURL());
    }

    private ()
    {
        this$0 = BoldChatSession.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
