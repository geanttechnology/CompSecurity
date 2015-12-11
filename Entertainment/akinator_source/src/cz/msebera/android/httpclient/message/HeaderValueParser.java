// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            ParserCursor

public interface HeaderValueParser
{

    public abstract HeaderElement[] parseElements(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract HeaderElement parseHeaderElement(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract NameValuePair parseNameValuePair(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract NameValuePair[] parseParameters(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;
}
