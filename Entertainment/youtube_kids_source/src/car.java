// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

public final class car extends bnt
{

    public car()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        ((cdv)bmz1.a(cdv)).f = Uri.parse(attributes.getValue("src"));
    }
}
