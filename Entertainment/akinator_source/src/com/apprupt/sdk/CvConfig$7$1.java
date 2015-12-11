// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig, CvUnderscore, Q

class val.resolver
    implements ler
{

    final il this$1;
    final il val$resolver;

    public void onFailure(Throwable throwable, Object obj)
    {
        val$resolver.il(throwable, obj);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$resolver = val.resolver.this;
        super();
    }

    // Unreferenced inner class com/apprupt/sdk/CvConfig$7

/* anonymous class */
    class CvConfig._cls7
        implements Q.Task
    {

        final CvConfig this$0;

        public void run(Object obj, final Q.Resolver resolver)
            throws Exception
        {
            CvConfig.access$000(CvConfig.this).v(new Object[] {
                "Preparing params"
            });
            obj = CvUnderscore.create().put("bundle", String.format("android.%s", new Object[] {
                getBundleId()
            }));
            boolean flag = false;
            Q q = Q.take(obj);
            Iterator iterator = CvConfig.access$1000(CvConfig.this).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Q.Task task = ((CvConfig.PropertiesProvider)iterator.next()).getRequestPrepareTask();
                if (task != null)
                {
                    flag = true;
                    q.then(task);
                }
            } while (true);
            if (flag)
            {
                q.success(new CvConfig._cls7._cls2()).failure(resolver. new CvConfig._cls7._cls1());
                return;
            } else
            {
                resolver.resolve(obj);
                return;
            }
        }

            
            {
                this$0 = CvConfig.this;
                super();
            }

        // Unreferenced inner class com/apprupt/sdk/CvConfig$7$2

/* anonymous class */
        class CvConfig._cls7._cls2
            implements Q.SuccessHandler
        {

            final CvConfig._cls7 this$1;
            final Q.Resolver val$resolver;

            public void onSuccess(Object obj)
            {
                resolver.resolve(obj);
            }

                    
                    {
                        this$1 = CvConfig._cls7.this;
                        resolver = resolver1;
                        super();
                    }
        }

    }

}
