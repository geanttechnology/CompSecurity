// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.b;

import java.util.List;

// Referenced classes of package com.target.mothership.services.e.h.b:
//            a, c

public class j
{

    private a mAddress;
    private List mCapabilities;
    private boolean mHasRequestTeamMember;
    private String mId;
    private c mLocation;
    private String mShortName;

    public j()
    {
    }

    public String a()
    {
        return mId;
    }

    public String b()
    {
        return mShortName;
    }

    public c c()
    {
        return mLocation;
    }

    public a d()
    {
        return mAddress;
    }

    public Boolean e()
    {
        return Boolean.valueOf(mHasRequestTeamMember);
    }
}
