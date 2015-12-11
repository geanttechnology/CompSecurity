// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcelable;
import com.target.mothership.common.tender.PaymentTender;

// Referenced classes of package com.target.ui.model.checkout:
//            BillingCardDetailsModel

public interface PaymentCardInformationModel
    extends Parcelable
{

    public abstract BillingCardDetailsModel a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract PaymentTender d();
}
