// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Enumeration;

public class dw extends dt
{

    private static final bm a = d.a(dw);

    public dw(String s, String s1, String s2, String s3, String s4, String s5, bi bi1, 
            String s6, short word0, short word1, String s7, String s8, String s9, String s10, 
            byte abyte0[], String s11, String s12, cv cv1)
    {
        super((short)514);
        if (a.b())
        {
            a.b("PDXQueryBegin()");
        }
        a("uid", s, (short)193);
        a("pdx_version", s1, (short)193);
        a("client_version", s2, (short)193);
        a("script_version", s3, (short)193);
        a("language", s4, (short)193);
        a("region", s5, (short)193);
        a("device_codec", bi1.a());
        a("dictation_language", s6, (short)193);
        a("lcd_width", word0);
        a("lcd_height", word1);
        if (s7 == null)
        {
            a("carrier", new byte[0], (short)5);
        } else
        {
            a("carrier", s7, (short)193);
        }
        a("phone_model", s8, (short)193);
        a("phone_number", s9, (short)193);
        a("original_session_id", s10, (short)22);
        if (abyte0 != null)
        {
            a("new_session_id", dm.a(abyte0), (short)193);
        }
        a("application", s11, (short)22);
        a("nmaid", s11, (short)22);
        a("command", s12, (short)22);
        if (cv1 != null)
        {
            s = cv1.a();
            do
            {
                if (!s.hasMoreElements())
                {
                    break;
                }
                s1 = (String)s.nextElement();
                switch (((cq)cv1).b(s1).c())
                {
                case 4: // '\004'
                    a(s1, cv1.e(s1), (short)4);
                    break;

                case 22: // '\026'
                    a(s1, cv1.g(s1), (short)22);
                    break;

                case 192: 
                    a(s1, cv1.d(s1));
                    break;

                case 193: 
                    a(s1, cv1.f(s1), (short)193);
                    break;

                case 5: // '\005'
                    a(s1, null, (short)5);
                    break;

                case 224: 
                    a.e("PDXQueryBegin() Dictionary not accepted in optionalKeys");
                    break;

                case 16: // '\020'
                    a.e("PDXQueryBegin() Sequence not accepted in optionalKeys");
                    break;
                }
            } while (true);
        }
    }

}
