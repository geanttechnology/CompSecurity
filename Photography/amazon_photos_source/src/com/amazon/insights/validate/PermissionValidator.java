// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.validate;

import android.content.Context;
import com.amazon.insights.impl.InitializationException;

public class PermissionValidator
{

    private final String permission;

    public PermissionValidator(String s)
    {
        permission = s;
    }

    private boolean hasPermission(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public void validate(Context context)
    {
        if (!hasPermission(context, permission))
        {
            throw new InitializationException((new StringBuilder()).append(permission).append(" permission is not granted.").toString());
        } else
        {
            return;
        }
    }
}
