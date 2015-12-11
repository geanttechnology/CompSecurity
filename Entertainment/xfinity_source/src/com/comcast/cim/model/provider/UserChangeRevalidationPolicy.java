// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.provider;

import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.UserManager;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserChangeRevalidationPolicy
    implements RevalidationPolicy
{

    private UserManager userManager;

    public UserChangeRevalidationPolicy(UserManager usermanager)
    {
        userManager = usermanager;
    }

    public User getCurrentVersion()
    {
        User user1 = userManager.getUser();
        User user = user1;
        if (user1 == null)
        {
            user = null;
        }
        return user;
    }

    public volatile Object getCurrentVersion()
    {
        return getCurrentVersion();
    }

    public boolean shouldFallBackToLastCached(User user)
    {
        return !shouldRevalidate(user);
    }

    public volatile boolean shouldFallBackToLastCached(Object obj)
    {
        return shouldFallBackToLastCached((User)obj);
    }

    public boolean shouldRevalidate(User user)
    {
        return user == null || !user.equals(getCurrentVersion());
    }

    public volatile boolean shouldRevalidate(Object obj)
    {
        return shouldRevalidate((User)obj);
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("currentVersion", getCurrentVersion()).toString();
    }
}
