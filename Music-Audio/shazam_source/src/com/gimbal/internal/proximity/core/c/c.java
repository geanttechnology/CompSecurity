// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import com.gimbal.internal.proximity.core.b.b;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            j, b, g, d

public final class c
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/gimbal/internal/proximity/core/c/c$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("GIMBAL", 0);
            b = new a("UNKNOWN", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private final UUID a[];

    public c(UUID auuid[])
    {
        a = auuid;
    }

    public final com.gimbal.internal.proximity.core.c.b a(byte abyte0[])
    {
        byte abyte1[];
        Object obj;
        int i;
        boolean flag;
        int k;
        boolean flag1;
        flag = true;
        UUID uuid;
        try
        {
            abyte0 = new j(abyte0);
            obj = a;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return new com.gimbal.internal.proximity.core.c.b(com.gimbal.internal.proximity.core.c.a.b, null);
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((j) (abyte0)).a != null) goto _L3; else goto _L2
_L10:
        if (i == 0) goto _L5; else goto _L4
_L4:
        return new com.gimbal.internal.proximity.core.c.b(a.a, abyte0);
_L3:
        abyte1 = ((j) (abyte0)).a;
        uuid = g.a(abyte1);
        if (uuid != null) goto _L7; else goto _L6
_L6:
        obj = d.g;
        k = obj.length;
        i = 0;
          goto _L8
_L7:
        flag1 = Arrays.asList(((Object []) (obj))).contains(uuid);
          goto _L9
_L12:
        i = 0;
          goto _L10
_L5:
        return null;
_L2:
        flag1 = false;
_L9:
        if (!flag1) goto _L12; else goto _L11
_L11:
        i = ((flag) ? 1 : 0);
          goto _L10
_L8:
label0:
        {
            if (i >= k)
            {
                break MISSING_BLOCK_LABEL_178;
            }
            Object obj1 = obj[i];
            if (abyte1[0] != obj1[0] || abyte1[1] != obj1[1])
            {
                break label0;
            }
            flag1 = true;
        }
          goto _L9
        i++;
          goto _L8
        flag1 = false;
          goto _L9
    }
}
