// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryMediaController

public class GalleryMediaControllerHelper
    implements GalleryMediaController
{

    private List backKeyPressedListeners;
    protected int fastForwardMilliseconds;
    private android.widget.MediaController.MediaPlayerControl mediaPlayer;
    protected int rewindMilliseconds;
    private List visibilityChangeListeners;

    public GalleryMediaControllerHelper()
    {
        visibilityChangeListeners = new ArrayList();
        backKeyPressedListeners = new ArrayList();
        rewindMilliseconds = 5000;
        fastForwardMilliseconds = 1500;
    }

    public void addBackKeyPressedListener(GalleryMediaController.OnBackKeyPressedListener onbackkeypressedlistener)
    {
        backKeyPressedListeners.add(onbackkeypressedlistener);
    }

    public void addOnVisibilityChangeListener(GalleryMediaController.OnVisibilityChangeListener onvisibilitychangelistener)
    {
        visibilityChangeListeners.add(onvisibilitychangelistener);
    }

    public void clearListeners()
    {
        visibilityChangeListeners.clear();
        backKeyPressedListeners.clear();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 6: default 64
    //                   4: 66
    //                   55: 111
    //                   56: 122
    //                   89: 111
    //                   90: 122
    //                   111: 66;
           goto _L1 _L2 _L3 _L4 _L3 _L4 _L2
_L1:
        return false;
_L2:
        boolean flag = false;
        for (keyevent = backKeyPressedListeners.iterator(); keyevent.hasNext();)
        {
            flag = ((GalleryMediaController.OnBackKeyPressedListener)keyevent.next()).onBackKeyPressed();
        }

        if (flag)
        {
            return true;
        }
          goto _L1
_L3:
        seekPlayerByDeltaTime(-rewindMilliseconds);
        return true;
_L4:
        seekPlayerByDeltaTime(fastForwardMilliseconds);
        return true;
    }

    public void hide()
    {
        for (Iterator iterator = visibilityChangeListeners.iterator(); iterator.hasNext(); ((GalleryMediaController.OnVisibilityChangeListener)iterator.next()).hide()) { }
    }

    public void onHideController()
    {
        for (Iterator iterator = visibilityChangeListeners.iterator(); iterator.hasNext(); ((GalleryMediaController.OnVisibilityChangeListener)iterator.next()).onHideController()) { }
    }

    public void removeBackKeyPressedListener(GalleryMediaController.OnBackKeyPressedListener onbackkeypressedlistener)
    {
        backKeyPressedListeners.remove(onbackkeypressedlistener);
    }

    protected void seekPlayerByDeltaTime(int i)
    {
        int j = mediaPlayer.getCurrentPosition();
        mediaPlayer.seekTo(j + i);
        show();
    }

    public void setMediaPlayer(android.widget.MediaController.MediaPlayerControl mediaplayercontrol)
    {
        mediaPlayer = mediaplayercontrol;
    }

    public void show()
    {
        for (Iterator iterator = visibilityChangeListeners.iterator(); iterator.hasNext(); ((GalleryMediaController.OnVisibilityChangeListener)iterator.next()).show()) { }
    }

    public void show(int i)
    {
        for (Iterator iterator = visibilityChangeListeners.iterator(); iterator.hasNext(); ((GalleryMediaController.OnVisibilityChangeListener)iterator.next()).show()) { }
    }

    public void show(int i, boolean flag, boolean flag1)
    {
        if (flag)
        {
            show(i);
        }
    }
}
