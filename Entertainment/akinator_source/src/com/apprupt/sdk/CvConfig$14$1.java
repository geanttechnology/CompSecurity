// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.apprupt.sdk:
//            SimpleJSON, CvConfig, SerialExecutor

class val.result
    implements Runnable
{

    final is._cls0 this$1;
    final Object val$result;

    public void run()
    {
        CvConfig.access$1202(_fld0, (SimpleJSON)val$result);
        CvConfig.access$402(_fld0, null);
        CvConfig.access$000(_fld0)._mth0(new Object[] {
            "Calling listeners"
        });
        ner ner;
        for (Iterator iterator = CvConfig.access$200(_fld0).iterator(); iterator.hasNext(); CvConfig.access$1300(_fld0, ner))
        {
            ner = (ner)iterator.next();
            CvConfig.access$000(_fld0)._mth0(new Object[] {
                "Calling listener..."
            });
        }

        CvConfig.access$000(_fld0)._mth0(new Object[] {
            "Calling waiting objects"
        });
        for (; CvConfig.access$700(_fld0).size() > 0; CvConfig.access$600(_fld0).post((Runnable)CvConfig.access$700(_fld0).poll()))
        {
            CvConfig.access$000(_fld0)._mth0(new Object[] {
                "Calling waiting  object..."
            });
        }

        CvConfig.access$000(_fld0)._mth0(new Object[] {
            "Config done! next reload:", Long.valueOf(CvConfig.access$500(_fld0))
        });
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$result = Object.this;
        super();
    }

    // Unreferenced inner class com/apprupt/sdk/CvConfig$14

/* anonymous class */
    class CvConfig._cls14
        implements Q.SuccessHandler
    {

        final CvConfig this$0;

        public void onSuccess(Object obj)
        {
            CvConfig.access$1400(CvConfig.this).execute(((CvConfig._cls14._cls1) (obj)). new CvConfig._cls14._cls1());
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }
    }

}
