// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.table;


// Referenced classes of package net.tsz.afinal.db.table:
//            Property

public class OneToMany extends Property
{

    private Class oneClass;

    public OneToMany()
    {
    }

    public Class getOneClass()
    {
        return oneClass;
    }

    public void setOneClass(Class class1)
    {
        oneClass = class1;
    }
}
