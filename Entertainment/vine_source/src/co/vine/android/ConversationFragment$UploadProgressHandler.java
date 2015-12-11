// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.vine.android.recorder.ProgressView;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationFragment

private class <init> extends Handler
{

    final ConversationFragment this$0;

    public void handleMessage(Message message)
    {
        int i = message.what;
        if (message.obj == null)
        {
            message = new Bundle();
        } else
        {
            message = (Bundle)message.obj;
        }
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Message received, what=").append(i).toString());
        i;
        JVM INSTR tableswitch 3 7: default 84
    //                   3 96
    //                   4 233
    //                   5 241
    //                   6 321
    //                   7 405;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        boolean flag = message.getBoolean("is_active");
        long l = message.getLong("conversation_row_id");
        message = message.getString("thumbnail");
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Result receiver was set in VineUploadService, conversationId=").append(l).toString());
        if (flag && ConversationFragment.access$700(ConversationFragment.this) == l)
        {
            ConversationFragment.access$800(ConversationFragment.this).setVisibility(0);
            ConversationFragment.access$902(ConversationFragment.this, (ProgressView)ConversationFragment.access$800(ConversationFragment.this).findViewById(0x7f0a00c6));
            if (!TextUtils.isEmpty(message))
            {
                message = BitmapFactory.decodeFile(message);
                ConversationFragment.access$1000(ConversationFragment.this).setImageBitmap(message);
                return;
            } else
            {
                ConversationFragment.access$1000(ConversationFragment.this).setVisibility(8);
                return;
            }
        }
          goto _L1
_L3:
        SLog.dWithTag("ConversationFrag", "Video transcoding started");
        return;
_L4:
        double d = message.getDouble("transcode_progress");
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Transcode progress changed to p=").append(d).toString());
        if (ConversationFragment.access$1100(ConversationFragment.this) == 0)
        {
            ConversationFragment.access$1102(ConversationFragment.this, ConversationFragment.access$900(ConversationFragment.this).getMeasuredWidth());
        }
        ConversationFragment.access$900(ConversationFragment.this).setProgressRatio((float)((0.65000000000000002D * d) / 100D));
        return;
_L5:
        double d1 = message.getDouble("upload_progress");
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Upload progress changed to p=").append(d1).toString());
        if (ConversationFragment.access$1100(ConversationFragment.this) == 0)
        {
            ConversationFragment.access$1102(ConversationFragment.this, ConversationFragment.access$900(ConversationFragment.this).getMeasuredWidth());
        }
        ConversationFragment.access$900(ConversationFragment.this).setProgressRatio((float)(0.65000000000000002D + (0.33000000000000002D * d1) / 100D));
        return;
_L6:
        boolean flag1 = message.getBoolean("success");
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Post completed, success=").append(flag1).toString());
        ConversationFragment.access$800(ConversationFragment.this).setVisibility(8);
        sendMessage(Message.obtain(null, 2));
        return;
    }

    private ()
    {
        this$0 = ConversationFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
