// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

public final class caq extends bnt
{

    public caq()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        if (attributes.getValue("rel").equals("edit"))
        {
            ((cdv)bmz1.a(cdv)).g = Uri.parse(attributes.getValue("href"));
        }
    }
}
