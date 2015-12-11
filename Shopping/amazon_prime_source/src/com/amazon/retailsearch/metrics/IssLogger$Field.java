// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


// Referenced classes of package com.amazon.retailsearch.metrics:
//            IssLogger

public static final class  extends Enum
{

    private static final RequestId $VALUES[];
    public static final RequestId DataSet;
    public static final RequestId IsFallback;
    public static final RequestId IsMidquery;
    public static final RequestId IsNonPrefix;
    public static final RequestId IsRobot;
    public static final RequestId IsSpellCorrected;
    public static final RequestId IsXcat;
    public static final RequestId Marketplace;
    public static final RequestId Pos;
    public static final RequestId Prefix;
    public static final RequestId RequestId;
    public static final RequestId ServiceName;
    public static final RequestId Size;
    public static final RequestId Source;
    public static final RequestId SourceSearchAlias;
    public static final RequestId Suffix;
    public static final RequestId Suggestion;
    public static final RequestId TargetSearchAlias;
    public static final RequestId UserAction;
    public static final RequestId Weblabs;
    public static final RequestId XcatPos;
    public static final RequestId XcatSize;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/metrics/IssLogger$Field, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DataSet = new <init>("DataSet", 0);
        Marketplace = new <init>("Marketplace", 1);
        SourceSearchAlias = new <init>("SourceSearchAlias", 2);
        TargetSearchAlias = new <init>("TargetSearchAlias", 3);
        ServiceName = new <init>("ServiceName", 4);
        Source = new <init>("Source", 5);
        UserAction = new <init>("UserAction", 6);
        Pos = new <init>("Pos", 7);
        XcatPos = new <init>("XcatPos", 8);
        Size = new <init>("Size", 9);
        XcatSize = new <init>("XcatSize", 10);
        IsSpellCorrected = new <init>("IsSpellCorrected", 11);
        IsXcat = new <init>("IsXcat", 12);
        IsFallback = new <init>("IsFallback", 13);
        IsMidquery = new <init>("IsMidquery", 14);
        IsNonPrefix = new <init>("IsNonPrefix", 15);
        IsRobot = new <init>("IsRobot", 16);
        Weblabs = new <init>("Weblabs", 17);
        Prefix = new <init>("Prefix", 18);
        Suffix = new <init>("Suffix", 19);
        Suggestion = new <init>("Suggestion", 20);
        RequestId = new <init>("RequestId", 21);
        $VALUES = (new .VALUES[] {
            DataSet, Marketplace, SourceSearchAlias, TargetSearchAlias, ServiceName, Source, UserAction, Pos, XcatPos, Size, 
            XcatSize, IsSpellCorrected, IsXcat, IsFallback, IsMidquery, IsNonPrefix, IsRobot, Weblabs, Prefix, Suffix, 
            Suggestion, RequestId
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
