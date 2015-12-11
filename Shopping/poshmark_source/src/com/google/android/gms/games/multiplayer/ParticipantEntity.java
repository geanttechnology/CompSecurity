// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, c, ParticipantResult

public final class ParticipantEntity extends fy
    implements Participant
{
    static final class a extends c
    {

        public ParticipantEntity ao(Parcel parcel)
        {
            boolean flag = true;
            if (ParticipantEntity.b(ParticipantEntity.fk()) || ParticipantEntity.at(com/google/android/gms/games/multiplayer/ParticipantEntity.getCanonicalName()))
            {
                return super.ao(parcel);
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
            return new ParticipantEntity(3, s, s1, ((Uri) (obj)), ((Uri) (obj1)), i, s2, flag1, parcel, 7, null, null, null);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return ao(parcel);
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
    private final String GZ;
    private final boolean JA;
    private final PlayerEntity JB;
    private final int JC;
    private final ParticipantResult JD;
    private final int Jy;
    private final String Jz;
    private final int wj;

    ParticipantEntity(int i, String s, String s1, Uri uri, Uri uri1, int j, String s2, 
            boolean flag, PlayerEntity playerentity, int k, ParticipantResult participantresult, String s3, String s4)
    {
        wj = i;
        GZ = s;
        FE = s1;
        FJ = uri;
        FK = uri1;
        Jy = j;
        Jz = s2;
        JA = flag;
        JB = playerentity;
        JC = k;
        JD = participantresult;
        FU = s3;
        FV = s4;
    }

    public ParticipantEntity(Participant participant)
    {
        wj = 3;
        GZ = participant.getParticipantId();
        FE = participant.getDisplayName();
        FJ = participant.getIconImageUri();
        FK = participant.getHiResImageUri();
        Jy = participant.getStatus();
        Jz = participant.ge();
        JA = participant.isConnectedToRoom();
        Object obj = participant.getPlayer();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new PlayerEntity(((Player) (obj)));
        }
        JB = ((PlayerEntity) (obj));
        JC = participant.getCapabilities();
        JD = participant.getResult();
        FU = participant.getIconImageUrl();
        FV = participant.getHiResImageUrl();
    }

    static int a(Participant participant)
    {
        return ep.hashCode(new Object[] {
            participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.ge(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult()
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
        if (!ep.equal(((Participant) (obj)).getPlayer(), participant.getPlayer()) || !ep.equal(Integer.valueOf(((Participant) (obj)).getStatus()), Integer.valueOf(participant.getStatus())) || !ep.equal(((Participant) (obj)).ge(), participant.ge()) || !ep.equal(Boolean.valueOf(((Participant) (obj)).isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) || !ep.equal(((Participant) (obj)).getDisplayName(), participant.getDisplayName()) || !ep.equal(((Participant) (obj)).getIconImageUri(), participant.getIconImageUri()) || !ep.equal(((Participant) (obj)).getHiResImageUri(), participant.getHiResImageUri()) || !ep.equal(Integer.valueOf(((Participant) (obj)).getCapabilities()), Integer.valueOf(participant.getCapabilities())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(((Participant) (obj)).getResult(), participant.getResult())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean at(String s)
    {
        return ae(s);
    }

    static String b(Participant participant)
    {
        return ep.e(participant).a("Player", participant.getPlayer()).a("Status", Integer.valueOf(participant.getStatus())).a("ClientAddress", participant.ge()).a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).a("DisplayName", participant.getDisplayName()).a("IconImage", participant.getIconImageUri()).a("IconImageUrl", participant.getIconImageUrl()).a("HiResImage", participant.getHiResImageUri()).a("HiResImageUrl", participant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(participant.getCapabilities())).a("Result", participant.getResult()).toString();
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

    public Participant freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String ge()
    {
        return Jz;
    }

    public int getCapabilities()
    {
        return JC;
    }

    public String getDisplayName()
    {
        if (JB == null)
        {
            return FE;
        } else
        {
            return JB.getDisplayName();
        }
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (JB == null)
        {
            fm.b(FE, chararraybuffer);
            return;
        } else
        {
            JB.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getHiResImageUri()
    {
        if (JB == null)
        {
            return FK;
        } else
        {
            return JB.getHiResImageUri();
        }
    }

    public String getHiResImageUrl()
    {
        if (JB == null)
        {
            return FV;
        } else
        {
            return JB.getHiResImageUrl();
        }
    }

    public Uri getIconImageUri()
    {
        if (JB == null)
        {
            return FJ;
        } else
        {
            return JB.getIconImageUri();
        }
    }

    public String getIconImageUrl()
    {
        if (JB == null)
        {
            return FU;
        } else
        {
            return JB.getIconImageUrl();
        }
    }

    public String getParticipantId()
    {
        return GZ;
    }

    public Player getPlayer()
    {
        return JB;
    }

    public ParticipantResult getResult()
    {
        return JD;
    }

    public int getStatus()
    {
        return Jy;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isConnectedToRoom()
    {
        return JA;
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
        if (!dZ())
        {
            c.a(this, parcel, i);
        } else
        {
            parcel.writeString(GZ);
            parcel.writeString(FE);
            String s;
            int j;
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
            parcel.writeInt(Jy);
            parcel.writeString(Jz);
            if (JA)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            if (JB == null)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 1;
            }
            parcel.writeInt(j);
            if (JB != null)
            {
                JB.writeToParcel(parcel, i);
                return;
            }
        }
    }

}
