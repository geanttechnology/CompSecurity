// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import cn.jpush.android.a;
import cn.jpush.android.data.r;
import cn.jpush.android.util.aa;
import cn.jpush.android.util.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// Referenced classes of package cn.jpush.android.service:
//            ServiceInterface

final class o
    implements Runnable
{

    private static final String z[];
    final String a;
    final byte b[];

    o(String s, byte abyte0[])
    {
        a = s;
        b = abyte0;
        super();
    }

    public final void run()
    {
        Object obj = null;
        DatagramSocket datagramsocket = new DatagramSocket();
        obj = datagramsocket;
        datagramsocket.setSoTimeout(20000);
        obj = datagramsocket;
        Object obj2 = new ByteArrayOutputStream();
        obj = datagramsocket;
        ((ByteArrayOutputStream) (obj2)).write(a.getBytes());
        obj = datagramsocket;
        ((ByteArrayOutputStream) (obj2)).write(b);
        obj = datagramsocket;
        byte abyte0[] = ((ByteArrayOutputStream) (obj2)).toByteArray();
        obj = datagramsocket;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        obj = datagramsocket;
        bytearrayoutputstream.write(aa.a(abyte0.length, 2));
        obj = datagramsocket;
        bytearrayoutputstream.write(abyte0);
        obj = datagramsocket;
        byte abyte1[] = bytearrayoutputstream.toByteArray();
        obj = datagramsocket;
        if (!z[1].equals(a)) goto _L2; else goto _L1
_L1:
        obj = datagramsocket;
        abyte0 = ServiceInterface.c();
        obj = datagramsocket;
        int i = ServiceInterface.d();
_L3:
        obj = datagramsocket;
        datagramsocket.send(new DatagramPacket(abyte1, abyte1.length, InetAddress.getByName(abyte0), i));
        if (datagramsocket != null)
        {
            datagramsocket.close();
        }
_L5:
        return;
_L2:
        obj = datagramsocket;
        abyte0 = ServiceInterface.e();
        obj = datagramsocket;
        i = ServiceInterface.f();
          goto _L3
        obj;
        datagramsocket = null;
_L10:
        obj = datagramsocket;
        x.h();
        obj = datagramsocket;
        abyte0 = new String(b);
        obj = datagramsocket;
        (new StringBuilder(z[0])).append(abyte0).toString();
        obj = datagramsocket;
        x.c();
        obj = datagramsocket;
        r.a(a.d, a, abyte0);
        if (datagramsocket == null) goto _L5; else goto _L4
_L4:
        datagramsocket.close();
        return;
        obj;
        datagramsocket = null;
_L9:
        obj = datagramsocket;
        x.h();
        obj = datagramsocket;
        abyte0 = new String(b);
        obj = datagramsocket;
        (new StringBuilder(z[0])).append(abyte0).toString();
        obj = datagramsocket;
        x.c();
        obj = datagramsocket;
        r.a(a.d, a, abyte0);
        if (datagramsocket == null) goto _L5; else goto _L6
_L6:
        datagramsocket.close();
        return;
        Exception exception;
        exception;
_L8:
        if (obj != null)
        {
            ((DatagramSocket) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        Object obj1;
        obj1;
          goto _L9
        obj1;
          goto _L10
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int l;
        as2 = new String[2];
        obj1 = "2LeIK\fLx^\n\006L+K\n\bEnIKL\004+";
        k = -1;
        l = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = 0;
        as = ((String []) (obj));
        i1 = l;
        obj = obj1;
        j1 = k;
_L9:
        l = i;
        k = i;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 236
    //                   1 243
    //                   2 250
    //                   3 257;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 107;
_L11:
label0:
        {
            obj1[k] = (char)(i ^ k1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        k = j;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        j = k;
        i = l;
        if (k > l) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "4m";
            l = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 97;
          goto _L11
_L3:
        i = 41;
          goto _L11
_L4:
        i = 11;
          goto _L11
_L5:
        i = 45;
          goto _L11
        boolean flag = false;
        k1 = k;
        l1 = l;
        as1 = ((String []) (obj));
        k = j;
        l = ((flag) ? 1 : 0);
          goto _L12
    }
}
