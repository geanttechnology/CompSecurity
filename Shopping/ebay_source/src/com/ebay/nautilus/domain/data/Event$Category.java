// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            Event

public class this._cls0
{

    public String id;
    public boolean leafCategory;
    public int level;
    public String name;
    final Event this$0;

    public String toString()
    {
        return (new StringBuilder()).append("Category(").append(id).append(",").append(name).append(",").append(level).append(",").append(leafCategory).append(")").toString();
    }

    public ()
    {
        this$0 = Event.this;
        super();
    }
}
