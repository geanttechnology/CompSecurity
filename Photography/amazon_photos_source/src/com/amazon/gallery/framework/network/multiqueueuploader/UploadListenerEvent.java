// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            QueueType, UploadListener

public class UploadListenerEvent
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action ADD;
        public static final Action REMOVE;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadListenerEvent$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            ADD = new Action("ADD", 0);
            REMOVE = new Action("REMOVE", 1);
            $VALUES = (new Action[] {
                ADD, REMOVE
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }
    }


    private final Action action;
    private final QueueType queueType;
    private final UploadListener uploadListener;

    public UploadListenerEvent(Action action1, QueueType queuetype, UploadListener uploadlistener)
    {
        action = action1;
        queueType = queuetype;
        uploadListener = uploadlistener;
    }

    public Action getAction()
    {
        return action;
    }

    public UploadListener getUploadListener()
    {
        return uploadListener;
    }
}
