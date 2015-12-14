// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Build;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.Calendar;
import java.util.Locale;

public final class k
{

    private static String t[][] = {
        {
            "NVC_ASR_CMD", "NVC_DATA_UPLOAD_CMD", "NVC_LOG_REVISION_CMD", "NVC_RESET_USER_PROFILE_CMD", "NVC_APPSERVER_CMD", "NVC_GET_DICTATION_LANGUAGE", "NVC_TTS_CMD"
        }, {
            "DRAGON_NLU_ASR_CMD", "DRAGON_NLU_DATA_UPLOAD_CMD", "DRAGON_NLU_LOG_REVISION_CMD", "DRAGON_NLU_RESET_USER_PROFILE_CMD", "DRAGON_NLU_APPSERVER_CMD", "ACADIA_GET_DICTATION_LANGUAGE_V2", "DRAGON_NLU_TTS_CMD"
        }
    };
    private static int u = 0x19120623;
    private static int v = 0x18f8a016;
    private static int w = 0x5580f982;
    private final String a;
    private final String b;
    private final byte c[];
    private final String d;
    private final int e;
    private final boolean f;
    private final Object g;
    private final String h;
    private final b i;
    private String j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private com.nuance.nmdp.speechkit.SpeechKit.CmdSetType s;

    public k(Object obj, String s1, String s2, int i1, String s3, boolean flag, String s4, 
            byte abyte0[], com.nuance.nmdp.speechkit.SpeechKit.CmdSetType cmdsettype)
    {
        a = s4;
        b = s1;
        c = abyte0;
        d = s2;
        e = i1;
        f = flag;
        g = obj;
        j = null;
        k = false;
        i = new b(obj);
        h = i.c();
        l = s3;
        s = cmdsettype;
        b(s);
    }

    private void b(com.nuance.nmdp.speechkit.SpeechKit.CmdSetType cmdsettype)
    {
        m = t[cmdsettype.getIndex()][0];
        n = t[cmdsettype.getIndex()][1];
        o = t[cmdsettype.getIndex()][2];
        p = t[cmdsettype.getIndex()][3];
        q = t[cmdsettype.getIndex()][4];
        String as[][] = t;
        cmdsettype.getIndex();
        r = t[cmdsettype.getIndex()][6];
    }

    public static String n()
    {
        return aw.b();
    }

    public static String q()
    {
        return aw.a();
    }

    public final com.nuance.nmdp.speechkit.SpeechKit.CmdSetType A()
    {
        return s;
    }

    public final Object a()
    {
        return g;
    }

    public final void a(com.nuance.nmdp.speechkit.SpeechKit.CmdSetType cmdsettype)
    {
        s = cmdsettype;
        b(s);
    }

    public final byte[] a(byte abyte0[])
    {
        int ai2[] = new int[32];
        int[] _tmp = ai2;
        ai2[0] = 26;
        ai2[1] = 233;
        ai2[2] = 231;
        ai2[3] = 106;
        ai2[4] = 177;
        ai2[5] = 47;
        ai2[6] = 122;
        ai2[7] = 185;
        ai2[8] = 154;
        ai2[9] = 158;
        ai2[10] = 116;
        ai2[11] = 173;
        ai2[12] = 122;
        ai2[13] = 152;
        ai2[14] = 94;
        ai2[15] = 156;
        ai2[16] = 182;
        ai2[17] = 175;
        ai2[18] = 122;
        ai2[19] = 187;
        ai2[20] = 114;
        ai2[21] = 37;
        ai2[22] = 234;
        ai2[23] = 222;
        ai2[24] = 155;
        ai2[25] = 36;
        ai2[26] = 165;
        ai2[27] = 106;
        ai2[28] = 215;
        ai2[29] = 171;
        ai2[30] = 41;
        ai2[31] = 93;
        byte abyte1[] = new byte[96];
        b b1 = i;
        int i1 = Calendar.getInstance().get(13);
        b1 = i;
        int k1 = i1 + Calendar.getInstance().get(14) + 0x6ae7e91a;
        byte abyte2[] = i.f();
        byte abyte3[] = i.g();
        int ai[] = new int[abyte2.length];
        int ai1[] = new int[abyte3.length];
        for (i1 = 0; i1 < ai.length; i1++)
        {
            ai[i1] = abyte2[i1];
            if (ai[i1] < 0)
            {
                ai[i1] = ai[i1] + 256;
            }
        }

        for (i1 = 0; i1 < ai1.length; i1++)
        {
            ai1[i1] = abyte3[i1];
            if (ai1[i1] < 0)
            {
                ai1[i1] = ai1[i1] + 256;
            }
        }

        i1 = k1;
        long l1 = 0L;
        int j1 = 0;
        while (j1 < 32) 
        {
            i1 = (i1 * (u - v) + w) - u;
            if (ai != null)
            {
                if (j1 >= ai.length)
                {
                    ai = null;
                } else
                {
                    l1 = (l1 >> 8) + (long)(ai2[j1] + ai[j1] + (i1 & 0xff));
                }
            } else
            {
                l1 = i1;
            }
            abyte1[j1] = (byte)(int)l1;
            j1++;
        }
        l1 = 0L;
        j1 = i1;
        i1 = 0;
        ai = ai1;
        while (i1 < 64) 
        {
            j1 = (j1 * (u - v) + w) - u;
            if (ai != null)
            {
                if (i1 >= ai.length || i1 >= ai2.length)
                {
                    ai = null;
                } else
                {
                    l1 = (l1 >> 8) + (long)(ai2[i1] + ai[i1] + (j1 & 0xff));
                }
            } else
            {
                l1 = j1;
            }
            abyte1[i1 + 32] = (byte)(int)l1;
            i1++;
        }
        l1 = ((u - v) * j1 + w) - u;
        if (l1 == 0L)
        {
            l1 = 1L;
        } else
        {
            l1 &= 127L;
        }
        i1 = 0;
        while (i1 < abyte1.length) 
        {
            long l2;
            do
            {
                do
                {
                    l2 = ((l1 >> 6 ^ (l1 >> 1 ^ l1 ^ l1 >> 3)) & 1L) << 6 | l1 >> 1;
                    l1 = l2;
                } while (l2 > (long)abyte1.length);
                l1 = l2;
            } while (l2 < 0L);
            if (l2 > 26L)
            {
                abyte0[(int)l2 + 3] = abyte1[i1];
            } else
            {
                abyte0[(int)l2 - 1] = abyte1[i1];
            }
            i1++;
            l1 = l2;
        }
        abyte0[26] = (byte)(k1 & 0xff);
        abyte0[27] = (byte)(k1 >> 8 & 0xff);
        abyte0[28] = (byte)(k1 >> 16 & 0xff);
        abyte0[29] = (byte)(k1 >> 24 & 0xff);
        return abyte0;
    }

    public final String b()
    {
        return a;
    }

    public final byte[] c()
    {
        return c;
    }

    public final String d()
    {
        return d;
    }

    public final String e()
    {
        return b;
    }

    public final int f()
    {
        return e;
    }

    public final String g()
    {
        return l;
    }

    public final boolean h()
    {
        return f;
    }

    public final String i()
    {
        String s2 = i.a();
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "unknown";
        }
        return s1;
    }

    public final String j()
    {
        Object obj;
        obj = i;
        obj = Locale.getDefault();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((Locale) (obj)).toString();
        if (obj == null || ((String) (obj)).length() <= 0) goto _L2; else goto _L3
_L3:
        String s1 = ((String) (obj));
        if (obj == null)
        {
            s1 = "unknown";
        }
        return s1;
_L2:
        obj = null;
        if (true) goto _L3; else goto _L4
_L4:
    }

    public final String k()
    {
        Object obj = i;
        String s1 = Build.MODEL;
        obj = s1;
        if (s1 == null)
        {
            obj = "unknown";
        }
        return ((String) (obj));
    }

    public final String l()
    {
        Object obj = i;
        String s1 = android.os.Build.VERSION.RELEASE;
        obj = s1;
        if (s1 == null)
        {
            obj = "unknown";
        }
        return ((String) (obj));
    }

    public final String m()
    {
        Object obj;
        obj = i;
        obj = Locale.getDefault();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((Locale) (obj)).getCountry();
        if (obj == null || ((String) (obj)).length() <= 0) goto _L2; else goto _L3
_L3:
        String s1 = ((String) (obj));
        if (obj == null)
        {
            s1 = "unknown";
        }
        return s1;
_L2:
        obj = null;
        if (true) goto _L3; else goto _L4
_L4:
    }

    public final String o()
    {
        String s2 = i.b();
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "unknown";
        }
        return s1;
    }

    public final String p()
    {
        if (h == null)
        {
            return "unknown";
        } else
        {
            return h;
        }
    }

    public final bi r()
    {
        return i.e();
    }

    public final bi s()
    {
        return i.d();
    }

    public final String t()
    {
        if (!k)
        {
            k = true;
            try
            {
                String s1 = d;
                int i1 = e;
                j = cy.g();
            }
            catch (RuntimeException runtimeexception)
            {
                b b1 = i;
                j = null;
            }
        }
        return j;
    }

    public final String u()
    {
        return m;
    }

    public final String v()
    {
        return n;
    }

    public final String w()
    {
        return o;
    }

    public final String x()
    {
        return p;
    }

    public final String y()
    {
        return q;
    }

    public final String z()
    {
        return r;
    }

}
