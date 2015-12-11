// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import java.io.IOException;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.lifevibes.videoeditor:
//            MediaItem, VideoEditorImpl, MediaArtistNativeHelper, VideoEditor

public class MediaVideoItem extends MediaItem
{

    private final int mAspectRatio;
    private final int mAudioBitrate;
    private final int mAudioChannels;
    private final int mAudioSamplingFrequency;
    private final int mAudioType;
    private String mAudioWaveformFilename;
    private long mBeginBoundaryTimeMs;
    private final long mDurationMs;
    private long mEndBoundaryTimeMs;
    private boolean mExclude;
    private long mExcludeBeginTime;
    private long mExcludeEndTime;
    private final int mFileType;
    private final int mFps;
    private final int mHeight;
    private boolean mIsVideo3D;
    private MediaArtistNativeHelper mMANativeHelper;
    private boolean mMuted;
    private Semaphore mThumbnailLock;
    private final int mVideoBitrate;
    private VideoEditorImpl mVideoEditor;
    private final int mVideoProfile;
    private final int mVideoType;
    private int mVolumePercentage;
    private final int mWidth;
    private int originalVolume;

    private MediaVideoItem()
        throws IOException
    {
        this(null, null, null, 0);
    }

    public MediaVideoItem(VideoEditor videoeditor, String s, String s1, int i)
        throws IOException
    {
        this(videoeditor, s, s1, i, 0L, -1L, 100, false, null);
        mThumbnailLock = new Semaphore(1, true);
    }

    MediaVideoItem(VideoEditor videoeditor, String s, String s1, int i, long l, long l1, int j, boolean flag, String s2)
        throws IOException
    {
        super(videoeditor, s, s1, i);
        if (videoeditor instanceof VideoEditorImpl)
        {
            mMANativeHelper = ((VideoEditorImpl)videoeditor).getNativeContext();
            mVideoEditor = (VideoEditorImpl)videoeditor;
        }
        mThumbnailLock = new Semaphore(1, true);
        try
        {
            videoeditor = mMANativeHelper.getMediaProperties(s1);
        }
        // Misplaced declaration of an exception variable
        catch (VideoEditor videoeditor)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(videoeditor.getMessage()).append(" : ").append(s1.substring(s1.lastIndexOf(".") + 1, s1.length())).toString());
        }
        switch (mMANativeHelper.getFileType(((MediaArtistNativeHelper.Properties) (videoeditor)).fileType))
        {
        default:
            throw new IllegalArgumentException(String.format("Unsupported Input File Type (%d)", new Object[] {
                Integer.valueOf(((MediaArtistNativeHelper.Properties) (videoeditor)).fileType)
            }));

        case 0: // '\0'
        case 1: // '\001'
        case 10: // '\n'
            switch (mMANativeHelper.getVideoCodecType(((MediaArtistNativeHelper.Properties) (videoeditor)).videoFormat))
            {
            case 3: // '\003'
            default:
                throw new IllegalArgumentException(String.format("Unsupported Video Codec Format in Input File (%d)", new Object[] {
                    Integer.valueOf(((MediaArtistNativeHelper.Properties) (videoeditor)).videoFormat)
                }));

            case 1: // '\001'
            case 2: // '\002'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
                break;
            }
            break;
        }
        if (((MediaArtistNativeHelper.Properties) (videoeditor)).audioFormat != 0)
        {
            switch (mMANativeHelper.getAudioCodecType(((MediaArtistNativeHelper.Properties) (videoeditor)).audioFormat))
            {
            default:
                throw new IllegalArgumentException(String.format("Unsupported Audio Codec Format in Input File (%d)", new Object[] {
                    Integer.valueOf(((MediaArtistNativeHelper.Properties) (videoeditor)).audioFormat)
                }));

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                break;
            }
        }
        if (((MediaArtistNativeHelper.Properties) (videoeditor)).profileAndLevel == 255)
        {
            throw new IllegalArgumentException(String.format("Unsupported Video Codec Profile in Input File (%d)", new Object[] {
                Integer.valueOf(((MediaArtistNativeHelper.Properties) (videoeditor)).profileAndLevel)
            }));
        }
        mIsVideo3D = ((MediaArtistNativeHelper.Properties) (videoeditor)).bIsVideo3D;
        mWidth = ((MediaArtistNativeHelper.Properties) (videoeditor)).width;
        mHeight = ((MediaArtistNativeHelper.Properties) (videoeditor)).height;
        mAspectRatio = mMANativeHelper.getAspectRatio(((MediaArtistNativeHelper.Properties) (videoeditor)).width, ((MediaArtistNativeHelper.Properties) (videoeditor)).height);
        mFileType = mMANativeHelper.getFileType(((MediaArtistNativeHelper.Properties) (videoeditor)).fileType);
        mVideoType = mMANativeHelper.getVideoCodecType(((MediaArtistNativeHelper.Properties) (videoeditor)).videoFormat);
        mVideoProfile = ((MediaArtistNativeHelper.Properties) (videoeditor)).profileAndLevel;
        mDurationMs = ((MediaArtistNativeHelper.Properties) (videoeditor)).videoDuration;
        mVideoBitrate = ((MediaArtistNativeHelper.Properties) (videoeditor)).videoBitrate;
        mAudioBitrate = ((MediaArtistNativeHelper.Properties) (videoeditor)).audioBitrate;
        mFps = (int)((MediaArtistNativeHelper.Properties) (videoeditor)).averageFrameRate;
        mAudioType = mMANativeHelper.getAudioCodecType(((MediaArtistNativeHelper.Properties) (videoeditor)).audioFormat);
        mAudioChannels = ((MediaArtistNativeHelper.Properties) (videoeditor)).audioChannels;
        mAudioSamplingFrequency = ((MediaArtistNativeHelper.Properties) (videoeditor)).audioSamplingFrequency;
        mBeginBoundaryTimeMs = l;
        l = l1;
        if (l1 == -1L)
        {
            l = mDurationMs;
        }
        mEndBoundaryTimeMs = l;
        mVolumePercentage = j;
        originalVolume = j;
        mMuted = flag;
        mAudioWaveformFilename = s2;
        mExcludeBeginTime = 0L;
        mExcludeEndTime = 0L;
        mExclude = false;
    }

    private void thumbnailLock()
        throws InterruptedException
    {
        mThumbnailLock.acquire();
    }

    private void thumbnailUnlock()
    {
        mThumbnailLock.release();
    }

    public int getAspectRatio()
    {
        return mAspectRatio;
    }

    public int getAudioBitrate()
    {
        return mAudioBitrate;
    }

    public int getAudioChannels()
    {
        return mAudioChannels;
    }

    public int getAudioSamplingFrequency()
    {
        return mAudioSamplingFrequency;
    }

    public int getAudioType()
    {
        return mAudioType;
    }

    public long getBoundaryBeginTime()
    {
        return mBeginBoundaryTimeMs;
    }

    public long getBoundaryEndTime()
    {
        return mEndBoundaryTimeMs;
    }

    public long getDuration()
    {
        return mDurationMs;
    }

    long getExcludeBeginTime()
    {
        return mExcludeBeginTime;
    }

    long getExcludeEndTime()
    {
        return mExcludeEndTime;
    }

    public int getFileType()
    {
        return mFileType;
    }

    public int getFps()
    {
        return mFps;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public long getTimelineDuration()
    {
        if (!mExclude)
        {
            return mEndBoundaryTimeMs - mBeginBoundaryTimeMs;
        } else
        {
            return (mExcludeBeginTime - 0L) + (getDuration() - mExcludeEndTime);
        }
    }

    public int getVideoBitrate()
    {
        return mVideoBitrate;
    }

    public int getVideoProfile()
    {
        return mVideoProfile;
    }

    public int getVideoType()
    {
        return mVideoType;
    }

    public int getWidth()
    {
        return mWidth;
    }

    boolean isExcludeCalled()
    {
        return mExclude;
    }

    public boolean isMuted()
    {
        return mMuted;
    }
}
