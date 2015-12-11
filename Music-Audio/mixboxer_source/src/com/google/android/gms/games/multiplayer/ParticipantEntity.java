// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, c, ParticipantResult

public final class ParticipantEntity extends fm
    implements Participant
{
    static final class a extends c
    {

        public ParticipantEntity ab(Parcel parcel)
        {
            boolean flag = true;
            if (ParticipantEntity.b(ParticipantEntity.da()) || ParticipantEntity.ad(com/google/android/gms/games/multiplayer/ParticipantEntity.getCanonicalName()))
            {
                return super.ab(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            Object obj = parcel.readString();
            Object obj1;
            String s2;
            int i;
            boolean flag1;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            obj1 = parcel.readString();
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Uri.parse(((String) (obj1)));
            }
            i = parcel.readInt();
            s2 = parcel.readString();
            if (parcel.readInt() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (parcel.readInt() <= 0)
            {
                flag = false;
            }
            if (flag)
            {
                parcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            return new ParticipantEntity(2, s, s1, ((Uri) (obj)), ((Uri) (obj1)), i, s2, flag1, parcel, 7, null);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return ab(parcel);
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
    private final String up;
    private final int wr;
    private final String ws;
    private final boolean wt;
    private final PlayerEntity wu;
    private final int wv;
    private final ParticipantResult ww;

    ParticipantEntity(int i, String s, String s1, Uri uri, Uri uri1, int j, String s2, 
            boolean flag, PlayerEntity playerentity, int k, ParticipantResult participantresult)
    {
        kg = i;
        up = s;
        qa = s1;
        sL = uri;
        sM = uri1;
        wr = j;
        ws = s2;
        wt = flag;
        wu = playerentity;
        wv = k;
        ww = participantresult;
    }

    public ParticipantEntity(Participant participant)
    {
        kg = 2;
        up = participant.getParticipantId();
        qa = participant.getDisplayName();
        sL = participant.getIconImageUri();
        sM = participant.getHiResImageUri();
        wr = participant.getStatus();
        ws = participant.dy();
        wt = participant.isConnectedToRoom();
        Object obj = participant.getPlayer();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new PlayerEntity(((Player) (obj)));
        }
        wu = ((PlayerEntity) (obj));
        wv = participant.getCapabilities();
        ww = participant.getResult();
    }

    static int a(Participant participant)
    {
        return ee.hashCode(new Object[] {
            participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.dy(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult()
        });
    }

    static boolean a(Participant participant, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Participant) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (participant == obj) goto _L4; else goto _L3
_L3:
        obj = (Participant)obj;
        if (!ee.equal(((Participant) (obj)).getPlayer(), participant.getPlayer()) || !ee.equal(Integer.valueOf(((Participant) (obj)).getStatus()), Integer.valueOf(participant.getStatus())) || !ee.equal(((Participant) (obj)).dy(), participant.dy()) || !ee.equal(Boolean.valueOf(((Participant) (obj)).isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) || !ee.equal(((Participant) (obj)).getDisplayName(), participant.getDisplayName()) || !ee.equal(((Participant) (obj)).getIconImageUri(), participant.getIconImageUri()) || !ee.equal(((Participant) (obj)).getHiResImageUri(), participant.getHiResImageUri()) || !ee.equal(Integer.valueOf(((Participant) (obj)).getCapabilities()), Integer.valueOf(participant.getCapabilities())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(((Participant) (obj)).getResult(), participant.getResult())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean ad(String s)
    {
        return P(s);
    }

    static String b(Participant participant)
    {
        return ee.e(participant).a("Player", participant.getPlayer()).a("Status", Integer.valueOf(participant.getStatus())).a("ClientAddress", participant.dy()).a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).a("DisplayName", participant.getDisplayName()).a("IconImage", participant.getIconImageUri()).a("HiResImage", participant.getHiResImageUri()).a("Capabilities", Integer.valueOf(participant.getCapabilities())).a("Result", participant.getResult()).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer da()
    {
        return bM();
    }

    public int describeContents()
    {
        return 0;
    }

    public String dy()
    {
        return ws;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Participant freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public int getCapabilities()
    {
        return wv;
    }

    public String getDisplayName()
    {
        if (wu == null)
        {
            return qa;
        } else
        {
            return wu.getDisplayName();
        }
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (wu == null)
        {
            fc.b(qa, chararraybuffer);
            return;
        } else
        {
            wu.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getHiResImageUri()
    {
        if (wu == null)
        {
            return sM;
        } else
        {
            return wu.getHiResImageUri();
        }
    }

    public Uri getIconImageUri()
    {
        if (wu == null)
        {
            return sL;
        } else
        {
            return wu.getIconImageUri();
        }
    }

    public String getParticipantId()
    {
        return up;
    }

    public Player getPlayer()
    {
        return wu;
    }

    public ParticipantResult getResult()
    {
        return ww;
    }

    public int getStatus()
    {
        return wr;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isConnectedToRoom()
    {
        return wt;
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
        boolean flag = false;
        if (!bN())
        {
            c.a(this, parcel, i);
        } else
        {
            parcel.writeString(up);
            parcel.writeString(qa);
            String s;
            int j;
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
            parcel.writeInt(wr);
            parcel.writeString(ws);
            if (wt)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            if (wu == null)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 1;
            }
            parcel.writeInt(j);
            if (wu != null)
            {
                wu.writeToParcel(parcel, i);
                return;
            }
        }
    }

}
