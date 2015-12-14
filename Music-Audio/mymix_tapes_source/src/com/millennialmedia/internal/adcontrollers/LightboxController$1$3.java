// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.content.Context;
import android.view.View;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.video.LightboxView;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController

class this._cls1
    implements android.view.eListener
{

    final is._cls0 this$1;

    public void onViewAttachedToWindow(View view)
    {
    }

    public void onViewDetachedFromWindow(View view)
    {
        LightboxController.access$000(_fld0).animateToGone(false);
    }

    tboxControllerListener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/adcontrollers/LightboxController$1

/* anonymous class */
    class LightboxController._cls1
        implements Runnable
    {

        final LightboxController this$0;
        final Context val$context;
        final LightboxController.LightboxControllerListener val$lightboxControllerListener;

        public void run()
        {
            LightboxController.access$002(LightboxController.this, new LightboxView(context, LightboxController.access$100(LightboxController.this), new LightboxController._cls1._cls1()));
            LightboxController.access$502(LightboxController.this, new MMWebView(context, false, false, new LightboxController._cls1._cls2()));
            LightboxController.access$500(LightboxController.this).setContent(LightboxController.access$100(LightboxController.this).inline.content);
            LightboxController.access$500(LightboxController.this).addOnAttachStateChangeListener(new LightboxController._cls1._cls3());
        }

            
            {
                this$0 = final_lightboxcontroller;
                context = context1;
                lightboxControllerListener = LightboxController.LightboxControllerListener.this;
                super();
            }

        // Unreferenced inner class com/millennialmedia/internal/adcontrollers/LightboxController$1$1

/* anonymous class */
        class LightboxController._cls1._cls1
            implements com.millennialmedia.internal.video.LightboxView.LightboxViewListener
        {

            final LightboxController._cls1 this$1;

            public void onAdLeftApplication()
            {
                lightboxControllerListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                lightboxControllerListener.onClicked();
            }

            public void onCollapsed()
            {
                lightboxControllerListener.onCollapsed();
            }

            public void onExpanded()
            {
                lightboxControllerListener.onExpanded();
            }

            public void onFailed()
            {
            }

            public void onPrepared()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(LightboxController.access$200(), "Lightbox prepared.");
                }
                ThreadUtils.runOnUiThread(new LightboxController._cls1._cls1._cls1());
            }

            public void onReadyToStart()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(LightboxController.access$200(), "lightbox is ready to start playback");
                }
                LightboxController.access$000(this$0).start();
            }

                    
                    {
                        this$1 = LightboxController._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/millennialmedia/internal/adcontrollers/LightboxController$1$1$1

/* anonymous class */
        class LightboxController._cls1._cls1._cls1
            implements Runnable
        {

            final LightboxController._cls1._cls1 this$2;

            public void run()
            {
                if (LightboxController.access$300(this$0) != null && LightboxController.access$000(this$0).getParent() == null)
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(LightboxController.access$200(), "Attaching Lightbox in onPrepared.");
                    }
                    LightboxController.access$400(this$0);
                }
            }

                    
                    {
                        this$2 = LightboxController._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/millennialmedia/internal/adcontrollers/LightboxController$1$2

/* anonymous class */
        class LightboxController._cls1._cls2
            implements com.millennialmedia.internal.MMWebView.MMWebViewListener
        {

            final LightboxController._cls1 this$1;

            public void close()
            {
            }

            public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
            {
                return false;
            }

            public void onAdLeftApplication()
            {
                lightboxControllerListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                lightboxControllerListener.onClicked();
            }

            public void onFailed()
            {
                lightboxControllerListener.initFailed();
            }

            public void onLoaded()
            {
                lightboxControllerListener.initSucceeded();
            }

            public void onReady()
            {
            }

            public boolean resize(com.millennialmedia.internal.SizableStateManager.ResizeParams resizeparams)
            {
                return false;
            }

            public void setOrientation(int i)
            {
            }

            public void showCloseIndicator(boolean flag)
            {
            }

                    
                    {
                        this$1 = LightboxController._cls1.this;
                        super();
                    }
        }

    }

}
