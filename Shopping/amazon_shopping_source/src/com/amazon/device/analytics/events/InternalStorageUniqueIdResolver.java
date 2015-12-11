// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONSerializable;

// Referenced classes of package com.amazon.device.analytics.events:
//            UniqueIdResolverChain, UniqueIdResolver

public class InternalStorageUniqueIdResolver extends UniqueIdResolverChain
    implements JSONSerializable
{

    protected static final String PREFS_NAME = com/amazon/device/analytics/events/InternalStorageUniqueIdResolver.getName();
    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/InternalStorageUniqueIdResolver);
    private final SharedPreferences sharedPreferences;

    public InternalStorageUniqueIdResolver(Context context, UniqueIdResolver uniqueidresolver)
    {
        super(uniqueidresolver);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public String tryResolve()
    {
        if (sharedPreferences == null)
        {
            logger.w("SharedPreferences is null");
            return null;
        }
        String s;
        try
        {
            s = sharedPreferences.getString("UniqueId", null);
        }
        catch (Exception exception)
        {
            logger.e("There was an exception when trying to retrieve the unique id from the SharedPreferences", exception);
            return null;
        }
        return s;
    }

    public boolean tryStore(String s)
    {
        if (sharedPreferences == null)
        {
            logger.w("sharedPreferences is null");
            return false;
        }
        boolean flag;
        try
        {
            android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("UniqueId", s);
            flag = editor.commit();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("There was an exception when trying to store the unique id into the SharedPreferences", s);
            return false;
        }
        return flag;
    }

}
