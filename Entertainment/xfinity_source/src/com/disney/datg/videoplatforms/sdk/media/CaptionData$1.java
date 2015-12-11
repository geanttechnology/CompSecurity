// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            CaptionData

static class 
{

    static final int $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[];
    static final int $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[];

    static 
    {
        $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType = new int[com.uplynk.media.aptionEventType.values().length];
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.aptionEventType.LINEBREAK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.aptionEventType.TEXT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.aptionEventType.CLEAR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode = new int[com.uplynk.media.aptionMode.values().length];
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.aptionMode.UNKNOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.aptionMode.POP_ON.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.aptionMode.ROLL_UP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.aptionMode.PAINT_ON.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.aptionMode.TEXT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
