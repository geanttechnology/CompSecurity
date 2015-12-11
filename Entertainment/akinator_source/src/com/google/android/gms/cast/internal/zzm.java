// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzc, zzf, zzp, zzl, 
//            zzo

public class zzm extends zzc
{

    private static final String NAMESPACE = zzf.zzbN("com.google.cast.media");
    private final List zzXI = new ArrayList();
    private final zzp zzZA = new zzp(0x5265c00L);
    private final zzp zzZB = new zzp(0x5265c00L);
    private final zzp zzZC = new zzp(0x5265c00L);
    private final zzp zzZD = new zzp(0x5265c00L);
    private final zzp zzZE = new zzp(0x5265c00L);
    private final zzp zzZF = new zzp(0x5265c00L);
    private long zzZq;
    private MediaStatus zzZr;
    private final zzp zzZs = new zzp(0x5265c00L);
    private final zzp zzZt = new zzp(0x5265c00L);
    private final zzp zzZu = new zzp(0x5265c00L);
    private final zzp zzZv = new zzp(0x5265c00L);
    private final zzp zzZw = new zzp(0x5265c00L);
    private final zzp zzZx = new zzp(0x5265c00L);
    private final zzp zzZy = new zzp(0x5265c00L);
    private final zzp zzZz = new zzp(0x5265c00L);

    public zzm(String s)
    {
        super(NAMESPACE, "MediaControlChannel", s, 1000L);
        zzXI.add(zzZs);
        zzXI.add(zzZt);
        zzXI.add(zzZu);
        zzXI.add(zzZv);
        zzXI.add(zzZw);
        zzXI.add(zzZx);
        zzXI.add(zzZy);
        zzXI.add(zzZz);
        zzXI.add(zzZA);
        zzXI.add(zzZB);
        zzXI.add(zzZC);
        zzXI.add(zzZD);
        zzXI.add(zzZE);
        zzXI.add(zzZF);
        zzni();
    }

    private void zza(long l, JSONObject jsonobject)
        throws JSONException
    {
        int i;
        int j;
label0:
        {
            j = 1;
            boolean flag1 = zzZs.zzB(l);
            boolean flag;
            if (zzZw.zznk() && !zzZw.zzB(l))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (zzZx.zznk())
            {
                flag = j;
                if (!zzZx.zzB(l))
                {
                    break label0;
                }
            }
            if (zzZy.zznk() && !zzZy.zzB(l))
            {
                flag = j;
            } else
            {
                flag = false;
            }
        }
        if (i != 0)
        {
            i = 2;
        } else
        {
            i = 0;
        }
        j = i;
        if (flag)
        {
            j = i | 1;
        }
        if (flag1 || zzZr == null)
        {
            zzZr = new MediaStatus(jsonobject);
            zzZq = SystemClock.elapsedRealtime();
            i = 31;
        } else
        {
            i = zzZr.zza(jsonobject, j);
        }
        if ((i & 1) != 0)
        {
            zzZq = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0)
        {
            zzZq = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0)
        {
            onMetadataUpdated();
        }
        if ((i & 8) != 0)
        {
            onQueueStatusUpdated();
        }
        if ((i & 0x10) != 0)
        {
            onPreloadStatusUpdated();
        }
        for (jsonobject = zzXI.iterator(); jsonobject.hasNext(); ((zzp)jsonobject.next()).zzc(l, 0)) { }
    }

    private void zzni()
    {
        zzZq = 0L;
        zzZr = null;
        for (Iterator iterator = zzXI.iterator(); iterator.hasNext(); ((zzp)iterator.next()).clear()) { }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        long l1;
        MediaInfo mediainfo;
        for (mediainfo = getMediaInfo(); mediainfo == null || zzZq == 0L;)
        {
            return 0L;
        }

        double d = zzZr.getPlaybackRate();
        long l2 = zzZr.getStreamPosition();
        int i = zzZr.getPlayerState();
        if (d == 0.0D || i != 2)
        {
            return l2;
        }
        l = SystemClock.elapsedRealtime() - zzZq;
        if (l < 0L)
        {
            l = 0L;
        }
        if (l == 0L)
        {
            return l2;
        }
        l1 = mediainfo.getStreamDuration();
        l = l2 + (long)((double)l * d);
        if (l1 <= 0L || l <= l1) goto _L2; else goto _L1
_L1:
        l = l1;
_L4:
        return l;
_L2:
        if (l < 0L)
        {
            l = 0L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public MediaInfo getMediaInfo()
    {
        if (zzZr == null)
        {
            return null;
        } else
        {
            return zzZr.getMediaInfo();
        }
    }

    public MediaStatus getMediaStatus()
    {
        return zzZr;
    }

    public long getStreamDuration()
    {
        MediaInfo mediainfo = getMediaInfo();
        if (mediainfo != null)
        {
            return mediainfo.getStreamDuration();
        } else
        {
            return 0L;
        }
    }

    protected void onMetadataUpdated()
    {
    }

    protected void onPreloadStatusUpdated()
    {
    }

    protected void onQueueStatusUpdated()
    {
    }

    protected void onStatusUpdated()
    {
    }

    public long zza(zzo zzo)
        throws IOException
    {
        JSONObject jsonobject = new JSONObject();
        long l = zzmQ();
        zzZz.zza(l, zzo);
        zzV(true);
        try
        {
            jsonobject.put("requestId", l);
            jsonobject.put("type", "GET_STATUS");
            if (zzZr != null)
            {
                jsonobject.put("mediaSessionId", zzZr.zzmy());
            }
        }
        // Misplaced declaration of an exception variable
        catch (zzo zzo) { }
        zza(jsonobject.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, double d, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        }
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZx.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzmy());
        zzo = new JSONObject();
        zzo.put("level", d);
        jsonobject1.put("volume", zzo);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, int i, long l, MediaQueueItem amediaqueueitem[], int j, Integer integer, 
            JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        if (l != -1L && l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("playPosition cannot be negative: ").append(l).toString());
        }
        jsonobject1 = new JSONObject();
        l1 = zzmQ();
        zzZD.zza(l1, zzo);
        zzV(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "QUEUE_UPDATE");
        jsonobject1.put("mediaSessionId", zzmy());
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        jsonobject1.put("currentItemId", i);
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        jsonobject1.put("jump", j);
        if (amediaqueueitem == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        if (amediaqueueitem.length <= 0)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        zzo = new JSONArray();
        i = 0;
_L2:
        if (i >= amediaqueueitem.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(i, amediaqueueitem[i].toJson());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("items", zzo);
        if (integer == null) goto _L4; else goto _L3
_L3:
        integer.intValue();
        JVM INSTR tableswitch 0 3: default 344
    //                   0 284
    //                   1 299
    //                   2 314
    //                   3 329;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_329;
_L4:
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        jsonobject1.put("currentTime", zzf.zzA(l));
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
_L6:
        jsonobject1.put("repeatMode", "REPEAT_OFF");
          goto _L4
_L7:
        jsonobject1.put("repeatMode", "REPEAT_ALL");
          goto _L4
_L8:
        jsonobject1.put("repeatMode", "REPEAT_SINGLE");
          goto _L4
        jsonobject1.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
          goto _L4
    }

    public long zza(zzo zzo, long l, int i, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = zzmQ();
        zzZw.zza(l1, zzo);
        zzV(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", zzmy());
        jsonobject1.put("currentTime", zzf.zzA(l));
        if (i != 1) goto _L2; else goto _L1
_L1:
        jsonobject1.put("resumeState", "PLAYBACK_START");
_L4:
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
_L2:
        if (i != 2) goto _L4; else goto _L3
_L3:
        jsonobject1.put("resumeState", "PLAYBACK_PAUSE");
          goto _L4
    }

    public long zza(zzo zzo, MediaInfo mediainfo, boolean flag, long l, long al[], JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = zzmQ();
        zzZs.zza(l1, zzo);
        zzV(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "LOAD");
        jsonobject1.put("media", mediainfo.toJson());
        jsonobject1.put("autoplay", flag);
        jsonobject1.put("currentTime", zzf.zzA(l));
        if (al == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        zzo = new JSONArray();
        int i = 0;
_L2:
        if (i >= al.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(i, al[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("activeTrackIds", zzo);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
    }

    public long zza(zzo zzo, TextTrackStyle texttrackstyle)
        throws IOException
    {
        JSONObject jsonobject;
        long l;
        jsonobject = new JSONObject();
        l = zzmQ();
        zzZB.zza(l, zzo);
        zzV(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        if (texttrackstyle == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        jsonobject.put("textTrackStyle", texttrackstyle.toJson());
        jsonobject.put("mediaSessionId", zzmy());
_L2:
        zza(jsonobject.toString(), l, null);
        return l;
        zzo;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public long zza(zzo zzo, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZt.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", zzmy());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, boolean flag, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZy.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzmy());
        zzo = new JSONObject();
        zzo.put("muted", flag);
        jsonobject1.put("volume", zzo);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, int ai[], int i, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (ai == null || ai.length == 0)
        {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZF.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_REORDER");
        jsonobject1.put("mediaSessionId", zzmy());
        zzo = new JSONArray();
        int j = 0;
_L2:
        if (j >= ai.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(j, ai[j]);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("itemIds", zzo);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        jsonobject1.put("insertBefore", i);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, int ai[], JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (ai == null || ai.length == 0)
        {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZE.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_REMOVE");
        jsonobject1.put("mediaSessionId", zzmy());
        zzo = new JSONArray();
        int i = 0;
_L2:
        if (i >= ai.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(i, ai[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("itemIds", zzo);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, long al[])
        throws IOException
    {
        JSONObject jsonobject;
        long l;
        jsonobject = new JSONObject();
        l = zzmQ();
        zzZA.zza(l, zzo);
        zzV(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        jsonobject.put("mediaSessionId", zzmy());
        zzo = new JSONArray();
        int i = 0;
_L2:
        if (i >= al.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(i, al[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            jsonobject.put("activeTrackIds", zzo);
        }
        // Misplaced declaration of an exception variable
        catch (zzo zzo) { }
        zza(jsonobject.toString(), l, null);
        return l;
    }

    public long zza(zzo zzo, MediaQueueItem amediaqueueitem[], int i, int j, int k, long l, 
            JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        if (amediaqueueitem == null || amediaqueueitem.length == 0)
        {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        if (j != 0 && k != -1)
        {
            throw new IllegalArgumentException("can not set both currentItemId and currentItemIndexInItemsToInsert");
        }
        if (k != -1 && (k < 0 || k >= amediaqueueitem.length))
        {
            throw new IllegalArgumentException(String.format("currentItemIndexInItemsToInsert %d out of range [0, %d).", new Object[] {
                Integer.valueOf(k), Integer.valueOf(amediaqueueitem.length)
            }));
        }
        if (l != -1L && l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("playPosition can not be negative: ").append(l).toString());
        }
        jsonobject1 = new JSONObject();
        l1 = zzmQ();
        zzZC.zza(l1, zzo);
        zzV(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "QUEUE_INSERT");
        jsonobject1.put("mediaSessionId", zzmy());
        zzo = new JSONArray();
        int i1 = 0;
_L2:
        if (i1 >= amediaqueueitem.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(i1, amediaqueueitem[i1].toJson());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("items", zzo);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        jsonobject1.put("insertBefore", i);
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        jsonobject1.put("currentItemId", j);
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        jsonobject1.put("currentItemIndex", k);
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_323;
        }
        jsonobject1.put("currentTime", zzf.zzA(l));
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
    }

    public long zza(zzo zzo, MediaQueueItem amediaqueueitem[], int i, int j, long l, JSONObject jsonobject)
        throws IOException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l1;
        if (amediaqueueitem == null || amediaqueueitem.length == 0)
        {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= amediaqueueitem.length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid startIndex: ").append(i).toString());
        }
        if (l != -1L && l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("playPosition can not be negative: ").append(l).toString());
        }
        jsonobject1 = new JSONObject();
        l1 = zzmQ();
        zzZs.zza(l1, zzo);
        zzV(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "QUEUE_LOAD");
        zzo = new JSONArray();
        int k = 0;
_L2:
        if (k >= amediaqueueitem.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(k, amediaqueueitem[k].toJson());
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("items", zzo);
        j;
        JVM INSTR tableswitch 0 3: default 390
    //                   0 281
    //                   1 345
    //                   2 360
    //                   3 375;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_375;
_L3:
        try
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid repeat mode: ").append(j).toString());
        }
        // Misplaced declaration of an exception variable
        catch (zzo zzo) { }
_L11:
        zza(jsonobject1.toString(), l1, null);
        return l1;
_L4:
        jsonobject1.put("repeatMode", "REPEAT_OFF");
_L12:
        jsonobject1.put("startIndex", i);
        if (l == -1L) goto _L9; else goto _L8
_L8:
        jsonobject1.put("currentTime", zzf.zzA(l));
_L9:
        if (jsonobject == null) goto _L11; else goto _L10
_L10:
        jsonobject1.put("customData", jsonobject);
          goto _L11
_L5:
        jsonobject1.put("repeatMode", "REPEAT_ALL");
          goto _L12
_L6:
        jsonobject1.put("repeatMode", "REPEAT_SINGLE");
          goto _L12
        jsonobject1.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
          goto _L12
    }

    public long zzb(zzo zzo, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZv.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "STOP");
        jsonobject1.put("mediaSessionId", zzmy());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public void zzb(long l, int i)
    {
        for (Iterator iterator = zzXI.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzc(l, i)) { }
    }

    public final void zzbK(String s)
    {
        zzYC.zzb("message received: %s", new Object[] {
            s
        });
        Object obj;
        Object obj1;
        long l;
        obj = new JSONObject(s);
        obj1 = ((JSONObject) (obj)).getString("type");
        l = ((JSONObject) (obj)).optLong("requestId", -1L);
        if (!((String) (obj1)).equals("MEDIA_STATUS"))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = ((JSONObject) (obj)).getJSONArray("status");
        if (((JSONArray) (obj)).length() > 0)
        {
            zza(l, ((JSONArray) (obj)).getJSONObject(0));
            return;
        }
        try
        {
            zzZr = null;
            onStatusUpdated();
            onMetadataUpdated();
            onQueueStatusUpdated();
            onPreloadStatusUpdated();
            zzZz.zzc(l, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzYC.zzf("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
        }
        return;
        if (((String) (obj1)).equals("INVALID_PLAYER_STATE"))
        {
            zzYC.zzf("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (obj1 = zzXI.iterator(); ((Iterator) (obj1)).hasNext(); ((zzp)((Iterator) (obj1)).next()).zzc(l, 2100, obj)) { }
            break MISSING_BLOCK_LABEL_354;
        }
        if (((String) (obj1)).equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzZs.zzc(l, 2100, obj);
            return;
        }
        if (((String) (obj1)).equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzZs.zzc(l, 2101, obj);
            return;
        }
        if (((String) (obj1)).equals("INVALID_REQUEST"))
        {
            zzYC.zzf("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (Iterator iterator = zzXI.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzc(l, 2100, obj)) { }
        }
    }

    public long zzc(zzo zzo, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmQ();
        zzZu.zza(l, zzo);
        zzV(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", zzmy());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzo zzo) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public void zzmP()
    {
        super.zzmP();
        zzni();
    }

    public long zzmy()
        throws IllegalStateException
    {
        if (zzZr == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return zzZr.zzmy();
        }
    }

    protected boolean zzz(long l)
    {
        for (Iterator iterator = zzXI.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzd(l, 2102)) { }
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

}
