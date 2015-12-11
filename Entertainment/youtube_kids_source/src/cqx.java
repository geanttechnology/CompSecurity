// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class cqx extends mt
{

    private final cok a;
    private final bmi b;

    public cqx(mx mx, cok cok1, bmi bmi1)
    {
        super(mx);
        a = (cok)b.a(cok1);
        b = (bmi)b.a(bmi1);
    }

    public final mb a(me me)
    {
        if (me instanceof cre)
        {
            Object obj = (cre)me;
            if (a.a())
            {
                bmo.d(((cre) (obj)).k());
            }
            long l = b.b();
            me = super.a(me);
            long l1 = b.b();
            if (a.a())
            {
                bmo.d(String.format(Locale.US, "Response for %s took %d ms and had status code %d", new Object[] {
                    ((cre) (obj)).a(), Long.valueOf(l1 - l), Integer.valueOf(((mb) (me)).a)
                }));
            }
            if (a.b())
            {
                bmo.d("Logging response for YouTube API call.");
                for (obj = ((cre) (obj)).b(me).iterator(); ((Iterator) (obj)).hasNext(); bmo.d((String)((Iterator) (obj)).next())) { }
            }
            return me;
        } else
        {
            return super.a(me);
        }
    }
}
