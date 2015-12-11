// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;


public class PushProtocol
{

    public static synchronized native int Close(int i);

    public static native int EnChannel(int i, long l, String s, String s1);

    public static native String GetEsg(int i);

    public static native int GetSdkVersion();

    public static native int HbJPush(int i, long l);

    public static native int InitConn();

    public static native int InitPush(int i, String s, int j);

    public static native int LogPushWithBack(int i, byte abyte0[], long l, String s, String s1, long l1);

    public static native int MsgResponse(int i, int j, long l, byte byte0, long l1);

    public static native int PushTime(int i, long l, String s, String s1);

    public static native int RecvPush(int i, byte abyte0[], int j);

    public static native int RegPush(int i, String s, String s1, String s2, String s3);

    public static native int RepPush(int i, long l, byte byte0, String s);

    public static native int Stop(int i);

    public static native int TagAlias(int i, long l, String s, String s1, int j);

    public static native int UnChnelId(int i, long l, String s, String s1);

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "Q~5Rx\n9q".toCharArray();
        j = ac.length;
        l = 0;
        i = 0;
        ac1 = ac;
        k = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        l = i;
        k = i;
_L9:
        char c;
        ac1 = ac;
        c = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 100
    //                   1 106
    //                   2 112
    //                   3 118;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_118;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        i = 16;
_L10:
        ac1[k] = (char)(i ^ c);
        l++;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        k = j;
        if (true) goto _L9; else goto _L8
_L8:
        i = 59;
          goto _L10
_L5:
        i = 14;
          goto _L10
_L6:
        i = 64;
          goto _L10
        i = 33;
          goto _L10
        k = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            System.loadLibrary((new String(ac1)).intern());
        }
        if (true) goto _L1; else goto _L11
_L11:
    }
}
