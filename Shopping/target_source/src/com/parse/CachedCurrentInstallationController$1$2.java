// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentInstallationController, ParseObjectStore, ParseExecutors, ParseInstallation, 
//            InstallationId

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j)
        throws Exception
    {
        return CachedCurrentInstallationController.access$100(_fld0).setAsync(installation);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    l.installation()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentInstallationController$1

/* anonymous class */
    class CachedCurrentInstallationController._cls1
        implements i
    {

        final CachedCurrentInstallationController this$0;
        final ParseInstallation val$installation;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new CachedCurrentInstallationController._cls1._cls2()).b(new CachedCurrentInstallationController._cls1._cls1(), ParseExecutors.io());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_cachedcurrentinstallationcontroller;
                installation = ParseInstallation.this;
                super();
            }

        // Unreferenced inner class com/parse/CachedCurrentInstallationController$1$1

/* anonymous class */
        class CachedCurrentInstallationController._cls1._cls1
            implements i
        {

            final CachedCurrentInstallationController._cls1 this$1;

            public j then(j j1)
                throws Exception
            {
                CachedCurrentInstallationController.access$000(this$0).set(installation.getInstallationId());
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = CachedCurrentInstallationController._cls1.this;
                        super();
                    }
        }

    }

}
