// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.util.Base64;
import com.amazon.identity.auth.device.storage.AbstractTokenEncryptor;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext, CommonInfoGetter

public class DCPOnlyTokenEncryptor extends AbstractTokenEncryptor
{

    private static final String TAG = com/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor.getName();
    private static byte sDcpOnlyEncryptionKey[];
    private final Context mContext;

    public DCPOnlyTokenEncryptor(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
    }

    protected byte[] getEncryptionKey()
    {
        this;
        JVM INSTR monitorenter ;
        if (sDcpOnlyEncryptionKey != null) goto _L2; else goto _L1
_L1:
        Object obj = CommonInfoGetter.getInstance(mContext).getTokenKey();
        if (obj != null) goto _L4; else goto _L3
_L3:
        MAPLog.e(TAG, "Could not generate a MAP only encryption key. Aborting.");
        obj = null;
_L6:
        sDcpOnlyEncryptionKey = ((byte []) (obj));
_L2:
        obj = sDcpOnlyEncryptionKey;
        this;
        JVM INSTR monitorexit ;
        return ((byte []) (obj));
_L4:
        obj = Base64.decode(((String) (obj)), 0);
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

}
