// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            DatastoreFactory

static class stenceFormat
{

    static final int $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[];

    static 
    {
        $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat = new int[stenceFormat.values().length];
        try
        {
            $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[stenceFormat.PRIVATE_DATA.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[stenceFormat.DROPBOX.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
