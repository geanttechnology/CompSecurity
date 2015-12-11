// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

// Referenced classes of package org.jsoup.nodes:
//            Attributes, Attribute

private class <init>
    implements Iterator
{

    private Attribute attr;
    private Iterator attrIter;
    final attr this$1;

    public boolean hasNext()
    {
        while (attrIter.hasNext()) 
        {
            attr = (Attribute)attrIter.next();
            if (attr.isDataAttribute())
            {
                return true;
            }
        }
        return false;
    }

    public volatile Object next()
    {
        return next();
    }

    public java.util.rator next()
    {
        return new Attribute(attr.getKey().substring("data-".length()), attr.getValue());
    }

    public void remove()
    {
        Attributes.access$100(this._cls1.this.attr).remove(attr.getKey());
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
        attrIter = Attributes.access$100(this._cls1.this.attrIter).values().iterator();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
