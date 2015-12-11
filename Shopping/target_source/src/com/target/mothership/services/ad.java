// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.util.Xml;
import com.target.mothership.util.o;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.target.mothership.services:
//            ab, ac, ae, d

public class ad
{

    public ad()
    {
    }

    public d a(String s, ae ae1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj = null;
        obj1 = null;
        if (o.g(s)) goto _L2; else goto _L1
_L1:
        s = ae1.a(new ab(ac.NoData, null));
_L4:
        return s;
_L2:
        org.xmlpull.v1.XmlPullParser xmlpullparser = Xml.newPullParser();
        StringReader stringreader = new StringReader(s);
        s = stringreader;
        obj = ae1.a(stringreader, xmlpullparser);
        ae1 = ((ae) (obj));
        s = ae1;
        if (stringreader != null)
        {
            stringreader.close();
            return ae1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        stringreader = null;
_L10:
        s = stringreader;
        ae1 = ae1.a(new ab(ac.ParseError, ((XmlPullParserException) (obj)).getMessage()));
        s = ae1;
        if (stringreader != null)
        {
            stringreader.close();
            return ae1;
        }
          goto _L4
        s;
        stringreader = obj1;
_L9:
        obj = stringreader;
        ae1 = ae1.a(new ab(ac.ParseError, s.getMessage()));
        s = ae1;
        if (stringreader != null)
        {
            stringreader.close();
            return ae1;
        }
          goto _L4
        s;
        stringreader = obj2;
_L8:
        obj = stringreader;
        ae1 = ae1.a(new ab(ac.UnknownError, s.getMessage()));
        s = ae1;
        if (stringreader == null) goto _L4; else goto _L5
_L5:
        stringreader.close();
        return ae1;
        s;
_L7:
        if (obj != null)
        {
            ((StringReader) (obj)).close();
        }
        throw s;
        ae1;
        obj = s;
        s = ae1;
        if (true) goto _L7; else goto _L6
_L6:
        s;
          goto _L8
        s;
          goto _L9
        obj;
          goto _L10
    }
}
