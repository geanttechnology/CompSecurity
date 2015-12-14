// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication

public static class 
    implements IPCCommand
{

    public static Bundle parametersToBundle(RegistrationType registrationtype, Bundle bundle, Tracer tracer)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("regType", registrationtype.getName());
        bundle1.putBundle("regData", bundle);
        tracer.addToBundle(bundle1);
        return bundle1;
    }

    public ()
    {
    }
}
