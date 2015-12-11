// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting;

import android.os.Parcel;
import android.os.Parcelable;
import com.gimbal.proguard.Keep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting:
//            e

public class Sighting
    implements Parcelable, Keep, Cloneable
{

    static final SimpleDateFormat timeFormatter;
    private e sightingInternal;

    public Sighting()
    {
        sightingInternal = new e();
    }

    protected Object clone()
    {
        Sighting sighting = new Sighting();
        sighting.setPayload(sightingInternal.a);
        sighting.setRssi(sightingInternal.b);
        sighting.setDate(sightingInternal.c);
        sighting.setServiceId(sightingInternal.d);
        sighting.setTimezone(sightingInternal.e);
        sighting.setLatitude(sightingInternal.f);
        sighting.setLongitude(sightingInternal.g);
        sighting.setAccuracy(sightingInternal.h);
        sighting.setFix_time(sightingInternal.i);
        sighting.setVersion(sightingInternal.k);
        sighting.setSequenceNumber(sightingInternal.j);
        sighting.setTemperature(Integer.valueOf(sightingInternal.l).intValue());
        sighting.setBatteryLevel(Integer.valueOf(sightingInternal.m).intValue());
        sighting.setGen4MaskedData(sightingInternal.p);
        sighting.setGen4PacketVersion(sightingInternal.o);
        sighting.setPacketFormat(sightingInternal.n);
        return sighting;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Sighting)obj;
        if (sightingInternal != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Sighting) (obj)).sightingInternal == null) goto _L1; else goto _L3
_L3:
        return false;
        if (sightingInternal.equals(((Sighting) (obj)).sightingInternal)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getAccuracy()
    {
        return sightingInternal.h;
    }

    public int getBatteryLevel()
    {
        return Integer.valueOf(sightingInternal.m).intValue();
    }

    public String getFix_time()
    {
        return sightingInternal.i;
    }

    public String getGen4MaskedData()
    {
        return sightingInternal.p;
    }

    public String getGen4PacketVersion()
    {
        return sightingInternal.o;
    }

    public String getLatitude()
    {
        return sightingInternal.f;
    }

    public String getLongitude()
    {
        return sightingInternal.g;
    }

    public Byte getPacketFormat()
    {
        return sightingInternal.n;
    }

    public String getPayload()
    {
        return sightingInternal.a;
    }

    public int getRssi()
    {
        return sightingInternal.b;
    }

    public Long getSequenceNumber()
    {
        return sightingInternal.j;
    }

    public String getServiceId()
    {
        return sightingInternal.d;
    }

    public int getTemperature()
    {
        return Integer.valueOf(sightingInternal.l).intValue();
    }

    public String getTime()
    {
        if (giveDate() == null)
        {
            return null;
        } else
        {
            return timeFormatter.format(giveDate());
        }
    }

    public String getTimezone()
    {
        return sightingInternal.e;
    }

    public Byte getVersion()
    {
        return sightingInternal.k;
    }

    public Date giveDate()
    {
        return sightingInternal.c;
    }

    public int hashCode()
    {
        int i;
        if (sightingInternal == null)
        {
            i = 0;
        } else
        {
            i = sightingInternal.hashCode();
        }
        return i + 31;
    }

    public void setAccuracy(String s)
    {
        sightingInternal.h = s;
    }

    public void setBatteryLevel(int i)
    {
        sightingInternal.m = Integer.valueOf(i).intValue();
    }

    public void setDate(Date date)
    {
        sightingInternal.c = date;
    }

    public void setFix_time(String s)
    {
        sightingInternal.i = s;
    }

    public void setGen4MaskedData(String s)
    {
        sightingInternal.p = s;
    }

    public void setGen4PacketVersion(String s)
    {
        sightingInternal.o = s;
    }

    public void setLatitude(String s)
    {
        sightingInternal.f = s;
    }

    public void setLongitude(String s)
    {
        sightingInternal.g = s;
    }

    public void setPacketFormat(Byte byte1)
    {
        sightingInternal.n = byte1;
    }

    public void setPayload(String s)
    {
        sightingInternal.a = s;
    }

    public void setRssi(int i)
    {
        sightingInternal.b = i;
    }

    public void setSequenceNumber(Long long1)
    {
        sightingInternal.j = long1;
    }

    public void setServiceId(String s)
    {
        sightingInternal.d = s;
    }

    public void setTemperature(int i)
    {
        sightingInternal.l = Integer.valueOf(i).intValue();
    }

    public void setTime()
    {
        throw new RuntimeException("Can't de-serialize Sighting yet");
    }

    public void setTimezone(String s)
    {
        sightingInternal.e = s;
    }

    public void setVersion(Byte byte1)
    {
        sightingInternal.k = byte1;
    }

    public String toString()
    {
        return String.format("Sighting [payload=%s, rssi=%s, service_id=%s, time=%s, timezone=%s, latitude=%s, longitude=%s, accuracy=%s, fix_time=%s, version=%d, sequenceNumber=%d, temperature=%d, batteryLevel=%s, gen4MaskedData=%s, get4PacketVersion=%s]", new Object[] {
            sightingInternal.a, Integer.valueOf(sightingInternal.b), sightingInternal.d, sightingInternal.c, sightingInternal.e, sightingInternal.f, sightingInternal.g, sightingInternal.h, sightingInternal.i, sightingInternal.k, 
            sightingInternal.j, Integer.valueOf(sightingInternal.l), Integer.valueOf(sightingInternal.m), sightingInternal.p, sightingInternal.o
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(sightingInternal.a);
        parcel.writeInt(sightingInternal.b);
        parcel.writeSerializable(sightingInternal.c);
        parcel.writeString(sightingInternal.d);
        parcel.writeString(sightingInternal.e);
        parcel.writeString(sightingInternal.f);
        parcel.writeString(sightingInternal.g);
        parcel.writeString(sightingInternal.h);
        parcel.writeString(sightingInternal.i);
        parcel.writeByte(sightingInternal.k.byteValue());
        parcel.writeLong(sightingInternal.j.longValue());
        parcel.writeInt(Integer.valueOf(sightingInternal.l).intValue());
        parcel.writeInt(Integer.valueOf(sightingInternal.m).intValue());
        parcel.writeString(sightingInternal.p);
        parcel.writeString(sightingInternal.o);
        parcel.writeByte(sightingInternal.n.byteValue());
    }

    static 
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeFormatter = simpledateformat;
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
