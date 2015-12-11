// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentInstallationController, ParseExecutors, ParseInstallation, InstallationId, 
//            ParseObjectStore

class val.installation
    implements i
{

    final CachedCurrentInstallationController this$0;
    final ParseInstallation val$installation;

    public j then(j j1)
        throws Exception
    {
        return j1.b(new i() {

            final CachedCurrentInstallationController._cls1 this$1;

            public j then(j j2)
                throws Exception
            {
                return CachedCurrentInstallationController.access$100(this$0).setAsync(installation);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentInstallationController._cls1.this;
                super();
            }
        }).b(new i() {

            final CachedCurrentInstallationController._cls1 this$1;

            public j then(j j2)
                throws Exception
            {
                CachedCurrentInstallationController.access$000(this$0).set(installation.getInstallationId());
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentInstallationController._cls1.this;
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
        this$0 = final_cachedcurrentinstallationcontroller;
        val$installation = ParseInstallation.this;
        super();
    }
}
