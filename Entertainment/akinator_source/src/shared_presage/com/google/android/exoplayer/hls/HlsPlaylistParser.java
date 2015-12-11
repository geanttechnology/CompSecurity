// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import shared_presage.com.google.android.exoplayer.ParserException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.hls:
//            c, Subtitle, Variant, HlsMasterPlaylist, 
//            HlsMediaPlaylist, HlsPlaylist

public final class HlsPlaylistParser
    implements shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    private static final class a
    {

        private final BufferedReader a;
        private final Queue b;
        private String c;

        public final boolean a()
        {
            if (c != null)
            {
                return true;
            }
            if (!b.isEmpty())
            {
                c = (String)b.poll();
                return true;
            }
            do
            {
                String s = a.readLine();
                c = s;
                if (s != null)
                {
                    c = c.trim();
                    if (!c.isEmpty())
                    {
                        return true;
                    }
                } else
                {
                    return false;
                }
            } while (true);
        }

        public final String b()
        {
            if (a())
            {
                String s = c;
                c = null;
                return s;
            } else
            {
                return null;
            }
        }

        public a(Queue queue, BufferedReader bufferedreader)
        {
            b = queue;
            a = bufferedreader;
        }
    }


    private static final String AUDIO_TYPE = "AUDIO";
    private static final String AUTOSELECT_ATTR = "AUTOSELECT";
    private static final Pattern AUTOSELECT_ATTR_REGEX = c.a("AUTOSELECT");
    private static final String BANDWIDTH_ATTR = "BANDWIDTH";
    private static final Pattern BANDWIDTH_ATTR_REGEX = Pattern.compile("BANDWIDTH=(\\d+)\\b");
    private static final Pattern BYTERANGE_REGEX = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final String BYTERANGE_TAG = "#EXT-X-BYTERANGE";
    private static final String CLOSED_CAPTIONS_TYPE = "CLOSED-CAPTIONS";
    private static final String CODECS_ATTR = "CODECS";
    private static final Pattern CODECS_ATTR_REGEX = Pattern.compile("CODECS=\"(.+?)\"");
    private static final String DEFAULT_ATTR = "DEFAULT";
    private static final Pattern DEFAULT_ATTR_REGEX = c.a("DEFAULT");
    private static final String DISCONTINUITY_TAG = "#EXT-X-DISCONTINUITY";
    private static final String ENDLIST_TAG = "#EXT-X-ENDLIST";
    private static final String IV_ATTR = "IV";
    private static final Pattern IV_ATTR_REGEX = Pattern.compile("IV=([^,.*]+)");
    private static final String KEY_TAG = "#EXT-X-KEY";
    private static final String LANGUAGE_ATTR = "LANGUAGE";
    private static final Pattern LANGUAGE_ATTR_REGEX = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern MEDIA_DURATION_REGEX = Pattern.compile("#EXTINF:([\\d.]+)\\b");
    private static final String MEDIA_DURATION_TAG = "#EXTINF";
    private static final Pattern MEDIA_SEQUENCE_REGEX = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final String MEDIA_SEQUENCE_TAG = "#EXT-X-MEDIA-SEQUENCE";
    private static final String MEDIA_TAG = "#EXT-X-MEDIA";
    private static final String METHOD_AES128 = "AES-128";
    private static final String METHOD_ATTR = "METHOD";
    private static final Pattern METHOD_ATTR_REGEX = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final String METHOD_NONE = "NONE";
    private static final String NAME_ATTR = "NAME";
    private static final Pattern NAME_ATTR_REGEX = Pattern.compile("NAME=\"(.+?)\"");
    private static final String RESOLUTION_ATTR = "RESOLUTION";
    private static final Pattern RESOLUTION_ATTR_REGEX = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final String STREAM_INF_TAG = "#EXT-X-STREAM-INF";
    private static final String SUBTITLES_TYPE = "SUBTITLES";
    private static final Pattern TARGET_DURATION_REGEX = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final String TARGET_DURATION_TAG = "#EXT-X-TARGETDURATION";
    private static final String TYPE_ATTR = "TYPE";
    private static final Pattern TYPE_ATTR_REGEX = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final String URI_ATTR = "URI";
    private static final Pattern URI_ATTR_REGEX = Pattern.compile("URI=\"(.+)\"");
    private static final Pattern VERSION_REGEX = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final String VERSION_TAG = "#EXT-X-VERSION";
    private static final String VIDEO_TYPE = "VIDEO";

    public HlsPlaylistParser()
    {
    }

    private static HlsMasterPlaylist parseMasterPlaylist(a a1, String s)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = -1;
        int j = 0;
        int k = -1;
        String s1 = null;
        int l = 0;
        do
        {
            if (!a1.a())
            {
                break;
            }
            Object obj = a1.b();
            if (((String) (obj)).startsWith("#EXT-X-MEDIA"))
            {
                if ("SUBTITLES".equals(c.a(((String) (obj)), TYPE_ATTR_REGEX, "TYPE")))
                {
                    arraylist1.add(new Subtitle(c.a(((String) (obj)), NAME_ATTR_REGEX, "NAME"), c.a(((String) (obj)), URI_ATTR_REGEX, "URI"), c.a(((String) (obj)), LANGUAGE_ATTR_REGEX), c.b(((String) (obj)), DEFAULT_ATTR_REGEX), c.b(((String) (obj)), AUTOSELECT_ATTR_REGEX)));
                }
            } else
            if (((String) (obj)).startsWith("#EXT-X-STREAM-INF"))
            {
                l = c.b(((String) (obj)), BANDWIDTH_ATTR_REGEX, "BANDWIDTH");
                s1 = c.a(((String) (obj)), CODECS_ATTR_REGEX);
                obj = c.a(((String) (obj)), RESOLUTION_ATTR_REGEX);
                boolean flag;
                if (obj != null)
                {
                    obj = ((String) (obj)).split("x");
                    i = Integer.parseInt(obj[0]);
                    k = i;
                    if (i <= 0)
                    {
                        k = -1;
                    }
                    int i1 = Integer.parseInt(obj[1]);
                    j = k;
                    i = i1;
                    if (i1 <= 0)
                    {
                        i = -1;
                        j = k;
                    }
                } else
                {
                    j = -1;
                    i = -1;
                }
                flag = true;
                k = j;
                j = ((flag) ? 1 : 0);
            } else
            if (!((String) (obj)).startsWith("#") && j != 0)
            {
                arraylist.add(new Variant(arraylist.size(), ((String) (obj)), l, s1, k, i));
                i = -1;
                j = 0;
                k = -1;
                s1 = null;
                l = 0;
            }
        } while (true);
        return new HlsMasterPlaylist(s, Collections.unmodifiableList(arraylist), Collections.unmodifiableList(arraylist1));
    }

    private static HlsMediaPlaylist parseMediaPlaylist(a a1, String s)
    {
        double d;
        String s1;
        String s2;
        ArrayList arraylist;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        long l1;
        boolean flag;
        boolean flag1;
        arraylist = new ArrayList();
        flag = false;
        l1 = 0L;
        k = -1;
        flag1 = false;
        s2 = null;
        i = 0;
        i1 = 1;
        l = 0;
        j1 = 0;
        j = 0;
        d = 0.0D;
        s1 = null;
_L3:
        String s4;
        while (a1.a()) 
        {
            s4 = a1.b();
            if (s4.startsWith("#EXT-X-TARGETDURATION"))
            {
                l = c.b(s4, TARGET_DURATION_REGEX, "#EXT-X-TARGETDURATION");
            } else
            if (s4.startsWith("#EXT-X-MEDIA-SEQUENCE"))
            {
                j1 = c.b(s4, MEDIA_SEQUENCE_REGEX, "#EXT-X-MEDIA-SEQUENCE");
                j = j1;
            } else
            if (s4.startsWith("#EXT-X-VERSION"))
            {
                i1 = c.b(s4, VERSION_REGEX, "#EXT-X-VERSION");
            } else
            if (s4.startsWith("#EXTINF"))
            {
                d = Double.parseDouble(c.a(s4, MEDIA_DURATION_REGEX, "#EXTINF"));
            } else
            if (s4.startsWith("#EXT-X-KEY"))
            {
                flag1 = "AES-128".equals(c.a(s4, METHOD_ATTR_REGEX, "METHOD"));
                if (flag1)
                {
                    s2 = c.a(s4, URI_ATTR_REGEX, "URI");
                    s1 = c.a(s4, IV_ATTR_REGEX);
                } else
                {
                    s2 = null;
                    s1 = null;
                }
            } else
            if (s4.startsWith("#EXT-X-BYTERANGE"))
            {
                String as[] = c.a(s4, BYTERANGE_REGEX, "#EXT-X-BYTERANGE").split("@");
                k = Integer.parseInt(as[0]);
                if (as.length > 1)
                {
                    i = Integer.parseInt(as[1]);
                }
            } else
            if (s4.equals("#EXT-X-DISCONTINUITY"))
            {
                flag = true;
            } else
            {
                if (s4.startsWith("#"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                String s3;
                if (!flag1)
                {
                    s3 = null;
                } else
                if (s1 != null)
                {
                    s3 = s1;
                } else
                {
                    s3 = Integer.toHexString(j);
                }
                if (k == -1)
                {
                    i = 0;
                }
                arraylist.add(new HlsMediaPlaylist.Segment(s4, d, flag, l1, flag1, s2, s3, i, k));
                l1 += (long)(1000000D * d);
                flag = false;
                d = 0.0D;
                if (k != -1)
                {
                    i += k;
                }
                k = -1;
                j++;
            }
        }
        flag = true;
          goto _L1
        if (!s4.equals("#EXT-X-ENDLIST")) goto _L3; else goto _L2
_L2:
        flag = false;
_L5:
        return new HlsMediaPlaylist(s, j1, l, i1, flag, Collections.unmodifiableList(arraylist));
_L1:
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final volatile Object parse(String s, InputStream inputstream)
    {
        return parse(s, inputstream);
    }

    public final HlsPlaylist parse(String s, InputStream inputstream)
    {
        LinkedList linkedlist;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        linkedlist = new LinkedList();
_L2:
        String s1 = inputstream.readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        s1 = s1.trim();
        if (s1.isEmpty()) goto _L2; else goto _L1
_L1:
        if (!s1.startsWith("#EXT-X-STREAM-INF"))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        linkedlist.add(s1);
        s = parseMasterPlaylist(new a(linkedlist, inputstream), s);
        inputstream.close();
        return s;
        if (!s1.startsWith("#EXT-X-TARGETDURATION") && !s1.startsWith("#EXT-X-MEDIA-SEQUENCE") && !s1.startsWith("#EXTINF") && !s1.startsWith("#EXT-X-KEY") && !s1.startsWith("#EXT-X-BYTERANGE") && !s1.equals("#EXT-X-DISCONTINUITY") && !s1.equals("#EXT-X-ENDLIST"))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        linkedlist.add(s1);
        s = parseMediaPlaylist(new a(linkedlist, inputstream), s);
        inputstream.close();
        return s;
        linkedlist.add(s1);
          goto _L2
        s;
        inputstream.close();
        throw s;
        inputstream.close();
        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
    }

}
