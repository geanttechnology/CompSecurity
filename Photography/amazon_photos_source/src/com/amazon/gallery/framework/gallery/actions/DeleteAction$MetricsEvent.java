// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

public static final class ce extends Enum
{

    private static final DeleteFile $VALUES[];
    public static final DeleteFile DeleteClicked;
    public static final DeleteFile DeleteFile;
    public static final DeleteFile MultiSelectDeleteCloudActivated;
    public static final DeleteFile MultiSelectDeleteCloudAndDeviceActivated;
    public static final DeleteFile MultiSelectDeleteCloudAndDeviceCompleted;
    public static final DeleteFile MultiSelectDeleteCloudCompleted;
    public static final DeleteFile MultiSelectDeleteDeviceActivated;
    public static final DeleteFile MultiSelectDeleteDeviceCompleted;
    public static final DeleteFile MultiSelectDeleteUnifiedActivated;
    public static final DeleteFile MultiSelectDeleteUnifiedCompleted;
    public static final DeleteFile SingleViewDeleteCloudActivated;
    public static final DeleteFile SingleViewDeleteCloudCompleted;
    public static final DeleteFile SingleViewDeleteDeviceActivated;
    public static final DeleteFile SingleViewDeleteDeviceCompleted;
    public static final DeleteFile SingleViewDeleteUnifiedActivated;
    public static final DeleteFile SingleViewDeleteUnifiedCompleted;

    public static ce getEvent(ce ce, ce ce1, ce ce2)
    {
        return (ce)DeleteAction.access$000().get(new init>(ce, ce1, ce2));
    }

    public static ce valueOf(String s)
    {
        return (ce)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$MetricsEvent, s);
    }

    public static ce[] values()
    {
        return (ce[])$VALUES.clone();
    }

    static 
    {
        MultiSelectDeleteDeviceActivated = new <init>("MultiSelectDeleteDeviceActivated", 0, AL, ce.MULTISELECT, CTIVATED);
        MultiSelectDeleteCloudActivated = new <init>("MultiSelectDeleteCloudActivated", 1, UD, ce.MULTISELECT, CTIVATED);
        MultiSelectDeleteCloudAndDeviceActivated = new <init>("MultiSelectDeleteCloudAndDeviceActivated", 2, UD_AND_LOCAL, ce.MULTISELECT, CTIVATED);
        MultiSelectDeleteUnifiedActivated = new <init>("MultiSelectDeleteUnifiedActivated", 3, FIED, ce.MULTISELECT, CTIVATED);
        MultiSelectDeleteDeviceCompleted = new <init>("MultiSelectDeleteDeviceCompleted", 4, AL, ce.MULTISELECT, OMPLETED);
        MultiSelectDeleteCloudCompleted = new <init>("MultiSelectDeleteCloudCompleted", 5, UD, ce.MULTISELECT, OMPLETED);
        MultiSelectDeleteCloudAndDeviceCompleted = new <init>("MultiSelectDeleteCloudAndDeviceCompleted", 6, UD_AND_LOCAL, ce.MULTISELECT, OMPLETED);
        MultiSelectDeleteUnifiedCompleted = new <init>("MultiSelectDeleteUnifiedCompleted", 7, FIED, ce.MULTISELECT, OMPLETED);
        SingleViewDeleteDeviceActivated = new <init>("SingleViewDeleteDeviceActivated", 8, AL, ce.SINGLE_VIEW_HAB, CTIVATED);
        SingleViewDeleteCloudActivated = new <init>("SingleViewDeleteCloudActivated", 9, UD, ce.SINGLE_VIEW_HAB, CTIVATED);
        SingleViewDeleteUnifiedActivated = new <init>("SingleViewDeleteUnifiedActivated", 10, FIED, ce.SINGLE_VIEW_HAB, CTIVATED);
        SingleViewDeleteDeviceCompleted = new <init>("SingleViewDeleteDeviceCompleted", 11, AL, ce.SINGLE_VIEW_HAB, OMPLETED);
        SingleViewDeleteCloudCompleted = new <init>("SingleViewDeleteCloudCompleted", 12, UD, ce.SINGLE_VIEW_HAB, OMPLETED);
        SingleViewDeleteUnifiedCompleted = new <init>("SingleViewDeleteUnifiedCompleted", 13, FIED, ce.SINGLE_VIEW_HAB, OMPLETED);
        DeleteClicked = new <init>("DeleteClicked", 14);
        DeleteFile = new <init>("DeleteFile", 15);
        $VALUES = (new .VALUES[] {
            MultiSelectDeleteDeviceActivated, MultiSelectDeleteCloudActivated, MultiSelectDeleteCloudAndDeviceActivated, MultiSelectDeleteUnifiedActivated, MultiSelectDeleteDeviceCompleted, MultiSelectDeleteCloudCompleted, MultiSelectDeleteCloudAndDeviceCompleted, MultiSelectDeleteUnifiedCompleted, SingleViewDeleteDeviceActivated, SingleViewDeleteCloudActivated, 
            SingleViewDeleteUnifiedActivated, SingleViewDeleteDeviceCompleted, SingleViewDeleteCloudCompleted, SingleViewDeleteUnifiedCompleted, DeleteClicked, DeleteFile
        });
    }

    private ce(String s, int i)
    {
        super(s, i);
    }

    private ce(String s, int i, ce ce, ce ce1, ce ce2)
    {
        super(s, i);
        DeleteAction.access$000().put(new init>(ce, ce1, ce2), this);
    }
}
