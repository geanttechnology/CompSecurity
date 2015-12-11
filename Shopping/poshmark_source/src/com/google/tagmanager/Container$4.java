// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Container

static class .Failure
{

    static final int $SwitchMap$com$google$tagmanager$LoadCallback$Failure[];

    static 
    {
        $SwitchMap$com$google$tagmanager$LoadCallback$Failure = new int[.Failure.values().length];
        try
        {
            $SwitchMap$com$google$tagmanager$LoadCallback$Failure[.Failure.NOT_AVAILABLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$google$tagmanager$LoadCallback$Failure[.Failure.IO_ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$google$tagmanager$LoadCallback$Failure[.Failure.SERVER_ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
