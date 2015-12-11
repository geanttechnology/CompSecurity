// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import com.penthera.virtuososdk.client.ServiceException;
import com.penthera.virtuososdk.client.Virtuoso;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager, DownloadServiceException, DownloadMetaData

class val.hlsFile
    implements Runnable
{

    final cess this$1;
    final IVirtuosoHLSFile val$hlsFile;

    public void run()
    {
        StopWatch stopwatch;
        stopwatch = new StopWatch();
        stopwatch.reset();
        stopwatch.start();
        DownloadServiceManager.access$500(_fld0).addToQueue(val$hlsFile);
        try
        {
            if (extraTask != null)
            {
                extraTask.run();
            }
        }
        catch (Exception exception)
        {
            try
            {
                throw new ServiceException(exception);
            }
            catch (ServiceException serviceexception)
            {
                resultCallback.onFailure(new DownloadServiceException(serviceexception));
            }
            return;
        }
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added Virtuoso File to download Queue in ").append(stopwatch).append(" seconds").toString());
        resultCallback.onSuccess(null);
        return;
    }

    l.resultCallback()
    {
        this$1 = final_resultcallback;
        val$hlsFile = IVirtuosoHLSFile.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$18

/* anonymous class */
    class DownloadServiceManager._cls18
        implements Runnable
    {

        final DownloadServiceManager this$0;
        final HlsSimplePlaylist val$alternateAudioPlaylist;
        final String val$assetId;
        final Runnable val$extraTask;
        final DownloadMetaData val$metaData;
        final FutureCallback val$resultCallback;
        final HlsSimplePlaylist val$simplePlaylist;
        final HlsVariantPlaylist val$variantPlaylist;

        public void run()
        {
            Object obj;
            StopWatch stopwatch;
            Object obj1;
            Object obj2;
            try
            {
                stopwatch = new StopWatch();
                stopwatch.start();
                obj1 = simplePlaylist.getRelativeSequencePaths();
                obj = Lists.newArrayList();
                if (alternateAudioPlaylist != null)
                {
                    obj = alternateAudioPlaylist.getRelativeSequencePaths();
                }
                obj2 = new ArrayList(((List) (obj1)).size() + ((List) (obj)).size());
                com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment2;
                for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((List) (obj2)).add((new StringBuilder()).append(simplePlaylist.getUrlPathPrefix()).append(sequencesegment2.getPath()).toString()))
                {
                    sequencesegment2 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                resultCallback.onFailure(new DownloadServiceException(((Throwable) (obj))));
                return;
            }
            com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment3;
            for (Iterator iterator1 = ((List) (obj)).iterator(); iterator1.hasNext(); ((List) (obj2)).add((new StringBuilder()).append(alternateAudioPlaylist.getUrlPathPrefix()).append(sequencesegment3.getPath()).toString()))
            {
                sequencesegment3 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)iterator1.next();
            }

            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added ").append(((List) (obj1)).size()).append(" segments").toString());
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added ").append(((List) (obj)).size()).append(" audio segments").toString());
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Created full path list in ").append(stopwatch).append(" seconds").toString());
            stopwatch.reset();
            stopwatch.start();
            obj = createHlsFile(((List) (obj2)), assetId, metaData);
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Created Virtuoso File in ").append(stopwatch).append(" seconds").toString());
            stopwatch.reset();
            stopwatch.start();
            obj2 = variantPlaylist.getMediaProfiles();
            obj1 = Lists.newArrayList();
            com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile;
            for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj1)).add(mediaprofile))
            {
                mediaprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((Iterator) (obj2)).next();
                mediaprofile.setRelativePath("simple.m3u8");
            }

            variantPlaylist.setMediaProfiles(((List) (obj1)));
            Object obj3 = variantPlaylist.getAudioProfiles();
            obj1 = Lists.newArrayList();
            com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile;
            for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj1)).add(mediaaudioprofile))
            {
                mediaaudioprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)((Iterator) (obj3)).next();
                if (mediaaudioprofile.getUriString() != null)
                {
                    mediaaudioprofile.setUriString("\"audio.m3u8\"");
                }
            }

            variantPlaylist.setAudioProfiles(((List) (obj1)));
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Variant Playlist in ").append(stopwatch).append(" seconds").toString());
            stopwatch.reset();
            stopwatch.start();
            Object obj4 = simplePlaylist.getRelativeSequencePaths();
            obj1 = new ArrayList(((List) (obj4)).size());
            com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment;
            for (obj4 = ((List) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj1)).add(sequencesegment))
            {
                sequencesegment = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)((Iterator) (obj4)).next();
                String s = sequencesegment.getPath();
                if (s.lastIndexOf('/') != -1)
                {
                    sequencesegment.setPath(s.substring(s.lastIndexOf('/') + 1));
                }
            }

            simplePlaylist.setSequencePaths(((List) (obj1)));
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Simple Playlist in ").append(stopwatch).append(" seconds").toString());
            if (alternateAudioPlaylist == null)
            {
                break MISSING_BLOCK_LABEL_903;
            }
            stopwatch.reset();
            stopwatch.start();
            Object obj5 = alternateAudioPlaylist.getRelativeSequencePaths();
            obj1 = new ArrayList(((List) (obj5)).size());
            com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment1;
            for (obj5 = ((List) (obj5)).iterator(); ((Iterator) (obj5)).hasNext(); ((List) (obj1)).add(sequencesegment1))
            {
                sequencesegment1 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)((Iterator) (obj5)).next();
                String s1 = sequencesegment1.getPath();
                if (s1.lastIndexOf('/') != -1)
                {
                    sequencesegment1.setPath(s1.substring(s1.lastIndexOf('/') + 1));
                }
            }

            alternateAudioPlaylist.setSequencePaths(((List) (obj1)));
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Alternate Audio Playlist in ").append(stopwatch).append(" seconds").toString());
            stopwatch.reset();
            stopwatch.start();
            obj1 = ((IVirtuosoHLSFile) (obj)).localBaseDir();
            variantPlaylist.writeToFile(new File(((String) (obj1)), "variant.m3u8"));
            simplePlaylist.writeToFile(new File(((String) (obj1)), "simple.m3u8"));
            if (alternateAudioPlaylist != null)
            {
                alternateAudioPlaylist.writeToFile(new File(((String) (obj1)), "audio.m3u8"));
            }
            stopwatch.stop();
            DownloadServiceManager.access$000().debug((new StringBuilder()).append("Saved Variant & Simple Playlists to disk in ").append(stopwatch).append("seconds").toString());
            foregroundExecutor.execute(((DownloadServiceManager._cls18._cls1) (obj)). new DownloadServiceManager._cls18._cls1());
            return;
            IOException ioexception;
            ioexception;
            deleteUnusedHlsFile(((IVirtuosoHLSFile) (obj)));
            throw new ServiceException("Failed to write playlist files", ioexception);
        }

            
            {
                this$0 = final_downloadservicemanager;
                simplePlaylist = hlssimpleplaylist;
                alternateAudioPlaylist = hlssimpleplaylist1;
                assetId = s;
                metaData = downloadmetadata;
                variantPlaylist = hlsvariantplaylist;
                extraTask = runnable;
                resultCallback = FutureCallback.this;
                super();
            }
    }

}
