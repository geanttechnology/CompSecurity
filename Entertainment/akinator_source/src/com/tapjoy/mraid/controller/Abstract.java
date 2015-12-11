// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tapjoy.mraid.util.NavigationStringEnum;
import com.tapjoy.mraid.util.TransitionStringEnum;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Abstract
{
    public static class Dimensions extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new Dimensions(parcel);
            }

            public final volatile Object[] newArray(int i)
            {
                return new Dimensions[i];
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

        protected Dimensions(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class PlayerProperties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new PlayerProperties(parcel);
            }

            public final volatile Object[] newArray(int i)
            {
                return new PlayerProperties[i];
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
            autoPlay = flag1;
            showControl = flag2;
            doLoop = flag4;
            audioMuted = flag;
            startStyle = s;
            stopStyle = s1;
            inline = flag3;
        }

        public void setStopStyle(String s)
        {
            stopStyle = s;
        }

        public boolean showControl()
        {
            return showControl;
        }


        public PlayerProperties()
        {
            showControl = true;
            autoPlay = true;
            audioMuted = false;
            doLoop = false;
            stopStyle = "normal";
            startStyle = "normal";
            inline = false;
        }

        public PlayerProperties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class Properties extends ReflectedParcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new Properties(parcel);
            }

            public final volatile Object[] newArray(int i)
            {
                return new Properties[i];
            }

        };
        public int backgroundColor;
        public float backgroundOpacity;
        public boolean isModal;
        public boolean lockOrientation;
        public boolean useBackground;
        public boolean useCustomClose;


        public Properties()
        {
            useBackground = false;
            backgroundColor = 0;
            backgroundOpacity = 0.0F;
            isModal = false;
            lockOrientation = false;
            useCustomClose = false;
        }

        protected Properties(Parcel parcel)
        {
            super(parcel);
        }
    }

    public static class ReflectedParcelable
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
            if (!(obj instanceof android.os.Parcelable.Creator))
            {
                parcel.writeValue(obj);
            }
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public ReflectedParcelable()
        {
        }

        protected ReflectedParcelable(Parcel parcel)
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
            if (!(field.get(this) instanceof android.os.Parcelable.Creator))
            {
                field.set(this, parcel.readValue(null));
            }
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }
    }


    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected MraidView a;
    protected Context b;

    public Abstract(MraidView mraidview, Context context)
    {
        a = mraidview;
        b = context;
    }

    protected static Object a(JSONObject jsonobject, Class class1)
    {
        Field afield[];
        int j;
        afield = class1.getDeclaredFields();
        class1 = ((Class) (class1.newInstance()));
        j = 0;
_L9:
        if (j >= afield.length) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        String s1;
        obj = afield[j];
        s = ((Field) (obj)).getName().replace('_', '-');
        s1 = ((Field) (obj)).getType().toString();
        if (!s1.equals("int")) goto _L4; else goto _L3
_L3:
        boolean flag;
        s = jsonobject.getString(s).toLowerCase();
        flag = s.startsWith("#");
        if (!flag) goto _L6; else goto _L5
_L5:
        int i = -1;
        if (!s.startsWith("#0x")) goto _L8; else goto _L7
_L7:
        int k = Integer.decode(s.substring(1)).intValue();
        i = k;
_L10:
        try
        {
            ((Field) (obj)).set(class1, Integer.valueOf(i));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
        }
_L11:
        j++;
          goto _L9
_L8:
        k = Integer.parseInt(s.substring(1), 16);
        i = k;
          goto _L10
_L6:
        i = Integer.parseInt(s);
          goto _L10
_L4:
label0:
        {
            if (!s1.equals("class java.lang.String"))
            {
                break label0;
            }
            ((Field) (obj)).set(class1, jsonobject.getString(s));
        }
          goto _L11
label1:
        {
            if (!s1.equals("boolean"))
            {
                break label1;
            }
            ((Field) (obj)).set(class1, Boolean.valueOf(jsonobject.getBoolean(s)));
        }
          goto _L11
label2:
        {
            if (!s1.equals("float"))
            {
                break label2;
            }
            ((Field) (obj)).set(class1, Float.valueOf(Float.parseFloat(jsonobject.getString(s))));
        }
          goto _L11
        if (!s1.equals("class com.tapjoy.mraid.util.NavigationStringEnum")) goto _L13; else goto _L12
_L12:
        ((Field) (obj)).set(class1, NavigationStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L13:
        if (!s1.equals("class com.tapjoy.mraid.util.TransitionStringEnum")) goto _L11; else goto _L14
_L14:
        ((Field) (obj)).set(class1, TransitionStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L2:
        return class1;
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L10
    }

    public abstract void stopAllListeners();
}
