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
        if (l1 == 0x73747364L)
        {
            flag = AacExtractor.access$1100(AacExtractor.this, l);
        } else
        {
            if (l1 == 0x73747473L)
            {
                return AacExtractor.access$1200(AacExtractor.this, l);
            }
            if (l1 == 0x7374737aL)
            {
                return AacExtractor.access$1300(AacExtractor.this, l);
            }
            if (l1 == 0x73747363L)
            {
                return AacExtractor.access$1400(AacExtractor.this, l);
            }
            if (l1 == 0x7374636fL)
            {
                return AacExtractor.access$1500(AacExtractor.this, l, false);
            }
            if (l1 == 0x636f3634L)
            {
                return AacExtractor.access$1500(AacExtractor.this, l, true);
            }
        }
        return flag;
    }

    xHandler()
    {
        this$0 = AacExtractor.this;
        super();
    }
}
