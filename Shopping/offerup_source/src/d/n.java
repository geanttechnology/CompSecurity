// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;


// Referenced classes of package d:
//            ab, f, ac

public abstract class n
    implements ab
{

    private final ab _flddelegate;

    public n(ab ab1)
    {
        if (ab1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = ab1;
            return;
        }
    }

    public void close()
    {
        _flddelegate.close();
    }

    public final ab _mthdelegate()
    {
        return _flddelegate;
    }

    public long read(f f, long l)
    {
        return _flddelegate.read(f, l);
    }

    public ac timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }
}
