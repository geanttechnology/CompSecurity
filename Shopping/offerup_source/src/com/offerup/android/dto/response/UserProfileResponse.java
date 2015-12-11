// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.UserProfile;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class UserProfileResponse extends BaseResponse
{

    Data data;

    public UserProfileResponse()
    {
    }

    public UserProfile getUserProfile()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getUserProfile();
        }
    }

    private class Data
    {

        UserProfile profile;

        public UserProfile getUserProfile()
        {
            return profile;
        }

        public Data()
        {
        }
    }

}
