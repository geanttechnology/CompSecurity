// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            kz, adl, abo

static class 
    implements kz
{

    private static int b(int i)
    {
        switch (i)
        {
        case 6: // '\006'
        default:
            return 3;

        case 5: // '\005'
            return 2;

        case 3: // '\003'
        case 4: // '\004'
            return 1;

        case 2: // '\002'
            return 0;
        }
    }

    public int a()
    {
        return b(abo.a());
    }

    public void a(int i)
    {
        abo.b("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public void a(String s)
    {
        abo.b(s);
    }

    public void b(String s)
    {
        abo.a(s);
    }

    ()
    {
    }
}
