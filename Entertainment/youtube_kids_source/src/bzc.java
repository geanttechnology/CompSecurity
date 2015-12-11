// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

final class bzc extends bnt
{

    bzc(byw byw)
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        ((cdo)bmz1.a(cdo)).b = Uri.parse(s);
    }
}
