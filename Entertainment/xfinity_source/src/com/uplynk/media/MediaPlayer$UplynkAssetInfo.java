// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.uplynk.media:
//            MediaPlayer

public class _isValid
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

    public (String s)
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
