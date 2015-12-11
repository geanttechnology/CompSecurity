// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class b
{

    protected final DataHolder zU;
    protected final int zW;
    private final int zX;

    public b(DataHolder dataholder, int i)
    {
        zU = (DataHolder)er.f(dataholder);
        boolean flag;
        if (i >= 0 && i < dataholder.getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.v(flag);
        zW = i;
        zX = dataholder.I(zW);
    }

    protected void a(String s, CharArrayBuffer chararraybuffer)
    {
        zU.copyToBuffer(s, zW, zX, chararraybuffer);
    }

    protected Uri aa(String s)
    {
        return zU.parseUri(s, zW, zX);
    }

    protected boolean ab(String s)
    {
        return zU.hasNull(s, zW, zX);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof b)
        {
            obj = (b)obj;
            flag = flag1;
            if (ep.equal(Integer.valueOf(((b) (obj)).zW), Integer.valueOf(zW)))
            {
                flag = flag1;
                if (ep.equal(Integer.valueOf(((b) (obj)).zX), Integer.valueOf(zX)))
                {
                    flag = flag1;
                    if (((b) (obj)).zU == zU)
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
        return zU.getBoolean(s, zW, zX);
    }

    protected byte[] getByteArray(String s)
    {
        return zU.getByteArray(s, zW, zX);
    }

    protected int getInteger(String s)
    {
        return zU.getInteger(s, zW, zX);
    }

    protected long getLong(String s)
    {
        return zU.getLong(s, zW, zX);
    }

    protected String getString(String s)
    {
        return zU.getString(s, zW, zX);
    }

    public boolean hasColumn(String s)
    {
        return zU.hasColumn(s);
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            Integer.valueOf(zW), Integer.valueOf(zX), zU
        });
    }

    public boolean isDataValid()
    {
        return !zU.isClosed();
    }
}
