// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class an extends af
{

    private com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary e;
    private String f;

    public an(df df, k k1, String s, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, bf bf, ac ac, 
            aa aa)
    {
        super(df, k1, false, false, s, null, null, null, null, bf, ac, aa);
        e = dictionary;
        f = s1;
    }

    protected final void a(cv cv1)
    {
        super.a(cv1);
        cv1.b("dictation_language", b);
        if (f != null)
        {
            cv1.b("application_session_id", f);
        }
    }

    protected final void j()
        throws l
    {
        cv cv1 = g();
        cv1.a("appserver_data", b.a(this, (new r(e)).a()));
        b.a(this, (new StringBuilder()).append("REQUEST_INFO: ").append(cv1).toString());
        a("REQUEST_INFO", cv1);
    }

    protected final String k()
    {
        return d.y();
    }

    protected final String l()
    {
        return "AUDIO_INFO";
    }

    protected final boolean m()
    {
        return false;
    }
}
