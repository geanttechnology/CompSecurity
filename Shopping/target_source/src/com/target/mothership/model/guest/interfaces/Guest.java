// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import com.google.a.a.e;
import java.util.Date;

// Referenced classes of package com.target.mothership.model.guest.interfaces:
//            GuestBase

public interface Guest
    extends GuestBase
{

    public abstract String getAccessToken();

    public abstract e getAccountDetails();

    public abstract Date getExpirationDate();

    public abstract String getGuestId();

    public abstract String getRefreshToken();

    public abstract boolean isAnonymous();
}
