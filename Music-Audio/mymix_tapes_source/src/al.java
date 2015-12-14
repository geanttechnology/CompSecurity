// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class al extends af
{

    private final String e;
    private com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary f;
    private String g;

    public al(df df, k k1, String s, boolean flag, boolean flag1, String s1, String s2, 
            com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, ba ba, ba ba1, ba ba2, ba ba3, bf bf, ac ac, 
            aa aa)
    {
        super(df, k1, flag, flag1, s1, ba, ba1, ba2, ba3, bf, ac, aa);
        e = s;
        f = dictionary;
        g = s2;
    }

    protected final void a(cv cv1)
    {
        super.a(cv1);
        cv1.b("dictation_language", b);
        cv1.b("dictation_type", e);
        if (g != null)
        {
            cv1.b("application_session_id", g);
        }
    }

    protected final void j()
        throws l
    {
        cv cv1 = g();
        cv1.b("start", 0);
        cv1.b("end", 0);
        cv1.b("text", "");
        cv1.a("appserver_data", b.a(this, (new r(f)).a()));
        b.a(this, (new StringBuilder()).append("REQUEST_INFO: ").append(cv1).toString());
        a("REQUEST_INFO", cv1);
    }

    protected final String k()
    {
        return d.u();
    }

    protected final String l()
    {
        return "AUDIO_INFO";
    }

    protected final boolean m()
    {
        return true;
    }
}
