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

    private static final String NAMESPACE = zzf.zzbM("com.google.cast.media");
    private final List zzVQ = new ArrayList();
    private long zzXA;
    private MediaStatus zzXB;
    private final zzp zzXC = new zzp(0x5265c00L);
    private final zzp zzXD = new zzp(0x5265c00L);
    private final zzp zzXE = new zzp(0x5265c00L);
    private final zzp zzXF = new zzp(0x5265c00L);
    private final zzp zzXG = new zzp(0x5265c00L);
    private final zzp zzXH = new zzp(0x5265c00L);
    private final zzp zzXI = new zzp(0x5265c00L);
    private final zzp zzXJ = new zzp(0x5265c00L);
    private final zzp zzXK = new zzp(0x5265c00L);
    private final zzp zzXL = new zzp(0x5265c00L);
    private final zzp zzXM = new zzp(0x5265c00L);
    private final zzp zzXN = new zzp(0x5265c00L);
    private final zzp zzXO = new zzp(0x5265c00L);
    private final zzp zzXP = new zzp(0x5265c00L);

    public zzm(String s)
    {
        super(NAMESPACE, "MediaControlChannel", s, 1000L);
        zzVQ.add(zzXC);
        zzVQ.add(zzXD);
        zzVQ.add(zzXE);
        zzVQ.add(zzXF);
        zzVQ.add(zzXG);
        zzVQ.add(zzXH);
        zzVQ.add(zzXI);
        zzVQ.add(zzXJ);
        zzVQ.add(zzXK);
        zzVQ.add(zzXL);
        zzVQ.add(zzXM);
        zzVQ.add(zzXN);
        zzVQ.add(zzXO);
        zzVQ.add(zzXP);
        zzmM();
    }

    private void zza(long l, JSONObject jsonobject)
        throws JSONException
    {
        int i;
        int j;
label0:
        {
            j = 1;
            boolean flag1 = zzXC.zzB(l);
            boolean flag;
            if (zzXG.zzmO() && !zzXG.zzB(l))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (zzXH.zzmO())
            {
                flag = j;
                if (!zzXH.zzB(l))
                {
                    break label0;
                }
            }
            if (zzXI.zzmO() && !zzXI.zzB(l))
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
        if (flag1 || zzXB == null)
        {
            zzXB = new MediaStatus(jsonobject);
            zzXA = SystemClock.elapsedRealtime();
            i = 31;
        } else
        {
            i = zzXB.zza(jsonobject, j);
        }
        if ((i & 1) != 0)
        {
            zzXA = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0)
        {
            zzXA = SystemClock.elapsedRealtime();
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
        for (jsonobject = zzVQ.iterator(); jsonobject.hasNext(); ((zzp)jsonobject.next()).zzc(l, 0)) { }
    }

    private void zzmM()
    {
        zzXA = 0L;
        zzXB = null;
        for (Iterator iterator = zzVQ.iterator(); iterator.hasNext(); ((zzp)iterator.next()).clear()) { }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        long l1;
        MediaInfo mediainfo;
        for (mediainfo = getMediaInfo(); mediainfo == null || zzXA == 0L;)
        {
            return 0L;
        }

        double d = zzXB.getPlaybackRate();
        long l2 = zzXB.getStreamPosition();
        int i = zzXB.getPlayerState();
        if (d == 0.0D || i != 2)
        {
            return l2;
        }
        l = SystemClock.elapsedRealtime() - zzXA;
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
        if (zzXB == null)
        {
            return null;
        } else
        {
            return zzXB.getMediaInfo();
        }
    }

    public MediaStatus getMediaStatus()
    {
        return zzXB;
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
        long l = zzmu();
        zzXJ.zza(l, zzo);
        zzU(true);
        try
        {
            jsonobject.put("requestId", l);
            jsonobject.put("type", "GET_STATUS");
            if (zzXB != null)
            {
                jsonobject.put("mediaSessionId", zzXB.zzmc());
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
        l = zzmu();
        zzXH.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzmc());
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

    public long zza(zzo zzo, int i, MediaQueueItem amediaqueueitem[], int j, Integer integer, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmu();
        zzXN.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_UPDATE");
        jsonobject1.put("mediaSessionId", zzmc());
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        jsonobject1.put("currentItemId", i);
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        jsonobject1.put("jump", j);
        if (amediaqueueitem == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (amediaqueueitem.length <= 0)
        {
            break MISSING_BLOCK_LABEL_147;
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
        JVM INSTR tableswitch 0 3: default 279
    //                   0 219
    //                   1 234
    //                   2 249
    //                   3 264;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_264;
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
        zza(jsonobject1.toString(), l, null);
        return l;
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
        l1 = zzmu();
        zzXG.zza(l1, zzo);
        zzU(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", zzmc());
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
        l1 = zzmu();
        zzXC.zza(l1, zzo);
        zzU(true);
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
        l = zzmu();
        zzXL.zza(l, zzo);
        zzU(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        if (texttrackstyle == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        jsonobject.put("textTrackStyle", texttrackstyle.toJson());
        jsonobject.put("mediaSessionId", zzmc());
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
        l = zzmu();
        zzXD.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", zzmc());
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
        l = zzmu();
        zzXI.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzmc());
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
        l = zzmu();
        zzXP.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_REORDER");
        jsonobject1.put("mediaSessionId", zzmc());
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
        l = zzmu();
        zzXO.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_REMOVE");
        jsonobject1.put("mediaSessionId", zzmc());
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
        l = zzmu();
        zzXK.zza(l, zzo);
        zzU(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        jsonobject.put("mediaSessionId", zzmc());
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

    public long zza(zzo zzo, MediaQueueItem amediaqueueitem[], int i, int j, JSONObject jsonobject)
        throws IOException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (amediaqueueitem == null || amediaqueueitem.length == 0)
        {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= amediaqueueitem.length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid startIndex: ").append(i).toString());
        }
        jsonobject1 = new JSONObject();
        l = zzmu();
        zzXC.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
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
        JVM INSTR tableswitch 0 3: default 323
    //                   0 237
    //                   1 278
    //                   2 293
    //                   3 308;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_308;
_L3:
        try
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid repeat mode: ").append(j).toString());
        }
        // Misplaced declaration of an exception variable
        catch (zzo zzo) { }
_L9:
        zza(jsonobject1.toString(), l, null);
        return l;
_L4:
        jsonobject1.put("repeatMode", "REPEAT_OFF");
_L10:
        jsonobject1.put("startIndex", i);
        if (jsonobject == null) goto _L9; else goto _L8
_L8:
        jsonobject1.put("customData", jsonobject);
          goto _L9
_L5:
        jsonobject1.put("repeatMode", "REPEAT_ALL");
          goto _L10
_L6:
        jsonobject1.put("repeatMode", "REPEAT_SINGLE");
          goto _L10
        jsonobject1.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
          goto _L10
    }

    public long zza(zzo zzo, MediaQueueItem amediaqueueitem[], int i, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        if (amediaqueueitem == null || amediaqueueitem.length == 0)
        {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        jsonobject1 = new JSONObject();
        l = zzmu();
        zzXM.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "QUEUE_INSERT");
        jsonobject1.put("mediaSessionId", zzmc());
        zzo = new JSONArray();
        int j = 0;
_L2:
        if (j >= amediaqueueitem.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzo.put(j, amediaqueueitem[j].toJson());
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("items", zzo);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_148;
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

    public long zzb(zzo zzo, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmu();
        zzXF.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "STOP");
        jsonobject1.put("mediaSessionId", zzmc());
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
        for (Iterator iterator = zzVQ.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzc(l, i)) { }
    }

    public final void zzbJ(String s)
    {
        zzWK.zzb("message received: %s", new Object[] {
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
            zzXB = null;
            onStatusUpdated();
            onMetadataUpdated();
            onQueueStatusUpdated();
            onPreloadStatusUpdated();
            zzXJ.zzc(l, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzWK.zzf("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
        }
        return;
        if (((String) (obj1)).equals("INVALID_PLAYER_STATE"))
        {
            zzWK.zzf("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (obj1 = zzVQ.iterator(); ((Iterator) (obj1)).hasNext(); ((zzp)((Iterator) (obj1)).next()).zzc(l, 2100, obj)) { }
            break MISSING_BLOCK_LABEL_354;
        }
        if (((String) (obj1)).equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzXC.zzc(l, 2100, obj);
            return;
        }
        if (((String) (obj1)).equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzXC.zzc(l, 2101, obj);
            return;
        }
        if (((String) (obj1)).equals("INVALID_REQUEST"))
        {
            zzWK.zzf("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (Iterator iterator = zzVQ.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzc(l, 2100, obj)) { }
        }
    }

    public long zzc(zzo zzo, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzmu();
        zzXE.zza(l, zzo);
        zzU(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", zzmc());
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

    public long zzmc()
        throws IllegalStateException
    {
        if (zzXB == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return zzXB.zzmc();
        }
    }

    public void zzmt()
    {
        super.zzmt();
        zzmM();
    }

    protected boolean zzz(long l)
    {
        for (Iterator iterator = zzVQ.iterator(); iterator.hasNext(); ((zzp)iterator.next()).zzd(l, 2102)) { }
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

}
