// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Field;

// Referenced classes of package com.amazon.device.ads:
//            Controller, Log

public static class _cls1
    implements Parcelable
{

    public static final android.os.age CREATOR = new android.os.Parcelable.Creator() {

        public Controller.ReflectedParcelable createFromParcel(Parcel parcel)
        {
            return new Controller.ReflectedParcelable(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Controller.ReflectedParcelable[] newArray(int i)
        {
            return new Controller.ReflectedParcelable[i];
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
                if (!(obj instanceof android.os.Parcelable))
                {
                    parcel.writeValue(obj);
                }
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.e(Controller.access$000(), "Error: Could not write to parcel: %s", new Object[] {
                    illegalaccessexception.getMessage()
                });
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.e(Controller.access$000(), "Error: Could not write to parcel: %s", new Object[] {
                    illegalargumentexception.getMessage()
                });
            }
            i++;
        }
    }


    public _cls1()
    {
    }

    protected _cls1(Parcel parcel)
    {
        Field afield[] = getClass().getDeclaredFields();
        int j = afield.length;
        int i = 0;
        while (i < j) 
        {
            Field field = afield[i];
            try
            {
                if (!(field.get(this) instanceof android.os.Parcelable))
                {
                    field.set(this, parcel.readValue(null));
                }
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.e(Controller.access$000(), "Error: Could not create object from parcel: %s", new Object[] {
                    illegalaccessexception.getMessage()
                });
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.e(Controller.access$000(), "Error: Could not create object from parcel: %s", new Object[] {
                    illegalargumentexception.getMessage()
                });
            }
            i++;
        }
    }
}
