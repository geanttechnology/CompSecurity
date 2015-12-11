// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import com.poshmark.ui.fragments.MappPageFragment;

// Referenced classes of package com.poshmark.webcommands:
//            TakePictureCompletionHandler, WebCommand

public abstract class CommandCompletionHandler
{
    static final class HandlerType extends Enum
    {

        private static final HandlerType $VALUES[];
        public static final HandlerType PICTURE;
        public static final HandlerType SIMPLE_CALLBACK;
        public static final HandlerType START_LISTINGS_FLOW;

        public static HandlerType valueOf(String s)
        {
            return (HandlerType)Enum.valueOf(com/poshmark/webcommands/CommandCompletionHandler$HandlerType, s);
        }

        public static HandlerType[] values()
        {
            return (HandlerType[])$VALUES.clone();
        }

        static 
        {
            PICTURE = new HandlerType("PICTURE", 0);
            START_LISTINGS_FLOW = new HandlerType("START_LISTINGS_FLOW", 1);
            SIMPLE_CALLBACK = new HandlerType("SIMPLE_CALLBACK", 2);
            $VALUES = (new HandlerType[] {
                PICTURE, START_LISTINGS_FLOW, SIMPLE_CALLBACK
            });
        }

        private HandlerType(String s, int i)
        {
            super(s, i);
        }
    }


    HandlerType type;

    public CommandCompletionHandler()
    {
        type = HandlerType.SIMPLE_CALLBACK;
    }

    static CommandCompletionHandler factory(HandlerType handlertype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType[];

            static 
            {
                $SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType = new int[HandlerType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$webcommands$CommandCompletionHandler$HandlerType[HandlerType.PICTURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.webcommands.CommandCompletionHandler.HandlerType[handlertype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new TakePictureCompletionHandler();
        }
    }

    public void handleCommandResults(MappPageFragment mapppagefragment, WebCommand webcommand, Intent intent)
    {
    }
}
