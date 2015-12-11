// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentInstallationController, ParseExecutors, ParseInstallation, ParseObject, 
//            InstallationId, PLog, ParseObjectStore

class this._cls0
    implements i
{

    final CachedCurrentInstallationController this$0;

    public j then(j j1)
        throws Exception
    {
        return j1.b(new i() {

            final CachedCurrentInstallationController._cls2 this$1;

            public j then(j j2)
                throws Exception
            {
                return CachedCurrentInstallationController.access$100(this$0).getAsync();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentInstallationController._cls2.this;
                super();
            }
        }).a(new i() {

            final CachedCurrentInstallationController._cls2 this$1;

            public ParseInstallation then(j j2)
                throws Exception
            {
                j2 = (ParseInstallation)j2.e();
                if (j2 == null)
                {
                    j2 = (ParseInstallation)ParseObject.create(com/parse/ParseInstallation);
                    j2.updateDeviceInfo(CachedCurrentInstallationController.access$000(this$0));
                } else
                {
                    CachedCurrentInstallationController.access$000(this$0).set(j2.getInstallationId());
                    PLog.v("com.parse.CachedCurrentInstallationController", "Successfully deserialized Installation object");
                }
                synchronized (CachedCurrentInstallationController.access$200(this$0))
                {
                    currentInstallation = j2;
                }
                return j2;
                j2;
                obj;
                JVM INSTR monitorexit ;
                throw j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentInstallationController._cls2.this;
                super();
            }
        }, ParseExecutors.io());
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls2.this._cls1()
    {
        this$0 = CachedCurrentInstallationController.this;
        super();
    }
}
