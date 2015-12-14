// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.device;

import android.content.Context;
import android.os.Build;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.upload.AbstractDeviceAttributeStore;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import java.util.UUID;

public class AospDeviceAttributeStore extends AbstractDeviceAttributeStore
{

    public AospDeviceAttributeStore(Context context)
    {
        super(context);
        deviceName = Build.MODEL;
    }

    public void clearCachedDeviceInformation()
    {
    }

    public String getCachedDeviceId()
    {
        String s1 = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        String s = s1;
        if (s1 == null)
        {
            s = getUniqueDeviceId();
        }
        return s;
    }

    public String getDefaultDeviceName()
    {
        return deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public String getDeviceSerialNumber()
    {
        return getCachedDeviceId();
    }

    public String getDeviceTypeId()
    {
        return "A2PGLM6YI9EXDZ";
    }

    public String getUniqueDeviceId()
    {
        AospPreferences aosppreferences = new AospPreferences(appContext);
        String s1 = aosppreferences.getDeviceUUID();
        String s = s1;
        if (s1.isEmpty())
        {
            s = UUID.randomUUID().toString();
            aosppreferences.setDeviceUUID(s);
        }
        return s;
    }

    public void storeDeviceId(String s)
    {
    }
}
