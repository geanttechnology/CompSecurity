// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import com.google.a.a.e;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.mothership.model.common:
//            GuestAddress

public interface PaymentCardTender
    extends PaymentTender
{

    public abstract GuestAddress c();

    public abstract a d();

    public abstract String e();

    public abstract e f();

    public abstract boolean g();
}
