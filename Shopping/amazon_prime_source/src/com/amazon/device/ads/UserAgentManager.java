// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

interface UserAgentManager
{

    public abstract String getUserAgentString();

    public abstract void populateUserAgentString(Context context);

    public abstract void setUserAgentString(String s);
}
