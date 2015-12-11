// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.b.a.b.c;
import com.target.mothership.util.o;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.target.mothership.services.b.a.d:
//            c

class val.offer
    implements com.target.mothership.util.b.a.d.c._cls5
{

    final com.target.mothership.services.b.a.d.c this$0;
    final c val$offer;

    public void a(XmlPullParser xmlpullparser, String s)
        throws IOException, XmlPullParserException
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -1221270899: 95
    //                   -341064690: 109
    //                   1557721666: 81
    //                   2061494827: 123;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 80
    //                   0 137
    //                   1 153
    //                   2 169
    //                   3 194;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        return;
_L4:
        if (s.equals("details"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("header"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("resource"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("redemption"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        val$offer.c(c.d(com.target.mothership.services.b.a.d.c.this, xmlpullparser));
        return;
_L8:
        val$offer.c(c.d(com.target.mothership.services.b.a.d.c.this, xmlpullparser));
        return;
_L9:
        xmlpullparser = c.e(com.target.mothership.services.b.a.d.c.this, xmlpullparser);
        if (o.g(xmlpullparser))
        {
            val$offer.a(xmlpullparser);
            return;
        }
          goto _L6
_L10:
        val$offer.b(c.f(com.target.mothership.services.b.a.d.c.this, xmlpullparser));
        return;
        if (true) goto _L1; else goto _L11
_L11:
    }

    ()
    {
        this$0 = final_c1;
        val$offer = c.this;
        super();
    }
}
