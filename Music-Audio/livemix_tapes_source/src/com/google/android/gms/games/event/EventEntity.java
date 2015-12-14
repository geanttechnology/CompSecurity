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
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games.event:
//            Event, EventEntityCreator

public final class EventEntity
    implements SafeParcelable, Event
{

    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int mVersionCode;
    private final String zzaoB;
    private final Uri zzaqW;
    private final PlayerEntity zzarZ;
    private final String zzarh;
    private final String zzasD;
    private final long zzasE;
    private final String zzasF;
    private final boolean zzasG;

    EventEntity(int i, String s, String s1, String s2, Uri uri, String s3, Player player, 
            long l, String s4, boolean flag)
    {
        mVersionCode = i;
        zzasD = s;
        mName = s1;
        zzaoB = s2;
        zzaqW = uri;
        zzarh = s3;
        zzarZ = new PlayerEntity(player);
        zzasE = l;
        zzasF = s4;
        zzasG = flag;
    }

    public EventEntity(Event event)
    {
        mVersionCode = 1;
        zzasD = event.getEventId();
        mName = event.getName();
        zzaoB = event.getDescription();
        zzaqW = event.getIconImageUri();
        zzarh = event.getIconImageUrl();
        zzarZ = (PlayerEntity)event.getPlayer().freeze();
        zzasE = event.getValue();
        zzasF = event.getFormattedValue();
        zzasG = event.isVisible();
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
        return zzw.zzu(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
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
        return zzaoB;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaoB, chararraybuffer);
    }

    public String getEventId()
    {
        return zzasD;
    }

    public String getFormattedValue()
    {
        return zzasF;
    }

    public void getFormattedValue(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzasF, chararraybuffer);
    }

    public Uri getIconImageUri()
    {
        return zzaqW;
    }

    public String getIconImageUrl()
    {
        return zzarh;
    }

    public String getName()
    {
        return mName;
    }

    public void getName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(mName, chararraybuffer);
    }

    public Player getPlayer()
    {
        return zzarZ;
    }

    public long getValue()
    {
        return zzasE;
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
        return zzasG;
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
