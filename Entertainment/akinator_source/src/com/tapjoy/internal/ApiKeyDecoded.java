// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;

// Referenced classes of package com.tapjoy.internal:
//            hk

public class ApiKeyDecoded
{
    public static final class KeyUsage extends Enum
    {

        private static final KeyUsage $VALUES[];
        public static final KeyUsage RPC_ANALYTICS;
        public static final KeyUsage SDK_ANDROID;
        public byte id;

        public static KeyUsage valueOf(byte byte0)
        {
            KeyUsage akeyusage[] = values();
            int j = akeyusage.length;
            for (int i = 0; i < j; i++)
            {
                KeyUsage keyusage = akeyusage[i];
                if (keyusage.id == byte0)
                {
                    return keyusage;
                }
            }

            return null;
        }

        public static KeyUsage valueOf(String s)
        {
            return (KeyUsage)Enum.valueOf(com/tapjoy/internal/ApiKeyDecoded$KeyUsage, s);
        }

        public static KeyUsage[] values()
        {
            return (KeyUsage[])$VALUES.clone();
        }

        static 
        {
            SDK_ANDROID = new KeyUsage("SDK_ANDROID", 0, (byte)2);
            RPC_ANALYTICS = new KeyUsage("RPC_ANALYTICS", 1, (byte)49);
            $VALUES = (new KeyUsage[] {
                SDK_ANDROID, RPC_ANALYTICS
            });
        }

        private KeyUsage(String s, int i, byte byte0)
        {
            super(s, i);
            id = byte0;
        }
    }


    private final String a;
    private final int b;
    private final KeyUsage c;
    private final String d;
    private final String e;
    private final String f;

    public ApiKeyDecoded(String s)
    {
        int i = s.length();
        if (!s.matches("[A-Za-z0-9\\-_]*") || i < 60 || (i & 3) != 0)
        {
            throw new IllegalArgumentException("The given API key was malformed.");
        }
        byte abyte0[];
        ByteBuffer bytebuffer;
        CRC32 crc32;
        int j;
        int k;
        try
        {
            abyte0 = Base64.decode(s, 8);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("The given API key was malformed.", s);
        }
        i = abyte0.length;
        bytebuffer = ByteBuffer.wrap(abyte0);
        bytebuffer.order(ByteOrder.BIG_ENDIAN);
        j = abyte0.length - 4;
        k = bytebuffer.getInt(j);
        crc32 = new CRC32();
        crc32.update(abyte0, 0, j);
        if (k != (int)crc32.getValue())
        {
            throw new IllegalArgumentException("The given API key was invalid.");
        }
        a = s;
        d = (new UUID(bytebuffer.getLong(0), bytebuffer.getLong(8))).toString();
        b = bytebuffer.get(16);
        c = KeyUsage.valueOf(bytebuffer.get(17));
        e = s.substring(24, 44);
        if (b == 1)
        {
            f = null;
            return;
        }
        if (b == 2 && c == KeyUsage.SDK_ANDROID)
        {
            if (i < 57)
            {
                throw new IllegalArgumentException("The given API key was invalid.");
            } else
            {
                s = new byte[12];
                System.arraycopy(abyte0, 33, s, 0, s.length);
                f = new String(hk.a(s));
                return;
            }
        } else
        {
            throw new IllegalArgumentException("The given API key was not supported.");
        }
    }

    public static String get5RocksAppId(String s)
    {
        if (s.regionMatches(13, "-8000-8000-", 0, 11))
        {
            return s.substring(0, 8) + s.substring(24, 30) + s.substring(9, 13) + s.substring(30);
        } else
        {
            throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ApiKeyDecoded)
        {
            return a.equals(((ApiKeyDecoded)obj).a);
        } else
        {
            return false;
        }
    }

    public String getAnalyticsId()
    {
        return f;
    }

    public String getAppId()
    {
        return d;
    }

    public KeyUsage getKeyUsage()
    {
        return c;
    }

    public String getSecretKey()
    {
        return e;
    }

    public String toString()
    {
        return a;
    }
}
