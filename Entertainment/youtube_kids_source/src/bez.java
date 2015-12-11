// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public final class bez extends bnt
{

    public bez()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (bgc)bmz1.a(bgc);
        attributes = a.l(attributes.getValue("timeOffset"));
        if (attributes != null)
        {
            if (((bgc) (bmz1)).k == null)
            {
                bmz1.k = new ArrayList();
            }
            ((bgc) (bmz1)).k.add(attributes);
        }
    }
}
