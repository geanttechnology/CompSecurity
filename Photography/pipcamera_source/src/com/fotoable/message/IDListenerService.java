// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.message;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

// Referenced classes of package com.fotoable.message:
//            RegistrationService

public class IDListenerService extends InstanceIDListenerService
{

    public IDListenerService()
    {
    }

    public void onTokenRefresh()
    {
        startService(new Intent(this, com/fotoable/message/RegistrationService));
    }
}
