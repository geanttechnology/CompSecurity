// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.table;


// Referenced classes of package net.tsz.afinal.db.table:
//            Property

public class ManyToOne extends Property
{

    private Class manyClass;

    public ManyToOne()
    {
    }

    public Class getManyClass()
    {
        return manyClass;
    }

    public void setManyClass(Class class1)
    {
        manyClass = class1;
    }
}
