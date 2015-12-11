// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaStatus, MediaQueueItem, MediaInfo, CastDevice, 
//            TextTrackStyle, Cast

public class RemoteMediaPlayer
    implements Cast.MessageReceivedCallback
{
    public static interface MediaChannelResult
        extends Result
    {

        public abstract JSONObject getCustomData();
    }

    public static interface OnMetadataUpdatedListener
    {

        public abstract void onMetadataUpdated();
    }

    public static interface OnPreloadStatusUpdatedListener
    {

        public abstract void onPreloadStatusUpdated();
    }

    public static interface OnQueueStatusUpdatedListener
    {

        public abstract void onQueueStatusUpdated();
    }

    public static interface OnStatusUpdatedListener
    {

        public abstract void onStatusUpdated();
    }

    private class zza
        implements zzn
    {

        final RemoteMediaPlayer zzWS;
        private GoogleApiClient zzXq;
        private long zzXr;

        public void zza(GoogleApiClient googleapiclient)
        {
            zzXq = googleapiclient;
        }

        public void zza(String s, String s1, long l, String s2)
            throws IOException
        {
            if (zzXq == null)
            {
                throw new IOException("No GoogleApiClient available");
            } else
            {
                Cast.CastApi.sendMessage(zzXq, s, s1).setResultCallback(new zza(this, l));
                return;
            }
        }

        public long zzmA()
        {
            long l = zzXr + 1L;
            zzXr = l;
            return l;
        }

        public zza()
        {
            zzWS = RemoteMediaPlayer.this;
            super();
            zzXr = 0L;
        }
    }

    private final class zza.zza
        implements ResultCallback
    {

        private final long zzXs;
        final zza zzXt;

        public void onResult(Result result)
        {
            zzo((Status)result);
        }

        public void zzo(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zzg(zzXt.zzWS).zzb(zzXs, status.getStatusCode());
            }
        }

        zza.zza(zza zza1, long l)
        {
            zzXt = zza1;
            super();
            zzXs = l;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb
    {

        zzo zzXu;

        public Result zzb(Status status)
        {
            return zzp(status);
        }

        public MediaChannelResult zzp(Status status)
        {
            return new MediaChannelResult(this, status) {

                final Status zzVb;
                final zzb zzXv;

                public JSONObject getCustomData()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzXv = zzb1;
                zzVb = status;
                super();
            }
            };
        }

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzXu = new _cls1(this);
        }
    }

    private static final class zzc
        implements MediaChannelResult
    {

        private final Status zzSC;
        private final JSONObject zzWc;

        public JSONObject getCustomData()
        {
            return zzWc;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        zzc(Status status, JSONObject jsonobject)
        {
            zzSC = status;
            zzWc = jsonobject;
        }
    }


    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzWM = new zzm(null) {

        final RemoteMediaPlayer zzWS;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.zzb(zzWS);
        }

        protected void onPreloadStatusUpdated()
        {
            RemoteMediaPlayer.zzd(zzWS);
        }

        protected void onQueueStatusUpdated()
        {
            RemoteMediaPlayer.zzc(zzWS);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.zza(zzWS);
        }

            
            {
                zzWS = RemoteMediaPlayer.this;
                super(s);
            }
    };
    private final zza zzWN = new zza();
    private OnPreloadStatusUpdatedListener zzWO;
    private OnQueueStatusUpdatedListener zzWP;
    private OnMetadataUpdatedListener zzWQ;
    private OnStatusUpdatedListener zzWR;
    private final Object zzpd = new Object();

    public RemoteMediaPlayer()
    {
        zzWM.zza(zzWN);
    }

    private void onMetadataUpdated()
    {
        if (zzWQ != null)
        {
            zzWQ.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated()
    {
        if (zzWO != null)
        {
            zzWO.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated()
    {
        if (zzWP != null)
        {
            zzWP.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (zzWR != null)
        {
            zzWR.onStatusUpdated();
        }
    }

    static int zza(RemoteMediaPlayer remotemediaplayer, int i)
    {
        return remotemediaplayer.zzaW(i);
    }

    static void zza(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onStatusUpdated();
    }

    private int zzaW(int i)
    {
        MediaStatus mediastatus = getMediaStatus();
        for (int j = 0; j < mediastatus.getQueueItemCount(); j++)
        {
            if (mediastatus.getQueueItem(j).getItemId() == i)
            {
                return j;
            }
        }

        return -1;
    }

    static void zzb(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onMetadataUpdated();
    }

    static void zzc(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onQueueStatusUpdated();
    }

    static void zzd(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onPreloadStatusUpdated();
    }

    static Object zze(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzpd;
    }

    static zza zzf(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzWN;
    }

    static zzm zzg(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzWM;
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (zzpd)
        {
            l = zzWM.getApproximateStreamPosition();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaInfo getMediaInfo()
    {
        MediaInfo mediainfo;
        synchronized (zzpd)
        {
            mediainfo = zzWM.getMediaInfo();
        }
        return mediainfo;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaStatus getMediaStatus()
    {
        MediaStatus mediastatus;
        synchronized (zzpd)
        {
            mediastatus = zzWM.getMediaStatus();
        }
        return mediastatus;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getNamespace()
    {
        return zzWM.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (zzpd)
        {
            l = zzWM.getStreamDuration();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo)
    {
        return load(googleapiclient, mediainfo, true, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag)
    {
        return load(googleapiclient, mediainfo, flag, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l)
    {
        return load(googleapiclient, mediainfo, flag, l, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
    {
        return load(googleapiclient, mediainfo, flag, l, null, jsonobject);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, long al[], JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, mediainfo, flag, l, al, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final long zzWZ;
            final JSONObject zzXa;
            final MediaInfo zzXh;
            final boolean zzXi;
            final long zzXj[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXh, zzXi, zzWZ, zzXj, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXh = mediainfo;
                zzXi = flag;
                zzWZ = l;
                zzXj = al;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        zzWM.zzbK(s1);
    }

    public PendingResult pause(GoogleApiClient googleapiclient)
    {
        return pause(googleapiclient, null);
    }

    public PendingResult pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult play(GoogleApiClient googleapiclient)
    {
        return play(googleapiclient, null);
    }

    public PendingResult play(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zzc(zzXu, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueAppendItem(GoogleApiClient googleapiclient, MediaQueueItem mediaqueueitem, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return queueInsertItems(googleapiclient, new MediaQueueItem[] {
            mediaqueueitem
        }, 0, jsonobject);
    }

    public PendingResult queueInsertAndPlayItem(GoogleApiClient googleapiclient, MediaQueueItem mediaqueueitem, int i, long l, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, mediaqueueitem, i, l, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final long zzWZ;
            final JSONObject zzXa;
            final int zzXc;
            final MediaQueueItem zzXd;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                zzm zzm1 = RemoteMediaPlayer.zzg(zzWS);
                zzo zzo = zzXu;
                MediaQueueItem mediaqueueitem1 = zzXd;
                int j = zzXc;
                long l1 = zzWZ;
                JSONObject jsonobject1 = zzXa;
                zzm1.zza(zzo, new MediaQueueItem[] {
                    mediaqueueitem1
                }, j, 0, 0, l1, jsonobject1);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXd = mediaqueueitem;
                zzXc = i;
                zzWZ = l;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueInsertAndPlayItem(GoogleApiClient googleapiclient, MediaQueueItem mediaqueueitem, int i, JSONObject jsonobject)
    {
        return queueInsertAndPlayItem(googleapiclient, mediaqueueitem, i, -1L, jsonobject);
    }

    public PendingResult queueInsertItems(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], int i, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, i, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final MediaQueueItem zzXb[];
            final int zzXc;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXb, zzXc, 0, -1, -1L, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXb = amediaqueueitem;
                zzXc = i;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleapiclient, int i, long l, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, googleapiclient, l, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final long zzWZ;
            final JSONObject zzXa;
            final int zzXk;

            protected void zza(zze zze1)
            {
label0:
                {
                    synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS))
                    {
                        if (RemoteMediaPlayer.zza(zzWS, zzXk) != -1)
                        {
                            break label0;
                        }
                        zzb(zzp(new Status(0)));
                    }
                    return;
                }
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXk, zzWZ, null, 0, null, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                exception;
                zze1;
                JVM INSTR monitorexit ;
                throw exception;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzXk = i;
                zzWT = googleapiclient1;
                zzWZ = l;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return queueJumpToItem(googleapiclient, i, -1L, jsonobject);
    }

    public PendingResult queueLoad(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], int i, int j, long l, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, i, j, l, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final MediaQueueItem zzWW[];
            final int zzWX;
            final int zzWY;
            final long zzWZ;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzWW, zzWX, zzWY, zzWZ, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzWW = amediaqueueitem;
                zzWX = i;
                zzWY = j;
                zzWZ = l;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueLoad(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], int i, int j, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return queueLoad(googleapiclient, amediaqueueitem, i, j, -1L, jsonobject);
    }

    public PendingResult queueMoveItemToNewIndex(GoogleApiClient googleapiclient, int i, int j, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, j, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final int zzXk;
            final int zzXl;

            protected void zza(zze zze1)
            {
                boolean flag = false;
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                int k = RemoteMediaPlayer.zza(zzWS, zzXk);
                if (k != -1)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                zzb(zzp(new Status(0)));
                zze1;
                JVM INSTR monitorexit ;
                return;
                if (zzXl >= 0)
                {
                    break MISSING_BLOCK_LABEL_106;
                }
                zzb(zzp(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[] {
                    Integer.valueOf(zzXl)
                }))));
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                if (k != zzXl)
                {
                    break MISSING_BLOCK_LABEL_134;
                }
                zzb(zzp(new Status(0)));
                zze1;
                JVM INSTR monitorexit ;
                return;
                if (zzXl <= k) goto _L2; else goto _L1
_L1:
                k = zzXl + 1;
_L3:
                MediaQueueItem mediaqueueitem = zzWS.getMediaStatus().getQueueItem(k);
                k = ((flag) ? 1 : 0);
                if (mediaqueueitem == null)
                {
                    break MISSING_BLOCK_LABEL_178;
                }
                k = mediaqueueitem.getItemId();
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                zzm zzm1 = RemoteMediaPlayer.zzg(zzWS);
                zzo zzo = zzXu;
                int l = zzXk;
                JSONObject jsonobject1 = zzXa;
                zzm1.zza(zzo, new int[] {
                    l
                }, k, jsonobject1);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L4:
                zze1;
                JVM INSTR monitorexit ;
                return;
_L2:
                k = zzXl;
                  goto _L3
                zzm1;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L4
                zzm1;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw zzm1;
                  goto _L3
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzXk = i;
                zzXl = j;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueNext(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, 0, -1L, null, 1, null, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queuePrev(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, 0, -1L, null, -1, null, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueRemoveItem(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final int zzXk;

            protected void zza(zze zze1)
            {
label0:
                {
                    synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS))
                    {
                        if (RemoteMediaPlayer.zza(zzWS, zzXk) != -1)
                        {
                            break label0;
                        }
                        zzb(zzp(new Status(0)));
                    }
                    return;
                }
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                zzm zzm1 = RemoteMediaPlayer.zzg(zzWS);
                zzo zzo = zzXu;
                int j = zzXk;
                JSONObject jsonobject1 = zzXa;
                zzm1.zza(zzo, new int[] {
                    j
                }, jsonobject1);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                exception;
                zze1;
                JVM INSTR monitorexit ;
                throw exception;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzXk = i;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueRemoveItems(GoogleApiClient googleapiclient, int ai[], JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, ai, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final int zzXf[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXf, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXf = ai;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueReorderItems(GoogleApiClient googleapiclient, int ai[], int i, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, ai, i, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final int zzXc;
            final int zzXg[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXg, zzXc, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXg = ai;
                zzXc = i;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueSetRepeatMode(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, i, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final int zzWY;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, 0, -1L, null, 0, Integer.valueOf(zzWY), zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzWY = i;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueUpdateItems(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final MediaQueueItem zzXe[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, 0, -1L, zzXe, 0, null, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXe = amediaqueueitem;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                super(googleapiclient);
            }
        });
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l)
    {
        return seek(googleapiclient, l, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i)
    {
        return seek(googleapiclient, l, i, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, l, i, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final long zzXm;
            final int zzXn;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXm, zzXn, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXm = l;
                zzXn = i;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setActiveMediaTracks(GoogleApiClient googleapiclient, long al[])
    {
        if (al == null)
        {
            throw new IllegalArgumentException("trackIds cannot be null");
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, al) {

                final RemoteMediaPlayer zzWS;
                final GoogleApiClient zzWT;
                final long zzWU[];

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                    RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzWU);
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    zzb(zzp(new Status(2100)));
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                    throw obj;
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zze)zzb1);
                }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzWU = al;
                super(googleapiclient);
            }
            });
        }
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        zzWQ = onmetadataupdatedlistener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onpreloadstatusupdatedlistener)
    {
        zzWO = onpreloadstatusupdatedlistener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onqueuestatusupdatedlistener)
    {
        zzWP = onqueuestatusupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        zzWR = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, flag, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;
            final boolean zzXp;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXp, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
_L2:
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
                obj;
                  goto _L2
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXp = flag;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d)
        throws IllegalArgumentException
    {
        return setStreamVolume(googleapiclient, d, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, d, jsonobject) {

                final RemoteMediaPlayer zzWS;
                final GoogleApiClient zzWT;
                final JSONObject zzXa;
                final double zzXo;

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                    RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXo, zzXa);
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
_L2:
                    zzb(zzp(new Status(2100)));
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                    throw obj;
                    obj;
                      goto _L2
                    obj;
                      goto _L2
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zze)zzb1);
                }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXo = d;
                zzXa = jsonobject;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult setTextTrackStyle(GoogleApiClient googleapiclient, TextTrackStyle texttrackstyle)
    {
        if (texttrackstyle == null)
        {
            throw new IllegalArgumentException("trackStyle cannot be null");
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, texttrackstyle) {

                final RemoteMediaPlayer zzWS;
                final GoogleApiClient zzWT;
                final TextTrackStyle zzWV;

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                    RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzWV);
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    zzb(zzp(new Status(2100)));
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzWS).zza(null);
                    throw obj;
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zze)zzb1);
                }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzWV = texttrackstyle;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult stop(GoogleApiClient googleapiclient)
    {
        return stop(googleapiclient, null);
    }

    public PendingResult stop(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzWS;
            final GoogleApiClient zzWT;
            final JSONObject zzXa;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
                RemoteMediaPlayer.zzg(zzWS).zzb(zzXu, zzXa);
                RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zzb(zzp(new Status(2100)));
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzWS).zza(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzWS = RemoteMediaPlayer.this;
                zzWT = googleapiclient1;
                zzXa = jsonobject;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/cast/RemoteMediaPlayer$zzb$1

/* anonymous class */
    class zzb._cls1
        implements zzo
    {

        final zzb zzXv;

        public void zza(long l, int i, Object obj)
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
            } else
            {
                obj = null;
            }
            zzXv.zzb(new zzc(new Status(i), ((JSONObject) (obj))));
        }

        public void zzy(long l)
        {
            zzXv.zzb(zzXv.zzp(new Status(2103)));
        }

            
            {
                zzXv = zzb1;
                super();
            }
    }

}
