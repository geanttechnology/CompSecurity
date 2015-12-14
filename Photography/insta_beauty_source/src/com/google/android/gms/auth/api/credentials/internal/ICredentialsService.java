// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            ICredentialsCallbacks, DeleteRequest, SaveRequest

public interface ICredentialsService
    extends IInterface
{

    public abstract void performCredentialsDeleteOperation(ICredentialsCallbacks icredentialscallbacks, DeleteRequest deleterequest);

    public abstract void performCredentialsRequestOperation(ICredentialsCallbacks icredentialscallbacks, CredentialRequest credentialrequest);

    public abstract void performCredentialsSaveOperation(ICredentialsCallbacks icredentialscallbacks, SaveRequest saverequest);

    public abstract void performDisableAutoSignInOperation(ICredentialsCallbacks icredentialscallbacks);
}
