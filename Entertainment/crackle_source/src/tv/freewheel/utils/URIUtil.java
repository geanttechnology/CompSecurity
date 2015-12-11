// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIUtil
{

    public URIUtil()
    {
    }

    public static String getFixedString(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = new URL(s);
            s = (new URI(s.getProtocol(), s.getAuthority(), s.getPath(), s.getQuery(), s.getRef())).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }
}
