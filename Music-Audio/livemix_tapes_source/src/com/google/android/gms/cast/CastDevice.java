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
    private String zzTn;
    String zzTo;
    private Inet4Address zzTp;
    private String zzTq;
    private String zzTr;
    private String zzTs;
    private int zzTt;
    private List zzTu;
    private int zzTv;
    private int zzxJ;

    private CastDevice()
    {
        this(3, null, null, null, null, null, -1, ((List) (new ArrayList())), 0, -1);
    }

    CastDevice(int i, String s, String s1, String s2, String s3, String s4, int j, 
            List list, int k, int l)
    {
        mVersionCode = i;
        zzTn = s;
        zzTo = s1;
        if (zzTo != null)
        {
            try
            {
                s = InetAddress.getByName(zzTo);
                if (s instanceof Inet4Address)
                {
                    zzTp = (Inet4Address)s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                zzTp = null;
            }
        }
        zzTq = s2;
        zzTr = s3;
        zzTs = s4;
        zzTt = j;
        zzTu = list;
        zzTv = k;
        zzxJ = l;
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
        if (zzf.zza(zzTn, ((CastDevice) (obj)).zzTn) && zzf.zza(zzTp, ((CastDevice) (obj)).zzTp) && zzf.zza(zzTr, ((CastDevice) (obj)).zzTr) && zzf.zza(zzTq, ((CastDevice) (obj)).zzTq) && zzf.zza(zzTs, ((CastDevice) (obj)).zzTs) && zzTt == ((CastDevice) (obj)).zzTt && zzf.zza(zzTu, ((CastDevice) (obj)).zzTu) && zzTv == ((CastDevice) (obj)).zzTv && zzxJ == ((CastDevice) (obj)).zzxJ) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getCapabilities()
    {
        return zzTv;
    }

    public String getDeviceId()
    {
        return zzTn;
    }

    public String getDeviceVersion()
    {
        return zzTs;
    }

    public String getFriendlyName()
    {
        return zzTq;
    }

    public WebImage getIcon(int i, int j)
    {
        WebImage webimage = null;
        if (zzTu.isEmpty())
        {
            return null;
        }
        if (i <= 0 || j <= 0)
        {
            return (WebImage)zzTu.get(0);
        }
        Iterator iterator = zzTu.iterator();
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
                webimage1 = (WebImage)zzTu.get(0);
            }
        }
        return webimage1;
    }

    public List getIcons()
    {
        return Collections.unmodifiableList(zzTu);
    }

    public Inet4Address getIpAddress()
    {
        return zzTp;
    }

    public String getModelName()
    {
        return zzTr;
    }

    public int getServicePort()
    {
        return zzTt;
    }

    public int getStatus()
    {
        return zzxJ;
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
        return (zzTv & i) == i;
    }

    public boolean hasIcons()
    {
        return !zzTu.isEmpty();
    }

    public int hashCode()
    {
        if (zzTn == null)
        {
            return 0;
        } else
        {
            return zzTn.hashCode();
        }
    }

    public boolean isOnLocalNetwork()
    {
        return !zzTn.startsWith("__cast_nearby__");
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
            zzTq, zzTn
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
