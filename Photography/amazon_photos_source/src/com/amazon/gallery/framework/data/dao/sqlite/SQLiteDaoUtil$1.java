// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            SQLiteDaoUtil

static final class  extends ThreadLocal
{

    public volatile Object get()
    {
        return get();
    }

    public StringBuilder get()
    {
        StringBuilder stringbuilder = (StringBuilder)super.get();
        stringbuilder.setLength(0);
        return stringbuilder;
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected StringBuilder initialValue()
    {
        return new StringBuilder(128);
    }

    ()
    {
    }
}
