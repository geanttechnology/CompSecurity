// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatch, TurnBasedMatchEntityCreator

public final class TurnBasedMatchEntity
    implements SafeParcelable, TurnBasedMatch
{

    public static final android.os.Parcelable.Creator CREATOR = new TurnBasedMatchEntityCreator();
    private final int mVersion;
    private final int mVersionCode;
    private final String zzaoB;
    private final long zzasc;
    private final String zzatz;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final String zzayD;
    private final String zzayE;
    private final int zzayF;
    private final byte zzayG[];
    private final String zzayH;
    private final byte zzayI[];
    private final int zzayJ;
    private final int zzayK;
    private final boolean zzayL;
    private final String zzayM;
    private final ArrayList zzayc;
    private final int zzayd;
    private final Bundle zzayt;
    private final String zzayv;

    TurnBasedMatchEntity(int i, GameEntity gameentity, String s, String s1, long l, String s2, 
            long l1, String s3, int j, int k, int i1, byte abyte0[], 
            ArrayList arraylist, String s4, byte abyte1[], int j1, Bundle bundle, int k1, boolean flag, 
            String s5, String s6)
    {
        mVersionCode = i;
        zzaxY = gameentity;
        zzatz = s;
        zzayv = s1;
        zzaxZ = l;
        zzayD = s2;
        zzasc = l1;
        zzayE = s3;
        zzayF = j;
        zzayK = k1;
        zzayd = k;
        mVersion = i1;
        zzayG = abyte0;
        zzayc = arraylist;
        zzayH = s4;
        zzayI = abyte1;
        zzayJ = j1;
        zzayt = bundle;
        zzayL = flag;
        zzaoB = s5;
        zzayM = s6;
    }

    public TurnBasedMatchEntity(TurnBasedMatch turnbasedmatch)
    {
        mVersionCode = 2;
        zzaxY = new GameEntity(turnbasedmatch.getGame());
        zzatz = turnbasedmatch.getMatchId();
        zzayv = turnbasedmatch.getCreatorId();
        zzaxZ = turnbasedmatch.getCreationTimestamp();
        zzayD = turnbasedmatch.getLastUpdaterId();
        zzasc = turnbasedmatch.getLastUpdatedTimestamp();
        zzayE = turnbasedmatch.getPendingParticipantId();
        zzayF = turnbasedmatch.getStatus();
        zzayK = turnbasedmatch.getTurnStatus();
        zzayd = turnbasedmatch.getVariant();
        mVersion = turnbasedmatch.getVersion();
        zzayH = turnbasedmatch.getRematchId();
        zzayJ = turnbasedmatch.getMatchNumber();
        zzayt = turnbasedmatch.getAutoMatchCriteria();
        zzayL = turnbasedmatch.isLocallyModified();
        zzaoB = turnbasedmatch.getDescription();
        zzayM = turnbasedmatch.getDescriptionParticipantId();
        byte abyte0[] = turnbasedmatch.getData();
        int j;
        if (abyte0 == null)
        {
            zzayG = null;
        } else
        {
            zzayG = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, zzayG, 0, abyte0.length);
        }
        abyte0 = turnbasedmatch.getPreviousMatchData();
        if (abyte0 == null)
        {
            zzayI = null;
        } else
        {
            zzayI = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, zzayI, 0, abyte0.length);
        }
        turnbasedmatch = turnbasedmatch.getParticipants();
        j = turnbasedmatch.size();
        zzayc = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzayc.add((ParticipantEntity)(ParticipantEntity)((Participant)turnbasedmatch.get(i)).freeze());
        }

    }

    static int zza(TurnBasedMatch turnbasedmatch)
    {
        return zzw.hashCode(new Object[] {
            turnbasedmatch.getGame(), turnbasedmatch.getMatchId(), turnbasedmatch.getCreatorId(), Long.valueOf(turnbasedmatch.getCreationTimestamp()), turnbasedmatch.getLastUpdaterId(), Long.valueOf(turnbasedmatch.getLastUpdatedTimestamp()), turnbasedmatch.getPendingParticipantId(), Integer.valueOf(turnbasedmatch.getStatus()), Integer.valueOf(turnbasedmatch.getTurnStatus()), turnbasedmatch.getDescription(), 
            Integer.valueOf(turnbasedmatch.getVariant()), Integer.valueOf(turnbasedmatch.getVersion()), turnbasedmatch.getParticipants(), turnbasedmatch.getRematchId(), Integer.valueOf(turnbasedmatch.getMatchNumber()), turnbasedmatch.getAutoMatchCriteria(), Integer.valueOf(turnbasedmatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnbasedmatch.isLocallyModified())
        });
    }

    static int zza(TurnBasedMatch turnbasedmatch, String s)
    {
        ArrayList arraylist = turnbasedmatch.getParticipants();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                return participant.getStatus();
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("Participant ").append(s).append(" is not in match ").append(turnbasedmatch.getMatchId()).toString());
    }

    static boolean zza(TurnBasedMatch turnbasedmatch, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof TurnBasedMatch) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (turnbasedmatch == obj) goto _L4; else goto _L3
_L3:
        obj = (TurnBasedMatch)obj;
        if (!zzw.equal(((TurnBasedMatch) (obj)).getGame(), turnbasedmatch.getGame()) || !zzw.equal(((TurnBasedMatch) (obj)).getMatchId(), turnbasedmatch.getMatchId()) || !zzw.equal(((TurnBasedMatch) (obj)).getCreatorId(), turnbasedmatch.getCreatorId()) || !zzw.equal(Long.valueOf(((TurnBasedMatch) (obj)).getCreationTimestamp()), Long.valueOf(turnbasedmatch.getCreationTimestamp())) || !zzw.equal(((TurnBasedMatch) (obj)).getLastUpdaterId(), turnbasedmatch.getLastUpdaterId()) || !zzw.equal(Long.valueOf(((TurnBasedMatch) (obj)).getLastUpdatedTimestamp()), Long.valueOf(turnbasedmatch.getLastUpdatedTimestamp())) || !zzw.equal(((TurnBasedMatch) (obj)).getPendingParticipantId(), turnbasedmatch.getPendingParticipantId()) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getStatus()), Integer.valueOf(turnbasedmatch.getStatus())) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getTurnStatus()), Integer.valueOf(turnbasedmatch.getTurnStatus())) || !zzw.equal(((TurnBasedMatch) (obj)).getDescription(), turnbasedmatch.getDescription()) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getVariant()), Integer.valueOf(turnbasedmatch.getVariant())) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getVersion()), Integer.valueOf(turnbasedmatch.getVersion())) || !zzw.equal(((TurnBasedMatch) (obj)).getParticipants(), turnbasedmatch.getParticipants()) || !zzw.equal(((TurnBasedMatch) (obj)).getRematchId(), turnbasedmatch.getRematchId()) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getMatchNumber()), Integer.valueOf(turnbasedmatch.getMatchNumber())) || !zzw.equal(((TurnBasedMatch) (obj)).getAutoMatchCriteria(), turnbasedmatch.getAutoMatchCriteria()) || !zzw.equal(Integer.valueOf(((TurnBasedMatch) (obj)).getAvailableAutoMatchSlots()), Integer.valueOf(turnbasedmatch.getAvailableAutoMatchSlots())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Boolean.valueOf(((TurnBasedMatch) (obj)).isLocallyModified()), Boolean.valueOf(turnbasedmatch.isLocallyModified()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(TurnBasedMatch turnbasedmatch)
    {
        return zzw.zzu(turnbasedmatch).zzg("Game", turnbasedmatch.getGame()).zzg("MatchId", turnbasedmatch.getMatchId()).zzg("CreatorId", turnbasedmatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(turnbasedmatch.getCreationTimestamp())).zzg("LastUpdaterId", turnbasedmatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(turnbasedmatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", turnbasedmatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(turnbasedmatch.getStatus())).zzg("TurnStatus", Integer.valueOf(turnbasedmatch.getTurnStatus())).zzg("Description", turnbasedmatch.getDescription()).zzg("Variant", Integer.valueOf(turnbasedmatch.getVariant())).zzg("Data", turnbasedmatch.getData()).zzg("Version", Integer.valueOf(turnbasedmatch.getVersion())).zzg("Participants", turnbasedmatch.getParticipants()).zzg("RematchId", turnbasedmatch.getRematchId()).zzg("PreviousData", turnbasedmatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(turnbasedmatch.getMatchNumber())).zzg("AutoMatchCriteria", turnbasedmatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(turnbasedmatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(turnbasedmatch.isLocallyModified())).zzg("DescriptionParticipantId", turnbasedmatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnbasedmatch, String s)
    {
        turnbasedmatch = turnbasedmatch.getParticipants();
        int j = turnbasedmatch.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)turnbasedmatch.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(s))
            {
                return participant.getParticipantId();
            }
        }

        return null;
    }

    static Participant zzc(TurnBasedMatch turnbasedmatch, String s)
    {
        ArrayList arraylist = turnbasedmatch.getParticipants();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                return participant;
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("Participant ").append(s).append(" is not in match ").append(turnbasedmatch.getMatchId()).toString());
    }

    static ArrayList zzc(TurnBasedMatch turnbasedmatch)
    {
        turnbasedmatch = turnbasedmatch.getParticipants();
        int j = turnbasedmatch.size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(((Participant)turnbasedmatch.get(i)).getParticipantId());
        }

        return arraylist;
    }

    public boolean canRematch()
    {
        return zzayF == 2 && zzayH == null;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public TurnBasedMatch freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzayt;
    }

    public int getAvailableAutoMatchSlots()
    {
        if (zzayt == null)
        {
            return 0;
        } else
        {
            return zzayt.getInt("max_automatch_players");
        }
    }

    public long getCreationTimestamp()
    {
        return zzaxZ;
    }

    public String getCreatorId()
    {
        return zzayv;
    }

    public byte[] getData()
    {
        return zzayG;
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaoB, chararraybuffer);
    }

    public Participant getDescriptionParticipant()
    {
        String s = getDescriptionParticipantId();
        if (s == null)
        {
            return null;
        } else
        {
            return getParticipant(s);
        }
    }

    public String getDescriptionParticipantId()
    {
        return zzayM;
    }

    public Game getGame()
    {
        return zzaxY;
    }

    public long getLastUpdatedTimestamp()
    {
        return zzasc;
    }

    public String getLastUpdaterId()
    {
        return zzayD;
    }

    public String getMatchId()
    {
        return zzatz;
    }

    public int getMatchNumber()
    {
        return zzayJ;
    }

    public Participant getParticipant(String s)
    {
        return zzc(this, s);
    }

    public String getParticipantId(String s)
    {
        return zzb(this, s);
    }

    public ArrayList getParticipantIds()
    {
        return zzc(this);
    }

    public int getParticipantStatus(String s)
    {
        return zza(this, s);
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(zzayc);
    }

    public String getPendingParticipantId()
    {
        return zzayE;
    }

    public byte[] getPreviousMatchData()
    {
        return zzayI;
    }

    public String getRematchId()
    {
        return zzayH;
    }

    public int getStatus()
    {
        return zzayF;
    }

    public int getTurnStatus()
    {
        return zzayK;
    }

    public int getVariant()
    {
        return zzayd;
    }

    public int getVersion()
    {
        return mVersion;
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

    public boolean isLocallyModified()
    {
        return zzayL;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        TurnBasedMatchEntityCreator.zza(this, parcel, i);
    }

}
