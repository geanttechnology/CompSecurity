// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aqj, aql, apv

public abstract class aqa
    implements aqj
{

    private final aqj _flddelegate;

    public aqa(aqj aqj1)
    {
        if (aqj1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = aqj1;
            return;
        }
    }

    public void close()
        throws IOException
    {
        _flddelegate.close();
    }

    public final aqj _mthdelegate()
    {
        return _flddelegate;
    }

    public void flush()
        throws IOException
    {
        _flddelegate.flush();
    }

    public aql timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }

    public void write(apv apv, long l)
        throws IOException
    {
        _flddelegate.write(apv, l);
    }
}
