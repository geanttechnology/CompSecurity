// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.apprupt.sdk.adview.AdViewWrapper;
import com.apprupt.sdk.adview.ExpandProperties;
import com.apprupt.sdk.adview.ExpandedAdWrapperListener;
import com.apprupt.sdk.adview.Orientation;
import com.apprupt.sdk.adview.OrientationProperties;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvViewHelper, CvContext, CvCloseButton, 
//            CvInlineAdWrapper, CvAdColony, CvMediator

public class CvExpandActivity extends Activity
    implements ExpandedAdWrapperListener
{

    private static final long MINIMUM_TIME_LOCKED = 30000L;
    private static final Logger.log llog = Logger.get("Lifecycle.ExpandView");
    static AdViewWrapper transportAdItem = null;
    private static volatile HashMap wrappers = new HashMap();
    private static volatile int wrappersCounter = 0;
    private boolean active;
    private AdViewWrapper adItem;
    private Runnable clickClose;
    private CvCloseButton closeButton;
    private Runnable closeHandler;
    private boolean firstRun;
    private boolean locked;
    private RelativeLayout myLayout;
    private Timer unlocker;

    public CvExpandActivity()
    {
        adItem = null;
        closeButton = null;
        firstRun = true;
        locked = true;
        active = false;
        unlocker = null;
        closeHandler = null;
        clickClose = new Runnable() {

            final CvExpandActivity this$0;

            public void run()
            {
                if (closeHandler != null)
                {
                    closeHandler.run();
                } else
                {
                    finish();
                }
                closeHandler = null;
            }

            
            {
                this$0 = CvExpandActivity.this;
                super();
            }
        };
    }

    static void expand(CvInlineAdWrapper cvinlineadwrapper)
    {
        CvViewHelper.runOnUIThread(new Runnable(cvinlineadwrapper) {

            final CvInlineAdWrapper val$wrapper;

            public void run()
            {
                Context context = wrapper.getMediator().getContext();
                int i = int i = putInt + 1;
                CvExpandActivity.wrappers.put(Integer.valueOf(i), wrapper);
                Bundle bundle = new Bundle();
                bundle.putInt("mraidId", i);
                Intent intent = new Intent(context, com/apprupt/sdk/CvExpandActivity);
                intent.setFlags(0x10000000);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }

            
            {
                wrapper = cvinlineadwrapper;
                super();
            }
        }, true);
    }

    private void prepareLegacyView()
    {
        int j = -1;
        boolean flag = false;
        com/apprupt/sdk/CvExpandActivity;
        JVM INSTR monitorenter ;
        adItem = transportAdItem;
        com/apprupt/sdk/CvExpandActivity;
        JVM INSTR monitorexit ;
        if (adItem != null) goto _L2; else goto _L1
_L1:
        finish();
_L8:
        return;
        Exception exception;
        exception;
        com/apprupt/sdk/CvExpandActivity;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        Object obj;
        Object obj1;
        android.view.ViewParent viewparent;
        int i;
        myLayout = new RelativeLayout(this);
        setContentView(myLayout);
        obj = adItem.getExpandProperties();
        if (((ExpandProperties) (obj)).getWidth() > 0)
        {
            i = CvViewHelper.dp2px(((ExpandProperties) (obj)).getWidth());
        } else
        {
            i = -1;
        }
        if (((ExpandProperties) (obj)).getHeight() > 0)
        {
            j = CvViewHelper.dp2px(((ExpandProperties) (obj)).getHeight());
        }
        obj1 = new android.widget.RelativeLayout.LayoutParams(i, j);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
        adItem.getView().setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = adItem;
        obj1;
        JVM INSTR monitorenter ;
        viewparent = adItem.getView().getParent();
        j = 1;
        i = j;
        if (viewparent == null) goto _L4; else goto _L3
_L3:
        if (!viewparent.equals(this)) goto _L6; else goto _L5
_L5:
        i = 0;
_L4:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        adItem.getView().setId(0xf42bb);
        myLayout.addView(adItem.getView());
        ((CvContext)adItem.getContext()).pushContext(this);
        obj1;
        JVM INSTR monitorexit ;
        closeButton = new CvCloseButton(this);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CvExpandActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = CvExpandActivity.this;
                super();
            }
        });
        obj1 = closeButton;
        if (((ExpandProperties) (obj)).getUseCustomClose())
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((CvCloseButton) (obj1)).setVisibility(i);
        i = CvViewHelper.dp2px(CvCloseButton.size);
        obj = new android.widget.RelativeLayout.LayoutParams(i, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(-i, 0, 0, -i);
        closeButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        myLayout.addView(closeButton);
        adItem.setExpandedViewListener(this);
        adItem.onAfterExpand();
        obj = adItem.getOrientationProperties();
        obj1 = ((OrientationProperties) (obj)).getForceOrientation();
        if (obj1 != Orientation.NONE)
        {
            if (obj1 == Orientation.LANDSCAPE)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 1;
            }
            setRequestedOrientation(i);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        ((ViewGroup)viewparent).removeView(adItem.getView());
        i = j;
          goto _L4
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        if (((OrientationProperties) (obj)).getAllowOrientationChange()) goto _L8; else goto _L7
_L7:
        setRequestedOrientation(getResources().getConfiguration().orientation);
        return;
    }

    private void prepareView(CvInlineAdWrapper cvinlineadwrapper)
    {
        int j = -1;
        boolean flag = false;
        myLayout = new RelativeLayout(this);
        setContentView(myLayout);
        Object obj = cvinlineadwrapper.getExpandProperties();
        Object obj1;
        View view;
        int i;
        if (((ExpandProperties) (obj)).getWidth() > 0)
        {
            i = CvViewHelper.dp2px(((ExpandProperties) (obj)).getWidth());
        } else
        {
            i = -1;
        }
        if (((ExpandProperties) (obj)).getHeight() > 0)
        {
            j = CvViewHelper.dp2px(((ExpandProperties) (obj)).getHeight());
        }
        obj1 = new android.widget.RelativeLayout.LayoutParams(i, j);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
        view = cvinlineadwrapper.getExpandView();
        view.setId(0xf42bb);
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        myLayout.addView(view);
        ((CvContext)view.getContext()).pushContext(this);
        closeHandler = cvinlineadwrapper.closeButtonHandler();
        closeButton = new CvCloseButton(this);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CvExpandActivity this$0;

            public void onClick(View view1)
            {
                runOnUiThread(clickClose);
            }

            
            {
                this$0 = CvExpandActivity.this;
                super();
            }
        });
        obj1 = closeButton;
        if (((ExpandProperties) (obj)).getUseCustomClose())
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((CvCloseButton) (obj1)).setVisibility(i);
        i = CvViewHelper.dp2px(CvCloseButton.size);
        obj = new android.widget.RelativeLayout.LayoutParams(i, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, 0xf42bb);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(-i, 0, 0, -i);
        closeButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        cvinlineadwrapper.setExpandActivity(this);
        myLayout.addView(closeButton);
        cvinlineadwrapper = cvinlineadwrapper.getOrientationProperties();
        obj = cvinlineadwrapper.getForceOrientation();
        if (obj != Orientation.NONE)
        {
            if (obj == Orientation.LANDSCAPE)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 1;
            }
            setRequestedOrientation(i);
        } else
        if (!cvinlineadwrapper.getAllowOrientationChange())
        {
            setRequestedOrientation(getResources().getConfiguration().orientation);
            return;
        }
    }

    public void changeCloseButtonVisibility(boolean flag)
    {
        CvCloseButton cvclosebutton = closeButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        cvclosebutton.setVisibility(i);
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (adItem != null)
        {
            ((CvContext)adItem.getContext()).popContext();
        }
        adItem = null;
        this;
        JVM INSTR monitorexit ;
        finish();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onBackPressed()
    {
        runOnUiThread(clickClose);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        byte byte0 = -1;
        bundle = getIntent();
        int i = byte0;
        if (bundle != null)
        {
            bundle = bundle.getExtras();
            i = byte0;
            if (bundle != null)
            {
                i = bundle.getInt("mraidId", -1);
            }
        }
        if (i > 0)
        {
            prepareView((CvInlineAdWrapper)wrappers.remove(Integer.valueOf(i)));
            return;
        } else
        {
            prepareLegacyView();
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        this;
        JVM INSTR monitorenter ;
        active = false;
        if (unlocker != null)
        {
            unlocker.cancel();
            unlocker = null;
        }
        this;
        JVM INSTR monitorexit ;
        CvAdColony.onPause();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onRestart()
    {
        super.onRestart();
    }

    protected void onResume()
    {
        super.onResume();
        this;
        JVM INSTR monitorenter ;
        active = true;
        if (!firstRun)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        firstRun = false;
_L1:
        unlocker = new Timer();
        unlocker.schedule(new TimerTask() {

            final CvExpandActivity this$0;

            public void run()
            {
                synchronized (CvExpandActivity.this)
                {
                    locked = false;
                }
                return;
                exception1;
                cvexpandactivity;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                this$0 = CvExpandActivity.this;
                super();
            }
        }, 30000L);
        this;
        JVM INSTR monitorexit ;
        CvAdColony.onResume(this);
        return;
        locked = false;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onStop()
    {
        super.onStop();
        this;
        JVM INSTR monitorenter ;
        if (adItem != null)
        {
            adItem.close(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setBackgroundColor(final int color)
    {
        runOnUiThread(new Runnable() {

            final CvExpandActivity this$0;
            final int val$color;

            public void run()
            {
                myLayout.setBackgroundColor(color);
            }

            
            {
                this$0 = CvExpandActivity.this;
                color = i;
                super();
            }
        });
    }




/*
    static Runnable access$002(CvExpandActivity cvexpandactivity, Runnable runnable)
    {
        cvexpandactivity.closeHandler = runnable;
        return runnable;
    }

*/


/*
    static int access$104()
    {
        int i = wrappersCounter + 1;
        wrappersCounter = i;
        return i;
    }

*/





/*
    static boolean access$502(CvExpandActivity cvexpandactivity, boolean flag)
    {
        cvexpandactivity.locked = flag;
        return flag;
    }

*/
}
