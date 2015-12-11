// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service.provider;

import android.content.Context;

// Referenced classes of package com.target.ui.service.provider:
//            s

public class DefaultStringResourceProvider
    implements s
{

    private Context mContext;

    public DefaultStringResourceProvider(Context context)
    {
        mContext = context.getApplicationContext();
    }

    public String a(int i)
    {
        return mContext.getString(i);
    }

    public transient String a(int i, Object aobj[])
    {
        return mContext.getString(i, aobj);
    }
}
