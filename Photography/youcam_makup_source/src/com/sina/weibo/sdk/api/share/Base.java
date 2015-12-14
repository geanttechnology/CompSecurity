// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.os.Bundle;

public abstract class Base
{

    public String transaction;

    public Base()
    {
    }

    public abstract void fromBundle(Bundle bundle);

    public abstract int getType();

    public abstract void toBundle(Bundle bundle);
}
