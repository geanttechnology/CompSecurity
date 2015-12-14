// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer.extractor.ts.TsExtractor;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsPlaylist, HlsPlaylistParser, Variant, HlsMediaPlaylist, 
//            HlsMasterPlaylist, TsChunk, HlsExtractorWrapper

public class HlsChunkSource
{
    private static class EncryptionKeyChunk extends DataChunk
    {

        public final String iv;
        private byte result[];
        public final int variantIndex;

        protected void consume(byte abyte0[], int i)
            throws IOException
        {
            result = Arrays.copyOf(abyte0, i);
        }

        public byte[] getResult()
        {
            return result;
        }

        public EncryptionKeyChunk(DataSource datasource, DataSpec dataspec, byte abyte0[], String s, int i)
        {
            super(datasource, dataspec, 3, 0, null, abyte0);
            iv = s;
            variantIndex = i;
        }
    }

    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }

    private static class MediaPlaylistChunk extends DataChunk
    {

        private final HlsPlaylistParser playlistParser;
        private final String playlistUrl;
        private HlsMediaPlaylist result;
        public final int variantIndex;

        protected void consume(byte abyte0[], int i)
            throws IOException
        {
            result = (HlsMediaPlaylist)playlistParser.parse(playlistUrl, new ByteArrayInputStream(abyte0, 0, i));
        }

        public HlsMediaPlaylist getResult()
        {
            return result;
        }

        public MediaPlaylistChunk(DataSource datasource, DataSpec dataspec, byte abyte0[], HlsPlaylistParser hlsplaylistparser, int i, String s)
        {
            super(datasource, dataspec, 4, 0, null, abyte0);
            variantIndex = i;
            playlistParser = hlsplaylistparser;
            playlistUrl = s;
        }
    }


    private static final String AAC_FILE_EXTENSION = ".aac";
    public static final int ADAPTIVE_MODE_ABRUPT = 3;
    public static final int ADAPTIVE_MODE_NONE = 0;
    public static final int ADAPTIVE_MODE_SPLICE = 1;
    private static final float BANDWIDTH_FRACTION = 0.8F;
    public static final long DEFAULT_MAX_BUFFER_TO_SWITCH_DOWN_MS = 20000L;
    public static final long DEFAULT_MIN_BUFFER_TO_SWITCH_UP_MS = 5000L;
    public static final long DEFAULT_PLAYLIST_BLACKLIST_MS = 60000L;
    private static final String TAG = "HlsChunkSource";
    private final int adaptiveMode;
    private final AudioCapabilities audioCapabilities;
    private final BandwidthMeter bandwidthMeter;
    private final String baseUri;
    private final DataSource dataSource;
    private long durationUs;
    private byte encryptionIv[];
    private String encryptionIvString;
    private byte encryptionKey[];
    private Uri encryptionKeyUri;
    private boolean live;
    private final long maxBufferDurationToSwitchDownUs;
    private final int maxHeight;
    private final int maxWidth;
    private final long minBufferDurationToSwitchUpUs;
    private final HlsPlaylistParser playlistParser;
    private byte scratchSpace[];
    private int selectedVariantIndex;
    private final long variantBlacklistTimes[];
    private final long variantLastPlaylistLoadTimesMs[];
    private final HlsMediaPlaylist variantPlaylists[];
    private final Variant variants[];

    public HlsChunkSource(DataSource datasource, String s, HlsPlaylist hlsplaylist, BandwidthMeter bandwidthmeter, int ai[], int i, long l, long l1, AudioCapabilities audiocapabilities)
    {
        dataSource = datasource;
        bandwidthMeter = bandwidthmeter;
        adaptiveMode = i;
        audioCapabilities = audiocapabilities;
        minBufferDurationToSwitchUpUs = 1000L * l;
        maxBufferDurationToSwitchDownUs = 1000L * l1;
        baseUri = hlsplaylist.baseUri;
        playlistParser = new HlsPlaylistParser();
        if (hlsplaylist.type == 1)
        {
            variants = (new Variant[] {
                new Variant(0, s, 0, null, -1, -1)
            });
            variantPlaylists = new HlsMediaPlaylist[1];
            variantLastPlaylistLoadTimesMs = new long[1];
            variantBlacklistTimes = new long[1];
            setMediaPlaylist(0, (HlsMediaPlaylist)hlsplaylist);
            maxWidth = -1;
            maxHeight = -1;
            return;
        }
        datasource = ((HlsMasterPlaylist)hlsplaylist).variants;
        variants = buildOrderedVariants(datasource, ai);
        variantPlaylists = new HlsMediaPlaylist[variants.length];
        variantLastPlaylistLoadTimesMs = new long[variants.length];
        variantBlacklistTimes = new long[variants.length];
        int k = -1;
        int j = -1;
        int j1 = 0x7fffffff;
        for (int i1 = 0; i1 < variants.length;)
        {
            int i2 = datasource.indexOf(variants[i1]);
            int k1 = j1;
            if (i2 < j1)
            {
                k1 = i2;
                selectedVariantIndex = i1;
            }
            s = variants[i1].format;
            k = Math.max(((Format) (s)).width, k);
            j = Math.max(((Format) (s)).height, j);
            i1++;
            j1 = k1;
        }

        if (variants.length <= 1 || i == 0)
        {
            maxWidth = -1;
            maxHeight = -1;
            return;
        }
        if (k <= 0)
        {
            k = 1920;
        }
        maxWidth = k;
        if (j <= 0)
        {
            j = 1080;
        }
        maxHeight = j;
    }

    public HlsChunkSource(DataSource datasource, String s, HlsPlaylist hlsplaylist, BandwidthMeter bandwidthmeter, int ai[], int i, AudioCapabilities audiocapabilities)
    {
        this(datasource, s, hlsplaylist, bandwidthmeter, ai, i, 5000L, 20000L, audiocapabilities);
    }

    private boolean allVariantsBlacklisted()
    {
        for (int i = 0; i < variantBlacklistTimes.length; i++)
        {
            if (variantBlacklistTimes[i] == 0L)
            {
                return false;
            }
        }

        return true;
    }

    private static Variant[] buildOrderedVariants(List list, int ai[])
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (ai != null)
        {
            for (int i = 0; i < ai.length; i++)
            {
                arraylist.add(list.get(ai[i]));
            }

        } else
        {
            arraylist.addAll(list);
        }
        list = new ArrayList();
        ai = new ArrayList();
        int j = 0;
        while (j < arraylist.size()) 
        {
            Variant variant = (Variant)arraylist.get(j);
            if (variant.format.height > 0 || variantHasExplicitCodecWithPrefix(variant, "avc"))
            {
                list.add(variant);
            } else
            if (variantHasExplicitCodecWithPrefix(variant, "mp4a"))
            {
                ai.add(variant);
            }
            j++;
        }
        if (list.isEmpty()) goto _L2; else goto _L1
_L1:
        ai = new Variant[list.size()];
        list.toArray(ai);
        Arrays.sort(ai, new Comparator() {

            private final Comparator formatComparator = new com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator();

            public int compare(Variant variant1, Variant variant2)
            {
                return formatComparator.compare(variant1.format, variant2.format);
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Variant)obj, (Variant)obj1);
            }

        });
        return ai;
_L2:
        list = arraylist;
        if (ai.size() < arraylist.size())
        {
            arraylist.removeAll(ai);
            list = arraylist;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void clearEncryptionData()
    {
        encryptionKeyUri = null;
        encryptionKey = null;
        encryptionIvString = null;
        encryptionIv = null;
    }

    private void clearStaleBlacklistedVariants()
    {
        long l = SystemClock.elapsedRealtime();
        for (int i = 0; i < variantBlacklistTimes.length; i++)
        {
            if (variantBlacklistTimes[i] != 0L && l - variantBlacklistTimes[i] > 60000L)
            {
                variantBlacklistTimes[i] = 0L;
            }
        }

    }

    private int getLiveStartChunkMediaSequence(int i)
    {
        HlsMediaPlaylist hlsmediaplaylist = variantPlaylists[i];
        if (hlsmediaplaylist.segments.size() > 3)
        {
            i = hlsmediaplaylist.segments.size() - 3;
        } else
        {
            i = 0;
        }
        return hlsmediaplaylist.mediaSequence + i;
    }

    private int getNextVariantIndex(TsChunk tschunk, long l)
    {
        long l1;
        clearStaleBlacklistedVariants();
        l1 = bandwidthMeter.getBitrateEstimate();
        if (variantBlacklistTimes[selectedVariantIndex] == 0L) goto _L2; else goto _L1
_L1:
        int i = getVariantIndexForBandwidth(l1);
_L4:
        return i;
_L2:
        if (tschunk == null)
        {
            return selectedVariantIndex;
        }
        if (l1 == -1L)
        {
            return selectedVariantIndex;
        }
        int j = getVariantIndexForBandwidth(l1);
        if (j == selectedVariantIndex)
        {
            return selectedVariantIndex;
        }
        if (adaptiveMode == 1)
        {
            l1 = tschunk.startTimeUs;
        } else
        {
            l1 = tschunk.endTimeUs;
        }
        l = l1 - l;
        i = j;
        if (variantBlacklistTimes[selectedVariantIndex] != 0L) goto _L4; else goto _L3
_L3:
        if (j <= selectedVariantIndex)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (l < maxBufferDurationToSwitchDownUs) goto _L4; else goto _L5
_L5:
        if (j >= selectedVariantIndex)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (l > minBufferDurationToSwitchUpUs) goto _L4; else goto _L6
_L6:
        return selectedVariantIndex;
    }

    private int getVariantIndex(Format format)
    {
        for (int i = 0; i < variants.length; i++)
        {
            if (variants[i].format.equals(format))
            {
                return i;
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("Invalid format: ").append(format).toString());
    }

    private int getVariantIndexForBandwidth(long l)
    {
        long l1 = l;
        if (l == -1L)
        {
            l1 = 0L;
        }
        int k = (int)((float)l1 * 0.8F);
        int j = -1;
        for (int i = 0; i < variants.length; i++)
        {
            if (variantBlacklistTimes[i] != 0L)
            {
                continue;
            }
            if (variants[i].format.bitrate <= k)
            {
                return i;
            }
            j = i;
        }

        boolean flag;
        if (j != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return j;
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String s, int i)
    {
        uri = new DataSpec(uri, 0L, -1L, null, 1);
        return new EncryptionKeyChunk(dataSource, uri, scratchSpace, s, i);
    }

    private MediaPlaylistChunk newMediaPlaylistChunk(int i)
    {
        Uri uri = UriUtil.resolveToUri(baseUri, variants[i].url);
        DataSpec dataspec = new DataSpec(uri, 0L, -1L, null, 1);
        return new MediaPlaylistChunk(dataSource, dataspec, scratchSpace, playlistParser, i, uri.toString());
    }

    private void setEncryptionData(Uri uri, String s, byte abyte0[])
    {
        Object obj;
        byte abyte1[];
        int i;
        if (s.toLowerCase(Locale.getDefault()).startsWith("0x"))
        {
            obj = s.substring(2);
        } else
        {
            obj = s;
        }
        obj = (new BigInteger(((String) (obj)), 16)).toByteArray();
        abyte1 = new byte[16];
        if (obj.length > 16)
        {
            i = obj.length - 16;
        } else
        {
            i = 0;
        }
        System.arraycopy(obj, i, abyte1, (abyte1.length - obj.length) + i, obj.length - i);
        encryptionKeyUri = uri;
        encryptionKey = abyte0;
        encryptionIvString = s;
        encryptionIv = abyte1;
    }

    private void setMediaPlaylist(int i, HlsMediaPlaylist hlsmediaplaylist)
    {
        variantLastPlaylistLoadTimesMs[i] = SystemClock.elapsedRealtime();
        variantPlaylists[i] = hlsmediaplaylist;
        live = live | hlsmediaplaylist.live;
        durationUs = hlsmediaplaylist.durationUs;
    }

    private boolean shouldRerequestMediaPlaylist(int i)
    {
        HlsMediaPlaylist hlsmediaplaylist = variantPlaylists[i];
        return SystemClock.elapsedRealtime() - variantLastPlaylistLoadTimesMs[i] >= (long)((hlsmediaplaylist.targetDurationSecs * 1000) / 2);
    }

    private static boolean variantHasExplicitCodecWithPrefix(Variant variant, String s)
    {
        variant = variant.format.codecs;
        if (!TextUtils.isEmpty(variant))
        {
            variant = variant.split("(\\s*,\\s*)|(\\s*$)");
            int i = 0;
            while (i < variant.length) 
            {
                if (variant[i].startsWith(s))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public Chunk getChunkOperation(TsChunk tschunk, long l, long l1)
    {
        Object obj;
        int k;
        boolean flag1;
        if (adaptiveMode == 0)
        {
            k = selectedVariantIndex;
            flag1 = false;
        } else
        {
            k = getNextVariantIndex(tschunk, l1);
            if (tschunk != null && !variants[k].format.equals(tschunk.format) && adaptiveMode == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        obj = variantPlaylists[k];
        if (obj == null)
        {
            return newMediaPlaylistChunk(k);
        }
        selectedVariantIndex = k;
        boolean flag = false;
        int i;
        int j;
        if (live)
        {
            if (tschunk == null)
            {
                i = getLiveStartChunkMediaSequence(k);
            } else
            {
                if (flag1)
                {
                    j = tschunk.chunkIndex;
                } else
                {
                    j = tschunk.chunkIndex + 1;
                }
                i = j;
                if (j < ((HlsMediaPlaylist) (obj)).mediaSequence)
                {
                    i = getLiveStartChunkMediaSequence(k);
                    flag = true;
                }
            }
        } else
        if (tschunk == null)
        {
            i = Util.binarySearchFloor(((HlsMediaPlaylist) (obj)).segments, Long.valueOf(l), true, true) + ((HlsMediaPlaylist) (obj)).mediaSequence;
        } else
        if (flag1)
        {
            i = tschunk.chunkIndex;
        } else
        {
            i = tschunk.chunkIndex + 1;
        }
        j = i - ((HlsMediaPlaylist) (obj)).mediaSequence;
        if (j >= ((HlsMediaPlaylist) (obj)).segments.size())
        {
            if (((HlsMediaPlaylist) (obj)).live && shouldRerequestMediaPlaylist(k))
            {
                return newMediaPlaylistChunk(k);
            } else
            {
                return null;
            }
        }
        HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment)((HlsMediaPlaylist) (obj)).segments.get(j);
        Uri uri1 = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj)).baseUri, segment.url);
        DataSpec dataspec;
        boolean flag2;
        if (segment.isEncrypted)
        {
            Uri uri = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj)).baseUri, segment.encryptionKeyUri);
            if (!uri.equals(encryptionKeyUri))
            {
                return newEncryptionKeyChunk(uri, segment.encryptionIV, selectedVariantIndex);
            }
            if (!Util.areEqual(segment.encryptionIV, encryptionIvString))
            {
                setEncryptionData(uri, segment.encryptionIV, encryptionKey);
            }
        } else
        {
            clearEncryptionData();
        }
        dataspec = new DataSpec(uri1, segment.byterangeOffset, segment.byterangeLength, null);
        if (live)
        {
            if (tschunk == null)
            {
                l = 0L;
            } else
            if (flag1)
            {
                l = tschunk.startTimeUs;
            } else
            {
                l = tschunk.endTimeUs;
            }
        } else
        {
            l = segment.startTimeUs;
        }
        l1 = (long)(segment.durationSecs * 1000000D);
        if (!((HlsMediaPlaylist) (obj)).live && j == ((HlsMediaPlaylist) (obj)).segments.size() - 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = variants[selectedVariantIndex].format;
        if (tschunk == null || segment.discontinuity || !((Format) (obj)).equals(tschunk.format) || flag)
        {
            if (uri1.getLastPathSegment().endsWith(".aac"))
            {
                tschunk = new AdtsExtractor(l);
            } else
            {
                tschunk = new TsExtractor(l, audioCapabilities);
            }
            tschunk = new HlsExtractorWrapper(0, ((Format) (obj)), l, tschunk, flag1);
        } else
        {
            tschunk = tschunk.extractorWrapper;
        }
        return new TsChunk(dataSource, dataspec, 0, ((Format) (obj)), l, l + l1, i, flag2, tschunk, encryptionKey, encryptionIv);
    }

    public long getDurationUs()
    {
        if (live)
        {
            return -1L;
        } else
        {
            return durationUs;
        }
    }

    public void getMaxVideoDimensions(MediaFormat mediaformat)
    {
        if (maxWidth == -1 || maxHeight == -1)
        {
            return;
        } else
        {
            mediaformat.setMaxVideoDimensions(maxWidth, maxHeight);
            return;
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
        if (chunk instanceof MediaPlaylistChunk)
        {
            chunk = (MediaPlaylistChunk)chunk;
            scratchSpace = chunk.getDataHolder();
            setMediaPlaylist(((MediaPlaylistChunk) (chunk)).variantIndex, chunk.getResult());
        } else
        if (chunk instanceof EncryptionKeyChunk)
        {
            chunk = (EncryptionKeyChunk)chunk;
            scratchSpace = chunk.getDataHolder();
            setEncryptionData(((EncryptionKeyChunk) (chunk)).dataSpec.uri, ((EncryptionKeyChunk) (chunk)).iv, chunk.getResult());
            return;
        }
    }

    public boolean onChunkLoadError(Chunk chunk, IOException ioexception)
    {
        if (chunk.bytesLoaded() == 0L && ((chunk instanceof TsChunk) || (chunk instanceof MediaPlaylistChunk) || (chunk instanceof EncryptionKeyChunk)) && (ioexception instanceof com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException))
        {
            int j = ((com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException)ioexception).responseCode;
            if (j == 404 || j == 410)
            {
                int i;
                boolean flag;
                if (chunk instanceof TsChunk)
                {
                    i = getVariantIndex(((TsChunk)chunk).format);
                } else
                if (chunk instanceof MediaPlaylistChunk)
                {
                    i = ((MediaPlaylistChunk)chunk).variantIndex;
                } else
                {
                    i = ((EncryptionKeyChunk)chunk).variantIndex;
                }
                if (variantBlacklistTimes[i] != 0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                variantBlacklistTimes[i] = SystemClock.elapsedRealtime();
                if (flag)
                {
                    Log.w("HlsChunkSource", (new StringBuilder()).append("Already blacklisted variant (").append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    return false;
                }
                if (!allVariantsBlacklisted())
                {
                    Log.w("HlsChunkSource", (new StringBuilder()).append("Blacklisted variant (").append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    return true;
                } else
                {
                    Log.w("HlsChunkSource", (new StringBuilder()).append("Final variant not blacklisted (").append(j).append("): ").append(chunk.dataSpec.uri).toString());
                    variantBlacklistTimes[i] = 0L;
                    return false;
                }
            }
        }
        return false;
    }
}
