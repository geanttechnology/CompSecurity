// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Parcel;

// Referenced classes of package com.amazon.device.ads:
//            Controller

public static class le extends le
{

    public static final android.os.Properties.showControl CREATOR = new android.os.Parcelable.Creator() {

        public Controller.PlayerProperties createFromParcel(Parcel parcel)
        {
            return new Controller.PlayerProperties(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Controller.PlayerProperties[] newArray(int i)
        {
            return new Controller.PlayerProperties[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public boolean inline;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;

    public boolean doLoop()
    {
        return doLoop;
    }

    public boolean doMute()
    {
        return audioMuted;
    }

    public boolean exitOnComplete()
    {
        return stopStyle.equalsIgnoreCase("exit");
    }

    public boolean isAutoPlay()
    {
        return autoPlay;
    }

    public boolean isFullScreen()
    {
        return startStyle.equalsIgnoreCase("fullscreen");
    }

    public void muteAudio()
    {
        audioMuted = true;
    }

    public void setProperties(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, String s, String s1)
    {
        audioMuted = flag;
        autoPlay = flag1;
        showControl = flag2;
        inline = flag3;
        doLoop = flag4;
        startStyle = s;
        stopStyle = s1;
    }

    public boolean showControl()
    {
        return showControl;
    }


    public _cls1()
    {
        autoPlay = true;
        showControl = true;
        doLoop = false;
        audioMuted = false;
        startStyle = "normal";
        stopStyle = "normal";
    }

    public stopStyle(Parcel parcel)
    {
        super(parcel);
    }
}
