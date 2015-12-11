// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvConfig, CvUnderscore, CvUrl, URLRequest

class this._cls0
    implements this._cls0
{

    final CvConfig this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        CvConfig.access$000(CvConfig.this).v(new Object[] {
            "Requesting config"
        });
        obj = (CvUnderscore)obj;
        CvConfig.access$1100().v(new Object[] {
            "Resolve: load config, result: <URLRequest>"
        });
        _pcls0.resolve(URLRequest.post(CvUrl.build("/mCfg")).addPostParam("_", ((CvUnderscore) (obj)).toString()).defer());
    }

    e()
    {
        this$0 = CvConfig.this;
        super();
    }
}
