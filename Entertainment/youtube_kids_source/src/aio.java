// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aio
{

    private ail a;

    aio(ail ail1)
    {
        a = ail1;
        super();
    }

    public final void onMdxStateChangedEvent(amk amk1)
    {
        Object obj = a;
        switch (aim.a[amk1.a.ordinal()])
        {
        default:
            obj = a.j;
            amk1 = String.valueOf(amk1.a);
            (new StringBuilder(String.valueOf(amk1).length() + 23)).append("Resuming scan in state ").append(amk1);
            a.l = false;
            ail.a(a);
            return;

        case 1: // '\001'
        case 2: // '\002'
            obj = a.j;
            break;
        }
        amk1 = String.valueOf(amk1.a);
        (new StringBuilder(String.valueOf(amk1).length() + 22)).append("Pausing scan in state ").append(amk1);
        a.l = true;
        ail.a(a);
    }

    public final void onMdxVolumeChangedEvent(amp amp1)
    {
        a.m = amp1.a;
        a.b();
    }
}
