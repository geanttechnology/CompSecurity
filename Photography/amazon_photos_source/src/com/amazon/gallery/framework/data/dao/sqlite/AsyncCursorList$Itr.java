// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            AsyncCursorList

private class <init>
    implements Iterator
{

    Object e;
    int ePos;
    int pos;
    final AsyncCursorList this$0;

    public boolean hasNext()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (pos + 1 < size())
        {
            try
            {
                ePos = pos + 1;
                e = get(ePos);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                return false;
            }
            flag = flag1;
            if (e != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public Object next()
    {
        Object obj;
        try
        {
            pos = pos + 1;
            if (ePos == pos)
            {
                return e;
            }
            obj = get(pos);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            throw new NoSuchElementException();
        }
        return obj;
    }

    public void remove()
    {
        throw new RuntimeException("Operation is not supported");
    }

    private ()
    {
        this$0 = AsyncCursorList.this;
        super();
        pos = -1;
        ePos = -1;
    }

    ePos(ePos epos)
    {
        this();
    }
}
