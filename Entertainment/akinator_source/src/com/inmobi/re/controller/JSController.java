// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Context;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;
import java.lang.reflect.Field;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController
{

    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected ExpandProperties expProps;
    protected IMWebView imWebView;
    protected Context mContext;
    protected ExpandProperties temporaryexpProps;

    public JSController(IMWebView imwebview, Context context)
    {
        imWebView = imwebview;
        mContext = context;
    /* block-local class not found */
    class ExpandProperties {}

        expProps = new ExpandProperties();
        temporaryexpProps = new ExpandProperties();
    }

    protected static Object getFromJSON(JSONObject jsonobject, Class class1)
        throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException
    {
        Field afield[];
        int j;
        afield = class1.getDeclaredFields();
        class1 = ((Class) (class1.newInstance()));
        j = 0;
_L9:
        if (j >= afield.length) goto _L2; else goto _L1
_L1:
        Field field;
        String s;
        String s1;
        field = afield[j];
        s = field.getName().replace('_', '-');
        s1 = field.getType().toString();
        if (!s1.equals("int")) goto _L4; else goto _L3
_L3:
        s = jsonobject.getString(s).toLowerCase(Locale.ENGLISH);
        boolean flag = s.startsWith("#");
        if (!flag) goto _L6; else goto _L5
_L5:
        int i = -1;
        if (!s.startsWith("#0x")) goto _L8; else goto _L7
_L7:
        int k = Integer.decode(s.substring(1)).intValue();
        i = k;
_L10:
        NumberFormatException numberformatexception;
        try
        {
            field.set(class1, Integer.valueOf(i));
        }
        catch (JSONException jsonexception) { }
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
            field.set(class1, jsonobject.getString(s));
        }
          goto _L11
label1:
        {
            if (!s1.equals("boolean"))
            {
                break label1;
            }
            field.set(class1, Boolean.valueOf(jsonobject.getBoolean(s)));
        }
          goto _L11
label2:
        {
            if (!s1.equals("float"))
            {
                break label2;
            }
            field.set(class1, Float.valueOf(Float.parseFloat(jsonobject.getString(s))));
        }
          goto _L11
        if (!s1.equals("class com.mraid.NavigationStringEnum")) goto _L13; else goto _L12
_L12:
        field.set(class1, NavigationStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L13:
        if (!s1.equals("class com.mraid.TransitionStringEnum")) goto _L11; else goto _L14
_L14:
        field.set(class1, TransitionStringEnum.fromString(jsonobject.getString(s)));
          goto _L11
_L2:
        return class1;
        numberformatexception;
        i = 0;
          goto _L10
        numberformatexception;
          goto _L10
    }

    public abstract void stopAllListeners();

    // Unreferenced inner class com/inmobi/re/controller/JSController$Dimensions
    /* block-local class not found */
    class Dimensions {}


    // Unreferenced inner class com/inmobi/re/controller/JSController$OrientationProperties
    /* block-local class not found */
    class OrientationProperties {}


    // Unreferenced inner class com/inmobi/re/controller/JSController$PlayerProperties
    /* block-local class not found */
    class PlayerProperties {}


    // Unreferenced inner class com/inmobi/re/controller/JSController$Properties
    /* block-local class not found */
    class Properties {}


    // Unreferenced inner class com/inmobi/re/controller/JSController$ReflectedParcelable
    /* block-local class not found */
    class ReflectedParcelable {}


    // Unreferenced inner class com/inmobi/re/controller/JSController$ResizeProperties
    /* block-local class not found */
    class ResizeProperties {}

}
