// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.user;

import com.comcast.cim.android.authentication.UserCredentials;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.XipUser;
import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayNowUser extends XipUser
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/user/PlayNowUser);
    private Boolean isGrandfatheredForCellularUse;

    public PlayNowUser()
    {
        isGrandfatheredForCellularUse = null;
    }

    public PlayNowUser(UserCredentials usercredentials, AuthKeys authkeys)
    {
        super(usercredentials, authkeys);
        isGrandfatheredForCellularUse = null;
    }

    private boolean doFlagsMatchMask(String s, long l)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "0";
        }
        try
        {
            l = (new BigInteger(s1.replace("-", ""), 16)).and(BigInteger.valueOf(l)).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LOG.error("Problem with Grandfathering", s);
            return false;
        }
        return l > 0L;
    }

    public boolean isGrandfatheredForCellularUse()
    {
        if (isGrandfatheredForCellularUse == null)
        {
            isGrandfatheredForCellularUse = Boolean.valueOf(false);
            isGrandfatheredForCellularUse = Boolean.valueOf(doFlagsMatchMask(getAuthKeys().getFlags(), 0x800000040000080L));
        }
        return isGrandfatheredForCellularUse.booleanValue();
    }

}
