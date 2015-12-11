// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.location.Location;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            eb, k, cy, fl, 
//            fx, cb

class am
{

    private static final String p = com/flurry/android/am.getSimpleName();
    private byte cF[];

    public am(eb eb1)
        throws IOException
    {
        Object obj1;
        obj1 = null;
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj = new DataOutputStream(bytearrayoutputstream);
        ((DataOutputStream) (obj)).writeShort(1);
        ((DataOutputStream) (obj)).writeUTF(eb1.getVersion());
        ((DataOutputStream) (obj)).writeLong(eb1.aJ());
        ((DataOutputStream) (obj)).writeLong(eb1.aK());
        ((DataOutputStream) (obj)).writeLong(eb1.aL());
        ((DataOutputStream) (obj)).writeUTF(eb1.getLocale());
        ((DataOutputStream) (obj)).writeUTF(eb1.getTimeZone());
        ((DataOutputStream) (obj)).writeByte(eb1.aM());
        ((DataOutputStream) (obj)).writeUTF(eb1.aN());
        if (eb1.getLocation() != null) goto _L2; else goto _L1
_L1:
        ((DataOutputStream) (obj)).writeBoolean(false);
_L6:
        ((DataOutputStream) (obj)).writeInt(eb1.aO());
        ((DataOutputStream) (obj)).writeByte(-1);
        ((DataOutputStream) (obj)).writeByte(-1);
        ((DataOutputStream) (obj)).writeByte(eb1.aP());
        if (eb1.aQ() != null) goto _L4; else goto _L3
_L3:
        ((DataOutputStream) (obj)).writeBoolean(false);
_L7:
        obj1 = eb1.aT();
        ((DataOutputStream) (obj)).writeShort(((Map) (obj1)).size());
        java.util.Map.Entry entry;
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((DataOutputStream) (obj)).writeInt(((k)entry.getValue()).value))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            ((DataOutputStream) (obj)).writeUTF((String)entry.getKey());
        }

          goto _L5
        obj1;
        eb1 = ((eb) (obj));
        obj = obj1;
_L11:
        cy.b(p, "", ((Throwable) (obj)));
        throw obj;
        obj1;
        obj = eb1;
        eb1 = ((eb) (obj1));
_L10:
        fl.a(((java.io.Closeable) (obj)));
        throw eb1;
_L2:
        ((DataOutputStream) (obj)).writeBoolean(true);
        ((DataOutputStream) (obj)).writeDouble(a(eb1.getLocation().getLatitude()));
        ((DataOutputStream) (obj)).writeDouble(a(eb1.getLocation().getLongitude()));
        ((DataOutputStream) (obj)).writeFloat(eb1.getLocation().getAccuracy());
          goto _L6
_L4:
        ((DataOutputStream) (obj)).writeBoolean(true);
        ((DataOutputStream) (obj)).writeLong(eb1.aQ().longValue());
          goto _L7
_L5:
        obj1 = eb1.aS();
        ((DataOutputStream) (obj)).writeShort(((List) (obj1)).size());
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((DataOutputStream) (obj)).write(((fx)((Iterator) (obj1)).next()).getBytes())) { }
        ((DataOutputStream) (obj)).writeBoolean(eb1.aU());
        obj1 = eb1.getErrors();
        int i;
        int j;
        int l;
        j = 0;
        i = 0;
        l = 0;
_L12:
        if (j >= ((List) (obj1)).size())
        {
            break MISSING_BLOCK_LABEL_436;
        }
        l += ((cb)((List) (obj1)).get(j)).getBytes().length;
        if (l <= 0x27100)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        cy.g(p, "Error Log size exceeded. No more event details logged.");
        ((DataOutputStream) (obj)).writeInt(eb1.aR());
        ((DataOutputStream) (obj)).writeShort(i);
        j = 0;
_L9:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ((DataOutputStream) (obj)).write(((cb)((List) (obj1)).get(j)).getBytes());
        j++;
        if (true) goto _L9; else goto _L8
_L8:
        ((DataOutputStream) (obj)).writeShort(0);
        ((DataOutputStream) (obj)).writeShort(0);
        cF = bytearrayoutputstream.toByteArray();
        fl.a(((java.io.Closeable) (obj)));
        return;
        eb1;
        obj = null;
          goto _L10
        obj;
        eb1 = ((eb) (obj1));
          goto _L11
        eb1;
          goto _L10
        i++;
        j++;
          goto _L12
    }

    public am(byte abyte0[])
    {
        cF = abyte0;
    }

    private static double a(double d)
    {
        return (double)Math.round(d * 1000D) / 1000D;
    }

    public final byte[] N()
    {
        return cF;
    }

}
