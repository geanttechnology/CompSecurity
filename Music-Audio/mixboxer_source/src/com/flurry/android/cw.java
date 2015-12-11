// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            gc

final class cw
{

    private static int eV = 1;
    private final int eW;
    private final long eX;
    private final String eY;
    private List eZ;

    cw(long l, String s)
    {
        int i = eV;
        eV = i + 1;
        eW = i;
        eX = l;
        eY = s;
        eZ = new ArrayList();
    }

    cw(DataInput datainput)
        throws IOException
    {
        eW = datainput.readInt();
        eX = datainput.readLong();
        String s1 = datainput.readUTF();
        String s = s1;
        if (s1.equals(""))
        {
            s = null;
        }
        eY = s;
        eZ = new ArrayList();
        short word1 = datainput.readShort();
        for (short word0 = 0; word0 < word1; word0++)
        {
            eZ.add(new gc(datainput));
        }

    }

    final void a(gc gc1)
    {
        eZ.add(gc1);
    }

    final void a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeInt(eW);
        dataoutput.writeLong(eX);
        Object obj;
        if (eY == null)
        {
            obj = "";
        } else
        {
            obj = eY;
        }
        dataoutput.writeUTF(((String) (obj)));
        dataoutput.writeShort(eZ.size());
        for (obj = eZ.iterator(); ((Iterator) (obj)).hasNext(); ((gc)((Iterator) (obj)).next()).a(dataoutput)) { }
    }

    final String aA()
    {
        return eY;
    }

    final long aB()
    {
        return eX;
    }

    final List aC()
    {
        return eZ;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof cw))
            {
                return false;
            }
            obj = (cw)obj;
            if (eW != ((cw) (obj)).eW || eX != ((cw) (obj)).eX || !TextUtils.equals(eY, ((cw) (obj)).eY) || eZ != ((cw) (obj)).eZ && (eZ == null || !eZ.equals(((cw) (obj)).eZ)))
            {
                return false;
            }
        }
        return true;
    }

    final int getIndex()
    {
        return eW;
    }

    public final int hashCode()
    {
        int j = (int)((long)(eW | 0x11) | eX);
        int i = j;
        if (eY != null)
        {
            i = j | eY.hashCode();
        }
        j = i;
        if (eZ != null)
        {
            j = i | eZ.hashCode();
        }
        return j;
    }

}
