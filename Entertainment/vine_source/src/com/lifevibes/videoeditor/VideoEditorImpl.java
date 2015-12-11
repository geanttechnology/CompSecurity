// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.lifevibes.videoeditor:
//            VideoEditor, MediaArtistNativeHelper, MediaItem, MediaVideoItem

public class VideoEditorImpl
    implements VideoEditor
{

    private static final String CODECCONFIG_FILENAME = "CodecConfig.xml";
    private static final String TAG = "VideoEditorImpl";
    private static final String TAG_DEC_CONFIG_TN_ACCURATE_MODE = "ThubmnailAccurateMode";
    private static final String TAG_DEC_CONFIG_TN_FAST_MODE = "ThubmnailFastMode";
    private static final String TAG_TN = "ThumbNailcodecConfig";
    private int mAspectRatio;
    private List mClipsList;
    private long mDurationMs;
    private boolean mIsFirstVideoItemAdded;
    private boolean mIsList3D;
    private final Semaphore mLock;
    private MediaArtistNativeHelper mMANativeHelper;
    private final List mMediaItems;
    private final String mProjectPath;
    private int modifiedBitrate;

    VideoEditorImpl(String s)
        throws IOException
    {
        mClipsList = new ArrayList();
        mMediaItems = new ArrayList();
        mLock = new Semaphore(1, true);
        mMANativeHelper = new MediaArtistNativeHelper(s, mLock, this);
        mProjectPath = s;
        mAspectRatio = 3;
        mDurationMs = 0L;
    }

    VideoEditorImpl(String s, String s1)
        throws IOException
    {
        mClipsList = new ArrayList();
        mMediaItems = new ArrayList();
        mLock = new Semaphore(1, true);
        mMANativeHelper = new MediaArtistNativeHelper(s, mLock, this);
        mProjectPath = s;
        mAspectRatio = 3;
        mDurationMs = 0L;
        if (!(new File(s1, "CodecConfig.xml")).exists())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        readCodecConfigFile(s1);
        return;
        s;
    }

    private void computeTimelineDuration()
    {
        mDurationMs = 0L;
        int j = mMediaItems.size();
        for (int i = 0; i < j; i++)
        {
            MediaItem mediaitem = (MediaItem)mMediaItems.get(i);
            mDurationMs = mDurationMs + mediaitem.getTimelineDuration();
        }

    }

    private void lock()
        throws InterruptedException
    {
        if (Log.isLoggable("VideoEditorImpl", 3))
        {
            Log.d("VideoEditorImpl", "lock: grabbing semaphore", new Throwable());
        }
        mLock.acquire();
        if (Log.isLoggable("VideoEditorImpl", 3))
        {
            Log.d("VideoEditorImpl", "lock: grabbed semaphore");
        }
    }

    private boolean lock(long l)
        throws InterruptedException
    {
        if (Log.isLoggable("VideoEditorImpl", 3))
        {
            Log.d("VideoEditorImpl", (new StringBuilder()).append("lock: grabbing semaphore with timeout ").append(l).toString(), new Throwable());
        }
        boolean flag = mLock.tryAcquire(l, TimeUnit.MILLISECONDS);
        if (Log.isLoggable("VideoEditorImpl", 3))
        {
            Log.d("VideoEditorImpl", (new StringBuilder()).append("lock: grabbed semaphore status ").append(flag).toString());
        }
        return flag;
    }

    private void readCodecConfigFile(String s)
        throws FileNotFoundException, XmlPullParserException, IOException
    {
        Object obj;
        boolean flag2;
        boolean flag3;
        int i;
        s = new FileInputStream(new File(s, "CodecConfig.xml"));
        obj = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory) (obj)).setNamespaceAware(true);
        obj = ((XmlPullParserFactory) (obj)).newPullParser();
        ((XmlPullParser) (obj)).setInput(s, "UTF-8");
        i = ((XmlPullParser) (obj)).getEventType();
        flag2 = false;
        flag3 = false;
_L6:
        boolean flag;
        boolean flag1;
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        flag = flag3;
        flag1 = flag2;
        i;
        JVM INSTR tableswitch 2 4: default 96
    //                   2 123
    //                   3 104
    //                   4 193;
           goto _L1 _L2 _L3 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        flag1 = flag2;
        flag = flag3;
_L7:
        i = ((XmlPullParser) (obj)).next();
        flag3 = flag;
        flag2 = flag1;
        if (true) goto _L6; else goto _L5
_L5:
        String s1 = ((XmlPullParser) (obj)).getName();
        flag = flag3;
        flag1 = flag2;
        if (!"ThumbNailcodecConfig".equals(s1))
        {
            if ("ThubmnailFastMode".equals(s1))
            {
                flag1 = true;
                flag = flag3;
            } else
            {
                flag = flag3;
                flag1 = flag2;
                if ("ThubmnailAccurateMode".equals(s1))
                {
                    flag = true;
                    flag1 = flag2;
                }
            }
        }
          goto _L7
_L4:
        if (flag2)
        {
            if (((XmlPullParser) (obj)).getText().equalsIgnoreCase("NXPSWVDEC"))
            {
                MediaArtistNativeHelper.mTNDecConfigFastMode = 1;
            } else
            if (((XmlPullParser) (obj)).getText().equalsIgnoreCase("SFHWVDEC"))
            {
                MediaArtistNativeHelper.mTNDecConfigFastMode = 2;
            }
            flag1 = false;
            flag = flag3;
        } else
        {
            flag = flag3;
            flag1 = flag2;
            if (flag3)
            {
                if (((XmlPullParser) (obj)).getText().equalsIgnoreCase("NXPSWVDEC"))
                {
                    MediaArtistNativeHelper.mTNDecConfigAccurateMode = 1;
                } else
                if (((XmlPullParser) (obj)).getText().equalsIgnoreCase("SFHWVDEC"))
                {
                    MediaArtistNativeHelper.mTNDecConfigAccurateMode = 2;
                }
                flag = false;
                flag1 = flag2;
            }
        }
          goto _L7
        s.close();
        return;
          goto _L7
    }

    private int setOptimalConfiguration(int i)
    {
        int j;
        if (i >= 0x7a1200)
        {
            j = 0x7a1200;
            i = 1080;
            mAspectRatio = 2;
        } else
        if (i >= 0x4c4b40)
        {
            j = 0x4c4b40;
            i = 720;
            mAspectRatio = 1;
        } else
        if (i >= 0x1e8480)
        {
            j = 0x1e8480;
            i = 480;
            mAspectRatio = 1;
        } else
        if (i >= 0xf4240)
        {
            j = 0xf4240;
            i = 480;
            mAspectRatio = 1;
        } else
        if (i >= 0xc3500)
        {
            j = 0xc3500;
            i = 480;
            mAspectRatio = 3;
        } else
        if (i >= 0x7d000)
        {
            j = 0x7d000;
            i = 480;
            mAspectRatio = 3;
        } else
        if (i >= 0x5dc00)
        {
            j = 0x5dc00;
            i = 288;
            mAspectRatio = 5;
        } else
        if (i >= 0x3e800)
        {
            j = 0x3e800;
            i = 288;
            mAspectRatio = 5;
        } else
        if (i >= 0x2ee00)
        {
            j = 0x2ee00;
            i = 144;
            mAspectRatio = 5;
        } else
        if (i >= 0x1f400)
        {
            j = 0x1f400;
            i = 144;
            mAspectRatio = 5;
        } else
        if (i >= 0x17700)
        {
            j = 0x17700;
            i = 144;
            mAspectRatio = 5;
        } else
        {
            j = 64000;
            i = 144;
            mAspectRatio = 5;
        }
        modifiedBitrate = j;
        return i;
    }

    private void unlock()
    {
        if (Log.isLoggable("VideoEditorImpl", 3))
        {
            Log.d("VideoEditorImpl", "unlock: releasing semaphore");
        }
        mLock.release();
    }

    public void addMediaItem(MediaItem mediaitem)
    {
        this;
        JVM INSTR monitorenter ;
        if (mediaitem != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new IllegalArgumentException("Media item is null");
        mediaitem;
        this;
        JVM INSTR monitorexit ;
        throw mediaitem;
        if (mMediaItems.contains(mediaitem))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Media item already exists: ").append(mediaitem.getId()).toString());
        }
        if (mMediaItems.size() == 1)
        {
            throw new IllegalStateException("More than one media item cannot be added for MediaShare configuration");
        }
        mMediaItems.add(mediaitem);
        computeTimelineDuration();
        this;
        JVM INSTR monitorexit ;
    }

    public void cancelExport(String s)
    {
        if (mMANativeHelper != null && s != null)
        {
            mMANativeHelper.stop(s);
        }
    }

    public void cancelFit2Share(String s)
    {
        if (mMANativeHelper != null && s != null)
        {
            mMANativeHelper.stop(s);
        }
    }

    public long export(String s, long l, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException, UnsupportedOperationException
    {
        File file;
        boolean flag;
        boolean flag1;
        int j;
        int k;
        if (s == null)
        {
            throw new IllegalArgumentException("export: filename is null");
        }
        file = new File(s);
        if (file == null)
        {
            throw new IOException((new StringBuilder()).append(s).append("can not be created").toString());
        }
        if (mMediaItems.size() == 0)
        {
            throw new IllegalStateException("No MediaItems added");
        }
        if (l <= 0L)
        {
            throw new IllegalArgumentException("Size is Zero");
        }
        int i = (int)(mDurationMs / 1000L);
        i = (int)((((double)l - (double)l * 0.040000000000000001D) / (double)i) * 8D) - 12200;
        if (i <= 64000)
        {
            float f = (float)((((double)l - (double)l * 0.040000000000000001D) / 64000D) * 8D * 1000D);
            throw new UnsupportedOperationException((new StringBuilder()).append("export: limit file duration to ").append(f).append(" ms").toString());
        }
        j = setOptimalConfiguration(i);
        k = mAspectRatio;
        flag1 = false;
        flag = false;
        lock();
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag = flag2;
        flag1 = flag3;
        if (mMANativeHelper != null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        flag1 = flag3;
        try
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag1 = flag;
        }
        finally
        {
            if (!flag1) goto _L0; else goto _L0
        }
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
_L3:
        mAspectRatio = k;
        if (file.length() > l)
        {
            file.delete();
            throw new RuntimeException("Generated File size > outputsize; reduce Input file duration and retry");
        } else
        {
            return file.length();
        }
_L2:
        flag = flag2;
        flag1 = flag3;
        mMANativeHelper.export(s, mProjectPath, j, modifiedBitrate, 1, 4, l, mMediaItems, exportprogresslistener);
        if (true)
        {
            unlock();
        }
          goto _L3
        unlock();
        throw s;
    }

    public void export(String s, int i, int j, int k, int l, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException
    {
        boolean flag;
        boolean flag1;
        if (s == null)
        {
            throw new IllegalArgumentException("export: filename is null");
        }
        if (mMediaItems.size() == 0)
        {
            throw new IllegalStateException("No MediaItems added");
        }
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported audio codec type ").append(k).toString());

        case 2: // '\002'
            switch (l)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Unsupported video codec type ").append(l).toString());

            case 4: // '\004'
                switch (i)
                {
                default:
                    throw new IllegalArgumentException("Argument Height incorrect");

                case 480: 
                    switch (j)
                    {
                    default:
                        throw new IllegalArgumentException("Argument Bitrate incorrect");

                    case 28000: 
                    case 40000: 
                    case 64000: 
                    case 96000: 
                    case 128000: 
                    case 192000: 
                    case 256000: 
                    case 384000: 
                    case 512000: 
                    case 800000: 
                    case 1000000: 
                    case 1200000: 
                    case 1500000: 
                    case 2000000: 
                    case 5000000: 
                    case 8000000: 
                        break;
                    }
                    break;
                }
                break;
            }
            break;
        }
        if (l == 1)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException("Argument Height incorrect for H263 output codec");

            case 96: // '`'
                if (getAspectRatio() != 3)
                {
                    throw new IllegalArgumentException("Aspect ratio not correct for H263 output codec");
                }
                break;

            case 144: 
            case 288: 
                if (getAspectRatio() != 5)
                {
                    throw new IllegalArgumentException("Aspect ratio not correct for H263 output codec");
                }
                break;
            }
        }
        flag1 = false;
        flag = false;
        lock();
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag = flag2;
        flag1 = flag3;
        if (mMANativeHelper != null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        flag1 = flag3;
        try
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag1 = flag;
        }
        finally
        {
            if (!flag1) goto _L0; else goto _L0
        }
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
_L4:
        return;
_L2:
        flag = flag2;
        flag1 = flag3;
        mMANativeHelper.export(s, mProjectPath, i, j, k, l, 0L, mMediaItems, exportprogresslistener);
        if (false) goto _L4; else goto _L3
_L3:
        unlock();
        return;
        unlock();
        throw s;
    }

    public void export(String s, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException
    {
        boolean flag;
        boolean flag1;
        exportprogresslistener = null;
        if (s == null)
        {
            throw new IllegalArgumentException("export: filename is null");
        }
        if (new File(s) == null)
        {
            throw new IOException((new StringBuilder()).append(s).append("can not be created").toString());
        }
        s = exportprogresslistener;
        if (mMediaItems.size() > 0)
        {
            s = (MediaItem)mMediaItems.get(0);
        }
        if (mMediaItems.size() == 1 && (s instanceof MediaVideoItem))
        {
            s = (MediaItem)mMediaItems.get(0);
            setAspectRatio(mMANativeHelper.getAspectRatio(s.getWidth(), s.getHeight()));
        }
        flag1 = false;
        flag = false;
        lock();
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag = flag2;
        flag1 = flag3;
        if (mMANativeHelper != null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        flag1 = flag3;
        try
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag1 = flag;
        }
        finally
        {
            if (!flag1) goto _L0; else goto _L0
        }
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
_L4:
        return;
_L2:
        if (false) goto _L4; else goto _L3
_L3:
        unlock();
        return;
        unlock();
        throw s;
    }

    public void exportAs2D(String s, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException
    {
        boolean flag;
        boolean flag1;
        if (s == null)
        {
            throw new IllegalArgumentException("export: filename is null");
        }
        if (new File(s) == null)
        {
            throw new IOException((new StringBuilder()).append(s).append("can not be created").toString());
        }
        flag1 = false;
        flag = false;
        lock();
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag = flag2;
        flag1 = flag3;
        if (mMANativeHelper != null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        flag1 = flag3;
        try
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag1 = flag;
        }
        finally
        {
            if (!flag1) goto _L0; else goto _L0
        }
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
_L4:
        return;
_L2:
        flag = flag2;
        flag1 = flag3;
        mMANativeHelper.exportAs2D(s, mProjectPath, mMediaItems, exportprogresslistener);
        if (false) goto _L4; else goto _L3
_L3:
        unlock();
        return;
        unlock();
        throw s;
    }

    public long fit2Share(String s, String s1, long l, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException, UnsupportedOperationException
    {
        Object obj;
        List list;
        boolean flag;
        int k;
        int i1;
        int j1;
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("fit2Share: filename is null");
        }
        obj = new File(s1);
        if (obj == null)
        {
            throw new IOException((new StringBuilder()).append(s1).append("can not be created").toString());
        }
        File file = new File(s);
        if (file == null)
        {
            throw new IOException((new StringBuilder()).append(s).append("can not be created").toString());
        }
        if (l <= 0L)
        {
            throw new IllegalArgumentException("fit2Share: File Size is Zero");
        }
        list = new ArrayList();
        MediaVideoItem mediavideoitem;
        try
        {
            mediavideoitem = new MediaVideoItem(this, "mediaVidItem", s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not create an Media Video Item of fileIn  Issue = ").append(s.toString()).toString());
        }
        list.add(mediavideoitem);
        if (file.exists() && file.length() <= l)
        {
            Log.i("FIT2SHARE", "Copying inputfile to output");
            obj = new FileOutputStream(s1);
            s = new FileInputStream(s);
            mMANativeHelper.setFit2ShareFile(s1);
            list = new byte[1];
            l = 0L;
            long l1 = 0L;
            long l2 = file.length();
            do
            {
                int i = s.read(list);
                if (i <= 0)
                {
                    break;
                }
                ((FileOutputStream) (obj)).write(list);
                if (exportprogresslistener != null)
                {
                    l1 += i;
                    if ((100L * l1) / l2 != l && l != 0L)
                    {
                        exportprogresslistener.onProgress(this, s1, (int)l);
                    }
                    l = (100L * l1) / l2;
                }
            } while (true);
            if (exportprogresslistener != null)
            {
                exportprogresslistener.onProgress(this, s1, (int)l);
            }
            ((FileOutputStream) (obj)).flush();
            ((FileOutputStream) (obj)).close();
            s.close();
            return file.length();
        }
        int j = (int)(mediavideoitem.getTimelineDuration() / 1000L);
        k = (int)((((double)l - (double)l * 0.040000000000000001D) / (double)j) * 8D) - 12200;
        if (k <= 64000)
        {
            float f = (float)((((double)l - (double)l * 0.040000000000000001D) / 64000D) * 8D * 1000D);
            throw new UnsupportedOperationException((new StringBuilder()).append("fit2share: limit file duration to ").append(f).append(" ms").toString());
        }
        j = mAspectRatio;
        i1 = setOptimalConfiguration(k);
        if (j == mAspectRatio)
        {
            mediavideoitem.setRenderingMode(1);
        }
        j1 = mAspectRatio;
        k = 0;
        flag = false;
        lock();
        boolean flag1;
        boolean flag2;
        flag2 = true;
        flag1 = true;
        flag = flag1;
        k = ((flag2) ? 1 : 0);
        if (mMANativeHelper != null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        k = ((flag2) ? 1 : 0);
        try
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            k = ((flag) ? 1 : 0);
        }
        finally
        {
            if (!k) goto _L0; else goto _L0
        }
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
_L3:
        mAspectRatio = j1;
        if (((File) (obj)).length() > l)
        {
            ((File) (obj)).delete();
            throw new RuntimeException("Generated File size > outputsize; reduce Input file duration and retry");
        } else
        {
            return ((File) (obj)).length();
        }
_L2:
        flag = flag1;
        k = ((flag2) ? 1 : 0);
        mMANativeHelper.export(s1, mProjectPath, i1, modifiedBitrate, 1, 4, l, list, exportprogresslistener);
        if (true)
        {
            unlock();
        }
          goto _L3
        unlock();
        throw s;
    }

    public long fit2ShareMMS(String s, String s1, VideoEditor.ExportProgressListener exportprogresslistener)
        throws IOException, UnsupportedOperationException
    {
        File file;
        boolean flag;
        boolean flag1;
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("fit2ShareMMS: filename is null");
        }
        file = new File(s1);
        if (file == null)
        {
            throw new IOException((new StringBuilder()).append(s1).append("can not be created").toString());
        }
        if (mMANativeHelper == null)
        {
            throw new IllegalStateException("The video editor is not initialized");
        }
        int k = mAspectRatio;
        if (mAspectRatio != 5)
        {
            mAspectRatio = 5;
        }
        Object obj = new ArrayList();
        File file1;
        byte abyte0[];
        try
        {
            abyte0 = new MediaVideoItem(this, "mmsMediaItem", s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not create an Media Video Item of fileIn file for MMS  Issue = ").append(s.toString()).toString());
        }
        ((List) (obj)).add(abyte0);
        file1 = new File(s);
        if (file1 != null && file1.length() <= 0x4b000L && abyte0.getVideoType() == 1 && mMANativeHelper.GetClosestVideoFrameRate(abyte0.getFps()) == 4 && abyte0.getVideoProfile() <= 4 && abyte0.getAudioType() <= 1)
        {
            obj = new FileOutputStream(s1);
            s = new FileInputStream(s);
            abyte0 = new byte[1];
            long l = 0L;
            long l1 = 0L;
            long l2 = file1.length();
            do
            {
                int i = s.read(abyte0);
                if (i <= 0)
                {
                    break;
                }
                ((FileOutputStream) (obj)).write(abyte0);
                if (exportprogresslistener != null)
                {
                    l1 += i;
                    if ((100L * l1) / l2 != l && l != 0L)
                    {
                        exportprogresslistener.onProgress(this, s1, (int)l);
                    }
                    l = (100L * l1) / l2;
                }
            } while (true);
            if (exportprogresslistener != null)
            {
                exportprogresslistener.onProgress(this, s1, (int)l);
            }
            ((FileOutputStream) (obj)).flush();
            ((FileOutputStream) (obj)).close();
            s.close();
            return file.length();
        }
        if (abyte0.getAspectRatio() == 5)
        {
            abyte0.setRenderingMode(1);
        }
        int j = (int)((0x47400L / (abyte0.getDuration() / 1000L)) * 8L) - 12200;
        if (j < 0x7a1200 && j >= 0x4c4b40)
        {
            j = 0x4c4b40;
        } else
        if (j < 0x4c4b40 && j >= 0x1e8480)
        {
            j = 0x1e8480;
        } else
        if (j < 0x1e8480 && j >= 0x16e360)
        {
            j = 0x16e360;
        } else
        if (j < 0x16e360 && j >= 0x124f80)
        {
            j = 0x124f80;
        } else
        if (j < 0x124f80 && j >= 0xf4240)
        {
            j = 0xf4240;
        } else
        if (j < 0xf4240 && j >= 0xc3500)
        {
            j = 0xc3500;
        } else
        if (j < 0xc3500 && j >= 0x7d000)
        {
            j = 0x7d000;
        } else
        if (j < 0x7d000 && j >= 0x5dc00)
        {
            j = 0x5dc00;
        } else
        if (j < 0x5dc00 && j >= 0x3e800)
        {
            j = 0x3e800;
        } else
        if (j < 0x3e800 && j >= 0x2ee00)
        {
            j = 0x2ee00;
        } else
        if (j < 0x2ee00 && j >= 0x1f400)
        {
            j = 0x1f400;
        } else
        if (j < 0x1f400 && j >= 0x17700)
        {
            j = 0x17700;
        } else
        if (j < 0x17700 && j >= 64000)
        {
            j = 64000;
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("fit2ShareMMS: limit file duration to ").append(32000).append(" ms").toString());
        }
_L3:
        flag1 = false;
        flag = false;
        lock();
        flag1 = true;
        flag = true;
        mMANativeHelper.export(s1, mProjectPath, 144, j, 1, 1, 0x4b000L, ((List) (obj)), exportprogresslistener);
        if (true)
        {
            unlock();
        }
_L1:
        mAspectRatio = k;
        if (file.length() > 0x4b000L)
        {
            file.delete();
            throw new RuntimeException("Generated File size > MAX_MMS_CLIP_SIZE; reduce Input file duration and retry");
        } else
        {
            return file.length();
        }
        s;
        flag1 = flag;
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export");
        if (flag)
        {
            unlock();
        }
          goto _L1
        s;
        if (flag1)
        {
            unlock();
        }
        throw s;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public int getAspectRatio()
    {
        return mAspectRatio;
    }

    public long getDuration()
    {
        computeTimelineDuration();
        return mDurationMs;
    }

    MediaArtistNativeHelper getNativeContext()
    {
        return mMANativeHelper;
    }

    public String getPath()
    {
        return mProjectPath;
    }

    public void release()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        lock();
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag = flag2;
        flag1 = flag3;
        if (mMANativeHelper == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        flag = flag2;
        flag1 = flag3;
        mMediaItems.clear();
        flag = flag2;
        flag1 = flag3;
        mMANativeHelper.releaseNativeHelper();
        flag = flag2;
        flag1 = flag3;
        mMANativeHelper = null;
        if (true)
        {
            unlock();
        }
_L2:
        return;
        Object obj;
        obj;
        flag1 = flag;
        Log.e("VideoEditorImpl", "Sem acquire NOT successful in export", ((Throwable) (obj)));
        if (!flag) goto _L2; else goto _L1
_L1:
        unlock();
        return;
        obj;
        if (flag1)
        {
            unlock();
        }
        throw obj;
    }

    public MediaItem removeMediaItem(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (mMediaItems.size() <= 0) goto _L2; else goto _L1
_L1:
        MediaItem mediaitem = (MediaItem)mMediaItems.get(0);
        if (mediaitem == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        mMediaItems.remove(mediaitem);
        s = mediaitem;
        if (mMediaItems.size() != 0)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        mIsList3D = false;
        mIsFirstVideoItemAdded = false;
        s = mediaitem;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setAspectRatio(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mAspectRatio = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void updateTimelineDuration()
    {
        computeTimelineDuration();
    }
}
