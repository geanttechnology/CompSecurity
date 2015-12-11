// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;


public final class TaggingOutcome extends Enum
{

    private static final TaggingOutcome $VALUES[];
    public static final TaggingOutcome BG_CANCELED;
    public static final TaggingOutcome CANCELED;
    public static final TaggingOutcome ERROR;
    public static final TaggingOutcome MATCH;
    public static final TaggingOutcome NO_MATCH;
    public static final TaggingOutcome UNKNOWN;
    public static final TaggingOutcome UNSUBMITTED;
    private final String outcome;

    private TaggingOutcome(String s, int i, String s1)
    {
        super(s, i);
        outcome = s1;
    }

    public static TaggingOutcome valueOf(String s)
    {
        return (TaggingOutcome)Enum.valueOf(com/shazam/android/analytics/TaggingOutcome, s);
    }

    public static TaggingOutcome[] values()
    {
        return (TaggingOutcome[])$VALUES.clone();
    }

    public final String getOutcome()
    {
        return outcome;
    }

    static 
    {
        UNKNOWN = new TaggingOutcome("UNKNOWN", 0, "unknown");
        MATCH = new TaggingOutcome("MATCH", 1, "match");
        NO_MATCH = new TaggingOutcome("NO_MATCH", 2, "nomatch");
        ERROR = new TaggingOutcome("ERROR", 3, "error");
        CANCELED = new TaggingOutcome("CANCELED", 4, "canceled");
        BG_CANCELED = new TaggingOutcome("BG_CANCELED", 5, "bgcanceled");
        UNSUBMITTED = new TaggingOutcome("UNSUBMITTED", 6, "unsubmitted");
        $VALUES = (new TaggingOutcome[] {
            UNKNOWN, MATCH, NO_MATCH, ERROR, CANCELED, BG_CANCELED, UNSUBMITTED
        });
    }
}
