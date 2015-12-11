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

public class HlsVariantPlaylist extends HlsPlaylist
{
    public static class MediaAudioProfile
    {

        private String groupId;
        private String language;
        private String mediaInfo;
        private String uriString;

        public String getGroupId()
        {
            return groupId;
        }

        public String getLanguage()
        {
            return language;
        }

        public String getMediaInfo()
        {
            return mediaInfo;
        }

        public String getUriString()
        {
            return uriString;
        }

        public void setUriString(String s)
        {
            String s1 = mediaInfo.substring(0, mediaInfo.indexOf("URI") + "URI".length() + 1);
            s1 = (new StringBuilder()).append(s1).append(s).toString();
            if (mediaInfo.indexOf(uriString) != mediaInfo.length() - uriString.length())
            {
                s1 = mediaInfo.substring(mediaInfo.indexOf("URI") + "URI".length() + 1 + uriString.length());
            }
            mediaInfo = s1;
            uriString = s;
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("uriString=").append(uriString).append(",language=").append(language).append(",groupId=").append(groupId).append(",mediaInfo=").append(mediaInfo).append("]").toString();
        }

        public MediaAudioProfile(String s, String s1, String s2, String s3)
        {
            uriString = s;
            language = s1;
            groupId = s2;
            mediaInfo = s3;
        }
    }

    public static class MediaProfile
    {

        private String audio;
        private int bandwidth;
        private int height;
        private String relativePath;
        private String streamInfo;
        private int width;

        public String getAudio()
        {
            return audio;
        }

        public int getBandwidth()
        {
            return bandwidth;
        }

        public int getHeight()
        {
            return height;
        }

        public String getRelativePath()
        {
            return relativePath;
        }

        public String getStreamInfo()
        {
            return streamInfo;
        }

        public int getWidth()
        {
            return width;
        }

        public void setRelativePath(String s)
        {
            relativePath = s;
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("relativePath=").append(relativePath).append(",bandwidth=").append(bandwidth).append(",streamInfo=").append(streamInfo).append(",audio=").append(audio).append(",width=").append(width).append(",height=").append(height).append("]").toString();
        }

        public MediaProfile(String s, int i, String s1, String s2, int j, int k)
        {
            relativePath = s;
            bandwidth = i;
            streamInfo = s1;
            audio = s2;
            width = j;
            height = k;
        }
    }


    private List audioProfiles;
    private List mediaProfiles;

    public HlsVariantPlaylist()
    {
        mediaProfiles = new ArrayList();
        audioProfiles = new ArrayList();
    }

    public void addMediaAudioProfile(MediaAudioProfile mediaaudioprofile)
    {
        audioProfiles.add(mediaaudioprofile);
    }

    public void addMediaProfile(MediaProfile mediaprofile)
    {
        mediaProfiles.add(mediaprofile);
    }

    public List getAudioProfiles()
    {
        return audioProfiles;
    }

    public List getMediaProfiles()
    {
        return mediaProfiles;
    }

    public void setAudioProfiles(List list)
    {
        audioProfiles = list;
    }

    public void setMediaProfiles(List list)
    {
        mediaProfiles = list;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append(getStartAndVersionString()).toString();
        s = (new StringBuilder()).append(s).append("\n").toString();
        s = (new StringBuilder()).append(s).append(getAllUnknownTags()).toString();
        s = (new StringBuilder()).append(s).append("\n").toString();
        Iterator iterator = audioProfiles.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediaAudioProfile mediaaudioprofile = (MediaAudioProfile)iterator.next();
            if (mediaaudioprofile != null)
            {
                s = (new StringBuilder()).append(s).append("#EXT-X-MEDIA:").append(mediaaudioprofile.getMediaInfo()).toString();
                s = (new StringBuilder()).append(s).append("\n").toString();
            }
        } while (true);
        iterator = mediaProfiles.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediaProfile mediaprofile = (MediaProfile)iterator.next();
            if (mediaprofile != null)
            {
                s = (new StringBuilder()).append(s).append("#EXT-X-STREAM-INF:").append(mediaprofile.getStreamInfo()).toString();
                s = (new StringBuilder()).append(s).append("\n").toString();
                s = (new StringBuilder()).append(s).append(mediaprofile.getRelativePath()).toString();
                s = (new StringBuilder()).append(s).append("\n").toString();
            }
        } while (true);
        return s;
    }

    public void writeToFile(File file)
        throws IOException
    {
        file = new BufferedWriter(new FileWriter(file), 32768);
        Iterator iterator;
        file.write(getStartAndVersionString());
        file.write("\n");
        file.write(getAllUnknownTags());
        file.write("\n");
        iterator = audioProfiles.iterator();
_L2:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_121;
            }
            obj = (MediaAudioProfile)iterator.next();
        } while (obj == null);
        file.write((new StringBuilder()).append("#EXT-X-MEDIA:").append(((MediaAudioProfile) (obj)).getMediaInfo()).toString());
        file.write("\n");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        file.close();
        throw exception;
        exception = mediaProfiles.iterator();
_L3:
        do
        {
            if (!exception.hasNext())
            {
                break MISSING_BLOCK_LABEL_203;
            }
            obj = (MediaProfile)exception.next();
        } while (obj == null);
        file.write((new StringBuilder()).append("#EXT-X-STREAM-INF:").append(((MediaProfile) (obj)).getStreamInfo()).toString());
        file.write("\n");
        file.write(((MediaProfile) (obj)).getRelativePath());
        file.write("\n");
          goto _L3
        file.flush();
        file.close();
        return;
    }
}
