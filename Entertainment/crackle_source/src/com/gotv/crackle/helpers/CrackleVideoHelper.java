// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.net.Uri;
import com.gotv.crackle.Application;
import com.gotv.crackle.views.CrackleVideoView;
import com.gotv.crackle.views.FanhattanVideoView;

public class CrackleVideoHelper
{

    private static CrackleVideoHelper sInstance = null;
    public CrackleVideoView crackleVideoView;
    public FanhattanVideoView fanhattanVideoView;

    private CrackleVideoHelper()
    {
    }

    public static CrackleVideoHelper getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new CrackleVideoHelper();
        }
        return sInstance;
    }

    private boolean isFanhattan()
    {
        return Application.isFanhattan();
    }

    public int getCurrentPosition()
    {
        if (isFanhattan())
        {
            return fanhattanVideoView.getCurrentPosition();
        } else
        {
            return crackleVideoView.getCurrentPosition();
        }
    }

    public int getDuration()
    {
        if (isFanhattan())
        {
            return fanhattanVideoView.getDuration();
        } else
        {
            return crackleVideoView.getDuration();
        }
    }

    public int getVisibility()
    {
        if (isFanhattan())
        {
            return fanhattanVideoView.getVisibility();
        } else
        {
            return crackleVideoView.getVisibility();
        }
    }

    public boolean isPlaying()
    {
        if (isFanhattan())
        {
            return fanhattanVideoView.isPlaying();
        } else
        {
            return crackleVideoView.isPlaying();
        }
    }

    public boolean isVideoSetup()
    {
        if (!isFanhattan()) goto _L2; else goto _L1
_L1:
        if (fanhattanVideoView == null) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (crackleVideoView == null)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void pause()
    {
        if (isFanhattan())
        {
            fanhattanVideoView.pause();
            return;
        } else
        {
            crackleVideoView.pause();
            return;
        }
    }

    public boolean requestFocus()
    {
        if (isFanhattan())
        {
            return fanhattanVideoView.requestFocus();
        } else
        {
            return crackleVideoView.requestFocus();
        }
    }

    public void seekTo(int i)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.seekTo(i);
            return;
        } else
        {
            crackleVideoView.seekTo(i);
            return;
        }
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setOnCompletionListener(oncompletionlistener);
            return;
        } else
        {
            crackleVideoView.setOnCompletionListener(oncompletionlistener);
            return;
        }
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setOnErrorListener(onerrorlistener);
            return;
        } else
        {
            crackleVideoView.setOnErrorListener(onerrorlistener);
            return;
        }
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setOnPreparedListener(onpreparedlistener);
            return;
        } else
        {
            crackleVideoView.setOnPreparedListener(onpreparedlistener);
            return;
        }
    }

    public void setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener onseekcompletelistener)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setOnSeekCompleteListener(onseekcompletelistener);
            return;
        } else
        {
            crackleVideoView.setOnSeekCompleteListener(onseekcompletelistener);
            return;
        }
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setOnTouchListener(ontouchlistener);
            return;
        } else
        {
            crackleVideoView.setOnTouchListener(ontouchlistener);
            return;
        }
    }

    public void setVideoURI(Uri uri)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setVideoURI(uri);
            return;
        } else
        {
            crackleVideoView.setVideoURI(uri);
            return;
        }
    }

    public void setVisibility(int i)
    {
        if (isFanhattan())
        {
            fanhattanVideoView.setVisibility(i);
            return;
        } else
        {
            crackleVideoView.setVisibility(i);
            return;
        }
    }

    public void start()
    {
        if (isFanhattan())
        {
            fanhattanVideoView.start();
            return;
        } else
        {
            crackleVideoView.start();
            return;
        }
    }

    public void stopPlayback()
    {
        if (isFanhattan())
        {
            fanhattanVideoView.stopPlayback();
            return;
        } else
        {
            crackleVideoView.stopPlayback();
            return;
        }
    }

}
