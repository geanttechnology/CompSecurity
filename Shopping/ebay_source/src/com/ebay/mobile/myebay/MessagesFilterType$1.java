// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;


// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesFilterType

static class 
{

    static final int $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType = new int[MessagesFilterType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_ALL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_EBAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_FLAGGED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_MEMBER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_PRIORITY.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$myebay$MessagesFilterType[MessagesFilterType.FILTER_UNREAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
