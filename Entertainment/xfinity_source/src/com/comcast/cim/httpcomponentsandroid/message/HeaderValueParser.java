// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            ParserCursor

public interface HeaderValueParser
{

    public abstract HeaderElement[] parseElements(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;

    public abstract HeaderElement parseHeaderElement(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException;
}
