// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;


// Referenced classes of package com.rdio.android.sdk.internal:
//            PlaybackStateChangedEvent

static class ate
{

    static final int $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[];

    static 
    {
        $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State = new int[ate.values().length];
        try
        {
            $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[ate.Playing.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[ate.Paused.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[ate.Stopped.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[ate.Loading.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[ate.None.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
