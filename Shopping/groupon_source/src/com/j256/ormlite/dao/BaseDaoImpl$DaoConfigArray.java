// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;


// Referenced classes of package com.j256.ormlite.dao:
//            BaseDaoImpl

private static class <init>
{

    private BaseDaoImpl daoArray[];
    private int daoArrayC;

    public void addDao(BaseDaoImpl basedaoimpl)
    {
        if (daoArrayC == daoArray.length)
        {
            BaseDaoImpl abasedaoimpl[] = new BaseDaoImpl[daoArray.length * 2];
            for (int i = 0; i < daoArray.length; i++)
            {
                abasedaoimpl[i] = daoArray[i];
                daoArray[i] = null;
            }

            daoArray = abasedaoimpl;
        }
        BaseDaoImpl abasedaoimpl1[] = daoArray;
        int j = daoArrayC;
        daoArrayC = j + 1;
        abasedaoimpl1[j] = basedaoimpl;
    }

    public void clear()
    {
        for (int i = 0; i < daoArrayC; i++)
        {
            daoArray[i] = null;
        }

        daoArrayC = 0;
    }

    public BaseDaoImpl get(int i)
    {
        return daoArray[i];
    }

    public int size()
    {
        return daoArrayC;
    }

    private ()
    {
        daoArray = new BaseDaoImpl[10];
        daoArrayC = 0;
    }

    daoArrayC(daoArrayC daoarrayc)
    {
        this();
    }
}
