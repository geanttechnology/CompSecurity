// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager

public static interface 
{

    public abstract void onBeaconsError(Exception exception);

    public abstract void onBeaconsReceived(JSONObject jsonobject);
}
