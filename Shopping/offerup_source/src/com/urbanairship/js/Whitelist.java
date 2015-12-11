// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.js;

import android.net.Uri;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Whitelist
{

    private static final String HOST_REGEX = "((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))";
    private static final String PATH_REGEX = "(/.*)";
    private static final String PATTERN_REGEX;
    private static final String REGEX_SPECIAL_CHARACTERS = "\\.[]{}()^$?+|*";
    private static final String SCHEME_REGEX = "((\\*)|(http)|(https))";
    private static final Pattern VALID_PATTERN;
    private final List uriPatterns = new ArrayList();

    public Whitelist()
    {
    }

    public static Whitelist createDefaultWhitelist(AirshipConfigOptions airshipconfigoptions)
    {
        Whitelist whitelist = new Whitelist();
        whitelist.addEntry("https://*.urbanairship.com");
        if (airshipconfigoptions.whitelist != null)
        {
            airshipconfigoptions = airshipconfigoptions.whitelist;
            int j = airshipconfigoptions.length;
            for (int i = 0; i < j; i++)
            {
                whitelist.addEntry(airshipconfigoptions[i]);
            }

        }
        return whitelist;
    }

    private String escapeRegEx(String s, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        s = s.toCharArray();
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            String s1 = String.valueOf(s[i]);
            if (!flag && s1.equals("*"))
            {
                if (s1.equals("*"))
                {
                    stringbuilder.append(".");
                }
            } else
            if ("\\.[]{}()^$?+|*".contains(s1))
            {
                stringbuilder.append("\\");
            }
            stringbuilder.append(s1);
            i++;
        }
        return stringbuilder.toString();
    }

    public boolean addEntry(String s)
    {
        Pattern pattern = null;
        if (s == null || !VALID_PATTERN.matcher(s).matches())
        {
            Logger.warn((new StringBuilder("Invalid whitelist pattern ")).append(s).toString());
            return false;
        }
        if (s.equals("*"))
        {
            uriPatterns.add(new UriPattern(Pattern.compile("(http)|(https)"), null, null));
            uriPatterns.add(new UriPattern(Pattern.compile("file"), null, Pattern.compile("/.*")));
            return true;
        }
        Object obj1 = Uri.parse(s);
        Object obj = ((Uri) (obj1)).getScheme();
        s = ((Uri) (obj1)).getEncodedAuthority();
        obj1 = ((Uri) (obj1)).getPath();
        if (UAStringUtil.isEmpty(((String) (obj))) || ((String) (obj)).equals("*"))
        {
            obj = Pattern.compile("(http)|(https)");
        } else
        {
            obj = Pattern.compile(((String) (obj)));
        }
        if (UAStringUtil.isEmpty(s) || s.equals("*"))
        {
            s = null;
        } else
        if (s.startsWith("*."))
        {
            s = Pattern.compile((new StringBuilder("(.*\\.)?")).append(escapeRegEx(s.substring(2), true)).toString());
        } else
        {
            s = Pattern.compile(escapeRegEx(s, true));
        }
        if (!UAStringUtil.isEmpty(((String) (obj1))))
        {
            pattern = Pattern.compile(escapeRegEx(((String) (obj1)), false));
        }
        uriPatterns.add(new UriPattern(((Pattern) (obj)), s, pattern));
        return true;
    }

    public boolean isWhitelisted(String s)
    {
        if (s == null)
        {
            return false;
        }
        s = Uri.parse(s);
        for (Iterator iterator = uriPatterns.iterator(); iterator.hasNext();)
        {
            if (((UriPattern)iterator.next()).matches(s))
            {
                return true;
            }
        }

        return false;
    }

    static 
    {
        String s = String.format(Locale.US, "^((\\*)|((%s://%s%s)|(%s://%s)|(file://%s)))", new Object[] {
            "((\\*)|(http)|(https))", "((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", "(/.*)", "((\\*)|(http)|(https))", "((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", "(/.*)"
        });
        PATTERN_REGEX = s;
        VALID_PATTERN = Pattern.compile(s, 2);
    }

    private class UriPattern
    {

        private final Pattern host;
        private final Pattern path;
        private final Pattern scheme;
        final Whitelist this$0;

        boolean matches(Uri uri)
        {
            while (scheme != null && (uri.getScheme() == null || !scheme.matcher(uri.getScheme()).matches()) || host != null && (uri.getHost() == null || !host.matcher(uri.getHost()).matches()) || path != null && (uri.getPath() == null || !path.matcher(uri.getPath()).matches())) 
            {
                return false;
            }
            return true;
        }

        UriPattern(Pattern pattern, Pattern pattern1, Pattern pattern2)
        {
            this$0 = Whitelist.this;
            super();
            scheme = pattern;
            host = pattern1;
            path = pattern2;
        }
    }

}
