// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.Iterator;

public class efy
{

    final String a;

    efy(efy efy1)
    {
        a = efy1.a;
    }

    public efy(String s)
    {
        a = (String)f.b(s);
    }

    public static efy a(String s)
    {
        return new efy(s);
    }

    public efy a()
    {
        return new ega(this, this);
    }

    public Appendable a(Appendable appendable, Iterator iterator)
    {
        f.b(appendable);
        if (iterator.hasNext())
        {
            appendable.append(a(iterator.next()));
            for (; iterator.hasNext(); appendable.append(a(iterator.next())))
            {
                appendable.append(a);
            }

        }
        return appendable;
    }

    CharSequence a(Object obj)
    {
        f.b(obj);
        if (obj instanceof CharSequence)
        {
            return (CharSequence)obj;
        } else
        {
            return obj.toString();
        }
    }

    public final StringBuilder a(StringBuilder stringbuilder, Iterator iterator)
    {
        try
        {
            a(((Appendable) (stringbuilder)), iterator);
        }
        // Misplaced declaration of an exception variable
        catch (StringBuilder stringbuilder)
        {
            throw new AssertionError(stringbuilder);
        }
        return stringbuilder;
    }

    public efy b(String s)
    {
        f.b(s);
        return new efz(this, this, s);
    }

    public egc c(String s)
    {
        return new egc(this, s);
    }
}
