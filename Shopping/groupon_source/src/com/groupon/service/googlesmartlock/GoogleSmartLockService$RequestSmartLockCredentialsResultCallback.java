// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.googlesmartlock;

import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.groupon.service.googlesmartlock:
//            GoogleSmartLockService

private class <init>
    implements ResultCallback
{

    final GoogleSmartLockService this$0;

    public void onResult(CredentialRequestResult credentialrequestresult)
    {
        if (GoogleSmartLockService.access$200(GoogleSmartLockService.this) != null)
        {
            if (credentialrequestresult.getStatus().isSuccess() && credentialrequestresult.getCredential() != null)
            {
                GoogleSmartLockService.access$200(GoogleSmartLockService.this).lsRetrieved(credentialrequestresult.getCredential());
                return;
            }
            if (credentialrequestresult.getStatus().getStatusCode() == 6)
            {
                if (!GoogleSmartLockService.access$300(GoogleSmartLockService.this) && GoogleSmartLockService.access$400(GoogleSmartLockService.this) != null)
                {
                    try
                    {
                        credentialrequestresult.getStatus().startResolutionForResult(GoogleSmartLockService.access$400(GoogleSmartLockService.this), 10153);
                        GoogleSmartLockService.access$200(GoogleSmartLockService.this).lResolutionRequired();
                        GoogleSmartLockService.access$302(GoogleSmartLockService.this, true);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (CredentialRequestResult credentialrequestresult)
                    {
                        GoogleSmartLockService.access$200(GoogleSmartLockService.this).lsRetrieveFailed();
                    }
                    return;
                }
            } else
            {
                GoogleSmartLockService.access$200(GoogleSmartLockService.this).lsRetrieveFailed();
                return;
            }
        }
    }

    public volatile void onResult(Result result)
    {
        onResult((CredentialRequestResult)result);
    }

    private ()
    {
        this$0 = GoogleSmartLockService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
