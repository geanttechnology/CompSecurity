// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            cy

final class gc
{

    private static List ip = Arrays.asList(new String[] {
        "requested", "filled", "unfilled", "rendered", "clicked", "videoStart", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", 
        "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", "capExhausted", "capNotExhausted"
    });
    private final Map bj;
    private final String iq;
    private final boolean ir;
    private final long is;

    gc(DataInput datainput)
        throws IOException
    {
        iq = datainput.readUTF();
        ir = datainput.readBoolean();
        is = datainput.readLong();
        bj = new HashMap();
        short word1 = datainput.readShort();
        for (short word0 = 0; word0 < word1; word0++)
        {
            bj.put(datainput.readUTF(), datainput.readUTF());
        }

    }

    gc(String s, boolean flag, long l, Map map)
    {
        if (!ip.contains(s))
        {
            cy.c("FlurryAgent", (new StringBuilder()).append("AdEvent initialized with unrecognized type: ").append(s).toString());
        }
        iq = s;
        ir = flag;
        is = l;
        if (map == null)
        {
            bj = new HashMap();
            return;
        } else
        {
            bj = map;
            return;
        }
    }

    final void a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeUTF(iq);
        dataoutput.writeBoolean(ir);
        dataoutput.writeLong(is);
        dataoutput.writeShort(bj.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = bj.entrySet().iterator(); iterator.hasNext(); dataoutput.writeUTF((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            dataoutput.writeUTF((String)entry.getKey());
        }

    }

    final boolean bD()
    {
        return ir;
    }

    final long bh()
    {
        return is;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof gc))
            {
                return false;
            }
            obj = (gc)obj;
            if (!TextUtils.equals(iq, ((gc) (obj)).iq) || ir != ((gc) (obj)).ir || is != ((gc) (obj)).is || bj != ((gc) (obj)).bj && (bj == null || !bj.equals(((gc) (obj)).bj)))
            {
                return false;
            }
        }
        return true;
    }

    final Map getParams()
    {
        return bj;
    }

    final String getType()
    {
        return iq;
    }

    public final int hashCode()
    {
        int i = 17;
        if (iq != null)
        {
            i = iq.hashCode() | 0x11;
        }
        int j = i;
        if (ir)
        {
            j = i | 1;
        }
        j = (int)((long)j | is);
        i = j;
        if (bj != null)
        {
            i = j | bj.hashCode();
        }
        return i;
    }

}
