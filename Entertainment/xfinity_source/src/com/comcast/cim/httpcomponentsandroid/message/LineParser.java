// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            ParserCursor

public interface LineParser
{

    public abstract boolean hasProtocolVersion(CharArrayBuffer chararraybuffer, ParserCursor parsercursor);

    public abstract Header parseHeader(CharArrayBuffer chararraybuffer)
        throws ParseException;

    public abstract RequestLine parseRequestLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract StatusLine parseStatusLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;
}
