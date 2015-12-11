// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.flurry.android.impl.ads.protocol.v13.SdkLogRequest;
import com.flurry.android.impl.ads.protocol.v13.SdkLogResponse;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            gp, gh, cl, gd, 
//            gk, gt, fn, fp

public class cf extends gp
{

    private static final String a = com/flurry/sdk/cf.getSimpleName();
    private final gh b;
    private final gh g;

    public cf()
    {
        this(null);
    }

    public cf(gp.a a1)
    {
        super("Ads", com/flurry/sdk/cf.getSimpleName());
        b = new gh("sdk log request", new cl(com/flurry/android/impl/ads/protocol/v13/SdkLogRequest));
        g = new gh("sdk log response", new cl(com/flurry/android/impl/ads/protocol/v13/SdkLogResponse));
        f = "AdData_";
        a(a1);
    }

    static gh a(cf cf1)
    {
        return cf1.g;
    }

    static String a()
    {
        return a;
    }

    static void a(cf cf1, String s, String s1)
    {
        cf1.b(s, s1);
    }

    static void a(cf cf1, String s, String s1, int i)
    {
        cf1.a(s, s1, i);
    }

    static String b(cf cf1)
    {
        return cf1.c;
    }

    static void c(cf cf1)
    {
        cf1.e();
    }

    static String d(cf cf1)
    {
        return cf1.c;
    }

    protected Pair a(byte abyte0[])
    {
        boolean flag = false;
        byte abyte2[] = new byte[4];
        byte abyte1[] = new byte[abyte0.length - 4];
        int i = 0;
        while (i < abyte0.length) 
        {
            if (i < 4)
            {
                abyte2[i] = abyte0[i];
            } else
            {
                abyte1[i - 4] = abyte0[i];
            }
            i++;
        }
        int j = ByteBuffer.wrap(abyte2).getInt();
        abyte0 = new byte[j];
        abyte2 = new byte[abyte1.length - j];
        i = ((flag) ? 1 : 0);
        while (i < abyte1.length) 
        {
            if (i < j)
            {
                abyte0[i] = abyte1[i];
            } else
            {
                abyte2[i - j] = abyte1[i];
            }
            i++;
        }
        return new Pair(new String(abyte0), abyte2);
    }

    public void a(SdkLogRequest sdklogrequest, String s, String s1, String s2)
    {
        if (sdklogrequest == null || TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            gd.a(6, c, "Ad log that has to be sent is EMPTY or NULL");
        } else
        {
            try
            {
                sdklogrequest = b.a(sdklogrequest);
            }
            // Misplaced declaration of an exception variable
            catch (SdkLogRequest sdklogrequest)
            {
                gd.a(5, c, (new StringBuilder()).append("Failed to encode sdk log request: ").append(sdklogrequest).toString());
                sdklogrequest = null;
            }
            if (sdklogrequest != null)
            {
                b(a(((byte []) (sdklogrequest)), s), s1, s2);
                return;
            }
        }
    }

    protected void a(byte abyte0[], String s, String s1)
    {
        Pair pair;
        byte abyte1[];
        gk gk1;
        try
        {
            pair = a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            gd.a(6, c, "Internal ERROR! Report is corrupt!");
            c(s, s1);
            return;
        }
        abyte0 = (String)pair.first;
        abyte1 = (byte[])pair.second;
        gd.a(4, c, (new StringBuilder()).append("FlurryAdLogsManager: start upload data with id = ").append(s).append(" to ").append(abyte0).toString());
        gk1 = new gk();
        gk1.a(abyte0);
        gk1.a(0x186a0);
        gk1.a(gl.a.c);
        gk1.a("Content-Type", "application/x-flurry");
        gk1.a("Accept", "application/x-flurry");
        gk1.a("FM-Checksum", Integer.toString(gh.c(abyte1)));
        gk1.a(new gt());
        gk1.b(new gt());
        gk1.a(abyte1);
        gk1.a(new gk.a(s, s1) {

            final String a;
            final String b;
            final cf c;

            public volatile void a(gk gk2, Object obj)
            {
                a(gk2, (byte[])obj);
            }

            public void a(gk gk2, byte abyte2[])
            {
                int i = gk2.e();
                if (!gk2.c() || abyte2 == null) goto _L2; else goto _L1
_L1:
                gk2 = (SdkLogResponse)cf.a(c).d(abyte2);
_L4:
                if (gk2 != null && ((SdkLogResponse) (gk2)).result.equals("success"))
                {
                    gd.a(5, cf.b(c), (new StringBuilder()).append("FlurryAdLogsManager: ad report ").append(a).append(" sent. HTTP response: ").append(i).toString());
                    if (gd.c() <= 3 && gd.d())
                    {
                        fp.a().a(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                Toast.makeText(fp.a().c(), "Ad log report sent", 0).show();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }
                    cf.a(c, a, b, i);
                    cf.c(c);
                    return;
                }
                break; /* Loop/switch isn't completed */
                gk2;
                gd.a(5, cf.a(), (new StringBuilder()).append("Failed to decode sdk log response: ").append(gk2).toString());
_L2:
                gk2 = null;
                if (true) goto _L4; else goto _L3
_L3:
                if (gk2 != null)
                {
                    for (gk2 = ((SdkLogResponse) (gk2)).errors.iterator(); gk2.hasNext(); gd.a(6, cf.d(c), abyte2))
                    {
                        abyte2 = (String)gk2.next();
                    }

                }
                cf.a(c, a, b);
                return;
            }

            
            {
                c = cf.this;
                a = s;
                b = s1;
                super();
            }
        });
        fn.a().a(this, gk1);
    }

    protected byte[] a(byte abyte0[], String s)
    {
        s = s.getBytes();
        int i = s.length;
        byte abyte1[] = ByteBuffer.allocate(4).putInt(i).array();
        byte abyte2[] = new byte[abyte1.length + s.length + abyte0.length];
        i = 0;
        while (i < abyte2.length) 
        {
            if (i < abyte1.length)
            {
                abyte2[i] = abyte1[i];
            } else
            if (i >= abyte1.length && i < s.length + abyte1.length)
            {
                abyte2[i] = s[i - 4];
            } else
            {
                abyte2[i] = abyte0[i - 4 - s.length];
            }
            i++;
        }
        return abyte2;
    }

}
