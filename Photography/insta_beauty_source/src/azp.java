// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.instamag.activity.commonview.TFavWaterFlowView;

public final class azp extends Handler
{

    public azp()
    {
    }

    public void handleMessage(Message message)
    {
        message = (TFavWaterFlowView)message.obj;
        int i = message.getScrollY();
        if (i == TFavWaterFlowView.access$000())
        {
            message.checkVisibility();
            return;
        } else
        {
            int _tmp = TFavWaterFlowView.access$002(i);
            Message message1 = new Message();
            message1.obj = message;
            TFavWaterFlowView.access$100().sendMessageDelayed(message1, 5L);
            return;
        }
    }
}
