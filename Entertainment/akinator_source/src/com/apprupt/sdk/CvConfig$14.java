// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig, SerialExecutor, SimpleJSON

class this._cls0
    implements dler
{

    final CvConfig this$0;

    public void onSuccess(final Object result)
    {
        CvConfig.access$1400(CvConfig.this).execute(new Runnable() {

            final CvConfig._cls14 this$1;
            final Object val$result;

            public void run()
            {
                CvConfig.access$1202(this$0, (SimpleJSON)result);
                CvConfig.access$402(this$0, null);
                CvConfig.access$000(this$0).v(new Object[] {
                    "Calling listeners"
                });
                CvConfig.Listener listener;
                for (Iterator iterator = CvConfig.access$200(this$0).iterator(); iterator.hasNext(); CvConfig.access$1300(this$0, listener))
                {
                    listener = (CvConfig.Listener)iterator.next();
                    CvConfig.access$000(this$0).v(new Object[] {
                        "Calling listener..."
                    });
                }

                CvConfig.access$000(this$0).v(new Object[] {
                    "Calling waiting objects"
                });
                for (; CvConfig.access$700(this$0).size() > 0; CvConfig.access$600(this$0).post((Runnable)CvConfig.access$700(this$0).poll()))
                {
                    CvConfig.access$000(this$0).v(new Object[] {
                        "Calling waiting  object..."
                    });
                }

                CvConfig.access$000(this$0).i(new Object[] {
                    "Config done! next reload:", Long.valueOf(CvConfig.access$500(this$0))
                });
            }

            
            {
                this$1 = CvConfig._cls14.this;
                result = obj;
                super();
            }
        });
    }

    _cls1.val.result()
    {
        this$0 = CvConfig.this;
        super();
    }
}
