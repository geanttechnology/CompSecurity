// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcelable;
import com.target.mothership.common.params.AddressParams;

// Referenced classes of package com.target.ui.model.checkout:
//            CardDataModel

public interface BillingCardDetailsModel
    extends Parcelable
{

    public abstract CardDataModel a();

    public abstract AddressParams b();
}
