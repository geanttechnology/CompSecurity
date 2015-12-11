// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Map;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

static interface 
{

    public abstract void onCancel();

    public abstract void onError(Throwable throwable);

    public abstract void onSuccess(Map map);
}
