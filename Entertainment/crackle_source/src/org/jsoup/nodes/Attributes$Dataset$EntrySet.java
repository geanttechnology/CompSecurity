// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package org.jsoup.nodes:
//            Attributes

private class <init> extends AbstractSet
{

    final this._cls1 this$1;

    public Iterator iterator()
    {
        return new erator(this._cls1.this, null);
    }

    public int size()
    {
        int i = 0;
        for (erator erator = new erator(this._cls1.this, null); erator.hasNext();)
        {
            i++;
        }

        return i;
    }

    private erator()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
