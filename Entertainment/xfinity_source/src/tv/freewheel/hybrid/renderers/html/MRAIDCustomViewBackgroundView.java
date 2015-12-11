// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.ImageButton;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDBackgroundView

public class MRAIDCustomViewBackgroundView extends MRAIDBackgroundView
{

    private ImageButton closeButton;
    private Logger logger;
    private WebChromeClient webChromeClient;

    public MRAIDCustomViewBackgroundView(Activity activity, WebChromeClient webchromeclient)
    {
        super(activity);
        closeButton = null;
        webChromeClient = null;
        logger = Logger.getLogger(this);
        webChromeClient = webchromeclient;
        closeButton = new ImageButton(activity);
        closeButton.setImageResource(0x108005a);
        closeButton.setBackgroundColor(0);
        closeButton.setPadding(0, 0, 0, 0);
        activity = new android.widget.FrameLayout.LayoutParams(50, 50);
        activity.gravity = 53;
        addView(closeButton, activity);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MRAIDCustomViewBackgroundView this$0;

            public void onClick(View view)
            {
                logger.debug("onClick");
                webChromeClient.onHideCustomView();
            }

            
            {
                this$0 = MRAIDCustomViewBackgroundView.this;
                super();
            }
        });
    }

    public volatile boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }


}
