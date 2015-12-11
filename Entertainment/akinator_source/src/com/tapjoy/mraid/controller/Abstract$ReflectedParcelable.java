// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.os.Parcel;
import android.os.Parcelable;
import com.tapjoy.mraid.util.NavigationStringEnum;
import com.tapjoy.mraid.util.TransitionStringEnum;
import java.lang.reflect.Field;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public static class 
    implements Parcelable
{

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Field afield[];
        afield = getClass().getDeclaredFields();
        i = 0;
_L2:
        if (i >= afield.length)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Object obj = afield[i];
        Object obj1;
        obj1 = ((Field) (obj)).getType();
        if (!((Class) (obj1)).isEnum())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj1 = ((Class) (obj1)).toString();
        if (((String) (obj1)).equals("class com.tapjoy.mraid.util.NavigationStringEnum"))
        {
            parcel.writeString(((NavigationStringEnum)((Field) (obj)).get(this)).getText());
            break MISSING_BLOCK_LABEL_138;
        }
        try
        {
            if (((String) (obj1)).equals("class com.tapjoy.mraid.util.TransitionStringEnum"))
            {
                parcel.writeString(((TransitionStringEnum)((Field) (obj)).get(this)).getText());
            }
            break MISSING_BLOCK_LABEL_138;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
            return;
        }
        return;
        obj = ((Field) (obj)).get(this);
        if (!(obj instanceof android.os.ackTrace))
        {
            parcel.writeValue(obj);
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ()
    {
    }

    protected (Parcel parcel)
    {
        Field afield[];
        int i;
        afield = getClass().getDeclaredFields();
        i = 0;
_L2:
        if (i >= afield.length)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        Field field = afield[i];
        Object obj;
        obj = field.getType();
        if (!((Class) (obj)).isEnum())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = ((Class) (obj)).toString();
        if (((String) (obj)).equals("class com.tapjoy.mraid.util.NavigationStringEnum"))
        {
            field.set(this, NavigationStringEnum.fromString(parcel.readString()));
            break MISSING_BLOCK_LABEL_134;
        }
        try
        {
            if (((String) (obj)).equals("class com.tapjoy.mraid.util.TransitionStringEnum"))
            {
                field.set(this, TransitionStringEnum.fromString(parcel.readString()));
            }
            break MISSING_BLOCK_LABEL_134;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
            return;
        }
        return;
        if (!(field.get(this) instanceof android.os.ackTrace))
        {
            field.set(this, parcel.readValue(null));
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
