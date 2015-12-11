// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.location.Location;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            df, cx, el, fb, 
//            cy

public class de
{

    private static final String b = com/flurry/sdk/de.getSimpleName();
    byte a[];

    public de(df df1)
        throws IOException
    {
        Object obj1;
        obj1 = null;
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj = new DataOutputStream(bytearrayoutputstream);
        ((DataOutputStream) (obj)).writeShort(3);
        ((DataOutputStream) (obj)).writeUTF(df1.a());
        ((DataOutputStream) (obj)).writeLong(df1.b());
        ((DataOutputStream) (obj)).writeLong(df1.c());
        ((DataOutputStream) (obj)).writeLong(df1.d());
        obj1 = df1.e();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        ((DataOutputStream) (obj)).writeShort(0);
_L15:
        ((DataOutputStream) (obj)).writeUTF(df1.f());
        ((DataOutputStream) (obj)).writeUTF(df1.g());
        ((DataOutputStream) (obj)).writeByte(df1.h());
        ((DataOutputStream) (obj)).writeUTF(df1.i());
        if (df1.j() != null) goto _L4; else goto _L3
_L3:
        ((DataOutputStream) (obj)).writeBoolean(false);
_L16:
        ((DataOutputStream) (obj)).writeInt(df1.k());
        ((DataOutputStream) (obj)).writeByte(-1);
        ((DataOutputStream) (obj)).writeByte(-1);
        ((DataOutputStream) (obj)).writeByte(df1.l());
        if (df1.m() != null) goto _L6; else goto _L5
_L5:
        ((DataOutputStream) (obj)).writeBoolean(false);
_L17:
        obj1 = df1.n();
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        ((DataOutputStream) (obj)).writeShort(0);
_L18:
        obj1 = df1.o();
        if (obj1 != null) goto _L10; else goto _L9
_L9:
        ((DataOutputStream) (obj)).writeShort(0);
_L19:
        ((DataOutputStream) (obj)).writeBoolean(df1.p());
        obj1 = df1.r();
        if (obj1 == null) goto _L12; else goto _L11
_L11:
        int i;
        int j;
        int k;
        j = 0;
        k = 0;
        i = 0;
_L23:
        if (j >= ((List) (obj1)).size())
        {
            break MISSING_BLOCK_LABEL_258;
        }
        k += ((cx)((List) (obj1)).get(j)).a();
        if (k <= 0x27100)
        {
            break MISSING_BLOCK_LABEL_664;
        }
        el.a(5, b, "Error Log size exceeded. No more event details logged.");
_L22:
        ((DataOutputStream) (obj)).writeInt(df1.q());
        ((DataOutputStream) (obj)).writeShort(i);
        j = 0;
_L14:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ((DataOutputStream) (obj)).write(((cx)((List) (obj1)).get(j)).b());
        j++;
        if (true) goto _L14; else goto _L13
_L2:
        ((DataOutputStream) (obj)).writeShort(((Map) (obj1)).size());
        obj1 = ((Map) (obj1)).entrySet().iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            ((DataOutputStream) (obj)).writeUTF((String)entry.getKey());
            ((DataOutputStream) (obj)).writeUTF((String)entry.getValue());
            ((DataOutputStream) (obj)).writeByte(0);
        }
          goto _L15
        obj1;
        df1 = ((df) (obj));
        obj = obj1;
_L21:
        el.a(6, b, "", ((Throwable) (obj)));
        throw obj;
        obj1;
        obj = df1;
        df1 = ((df) (obj1));
_L20:
        fb.a(((java.io.Closeable) (obj)));
        throw df1;
_L4:
        ((DataOutputStream) (obj)).writeBoolean(true);
        ((DataOutputStream) (obj)).writeDouble(a(df1.j().getLatitude()));
        ((DataOutputStream) (obj)).writeDouble(a(df1.j().getLongitude()));
        ((DataOutputStream) (obj)).writeFloat(df1.j().getAccuracy());
          goto _L16
_L6:
        ((DataOutputStream) (obj)).writeBoolean(true);
        ((DataOutputStream) (obj)).writeLong(df1.m().longValue());
          goto _L17
_L8:
        ((DataOutputStream) (obj)).writeShort(((Map) (obj1)).size());
        obj1 = ((Map) (obj1)).entrySet().iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            ((DataOutputStream) (obj)).writeUTF((String)entry1.getKey());
            ((DataOutputStream) (obj)).writeInt(((cu.a)entry1.getValue()).a);
        }
          goto _L18
_L10:
        ((DataOutputStream) (obj)).writeShort(((List) (obj1)).size());
        obj1 = ((List) (obj1)).iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            ((DataOutputStream) (obj)).write(((cy)((Iterator) (obj1)).next()).e());
        }
          goto _L19
_L13:
        ((DataOutputStream) (obj)).writeInt(-1);
        ((DataOutputStream) (obj)).writeShort(0);
        ((DataOutputStream) (obj)).writeShort(0);
        ((DataOutputStream) (obj)).writeShort(0);
        a = bytearrayoutputstream.toByteArray();
        fb.a(((java.io.Closeable) (obj)));
        return;
        df1;
        obj = null;
          goto _L20
        obj;
        df1 = ((df) (obj1));
          goto _L21
_L12:
        i = 0;
          goto _L22
        df1;
          goto _L20
        i++;
        j++;
          goto _L23
    }

    public de(byte abyte0[])
    {
        a = abyte0;
    }

    double a(double d)
    {
        return (double)Math.round(d * 1000D) / 1000D;
    }

    public byte[] a()
    {
        return a;
    }

}
