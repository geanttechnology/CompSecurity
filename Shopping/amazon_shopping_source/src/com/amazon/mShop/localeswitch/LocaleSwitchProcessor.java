// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.content.Context;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchChain

public interface LocaleSwitchProcessor
{

    public abstract void doProcess(String s, Context context, LocaleSwitchChain localeswitchchain);
}
