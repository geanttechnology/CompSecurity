// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.millennialmedia.internal.MMActivity;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class er extends com.millennialmedia.internal.Listener
{

    final InlineWebVideoView this$0;

    public void onCreate(final MMActivity mmActivity)
    {
        super.onCreate(mmActivity);
        ViewUtils.removeFromParent(InlineWebVideoView.this);
        android.widget.Params params = new android.widget.Params(-1, -1);
        InlineWebVideoView.access$900(InlineWebVideoView.this).setOnCheckedChangeListener(null);
        InlineWebVideoView.access$900(InlineWebVideoView.this).setChecked(true);
        InlineWebVideoView.access$900(InlineWebVideoView.this).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final InlineWebVideoView._cls5 this$1;
            final MMActivity val$mmActivity;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (!flag)
                {
                    mmActivity.finish();
                }
            }

            
            {
                this$1 = InlineWebVideoView._cls5.this;
                mmActivity = mmactivity;
                super();
            }
        });
        InlineWebVideoView.access$1900(InlineWebVideoView.this, true);
        ViewUtils.attachView(mmActivity.getRootView(), InlineWebVideoView.this, params);
        mmActivity = (MMWebView)InlineWebVideoView.access$700(InlineWebVideoView.this).get();
        if (mmActivity != null)
        {
            mmActivity.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                getTag(), "expand"
            });
        }
    }

    public void onDestroy(MMActivity mmactivity)
    {
        ViewUtils.removeFromParent(InlineWebVideoView.this);
        android.widget.Params params = new android.widget.Params(InlineWebVideoView.access$1400(InlineWebVideoView.this), InlineWebVideoView.access$1600(InlineWebVideoView.this), InlineWebVideoView.access$1300(InlineWebVideoView.this), InlineWebVideoView.access$1500(InlineWebVideoView.this));
        InlineWebVideoView.access$900(InlineWebVideoView.this).setOnCheckedChangeListener(null);
        InlineWebVideoView.access$900(InlineWebVideoView.this).setChecked(false);
        InlineWebVideoView.access$900(InlineWebVideoView.this).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final InlineWebVideoView._cls5 this$1;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    InlineWebVideoView.access$1100(this$0);
                }
            }

            
            {
                this$1 = InlineWebVideoView._cls5.this;
                super();
            }
        });
        InlineWebVideoView.access$1900(InlineWebVideoView.this, false);
        MMWebView mmwebview = (MMWebView)InlineWebVideoView.access$700(InlineWebVideoView.this).get();
        if (mmwebview != null)
        {
            ViewUtils.attachView(mmwebview, InlineWebVideoView.this, params);
            mmwebview.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                getTag(), "collapse"
            });
        }
        super.onDestroy(mmactivity);
    }

    public void onPause(MMActivity mmactivity)
    {
        super.onPause(mmactivity);
    }

    public void onResume(MMActivity mmactivity)
    {
        super.onResume(mmactivity);
    }

    _cls2.this._cls1()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
