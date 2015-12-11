// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            a, q, s

public abstract class c extends a
{

    public c()
    {
    }

    private String a(q q1)
    {
        if (q1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$NotificationType = new int[q.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.AddToCartSuccess.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.AccountSessionAction.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.BarcodeScan.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.ErrorReceived.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.Launch.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.ExternalDeepLink.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.GeofenceChange.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.RefineSort.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.TargetWidget.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.SaveGiftCardToAccount.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.VlcPositionUpdate.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.ExitLink.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationType[q.ShareProduct.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.NotificationType[q1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "event:productEvent";

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return "event:contentEvent";

        case 12: // '\f'
            return "event:exitLink";

        case 13: // '\r'
            return "event:productEvent";
        }
    }

    protected String a()
    {
        return a(i());
    }

    protected s c()
    {
        return s.Unknown;
    }

    protected abstract q i();
}
