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
//            zzks, zzkq, zzku, zzkt, 
//            zzkp, zzkr

public class zzko extends com.google.android.gms.cast.internal.zzc
{
    public abstract class zza extends zzb
    {

        final zzko zzXV;

        public Result zzb(Status status)
        {
            return zzq(status);
        }

        public com.google.android.gms.cast.games.GameManagerClient.GameManagerResult zzq(Status status)
        {
            return new zze(status, null, -1L, null);
        }

        public zza()
        {
            zzXV = zzko.this;
            super();
            zzXu = new _cls1(this, zzko.this);
        }
    }

    public abstract class zzb extends com.google.android.gms.cast.internal.zzb
    {

        final zzko zzXV;
        protected zzo zzXu;

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

        public zzo zzmG()
        {
            return zzXu;
        }

        public zzb()
        {
            zzXV = zzko.this;
            super(zzko.zzb(zzko.this));
        }
    }

    public abstract class zzc extends zzb
    {

        final zzko zzXV;
        private GameManagerClient zzYd;

        static GameManagerClient zza(zzc zzc1)
        {
            return zzc1.zzYd;
        }

        public Result zzb(Status status)
        {
            return zzr(status);
        }

        public com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult zzr(Status status)
        {
            return new zzd(status, null);
        }

        public zzc(GameManagerClient gamemanagerclient)
        {
            zzXV = zzko.this;
            super();
            zzYd = gamemanagerclient;
            zzXu = new _cls1(this, zzko.this);
        }
    }

    private static final class zzd
        implements com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult
    {

        private final Status zzSC;
        private final GameManagerClient zzYd;

        public GameManagerClient getGameManagerClient()
        {
            return zzYd;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        zzd(Status status, GameManagerClient gamemanagerclient)
        {
            zzSC = status;
            zzYd = gamemanagerclient;
        }
    }

    private static final class zze
        implements com.google.android.gms.cast.games.GameManagerClient.GameManagerResult
    {

        private final Status zzSC;
        private final String zzYf;
        private final long zzYg;
        private final JSONObject zzYh;

        public JSONObject getExtraMessageData()
        {
            return zzYh;
        }

        public String getPlayerId()
        {
            return zzYf;
        }

        public long getRequestId()
        {
            return zzYg;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        zze(Status status, String s, long l, JSONObject jsonobject)
        {
            zzSC = status;
            zzYf = s;
            zzYg = l;
            zzYh = jsonobject;
        }
    }


    static final String NAMESPACE = zzf.zzbN("com.google.cast.games");
    private static final zzl zzVo = new zzl("GameManagerChannel");
    private final Map zzXH = new ConcurrentHashMap();
    private final List zzXI;
    private final String zzXJ;
    private final com.google.android.gms.cast.Cast.CastApi zzXK;
    private final GoogleApiClient zzXL;
    private zzkp zzXM;
    private boolean zzXN;
    private GameManagerState zzXO;
    private GameManagerState zzXP;
    private String zzXQ;
    private JSONObject zzXR;
    private long zzXS;
    private com.google.android.gms.cast.games.GameManagerClient.Listener zzXT;
    private String zzXU;
    private final SharedPreferences zzuj;

    public zzko(GoogleApiClient googleapiclient, String s, com.google.android.gms.cast.Cast.CastApi castapi)
        throws IllegalArgumentException, IllegalStateException
    {
        super(NAMESPACE, "CastGameManagerChannel", null);
        zzXN = false;
        zzXS = 0L;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        }
        if (googleapiclient == null || !googleapiclient.isConnected() || !googleapiclient.hasConnectedApi(Cast.API))
        {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        } else
        {
            zzXI = new ArrayList();
            zzXJ = s;
            zzXK = castapi;
            zzXL = googleapiclient;
            googleapiclient = googleapiclient.getContext().getApplicationContext();
            s = String.format(Locale.ROOT, "%s.%s", new Object[] {
                googleapiclient.getPackageName(), "game_manager_channel_data"
            });
            zzuj = googleapiclient.getApplicationContext().getSharedPreferences(s, 0);
            zzXP = null;
            zzXO = new zzks(0, 0, "", null, new ArrayList(), "", -1);
            return;
        }
    }

    static zzkp zza(zzko zzko1, zzkp zzkp1)
    {
        zzko1.zzXM = zzkp1;
        return zzkp1;
    }

    static String zza(zzko zzko1, String s)
    {
        zzko1.zzXU = s;
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
            jsonobject1.put("playerToken", zzbJ(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzVo.zzf("JSONException when trying to create a message: %s", new Object[] {
                s.getMessage()
            });
            return null;
        }
        return jsonobject1;
    }

    static void zza(zzko zzko1, String s, int i, JSONObject jsonobject, zzo zzo1)
    {
        zzko1.zza(s, i, jsonobject, zzo1);
    }

    private void zza(zzkq zzkq1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1;
        if (zzkq1.zzmI() != 1)
        {
            flag = false;
        }
        zzXP = zzXO;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (zzkq1.zzmN() != null)
        {
            zzXM = zzkq1.zzmN();
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
        zzku zzku1;
        String s;
        for (Iterator iterator = zzkq1.zzmK().iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(new zzkt(s, zzku1.getPlayerState(), zzku1.getPlayerData(), zzXH.containsKey(s))))
        {
            zzku1 = (zzku)iterator.next();
            s = zzku1.getPlayerId();
        }

        break MISSING_BLOCK_LABEL_149;
        zzkq1;
        throw zzkq1;
        zzXO = new zzks(zzkq1.getLobbyState(), zzkq1.getGameplayState(), zzkq1.zzmL(), zzkq1.getGameData(), ((java.util.Collection) (obj)), zzXM.zzmH(), zzXM.getMaxPlayers());
        obj = zzXO.getPlayer(zzkq1.getPlayerId());
        if (obj == null) goto _L1; else goto _L3
_L3:
        if (!((PlayerInfo) (obj)).isControllable() || zzkq1.zzmI() != 2) goto _L1; else goto _L4
_L4:
        zzXQ = zzkq1.getPlayerId();
        zzXR = zzkq1.getExtraMessageData();
          goto _L1
    }

    private void zza(String s, int i, JSONObject jsonobject, zzo zzo1)
    {
        long l = 1L + zzXS;
        zzXS = l;
        s = zza(l, s, i, jsonobject);
        if (s == null)
        {
            zzo1.zza(-1L, 2001, null);
            zzVo.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        } else
        {
            jsonobject = new zzp(30000L);
            jsonobject.zza(l, zzo1);
            zzXI.add(jsonobject);
            zzV(true);
            zzXK.sendMessage(zzXL, getNamespace(), s.toString()).setResultCallback(new ResultCallback(l) {

                final zzko zzXV;
                final long zzYa;

                public void onResult(Result result)
                {
                    zzo((Status)result);
                }

                public void zzo(Status status)
                {
                    if (!status.isSuccess())
                    {
                        zzXV.zzb(zzYa, status.getStatusCode());
                    }
                }

            
            {
                zzXV = zzko.this;
                zzYa = l;
                super();
            }
            });
            return;
        }
    }

    private int zzaX(int i)
    {
        byte byte0 = 0;
        switch (i)
        {
        default:
            zzVo.zzf((new StringBuilder()).append("Unknown GameManager protocol status code: ").append(i).toString(), new Object[0]);
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

    static GoogleApiClient zzb(zzko zzko1)
    {
        return zzko1.zzXL;
    }

    private void zzb(long l, int i, Object obj)
    {
        Iterator iterator = zzXI.iterator();
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

    static com.google.android.gms.cast.Cast.CastApi zzc(zzko zzko1)
    {
        return zzko1.zzXK;
    }

    static void zzd(zzko zzko1)
    {
        zzko1.zzmE();
    }

    static void zze(zzko zzko1)
    {
        zzko1.zzmD();
    }

    private void zzmB()
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

    private void zzmC()
    {
        if (zzXT != null)
        {
            if (zzXP != null && !zzXO.equals(zzXP))
            {
                zzXT.onStateChanged(zzXO, zzXP);
            }
            if (zzXR != null && zzXQ != null)
            {
                zzXT.onGameMessageReceived(zzXQ, zzXR);
            }
        }
        zzXP = null;
        zzXQ = null;
        zzXR = null;
    }

    private void zzmD()
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("castSessionId", zzXJ);
        jsonobject.put("playerTokenMap", new JSONObject(zzXH));
        zzuj.edit().putString("save_data", jsonobject.toString()).commit();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zzVo.zzf("Error while saving data: %s", new Object[] {
            ((JSONException) (obj)).getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    private void zzmE()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = zzuj.getString("save_data", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = new JSONObject(((String) (obj)));
        String s = ((JSONObject) (obj)).getString("castSessionId");
        if (zzXJ.equals(s))
        {
            obj = ((JSONObject) (obj)).getJSONObject("playerTokenMap");
            String s1;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); zzXH.put(s1, ((JSONObject) (obj)).getString(s1)))
            {
                s1 = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_131;
        }
          goto _L1
        Object obj1;
        obj1;
        zzVo.zzf("Error while loading data: %s", new Object[] {
            ((JSONException) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        throw obj1;
        zzXS = 0L;
          goto _L1
    }

    static zzl zzmF()
    {
        return zzVo;
    }

    public void dispose()
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzXN;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzXO = null;
        zzXP = null;
        zzXQ = null;
        zzXR = null;
        zzXN = true;
        zzXK.removeMessageReceivedCallbacks(zzXL, getNamespace());
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        zzVo.zzf("Exception while detaching game manager channel.", new Object[] {
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
        zzmB();
        gamemanagerstate = zzXO;
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
        zzmB();
        s = zzXU;
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
        boolean flag = zzXN;
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
        zzkp zzkp1 = zzXM;
        boolean flag;
        if (zzkp1 != null)
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
        zzmB();
        long l = 1L + zzXS;
        zzXS = l;
        s = zza(l, s, 7, jsonobject);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzXK.sendMessage(zzXL, getNamespace(), s.toString());
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
        zzmB();
        s = zzXL.zzb(new zza(s, jsonobject) {

            final zzko zzXV;
            final String zzXY;
            final JSONObject zzXZ;

            public void execute()
            {
                zzko.zza(zzXV, zzXY, 6, zzXZ, zzmG());
            }

            
            {
                zzXV = zzko.this;
                zzXY = s;
                zzXZ = jsonobject;
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
        zzXT = listener;
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
        gamemanagerclient = zzXL.zzb(new zzc(gamemanagerclient) {

            final zzko zzXV;

            public void execute()
            {
                com.google.android.gms.internal.zzko.zzc(zzXV).setMessageReceivedCallbacks(zzko.zzb(zzXV), zzXV.getNamespace(), new com.google.android.gms.cast.Cast.MessageReceivedCallback(this) {

                    final _cls1 zzXW;

                    public void onMessageReceived(CastDevice castdevice, String s, String s1)
                    {
                        zzXW.zzXV.zzbK(s1);
                    }

            
            {
                zzXW = _pcls1;
                super();
            }
                });
                zzko.zzd(zzXV);
                zzko.zze(zzXV);
                zzko.zza(zzXV, null, 1100, null, zzmG());
                return;
                Object obj;
                obj;
_L2:
                zzmG().zza(-1L, 8, null);
                return;
                obj;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                zzXV = zzko.this;
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
        zzmB();
        s = zzXL.zzb(new zza(i, s, jsonobject) {

            final zzko zzXV;
            final int zzXX;
            final String zzXY;
            final JSONObject zzXZ;

            public void execute()
            {
                int j = zzkr.zzaY(zzXX);
                if (j == 0)
                {
                    zzmG().zza(-1L, 2001, null);
                    zzko.zzmF().zzf("sendPlayerRequest for unsupported playerState: %d", new Object[] {
                        Integer.valueOf(zzXX)
                    });
                    return;
                } else
                {
                    zzko.zza(zzXV, zzXY, j, zzXZ, zzmG());
                    return;
                }
            }

            
            {
                zzXV = zzko.this;
                zzXX = i;
                zzXY = s;
                zzXZ = jsonobject;
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

    public String zzbJ(String s)
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
        s = (String)zzXH.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public final void zzbK(String s)
    {
        zzVo.zzb("message received: %s", new Object[] {
            s
        });
        Object obj;
        try
        {
            obj = zzkq.zzh(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzVo.zzf("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
            return;
        }
        if (obj == null)
        {
            zzVo.zzf("Could not parse game manager message from string: %s", new Object[] {
                s
            });
        } else
        if ((isInitialized() || ((zzkq) (obj)).zzmN() != null) && !isDisposed())
        {
            boolean flag;
            int i;
            if (((zzkq) (obj)).zzmI() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && !TextUtils.isEmpty(((zzkq) (obj)).zzmM()))
            {
                zzXH.put(((zzkq) (obj)).getPlayerId(), ((zzkq) (obj)).zzmM());
                zzmD();
            }
            if (((zzkq) (obj)).getStatusCode() == 0)
            {
                zza(((zzkq) (obj)));
            } else
            {
                zzVo.zzf("Not updating from game message because the message contains error code: %d", new Object[] {
                    Integer.valueOf(((zzkq) (obj)).getStatusCode())
                });
            }
            i = zzaX(((zzkq) (obj)).getStatusCode());
            if (flag)
            {
                zzb(((zzkq) (obj)).getRequestId(), i, obj);
            }
            if (isInitialized() && i == 0)
            {
                zzmC();
                return;
            }
        }
    }

    protected boolean zzz(long l)
    {
        Iterator iterator = zzXI.iterator();
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
        Object obj = zzp.zzZJ;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator1 = zzXI.iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((zzp)iterator1.next()).zznk()) goto _L4; else goto _L3
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


    // Unreferenced inner class com/google/android/gms/internal/zzko$zza$1

/* anonymous class */
    class zza._cls1
        implements zzo
    {

        final zzko zzYb;
        final zza zzYc;

        public void zza(long l, int i, Object obj)
        {
            if (obj == null)
            {
                String s;
                try
                {
                    zzYc.zzb(new zze(new Status(i, null, null), null, l, null));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    zzYc.zzb(zzYc.zzq(new Status(13)));
                }
                break MISSING_BLOCK_LABEL_135;
            }
            obj = (zzkq)obj;
            s = ((zzkq) (obj)).getPlayerId();
            if (i != 0 || s == null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            zzko.zza(zzYc.zzXV, s);
            zzYc.zzb(new zze(new Status(i, ((zzkq) (obj)).zzmJ(), null), s, ((zzkq) (obj)).getRequestId(), ((zzkq) (obj)).getExtraMessageData()));
            return;
        }

        public void zzy(long l)
        {
            zzYc.zzb(zzYc.zzq(new Status(2103)));
        }

            
            {
                zzYc = zza1;
                zzYb = zzko1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/internal/zzko$zzc$1

/* anonymous class */
    class zzc._cls1
        implements zzo
    {

        final zzko zzYb;
        final zzc zzYe;

        public void zza(long l, int i, Object obj)
        {
            if (obj == null)
            {
                zzkp zzkp1;
                try
                {
                    zzYe.zzb(new zzd(new Status(i, null, null), zzc.zza(zzYe)));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    zzYe.zzb(zzYe.zzr(new Status(13)));
                }
                break MISSING_BLOCK_LABEL_156;
            }
            obj = (zzkq)obj;
            zzkp1 = ((zzkq) (obj)).zzmN();
            if (zzkp1 == null)
            {
                break MISSING_BLOCK_LABEL_157;
            }
            if (!zzf.zza("1.0.0", zzkp1.getVersion()))
            {
                zzYe.zzb(zzYe.zzr(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                    zzkp1.getVersion(), "1.0.0"
                }))));
                zzko.zza(zzYe.zzXV, null);
                return;
            }
            break MISSING_BLOCK_LABEL_157;
            return;
            zzYe.zzb(new zzd(new Status(i, ((zzkq) (obj)).zzmJ(), null), zzc.zza(zzYe)));
            return;
        }

        public void zzy(long l)
        {
            zzYe.zzb(zzYe.zzr(new Status(2103)));
        }

            
            {
                zzYe = zzc1;
                zzYb = zzko1;
                super();
            }
    }

}
