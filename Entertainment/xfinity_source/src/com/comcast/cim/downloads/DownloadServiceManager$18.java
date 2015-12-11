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

class val.resultCallback
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
        final IVirtuosoHLSFile hlsFile;
        StopWatch stopwatch;
        Object obj;
        Object obj1;
        try
        {
            stopwatch = new StopWatch();
            stopwatch.start();
            obj = val$simplePlaylist.getRelativeSequencePaths();
            hlsFile = Lists.newArrayList();
            if (val$alternateAudioPlaylist != null)
            {
                hlsFile = val$alternateAudioPlaylist.getRelativeSequencePaths();
            }
            obj1 = new ArrayList(((List) (obj)).size() + hlsFile.size());
            com.comcast.cim.cmasl.hls.Segment segment2;
            for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((List) (obj1)).add((new StringBuilder()).append(val$simplePlaylist.getUrlPathPrefix()).append(segment2.getPath()).toString()))
            {
                segment2 = (com.comcast.cim.cmasl.hls.Segment)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (final IVirtuosoHLSFile hlsFile)
        {
            val$resultCallback.onFailure(new DownloadServiceException(hlsFile));
            return;
        }
        com.comcast.cim.cmasl.hls.Segment segment3;
        for (Iterator iterator1 = hlsFile.iterator(); iterator1.hasNext(); ((List) (obj1)).add((new StringBuilder()).append(val$alternateAudioPlaylist.getUrlPathPrefix()).append(segment3.getPath()).toString()))
        {
            segment3 = (com.comcast.cim.cmasl.hls.Segment)iterator1.next();
        }

        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added ").append(((List) (obj)).size()).append(" segments").toString());
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added ").append(hlsFile.size()).append(" audio segments").toString());
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Created full path list in ").append(stopwatch).append(" seconds").toString());
        stopwatch.reset();
        stopwatch.start();
        hlsFile = createHlsFile(((List) (obj1)), val$assetId, val$metaData);
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Created Virtuoso File in ").append(stopwatch).append(" seconds").toString());
        stopwatch.reset();
        stopwatch.start();
        obj1 = val$variantPlaylist.getMediaProfiles();
        obj = Lists.newArrayList();
        com.comcast.cim.cmasl.hls.ofile ofile;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(ofile))
        {
            ofile = (com.comcast.cim.cmasl.hls.ofile)((Iterator) (obj1)).next();
            ofile.setRelativePath("simple.m3u8");
        }

        val$variantPlaylist.setMediaProfiles(((List) (obj)));
        Object obj2 = val$variantPlaylist.getAudioProfiles();
        obj = Lists.newArrayList();
        com.comcast.cim.cmasl.hls.dioProfile dioprofile;
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(dioprofile))
        {
            dioprofile = (com.comcast.cim.cmasl.hls.dioProfile)((Iterator) (obj2)).next();
            if (dioprofile.getUriString() != null)
            {
                dioprofile.setUriString("\"audio.m3u8\"");
            }
        }

        val$variantPlaylist.setAudioProfiles(((List) (obj)));
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Variant Playlist in ").append(stopwatch).append(" seconds").toString());
        stopwatch.reset();
        stopwatch.start();
        Object obj3 = val$simplePlaylist.getRelativeSequencePaths();
        obj = new ArrayList(((List) (obj3)).size());
        com.comcast.cim.cmasl.hls.Segment segment;
        for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj)).add(segment))
        {
            segment = (com.comcast.cim.cmasl.hls.Segment)((Iterator) (obj3)).next();
            String s = segment.getPath();
            if (s.lastIndexOf('/') != -1)
            {
                segment.setPath(s.substring(s.lastIndexOf('/') + 1));
            }
        }

        val$simplePlaylist.setSequencePaths(((List) (obj)));
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Simple Playlist in ").append(stopwatch).append(" seconds").toString());
        if (val$alternateAudioPlaylist == null)
        {
            break MISSING_BLOCK_LABEL_903;
        }
        stopwatch.reset();
        stopwatch.start();
        Object obj4 = val$alternateAudioPlaylist.getRelativeSequencePaths();
        obj = new ArrayList(((List) (obj4)).size());
        com.comcast.cim.cmasl.hls.Segment segment1;
        for (obj4 = ((List) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj)).add(segment1))
        {
            segment1 = (com.comcast.cim.cmasl.hls.Segment)((Iterator) (obj4)).next();
            String s1 = segment1.getPath();
            if (s1.lastIndexOf('/') != -1)
            {
                segment1.setPath(s1.substring(s1.lastIndexOf('/') + 1));
            }
        }

        val$alternateAudioPlaylist.setSequencePaths(((List) (obj)));
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Manipulated Alternate Audio Playlist in ").append(stopwatch).append(" seconds").toString());
        stopwatch.reset();
        stopwatch.start();
        obj = hlsFile.localBaseDir();
        val$variantPlaylist.writeToFile(new File(((String) (obj)), "variant.m3u8"));
        val$simplePlaylist.writeToFile(new File(((String) (obj)), "simple.m3u8"));
        if (val$alternateAudioPlaylist != null)
        {
            val$alternateAudioPlaylist.writeToFile(new File(((String) (obj)), "audio.m3u8"));
        }
        stopwatch.stop();
        DownloadServiceManager.access$000().debug((new StringBuilder()).append("Saved Variant & Simple Playlists to disk in ").append(stopwatch).append("seconds").toString());
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager._cls18 this$1;
            final IVirtuosoHLSFile val$hlsFile;

            public void run()
            {
                StopWatch stopwatch1;
                stopwatch1 = new StopWatch();
                stopwatch1.reset();
                stopwatch1.start();
                DownloadServiceManager.access$500(this$0).addToQueue(hlsFile);
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
                stopwatch1.stop();
                DownloadServiceManager.access$000().debug((new StringBuilder()).append("Added Virtuoso File to download Queue in ").append(stopwatch1).append(" seconds").toString());
                resultCallback.onSuccess(null);
                return;
            }

            
            {
                this$1 = DownloadServiceManager._cls18.this;
                hlsFile = ivirtuosohlsfile;
                super();
            }
        });
        return;
        IOException ioexception;
        ioexception;
        deleteUnusedHlsFile(hlsFile);
        throw new ServiceException("Failed to write playlist files", ioexception);
    }

    _cls1.val.hlsFile()
    {
        this$0 = final_downloadservicemanager;
        val$simplePlaylist = hlssimpleplaylist;
        val$alternateAudioPlaylist = hlssimpleplaylist1;
        val$assetId = s;
        val$metaData = downloadmetadata;
        val$variantPlaylist = hlsvariantplaylist;
        val$extraTask = runnable;
        val$resultCallback = FutureCallback.this;
        super();
    }
}
