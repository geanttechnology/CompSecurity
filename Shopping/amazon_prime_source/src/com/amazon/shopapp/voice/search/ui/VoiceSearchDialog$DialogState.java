// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;


// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            VoiceSearchDialog

public static final class  extends Enum
{

    private static final INVALID_TIME $VALUES[];
    public static final INVALID_TIME DISAMBIGUATION;
    public static final INVALID_TIME INVALID_TIME;
    public static final INVALID_TIME LOADING;
    public static final INVALID_TIME LOW_CONFIDENCE;
    public static final INVALID_TIME NEGATIVE_RESULT;
    public static final INVALID_TIME NETWORK_ERROR;
    public static final INVALID_TIME NONE;
    public static final INVALID_TIME NO_SPEECH;
    public static final INVALID_TIME PROCESSING;
    public static final INVALID_TIME SEARCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/shopapp/voice/search/ui/VoiceSearchDialog$DialogState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        LOADING = new <init>("LOADING", 1);
        SEARCH = new <init>("SEARCH", 2);
        PROCESSING = new <init>("PROCESSING", 3);
        DISAMBIGUATION = new <init>("DISAMBIGUATION", 4);
        LOW_CONFIDENCE = new <init>("LOW_CONFIDENCE", 5);
        NO_SPEECH = new <init>("NO_SPEECH", 6);
        NEGATIVE_RESULT = new <init>("NEGATIVE_RESULT", 7);
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 8);
        INVALID_TIME = new <init>("INVALID_TIME", 9);
        $VALUES = (new .VALUES[] {
            NONE, LOADING, SEARCH, PROCESSING, DISAMBIGUATION, LOW_CONFIDENCE, NO_SPEECH, NEGATIVE_RESULT, NETWORK_ERROR, INVALID_TIME
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
