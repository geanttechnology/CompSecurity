// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import com.uplynk.tools.CpuInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.uplynk.media:
//            CaptionManager, CaptionStyle, CaptionEvent

public class MediaPlayer
{
    private class EventHandler extends Handler
    {

        private MediaPlayer mMediaPlayer;
        final MediaPlayer this$0;

        public void handleMessage(Message message)
        {
            if (mMediaPlayer.mNativeContext != 0) goto _L2; else goto _L1
_L1:
            Log.w("upLynkMediaPlayer", "mediaplayer went away with unhandled events");
_L4:
            return;
_L2:
            message.what;
            JVM INSTR lookupswitch 13: default 136
        //                       0: 18
        //                       1: 162
        //                       2: 189
        //                       3: 244
        //                       4: 275
        //                       5: 302
        //                       6: 402
        //                       7: 747
        //                       100: 511
        //                       200: 660
        //                       201: 738
        //                       400: 775
        //                       401: 1136;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L16:
            continue; /* Loop/switch isn't completed */
_L3:
            Log.e("upLynkMediaPlayer", (new StringBuilder("Unknown message type ")).append(message.what).toString());
            return;
_L5:
            if (mOnPreparedListener != null)
            {
                mOnPreparedListener.onPrepared(mMediaPlayer);
                return;
            }
              goto _L4
_L6:
            if (mOnCompletionListener != null)
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            }
            stayAwake(false);
            if (_ccManager != null)
            {
                _ccManager.reset();
                return;
            }
              goto _L4
_L7:
            if (mOnBufferingUpdateListener != null)
            {
                mOnBufferingUpdateListener.onBufferingUpdate(mMediaPlayer, message.arg1);
                return;
            }
              goto _L4
_L8:
            if (mOnSeekCompleteListener != null)
            {
                mOnSeekCompleteListener.onSeekComplete(mMediaPlayer);
                return;
            }
              goto _L4
_L9:
            if (mOnVideoSizeChangedListener != null)
            {
                mOnVideoSizeChangedListener.onVideoSizeChanged(mMediaPlayer, message.arg1, message.arg2);
            }
            Log.i("upLynkMediaPlayer", (new StringBuilder("Video Resolution Changed: ")).append(message.arg1).append("x").append(message.arg2).toString());
            if (_ccManager != null)
            {
                _ccManager.setVideoSize(message.arg1, message.arg2);
                return;
            }
              goto _L4
_L10:
            if (MediaPlayer.SET_FIXED_SURFACE_SIZE && mSurfaceHolder != null)
            {
                Log.i("upLynkMediaPlayer", (new StringBuilder("Setting window to fixed size of ")).append(message.arg1).append("x").append(message.arg2).toString());
                mSurfaceHolder.setFixedSize(message.arg1, message.arg2);
            }
            Log.i("upLynkMediaPlayer", String.format("Video Window Size Changed: %dx%d", new Object[] {
                Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)
            }));
            return;
_L12:
            Log.e("upLynkMediaPlayer", (new StringBuilder("Error (")).append(message.arg1).append(",").append(message.arg2).append(")").toString());
            boolean flag = false;
            if (mOnErrorListener != null)
            {
                flag = mOnErrorListener.onError(mMediaPlayer, message.arg1, message.arg2);
            }
            if (mOnCompletionListener != null && !flag)
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            }
            stayAwake(false);
            if (_ccManager != null)
            {
                _ccManager.reset();
            }
            _hasCaptions = false;
            return;
_L13:
            Log.i("upLynkMediaPlayer", (new StringBuilder("Info (")).append(message.arg1).append(",").append(message.arg2).append(")").toString());
            if (mOnInfoListener != null)
            {
                mOnInfoListener.onInfo(mMediaPlayer, message.arg1, message.arg2);
                return;
            }
              goto _L4
_L14:
            _hasCaptions = true;
            return;
_L11:
            if (mOnAssetBoundaryListener != null)
            {
                mOnAssetBoundaryListener.onAssetBoundary(mMediaPlayer, null);
                return;
            }
              goto _L4
_L15:
            message = getMetadata();
            if (message == null) goto _L4; else goto _L17
_L17:
            String as[] = message.split("_");
            if (as.length != 3) goto _L4; else goto _L18
_L18:
            String s = as[0];
            if (s == null || s.length() != 32) goto _L20; else goto _L19
_L19:
            int i;
            if (_currentAssetID == null || !s.equals(_currentAssetID))
            {
                _currentAssetID = s;
                if (_ccManager != null)
                {
                    _ccManager.clearDisplay(true);
                }
                if (mOnAssetBoundaryListener != null)
                {
                    mOnAssetBoundaryListener.onAssetBoundary(mMediaPlayer, s);
                }
            }
            if (_currentAssetInfo != null && _currentAssetInfo._assetID.equals(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            message = getAssetInfo(s);
            i = 0;
_L24:
            if (message == null && i < 15) goto _L22; else goto _L21
_L21:
            if (message != null)
            {
                message = new UplynkAssetInfo(message);
                Object obj = MediaPlayer.this;
                InterruptedException interruptedexception;
                if (!((UplynkAssetInfo) (message))._isValid)
                {
                    message = null;
                }
                obj._currentAssetInfo = message;
            } else
            {
                _currentAssetInfo = null;
            }
            if (mOnUplynkMetadataListener == null) goto _L4; else goto _L23
_L23:
            message = new UplynkMetadata(as);
            if (_currentAssetInfo != null)
            {
                message._assetInfo = _currentAssetInfo;
            }
            mOnUplynkMetadataListener.onUplynkMetadata(mMediaPlayer, message);
            return;
_L22:
            Log.d("upLynkMediaPlayer", "AssetInfo not yet available, sleeping");
            Thread.sleep(150L);
            obj = getAssetInfo(s);
            message = ((Message) (obj));
            i++;
              goto _L24
            interruptedexception;
            interruptedexception.printStackTrace();
              goto _L24
_L20:
            Log.w("upLynkMediaPlayer", (new StringBuilder("Invalid Metadata: ")).append(message).toString());
            return;
            if (mOnID3MetadataListener == null) goto _L4; else goto _L25
_L25:
            mOnID3MetadataListener.onID3Metadata(mMediaPlayer, (UplynkID3)message.obj);
            return;
        }

        public EventHandler(MediaPlayer mediaplayer1, Looper looper)
        {
            this$0 = MediaPlayer.this;
            super(looper);
            mMediaPlayer = mediaplayer1;
        }
    }

    public static interface OnAssetBoundaryListener
    {

        public abstract void onAssetBoundary(MediaPlayer mediaplayer, String s);
    }

    public static interface OnBufferingUpdateListener
    {

        public abstract void onBufferingUpdate(MediaPlayer mediaplayer, int i);
    }

    public static interface OnCaptionEventListener
    {

        public abstract boolean onCaptionEvent(MediaPlayer mediaplayer, CaptionEvent captionevent);
    }

    public static interface OnCompletionListener
    {

        public abstract void onCompletion(MediaPlayer mediaplayer);
    }

    public static interface OnErrorListener
    {

        public abstract boolean onError(MediaPlayer mediaplayer, int i, int j);
    }

    public static interface OnID3MetadataListener
    {

        public abstract boolean onID3Metadata(MediaPlayer mediaplayer, UplynkID3 uplynkid3);
    }

    public static interface OnInfoListener
    {

        public abstract boolean onInfo(MediaPlayer mediaplayer, int i, int j);
    }

    public static interface OnPreparedListener
    {

        public abstract void onPrepared(MediaPlayer mediaplayer);
    }

    public static interface OnSeekCompleteListener
    {

        public abstract void onSeekComplete(MediaPlayer mediaplayer);
    }

    public static interface OnUplynkMetadataListener
    {

        public abstract boolean onUplynkMetadata(MediaPlayer mediaplayer, UplynkMetadata uplynkmetadata);
    }

    public static interface OnUplynkSegmentListener
    {

        public abstract boolean onUplynkSegmentList(MediaPlayer mediaplayer, Vector vector);
    }

    public static interface OnVideoSizeChangedListener
    {

        public abstract void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j);
    }

    private class SurfaceListener
        implements android.view.SurfaceHolder.Callback2
    {

        final MediaPlayer this$0;

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
            Log.v("upLynkMediaPlayer", (new StringBuilder("SurfaceListener::surfaceChanged() ")).append(j).append("x").append(k).toString());
            updateSurfaceBounds(0, 0, j, k);
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceCreated()");
            Rect rect = surfaceholder.getSurfaceFrame();
            _setSurface(surfaceholder.getSurface(), rect.left, rect.top, rect.right, rect.bottom);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceDestroyed()");
            if (mNativeContext != 0)
            {
                try
                {
                    _setSurface(null, 0, 0, 0, 0);
                    if (mSurfaceHolder != null)
                    {
                        Log.i("upLynkMediaPlayer", "Display Surface Destroyed - Unlinking SurfaceHolder from Player");
                        mSurfaceHolder.removeCallback(mSurfaceListener);
                        mSurfaceHolder = null;
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (SurfaceHolder surfaceholder)
                {
                    Log.v("upLynkMediaPlayer", "Ignoring IllegalStateException on _setSurface(null,0,0,0,0)");
                    return;
                }
            }
        }

        public void surfaceRedrawNeeded(SurfaceHolder surfaceholder)
        {
            Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceRedrawNeeded()");
        }

        private SurfaceListener()
        {
            this$0 = MediaPlayer.this;
            super();
        }

        SurfaceListener(SurfaceListener surfacelistener)
        {
            this();
        }
    }

    public class UplynkAssetInfo
    {

        protected String _assetID;
        protected boolean _audioOnly;
        protected String _desc;
        protected double _duration;
        protected int _error;
        protected boolean _isAd;
        protected boolean _isValid;
        protected int _maxSlice;
        protected int _movieRating;
        protected String _owner;
        protected int _ratingFlags;
        protected double _sliceDuration;
        protected String _thumbnailPrefix;
        protected int _tvRating;
        final MediaPlayer this$0;

        public String getAssetID()
        {
            return _assetID;
        }

        public String getDescription()
        {
            return _desc;
        }

        public double getDuration()
        {
            return _duration;
        }

        public int getMaxSlice()
        {
            return _maxSlice;
        }

        public int getMovieRating()
        {
            return _movieRating;
        }

        public String getOwner()
        {
            return _owner;
        }

        public int getRatingFlags()
        {
            return _ratingFlags;
        }

        public double getSliceDuration()
        {
            return _sliceDuration;
        }

        public String getThumbnailPrefix()
        {
            return _thumbnailPrefix;
        }

        public int getTvRating()
        {
            return _tvRating;
        }

        public boolean hasError()
        {
            return _error != 0;
        }

        public boolean isAd()
        {
            return _isAd;
        }

        public boolean isAudioOnly()
        {
            return _audioOnly;
        }

        public UplynkAssetInfo(String s)
        {
            boolean flag1 = true;
            this$0 = MediaPlayer.this;
            super();
            _isValid = false;
            boolean flag;
            try
            {
                mediaplayer = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (MediaPlayer mediaplayer)
            {
                Log.w("upLynkMediaPlayer", (new StringBuilder("AssetInfo Error: ")).append(toString()).toString());
                return;
            }
            if (MediaPlayer.this == null)
            {
                break MISSING_BLOCK_LABEL_304;
            }
            if (has("asset"))
            {
                _assetID = getString("asset");
            }
            if (has("error"))
            {
                _error = getInt("error");
            }
            if (_error != 0)
            {
                break MISSING_BLOCK_LABEL_299;
            }
            if (!has("audio_only"))
            {
                break MISSING_BLOCK_LABEL_101;
            }
            if (getInt("audio_only") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _audioOnly = flag;
            if (has("duration"))
            {
                _duration = getDouble("duration");
            }
            if (has("max_slice"))
            {
                _maxSlice = getInt("max_slice");
            }
            if (has("slice_dur"))
            {
                _sliceDuration = getDouble("slice_dur");
            }
            if (has("owner"))
            {
                _owner = getString("owner");
            }
            if (has("thumb_prefix"))
            {
                _thumbnailPrefix = getString("thumb_prefix");
            }
            if (has("desc"))
            {
                _desc = getString("desc");
            }
            if (!has("is_ad"))
            {
                break MISSING_BLOCK_LABEL_242;
            }
            if (getInt("is_ad") == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            _isAd = flag;
            if (has("tv_rating"))
            {
                _tvRating = getInt("tv_rating");
            }
            if (has("movie_rating"))
            {
                _movieRating = getInt("movie_rating");
            }
            if (has("rating_flags"))
            {
                _ratingFlags = getInt("rating_flags");
            }
            _isValid = true;
        }
    }

    public class UplynkID3
    {

        protected String _desc;
        protected String _key;
        protected String _value;
        final MediaPlayer this$0;

        public String getDescription()
        {
            return _desc;
        }

        public String getKey()
        {
            return _key;
        }

        public String getValue()
        {
            return _value;
        }

        protected UplynkID3()
        {
            this$0 = MediaPlayer.this;
            super();
        }

        protected UplynkID3(String s, String s1, String s2)
        {
            this$0 = MediaPlayer.this;
            super();
            _key = s;
            _value = s1;
            _desc = s2;
        }
    }

    public class UplynkMetadata
    {

        protected String _assetID;
        protected UplynkAssetInfo _assetInfo;
        protected String _ray;
        protected String _sliceIndex;
        final MediaPlayer this$0;

        public String getAssetID()
        {
            return _assetID;
        }

        public UplynkAssetInfo getAssetInfo()
        {
            return _assetInfo;
        }

        public String getRay()
        {
            return _ray;
        }

        public String getSliceIndex()
        {
            return _sliceIndex;
        }

        public int getSliceNumber()
        {
            if (_sliceIndex != null)
            {
                int i;
                try
                {
                    i = Integer.parseInt(_sliceIndex, 16);
                }
                catch (NumberFormatException numberformatexception)
                {
                    return 0;
                }
                return i;
            } else
            {
                return 0;
            }
        }

        public String toString()
        {
            return (new StringBuilder(String.valueOf(_assetID))).append(" ").append(_ray).append(" ").append(_sliceIndex).append(" (").append(getSliceNumber()).append(")").toString();
        }

        protected UplynkMetadata()
        {
            this$0 = MediaPlayer.this;
            super();
            _assetID = null;
            _ray = null;
            _sliceIndex = null;
            _assetInfo = null;
        }

        protected UplynkMetadata(String as[])
        {
            this$0 = MediaPlayer.this;
            super();
            _assetID = null;
            _ray = null;
            _sliceIndex = null;
            _assetInfo = null;
            if (as.length < 3)
            {
                return;
            } else
            {
                _assetID = as[0];
                _ray = as[1];
                _sliceIndex = as[2];
                return;
            }
        }
    }

    public class UplynkSegment
    {

        protected String _assetId;
        protected double _duration;
        protected double _offset;
        protected char _type;
        final MediaPlayer this$0;

        public String getAssetId()
        {
            return _assetId;
        }

        public double getDuration()
        {
            return _duration;
        }

        public double getOffset()
        {
            return _offset;
        }

        public char getType()
        {
            return _type;
        }

        public String toString()
        {
            return (new StringBuilder("[")).append(_type).append("] ").append(_assetId).toString();
        }

        protected UplynkSegment()
        {
            this$0 = MediaPlayer.this;
            super();
        }

        protected UplynkSegment(char c, double d, double d1, String s)
        {
            this$0 = MediaPlayer.this;
            super();
            _type = c;
            _duration = d;
            _offset = d1;
            _assetId = s;
        }
    }

    public class UplynkTrackInfo
    {

        protected boolean _autoSelect;
        protected String _group;
        protected boolean _isDefault;
        protected boolean _isEmbedded;
        protected boolean _isForced;
        protected String _lang;
        protected String _name;
        protected char _type;
        final MediaPlayer this$0;

        public String getGroup()
        {
            return _group;
        }

        public String getLang()
        {
            return _lang;
        }

        public String getName()
        {
            return _name;
        }

        public char getType()
        {
            return _type;
        }

        public String toString()
        {
            return String.format("[%s] %s", new Object[] {
                _lang, _name
            });
        }

        protected UplynkTrackInfo()
        {
            this$0 = MediaPlayer.this;
            super();
        }

        protected UplynkTrackInfo(char c, String s, String s1, String s2, boolean flag, boolean flag1, 
                boolean flag2)
        {
            this$0 = MediaPlayer.this;
            super();
            _type = c;
            _name = s;
            _group = s1;
            _lang = s2;
            _isEmbedded = flag;
            _isDefault = flag1;
            _isForced = flag2;
        }
    }


    private static final String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    private static final boolean LOAD_LOLLIPOP_STANDALONE = true;
    private static final boolean LOAD_SHARED_LIB_SET = true;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_CC_DETECTED = 201;
    private static final int MEDIA_DISCONTINUITY = 7;
    private static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED_FORMAT = 400;
    private static final int MEDIA_ID3_METADATA = 401;
    private static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_SET_WINDOW_SIZE = 6;
    private static final int MEDIA_UPLYNK_METADATA = 400;
    public static final int PLAYER_STATE_PAUSED = 4;
    public static final int PLAYER_STATE_PLAYING = 3;
    public static final int PLAYER_STATE_PREPARED = 2;
    public static final int PLAYER_STATE_PREPARING = 1;
    public static final int PLAYER_STATE_STOPPED = 0;
    private static final boolean REQUIRE_UPLYNK_SRC = true;
    private static final boolean SET_FIXED_SURFACE_SIZE;
    private static final int SURFACE_TYPE_NORMAL = 0;
    private static final String TAG = "upLynkMediaPlayer";
    private static int mSurfaceType = 0;
    private CaptionManager _ccManager;
    private String _currentAssetID;
    private UplynkAssetInfo _currentAssetInfo;
    private boolean _hasCaptions;
    private SparseArray _trackOptions;
    private EventHandler mEventHandler;
    private int mListenerContext;
    private int mNativeContext;
    private OnAssetBoundaryListener mOnAssetBoundaryListener;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    protected OnCaptionEventListener mOnCaptionEventListener;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnID3MetadataListener mOnID3MetadataListener;
    private OnInfoListener mOnInfoListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnUplynkMetadataListener mOnUplynkMetadataListener;
    private OnUplynkSegmentListener mOnUplynkSegmentListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private final SurfaceListener mSurfaceListener = new SurfaceListener(null);
    private android.os.PowerManager.WakeLock mWakeLock;
    private String url;

    public MediaPlayer()
    {
        mWakeLock = null;
        _ccManager = new CaptionManager(this);
        _hasCaptions = false;
        _trackOptions = new SparseArray();
        Looper looper = Looper.myLooper();
        if (looper != null)
        {
            mEventHandler = new EventHandler(this, looper);
            CaptionManager captionmanager = _ccManager;
            CaptionManager captionmanager2 = _ccManager;
            captionmanager2.getClass();
            captionmanager.setEventHandler(new CaptionManager.CCEventHandler(captionmanager2, this, _ccManager, looper));
        } else
        {
            Looper looper1 = Looper.getMainLooper();
            if (looper1 != null)
            {
                mEventHandler = new EventHandler(this, looper1);
                CaptionManager captionmanager1 = _ccManager;
                CaptionManager captionmanager3 = _ccManager;
                captionmanager3.getClass();
                captionmanager1.setEventHandler(new CaptionManager.CCEventHandler(captionmanager3, this, _ccManager, looper1));
            } else
            {
                mEventHandler = null;
            }
        }
        nativeSetup(new WeakReference(this));
    }

    private native void _pause()
        throws IllegalStateException;

    private native void _play(String s);

    private native void _reset();

    private native void _resume();

    private native void _seekTo(int i)
        throws IllegalStateException;

    private native void _setDataSource(String s)
        throws IOException, IllegalArgumentException, IllegalStateException;

    private native void _setSurface(Surface surface, int i, int j, int k, int l);

    private native void _start()
        throws IllegalStateException;

    private native void _stop()
        throws IllegalStateException;

    private native void disposePlayer();

    private native String getAssetInfo(String s);

    private native int getContentState();

    private native String getMetadata();

    private static native int getNeededSurfaceType();

    public static void initSurfaceHolder(SurfaceHolder surfaceholder)
    {
        if (surfaceholder == null)
        {
            throw new NullPointerException("SurfaceHolder cannot be null");
        }
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            int i = getNeededSurfaceType();
            mSurfaceType = i;
            surfaceholder.setType(i);
        }
    }

    private static final native void nativeInit(String s, String s1, String s2);

    private final native void nativeSetup(Object obj);

    private static void postCCEventFromNative(Object obj, int i, int j, int k, char ac[])
    {
        if (j != 0)
        {
            StringBuilder stringbuilder = (new StringBuilder("Ignoring CC Data from Channel + ")).append(j).append(": ");
            if (ac != null)
            {
                obj = new String(ac);
            } else
            {
                obj = "null";
            }
            Log.v("upLynkMediaPlayer", stringbuilder.append(((String) (obj))).toString());
        } else
        {
            obj = (MediaPlayer)((WeakReference)obj).get();
            if (obj != null && ((MediaPlayer) (obj))._ccManager != null && ((MediaPlayer) (obj))._ccManager.getEventHandler() != null)
            {
                ac = ((MediaPlayer) (obj))._ccManager.getEventHandler().obtainMessage(i, k, 0, ac);
                ((MediaPlayer) (obj))._ccManager.getEventHandler().sendMessage(ac);
                return;
            }
        }
    }

    private static void postCCPacketFromNative(Object obj, char c, char c1, char c2)
    {
        for (obj = (MediaPlayer)((WeakReference)obj).get(); obj == null || ((MediaPlayer) (obj))._ccManager == null;)
        {
            return;
        }

        ((MediaPlayer) (obj))._ccManager.processPacket(c, c1, c2);
    }

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1)
    {
        for (obj = (MediaPlayer)((WeakReference)obj).get(); obj == null || ((MediaPlayer) (obj)).mEventHandler == null;)
        {
            return;
        }

        obj1 = ((MediaPlayer) (obj)).mEventHandler.obtainMessage(i, j, k, obj1);
        ((MediaPlayer) (obj)).mEventHandler.sendMessage(((Message) (obj1)));
    }

    private static void postMetadataEventFromNative(Object obj, int i, String s, String s1, int j, char ac[])
    {
        for (obj = (MediaPlayer)((WeakReference)obj).get(); obj == null || i != 1 || ((MediaPlayer) (obj)).mOnID3MetadataListener == null || j <= 0;)
        {
            return;
        }

        ac = new String(ac, 0, j - 1);
        EventHandler eventhandler = ((MediaPlayer) (obj)).mEventHandler;
        obj.getClass();
        s = eventhandler.obtainMessage(401, 0, 0, ((UplynkID3) (obj)). new UplynkID3(s, ac, s1));
        ((MediaPlayer) (obj)).mEventHandler.sendMessage(s);
    }

    private void postNativeCrash()
    {
        Log.e("upLynkMediaPlayer", "Unknown Error Caused Player to Abort");
        if (mEventHandler == null)
        {
            return;
        } else
        {
            Message message = mEventHandler.obtainMessage(100, 1000, 1000, null);
            mEventHandler.sendMessage(message);
            return;
        }
    }

    private static void postSegmentListFromNative(Object obj, int i, char ac[])
    {
        obj = (MediaPlayer)((WeakReference)obj).get();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i > 0)
        {
            ac = new String(ac);
            ac.trim();
            ac = ac.split("\\|");
            Vector vector = new Vector();
            i = 0;
            do
            {
                if (i >= ac.length)
                {
                    if (((MediaPlayer) (obj)).mOnUplynkSegmentListener != null)
                    {
                        ((MediaPlayer) (obj)).mOnUplynkSegmentListener.onUplynkSegmentList(((MediaPlayer) (obj)), vector);
                        return;
                    }
                    continue; /* Loop/switch isn't completed */
                }
                String as[] = ac[i].split(":");
                if (as.length != 4)
                {
                    Log.w("upLynkMediaPlayer", String.format("Skipping Invalid Segment Params: %s", new Object[] {
                        ac[i]
                    }));
                } else
                {
                    obj.getClass();
                    vector.add(((UplynkSegment) (obj)). new UplynkSegment(as[0].charAt(0), Double.parseDouble(as[1]), Double.parseDouble(as[2]), as[3]));
                }
                i++;
            } while (true);
        }
        Log.d("upLynkMediaPlayer", "postSegmentListFromNative : No Data");
        return;
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static void postTrackOptionsFromNative(Object obj, int i, char ac[])
    {
        obj = (MediaPlayer)((WeakReference)obj).get();
        if (obj != null)
        {
            if (i > 0)
            {
                ac = new String(ac);
                ac.trim();
                ac = ac.split("\\|");
                ((MediaPlayer) (obj))._trackOptions.clear();
                i = 0;
                while (i < ac.length) 
                {
                    String as[] = ac[i].split(":");
                    if (as.length != 8)
                    {
                        Log.w("upLynkMediaPlayer", String.format("Skipping Invalid Track Params: %s", new Object[] {
                            ac[i]
                        }));
                    } else
                    {
                        obj.getClass();
                        char c = as[0].charAt(0);
                        String s = as[1];
                        String s1 = as[2];
                        String s2 = as[3];
                        UplynkTrackInfo uplynktrackinfo;
                        boolean flag;
                        boolean flag1;
                        boolean flag2;
                        if (as[4].charAt(0) == 'Y')
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (as[5].charAt(0) == 'Y')
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (as[6].charAt(0) == 'Y')
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        uplynktrackinfo = ((UplynkTrackInfo) (obj)). new UplynkTrackInfo(c, s, s1, s2, flag, flag1, flag2);
                        if (((MediaPlayer) (obj))._trackOptions.get(uplynktrackinfo.getType()) == null)
                        {
                            ((MediaPlayer) (obj))._trackOptions.put(uplynktrackinfo.getType(), new Vector());
                        }
                        ((Vector)((MediaPlayer) (obj))._trackOptions.get(uplynktrackinfo.getType())).add(uplynktrackinfo);
                    }
                    i++;
                }
            } else
            {
                Log.d("upLynkMediaPlayer", "postTrackOptionsFromNative : No Data");
                return;
            }
        }
    }

    private native int selectSecondaryTrack(int i, int j);

    private static native void setAppInfo(String s, String s1);

    private void stayAwake(boolean flag)
    {
        if (mWakeLock == null) goto _L2; else goto _L1
_L1:
        if (!flag || mWakeLock.isHeld()) goto _L4; else goto _L3
_L3:
        mWakeLock.acquire();
_L2:
        mStayAwake = flag;
        updateSurfaceScreenOn();
        return;
_L4:
        if (!flag && mWakeLock.isHeld())
        {
            mWakeLock.release();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private native void updateSurfaceBounds(int i, int j, int k, int l);

    private void updateSurfaceScreenOn()
    {
        if (mSurfaceHolder != null)
        {
            SurfaceHolder surfaceholder = mSurfaceHolder;
            boolean flag;
            if (mScreenOnWhilePlaying && mStayAwake)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            surfaceholder.setKeepScreenOn(flag);
        }
    }

    public boolean canPause()
    {
        return !isLive();
    }

    public boolean canSeekBackward()
    {
        return !isLive();
    }

    public boolean canSeekForward()
    {
        return !isLive();
    }

    public native int getAudioSessionId();

    public Vector getAudioTrackOptions()
    {
        return (Vector)_trackOptions.get(65);
    }

    public native int getCurrentPosition();

    public native int getDuration();

    public int getState()
    {
        return getContentState();
    }

    public native int getVideoHeight();

    public native int getVideoWidth();

    public boolean hasCaptions()
    {
        return _hasCaptions;
    }

    protected boolean hasNativeContext()
    {
        return mNativeContext != 0;
    }

    public native boolean isLive();

    public native boolean isPlaying();

    public void pause()
        throws IllegalStateException
    {
        stayAwake(false);
        _pause();
    }

    public native void prepare()
        throws IllegalStateException;

    public native void prepareAsync()
        throws IllegalStateException;

    public void release()
    {
        if (mEventHandler != null)
        {
            mEventHandler.removeCallbacksAndMessages(null);
        }
        if (isPlaying())
        {
            stop();
        }
        stayAwake(false);
        updateSurfaceScreenOn();
        setDisplay(null);
        mOnAssetBoundaryListener = null;
        mOnPreparedListener = null;
        mOnBufferingUpdateListener = null;
        mOnCaptionEventListener = null;
        mOnCompletionListener = null;
        mOnSeekCompleteListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnVideoSizeChangedListener = null;
        mOnUplynkMetadataListener = null;
        mOnID3MetadataListener = null;
        mOnUplynkSegmentListener = null;
        if (_ccManager != null)
        {
            _ccManager.release();
            _ccManager = null;
        }
        disposePlayer();
        Log.d("upLynkMediaPlayer", "MediaPlayer Released");
    }

    public void reset()
    {
        stayAwake(false);
        if (_ccManager != null)
        {
            _ccManager.reset();
        }
        _hasCaptions = false;
        _reset();
        mEventHandler.removeCallbacksAndMessages(null);
    }

    public void seekTo(int i)
        throws IllegalStateException
    {
        if (_ccManager != null)
        {
            _ccManager.reset();
        }
        _seekTo(i);
    }

    public boolean selectAudioTrack(int i)
    {
        selectSecondaryTrack(1, i);
        return true;
    }

    public native void setAudioSessionId(int i)
        throws IllegalStateException;

    public void setAudioStreamType(int i)
    {
    }

    public boolean setCaptionChannel(int i)
    {
        if (_ccManager != null)
        {
            return _ccManager.setPreferredCaptionChannel(i - 1);
        } else
        {
            return false;
        }
    }

    public void setCaptionLayoutContainer(RelativeLayout relativelayout)
    {
        if (_ccManager != null)
        {
            _ccManager.setLayoutContainer(relativelayout);
        }
    }

    public void setCaptionPreviewText(int i, int j, String s)
    {
        if (_ccManager != null)
        {
            _ccManager.setPreviewText(i, j, s);
        }
    }

    public void setCaptionPreviewText(String s)
    {
        setCaptionPreviewText(7, 5, s);
    }

    public void setCaptionStyle(CaptionStyle captionstyle)
    {
        if (_ccManager != null)
        {
            _ccManager.setCaptionStyle(captionstyle);
        }
    }

    public void setCaptionsEnabled(boolean flag)
    {
        if (_ccManager != null)
        {
            _ccManager.setEnabled(flag);
        }
    }

    public void setContext(Context context)
    {
        if (context != null)
        {
            setAppInfo(context.getPackageName(), context.getFilesDir().getPath());
        }
    }

    public void setDataSource(String s)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        Object obj = new URL(s);
        obj = ((URL) (obj)).getHost().toLowerCase();
        if (((String) (obj)).endsWith("uplynk.com") || ((String) (obj)).endsWith("uplynk.dev"))
        {
            _setDataSource(s);
            return;
        }
        try
        {
            throw new IllegalArgumentException("upLynk Source Expected");
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
_L2:
        throw new IllegalArgumentException("Invalid Content URL");
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setDisplay(SurfaceHolder surfaceholder)
    {
        if (mSurfaceHolder != null)
        {
            mSurfaceHolder.removeCallback(mSurfaceListener);
        }
        mSurfaceHolder = surfaceholder;
        if (surfaceholder == null) goto _L2; else goto _L1
_L1:
        if (surfaceholder.getSurface() == null || mSurfaceType <= 0 && !surfaceholder.getSurface().isValid()) goto _L4; else goto _L3
_L3:
        mSurfaceHolder.addCallback(mSurfaceListener);
        mSurface = surfaceholder.getSurface();
        Rect rect = surfaceholder.getSurfaceFrame();
        _setSurface(surfaceholder.getSurface(), rect.left, rect.top, rect.right, rect.bottom);
        updateSurfaceScreenOn();
_L6:
        return;
_L4:
        Log.e("upLynkMediaPlayer", "Surface is invalid");
        mSurfaceHolder = null;
        mSurface = null;
        _setSurface(null, 0, 0, 0, 0);
        return;
_L2:
        mSurface = null;
        if (mNativeContext != 0 && mSurfaceType == 0)
        {
            try
            {
                _setSurface(null, 0, 0, 0, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SurfaceHolder surfaceholder)
            {
                Log.v("upLynkMediaPlayer", "Ignoring IllegalStateException on _setSurface(null, 0, 0, 0, 0)");
            }
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public native void setMaxBitrate(int i);

    public void setOnAssetBoundaryListener(OnAssetBoundaryListener onassetboundarylistener)
    {
        mOnAssetBoundaryListener = onassetboundarylistener;
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onbufferingupdatelistener)
    {
        mOnBufferingUpdateListener = onbufferingupdatelistener;
    }

    public void setOnCaptionEventListener(OnCaptionEventListener oncaptioneventlistener)
    {
        mOnCaptionEventListener = oncaptioneventlistener;
    }

    public void setOnCompletionListener(OnCompletionListener oncompletionlistener)
    {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(OnErrorListener onerrorlistener)
    {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnID3MetadataListener(OnID3MetadataListener onid3metadatalistener)
    {
        mOnID3MetadataListener = onid3metadatalistener;
    }

    public void setOnInfoListener(OnInfoListener oninfolistener)
    {
        mOnInfoListener = oninfolistener;
    }

    public void setOnPreparedListener(OnPreparedListener onpreparedlistener)
    {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onseekcompletelistener)
    {
        mOnSeekCompleteListener = onseekcompletelistener;
    }

    public void setOnUplynkMetadataListener(OnUplynkMetadataListener onuplynkmetadatalistener)
    {
        mOnUplynkMetadataListener = onuplynkmetadatalistener;
    }

    public void setOnUplynkSegmentListener(OnUplynkSegmentListener onuplynksegmentlistener)
    {
        mOnUplynkSegmentListener = onuplynksegmentlistener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onvideosizechangedlistener)
    {
        mOnVideoSizeChangedListener = onvideosizechangedlistener;
    }

    public void setScreenOnWhilePlaying(boolean flag)
    {
        if (mScreenOnWhilePlaying != flag)
        {
            mScreenOnWhilePlaying = flag;
            updateSurfaceScreenOn();
        }
    }

    public void setSurface(Surface surface)
    {
        if (mSurfaceHolder != null)
        {
            mSurfaceHolder.removeCallback(mSurfaceListener);
        }
        mSurfaceHolder = null;
        mSurface = null;
        if (surface != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (mNativeContext == 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        _setSurface(null, 0, 0, 0, 0);
        return;
        surface;
        Log.v("upLynkMediaPlayer", "Ignoring IllegalStateException on _setSurface(null, 0, 0, 0, 0)");
        return;
        mSurface = surface;
        _setSurface(surface, 0, 0, 0, 0);
        return;
    }

    public native void setVolume(float f, float f1);

    public void start()
        throws IllegalStateException
    {
        int i = getContentState();
        stayAwake(true);
        if (i == 4)
        {
            _resume();
            return;
        } else
        {
            _start();
            return;
        }
    }

    public void stop()
        throws IllegalStateException
    {
        stayAwake(false);
        if (_ccManager != null)
        {
            _ccManager.reset();
        }
        _stop();
    }

    static 
    {
        String s;
        String s1;
        boolean flag;
        if ((!Build.MANUFACTURER.equalsIgnoreCase("motorola") || android.os.Build.VERSION.SDK_INT > 10) && (!Build.MANUFACTURER.equalsIgnoreCase("LGE") || android.os.Build.VERSION.SDK_INT > 10) && !Build.MODEL.equalsIgnoreCase("SAMSUNG-SGH-I727") && !Build.MODEL.startsWith("SPH-M820"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        SET_FIXED_SURFACE_SIZE = flag;
        System.loadLibrary("gnustl_shared");
        if (android.os.Build.VERSION.SDK_INT == 9 || android.os.Build.VERSION.SDK_INT == 10)
        {
            s = "_2_3";
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14 && android.os.Build.VERSION.SDK_INT <= 15)
        {
            s = "_4_0";
        } else
        if (android.os.Build.VERSION.SDK_INT == 16)
        {
            s = "_4_1";
        } else
        if (android.os.Build.VERSION.SDK_INT == 17)
        {
            s = "_4_2";
        } else
        if (android.os.Build.VERSION.SDK_INT == 18)
        {
            s = "_4_3";
        } else
        if (android.os.Build.VERSION.SDK_INT == 19)
        {
            s = "_4_4";
        } else
        if (android.os.Build.VERSION.SDK_INT == 21 || android.os.Build.VERSION.SDK_INT == 22)
        {
            s = "_5_0";
            if (android.os.Build.VERSION.RELEASE.equals("M"))
            {
                s = "_6_0";
            }
        } else
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            s = "_6_0";
        } else
        {
            throw new Error((new StringBuilder("SDK Version ")).append(android.os.Build.VERSION.SDK_INT).append(" is not supported").toString());
        }
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            System.loadLibrary("UplynkCore");
            System.loadLibrary((new StringBuilder("uplynk")).append(s).toString());
            System.loadLibrary("UplynkPlayer");
            if (CpuInfo.hasFeature("neon"))
            {
                System.loadLibrary("UplynkNeonExt");
            }
        } else
        {
            System.loadLibrary((new StringBuilder("Uplynk")).append(s).toString());
        }
        s1 = android.os.Build.VERSION.RELEASE;
        s = s1;
        if (s1.equals("M"))
        {
            Log.d("upLynkMediaPlayer", "*** M Preview ***");
            s = "6.0.0";
        }
        nativeInit(s, Build.MANUFACTURER, Build.MODEL);
    }


























}
