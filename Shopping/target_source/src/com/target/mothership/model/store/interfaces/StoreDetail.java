// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.interfaces;

import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store.interfaces:
//            Store

public interface StoreDetail
    extends Parcelable, Store
{

    public abstract String a();

    public abstract Address b();

    public abstract List c();

    public abstract List d();

    public abstract List e();

    public abstract List f();
}
