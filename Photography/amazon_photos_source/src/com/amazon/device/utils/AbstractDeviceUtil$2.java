// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.SharedPreferences;
import android.util.Log;
import java.security.SecureRandom;

// Referenced classes of package com.amazon.device.utils:
//            AbstractDeviceUtil

class this._cls0
    implements Runnable
{

    final AbstractDeviceUtil this$0;

    public void run()
    {
        String s = mSharedPrefs.getString("clickstreamSessionID", null);
        Object obj = s;
        if (s == null)
        {
            obj = new SecureRandom();
            obj = String.format("%s-%s-%s", new Object[] {
                AbstractDeviceUtil.access$000(AbstractDeviceUtil.this, 3, ((SecureRandom) (obj))), AbstractDeviceUtil.access$000(AbstractDeviceUtil.this, 7, ((SecureRandom) (obj))), AbstractDeviceUtil.access$000(AbstractDeviceUtil.this, 7, ((SecureRandom) (obj)))
            });
            android.content.tor tor = mSharedPrefs.edit();
            tor.putString("clickstreamSessionID", ((String) (obj)));
            tor.commit();
            Log.d("AbstractDeviceUtil", (new StringBuilder()).append("Generated a new SessionID").append(((String) (obj))).toString());
        }
        AbstractDeviceUtil.access$202(AbstractDeviceUtil.this, ((String) (obj)));
    }

    ()
    {
        this$0 = AbstractDeviceUtil.this;
        super();
    }
}
