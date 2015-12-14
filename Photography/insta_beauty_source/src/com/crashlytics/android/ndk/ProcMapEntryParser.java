// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.crashlytics.android.ndk:
//            ProcMapEntry

final class ProcMapEntryParser
{

    private static final Pattern MAP_REGEX = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.+)");

    private ProcMapEntryParser()
    {
    }

    private static boolean isRelevant(long l, long l1, String s, String s1)
    {
        return s.indexOf('x') != -1 && s1.indexOf('/') != -1;
    }

    public static ProcMapEntry parse(String s)
    {
        Object obj = MAP_REGEX.matcher(s);
        if (((Matcher) (obj)).matches())
        {
            long l = Long.valueOf(((Matcher) (obj)).group(1), 16).longValue();
            long l1 = Long.valueOf(((Matcher) (obj)).group(2), 16).longValue() - l;
            s = ((Matcher) (obj)).group(3);
            obj = ((Matcher) (obj)).group(4);
            if (isRelevant(l, l1, s, ((String) (obj))))
            {
                return new ProcMapEntry(l, l1, ((String) (obj)));
            }
        }
        return null;
    }

}
