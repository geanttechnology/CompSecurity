// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import java.util.Iterator;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericData

class position
    implements Iterator
{

    private int position;
    final position this$0;

    public boolean hasNext()
    {
        return position < cess._mth100(this._cls0.this);
    }

    public Object next()
    {
        Object aobj[] = cess._mth200(this._cls0.this);
        int i = position;
        position = i + 1;
        return aobj[i];
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
        position = 0;
    }
}
