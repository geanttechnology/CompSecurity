// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzmu

public final class zzks
    implements GameManagerState
{

    private final String zzYi;
    private final int zzYj;
    private final int zzYo;
    private final int zzYp;
    private final JSONObject zzYr;
    private final String zzYs;
    private final Map zzYu;

    public zzks(int i, int j, String s, JSONObject jsonobject, Collection collection, String s1, int k)
    {
        zzYp = i;
        zzYo = j;
        zzYs = s;
        zzYr = jsonobject;
        zzYi = s1;
        zzYj = k;
        zzYu = new HashMap(collection.size());
        for (s = collection.iterator(); s.hasNext(); zzYu.put(jsonobject.getPlayerId(), jsonobject))
        {
            jsonobject = (PlayerInfo)s.next();
        }

    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && (obj instanceof GameManagerState)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Iterator iterator;
        if (getPlayers().size() != ((GameManagerState) (obj = (GameManagerState)obj)).getPlayers().size())
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = getPlayers().iterator();
_L4:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_152;
        }
        PlayerInfo playerinfo = (PlayerInfo)iterator.next();
        Iterator iterator1 = ((GameManagerState) (obj)).getPlayers().iterator();
        flag = false;
        do
        {
            PlayerInfo playerinfo1;
            do
            {
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                playerinfo1 = (PlayerInfo)iterator1.next();
            } while (!zzf.zza(playerinfo.getPlayerId(), playerinfo1.getPlayerId()));
            if (!zzf.zza(playerinfo, playerinfo1))
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = true;
        } while (true);
        continue; /* Loop/switch isn't completed */
        if (flag) goto _L4; else goto _L3
_L3:
        return false;
        if (zzYp != ((GameManagerState) (obj)).getLobbyState() || zzYo != ((GameManagerState) (obj)).getGameplayState() || zzYj != ((GameManagerState) (obj)).getMaxPlayers() || !zzf.zza(zzYi, ((GameManagerState) (obj)).getApplicationName()) || !zzf.zza(zzYs, ((GameManagerState) (obj)).getGameStatusText()) || !zzmu.zzd(zzYr, ((GameManagerState) (obj)).getGameData()))
        {
            flag1 = false;
        }
        return flag1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public CharSequence getApplicationName()
    {
        return zzYi;
    }

    public List getConnectedControllablePlayers()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getPlayers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo = (PlayerInfo)iterator.next();
            if (playerinfo.isConnected() && playerinfo.isControllable())
            {
                arraylist.add(playerinfo);
            }
        } while (true);
        return arraylist;
    }

    public List getConnectedPlayers()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getPlayers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo = (PlayerInfo)iterator.next();
            if (playerinfo.isConnected())
            {
                arraylist.add(playerinfo);
            }
        } while (true);
        return arraylist;
    }

    public List getControllablePlayers()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getPlayers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo = (PlayerInfo)iterator.next();
            if (playerinfo.isControllable())
            {
                arraylist.add(playerinfo);
            }
        } while (true);
        return arraylist;
    }

    public JSONObject getGameData()
    {
        return zzYr;
    }

    public CharSequence getGameStatusText()
    {
        return zzYs;
    }

    public int getGameplayState()
    {
        return zzYo;
    }

    public Collection getListOfChangedPlayers(GameManagerState gamemanagerstate)
    {
        HashSet hashset = new HashSet();
        Iterator iterator = getPlayers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo1 = (PlayerInfo)iterator.next();
            PlayerInfo playerinfo2 = gamemanagerstate.getPlayer(playerinfo1.getPlayerId());
            if (playerinfo2 == null || !playerinfo1.equals(playerinfo2))
            {
                hashset.add(playerinfo1.getPlayerId());
            }
        } while (true);
        gamemanagerstate = gamemanagerstate.getPlayers().iterator();
        do
        {
            if (!gamemanagerstate.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo = (PlayerInfo)gamemanagerstate.next();
            if (getPlayer(playerinfo.getPlayerId()) == null)
            {
                hashset.add(playerinfo.getPlayerId());
            }
        } while (true);
        return hashset;
    }

    public int getLobbyState()
    {
        return zzYp;
    }

    public int getMaxPlayers()
    {
        return zzYj;
    }

    public PlayerInfo getPlayer(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (PlayerInfo)zzYu.get(s);
        }
    }

    public Collection getPlayers()
    {
        return Collections.unmodifiableCollection(zzYu.values());
    }

    public List getPlayersInState(int i)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getPlayers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayerInfo playerinfo = (PlayerInfo)iterator.next();
            if (playerinfo.getPlayerState() == i)
            {
                arraylist.add(playerinfo);
            }
        } while (true);
        return arraylist;
    }

    public boolean hasGameDataChanged(GameManagerState gamemanagerstate)
    {
        return !zzmu.zzd(zzYr, gamemanagerstate.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState gamemanagerstate)
    {
        return !zzf.zza(zzYs, gamemanagerstate.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState gamemanagerstate)
    {
        return zzYo != gamemanagerstate.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState gamemanagerstate)
    {
        return zzYp != gamemanagerstate.getLobbyState();
    }

    public boolean hasPlayerChanged(String s, GameManagerState gamemanagerstate)
    {
        return !zzf.zza(getPlayer(s), gamemanagerstate.getPlayer(s));
    }

    public boolean hasPlayerDataChanged(String s, GameManagerState gamemanagerstate)
    {
        boolean flag1 = true;
        PlayerInfo playerinfo = getPlayer(s);
        s = gamemanagerstate.getPlayer(s);
        boolean flag;
        if (playerinfo == null && s == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (playerinfo != null)
            {
                flag = flag1;
                if (s != null)
                {
                    flag = flag1;
                    if (zzmu.zzd(playerinfo.getPlayerData(), s.getPlayerData()))
                    {
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    public boolean hasPlayerStateChanged(String s, GameManagerState gamemanagerstate)
    {
        boolean flag1 = true;
        PlayerInfo playerinfo = getPlayer(s);
        s = gamemanagerstate.getPlayer(s);
        boolean flag;
        if (playerinfo == null && s == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (playerinfo != null)
            {
                flag = flag1;
                if (s != null)
                {
                    flag = flag1;
                    if (playerinfo.getPlayerState() == s.getPlayerState())
                    {
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzYp), Integer.valueOf(zzYo), zzYu, zzYs, zzYr, zzYi, Integer.valueOf(zzYj)
        });
    }
}
