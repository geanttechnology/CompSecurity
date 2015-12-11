// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;

public class it extends j
{

    public static final it KB = new it();

    private it()
    {
        super("driveId", Arrays.asList(new String[] {
            "sqlId", "resourceId"
        }), Arrays.asList(new String[] {
            "dbInstanceId"
        }), 0x3e8fa0);
    }

}
