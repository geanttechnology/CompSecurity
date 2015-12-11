// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store;

import android.location.Location;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.h;
import java.util.List;

public interface a
{

    public abstract void a(StoreIdentifier storeidentifier, h h);

    public abstract void a(GuestBase guestbase, double d, double d1, int i, h h);

    public abstract void a(GuestBase guestbase, Location location, int i, h h);

    public abstract void a(GuestBase guestbase, Location location, h h);

    public abstract void a(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1);

    public abstract void a(GuestBase guestbase, StoreIdentifier storeidentifier, h h);

    public abstract void a(GuestBase guestbase, StoreIdentifier storeidentifier, boolean flag, com.target.mothership.cache.i.a a1);

    public abstract void a(GuestBase guestbase, h h);

    public abstract void a(GuestBase guestbase, List list, h h);

    public abstract void a(String s, int i, int j, h h);

    public abstract void b(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1);
}
