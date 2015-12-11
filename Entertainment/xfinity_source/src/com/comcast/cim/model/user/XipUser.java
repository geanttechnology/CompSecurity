// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import com.comcast.cim.android.authentication.UserCredentials;

// Referenced classes of package com.comcast.cim.model.user:
//            User, AuthKeys

public class XipUser
    implements User
{

    private AuthKeys authKeys;
    private String greetingName;
    private String userName;

    public XipUser()
    {
    }

    public XipUser(UserCredentials usercredentials, AuthKeys authkeys)
    {
        userName = usercredentials.getUsername();
        greetingName = authkeys.getGreetingName();
        authKeys = authkeys;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (XipUser)obj;
            if (getUserKey() == null ? ((XipUser) (obj)).getUserKey() != null : !getUserKey().equals(((XipUser) (obj)).getUserKey()))
            {
                return false;
            }
        }
        return true;
    }

    public AuthKeys getAuthKeys()
    {
        return authKeys;
    }

    public String getGreetingName()
    {
        return greetingName;
    }

    public String getOmnitureTrackingKey()
    {
        if (authKeys == null)
        {
            return null;
        } else
        {
            return authKeys.getOmnitureTrackingKey();
        }
    }

    public String getUserKey()
    {
        return userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public int hashCode()
    {
        if (getUserKey() != null)
        {
            return getUserKey().hashCode();
        } else
        {
            return 0;
        }
    }

    public void setAuthKeys(AuthKeys authkeys)
    {
        authKeys = authkeys;
        userName = authkeys.getGreetingName();
    }
}
