// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvConfig, CvCrypto

class this._cls0
    implements this._cls0
{

    final CvConfig this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        CvConfig.access$000(CvConfig.this).v(new Object[] {
            "Config decode"
        });
        obj = CvCrypto.decode(((URLResponse)obj).data);
        if (obj == null || obj.length == 0)
        {
            throw new Exception("Cannot decode response data");
        }
        obj = new String(((byte []) (obj)));
        if (((String) (obj)).length() == 0)
        {
            throw new Exception("Cannot decode response data!");
        } else
        {
            CvConfig.access$000(CvConfig.this).v(new Object[] {
                "Resolve: decode config:", obj
            });
            _pcls0.resolve(obj);
            return;
        }
    }

    URLResponse()
    {
        this$0 = CvConfig.this;
        super();
    }
}
