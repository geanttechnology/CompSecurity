// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.util;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package android.support.v7.util:
//            MessageThreadUtil

class this._cls1
    implements Runnable
{

    final QueueItem.data this$1;

    public void run()
    {
        QueueItem queueitem = ueue.next();
        if (queueitem == null)
        {
            return;
        }
        switch (queueitem.what)
        {
        default:
            Log.e("ThreadUtil", (new StringBuilder()).append("Unsupported message, what=").append(queueitem.what).toString());
            return;

        case 1: // '\001'
            ueue.removeMessages(1);
            callback.refresh(queueitem.arg1);
            return;

        case 2: // '\002'
            ueue.removeMessages(2);
            ueue.removeMessages(3);
            callback.updateRange(queueitem.arg1, queueitem.arg2, queueitem.arg3, queueitem.arg4, queueitem.arg5);
            return;

        case 3: // '\003'
            callback.loadTile(queueitem.arg1, queueitem.arg2);
            return;

        case 4: // '\004'
            callback.recycleTile((allback.recycleTile)queueitem.data);
            break;
        }
    }

    <init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class android/support/v7/util/MessageThreadUtil$2

/* anonymous class */
    class MessageThreadUtil._cls2
        implements ThreadUtil.BackgroundCallback
    {

        private static final int LOAD_TILE = 3;
        private static final int RECYCLE_TILE = 4;
        private static final int REFRESH = 1;
        private static final int UPDATE_RANGE = 2;
        private Runnable mBackgroundRunnable;
        private final Executor mExecutor = Executors.newSingleThreadExecutor();
        private final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
        final MessageThreadUtil this$0;
        final ThreadUtil.BackgroundCallback val$callback;

        private void sendMessage(MessageThreadUtil.SyncQueueItem syncqueueitem)
        {
            mQueue.sendMessage(syncqueueitem);
            mExecutor.execute(mBackgroundRunnable);
        }

        private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem syncqueueitem)
        {
            mQueue.sendMessageAtFrontOfQueue(syncqueueitem);
            mExecutor.execute(mBackgroundRunnable);
        }

        public void loadTile(int i, int j)
        {
            sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, i, j));
        }

        public void recycleTile(TileList.Tile tile)
        {
            sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, tile));
        }

        public void refresh(int i)
        {
            sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, i, null));
        }

        public void updateRange(int i, int j, int k, int l, int i1)
        {
            sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, i, j, k, l, i1, null));
        }


            
            {
                this$0 = final_messagethreadutil;
                callback = ThreadUtil.BackgroundCallback.this;
                super();
                mBackgroundRunnable = new MessageThreadUtil._cls2._cls1();
            }
    }

}
