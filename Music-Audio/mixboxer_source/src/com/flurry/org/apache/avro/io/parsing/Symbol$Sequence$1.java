// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

class oduction
    implements Iterator
{

    private int pos;
    final next this$0;

    public boolean hasNext()
    {
        return pos > 0;
    }

    public Symbol next()
    {
        if (pos > 0)
        {
            Symbol asymbol[] = oduction;
            int i = pos - 1;
            pos = i;
            return asymbol[i];
        } else
        {
            throw new NoSuchElementException();
        }
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
        pos = oduction.length;
    }
}
