// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class  extends Enum
{

    public static final EItemDownloadRemoved ECollectionComplete;
    public static final EItemDownloadRemoved ECollectionProgress;
    public static final EItemDownloadRemoved ECollectionsChanged;
    public static final EItemDownloadRemoved ECollectionsDeleted;
    public static final EItemDownloadRemoved EDownloadEnd;
    public static final EItemDownloadRemoved EDownloadQueueChanged;
    public static final EItemDownloadRemoved EDownloadStart;
    public static final EItemDownloadRemoved EDownloadedListChanged;
    public static final EItemDownloadRemoved EFragmentComplete;
    public static final EItemDownloadRemoved EFullListChanged;
    public static final EItemDownloadRemoved EItemDownloadRemoved;
    public static final EItemDownloadRemoved EItemUpdate;
    public static final EItemDownloadRemoved EListFiles;
    public static final EItemDownloadRemoved EListFilesIteratively;
    private static final EItemDownloadRemoved ENUM$VALUES[];
    public static final EItemDownloadRemoved EProgressUpdate;
    public static final EItemDownloadRemoved ESettingsChanged;
    public static final EItemDownloadRemoved EStatusChange;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType, s);
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
        EStatusChange = new <init>("EStatusChange", 0);
        EDownloadStart = new <init>("EDownloadStart", 1);
        EProgressUpdate = new <init>("EProgressUpdate", 2);
        EDownloadEnd = new <init>("EDownloadEnd", 3);
        EDownloadQueueChanged = new <init>("EDownloadQueueChanged", 4);
        EDownloadedListChanged = new <init>("EDownloadedListChanged", 5);
        EFullListChanged = new <init>("EFullListChanged", 6);
        EListFiles = new <init>("EListFiles", 7);
        EListFilesIteratively = new <init>("EListFilesIteratively", 8);
        ESettingsChanged = new <init>("ESettingsChanged", 9);
        EItemUpdate = new <init>("EItemUpdate", 10);
        ECollectionsChanged = new <init>("ECollectionsChanged", 11);
        ECollectionsDeleted = new <init>("ECollectionsDeleted", 12);
        ECollectionProgress = new <init>("ECollectionProgress", 13);
        ECollectionComplete = new <init>("ECollectionComplete", 14);
        EFragmentComplete = new <init>("EFragmentComplete", 15);
        EItemDownloadRemoved = new <init>("EItemDownloadRemoved", 16);
        ENUM$VALUES = (new ENUM.VALUES[] {
            EStatusChange, EDownloadStart, EProgressUpdate, EDownloadEnd, EDownloadQueueChanged, EDownloadedListChanged, EFullListChanged, EListFiles, EListFilesIteratively, ESettingsChanged, 
            EItemUpdate, ECollectionsChanged, ECollectionsDeleted, ECollectionProgress, ECollectionComplete, EFragmentComplete, EItemDownloadRemoved
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
