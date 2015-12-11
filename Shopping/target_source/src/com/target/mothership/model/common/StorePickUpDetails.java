// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcelable;
import com.target.mothership.common.store.StoreIdentifier;

// Referenced classes of package com.target.mothership.model.common:
//            PickUpPersonDetails

public interface StorePickUpDetails
    extends Parcelable
{

    public abstract StoreIdentifier a();

    public abstract String b();

    public abstract PickUpPersonDetails c();
}
