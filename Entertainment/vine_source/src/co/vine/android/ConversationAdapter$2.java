// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.player.SdkVideoView;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

class this._cls0
    implements Runnable
{

    final ConversationAdapter this$0;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int k;
        k = ConversationAdapter.access$100(ConversationAdapter.this).getFirstVisiblePosition();
        obj = (VinePrivateMessage)ConversationAdapter.access$200(ConversationAdapter.this).get(k);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((VinePrivateMessage) (obj)).hasVideo) goto _L2; else goto _L3
_L3:
        int i = 1;
_L10:
        obj = ConversationAdapter.access$300(ConversationAdapter.this, k);
        float f;
        int j;
        f = -1F;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        j = 0;
        if (getLastPlayer() != null)
        {
            j = getLastPlayer().getHeight() / 2;
        }
        f = ((float)((View) (obj)).getBottom() + (float)j) / ((float)((View) (obj)).getHeight() + (float)j);
        SLog.d("Current First: {}, ratio: {}", Integer.valueOf(k), Float.valueOf(f));
        byte byte0;
        byte0 = -1;
        if ((double)f < 0.5D || k == -1 || i == 0)
        {
            break MISSING_BLOCK_LABEL_288;
        }
          goto _L4
_L11:
        j = byte0;
        if (i >= getCount()) goto _L6; else goto _L5
_L5:
        obj = (VinePrivateMessage)ConversationAdapter.access$200(ConversationAdapter.this).get(i);
        j = byte0;
        if (obj == null) goto _L6; else goto _L7
_L7:
        if (!((VinePrivateMessage) (obj)).hasVideo) goto _L9; else goto _L8
_L8:
        j = i;
_L6:
        SLog.d("Current Next: {}", Integer.valueOf(j));
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (j != ConversationAdapter.access$400(ConversationAdapter.this))
        {
            play(j);
        }
_L12:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = 0;
          goto _L10
_L9:
        i++;
          goto _L11
_L4:
        if (k == ConversationAdapter.access$400(ConversationAdapter.this))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        play(k);
          goto _L12
        Exception exception;
        exception;
        throw exception;
        playFile(k, false);
          goto _L12
        i = k + 1;
          goto _L11
    }

    ()
    {
        this$0 = ConversationAdapter.this;
        super();
    }
}
