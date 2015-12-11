// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.target.mothership.util:
//            g

static final class rfaces.Guest
    implements Guest
{

    public int describeContents()
    {
        return 0;
    }

    public String getAccessToken()
    {
        return "fake access token";
    }

    public e getAccountDetails()
    {
        return e.b(g.FAKE_ACCOUNT_DETAILS);
    }

    public Date getExpirationDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 30);
        return calendar.getTime();
    }

    public String getGuestId()
    {
        return "123345";
    }

    public String getRefreshToken()
    {
        return "fake refresh token";
    }

    public boolean isAnonymous()
    {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

    rfaces.Guest()
    {
    }
}
