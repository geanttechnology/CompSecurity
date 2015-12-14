// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class a extends IQ
{

    final ScrollTextViewActivity a;

    public String a()
    {
        return "<ping xmlns='urn:xmpp:ping'/>";
    }

    public CharSequence b()
    {
        return a();
    }

    _cls9(ScrollTextViewActivity scrolltextviewactivity)
    {
        a = scrolltextviewactivity;
        super();
    }
}
