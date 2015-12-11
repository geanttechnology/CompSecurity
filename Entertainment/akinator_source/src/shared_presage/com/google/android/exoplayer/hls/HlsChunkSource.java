// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.audio.AudioCapabilities;
import shared_presage.com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import shared_presage.com.google.android.exoplayer.chunk.Chunk;
import shared_presage.com.google.android.exoplayer.chunk.DataChunk;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.extractor.ts.AdtsExtractor;
import shared_presage.com.google.android.exoplayer.extractor.ts.TsExtractor;
import shared_presage.com.google.android.exoplayer.upstream.BandwidthMeter;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.UriUtil;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            HlsPlaylist, HlsPlaylistParser, Variant, HlsMediaPlaylist, 
//            HlsMasterPlaylist, b, TsChunk, HlsExtractorWrapper

public class HlsChunkSource
{
    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }

    private static final class a extends DataChunk
    {

        public final String a;
        public final int b;
        private byte c[];

        public final byte[] a()
        {
            return c;
        }

        protected final void consume(byte abyte0[], int i)
        {
            c = Arrays.copyOf(abyte0, i);
        }

        public a(DataSource datasource, DataSpec dataspec, byte abyte0[], String s, int i)
        {
            super(datasource, dataspec, 3, 0, null, abyte0);
            a = s;
            b = i;
        }
    }

    private static final class b extends DataChunk
    {

        public final int a;
        private final HlsPlaylistParser b;
        private final String c;
        private HlsMediaPlaylist d;

        public final HlsMediaPlaylist a()
        {
            return d;
        }

        protected final void consume(byte abyte0[], int i)
        {
            d = (HlsMediaPlaylist)b.parse(c, new ByteArrayInputStream(abyte0, 0, i));
        }

        public b(DataSource datasource, DataSpec dataspec, byte abyte0[], HlsPlaylistParser hlsplaylistparser, int i, String s)
        {
            super(datasource, dataspec, 4, 0, null, abyte0);
            a = i;
            b = hlsplaylistparser;
            c = s;
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
        if (hlsplaylist.type != 1) goto _L2; else goto _L1
_L1:
        variants = (new Variant[] {
            new Variant(0, s, 0, null, -1, -1)
        });
        variantPlaylists = new HlsMediaPlaylist[1];
        variantLastPlaylistLoadTimesMs = new long[1];
        variantBlacklistTimes = new long[1];
        setMediaPlaylist(0, (HlsMediaPlaylist)hlsplaylist);
        maxWidth = -1;
        i = -1;
_L4:
        maxHeight = i;
        return;
_L2:
        datasource = ((HlsMasterPlaylist)hlsplaylist).variants;
        variants = buildOrderedVariants(datasource, ai);
        variantPlaylists = new HlsMediaPlaylist[variants.length];
        variantLastPlaylistLoadTimesMs = new long[variants.length];
        variantBlacklistTimes = new long[variants.length];
        int i1 = 0x7fffffff;
        int k = -1;
        int j = -1;
        for (int j1 = 0; j1 < variants.length; j1++)
        {
            int k1 = datasource.indexOf(variants[j1]);
            if (k1 < i1)
            {
                selectedVariantIndex = j1;
                i1 = k1;
            }
            s = variants[j1].format;
            k = Math.max(((Format) (s)).width, k);
            j = Math.max(((Format) (s)).height, j);
        }

        if (variants.length <= 1 || i == 0)
        {
            maxWidth = -1;
            i = -1;
        } else
        {
            if (k <= 0)
            {
                k = 1920;
            }
            maxWidth = k;
            i = j;
            if (j <= 0)
            {
                i = 1080;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
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
        int j = ((flag) ? 1 : 0);
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
        if (list.isEmpty())
        {
            if (ai.size() < arraylist.size())
            {
                arraylist.removeAll(ai);
            }
            list = arraylist;
        }
        ai = new Variant[list.size()];
        list.toArray(ai);
        Arrays.sort(ai, new shared_presage.com.google.android.exoplayer.hls.b());
        return ai;
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
        return i + hlsmediaplaylist.mediaSequence;
    }

    private int getNextVariantIndex(TsChunk tschunk, long l)
    {
        clearStaleBlacklistedVariants();
        long l1 = bandwidthMeter.getBitrateEstimate();
        if (variantBlacklistTimes[selectedVariantIndex] != 0L)
        {
            return getVariantIndexForBandwidth(l1);
        }
        if (tschunk == null)
        {
            return selectedVariantIndex;
        }
        if (l1 == -1L)
        {
            return selectedVariantIndex;
        }
        int i = getVariantIndexForBandwidth(l1);
        if (i == selectedVariantIndex)
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
        if (variantBlacklistTimes[selectedVariantIndex] != 0L || i > selectedVariantIndex && l < maxBufferDurationToSwitchDownUs || i < selectedVariantIndex && l > minBufferDurationToSwitchUpUs)
        {
            return i;
        } else
        {
            return selectedVariantIndex;
        }
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

        throw new IllegalStateException((new StringBuilder("Invalid format: ")).append(format).toString());
    }

    private int getVariantIndexForBandwidth(long l)
    {
        boolean flag = false;
        long l1 = l;
        if (l == -1L)
        {
            l1 = 0L;
        }
        int k = (int)((float)l1 * 0.8F);
        int i = 0;
        int j = -1;
        for (; i < variants.length; i++)
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

        if (j != -1)
        {
            flag = true;
        }
        Assertions.checkState(flag);
        return j;
    }

    private a newEncryptionKeyChunk(Uri uri, String s, int i)
    {
        uri = new DataSpec(uri, 0L, -1L, null, 1);
        return new a(dataSource, uri, scratchSpace, s, i);
    }

    private b newMediaPlaylistChunk(int i)
    {
        Uri uri = UriUtil.resolveToUri(baseUri, variants[i].url);
        DataSpec dataspec = new DataSpec(uri, 0L, -1L, null, 1);
        return new b(dataSource, dataspec, scratchSpace, playlistParser, i, uri.toString());
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
        if (adaptiveMode != 0) goto _L2; else goto _L1
_L1:
        int i = selectedVariantIndex;
_L4:
        int k;
        boolean flag2;
        flag2 = false;
        k = i;
_L7:
        Object obj1;
        obj1 = variantPlaylists[k];
        if (obj1 == null)
        {
            return newMediaPlaylistChunk(k);
        }
        break MISSING_BLOCK_LABEL_100;
_L2:
        k = getNextVariantIndex(tschunk, l1);
        i = k;
        if (tschunk == null) goto _L4; else goto _L3
_L3:
        i = k;
        if (variants[k].format.equals(tschunk.format)) goto _L4; else goto _L5
_L5:
        i = k;
        if (adaptiveMode != 1) goto _L4; else goto _L6
_L6:
        flag2 = true;
          goto _L7
        selectedVariantIndex = k;
        if (!live) goto _L9; else goto _L8
_L8:
        if (tschunk != null) goto _L11; else goto _L10
_L10:
        i = getLiveStartChunkMediaSequence(k);
_L14:
        int j;
        boolean flag = false;
        j = i;
        i = ((flag) ? 1 : 0);
_L13:
        int i1;
        i1 = j - ((HlsMediaPlaylist) (obj1)).mediaSequence;
        if (i1 >= ((HlsMediaPlaylist) (obj1)).segments.size())
        {
            if (((HlsMediaPlaylist) (obj1)).live && shouldRerequestMediaPlaylist(k))
            {
                return newMediaPlaylistChunk(k);
            } else
            {
                return null;
            }
        }
        break; /* Loop/switch isn't completed */
_L11:
        if (flag2)
        {
            i = tschunk.chunkIndex;
        } else
        {
            i = tschunk.chunkIndex + 1;
        }
        Object obj;
        HlsMediaPlaylist.Segment segment;
        Uri uri;
        boolean flag3;
        if (i < ((HlsMediaPlaylist) (obj1)).mediaSequence)
        {
            j = getLiveStartChunkMediaSequence(k);
            i = 1;
        } else
        {
            boolean flag1 = false;
            j = i;
            i = ((flag1) ? 1 : 0);
        }
        if (true) goto _L13; else goto _L12
_L9:
        if (tschunk == null)
        {
            i = Util.binarySearchFloor(((HlsMediaPlaylist) (obj1)).segments, Long.valueOf(l), true, true) + ((HlsMediaPlaylist) (obj1)).mediaSequence;
        } else
        if (flag2)
        {
            i = tschunk.chunkIndex;
        } else
        {
            i = tschunk.chunkIndex + 1;
        }
        if (true) goto _L14; else goto _L12
_L12:
        segment = (HlsMediaPlaylist.Segment)((HlsMediaPlaylist) (obj1)).segments.get(i1);
        uri = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj1)).baseUri, segment.url);
        if (segment.isEncrypted)
        {
            obj = UriUtil.resolveToUri(((HlsMediaPlaylist) (obj1)).baseUri, segment.encryptionKeyUri);
            if (!((Uri) (obj)).equals(encryptionKeyUri))
            {
                return newEncryptionKeyChunk(((Uri) (obj)), segment.encryptionIV, selectedVariantIndex);
            }
            if (!Util.areEqual(segment.encryptionIV, encryptionIvString))
            {
                setEncryptionData(((Uri) (obj)), segment.encryptionIV, encryptionKey);
            }
        } else
        {
            clearEncryptionData();
        }
        obj = new DataSpec(uri, segment.byterangeOffset, segment.byterangeLength, null);
        if (live)
        {
            if (tschunk == null)
            {
                l = 0L;
            } else
            if (flag2)
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
        if (!((HlsMediaPlaylist) (obj1)).live && i1 == ((HlsMediaPlaylist) (obj1)).segments.size() - 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        obj1 = variants[selectedVariantIndex].format;
        if (tschunk == null || segment.discontinuity || !((Format) (obj1)).equals(tschunk.format) || i != 0)
        {
            if (uri.getLastPathSegment().endsWith(".aac"))
            {
                tschunk = new AdtsExtractor(l);
            } else
            {
                tschunk = new TsExtractor(l, audioCapabilities);
            }
            tschunk = new HlsExtractorWrapper(0, ((Format) (obj1)), l, tschunk, flag2);
        } else
        {
            tschunk = tschunk.extractorWrapper;
        }
        return new TsChunk(dataSource, ((DataSpec) (obj)), 0, ((Format) (obj1)), l, l + l1, j, flag3, tschunk, encryptionKey, encryptionIv);
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
        if (chunk instanceof b)
        {
            chunk = (b)chunk;
            scratchSpace = chunk.getDataHolder();
            setMediaPlaylist(((b) (chunk)).a, chunk.a());
        } else
        if (chunk instanceof a)
        {
            chunk = (a)chunk;
            scratchSpace = chunk.getDataHolder();
            setEncryptionData(((a) (chunk)).dataSpec.uri, ((a) (chunk)).a, chunk.a());
            return;
        }
    }

    public boolean onChunkLoadError(Chunk chunk, IOException ioexception)
    {
        int i;
        int j;
label0:
        {
            if (chunk.bytesLoaded() == 0L && ((chunk instanceof TsChunk) || (chunk instanceof b) || (chunk instanceof a)) && (ioexception instanceof shared_presage.com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException))
            {
                j = ((shared_presage.com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException)ioexception).responseCode;
                if (j == 404 || j == 410)
                {
                    boolean flag;
                    if (chunk instanceof TsChunk)
                    {
                        i = getVariantIndex(((TsChunk)chunk).format);
                    } else
                    if (chunk instanceof b)
                    {
                        i = ((b)chunk).a;
                    } else
                    {
                        i = ((a)chunk).b;
                    }
                    if (variantBlacklistTimes[i] != 0L)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    variantBlacklistTimes[i] = SystemClock.elapsedRealtime();
                    if (!flag)
                    {
                        break label0;
                    }
                    Log.w("HlsChunkSource", (new StringBuilder("Already blacklisted variant (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
                }
            }
            return false;
        }
        if (!allVariantsBlacklisted())
        {
            Log.w("HlsChunkSource", (new StringBuilder("Blacklisted variant (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
            return true;
        } else
        {
            Log.w("HlsChunkSource", (new StringBuilder("Final variant not blacklisted (")).append(j).append("): ").append(chunk.dataSpec.uri).toString());
            variantBlacklistTimes[i] = 0L;
            return false;
        }
    }
}
