// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.blueKai;

import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.extension.ParamParser;
import tv.freewheel.utils.CommonUtil;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.extension.blueKai:
//            BlueKaiDataExtension

class this._cls0
    implements IEventListener
{

    final BlueKaiDataExtension this$0;

    public void run(IEvent ievent)
    {
        if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(BlueKaiDataExtension.access$000(BlueKaiDataExtension.this).INFO_KEY_SUCCESS())))
        {
            BlueKaiDataExtension.access$100(BlueKaiDataExtension.this).debug("RequestComplete: false, return.");
        } else
        if (BlueKaiDataExtension.access$200(BlueKaiDataExtension.this) != null)
        {
            BlueKaiDataExtension.access$100(BlueKaiDataExtension.this).debug("requestCompleteListener()");
            if ((new ParamParser(BlueKaiDataExtension.access$200(BlueKaiDataExtension.this), "extension.blueKai")).parseBoolean("bluekaiMobileDataSync", Boolean.valueOf(false)).booleanValue() && !BlueKaiDataExtension.alreadySync)
            {
                ievent = BlueKaiDataExtension.access$300(BlueKaiDataExtension.this);
                if (ievent != null)
                {
                    BlueKaiDataExtension.access$402(BlueKaiDataExtension.this, BlueKaiDataExtension.access$400(BlueKaiDataExtension.this).replace("androidId_md5", CommonUtil.md5(ievent)));
                    BlueKaiDataExtension.access$502(BlueKaiDataExtension.this, new WebView(BlueKaiDataExtension.access$200(BlueKaiDataExtension.this).getActivity()));
                    BlueKaiDataExtension.access$500(BlueKaiDataExtension.this).getSettings().setJavaScriptEnabled(true);
                    BlueKaiDataExtension.access$500(BlueKaiDataExtension.this).loadData(BlueKaiDataExtension.access$400(BlueKaiDataExtension.this), "text/html", "UTF-8");
                    BlueKaiDataExtension.alreadySync = true;
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = BlueKaiDataExtension.this;
        super();
    }
}
