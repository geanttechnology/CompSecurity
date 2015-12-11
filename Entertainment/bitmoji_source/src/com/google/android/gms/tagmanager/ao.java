// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, j, bh

class ao extends aj
{

    private static final String ID;
    private static final String US;
    private static final String UU;
    private static final String UY;

    public ao()
    {
        super(ID, new String[] {
            US
        });
    }

    private byte[] c(String s, byte abyte0[])
        throws NoSuchAlgorithmException
    {
        s = MessageDigest.getInstance(s);
        s.update(abyte0);
        return s.digest();
    }

    public boolean iy()
    {
        return true;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj = (com.google.android.gms.internal.d.a)map.get(US);
        if (obj == null || obj == di.ku())
        {
            return di.ku();
        }
        String s = di.j(((com.google.android.gms.internal.d.a) (obj)));
        obj = (com.google.android.gms.internal.d.a)map.get(UY);
        if (obj == null)
        {
            obj = "MD5";
        } else
        {
            obj = di.j(((com.google.android.gms.internal.d.a) (obj)));
        }
        map = (com.google.android.gms.internal.d.a)map.get(UU);
        if (map == null)
        {
            map = "text";
        } else
        {
            map = di.j(map);
        }
        if ("text".equals(map))
        {
            map = s.getBytes();
        } else
        if ("base16".equals(map))
        {
            map = j.aX(s);
        } else
        {
            bh.t((new StringBuilder()).append("Hash: unknown input format: ").append(map).toString());
            return di.ku();
        }
        try
        {
            map = di.r(j.d(c(((String) (obj)), map)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            bh.t((new StringBuilder()).append("Hash: unknown algorithm: ").append(((String) (obj))).toString());
            return di.ku();
        }
        return map;
    }

    static 
    {
        ID = a.al.toString();
        US = b.bt.toString();
        UY = b.bk.toString();
        UU = b.cS.toString();
    }
}
