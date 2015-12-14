// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class DeviceUuidFactory
{

    protected static final String PREFS_DEVICE_ID = "device_id";
    protected static final String PREFS_FILE = "device_id.xml";
    protected static UUID uuid;

    public DeviceUuidFactory(Context context)
    {
        if (uuid != null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        com/fotoable/ad/DeviceUuidFactory;
        JVM INSTR monitorenter ;
        if (uuid != null) goto _L2; else goto _L1
_L1:
        SharedPreferences sharedpreferences;
        String s;
        sharedpreferences = context.getSharedPreferences("device_id.xml", 0);
        s = sharedpreferences.getString("device_id", null);
        if (s == null) goto _L4; else goto _L3
_L3:
        uuid = UUID.fromString(s);
_L2:
        com/fotoable/ad/DeviceUuidFactory;
        JVM INSTR monitorexit ;
        return;
_L4:
        s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        uuid = UUID.nameUUIDFromBytes(s.getBytes("utf8"));
_L6:
        sharedpreferences.edit().putString("device_id", uuid.toString()).commit();
        if (true) goto _L2; else goto _L5
        context;
        com/fotoable/ad/DeviceUuidFactory;
        JVM INSTR monitorexit ;
        throw context;
_L5:
        context = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        context = UUID.nameUUIDFromBytes(context.getBytes("utf8"));
_L7:
        uuid = context;
          goto _L6
        context;
        throw new RuntimeException(context);
        context = UUID.randomUUID();
          goto _L7
    }

    public UUID getDeviceUuid()
    {
        return uuid;
    }
}
