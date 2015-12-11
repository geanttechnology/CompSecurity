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

class ryingExecutionListener extends ryingExecutionListener
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
            com.comcast.cim.cmasl.hls.file file = (com.comcast.cim.cmasl.hls.file)iterator.next();
            if (file.getWidth() != PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this).getWidth() || file.getHeight() != PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this).getHeight())
            {
                PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).info("Filtering media profile {} as it has a resolution that does match the selected HAL profile", file);
                iterator.remove();
            }
        } while (true);
        if (((List) (obj)).isEmpty())
        {
            PreDownloadFlowFragment.access$1700(PreDownloadFlowFragment.this, new Provider() {

                final PreDownloadFlowFragment._cls13 this$1;

                public CALDialogFragment get()
                {
                    Object obj1 = new Bundle();
                    ((Bundle) (obj1)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.no_matching_profile_error));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                    caldialogfragment.addArguments(((Bundle) (obj1)));
                    obj1 = new ArrayList();
                    ((List) (obj1)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_try_again), new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            PreDownloadFlowFragment.access$300(this$0);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    }));
                    ((List) (obj1)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new CancellingClickListener()));
                    caldialogfragment.setButtonList(((List) (obj1)));
                    caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(this$0));
                    return caldialogfragment;
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$1 = PreDownloadFlowFragment._cls13.this;
                super();
            }
            }, "chooseVideoFormat");
            return;
        }
        Collections.sort(((List) (obj)), PreDownloadFlowFragment.access$1800());
        .SwitchMap.com.xfinity.playerlib.view.programdetails.PreDownloadFlowFragment.VideoQuality[PreDownloadFlowFragment.access$1900(PreDownloadFlowFragment.this).ordinal()];
        JVM INSTR tableswitch 1 1: default 164
    //                   1 266;
           goto _L1 _L2
_L1:
        obj = (com.comcast.cim.cmasl.hls.file)((List) (obj)).get(((List) (obj)).size() - 1);
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
        com.comcast.cim.cmasl.hls.ioProfile ioprofile = (com.comcast.cim.cmasl.hls.ioProfile)iterator1.next();
        if (((com.comcast.cim.cmasl.hls.file) (obj)).getAudio() != null && !((com.comcast.cim.cmasl.hls.file) (obj)).getAudio().equals(ioprofile.getGroupId()))
        {
            iterator1.remove();
        } else
        if (ioprofile.getUriString() == null)
        {
            arraylist.add(ioprofile);
            iterator1.remove();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = (com.comcast.cim.cmasl.hls.file)((List) (obj)).get(0);
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        if (!arraylist1.isEmpty())
        {
            Collections.sort(arraylist1, PreDownloadFlowFragment.access$2000());
            PreDownloadFlowFragment.access$2102(PreDownloadFlowFragment.this, (com.comcast.cim.cmasl.hls.ioProfile)arraylist1.get(0));
            arraylist.add(PreDownloadFlowFragment.access$2100(PreDownloadFlowFragment.this));
        }
        hlsvariantplaylist.setAudioProfiles(arraylist);
        PreDownloadFlowFragment.access$2202(PreDownloadFlowFragment.this, hlsvariantplaylist);
        PreDownloadFlowFragment.access$2300(PreDownloadFlowFragment.this, ((com.comcast.cim.cmasl.hls.file) (obj)));
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((HlsVariantPlaylist)obj);
    }

    _cls1.this._cls1(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
