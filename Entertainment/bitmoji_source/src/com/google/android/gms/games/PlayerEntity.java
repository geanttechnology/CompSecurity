// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;

// Referenced classes of package com.google.android.gms.games:
//            Player, c

public final class PlayerEntity extends fy
    implements Player
{
    static final class a extends c
    {

        public PlayerEntity ak(Parcel parcel)
        {
            if (PlayerEntity.b(PlayerEntity.fk()) || PlayerEntity.at(com/google/android/gms/games/PlayerEntity.getCanonicalName()))
            {
                return super.ak(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            Object obj = parcel.readString();
            Object obj1 = parcel.readString();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Uri.parse(((String) (obj1)));
            }
            return new PlayerEntity(4, s, s1, ((Uri) (obj)), ((Uri) (obj1)), parcel.readLong(), -1, -1L, null, null);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return ak(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final String FE;
    private final Uri FJ;
    private final Uri FK;
    private final String FU;
    private final String FV;
    private final String Gh;
    private final long Gi;
    private final int Gj;
    private final long Gk;
    private final int wj;

    PlayerEntity(int i, String s, String s1, Uri uri, Uri uri1, long l, 
            int j, long l1, String s2, String s3)
    {
        wj = i;
        Gh = s;
        FE = s1;
        FJ = uri;
        FU = s2;
        FK = uri1;
        FV = s3;
        Gi = l;
        Gj = j;
        Gk = l1;
    }

    public PlayerEntity(Player player)
    {
        wj = 4;
        Gh = player.getPlayerId();
        FE = player.getDisplayName();
        FJ = player.getIconImageUri();
        FU = player.getIconImageUrl();
        FK = player.getHiResImageUri();
        FV = player.getHiResImageUrl();
        Gi = player.getRetrievedTimestamp();
        Gj = player.fl();
        Gk = player.getLastPlayedWithTimestamp();
        ed.d(Gh);
        ed.d(FE);
        boolean flag;
        if (Gi > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ed.v(flag);
    }

    static int a(Player player)
    {
        return ep.hashCode(new Object[] {
            player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp())
        });
    }

    static boolean a(Player player, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Player) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (player == obj) goto _L4; else goto _L3
_L3:
        obj = (Player)obj;
        if (!ep.equal(((Player) (obj)).getPlayerId(), player.getPlayerId()) || !ep.equal(((Player) (obj)).getDisplayName(), player.getDisplayName()) || !ep.equal(((Player) (obj)).getIconImageUri(), player.getIconImageUri()) || !ep.equal(((Player) (obj)).getHiResImageUri(), player.getHiResImageUri()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(Long.valueOf(((Player) (obj)).getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean at(String s)
    {
        return ae(s);
    }

    static String b(Player player)
    {
        return ep.e(player).a("PlayerId", player.getPlayerId()).a("DisplayName", player.getDisplayName()).a("IconImageUri", player.getIconImageUri()).a("IconImageUrl", player.getIconImageUrl()).a("HiResImageUri", player.getHiResImageUri()).a("HiResImageUrl", player.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer fk()
    {
        return dY();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public int fl()
    {
        return Gj;
    }

    public Player freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getDisplayName()
    {
        return FE;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fm.b(FE, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return FK;
    }

    public String getHiResImageUrl()
    {
        return FV;
    }

    public Uri getIconImageUri()
    {
        return FJ;
    }

    public String getIconImageUrl()
    {
        return FU;
    }

    public long getLastPlayedWithTimestamp()
    {
        return Gk;
    }

    public String getPlayerId()
    {
        return Gh;
    }

    public long getRetrievedTimestamp()
    {
        return Gi;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public boolean hasHiResImage()
    {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage()
    {
        return getIconImageUri() != null;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return b(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Object obj = null;
        if (!dZ())
        {
            c.a(this, parcel, i);
            return;
        }
        parcel.writeString(Gh);
        parcel.writeString(FE);
        String s;
        if (FJ == null)
        {
            s = null;
        } else
        {
            s = FJ.toString();
        }
        parcel.writeString(s);
        if (FK == null)
        {
            s = obj;
        } else
        {
            s = FK.toString();
        }
        parcel.writeString(s);
        parcel.writeLong(Gi);
    }

}
