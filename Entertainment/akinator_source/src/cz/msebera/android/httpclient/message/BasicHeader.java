// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            BasicHeaderValueParser, BasicLineFormatter

public class BasicHeader
    implements Header, Cloneable, Serializable
{

    private static final long serialVersionUID = 0xb4ae9550d79ce842L;
    private final String name;
    private final String value;

    public BasicHeader(String s, String s1)
    {
        name = (String)Args.notNull(s, "Name");
        value = s1;
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
        return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
    }
}
