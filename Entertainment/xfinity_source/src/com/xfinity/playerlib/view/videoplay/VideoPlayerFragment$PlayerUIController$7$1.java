// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ImageView;
import com.comcast.cim.android.view.common.SAPSelectionListDialogFragment;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import java.util.List;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment, PlayerPlatformMediaPlayer

class val.mediaPlayer
    implements com.comcast.cim.android.view.common.gedListener
{

    final ._cls0 this$2;
    final PlayerPlatformMediaPlayer val$mediaPlayer;

    public void onSelectionChanged(int i)
    {
        val$mediaPlayer.setLanguage(i);
        ImageView imageview = VideoPlayerFragment.access$4500(_fld0);
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imageview.setSelected(flag);
    }

    is._cls1()
    {
        this$2 = final__pcls1;
        val$mediaPlayer = PlayerPlatformMediaPlayer.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7

/* anonymous class */
    class VideoPlayerFragment.PlayerUIController._cls7
        implements Runnable
    {

        final VideoPlayerFragment.PlayerUIController this$1;

        public void run()
        {
            Object obj = VideoPlayerFragment.access$500(this$0).getMediaPlayer();
            Object obj1 = ((VideoPlayerFragment.PlayerUIController._cls7._cls1) (obj)). new VideoPlayerFragment.PlayerUIController._cls7._cls1();
            List list = VideoPlayerFragment.access$500(this$0).getMediaPlayer().getAvailableLanguages();
            obj = new SAPSelectionListDialogFragment(list.indexOf(((PlayerPlatformMediaPlayer) (obj)).getLanguage()), VideoPlayerFragment.access$4500(this$0), ((com.comcast.cim.android.view.common.SelectionListDialogFragment.OnSelectionChangedListener) (obj1)), selectionDialogOnCancelListener, selectionDialogOnKeyListener, getActivity().getActionBar().getHeight());
            obj1 = getActivity().getFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj1)).addToBackStack(null);
            try
            {
                Bundle bundle = new Bundle();
                bundle.putStringArray("data", (String[])list.toArray(new String[list.size()]));
                ((SAPSelectionListDialogFragment) (obj)).setArguments(bundle);
                ((SAPSelectionListDialogFragment) (obj)).show(((FragmentTransaction) (obj1)), "sapselectionlistdialog");
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                VideoPlayerFragment.access$400().error("Caught IllegalStateException when trying to show SAPSelectionListDialogFragment, fragment manager is likely no longer valid because user has moved on", illegalstateexception);
            }
        }

            
            {
                this$1 = VideoPlayerFragment.PlayerUIController.this;
                super();
            }
    }

}
