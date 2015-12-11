// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Locale;
import org.xml.sax.Attributes;

public final class cab extends bnt
{

    public cab()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = s.toUpperCase(Locale.US);
        try
        {
            ((cds)bmz1.a(cds)).c = cdt.valueOf(attributes);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmz1 = String.valueOf(attributes);
        }
        if (bmz1.length() != 0)
        {
            bmz1 = "Unexpected status ".concat(bmz1);
        } else
        {
            bmz1 = new String("Unexpected status ");
        }
        bmo.c(bmz1);
    }
}
