// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.googlesmartlock;

import com.google.android.gms.auth.api.credentials.Credential;

// Referenced classes of package com.groupon.service.googlesmartlock:
//            GoogleSmartLockService

public static interface 
{

    public abstract void onCredentialResolutionRequired();

    public abstract void onCredentialsRetrieveFailed();

    public abstract void onCredentialsRetrieved(Credential credential);
}
