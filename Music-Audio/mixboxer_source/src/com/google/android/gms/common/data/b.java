// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class b
{

    protected final DataHolder nE;
    protected final int nG;
    private final int nH;

    public b(DataHolder dataholder, int i)
    {
        nE = (DataHolder)eg.f(dataholder);
        boolean flag;
        if (i >= 0 && i < dataholder.getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.p(flag);
        nG = i;
        nH = dataholder.C(nG);
    }

    protected Uri L(String s)
    {
        return nE.parseUri(s, nG, nH);
    }

    protected boolean M(String s)
    {
        return nE.hasNull(s, nG, nH);
    }

    protected void a(String s, CharArrayBuffer chararraybuffer)
    {
        nE.copyToBuffer(s, nG, nH, chararraybuffer);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof b)
        {
            obj = (b)obj;
            flag = flag1;
            if (ee.equal(Integer.valueOf(((b) (obj)).nG), Integer.valueOf(nG)))
            {
                flag = flag1;
                if (ee.equal(Integer.valueOf(((b) (obj)).nH), Integer.valueOf(nH)))
                {
                    flag = flag1;
                    if (((b) (obj)).nE == nE)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected boolean getBoolean(String s)
    {
        return nE.getBoolean(s, nG, nH);
    }

    protected byte[] getByteArray(String s)
    {
        return nE.getByteArray(s, nG, nH);
    }

    protected int getInteger(String s)
    {
        return nE.getInteger(s, nG, nH);
    }

    protected long getLong(String s)
    {
        return nE.getLong(s, nG, nH);
    }

    protected String getString(String s)
    {
        return nE.getString(s, nG, nH);
    }

    public boolean hasColumn(String s)
    {
        return nE.hasColumn(s);
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(nG), Integer.valueOf(nH), nE
        });
    }

    public boolean isDataValid()
    {
        return !nE.isClosed();
    }
}
