// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import shared_presage.com.google.android.exoplayer.util.CodecSpecificDataUtil;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

private static final class <init> extends <init>
{

    private final List a = new LinkedList();
    private int b;
    private int c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;

    private static String c(String s)
    {
        if (s.equalsIgnoreCase("H264") || s.equalsIgnoreCase("X264") || s.equalsIgnoreCase("AVC1") || s.equalsIgnoreCase("DAVC"))
        {
            return "video/avc";
        }
        if (s.equalsIgnoreCase("AAC") || s.equalsIgnoreCase("AACL") || s.equalsIgnoreCase("AACH") || s.equalsIgnoreCase("AACP"))
        {
            return "audio/mp4a-latm";
        }
        if (s.equalsIgnoreCase("TTML"))
        {
            return "application/ttml+xml";
        } else
        {
            return null;
        }
    }

    public final Object a()
    {
        byte abyte0[][] = null;
        if (!a.isEmpty())
        {
            abyte0 = new byte[a.size()][];
            a.toArray(abyte0);
        }
        return new ment(b, c, d, abyte0, e, f, g, h);
    }

    public final void b(XmlPullParser xmlpullparser)
    {
        boolean flag = false;
        int i = ((Integer)a("Type")).intValue();
        b = b(xmlpullparser, "Index");
        c = c(xmlpullparser, "Bitrate");
        String s;
        if (i == 1)
        {
            f = c(xmlpullparser, "MaxHeight");
            e = c(xmlpullparser, "MaxWidth");
            s = c(a(xmlpullparser, "FourCC"));
        } else
        {
            f = -1;
            e = -1;
            s = xmlpullparser.getAttributeValue(null, "FourCC");
            if (s != null)
            {
                s = c(s);
            } else
            if (i == 0)
            {
                s = "audio/mp4a-latm";
            } else
            {
                s = null;
            }
        }
        d = s;
        if (i == 0)
        {
            g = c(xmlpullparser, "SamplingRate");
            h = c(xmlpullparser, "Channels");
        } else
        {
            g = -1;
            h = -1;
        }
        s = xmlpullparser.getAttributeValue(null, "CodecPrivateData");
        if (s != null && s.length() > 0)
        {
            xmlpullparser = new byte[s.length() / 2];
            for (i = 0; i < xmlpullparser.length; i++)
            {
                int j = i * 2;
                int k = Character.digit(s.charAt(j), 16);
                xmlpullparser[i] = (byte)(Character.digit(s.charAt(j + 1), 16) + (k << 4));
            }

            byte abyte0[][] = CodecSpecificDataUtil.splitNalUnits(xmlpullparser);
            i = ((flag) ? 1 : 0);
            if (abyte0 == null)
            {
                a.add(xmlpullparser);
            } else
            {
                while (i < abyte0.length) 
                {
                    a.add(abyte0[i]);
                    i++;
                }
            }
        }
    }

    public ment(ment ment, String s)
    {
        super(ment, s, "QualityLevel");
    }
}
