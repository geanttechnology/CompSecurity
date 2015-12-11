// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            zzb

public class CastDevice
    implements SafeParcelable
{

    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private String zzVd;
    String zzVe;
    private Inet4Address zzVf;
    private String zzVg;
    private String zzVh;
    private String zzVi;
    private int zzVj;
    private List zzVk;
    private int zzVl;
    private int zzys;

    private CastDevice()
    {
        this(3, null, null, null, null, null, -1, ((List) (new ArrayList())), 0, -1);
    }

    CastDevice(int i, String s, String s1, String s2, String s3, String s4, int j, 
            List list, int k, int l)
    {
        mVersionCode = i;
        zzVd = s;
        zzVe = s1;
        if (zzVe != null)
        {
            try
            {
                s = InetAddress.getByName(zzVe);
                if (s instanceof Inet4Address)
                {
                    zzVf = (Inet4Address)s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                zzVf = null;
            }
        }
        zzVg = s2;
        zzVh = s3;
        zzVi = s4;
        zzVj = j;
        zzVk = list;
        zzVl = k;
        zzys = l;
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
        if (zzf.zza(zzVd, ((CastDevice) (obj)).zzVd) && zzf.zza(zzVf, ((CastDevice) (obj)).zzVf) && zzf.zza(zzVh, ((CastDevice) (obj)).zzVh) && zzf.zza(zzVg, ((CastDevice) (obj)).zzVg) && zzf.zza(zzVi, ((CastDevice) (obj)).zzVi) && zzVj == ((CastDevice) (obj)).zzVj && zzf.zza(zzVk, ((CastDevice) (obj)).zzVk) && zzVl == ((CastDevice) (obj)).zzVl && zzys == ((CastDevice) (obj)).zzys) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getCapabilities()
    {
        return zzVl;
    }

    public String getDeviceId()
    {
        return zzVd;
    }

    public String getDeviceVersion()
    {
        return zzVi;
    }

    public String getFriendlyName()
    {
        return zzVg;
    }

    public WebImage getIcon(int i, int j)
    {
        WebImage webimage = null;
        if (zzVk.isEmpty())
        {
            return null;
        }
        if (i <= 0 || j <= 0)
        {
            return (WebImage)zzVk.get(0);
        }
        Iterator iterator = zzVk.iterator();
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
                webimage1 = (WebImage)zzVk.get(0);
            }
        }
        return webimage1;
    }

    public List getIcons()
    {
        return Collections.unmodifiableList(zzVk);
    }

    public Inet4Address getIpAddress()
    {
        return zzVf;
    }

    public String getModelName()
    {
        return zzVh;
    }

    public int getServicePort()
    {
        return zzVj;
    }

    public int getStatus()
    {
        return zzys;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasCapabilities(int ai[])
    {
        if (ai != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = ai.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (!hasCapability(ai[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public boolean hasCapability(int i)
    {
        return (zzVl & i) == i;
    }

    public boolean hasIcons()
    {
        return !zzVk.isEmpty();
    }

    public int hashCode()
    {
        if (zzVd == null)
        {
            return 0;
        } else
        {
            return zzVd.hashCode();
        }
    }

    public boolean isOnLocalNetwork()
    {
        return !zzVd.startsWith("__cast_nearby__");
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
                return zzf.zza(getDeviceId(), castdevice.getDeviceId());
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
            zzVg, zzVd
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
