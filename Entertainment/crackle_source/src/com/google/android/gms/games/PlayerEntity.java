// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

// Referenced classes of package com.google.android.gms.games:
//            Player, c

public final class PlayerEntity extends fm
    implements Player
{
    static final class a extends c
    {

        public PlayerEntity Z(Parcel parcel)
        {
            Uri uri = null;
            if (PlayerEntity.b(PlayerEntity.da()) || PlayerEntity.ad(com/google/android/gms/games/PlayerEntity.getCanonicalName()))
            {
                return super.Z(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            Object obj = parcel.readString();
            String s2 = parcel.readString();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            if (s2 != null)
            {
                uri = Uri.parse(s2);
            }
            return new PlayerEntity(3, s, s1, ((Uri) (obj)), uri, parcel.readLong(), -1, -1L);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return Z(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final int kg;
    private final String qa;
    private final Uri sL;
    private final Uri sM;
    private final String tC;
    private final long tD;
    private final int tE;
    private final long tF;

    PlayerEntity(int i, String s, String s1, Uri uri, Uri uri1, long l, 
            int j, long l1)
    {
        kg = i;
        tC = s;
        qa = s1;
        sL = uri;
        sM = uri1;
        tD = l;
        tE = j;
        tF = l1;
    }

    public PlayerEntity(Player player)
    {
        kg = 3;
        tC = player.getPlayerId();
        qa = player.getDisplayName();
        sL = player.getIconImageUri();
        sM = player.getHiResImageUri();
        tD = player.getRetrievedTimestamp();
        tE = player.db();
        tF = player.getLastPlayedWithTimestamp();
        ds.d(tC);
        ds.d(qa);
        boolean flag;
        if (tD > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ds.p(flag);
    }

    static int a(Player player)
    {
        return ee.hashCode(new Object[] {
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
        if (!ee.equal(((Player) (obj)).getPlayerId(), player.getPlayerId()) || !ee.equal(((Player) (obj)).getDisplayName(), player.getDisplayName()) || !ee.equal(((Player) (obj)).getIconImageUri(), player.getIconImageUri()) || !ee.equal(((Player) (obj)).getHiResImageUri(), player.getHiResImageUri()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(Long.valueOf(((Player) (obj)).getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean ad(String s)
    {
        return P(s);
    }

    static String b(Player player)
    {
        return ee.e(player).a("PlayerId", player.getPlayerId()).a("DisplayName", player.getDisplayName()).a("IconImageUri", player.getIconImageUri()).a("HiResImageUri", player.getHiResImageUri()).a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer da()
    {
        return bM();
    }

    public int db()
    {
        return tE;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
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
        return qa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fc.b(qa, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return sM;
    }

    public Uri getIconImageUri()
    {
        return sL;
    }

    public long getLastPlayedWithTimestamp()
    {
        return tF;
    }

    public String getPlayerId()
    {
        return tC;
    }

    public long getRetrievedTimestamp()
    {
        return tD;
    }

    public int getVersionCode()
    {
        return kg;
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
        if (!bN())
        {
            c.a(this, parcel, i);
            return;
        }
        parcel.writeString(tC);
        parcel.writeString(qa);
        String s;
        if (sL == null)
        {
            s = null;
        } else
        {
            s = sL.toString();
        }
        parcel.writeString(s);
        if (sM == null)
        {
            s = obj;
        } else
        {
            s = sM.toString();
        }
        parcel.writeString(s);
        parcel.writeLong(tD);
    }

}
