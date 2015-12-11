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

    public static String getResult(Bundle bundle)
    {
        return bundle.getString("value");
    }

    public ()
    {
    }
}
