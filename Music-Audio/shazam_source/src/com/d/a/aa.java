// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.d.a:
//            ai

final class aa
{

    private int a;
    private String b;
    private Map c;
    private long d;
    private long e;

    public final byte[] a()
    {
        Object obj;
        Object obj1;
        obj1 = new ByteArrayOutputStream();
        obj = new DataOutputStream(((java.io.OutputStream) (obj1)));
        ((DataOutputStream) (obj)).writeShort(a);
        ((DataOutputStream) (obj)).writeUTF(b);
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ((DataOutputStream) (obj)).writeShort(0);
_L1:
        byte abyte0[];
        ((DataOutputStream) (obj)).writeLong(d);
        ((DataOutputStream) (obj)).writeLong(e);
        ((DataOutputStream) (obj)).flush();
        abyte0 = ((ByteArrayOutputStream) (obj1)).toByteArray();
        ai.a(((java.io.Closeable) (obj)));
        return abyte0;
        ((DataOutputStream) (obj)).writeShort(c.size());
        Iterator iterator = c.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            ((DataOutputStream) (obj)).writeUTF(ai.a((String)entry.getKey(), 255));
            ((DataOutputStream) (obj)).writeUTF(ai.a((String)entry.getValue(), 255));
        }
          goto _L1
        IOException ioexception1;
        ioexception1;
_L5:
        ai.a(((java.io.Closeable) (obj)));
        return new byte[0];
        obj;
        Object obj2;
        obj2 = null;
        ioexception1 = ((IOException) (obj));
_L3:
        ai.a(((java.io.Closeable) (obj2)));
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
}
