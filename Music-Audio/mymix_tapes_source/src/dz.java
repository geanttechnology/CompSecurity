// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class dz extends dt
{

    private static final bm a = d.a(dz);

    public dz(dv dv1)
    {
        super((short)515);
        if (a.b())
        {
            a.b("PDXQueryParameter()");
        }
        a("name", dv1.b(), (short)193);
        if (dv1.c() == 127)
        {
            a("type", 5);
        } else
        {
            a("type", dv1.c());
        }
        switch (dv1.c())
        {
        default:
            a.e((new StringBuilder("PDXQueryParameter() Unknown parameter type: ")).append(dv1.c()).append(". ").toString());
            return;

        case 1: // '\001'
            a("buffer_id", ((dq)dv1).a());
            return;

        case 3: // '\003'
            a("text", null, (short)193);
            return;

        case 4: // '\004'
            a("data", null, (short)193);
            return;

        case 5: // '\005'
            a("dict", ((dr)dv1).a(), (short)224);
            return;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            a("dict", ((ec)dv1).a(), (short)224);
            return;

        case 2: // '\002'
            a("text", ((ee)dv1).a(), (short)193);
            return;

        case 127: // '\177'
            a("dict", ((ed)dv1).d(), (short)224);
            break;
        }
    }

}
