// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.io.DataInput;

// Referenced classes of package com.d.a:
//            q

public final class a extends q
{

    long a;
    int b;
    int c;
    String d;
    byte e[];

    a()
    {
    }

    a(DataInput datainput)
    {
        a(datainput);
    }

    final void a(DataInput datainput)
    {
        a = datainput.readLong();
        b = datainput.readInt();
        c = datainput.readInt();
        d = datainput.readUTF();
        e = new byte[datainput.readInt()];
        datainput.readFully(e);
    }
}
