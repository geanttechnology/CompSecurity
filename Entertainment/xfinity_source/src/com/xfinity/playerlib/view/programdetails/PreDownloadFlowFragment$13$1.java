// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.CancellingClickListener;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements Provider
{

    final get this$1;

    public CALDialogFragment get()
    {
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.error));
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
        caldialogfragment.addArguments(((Bundle) (obj)));
        obj = new ArrayList();
        ((List) (obj)).add(new com.comcast.cim.android.view.common.init>(getResources().getString(com.xfinity.playerlib.adFlowFragment.getResources), new android.content.DialogInterface.OnClickListener() {

            final PreDownloadFlowFragment._cls13._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PreDownloadFlowFragment.access$300(this$0);
            }

            
            {
                this$2 = PreDownloadFlowFragment._cls13._cls1.this;
                super();
            }
        }));
        ((List) (obj)).add(new com.comcast.cim.android.view.common.init>(getResources().getString(com.xfinity.playerlib.adFlowFragment.getResources), new CancellingClickListener()));
        caldialogfragment.setButtonList(((List) (obj)));
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(_fld0));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    ingExecutionListener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13

/* anonymous class */
    class PreDownloadFlowFragment._cls13 extends PreDownloadFlowFragment.RetryingExecutionListener
    {

        final PreDownloadFlowFragment this$0;

        public void onPostExecute(HlsVariantPlaylist hlsvariantplaylist)
        {
            Object obj;
            obj = Lists.newArrayList(hlsvariantplaylist.getMediaProfiles());
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)iterator.next();
                if (mediaprofile.getWidth() != PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this).getWidth() || mediaprofile.getHeight() != PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this).getHeight())
                {
                    PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).info("Filtering media profile {} as it has a resolution that does match the selected HAL profile", mediaprofile);
                    iterator.remove();
                }
            } while (true);
            if (((List) (obj)).isEmpty())
            {
                PreDownloadFlowFragment.access$1700(PreDownloadFlowFragment.this, new PreDownloadFlowFragment._cls13._cls1(), "chooseVideoFormat");
                return;
            }
            Collections.sort(((List) (obj)), PreDownloadFlowFragment.access$1800());
            PreDownloadFlowFragment._cls29.$SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality[PreDownloadFlowFragment.access$1900(PreDownloadFlowFragment.this).ordinal()];
            JVM INSTR tableswitch 1 1: default 164
        //                       1 266;
               goto _L1 _L2
_L1:
            obj = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((List) (obj)).get(((List) (obj)).size() - 1);
_L6:
            ArrayList arraylist;
            ArrayList arraylist1;
            Iterator iterator1;
            hlsvariantplaylist.setMediaProfiles(CollectionUtils.createList(obj));
            arraylist = Lists.newArrayList();
            arraylist1 = Lists.newArrayList(hlsvariantplaylist.getAudioProfiles());
            iterator1 = arraylist1.iterator();
_L4:
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)iterator1.next();
            if (((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)).getAudio() != null && !((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)).getAudio().equals(mediaaudioprofile.getGroupId()))
            {
                iterator1.remove();
            } else
            if (mediaaudioprofile.getUriString() == null)
            {
                arraylist.add(mediaaudioprofile);
                iterator1.remove();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            obj = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((List) (obj)).get(0);
            continue; /* Loop/switch isn't completed */
            if (true) goto _L4; else goto _L3
_L3:
            if (!arraylist1.isEmpty())
            {
                Collections.sort(arraylist1, PreDownloadFlowFragment.access$2000());
                PreDownloadFlowFragment.access$2102(PreDownloadFlowFragment.this, (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)arraylist1.get(0));
                arraylist.add(PreDownloadFlowFragment.access$2100(PreDownloadFlowFragment.this));
            }
            hlsvariantplaylist.setAudioProfiles(arraylist);
            PreDownloadFlowFragment.access$2202(PreDownloadFlowFragment.this, hlsvariantplaylist);
            PreDownloadFlowFragment.access$2300(PreDownloadFlowFragment.this, ((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)));
            return;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((HlsVariantPlaylist)obj);
        }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(PreDownloadFlowFragment.this, taskexecutor);
            }
    }

}
