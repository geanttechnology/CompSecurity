// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            BasicHeaderValueParser, BasicLineFormatter

public class BasicHeader
    implements Header, Serializable, Cloneable
{

    private final String name;
    private final String value;

    public BasicHeader(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        } else
        {
            name = s;
            value = s1;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public HeaderElement[] getElements()
        throws ParseException
    {
        if (value != null)
        {
            return BasicHeaderValueParser.parseElements(value, null);
        } else
        {
            return new HeaderElement[0];
        }
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
    }
}
