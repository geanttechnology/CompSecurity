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

class this._cls0
    implements Runnable
{

    final VASTVideoView this$0;

    public void run()
    {
        final com.millennialmedia.internal.utils.se response = HttpUtils.getBitmapFromGetRequest(VASTVideoView.access$1300(VASTVideoView.this).staticResource.uri);
        if (response != null && response.code == 200)
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoView._cls9 this$1;
                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                public void run()
                {
                    ImageView imageview = new ImageView(getContext());
                    imageview.setImageBitmap(response.bitmap);
                    imageview.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(View view)
                        {
                            VASTVideoView.access$100(this$0);
                            if (!Utils.isEmpty(VASTVideoView.access$1300(this$0).companionClickThrough))
                            {
                                Utils.startActivityFromUrl(VASTVideoView.access$1300(this$0).companionClickThrough);
                            }
                            if (VASTVideoView.access$1300(this$0) != null)
                            {
                                ThreadUtils.runOnWorkerThread(new Runnable() {

                                    final _cls1 this$3;

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
                this$3 = _cls1.this;
                super();
            }
                                });
                            }
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                    VASTVideoView.access$2000(this$0).setBackgroundColor(VASTVideoView.access$1900(this$0, VASTVideoView.access$1300(this$0).staticResource));
                    VASTVideoView.access$2000(this$0).addView(imageview, layoutparams);
                }

            
            {
                this$1 = VASTVideoView._cls9.this;
                response = response1;
                super();
            }
            });
        }
    }

    _cls1.val.response()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
