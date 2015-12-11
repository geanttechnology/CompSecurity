// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.io;

import org.codehaus.jackson.SerializableString;

// Referenced classes of package org.codehaus.jackson.io:
//            JsonStringEncoder

public class SerializedString
    implements SerializableString
{

    protected char _quotedChars[];
    protected final String _value;

    public SerializedString(String s)
    {
        _value = s;
    }

    public final char[] asQuotedChars()
    {
        char ac1[] = _quotedChars;
        char ac[] = ac1;
        if (ac1 == null)
        {
            ac = JsonStringEncoder.getInstance().quoteAsString(_value);
            _quotedChars = ac;
        }
        return ac;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || obj.getClass() != getClass())
        {
            return false;
        } else
        {
            obj = (SerializedString)obj;
            return _value.equals(((SerializedString) (obj))._value);
        }
    }

    public final String getValue()
    {
        return _value;
    }

    public final int hashCode()
    {
        return _value.hashCode();
    }

    public final String toString()
    {
        return _value;
    }
}
