// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import java.util.Map;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager

public static interface 
{

    public abstract void onError(Exception exception);

    public abstract void onTagsReceived(Map map);
}
