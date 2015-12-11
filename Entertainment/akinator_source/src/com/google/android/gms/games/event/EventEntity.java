// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games.event:
//            Event, EventEntityCreator

public final class EventEntity
    implements SafeParcelable, Event
{

    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int mVersionCode;
    private final String zzaqZ;
    private final String zzatF;
    private final Uri zzatu;
    private final PlayerEntity zzaux;
    private final String zzavb;
    private final long zzavc;
    private final String zzavd;
    private final boolean zzave;

    EventEntity(int i, String s, String s1, String s2, Uri uri, String s3, Player player, 
            long l, String s4, boolean flag)
    {
        mVersionCode = i;
        zzavb = s;
        mName = s1;
        zzaqZ = s2;
        zzatu = uri;
        zzatF = s3;
        zzaux = new PlayerEntity(player);
        zzavc = l;
        zzavd = s4;
        zzave = flag;
    }

    public EventEntity(Event event)
    {
        mVersionCode = 1;
        zzavb = event.getEventId();
        mName = event.getName();
        zzaqZ = event.getDescription();
        zzatu = event.getIconImageUri();
        zzatF = event.getIconImageUrl();
        zzaux = (PlayerEntity)event.getPlayer().freeze();
        zzavc = event.getValue();
        zzavd = event.getFormattedValue();
        zzave = event.isVisible();
    }

    static int zza(Event event)
    {
        return zzw.hashCode(new Object[] {
            event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible())
        });
    }

    static boolean zza(Event event, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Event) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (event == obj) goto _L4; else goto _L3
_L3:
        obj = (Event)obj;
        if (!zzw.equal(((Event) (obj)).getEventId(), event.getEventId()) || !zzw.equal(((Event) (obj)).getName(), event.getName()) || !zzw.equal(((Event) (obj)).getDescription(), event.getDescription()) || !zzw.equal(((Event) (obj)).getIconImageUri(), event.getIconImageUri()) || !zzw.equal(((Event) (obj)).getIconImageUrl(), event.getIconImageUrl()) || !zzw.equal(((Event) (obj)).getPlayer(), event.getPlayer()) || !zzw.equal(Long.valueOf(((Event) (obj)).getValue()), Long.valueOf(event.getValue())) || !zzw.equal(((Event) (obj)).getFormattedValue(), event.getFormattedValue()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Boolean.valueOf(((Event) (obj)).isVisible()), Boolean.valueOf(event.isVisible()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Event event)
    {
        return zzw.zzv(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Event freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public String getEventId()
    {
        return zzavb;
    }

    public String getFormattedValue()
    {
        return zzavd;
    }

    public void getFormattedValue(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzavd, chararraybuffer);
    }

    public Uri getIconImageUri()
    {
        return zzatu;
    }

    public String getIconImageUrl()
    {
        return zzatF;
    }

    public String getName()
    {
        return mName;
    }

    public void getName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(mName, chararraybuffer);
    }

    public Player getPlayer()
    {
        return zzaux;
    }

    public long getValue()
    {
        return zzavc;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isVisible()
    {
        return zzave;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        EventEntityCreator.zza(this, parcel, i);
    }

}
