// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import net.tsz.afinal.core.AsyncTask;

// Referenced classes of package net.tsz.afinal:
//            FinalBitmap

private class <init> extends AsyncTask
{

    public static final int MESSAGE_CLEAR = 0;
    public static final int MESSAGE_CLEAR_DISK = 5;
    public static final int MESSAGE_CLEAR_KEY = 6;
    public static final int MESSAGE_CLEAR_KEY_IN_DISK = 8;
    public static final int MESSAGE_CLEAR_KEY_IN_MEMORY = 7;
    public static final int MESSAGE_CLEAR_MEMORY = 4;
    public static final int MESSAGE_CLOSE = 3;
    public static final int MESSAGE_FLUSH = 2;
    public static final int MESSAGE_INIT_DISK_CACHE = 1;
    final FinalBitmap this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Object[])aobj);
    }

    protected transient Void doInBackground(Object aobj[])
    {
        ((Integer)aobj[0]).intValue();
        JVM INSTR tableswitch 0 8: default 60
    //                   0 62
    //                   1 72
    //                   2 82
    //                   3 99
    //                   4 113
    //                   5 123
    //                   6 133
    //                   7 149
    //                   8 165;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return null;
_L2:
        FinalBitmap.access$0(FinalBitmap.this);
        continue; /* Loop/switch isn't completed */
_L3:
        FinalBitmap.access$1(FinalBitmap.this);
        continue; /* Loop/switch isn't completed */
_L4:
        FinalBitmap.access$2(FinalBitmap.this);
        FinalBitmap.access$3(FinalBitmap.this);
        continue; /* Loop/switch isn't completed */
_L5:
        FinalBitmap.access$2(FinalBitmap.this);
        FinalBitmap.access$4(FinalBitmap.this);
_L6:
        FinalBitmap.access$2(FinalBitmap.this);
        continue; /* Loop/switch isn't completed */
_L7:
        FinalBitmap.access$5(FinalBitmap.this);
        continue; /* Loop/switch isn't completed */
_L8:
        FinalBitmap.access$6(FinalBitmap.this, String.valueOf(aobj[1]));
        continue; /* Loop/switch isn't completed */
_L9:
        FinalBitmap.access$7(FinalBitmap.this, String.valueOf(aobj[1]));
        continue; /* Loop/switch isn't completed */
_L10:
        FinalBitmap.access$8(FinalBitmap.this, String.valueOf(aobj[1]));
        if (true) goto _L1; else goto _L11
_L11:
    }

    private ()
    {
        this$0 = FinalBitmap.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
