// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.framework.IPCCommand;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication

public static class 
    implements IPCCommand
{

    public static Bundle parametersToBundle$4fbc83d1(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("directedId", s);
        bundle.putString("key", s1);
        bundle.putBundle("options", null);
        return bundle;
    }

    public ()
    {
    }
}
