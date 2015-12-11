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
        if (AacExtractor.access$1600(AacExtractor.this) == 0x736f756eL || AacExtractor.access$1600(AacExtractor.this) == 0x61757876L || AacExtractor.access$1600(AacExtractor.this) == 0x68696e74L || AacExtractor.access$1600(AacExtractor.this) == 0x6d657461L || AacExtractor.access$1600(AacExtractor.this) == 0x76696465L)
        {
            flag = AacExtractor.access$1700(AacExtractor.this, l);
        }
        return flag;
    }

    xHandler()
    {
        this$0 = AacExtractor.this;
        super();
    }
}
