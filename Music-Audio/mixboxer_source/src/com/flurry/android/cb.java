// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.flurry.android:
//            fl

final class cb
{

    private int dZ;
    private long ea;
    private String eb;
    private String ec;
    private String ed;
    private Throwable ee;

    public cb(int i, long l, String s, String s1, String s2, Throwable throwable)
    {
        dZ = i;
        ea = l;
        eb = s;
        ec = s1;
        ed = s2;
        ee = throwable;
    }

    public final String at()
    {
        return eb;
    }

    public final byte[] getBytes()
    {
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj = new DataOutputStream(bytearrayoutputstream);
        Object obj1 = obj;
        ((DataOutputStream) (obj)).writeShort(dZ);
        obj1 = obj;
        ((DataOutputStream) (obj)).writeLong(ea);
        obj1 = obj;
        ((DataOutputStream) (obj)).writeUTF(eb);
        obj1 = obj;
        ((DataOutputStream) (obj)).writeUTF(ec);
        obj1 = obj;
        ((DataOutputStream) (obj)).writeUTF(ed);
        obj1 = obj;
        if (ee == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (eb != "uncaught") goto _L4; else goto _L3
_L3:
        obj1 = obj;
        ((DataOutputStream) (obj)).writeByte(3);
_L8:
        obj1 = obj;
        ((DataOutputStream) (obj)).writeByte(2);
        obj1 = obj;
        StringBuilder stringbuilder = new StringBuilder("");
        obj1 = obj;
        String s = System.getProperty("line.separator");
        obj1 = obj;
        StackTraceElement astacktraceelement[] = ee.getStackTrace();
        obj1 = obj;
        int j = astacktraceelement.length;
        int i = 0;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        stringbuilder.append(astacktraceelement[i]);
        obj1 = obj;
        stringbuilder.append(s);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        obj1 = obj;
        ((DataOutputStream) (obj)).writeByte(2);
        if (true) goto _L8; else goto _L7
        obj1;
_L17:
        fl.a(((java.io.Closeable) (obj)));
        return new byte[0];
_L7:
        obj1 = obj;
        if (ee.getCause() == null) goto _L10; else goto _L9
_L9:
        obj1 = obj;
        stringbuilder.append(s);
        obj1 = obj;
        stringbuilder.append("Caused by: ");
        obj1 = obj;
        astacktraceelement = ee.getCause().getStackTrace();
        obj1 = obj;
        j = astacktraceelement.length;
        i = 0;
_L11:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        stringbuilder.append(astacktraceelement[i]);
        obj1 = obj;
        stringbuilder.append(s);
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        obj1 = obj;
        byte abyte1[] = stringbuilder.toString().getBytes();
        obj1 = obj;
        ((DataOutputStream) (obj)).writeInt(abyte1.length);
        obj1 = obj;
        ((DataOutputStream) (obj)).write(abyte1);
_L13:
        obj1 = obj;
        ((DataOutputStream) (obj)).flush();
        obj1 = obj;
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        fl.a(((java.io.Closeable) (obj)));
        return abyte0;
_L2:
        obj1 = obj;
        ((DataOutputStream) (obj)).writeByte(1);
        obj1 = obj;
        ((DataOutputStream) (obj)).writeByte(0);
        if (true) goto _L13; else goto _L12
_L12:
        obj;
_L15:
        fl.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        obj1 = null;
        if (true) goto _L15; else goto _L14
_L14:
        IOException ioexception;
        ioexception;
        ioexception = null;
        if (true) goto _L17; else goto _L16
_L16:
    }
}
