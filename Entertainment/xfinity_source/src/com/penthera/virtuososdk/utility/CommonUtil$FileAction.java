// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class  extends Enum
{

    public static final EUpdate EAdd;
    public static final EUpdate EAddToCollection;
    public static final EUpdate EExpire;
    public static final EUpdate EListAllFiles;
    public static final EUpdate EListDownloaded;
    public static final EUpdate EListQueued;
    public static final EUpdate EMove;
    private static final EUpdate ENUM$VALUES[];
    public static final EUpdate ERemove;
    public static final EUpdate ERemoveAll;
    public static final EUpdate ERemoveAllFromQueue;
    public static final EUpdate EUpdate;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$FileAction, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        EAdd = new <init>("EAdd", 0);
        EAddToCollection = new <init>("EAddToCollection", 1);
        EMove = new <init>("EMove", 2);
        ERemove = new <init>("ERemove", 3);
        EListQueued = new <init>("EListQueued", 4);
        EListDownloaded = new <init>("EListDownloaded", 5);
        EListAllFiles = new <init>("EListAllFiles", 6);
        ERemoveAllFromQueue = new <init>("ERemoveAllFromQueue", 7);
        ERemoveAll = new <init>("ERemoveAll", 8);
        EExpire = new <init>("EExpire", 9);
        EUpdate = new <init>("EUpdate", 10);
        ENUM$VALUES = (new ENUM.VALUES[] {
            EAdd, EAddToCollection, EMove, ERemove, EListQueued, EListDownloaded, EListAllFiles, ERemoveAllFromQueue, ERemoveAll, EExpire, 
            EUpdate
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
