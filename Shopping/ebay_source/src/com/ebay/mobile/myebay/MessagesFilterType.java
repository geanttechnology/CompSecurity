// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import com.ebay.nautilus.domain.data.EbayMessage;

public final class MessagesFilterType extends Enum
{

    private static final MessagesFilterType $VALUES[];
    public static final MessagesFilterType FILTER_ALL;
    public static final MessagesFilterType FILTER_EBAY;
    public static final MessagesFilterType FILTER_FLAGGED;
    public static final MessagesFilterType FILTER_MEMBER;
    public static final MessagesFilterType FILTER_PRIORITY;
    public static final MessagesFilterType FILTER_UNREAD;

    private MessagesFilterType(String s, int i)
    {
        super(s, i);
    }

    public static boolean doesMessageMatchFilter(MessagesFilterType messagesfiltertype, EbayMessage ebaymessage)
    {
        if (messagesfiltertype == null || ebaymessage == null) goto _L2; else goto _L1
_L1:
        static class _cls1
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

        _cls1..SwitchMap.com.ebay.mobile.myebay.MessagesFilterType[messagesfiltertype.ordinal()];
        JVM INSTR tableswitch 1 6: default 56
    //                   1 58
    //                   2 60
    //                   3 65
    //                   4 70
    //                   5 75
    //                   6 80;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        return false;
_L3:
        return true;
_L4:
        return ebaymessage.isEbayMessage();
_L5:
        return ebaymessage.isFlagged();
_L6:
        return ebaymessage.isMemberMessage();
_L7:
        return ebaymessage.isHighPriority();
_L8:
        return ebaymessage.isUnread();
    }

    public static MessagesFilterType valueOf(String s)
    {
        return (MessagesFilterType)Enum.valueOf(com/ebay/mobile/myebay/MessagesFilterType, s);
    }

    public static MessagesFilterType[] values()
    {
        return (MessagesFilterType[])$VALUES.clone();
    }

    static 
    {
        FILTER_ALL = new MessagesFilterType("FILTER_ALL", 0);
        FILTER_UNREAD = new MessagesFilterType("FILTER_UNREAD", 1);
        FILTER_FLAGGED = new MessagesFilterType("FILTER_FLAGGED", 2);
        FILTER_EBAY = new MessagesFilterType("FILTER_EBAY", 3);
        FILTER_MEMBER = new MessagesFilterType("FILTER_MEMBER", 4);
        FILTER_PRIORITY = new MessagesFilterType("FILTER_PRIORITY", 5);
        $VALUES = (new MessagesFilterType[] {
            FILTER_ALL, FILTER_UNREAD, FILTER_FLAGGED, FILTER_EBAY, FILTER_MEMBER, FILTER_PRIORITY
        });
    }
}
