// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aqk, apv, aql

public abstract class aqb
    implements aqk
{

    private final aqk _flddelegate;

    public aqb(aqk aqk1)
    {
        if (aqk1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = aqk1;
            return;
        }
    }

    public void close()
        throws IOException
    {
        _flddelegate.close();
    }

    public final aqk _mthdelegate()
    {
        return _flddelegate;
    }

    public long read(apv apv, long l)
        throws IOException
    {
        return _flddelegate.read(apv, l);
    }

    public aql timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }
}
