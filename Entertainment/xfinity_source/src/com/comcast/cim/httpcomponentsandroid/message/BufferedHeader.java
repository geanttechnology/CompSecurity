// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.FormattedHeader;
import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            ParserCursor, BasicHeaderValueParser

public class BufferedHeader
    implements FormattedHeader, Serializable, Cloneable
{

    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer chararraybuffer)
        throws ParseException
    {
        if (chararraybuffer == null)
        {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        int i = chararraybuffer.indexOf(58);
        if (i == -1)
        {
            throw new ParseException("Invalid header: " + chararraybuffer.toString());
        }
        String s = chararraybuffer.substringTrimmed(0, i);
        if (s.length() == 0)
        {
            throw new ParseException("Invalid header: " + chararraybuffer.toString());
        } else
        {
            buffer = chararraybuffer;
            name = s;
            valuePos = i + 1;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public CharArrayBuffer getBuffer()
    {
        return buffer;
    }

    public HeaderElement[] getElements()
        throws ParseException
    {
        ParserCursor parsercursor = new ParserCursor(0, buffer.length());
        parsercursor.updatePos(valuePos);
        return BasicHeaderValueParser.DEFAULT.parseElements(buffer, parsercursor);
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return buffer.substringTrimmed(valuePos, buffer.length());
    }

    public int getValuePos()
    {
        return valuePos;
    }

    public String toString()
    {
        return buffer.toString();
    }
}
