// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dh;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            b

public class CastDevice
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    String kA;
    private Inet4Address kB;
    private String kC;
    private String kD;
    private String kE;
    private int kF;
    private List kG;
    private final int kg;
    private String kz;

    private CastDevice()
    {
        this(1, null, null, null, null, null, -1, ((List) (new ArrayList())));
    }

    CastDevice(int i, String s, String s1, String s2, String s3, String s4, int j, 
            List list)
    {
        kg = i;
        kz = s;
        kA = s1;
        if (kA != null)
        {
            try
            {
                s = InetAddress.getByName(kA);
                if (s instanceof Inet4Address)
                {
                    kB = (Inet4Address)s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                kB = null;
            }
        }
        kC = s2;
        kD = s3;
        kE = s4;
        kF = j;
        kG = list;
    }

    public static CastDevice getFromBundle(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        } else
        {
            bundle.setClassLoader(com/google/android/gms/cast/CastDevice.getClassLoader());
            return (CastDevice)bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof CastDevice))
        {
            return false;
        }
        obj = (CastDevice)obj;
        if (getDeviceId() != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CastDevice) (obj)).getDeviceId() == null) goto _L1; else goto _L3
_L3:
        return false;
        if (dh.a(kz, ((CastDevice) (obj)).kz) && dh.a(kB, ((CastDevice) (obj)).kB) && dh.a(kD, ((CastDevice) (obj)).kD) && dh.a(kC, ((CastDevice) (obj)).kC) && dh.a(kE, ((CastDevice) (obj)).kE) && kF == ((CastDevice) (obj)).kF && dh.a(kG, ((CastDevice) (obj)).kG)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getDeviceId()
    {
        return kz;
    }

    public String getDeviceVersion()
    {
        return kE;
    }

    public String getFriendlyName()
    {
        return kC;
    }

    public WebImage getIcon(int i, int j)
    {
        WebImage webimage = null;
        if (kG.isEmpty())
        {
            return null;
        }
        if (i <= 0 || j <= 0)
        {
            return (WebImage)kG.get(0);
        }
        Iterator iterator = kG.iterator();
        WebImage webimage1 = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WebImage webimage2 = (WebImage)iterator.next();
            int k = webimage2.getWidth();
            int l = webimage2.getHeight();
            if (k >= i && l >= j)
            {
                if (webimage1 == null || webimage1.getWidth() > k && webimage1.getHeight() > l)
                {
                    webimage1 = webimage2;
                }
            } else
            if (k < i && l < j && (webimage == null || webimage.getWidth() < k && webimage.getHeight() < l))
            {
                webimage = webimage2;
            }
        } while (true);
        if (webimage1 == null)
        {
            if (webimage != null)
            {
                webimage1 = webimage;
            } else
            {
                webimage1 = (WebImage)kG.get(0);
            }
        }
        return webimage1;
    }

    public List getIcons()
    {
        return Collections.unmodifiableList(kG);
    }

    public Inet4Address getIpAddress()
    {
        return kB;
    }

    public String getModelName()
    {
        return kD;
    }

    public int getServicePort()
    {
        return kF;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasIcons()
    {
        return !kG.isEmpty();
    }

    public int hashCode()
    {
        if (kz == null)
        {
            return 0;
        } else
        {
            return kz.hashCode();
        }
    }

    public boolean isSameDevice(CastDevice castdevice)
    {
        if (castdevice != null)
        {
            if (getDeviceId() == null)
            {
                if (castdevice.getDeviceId() == null)
                {
                    return true;
                }
            } else
            {
                return dh.a(getDeviceId(), castdevice.getDeviceId());
            }
        }
        return false;
    }

    public void putInBundle(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
            return;
        }
    }

    public String toString()
    {
        return String.format("\"%s\" (%s)", new Object[] {
            kC, kz
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b.a(this, parcel, i);
    }

}
