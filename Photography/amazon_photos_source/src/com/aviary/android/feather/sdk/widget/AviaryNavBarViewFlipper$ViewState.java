// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryNavBarViewFlipper

private static class <init>
{
    static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status Close;
        public static final Status Open;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/aviary/android/feather/sdk/widget/AviaryNavBarViewFlipper$ViewState$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            Open = new Status("Open", 0);
            Close = new Status("Close", 1);
            $VALUES = (new Status[] {
                Open, Close
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    Status current;
    Status previous;

    void setCurrent(Status status)
    {
        previous = current;
        current = status;
    }

    private Status()
    {
    }

    Status(Status status)
    {
        this();
    }
}
