// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import android.util.Base64;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import shared_presage.com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

private static final class <init> extends <init>
{

    private boolean a;
    private UUID b;
    private byte c[];

    public final Object a()
    {
        return new onElement(b, PsshAtomUtil.buildPsshAtom(b, c));
    }

    public final void b(XmlPullParser xmlpullparser)
    {
        if ("ProtectionHeader".equals(xmlpullparser.getName()))
        {
            a = true;
            b = UUID.fromString(xmlpullparser.getAttributeValue(null, "SystemID"));
        }
    }

    public final boolean b(String s)
    {
        return "ProtectionHeader".equals(s);
    }

    public final void c(XmlPullParser xmlpullparser)
    {
        if (a)
        {
            c = Base64.decode(xmlpullparser.getText(), 0);
        }
    }

    public final void d(XmlPullParser xmlpullparser)
    {
        if ("ProtectionHeader".equals(xmlpullparser.getName()))
        {
            a = false;
        }
    }

    public onElement(onElement onelement, String s)
    {
        super(onelement, s, "Protection");
    }
}
