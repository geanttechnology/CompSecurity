// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

final class bea extends bnt
{

    bea()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bvd bvd1;
        bvd1 = (bvd)bmz1.a(bvd);
        attributes = attributes.getValue("event");
        if (attributes != null) goto _L2; else goto _L1
_L1:
        bmo.c("Custom tracking tag missing event attribute - ignoring");
_L5:
        return;
_L2:
        if (!TextUtils.isEmpty(s.trim()))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        bmz1 = Uri.EMPTY;
_L3:
        if ("skip".equals(attributes))
        {
            bvd1.f(bmz1);
            return;
        }
        break MISSING_BLOCK_LABEL_79;
        try
        {
            bmz1 = a.q(s.trim());
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmo.c("Badly formed custom tracking uri - ignoring");
            return;
        }
          goto _L3
        if ("engagedView".equals(attributes))
        {
            bvd1.g(bmz1);
            return;
        }
        if ("skipShown".equals(attributes))
        {
            if (bvd1.D == null)
            {
                bvd1.D = new ArrayList();
            }
            bvd1.D.add(bmz1);
            return;
        }
        if ("videoTitleClicked".equals(attributes))
        {
            if (bvd1.N == null)
            {
                bvd1.N = new ArrayList();
            }
            bvd1.N.add(bmz1);
            return;
        }
        if ("vast2tracking".equals(attributes))
        {
            bvd1.Q = bmz1;
            return;
        }
        if (!"viewable_impression".equals(attributes)) goto _L5; else goto _L4
_L4:
        if (bvd1.ak == null)
        {
            bvd1.ak = new ArrayList();
        }
        bvd1.ak.add(bmz1);
        return;
    }
}
