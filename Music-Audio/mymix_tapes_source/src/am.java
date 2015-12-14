// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class am extends af
{

    private final String e;
    private com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence f;

    public am(df df, k k1, String s, boolean flag, boolean flag1, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence, 
            ba ba, ba ba1, ba ba2, ba ba3, bf bf, ac ac, aa aa)
    {
        super(df, k1, flag, flag1, s1, ba, ba1, ba2, ba3, bf, ac, aa);
        e = s;
        f = sequence;
    }

    protected final void a(cv cv1)
    {
        super.a(cv1);
        cv1.b("dictation_language", b);
        cv1.b("dictation_type", e);
    }

    protected final void j()
        throws l
    {
        cv cv1 = g();
        cv1.b("start", 0);
        cv1.b("end", 0);
        cv1.b("text", "");
        if (f != null)
        {
            cv1.a("grammar_list", b.a(this, (new r(f)).b()));
        }
        cv1.b("binary_results", 1);
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
