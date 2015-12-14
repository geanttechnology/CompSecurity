// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer.upstream.HttpDataSource;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.nativeads:
//            IntInterval

public class HttpDiskCompositeDataSource
    implements DataSource
{

    private static final int BLOCK_SIZE = 0x7d000;
    private static final String EXPECTED_FILE_SIZE_KEY_PREFIX = "expectedsize-";
    private static final int HTTP_RESPONSE_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    private static final String INTERVALS_KEY_PREFIX = "intervals-";
    private static final String LENGTH = "length";
    private static final int LENGTH_UNBOUNDED = -1;
    private static final String START = "start";
    private byte mCachedBytes[];
    private int mDataBlockOffset;
    private DataSpec mDataSpec;
    private final EventDetails mEventDetails;
    private Integer mExpectedFileLength;
    private boolean mHasLoggedDownloadStart;
    private final HttpDataSource mHttpDataSource;
    private final List mIntervals = new ArrayList();
    private boolean mIsDirty;
    private boolean mIsHttpSourceOpen;
    private String mKey;
    private int mSegment;
    private int mStartInDataBlock;
    private int mStartInFile;

    public HttpDiskCompositeDataSource(Context context, String s, EventDetails eventdetails)
    {
        mExpectedFileLength = null;
        mHttpDataSource = new DefaultHttpDataSource(s, null, null, 8000, 8000, false);
        CacheService.initialize(context);
        mEventDetails = eventdetails;
    }

    private void addNewInterval(int i, int j)
    {
        for (int k = 0; k < mIntervals.size(); k++)
        {
            if (((IntInterval)mIntervals.get(k)).equals(i, j))
            {
                return;
            }
        }

        mIntervals.add(new IntInterval(i, j));
    }

    private static boolean areBytesAvailableInCache(int i, int j, int k)
    {
        return i > j + k;
    }

    private static Integer getExpectedFileLengthFromDisk(String s)
    {
        Object obj = null;
        Preconditions.checkNotNull(s);
        byte abyte0[] = CacheService.getFromDiskCache((new StringBuilder()).append("expectedsize-").append(s).toString());
        s = obj;
        if (abyte0 != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(new String(abyte0));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            s = Integer.valueOf(i);
        }
        return s;
    }

    private static int getFirstContiguousPointAfter(int i, List list)
    {
        Preconditions.checkNotNull(list);
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < list.size(); i++)
        {
            for (int k = 0; k < list.size();)
            {
                IntInterval intinterval = (IntInterval)list.get(k);
                int l = j;
                if (intinterval.getStart() <= j)
                {
                    l = Math.max(j, intinterval.getStart() + intinterval.getLength());
                }
                k++;
                j = l;
            }

        }

        return j;
    }

    private static void populateIntervalsFromDisk(String s, List list)
    {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(list);
        list.clear();
        s = CacheService.getFromDiskCache((new StringBuilder()).append("intervals-").append(s).toString());
        if (s == null) goto _L2; else goto _L1
_L1:
        s = new String(s);
        s = new JSONArray(s);
        int i = 0;
_L3:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = new JSONObject((String)s.get(i));
        list.add(new IntInterval(jsonobject.getInt("start"), jsonobject.getInt("length")));
        i++;
        if (true) goto _L3; else goto _L2
        s;
        MoPubLog.d("clearing cache since invalid json intervals found", s);
        list.clear();
_L2:
        return;
        s;
        MoPubLog.d("clearing cache since unable to read json data");
        list.clear();
        return;
    }

    private void writeCacheToDiskAndClearVariables()
    {
        CacheService.putToDiskCache((new StringBuilder()).append(mSegment).append(mKey).toString(), mCachedBytes);
        addNewInterval(mStartInFile, mDataBlockOffset);
        mStartInDataBlock = 0;
        mStartInFile = mStartInFile + mDataBlockOffset;
        mDataBlockOffset = 0;
        mSegment = mStartInFile / 0x7d000;
    }

    private static void writeIntervalsToDisk(List list, String s)
    {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(s);
        JSONArray jsonarray = new JSONArray();
        for (list = list.iterator(); list.hasNext(); jsonarray.put((IntInterval)list.next())) { }
        CacheService.putToDiskCache((new StringBuilder()).append("intervals-").append(s).toString(), jsonarray.toString().getBytes());
    }

    public void close()
        throws IOException
    {
        if (!TextUtils.isEmpty(mKey) && mCachedBytes != null)
        {
            CacheService.putToDiskCache((new StringBuilder()).append(mSegment).append(mKey).toString(), mCachedBytes);
            addNewInterval(mStartInFile, mDataBlockOffset);
            writeIntervalsToDisk(mIntervals, mKey);
            if (mIsDirty && mExpectedFileLength != null && getFirstContiguousPointAfter(0, mIntervals) == mExpectedFileLength.intValue())
            {
                MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.DOWNLOAD_FINISHED, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
            }
        }
        mCachedBytes = null;
        mHttpDataSource.close();
        mIsHttpSourceOpen = false;
        mStartInFile = 0;
        mDataBlockOffset = 0;
        mStartInDataBlock = 0;
        mExpectedFileLength = null;
        mIsDirty = false;
    }

    public long open(DataSpec dataspec)
        throws IOException
    {
        Preconditions.checkNotNull(dataspec);
        if (dataspec.uri != null) goto _L2; else goto _L1
_L1:
        long l = -1L;
_L4:
        return l;
_L2:
        mIsDirty = false;
        mDataSpec = dataspec;
        mKey = dataspec.uri.toString();
        if (mKey == null)
        {
            return -1L;
        }
        mStartInFile = (int)dataspec.absoluteStreamPosition;
        mSegment = mStartInFile / 0x7d000;
        mCachedBytes = CacheService.getFromDiskCache((new StringBuilder()).append(mSegment).append(mKey).toString());
        mStartInDataBlock = mStartInFile % 0x7d000;
        mDataBlockOffset = 0;
        mExpectedFileLength = getExpectedFileLengthFromDisk(mKey);
        populateIntervalsFromDisk(mKey, mIntervals);
        int j = getFirstContiguousPointAfter(mStartInFile, mIntervals);
        int i = j;
        if (mCachedBytes == null)
        {
            mCachedBytes = new byte[0x7d000];
            i = j;
            if (j > mStartInFile)
            {
                MoPubLog.d((new StringBuilder()).append("Cache segment ").append(mSegment).append(" was evicted. Invalidating cache").toString());
                mIntervals.clear();
                i = (int)dataspec.absoluteStreamPosition;
            }
        }
        if (mExpectedFileLength != null && i == mExpectedFileLength.intValue())
        {
            break MISSING_BLOCK_LABEL_485;
        }
        long l1;
        if (mDataSpec.length == -1L)
        {
            l = -1L;
        } else
        {
            l = mDataSpec.length - (long)(i - mStartInFile);
        }
        dataspec = new DataSpec(dataspec.uri, i, l, dataspec.key, dataspec.flags);
        l1 = mHttpDataSource.open(dataspec);
        if (mExpectedFileLength != null || l != -1L)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        mExpectedFileLength = Integer.valueOf((int)((long)mStartInFile + l1));
        CacheService.putToDiskCache((new StringBuilder()).append("expectedsize-").append(mKey).toString(), String.valueOf(mExpectedFileLength).getBytes());
        mIsHttpSourceOpen = true;
        l = l1;
        if (mHasLoggedDownloadStart) goto _L4; else goto _L3
_L3:
        MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.DOWNLOAD_START, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
        mHasLoggedDownloadStart = true;
        return l1;
        dataspec;
        if (((com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException) (dataspec)).responseCode == 416)
        {
            if (mExpectedFileLength == null)
            {
                l = i - mStartInFile;
            } else
            {
                l = mExpectedFileLength.intValue() - mStartInFile;
            }
            mIsHttpSourceOpen = false;
            return l;
        } else
        {
            throw dataspec;
        }
        if (dataspec.length == -1L)
        {
            return (long)(mExpectedFileLength.intValue() - mStartInFile);
        } else
        {
            return dataspec.length;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j > 0x7d000)
        {
            MoPubLog.d((new StringBuilder()).append("Reading more than the block size (512000 bytes) at once is not possible. length = ").append(j).toString());
            return -1;
        }
        if (mDataSpec == null)
        {
            MoPubLog.d("Unable to read from data source when no spec provided");
            return -1;
        }
        if (mCachedBytes == null)
        {
            MoPubLog.d("No cache set up. Call open before read.");
            return -1;
        }
        int i1 = 0x7d000 - mStartInDataBlock - mDataBlockOffset;
        int j1 = getFirstContiguousPointAfter(mStartInFile + mDataBlockOffset, mIntervals);
        int l = Math.min(j1 - mStartInFile - mDataBlockOffset, j);
        int k = 0;
        if (areBytesAvailableInCache(j1, mStartInFile, mDataBlockOffset))
        {
            if (l <= i1)
            {
                System.arraycopy(mCachedBytes, mStartInDataBlock + mDataBlockOffset, abyte0, i, l);
                mDataBlockOffset = mDataBlockOffset + l;
                return l;
            }
            System.arraycopy(mCachedBytes, mStartInDataBlock + mDataBlockOffset, abyte0, i, i1);
            mDataBlockOffset = mDataBlockOffset + i1;
            k = 0 + i1;
            writeCacheToDiskAndClearVariables();
            mCachedBytes = CacheService.getFromDiskCache((new StringBuilder()).append(mSegment).append(mKey).toString());
            if (mCachedBytes == null)
            {
                MoPubLog.d("Unexpected cache miss. Invalidating cache");
                mIntervals.clear();
                mCachedBytes = new byte[0x7d000];
                mHttpDataSource.close();
                mHttpDataSource.open(new DataSpec(mDataSpec.uri, mStartInFile + mDataBlockOffset, -1L, mDataSpec.key, mDataSpec.flags));
                mIsHttpSourceOpen = true;
            } else
            {
                System.arraycopy(mCachedBytes, mStartInDataBlock + mDataBlockOffset, abyte0, i + k, l - k);
                mDataBlockOffset = mDataBlockOffset + (l - k);
                k = l;
            }
        }
        j -= k;
        if (j <= 0)
        {
            return k;
        }
        mIsDirty = true;
        if (!mIsHttpSourceOpen)
        {
            MoPubLog.d("end of cache reached. No http source open");
            return -1;
        }
        j = mHttpDataSource.read(abyte0, i, j);
        k = 0x7d000 - mStartInDataBlock - mDataBlockOffset;
        if (k < j)
        {
            System.arraycopy(abyte0, i, mCachedBytes, mStartInDataBlock + mDataBlockOffset, k);
            mDataBlockOffset = mDataBlockOffset + k;
            writeCacheToDiskAndClearVariables();
            mCachedBytes = CacheService.getFromDiskCache((new StringBuilder()).append(mSegment).append(mKey).toString());
            if (mCachedBytes == null)
            {
                mCachedBytes = new byte[0x7d000];
            }
            System.arraycopy(abyte0, i + k, mCachedBytes, mStartInDataBlock + mDataBlockOffset, j - k);
            mDataBlockOffset = mDataBlockOffset + (j - k);
        } else
        {
            System.arraycopy(abyte0, i, mCachedBytes, mStartInDataBlock + mDataBlockOffset, j);
            mDataBlockOffset = mDataBlockOffset + j;
        }
        return j;
    }
}
