// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            fl, cy

final class fx
{

    private int dZ;
    private String ih;
    private Map ii;
    private long ij;
    private boolean ik;
    private boolean il;
    private long im;

    public fx(int i, String s, Map map, long l, boolean flag)
    {
        dZ = i;
        ih = s;
        ii = map;
        ij = l;
        ik = flag;
        if (ik)
        {
            il = false;
            return;
        } else
        {
            il = true;
            return;
        }
    }

    public final boolean K(String s)
    {
        return ik && im == 0L && ih.equals(s);
    }

    public final boolean bC()
    {
        return ik;
    }

    public final void d(Map map)
    {
        if (ii == null || ii.size() == 0)
        {
            ii = map;
        } else
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                if (ii.containsKey(entry.getKey()))
                {
                    ii.remove(entry.getKey());
                    ii.put(entry.getKey(), entry.getValue());
                } else
                {
                    ii.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public final void e(Map map)
    {
        ii = map;
    }

    public final byte[] getBytes()
    {
        Object obj;
        Object obj1;
        obj1 = new ByteArrayOutputStream();
        obj = new DataOutputStream(((java.io.OutputStream) (obj1)));
        ((DataOutputStream) (obj)).writeShort(dZ);
        ((DataOutputStream) (obj)).writeUTF(ih);
        if (ii != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ((DataOutputStream) (obj)).writeShort(0);
_L1:
        byte abyte0[];
        ((DataOutputStream) (obj)).writeLong(ij);
        ((DataOutputStream) (obj)).writeLong(im);
        ((DataOutputStream) (obj)).flush();
        abyte0 = ((ByteArrayOutputStream) (obj1)).toByteArray();
        fl.a(((java.io.Closeable) (obj)));
        return abyte0;
        ((DataOutputStream) (obj)).writeShort(ii.size());
        Iterator iterator = ii.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            ((DataOutputStream) (obj)).writeUTF(fl.sanitize((String)entry.getKey()));
            ((DataOutputStream) (obj)).writeUTF(fl.sanitize((String)entry.getValue()));
        }
          goto _L1
        IOException ioexception1;
        ioexception1;
_L5:
        fl.a(((java.io.Closeable) (obj)));
        return new byte[0];
        obj;
        Object obj2;
        obj2 = null;
        ioexception1 = ((IOException) (obj));
_L3:
        fl.a(((java.io.Closeable) (obj2)));
        throw ioexception1;
        ioexception1;
        obj2 = obj;
        if (true) goto _L3; else goto _L2
_L2:
        IOException ioexception;
        ioexception;
        ioexception = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final Map getParameters()
    {
        return ii;
    }

    public final void h(long l)
    {
        il = true;
        im = l - ij;
        cy.c("FlurryAgent", (new StringBuilder()).append("Ended event '").append(ih).append("' (").append(ij).append(") after ").append(im).append("ms").toString());
    }

    public final boolean isFinished()
    {
        return il;
    }
}
