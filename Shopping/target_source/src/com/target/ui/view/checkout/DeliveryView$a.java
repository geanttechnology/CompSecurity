// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            DeliveryView

public static interface tailsModel
{

    public abstract void a(EmailRecipientDetailsModel emailrecipientdetailsmodel);

    public abstract void a(PickUpPersonDetailsModel pickuppersondetailsmodel);

    public abstract void a(SmsRecipientDetailsModel smsrecipientdetailsmodel);

    public abstract void a(List list);

    public abstract void b(List list);

    public abstract void j();

    public abstract void k();

    public abstract void o();
}
