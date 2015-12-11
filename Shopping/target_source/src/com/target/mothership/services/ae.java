// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.target.mothership.services:
//            aa, ab, d

public interface ae
    extends aa
{

    public abstract d a(ab ab);

    public abstract d a(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException;
}
