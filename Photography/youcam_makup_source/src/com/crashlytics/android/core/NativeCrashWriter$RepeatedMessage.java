// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;


// Referenced classes of package com.crashlytics.android.core:
//            CodedOutputStream

final class messages extends messages
{

    private final write messages[];

    public int getSize()
    {
        int i = 0;
        messages amessages[] = messages;
        int k = amessages.length;
        int j = 0;
        for (; i < k; i++)
        {
            j += amessages[i].getSize();
        }

        return j;
    }

    public void write(CodedOutputStream codedoutputstream)
    {
        getSize agetsize[] = messages;
        int j = agetsize.length;
        for (int i = 0; i < j; i++)
        {
            agetsize[i].write(codedoutputstream);
        }

    }

    public transient ( a[])
    {
        super(0, new <init>[0]);
        messages = a;
    }
}
