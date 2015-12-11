// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk;

import android.content.Context;

// Referenced classes of package com.supersonicads.sdk:
//            SSAAdvertiser

public interface SSAAdvertiserTest
    extends SSAAdvertiser
{

    public abstract void clearReportApp(Context context);

    public abstract void setDomain(String s, String s1, int i);

    public abstract void setPackageName(String s);

    public abstract void setTimeAPI(String s);
}
