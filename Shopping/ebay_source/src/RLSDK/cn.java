// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cw, ag, ck, co, 
//            ce, cf, cg, ch, 
//            ci, v

public abstract class cn
{

    protected final ag a;
    protected final cw b;

    cn(ag ag1)
    {
        a = ag1;
        b = new cw(ag1);
    }

    public static cn a(ag ag1)
    {
        if (ag1.a(1))
        {
            return new ck(ag1);
        }
        if (!ag1.a(2))
        {
            return new co(ag1);
        }
        switch (cw.a(ag1, 1, 4))
        {
        default:
            switch (cw.a(ag1, 1, 5))
            {
            default:
                switch (cw.a(ag1, 1, 7))
                {
                default:
                    throw new IllegalStateException((new StringBuilder("unknown decoder: ")).append(ag1).toString());

                case 56: // '8'
                    return new ci(ag1, "310", "11");

                case 57: // '9'
                    return new ci(ag1, "320", "11");

                case 58: // ':'
                    return new ci(ag1, "310", "13");

                case 59: // ';'
                    return new ci(ag1, "320", "13");

                case 60: // '<'
                    return new ci(ag1, "310", "15");

                case 61: // '='
                    return new ci(ag1, "320", "15");

                case 62: // '>'
                    return new ci(ag1, "310", "17");

                case 63: // '?'
                    return new ci(ag1, "320", "17");
                }

            case 12: // '\f'
                return new cg(ag1);

            case 13: // '\r'
                return new ch(ag1);
            }

        case 4: // '\004'
            return new ce(ag1);

        case 5: // '\005'
            return new cf(ag1);
        }
    }

    public abstract String a()
        throws v;
}
