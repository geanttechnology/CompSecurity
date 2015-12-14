// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.chat:
//            j

final class b extends IQ
{

    final Date a;
    final String b;

    public String a()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (a != null)
        {
            return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:tmp'><with>").append(b).append("</with>").append("<end>").append(simpledateformat.format(a)).append("</end><set xmlns='http://jabber.org/protocol/rsm'><max>").append(20).append("</max><before/></set></query>").toString();
        } else
        {
            return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:tmp'><with>").append(b).append("</with>").append("<set xmlns='http://jabber.org/protocol/rsm'><max>").append(20).append("</max><before/></set></query>").toString();
        }
    }

    public CharSequence b()
    {
        return a();
    }

    (Date date, String s)
    {
        a = date;
        b = s;
        super();
    }
}
