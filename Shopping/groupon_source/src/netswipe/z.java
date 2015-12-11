// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.os.Handler;
import android.os.Message;
import com.jumio.netswipe.sdk.core.ScanCardActivity;
import com.jumio.netswipe.sdk.enums.ErrorCase;
import java.util.ArrayList;

// Referenced classes of package netswipe:
//            o, cc, ar, by, 
//            dh, am

class z extends Handler
{

    final o a;

    z(o o1)
    {
        a = o1;
        super();
    }

    public void handleMessage(Message message)
    {
        boolean flag = true;
        if (o.c(a) != null)
        {
            if (message.what == 111)
            {
                o.c(a).topInfoBar.setShowLoading(false);
                o.c(a).topInfoBar.setText(ar.a(o.c(a), "top_info_success"));
                o.c(a).successView.setShowSuccessIcon(true);
                o.w(a).removeMessages(112);
                o.w(a).sendEmptyMessageDelayed(112, 3000L);
                return;
            }
            if (message.what == 112)
            {
                if (!o.x(a))
                {
                    a.b(ErrorCase.REQUEST_IMAGE_FAILED);
                    dh.b("Image upload task not ready!");
                    return;
                }
                if (!o.y(a))
                {
                    a.b(ErrorCase.REQUEST_RESULT_FAILED);
                    dh.b("Result task not ready!");
                    return;
                }
                if (o.r(a) || o.s(a).size() != 0 || o.d(a) && o.z(a))
                {
                    message = o.c(a);
                    com.jumio.netswipe.sdk.core.NetswipeCardInformation netswipecardinformation = o.f(a);
                    android.view.View.OnClickListener onclicklistener = o.q(a);
                    ArrayList arraylist = o.s(a);
                    boolean flag1 = o.r(a);
                    if (!o.d(a) || !o.z(a))
                    {
                        flag = false;
                    }
                    message.showAdditionalEntryView(netswipecardinformation, onclicklistener, arraylist, flag1, flag);
                    o.a(a, am.c);
                    return;
                } else
                {
                    a.a(false, false);
                    return;
                }
            }
        }
    }
}
