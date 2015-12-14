// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls2
    implements android.view.
{

    final FromGetRequest this$2;

    public void onClick(View view)
    {
        VASTVideoView.access$100(_fld0);
        if (!Utils.isEmpty(VASTVideoView.access$1300(_fld0).companionClickThrough))
        {
            Utils.startActivityFromUrl(VASTVideoView.access$1300(_fld0).companionClickThrough);
        }
        if (VASTVideoView.access$1300(_fld0) != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final VASTVideoView._cls9._cls1._cls1 this$3;

                public void run()
                {
                    Iterator iterator = VASTVideoView.access$1300(this$0).companionClickTracking.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s = (String)iterator.next();
                        if (!Utils.isEmpty(s))
                        {
                            HttpUtils.getContentFromGetRequest(s);
                        }
                    } while (true);
                }

            
            {
                this$3 = VASTVideoView._cls9._cls1._cls1.this;
                super();
            }
            });
        }
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$9

/* anonymous class */
    class VASTVideoView._cls9
        implements Runnable
    {

        final VASTVideoView this$0;

        public void run()
        {
            com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(VASTVideoView.access$1300(VASTVideoView.this).staticResource.uri);
            if (response != null && response.code == 200)
            {
                ThreadUtils.runOnUiThread(response. new VASTVideoView._cls9._cls1());
            }
        }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$9$1

/* anonymous class */
    class VASTVideoView._cls9._cls1
        implements Runnable
    {

        final VASTVideoView._cls9 this$1;
        final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

        public void run()
        {
            ImageView imageview = new ImageView(getContext());
            imageview.setImageBitmap(response.bitmap);
            imageview.setOnClickListener(new VASTVideoView._cls9._cls1._cls1());
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            VASTVideoView.access$2000(this$0).setBackgroundColor(VASTVideoView.access$1900(this$0, VASTVideoView.access$1300(this$0).staticResource));
            VASTVideoView.access$2000(this$0).addView(imageview, layoutparams);
        }

            
            {
                this$1 = final__pcls9;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
    }

}
