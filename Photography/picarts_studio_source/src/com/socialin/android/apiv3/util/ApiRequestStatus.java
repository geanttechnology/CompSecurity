// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;


public interface ApiRequestStatus
{

    public static final String REASON_USER_NOT_FOUND = "user_not_found";
    public static final int STATUS_COMPLETED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_INVALID = -1;
    public static final int STATUS_PROGRESS = 0;
}
