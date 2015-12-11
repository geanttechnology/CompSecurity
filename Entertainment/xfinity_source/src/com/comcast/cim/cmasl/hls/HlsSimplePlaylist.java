// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.cim.cmasl.hls:
//            HlsPlaylist

public class HlsSimplePlaylist extends HlsPlaylist
{
    public static class SequenceSegment
    {

        private String path;
        private String sequenceInfo;
        private double sequenceLength;

        public String getPath()
        {
            return path;
        }

        public String getSequenceInfo()
        {
            return sequenceInfo;
        }

        public double getSequenceLength()
        {
            return sequenceLength;
        }

        public void setPath(String s)
        {
            path = s;
        }



        public SequenceSegment(String s, String s1, double d)
        {
            path = s;
            sequenceInfo = s1;
            sequenceLength = d;
        }
    }


    Integer mediaSequence;
    List sequencePaths;

    public HlsSimplePlaylist()
    {
        mediaSequence = null;
        sequencePaths = new ArrayList();
    }

    public void addSequenceSegment(SequenceSegment sequencesegment)
    {
        sequencePaths.add(sequencesegment);
    }

    public Integer getMediaSequence()
    {
        return mediaSequence;
    }

    public List getRelativeSequencePaths()
    {
        return sequencePaths;
    }

    public void setMediaSequence(Integer integer)
    {
        mediaSequence = null;
    }

    public void setSequencePaths(List list)
    {
        sequencePaths = list;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append(getStartAndVersionString()).toString();
        s = (new StringBuilder()).append(s).append("\n").toString();
        s = (new StringBuilder()).append(s).append(getAllUnknownTags()).toString();
        s = (new StringBuilder()).append(s).append("\n").toString();
        if (mediaSequence != null)
        {
            s = (new StringBuilder()).append(s).append("#EXT-X-MEDIA-SEQUENCE:").append(mediaSequence.toString()).toString();
        } else
        {
            s = (new StringBuilder()).append(s).append("#EXT-X-MEDIA-SEQUENCE:0").toString();
        }
        s = (new StringBuilder()).append(s).append("\n").toString();
        for (Iterator iterator = sequencePaths.iterator(); iterator.hasNext();)
        {
            SequenceSegment sequencesegment = (SequenceSegment)iterator.next();
            s = (new StringBuilder()).append(s).append("#EXTINF:").append(sequencesegment.sequenceInfo).toString();
            s = (new StringBuilder()).append(s).append("\n").toString();
            s = (new StringBuilder()).append(s).append(sequencesegment.path).toString();
            s = (new StringBuilder()).append(s).append("\n").toString();
        }

        return (new StringBuilder()).append(s).append("#EXT-X-ENDLIST\n").toString();
    }

    public void writeToFile(File file)
        throws IOException
    {
        file = new BufferedWriter(new FileWriter(file), 32768);
        file.write(getStartAndVersionString());
        file.write("\n");
        file.write(getAllUnknownTags());
        file.write("\n");
        if (mediaSequence == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        file.write((new StringBuilder()).append("#EXT-X-MEDIA-SEQUENCE:").append(mediaSequence.toString()).toString());
_L1:
        file.write("\n");
        for (Iterator iterator = sequencePaths.iterator(); iterator.hasNext(); file.write("\n"))
        {
            SequenceSegment sequencesegment = (SequenceSegment)iterator.next();
            file.write((new StringBuilder()).append("#EXTINF:").append(sequencesegment.sequenceInfo).toString());
            file.write("\n");
            file.write(sequencesegment.path);
        }

        break MISSING_BLOCK_LABEL_182;
        Exception exception;
        exception;
        file.close();
        throw exception;
        file.write("#EXT-X-MEDIA-SEQUENCE:0");
          goto _L1
        file.write("#EXT-X-ENDLIST\n");
        file.flush();
        file.close();
        return;
    }
}
