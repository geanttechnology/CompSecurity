// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface al
{

    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "timer", "custom-metric", "custom-string-metric"
    })));
    public static final int c = (int)TimeUnit.MILLISECONDS.convert(5L, TimeUnit.MINUTES);
    public static final long d = TimeUnit.MILLISECONDS.convert(1L, TimeUnit.HOURS);

}
