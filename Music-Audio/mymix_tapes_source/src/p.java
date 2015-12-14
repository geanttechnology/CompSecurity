// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.Iterator;
import java.util.List;

public class p extends j
{

    private final List e;
    private final bf f;
    private final String g;

    public p(df df, k k1, String s1, List list, bf bf, h h)
    {
        super(df, k1, h);
        e = list;
        f = bf;
        g = s1;
        a = new s(this);
    }

    protected void a(cv cv1)
    {
        super.a(cv1);
        cv1.b("dictation_language", "eng-USA");
    }

    protected final void i()
        throws l
    {
        Iterator iterator;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        iterator = e.iterator();
_L10:
        String s1;
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj = (q)iterator.next();
        s1 = ((q) (obj)).a();
        obj = ((q) (obj)).b();
        ((r) (obj)).f();
        JVM INSTR tableswitch 0 7: default 96
    //                   0 131
    //                   1 122
    //                   2 143
    //                   3 159
    //                   4 96
    //                   5 168
    //                   6 184
    //                   7 200;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_200;
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L11:
        b.a(this, (new StringBuilder()).append("Send custom param ").append(s1).toString());
        if (true) goto _L10; else goto _L9
_L9:
        b.c(this, "INT is an unsupported param type");
          goto _L11
_L2:
        a(s1, ((r) (obj)).c());
          goto _L11
_L4:
        a(s1, b.a(this, ((r) (obj)).a()));
          goto _L11
_L5:
        b.c(this, "SEQ is an unsupported param type");
          goto _L11
_L6:
        b(s1, b.a(this, ((r) (obj)).a()));
          goto _L11
_L7:
        c(s1, b.a(this, ((r) (obj)).a()));
          goto _L11
        d(s1, b.a(this, ((r) (obj)).a()));
          goto _L11
    }

    final String j()
    {
        return g;
    }

    final bf k()
    {
        return f;
    }
}
