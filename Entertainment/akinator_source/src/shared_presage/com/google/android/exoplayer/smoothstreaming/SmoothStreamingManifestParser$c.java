// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser, SmoothStreamingManifest

private static final class i extends i
{

    private int a;
    private int b;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;
    private onElement h;
    private List i;

    public final Object a()
    {
        ement aement[] = new ement[i.size()];
        i.toArray(aement);
        return new SmoothStreamingManifest(a, b, c, d, e, f, g, h, aement);
    }

    public final void a(Object obj)
    {
        if (obj instanceof ement)
        {
            i.add((ement)obj);
        } else
        if (obj instanceof onElement)
        {
            boolean flag;
            if (h == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            h = (onElement)obj;
            return;
        }
    }

    public final void b(XmlPullParser xmlpullparser)
    {
        a = c(xmlpullparser, "MajorVersion");
        b = c(xmlpullparser, "MinorVersion");
        c = a(xmlpullparser, "TimeScale", 0x989680L);
        d = d(xmlpullparser, "Duration");
        e = a(xmlpullparser, "DVRWindowLength", 0L);
        f = b(xmlpullparser, "LookaheadCount");
        xmlpullparser = xmlpullparser.getAttributeValue(null, "IsLive");
        boolean flag;
        if (xmlpullparser != null)
        {
            flag = Boolean.parseBoolean(xmlpullparser);
        } else
        {
            flag = false;
        }
        g = flag;
        a("TimeScale", Long.valueOf(c));
    }

    public onElement(String s)
    {
        super(null, s, "SmoothStreamingMedia");
        f = -1;
        h = null;
        i = new LinkedList();
    }
}
