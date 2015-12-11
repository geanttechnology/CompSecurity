// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Field;

// Referenced classes of package com.amazon.device.ads:
//            Log

class Controller
{
    public static class Dimensions extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Dimensions createFromParcel(Parcel parcel)
            {
                return new Dimensions(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Dimensions[] newArray(int i)
            {
                return new Dimensions[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int height;
        public int width;
        public int x;
        public int y;


        public Dimensions()
        {
            x = -1;
            y = -1;
            width = -1;
            height = -1;
        }

        public Dimensions(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class PlayerProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public PlayerProperties createFromParcel(Parcel parcel)
            {
                return new PlayerProperties(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public PlayerProperties[] newArray(int i)
            {
                return new PlayerProperties[i];
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


        public PlayerProperties()
        {
            autoPlay = true;
            showControl = true;
            doLoop = false;
            audioMuted = false;
            startStyle = "normal";
            stopStyle = "normal";
        }

        public PlayerProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class ReflectedParcelable
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ReflectedParcelable createFromParcel(Parcel parcel)
            {
                return new ReflectedParcelable(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ReflectedParcelable[] newArray(int i)
            {
                return new ReflectedParcelable[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            Field afield[] = getClass().getDeclaredFields();
            int j = afield.length;
            i = 0;
            while (i < j) 
            {
                Object obj = afield[i];
                try
                {
                    obj = ((Field) (obj)).get(this);
                    if (!(obj instanceof android.os.Parcelable.Creator))
                    {
                        parcel.writeValue(obj);
                    }
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", new Object[] {
                        illegalaccessexception.getMessage()
                    });
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", new Object[] {
                        illegalargumentexception.getMessage()
                    });
                }
                i++;
            }
        }


        public ReflectedParcelable()
        {
        }

        protected ReflectedParcelable(Parcel parcel)
        {
            Field afield[] = getClass().getDeclaredFields();
            int j = afield.length;
            int i = 0;
            while (i < j) 
            {
                Field field = afield[i];
                try
                {
                    if (!(field.get(this) instanceof android.os.Parcelable.Creator))
                    {
                        field.set(this, parcel.readValue(null));
                    }
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", new Object[] {
                        illegalaccessexception.getMessage()
                    });
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", new Object[] {
                        illegalargumentexception.getMessage()
                    });
                }
                i++;
            }
        }
    }


    private static String LOG_TAG = "Controller";

    Controller()
    {
    }


}
