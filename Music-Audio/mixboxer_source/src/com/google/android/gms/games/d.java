// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerEntity

public final class d extends b
    implements Player
{
    private static final class a
    {

        public final String tH;
        public final String tI;
        public final String tJ;
        public final String tK;
        public final String tL;
        public final String tM;
        public final String tN;

        public a(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                tH = "external_player_id";
                tI = "profile_name";
                tJ = "profile_icon_image_uri";
                tK = "profile_hi_res_image_uri";
                tL = "last_updated";
                tM = "is_in_circles";
                tN = "played_with_timestamp";
                return;
            } else
            {
                tH = (new StringBuilder()).append(s).append("external_player_id").toString();
                tI = (new StringBuilder()).append(s).append("profile_name").toString();
                tJ = (new StringBuilder()).append(s).append("profile_icon_image_uri").toString();
                tK = (new StringBuilder()).append(s).append("profile_hi_res_image_uri").toString();
                tL = (new StringBuilder()).append(s).append("last_updated").toString();
                tM = (new StringBuilder()).append(s).append("is_in_circles").toString();
                tN = (new StringBuilder()).append(s).append("played_with_timestamp").toString();
                return;
            }
        }
    }


    private final a tG;

    public d(DataHolder dataholder, int i)
    {
        this(dataholder, i, null);
    }

    public d(DataHolder dataholder, int i, String s)
    {
        super(dataholder, i);
        tG = new a(s);
    }

    public int db()
    {
        return getInteger(tG.tM);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return PlayerEntity.a(this, obj);
    }

    public Player freeze()
    {
        return new PlayerEntity(this);
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getDisplayName()
    {
        return getString(tG.tI);
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        a(tG.tI, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return L(tG.tK);
    }

    public Uri getIconImageUri()
    {
        return L(tG.tJ);
    }

    public long getLastPlayedWithTimestamp()
    {
        if (!hasColumn(tG.tN))
        {
            return -1L;
        } else
        {
            return getLong(tG.tN);
        }
    }

    public String getPlayerId()
    {
        return getString(tG.tH);
    }

    public long getRetrievedTimestamp()
    {
        return getLong(tG.tL);
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
        return PlayerEntity.a(this);
    }

    public String toString()
    {
        return com.google.android.gms.games.PlayerEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((PlayerEntity)freeze()).writeToParcel(parcel, i);
    }
}
