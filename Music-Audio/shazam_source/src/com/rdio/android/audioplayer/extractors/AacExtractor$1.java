// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AacExtractor

class this._cls0
    implements xHandler
{

    final AacExtractor this$0;

    public boolean handleBox(long l, long l1)
    {
        boolean flag = false;
        if (l1 == 0x6d766864L)
        {
            flag = AacExtractor.access$000(AacExtractor.this, l);
        } else
        if (l1 == 0x7472616bL)
        {
            return AacExtractor.access$200(AacExtractor.this, l, AacExtractor.access$100(AacExtractor.this));
        }
        return flag;
    }

    xHandler()
    {
        this$0 = AacExtractor.this;
        super();
    }
}
