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

        final RemoteMediaPlayer zzVb;
        private GoogleApiClient zzVy;
        private long zzVz;

        public void zza(String s, String s1, long l, String s2)
            throws IOException
        {
            if (zzVy == null)
            {
                throw new IOException("No GoogleApiClient available");
            } else
            {
                Cast.CastApi.sendMessage(zzVy, s, s1).setResultCallback(new zza(this, l));
                return;
            }
        }

        public void zzb(GoogleApiClient googleapiclient)
        {
            zzVy = googleapiclient;
        }

        public long zzme()
        {
            long l = zzVz + 1L;
            zzVz = l;
            return l;
        }

        public zza()
        {
            zzVb = RemoteMediaPlayer.this;
            super();
            zzVz = 0L;
        }
    }

    private final class zza.zza
        implements ResultCallback
    {

        private final long zzVA;
        final zza zzVB;

        public void onResult(Result result)
        {
            zzr((Status)result);
        }

        public void zzr(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zzg(zzVB.zzVb).zzb(zzVA, status.getStatusCode());
            }
        }

        zza.zza(zza zza1, long l)
        {
            zzVB = zza1;
            super();
            zzVA = l;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb
    {

        zzo zzVC;

        public Result zzb(Status status)
        {
            return zzs(status);
        }

        public MediaChannelResult zzs(Status status)
        {
            return new MediaChannelResult(this, status) {

                final Status zzQs;
                final zzb zzVD;

                public JSONObject getCustomData()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzVD = zzb1;
                zzQs = status;
                super();
            }
            };
        }

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzVC = new _cls1(this);
        }
    }

    private static final class zzc
        implements MediaChannelResult
    {

        private final Status zzQA;
        private final JSONObject zzUl;

        public JSONObject getCustomData()
        {
            return zzUl;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        zzc(Status status, JSONObject jsonobject)
        {
            zzQA = status;
            zzUl = jsonobject;
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
    private final zzm zzUV = new zzm(null) {

        final RemoteMediaPlayer zzVb;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.zzb(zzVb);
        }

        protected void onPreloadStatusUpdated()
        {
            RemoteMediaPlayer.zzd(zzVb);
        }

        protected void onQueueStatusUpdated()
        {
            RemoteMediaPlayer.zzc(zzVb);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.zza(zzVb);
        }

            
            {
                zzVb = RemoteMediaPlayer.this;
                super(s);
            }
    };
    private final zza zzUW = new zza();
    private OnPreloadStatusUpdatedListener zzUX;
    private OnQueueStatusUpdatedListener zzUY;
    private OnMetadataUpdatedListener zzUZ;
    private OnStatusUpdatedListener zzVa;
    private final Object zzpc = new Object();

    public RemoteMediaPlayer()
    {
        zzUV.zza(zzUW);
    }

    private void onMetadataUpdated()
    {
        if (zzUZ != null)
        {
            zzUZ.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated()
    {
        if (zzUX != null)
        {
            zzUX.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated()
    {
        if (zzUY != null)
        {
            zzUY.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (zzVa != null)
        {
            zzVa.onStatusUpdated();
        }
    }

    static int zza(RemoteMediaPlayer remotemediaplayer, int i)
    {
        return remotemediaplayer.zzaP(i);
    }

    static void zza(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onStatusUpdated();
    }

    private int zzaP(int i)
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
        return remotemediaplayer.zzpc;
    }

    static zza zzf(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzUW;
    }

    static zzm zzg(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzUV;
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (zzpc)
        {
            l = zzUV.getApproximateStreamPosition();
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
        synchronized (zzpc)
        {
            mediainfo = zzUV.getMediaInfo();
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
        synchronized (zzpc)
        {
            mediastatus = zzUV.getMediaStatus();
        }
        return mediastatus;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getNamespace()
    {
        return zzUV.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (zzpc)
        {
            l = zzUV.getStreamDuration();
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

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final MediaInfo zzVo;
            final boolean zzVp;
            final long zzVq;
            final long zzVr[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVo, zzVp, zzVq, zzVr, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVo = mediainfo;
                zzVp = flag;
                zzVq = l;
                zzVr = al;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        zzUV.zzbJ(s1);
    }

    public PendingResult pause(GoogleApiClient googleapiclient)
    {
        return pause(googleapiclient, null);
    }

    public PendingResult pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
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

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zzc(zzVC, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
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

    public PendingResult queueInsertItems(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], int i, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, i, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final MediaQueueItem zzVj[];
            final int zzVk;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVj, zzVk, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVj = amediaqueueitem;
                zzVk = i;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueJumpToItem(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final int zzVs;

            protected void zza(zze zze1)
            {
label0:
                {
                    synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb))
                    {
                        if (RemoteMediaPlayer.zza(zzVb, zzVs) != -1)
                        {
                            break label0;
                        }
                        zza(((Result) (zzs(new Status(0)))));
                    }
                    return;
                }
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVs, null, 0, null, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
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
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVs = i;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueLoad(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], int i, int j, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, i, j, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final MediaQueueItem zzVf[];
            final int zzVg;
            final int zzVh;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVf, zzVg, zzVh, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVf = amediaqueueitem;
                zzVg = i;
                zzVh = j;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueMoveItemToNewIndex(GoogleApiClient googleapiclient, int i, int j, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, j, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final int zzVs;
            final int zzVt;

            protected void zza(zze zze1)
            {
                boolean flag = false;
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                int k = RemoteMediaPlayer.zza(zzVb, zzVs);
                if (k != -1)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                zza(((Result) (zzs(new Status(0)))));
                zze1;
                JVM INSTR monitorexit ;
                return;
                if (zzVt >= 0)
                {
                    break MISSING_BLOCK_LABEL_106;
                }
                zza(((Result) (zzs(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[] {
                    Integer.valueOf(zzVt)
                }))))));
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                if (k != zzVt)
                {
                    break MISSING_BLOCK_LABEL_134;
                }
                zza(((Result) (zzs(new Status(0)))));
                zze1;
                JVM INSTR monitorexit ;
                return;
                if (zzVt <= k) goto _L2; else goto _L1
_L1:
                k = zzVt + 1;
_L3:
                MediaQueueItem mediaqueueitem = zzVb.getMediaStatus().getQueueItem(k);
                k = ((flag) ? 1 : 0);
                if (mediaqueueitem == null)
                {
                    break MISSING_BLOCK_LABEL_178;
                }
                k = mediaqueueitem.getItemId();
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                zzm zzm1 = RemoteMediaPlayer.zzg(zzVb);
                zzo zzo = zzVC;
                int l = zzVs;
                JSONObject jsonobject1 = zzVi;
                zzm1.zza(zzo, new int[] {
                    l
                }, k, jsonobject1);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L4:
                zze1;
                JVM INSTR monitorexit ;
                return;
_L2:
                k = zzVt;
                  goto _L3
                zzm1;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L4
                zzm1;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw zzm1;
                  goto _L3
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVs = i;
                zzVt = j;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueNext(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, 0, null, 1, null, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queuePrev(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, 0, null, -1, null, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueRemoveItem(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i, googleapiclient, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final int zzVs;

            protected void zza(zze zze1)
            {
label0:
                {
                    synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb))
                    {
                        if (RemoteMediaPlayer.zza(zzVb, zzVs) != -1)
                        {
                            break label0;
                        }
                        zza(((Result) (zzs(new Status(0)))));
                    }
                    return;
                }
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                zzm zzm1 = RemoteMediaPlayer.zzg(zzVb);
                zzo zzo = zzVC;
                int j = zzVs;
                JSONObject jsonobject1 = zzVi;
                zzm1.zza(zzo, new int[] {
                    j
                }, jsonobject1);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
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
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVs = i;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueRemoveItems(GoogleApiClient googleapiclient, int ai[], JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, ai, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final int zzVm[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVm, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVm = ai;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueReorderItems(GoogleApiClient googleapiclient, int ai[], int i, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, ai, i, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final int zzVk;
            final int zzVn[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVn, zzVk, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVn = ai;
                zzVk = i;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueSetRepeatMode(GoogleApiClient googleapiclient, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, i, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final int zzVh;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, 0, null, 0, Integer.valueOf(zzVh), zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVh = i;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult queueUpdateItems(GoogleApiClient googleapiclient, MediaQueueItem amediaqueueitem[], JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, amediaqueueitem, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final MediaQueueItem zzVl[];

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, 0, zzVl, 0, null, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVl = amediaqueueitem;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
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

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final long zzVu;
            final int zzVv;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVu, zzVv, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVu = l;
                zzVv = i;
                zzVi = jsonobject;
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

                final RemoteMediaPlayer zzVb;
                final GoogleApiClient zzVc;
                final long zzVd[];

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                    RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVd);
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    zza(((Result) (zzs(new Status(2100)))));
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
                    throw obj;
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zze)zzb1);
                }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVd = al;
                super(googleapiclient);
            }
            });
        }
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        zzUZ = onmetadataupdatedlistener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onpreloadstatusupdatedlistener)
    {
        zzUX = onpreloadstatusupdatedlistener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onqueuestatusupdatedlistener)
    {
        zzUY = onqueuestatusupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        zzVa = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, flag, jsonobject) {

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;
            final boolean zzVx;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVx, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
_L2:
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
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
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVx = flag;
                zzVi = jsonobject;
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

                final RemoteMediaPlayer zzVb;
                final GoogleApiClient zzVc;
                final JSONObject zzVi;
                final double zzVw;

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                    RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVw, zzVi);
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
_L2:
                    zza(((Result) (zzs(new Status(2100)))));
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
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
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVw = d;
                zzVi = jsonobject;
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

                final RemoteMediaPlayer zzVb;
                final GoogleApiClient zzVc;
                final TextTrackStyle zzVe;

                protected void zza(zze zze1)
                {
                    zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                    zze1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                    RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVe);
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                    zze1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    zza(((Result) (zzs(new Status(2100)))));
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
                      goto _L1
                    obj;
                    zze1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzf(zzVb).zzb(null);
                    throw obj;
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zze)zzb1);
                }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVe = texttrackstyle;
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

            final RemoteMediaPlayer zzVb;
            final GoogleApiClient zzVc;
            final JSONObject zzVi;

            protected void zza(zze zze1)
            {
                zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
                zze1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
                RemoteMediaPlayer.zzg(zzVb).zzb(zzVC, zzVi);
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
                zze1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                zza(((Result) (zzs(new Status(2100)))));
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                  goto _L1
                obj;
                zze1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzf(zzVb).zzb(null);
                throw obj;
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zze)zzb1);
            }

            
            {
                zzVb = RemoteMediaPlayer.this;
                zzVc = googleapiclient1;
                zzVi = jsonobject;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/cast/RemoteMediaPlayer$zzb$1

/* anonymous class */
    class zzb._cls1
        implements zzo
    {

        final zzb zzVD;

        public void zza(long l, int i, Object obj)
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
            } else
            {
                obj = null;
            }
            zzVD.zza(new zzc(new Status(i), ((JSONObject) (obj))));
        }

        public void zzy(long l)
        {
            zzVD.zza(zzVD.zzs(new Status(2103)));
        }

            
            {
                zzVD = zzb1;
                super();
            }
    }

}
