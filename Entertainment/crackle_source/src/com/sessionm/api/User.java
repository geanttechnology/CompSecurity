// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api;

import android.content.Context;
import java.util.List;

public interface User
{

    public abstract List getAchievements();

    public abstract int getPointBalance();

    public abstract int getUnclaimedAchievementCount();

    public abstract int getUnclaimedAchievementValue();

    public abstract Object getValueForKey(String s);

    public abstract boolean isOptedOut();

    public abstract void setOptedOut(Context context, boolean flag);
}
