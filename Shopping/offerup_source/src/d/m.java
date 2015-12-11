// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;


// Referenced classes of package d:
//            aa, ac, f

public abstract class m
    implements aa
{

    private final aa _flddelegate;

    public m(aa aa1)
    {
        if (aa1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            _flddelegate = aa1;
            return;
        }
    }

    public void close()
    {
        _flddelegate.close();
    }

    public final aa _mthdelegate()
    {
        return _flddelegate;
    }

    public void flush()
    {
        _flddelegate.flush();
    }

    public ac timeout()
    {
        return _flddelegate.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(_flddelegate.toString()).append(")").toString();
    }

    public void write(f f, long l)
    {
        _flddelegate.write(f, l);
    }
}
