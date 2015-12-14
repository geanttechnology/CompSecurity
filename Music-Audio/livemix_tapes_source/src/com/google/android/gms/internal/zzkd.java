// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzc;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzkh, zzkf, zzkj, zzki, 
//            zzke, zzkg

public class zzkd extends com.google.android.gms.cast.internal.zzc
{
    public abstract class zza extends zzb
    {

        final zzkd zzWd;

        public Result zzb(Status status)
        {
            return zzt(status);
        }

        public com.google.android.gms.cast.games.GameManagerClient.GameManagerResult zzt(Status status)
        {
            return new zze(status, null, -1L, null);
        }

        public zza()
        {
            zzWd = zzkd.this;
            super();
            zzVC = new _cls1(this, zzkd.this);
        }
    }

    public abstract class zzb extends com.google.android.gms.cast.internal.zzb
    {

        protected zzo zzVC;
        final zzkd zzWd;

        public abstract void execute();

        protected void zza(com.google.android.gms.cast.internal.zze zze1)
        {
            execute();
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((com.google.android.gms.cast.internal.zze)zzb1);
        }

        public zzo zzmk()
        {
            return zzVC;
        }

        public zzb()
        {
            zzWd = zzkd.this;
            super(zzkd.zzb(zzkd.this));
        }
    }

    public abstract class zzc extends zzb
    {

        final zzkd zzWd;
        private GameManagerClient zzWl;

        static GameManagerClient zza(zzc zzc1)
        {
            return zzc1.zzWl;
        }

        public Result zzb(Status status)
        {
            return zzu(status);
        }

        public com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult zzu(Status status)
        {
            return new zzd(status, null);
        }

        public zzc(GameManagerClient gamemanagerclient)
        {
            zzWd = zzkd.this;
            super();
            zzWl = gamemanagerclient;
            zzVC = new _cls1(this, zzkd.this);
        }
    }

    private static final class zzd
        implements com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult
    {

        private final Status zzQA;
        private final GameManagerClient zzWl;

        public GameManagerClient getGameManagerClient()
        {
            return zzWl;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        zzd(Status status, GameManagerClient gamemanagerclient)
        {
            zzQA = status;
            zzWl = gamemanagerclient;
        }
    }

    private static final class zze
        implements com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
    {

        private final Status zzQA;
        private final String zzWn;
        private final long zzWo;
        private final JSONObject zzWp;

        public JSONObject getExtraMessageData()
        {
            return zzWp;
        }

        public String getPlayerId()
        {
            return zzWn;
        }

        public long getRequestId()
        {
            return zzWo;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        zze(Status status, String s, long l, JSONObject jsonobject)
        {
            zzQA = status;
            zzWn = s;
            zzWo = l;
            zzWp = jsonobject;
        }
    }


    static final String NAMESPACE = zzf.zzbM("com.google.cast.games");
    private static final zzl zzTy = new zzl("GameManagerChannel");
    private final Map zzVP = new ConcurrentHashMap();
    private final List zzVQ;
    private final String zzVR;
    private final com.google.android.gms.cast.Cast.CastApi zzVS;
    private final GoogleApiClient zzVT;
    private zzke zzVU;
    private boolean zzVV;
    private GameManagerState zzVW;
    private GameManagerState zzVX;
    private String zzVY;
    private JSONObject zzVZ;
    private long zzWa;
    private com.google.android.gms.cast.games.GameManagerClient.Listener zzWb;
    private String zzWc;
    private final SharedPreferences zztU;

    public zzkd(GoogleApiClient googleapiclient, String s, com.google.android.gms.cast.Cast.CastApi castapi)
        throws IllegalArgumentException, IllegalStateException
    {
        super(NAMESPACE, "CastGameManagerChannel", null);
        zzVV = false;
        zzWa = 0L;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        }
        if (googleapiclient == null || !googleapiclient.isConnected() || !googleapiclient.hasConnectedApi(Cast.API))
        {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        } else
        {
            zzVQ = new ArrayList();
            zzVR = s;
            zzVS = castapi;
            zzVT = googleapiclient;
            googleapiclient = googleapiclient.getContext().getApplicationContext();
            s = String.format(Locale.ROOT, "%s.%s", new Object[] {
                googleapiclient.getPackageName(), "game_manager_channel_data"
            });
            zztU = googleapiclient.getApplicationContext().getSharedPreferences(s, 0);
            zzVX = null;
            zzVW = new zzkh(0, 0, "", null, new ArrayList(), "", -1);
            return;
        }
    }

    static zzke zza(zzkd zzkd1, zzke zzke1)
    {
        zzkd1.zzVU = zzke1;
        return zzke1;
    }

    static String zza(zzkd zzkd1, String s)
    {
        zzkd1.zzWc = s;
        return s;
    }

    private JSONObject zza(long l, String s, int i, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        try
        {
            jsonobject1 = new JSONObject();
            jsonobject1.put("requestId", l);
            jsonobject1.put("type", i);
            jsonobject1.put("extraMessageData", jsonobject);
            jsonobject1.put("playerId", s);
            jsonobject1.put("playerToken", zzbI(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzTy.zzf("JSONException when trying to create a message: %s", new Object[] {
                s.getMessage()
            });
            return null;
        }
        return jsonobject1;
    }

    static void zza(zzkd zzkd1, String s, int i, JSONObject jsonobject, zzo zzo1)
    {
        zzkd1.zza(s, i, jsonobject, zzo1);
    }

    private void zza(zzkf zzkf1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1;
        if (zzkf1.zzmm() != 1)
        {
            flag = false;
        }
        zzVX = zzVW;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (zzkf1.zzmr() != null)
        {
            zzVU = zzkf1.zzmr();
        }
        flag1 = isInitialized();
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        obj = new ArrayList();
        zzkj zzkj1;
        String s;
        for (Iterator iterator = zzkf1.zzmo().iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(new zzki(s, zzkj1.getPlayerState(), zzkj1.getPlayerData(), zzVP.containsKey(s))))
        {
            zzkj1 = (zzkj)iterator.next();
            s = zzkj1.getPlayerId();
        }

        break MISSING_BLOCK_LABEL_149;
        zzkf1;
        throw zzkf1;
        zzVW = new zzkh(zzkf1.getLobbyState(), zzkf1.getGameplayState(), zzkf1.zzmp(), zzkf1.getGameData(), ((java.util.Collection) (obj)), zzVU.zzml(), zzVU.getMaxPlayers());
        obj = zzVW.getPlayer(zzkf1.getPlayerId());
        if (obj == null) goto _L1; else goto _L3
_L3:
        if (!((PlayerInfo) (obj)).isControllable() || zzkf1.zzmm() != 2) goto _L1; else goto _L4
_L4:
        zzVY = zzkf1.getPlayerId();
        zzVZ = zzkf1.getExtraMessageData();
          goto _L1
    }

    private void zza(String s, int i, JSONObject jsonobject, zzo zzo1)
    {
        long l = zzWa + 1L;
        zzWa = l;
        s = zza(l, s, i, jsonobject);
        if (s == null)
        {
            zzo1.zza(-1L, 2001, null);
            zzTy.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        } else
        {
            jsonobject = new zzp(30000L);
            jsonobject.zza(l, zzo1);
            zzVQ.add(jsonobject);
            zzU(true);
            zzVS.sendMessage(zzVT, getNamespace(), s.toString()).setResultCallback(new ResultCallback(l) {

                final zzkd zzWd;
                final long zzWi;

                public void onResult(Result result)
                {
                    zzr((Status)result);
                }

                public void zzr(Status status)
                {
                    if (!status.isSuccess())
                    {
                        zzWd.zzb(zzWi, status.getStatusCode());
                    }
                }

            
            {
                zzWd = zzkd.this;
                zzWi = l;
                super();
            }
            });
            return;
        }
    }

    private int zzaQ(int i)
    {
        byte byte0 = 0;
        switch (i)
        {
        default:
            zzTy.zzf((new StringBuilder()).append("Unknown GameManager protocol status code: ").append(i).toString(), new Object[0]);
            byte0 = 13;
            // fall through

        case 0: // '\0'
            return byte0;

        case 4: // '\004'
            return 2151;

        case 3: // '\003'
            return 2150;

        case 2: // '\002'
            return 2003;

        case 1: // '\001'
            return 2001;
        }
    }

    static GoogleApiClient zzb(zzkd zzkd1)
    {
        return zzkd1.zzVT;
    }

    private void zzb(long l, int i, Object obj)
    {
        Iterator iterator = zzVQ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((zzp)iterator.next()).zzc(l, i, obj))
            {
                iterator.remove();
            }
        } while (true);
    }

    static com.google.android.gms.cast.Cast.CastApi zzc(zzkd zzkd1)
    {
        return zzkd1.zzVS;
    }

    static void zzd(zzkd zzkd1)
    {
        zzkd1.zzmi();
    }

    static void zze(zzkd zzkd1)
    {
        zzkd1.zzmh();
    }

    private void zzmf()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        if (!isInitialized())
        {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (isDisposed())
        {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
        this;
        JVM INSTR monitorexit ;
    }

    private void zzmg()
    {
        if (zzWb != null)
        {
            if (zzVX != null && !zzVW.equals(zzVX))
            {
                zzWb.onStateChanged(zzVW, zzVX);
            }
            if (zzVZ != null && zzVY != null)
            {
                zzWb.onGameMessageReceived(zzVY, zzVZ);
            }
        }
        zzVX = null;
        zzVY = null;
        zzVZ = null;
    }

    private void zzmh()
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("castSessionId", zzVR);
        jsonobject.put("playerTokenMap", new JSONObject(zzVP));
        zztU.edit().putString("save_data", jsonobject.toString()).commit();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zzTy.zzf("Error while saving data: %s", new Object[] {
            ((JSONException) (obj)).getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    private void zzmi()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = zztU.getString("save_data", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = new JSONObject(((String) (obj)));
        String s = ((JSONObject) (obj)).getString("castSessionId");
        if (zzVR.equals(s))
        {
            obj = ((JSONObject) (obj)).getJSONObject("playerTokenMap");
            String s1;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); zzVP.put(s1, ((JSONObject) (obj)).getString(s1)))
            {
                s1 = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_131;
        }
          goto _L1
        Object obj1;
        obj1;
        zzTy.zzf("Error while loading data: %s", new Object[] {
            ((JSONException) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        throw obj1;
        zzWa = 0L;
          goto _L1
    }

    static zzl zzmj()
    {
        return zzTy;
    }

    public void dispose()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzVV;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzVW = null;
        zzVX = null;
        zzVY = null;
        zzVZ = null;
        zzVV = true;
        zzVS.removeMessageReceivedCallbacks(zzVT, getNamespace());
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        zzTy.zzf("Exception while detaching game manager channel.", new Object[] {
            obj
        });
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public GameManagerState getCurrentState()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        GameManagerState gamemanagerstate;
        zzmf();
        gamemanagerstate = zzVW;
        this;
        JVM INSTR monitorexit ;
        return gamemanagerstate;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLastUsedPlayerId()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        zzmf();
        s = zzWc;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isDisposed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzVV;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isInitialized()
    {
        this;
        JVM INSTR monitorenter ;
        zzke zzke1 = zzVU;
        boolean flag;
        if (zzke1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void sendGameMessage(String s, JSONObject jsonobject)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        zzmf();
        long l = zzWa + 1L;
        zzWa = l;
        s = zza(l, s, 7, jsonobject);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzVS.sendMessage(zzVT, getNamespace(), s.toString());
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public PendingResult sendGameRequest(String s, JSONObject jsonobject)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        zzmf();
        s = zzVT.zzb(new zza(s, jsonobject) {

            final zzkd zzWd;
            final String zzWg;
            final JSONObject zzWh;

            public void execute()
            {
                zzkd.zza(zzWd, zzWg, 6, zzWh, zzmk());
            }

            
            {
                zzWd = zzkd.this;
                zzWg = s;
                zzWh = jsonobject;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void setListener(com.google.android.gms.cast.games.GameManagerClient.Listener listener)
    {
        this;
        JVM INSTR monitorenter ;
        zzWb = listener;
        this;
        JVM INSTR monitorexit ;
        return;
        listener;
        throw listener;
    }

    public PendingResult zza(GameManagerClient gamemanagerclient)
        throws IllegalArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        if (gamemanagerclient != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new IllegalArgumentException("gameManagerClient can't be null.");
        gamemanagerclient;
        this;
        JVM INSTR monitorexit ;
        throw gamemanagerclient;
        gamemanagerclient = zzVT.zzb(new zzc(gamemanagerclient) {

            final zzkd zzWd;

            public void execute()
            {
                com.google.android.gms.internal.zzkd.zzc(zzWd).setMessageReceivedCallbacks(zzkd.zzb(zzWd), zzWd.getNamespace(), new com.google.android.gms.cast.Cast.MessageReceivedCallback(this) {

                    final _cls1 zzWe;

                    public void onMessageReceived(CastDevice castdevice, String s, String s1)
                    {
                        zzWe.zzWd.zzbJ(s1);
                    }

            
            {
                zzWe = _pcls1;
                super();
            }
                });
                zzkd.zzd(zzWd);
                zzkd.zze(zzWd);
                zzkd.zza(zzWd, null, 1100, null, zzmk());
                return;
                Object obj;
                obj;
_L2:
                zzmk().zza(-1L, 8, null);
                return;
                obj;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                zzWd = zzkd.this;
                super(gamemanagerclient);
            }
        });
        this;
        JVM INSTR monitorexit ;
        return gamemanagerclient;
    }

    public PendingResult zza(String s, int i, JSONObject jsonobject)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        zzmf();
        s = zzVT.zzb(new zza(i, s, jsonobject) {

            final zzkd zzWd;
            final int zzWf;
            final String zzWg;
            final JSONObject zzWh;

            public void execute()
            {
                int j = zzkg.zzaR(zzWf);
                if (j == 0)
                {
                    zzmk().zza(-1L, 2001, null);
                    zzkd.zzmj().zzf("sendPlayerRequest for unsupported playerState: %d", new Object[] {
                        Integer.valueOf(zzWf)
                    });
                    return;
                } else
                {
                    zzkd.zza(zzWd, zzWg, j, zzWh, zzmk());
                    return;
                }
            }

            
            {
                zzWd = zzkd.this;
                zzWf = i;
                zzWg = s;
                zzWh = jsonobject;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void zzb(long l, int i)
    {
        zzb(l, i, null);
    }

    public String zzbI(String s)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (String)zzVP.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public final void zzbJ(String s)
    {
        zzTy.zzb("message received: %s", new Object[] {
            s
        });
        Object obj;
        try
        {
            obj = zzkf.zzh(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzTy.zzf("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
            return;
        }
        if (obj == null)
        {
            zzTy.zzf("Could not parse game manager message from string: %s", new Object[] {
                s
            });
        } else
        if ((isInitialized() || ((zzkf) (obj)).zzmr() != null) && !isDisposed())
        {
            boolean flag;
            int i;
            if (((zzkf) (obj)).zzmm() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && !TextUtils.isEmpty(((zzkf) (obj)).zzmq()))
            {
                zzVP.put(((zzkf) (obj)).getPlayerId(), ((zzkf) (obj)).zzmq());
                zzmh();
            }
            if (((zzkf) (obj)).getStatusCode() == 0)
            {
                zza(((zzkf) (obj)));
            } else
            {
                zzTy.zzf("Not updating from game message because the message contains error code: %d", new Object[] {
                    Integer.valueOf(((zzkf) (obj)).getStatusCode())
                });
            }
            i = zzaQ(((zzkf) (obj)).getStatusCode());
            if (flag)
            {
                zzb(((zzkf) (obj)).getRequestId(), i, obj);
            }
            if (isInitialized() && i == 0)
            {
                zzmg();
                return;
            }
        }
    }

    protected boolean zzz(long l)
    {
        Iterator iterator = zzVQ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((zzp)iterator.next()).zzd(l, 15))
            {
                iterator.remove();
            }
        } while (true);
        Object obj = zzp.zzXT;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator1 = zzVQ.iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((zzp)iterator1.next()).zzmO()) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }


    // Unreferenced inner class com/google/android/gms/internal/zzkd$zza$1

/* anonymous class */
    class zza._cls1
        implements zzo
    {

        final zzkd zzWj;
        final zza zzWk;

        public void zza(long l, int i, Object obj)
        {
            if (obj == null)
            {
                String s;
                try
                {
                    zzWk.zza(new zze(new Status(i, null, null), null, l, null));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    zzWk.zza(zzWk.zzt(new Status(13)));
                }
                break MISSING_BLOCK_LABEL_135;
            }
            obj = (zzkf)obj;
            s = ((zzkf) (obj)).getPlayerId();
            if (i != 0 || s == null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            zzkd.zza(zzWk.zzWd, s);
            zzWk.zza(new zze(new Status(i, ((zzkf) (obj)).zzmn(), null), s, ((zzkf) (obj)).getRequestId(), ((zzkf) (obj)).getExtraMessageData()));
            return;
        }

        public void zzy(long l)
        {
            zzWk.zza(zzWk.zzt(new Status(2103)));
        }

            
            {
                zzWk = zza1;
                zzWj = zzkd1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/internal/zzkd$zzc$1

/* anonymous class */
    class zzc._cls1
        implements zzo
    {

        final zzkd zzWj;
        final zzc zzWm;

        public void zza(long l, int i, Object obj)
        {
            if (obj == null)
            {
                zzke zzke1;
                try
                {
                    zzWm.zza(new zzd(new Status(i, null, null), zzc.zza(zzWm)));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    zzWm.zza(zzWm.zzu(new Status(13)));
                }
                break MISSING_BLOCK_LABEL_156;
            }
            obj = (zzkf)obj;
            zzke1 = ((zzkf) (obj)).zzmr();
            if (zzke1 == null)
            {
                break MISSING_BLOCK_LABEL_157;
            }
            if (!zzf.zza("1.0.0", zzke1.getVersion()))
            {
                zzWm.zza(zzWm.zzu(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                    zzke1.getVersion(), "1.0.0"
                }))));
                zzkd.zza(zzWm.zzWd, null);
                return;
            }
            break MISSING_BLOCK_LABEL_157;
            return;
            zzWm.zza(new zzd(new Status(i, ((zzkf) (obj)).zzmn(), null), zzc.zza(zzWm)));
            return;
        }

        public void zzy(long l)
        {
            zzWm.zza(zzWm.zzu(new Status(2103)));
        }

            
            {
                zzWm = zzc1;
                zzWj = zzkd1;
                super();
            }
    }

}
