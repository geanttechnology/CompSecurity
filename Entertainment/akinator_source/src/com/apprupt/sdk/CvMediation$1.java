// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvMediation, CvConfig

class this._cls0
    implements ner
{

    final CvMediation this$0;

    public void onConfigUpdated(CvConfig cvconfig)
    {
        CvMediation.access$000(CvMediation.this, cvconfig.get("mediation"), cvconfig.getLastLoaded());
    }

    ner()
    {
        this$0 = CvMediation.this;
        super();
    }
}
