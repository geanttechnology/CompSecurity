// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.delay.provider;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smackx.delay.a.a;
import org.jivesoftware.smackx.delay.a.b;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.jivesoftware.smackx.delay.provider:
//            DelayInformationProvider

public class DelayInfoProvider extends DelayInformationProvider
{

    public DelayInfoProvider()
    {
    }

    public f a(XmlPullParser xmlpullparser)
    {
        return new a((b)super.a(xmlpullparser));
    }
}
