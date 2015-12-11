// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentInstallationController, ParseObjectStore, ParseExecutors, ParseInstallation, 
//            ParseObject, InstallationId, PLog

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j)
        throws Exception
    {
        return CachedCurrentInstallationController.access$100(_fld0).getAsync();
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentInstallationController$2

/* anonymous class */
    class CachedCurrentInstallationController._cls2
        implements i
    {

        final CachedCurrentInstallationController this$0;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new CachedCurrentInstallationController._cls2._cls2()).a(new CachedCurrentInstallationController._cls2._cls1(), ParseExecutors.io());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = CachedCurrentInstallationController.this;
                super();
            }

        // Unreferenced inner class com/parse/CachedCurrentInstallationController$2$1

/* anonymous class */
        class CachedCurrentInstallationController._cls2._cls1
            implements i
        {

            final CachedCurrentInstallationController._cls2 this$1;

            public ParseInstallation then(j j1)
                throws Exception
            {
                j1 = (ParseInstallation)j1.e();
                if (j1 == null)
                {
                    j1 = (ParseInstallation)ParseObject.create(com/parse/ParseInstallation);
                    j1.updateDeviceInfo(CachedCurrentInstallationController.access$000(this$0));
                } else
                {
                    CachedCurrentInstallationController.access$000(this$0).set(j1.getInstallationId());
                    PLog.v("com.parse.CachedCurrentInstallationController", "Successfully deserialized Installation object");
                }
                synchronized (CachedCurrentInstallationController.access$200(this$0))
                {
                    currentInstallation = j1;
                }
                return j1;
                j1;
                obj;
                JVM INSTR monitorexit ;
                throw j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = CachedCurrentInstallationController._cls2.this;
                        super();
                    }
        }

    }

}
