// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            CrcMessageDigest, FlurryAgent, ReportedIdType, cy, 
//            fl, ar, es, am

class cn
{

    private static final String p = com/flurry/android/cn.getSimpleName();
    private byte cF[];

    public cn(String s, String s1, String s2, long l, long l1, 
            List list, File file, Map map, Map map1, Map map2)
        throws IOException
    {
        Object obj;
        cF = null;
        obj = null;
        DataOutputStream dataoutputstream;
        CrcMessageDigest crcmessagedigest;
        ByteArrayOutputStream bytearrayoutputstream;
        DigestOutputStream digestoutputstream;
        crcmessagedigest = new CrcMessageDigest();
        bytearrayoutputstream = new ByteArrayOutputStream();
        digestoutputstream = new DigestOutputStream(bytearrayoutputstream, crcmessagedigest);
        dataoutputstream = new DataOutputStream(digestoutputstream);
        dataoutputstream.writeShort(26);
        dataoutputstream.writeShort(0);
        dataoutputstream.writeLong(0L);
        dataoutputstream.writeShort(0);
        dataoutputstream.writeShort(3);
        dataoutputstream.writeShort(FlurryAgent.getAgentVersion());
        dataoutputstream.writeLong(System.currentTimeMillis());
        dataoutputstream.writeUTF(s);
        dataoutputstream.writeUTF(s1);
        dataoutputstream.writeShort(map.size() + 1);
        dataoutputstream.writeShort(0);
        dataoutputstream.writeUTF(s2);
        if (!map.isEmpty())
        {
            for (s = map.entrySet().iterator(); s.hasNext(); dataoutputstream.write(s1))
            {
                s1 = (java.util.Map.Entry)s.next();
                dataoutputstream.writeShort(((ReportedIdType)s1.getKey()).eS);
                s1 = ((ByteBuffer)s1.getValue()).array();
                dataoutputstream.writeShort(s1.length);
            }

        }
          goto _L1
        s1;
        s = dataoutputstream;
_L17:
        cy.b(p, "Error when generating report", s1);
        fl.a(s);
        s = null;
_L15:
        cF = s;
        return;
_L1:
        dataoutputstream.writeByte(0);
        dataoutputstream.writeLong(l);
        dataoutputstream.writeLong(l1);
        dataoutputstream.writeShort(6);
        dataoutputstream.writeUTF("device.model");
        dataoutputstream.writeUTF(Build.MODEL);
        dataoutputstream.writeUTF("build.brand");
        dataoutputstream.writeUTF(Build.BRAND);
        dataoutputstream.writeUTF("build.id");
        dataoutputstream.writeUTF(Build.ID);
        dataoutputstream.writeUTF("version.release");
        dataoutputstream.writeUTF(android.os.Build.VERSION.RELEASE);
        dataoutputstream.writeUTF("build.device");
        dataoutputstream.writeUTF(Build.DEVICE);
        dataoutputstream.writeUTF("build.product");
        dataoutputstream.writeUTF(Build.PRODUCT);
        if (map1 == null) goto _L3; else goto _L2
_L2:
        int i = map1.keySet().size();
_L6:
        (new StringBuilder()).append("refMapSize is:  ").append(i).toString();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        map1 = (new ar(file)).W();
        dataoutputstream.writeShort(i);
        if (map1 == null) goto _L5; else goto _L4
_L4:
        for (s = map1.entrySet().iterator(); s.hasNext();)
        {
            s1 = (java.util.Map.Entry)s.next();
            (new StringBuilder()).append("Referrer Entry:  ").append((String)s1.getKey()).append("=").append(s1.getValue()).toString();
            dataoutputstream.writeUTF((String)s1.getKey());
            (new StringBuilder()).append("referrer key is :").append((String)s1.getKey()).toString();
            dataoutputstream.writeShort(((List)s1.getValue()).size());
            s1 = ((List)s1.getValue()).iterator();
            while (s1.hasNext()) 
            {
                s2 = (String)s1.next();
                dataoutputstream.writeUTF(s2);
                (new StringBuilder()).append("referrer value is :").append(s2).toString();
            }
        }

          goto _L5
        s;
        s1 = dataoutputstream;
_L16:
        fl.a(s1);
        throw s;
_L3:
        i = 0;
          goto _L6
_L5:
        s = es.aW();
        if (!FlurryAgent.q() || s == null) goto _L8; else goto _L7
_L7:
        if (s.getPushToken().length() <= 0) goto _L8; else goto _L9
_L9:
        dataoutputstream.writeBoolean(true);
        dataoutputstream.writeUTF(s.getPushToken());
_L12:
        if (map2 == null)
        {
            break MISSING_BLOCK_LABEL_1021;
        }
        i = map2.keySet().size();
_L18:
        (new StringBuilder()).append("optionsMapSize is:  ").append(i).toString();
        dataoutputstream.writeShort(i);
        if (map2 == null) goto _L11; else goto _L10
_L10:
        for (s = map2.entrySet().iterator(); s.hasNext();)
        {
            s1 = (java.util.Map.Entry)s.next();
            (new StringBuilder()).append("Launch Options Key:  ").append((String)s1.getKey()).toString();
            dataoutputstream.writeUTF((String)s1.getKey());
            dataoutputstream.writeShort(((List)s1.getValue()).size());
            s1 = ((List)s1.getValue()).iterator();
            while (s1.hasNext()) 
            {
                s2 = (String)s1.next();
                dataoutputstream.writeUTF(s2);
                (new StringBuilder()).append("Launch Options value is :").append(s2).toString();
            }
        }

          goto _L11
_L8:
        dataoutputstream.writeBoolean(false);
          goto _L12
_L11:
        int j;
        j = list.size();
        dataoutputstream.writeShort(j);
        i = 0;
_L14:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        dataoutputstream.write(((am)list.get(i)).N());
        i++;
        if (true) goto _L14; else goto _L13
_L13:
        digestoutputstream.on(false);
        dataoutputstream.write(crcmessagedigest.getDigest());
        dataoutputstream.close();
        s = bytearrayoutputstream.toByteArray();
        fl.a(dataoutputstream);
          goto _L15
        s;
        s1 = null;
          goto _L16
        s2;
        s1 = s;
        s = s2;
          goto _L16
        s1;
        s = obj;
          goto _L17
        i = 0;
          goto _L18
    }

    public final byte[] N()
    {
        return cF;
    }

}
