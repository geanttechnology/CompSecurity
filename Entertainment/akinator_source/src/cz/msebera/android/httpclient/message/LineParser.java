// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            ParserCursor

public interface LineParser
{

    public abstract boolean hasProtocolVersion(CharArrayBuffer chararraybuffer, ParserCursor parsercursor);

    public abstract Header parseHeader(CharArrayBuffer chararraybuffer)
        throws ParseException;

    public abstract ProtocolVersion parseProtocolVersion(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract RequestLine parseRequestLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract StatusLine parseStatusLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;
}
