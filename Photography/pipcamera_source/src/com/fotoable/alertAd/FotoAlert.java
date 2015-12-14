// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertad;

import android.content.Context;
import android.content.SharedPreferences;
import ep;
import eu;
import ew;
import java.util.ArrayList;
import kv;
import org.json.JSONObject;

public class FotoAlert
{

    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public FotoAlertType h;
    private Context i;

    public FotoAlert(Context context)
    {
        b = 0;
        c = null;
        i = context;
    }

    public static FotoAlert a(JSONObject jsonobject, Context context)
    {
        if (jsonobject != null)
        {
            context = new FotoAlert(context);
            if (!jsonobject.isNull("alertId"))
            {
                context.a = kv.e(jsonobject, "alertId");
                if (!jsonobject.isNull("showTimes"))
                {
                    context.b = kv.e(jsonobject, "showTimes");
                }
                if (((FotoAlert) (context)).b < 1)
                {
                    context.b = 1;
                }
                if (!jsonobject.isNull("imageUrl"))
                {
                    context.c = kv.a(jsonobject, "imageUrl");
                }
                if (((FotoAlert) (context)).c != null && ((FotoAlert) (context)).c.length() > 0)
                {
                    if (!jsonobject.isNull("alertType"))
                    {
                        context.h = c(kv.e(jsonobject, "alertType"));
                    }
                    if (!jsonobject.isNull("stepUrl"))
                    {
                        context.d = kv.a(jsonobject, "stepUrl");
                    }
                    if (!jsonobject.isNull("version"))
                    {
                        context.e = kv.a(jsonobject, "version");
                    }
                    if (!jsonobject.isNull("schemUrl"))
                    {
                        context.f = kv.a(jsonobject, "schemUrl");
                    }
                    if (!jsonobject.isNull("funName"))
                    {
                        context.g = kv.a(jsonobject, "funName");
                    }
                    if ((((FotoAlert) (context)).h != FotoAlertType.FotoAlertFun || ((FotoAlert) (context)).g != null && ((FotoAlert) (context)).g.length() > 0) && (((FotoAlert) (context)).h != FotoAlertType.FotoAlertApp && ((FotoAlert) (context)).h != FotoAlertType.FotoAlertUpdate || ((FotoAlert) (context)).d != null && ((FotoAlert) (context)).d.length() > 0))
                    {
                        return context;
                    }
                }
            }
        }
        return null;
    }

    private boolean b()
    {
        if (f != null && f.length() > 0)
        {
            return ew.a(i, f);
        } else
        {
            return false;
        }
    }

    public static FotoAlertType c(int j)
    {
        switch (j)
        {
        default:
            return FotoAlertType.FotoAlertNone;

        case 0: // '\0'
            return FotoAlertType.FotoAlertNone;

        case 1: // '\001'
            return FotoAlertType.FotoAlertUpdate;

        case 2: // '\002'
            return FotoAlertType.FotoAlertApp;

        case 3: // '\003'
            return FotoAlertType.FotoAlertFun;
        }
    }

    private boolean c()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (e != null)
        {
            flag = flag1;
            if (e.length() > 0)
            {
                flag = flag1;
                if (!ew.a(e, ew.h(i)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int a(int j)
    {
        String s = (new StringBuilder()).append("FotoAlertShow_Id_").append(j).toString();
        return i.getSharedPreferences("FotoAlertFactoryPreference", 0).getInt(s, 0);
    }

    public String a(String s)
    {
        if (s == null || s.length() <= 0)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append("/").append(eu.a(c)).toString();
        }
    }

    public boolean a()
    {
        boolean flag = true;
        if (a(a) < b)
        {
            if (h == FotoAlertType.FotoAlertUpdate)
            {
                return c();
            }
            if (h == FotoAlertType.FotoAlertApp)
            {
                if (b())
                {
                    flag = false;
                }
                return flag;
            }
            if (h == FotoAlertType.FotoAlertFun)
            {
                ArrayList arraylist = ep.b(i);
                if (arraylist != null && arraylist.size() > 0 && arraylist.contains(g))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void b(int j)
    {
        String s = (new StringBuilder()).append("FotoAlertShow_Id_").append(j).toString();
        SharedPreferences sharedpreferences = i.getSharedPreferences("FotoAlertFactoryPreference", 0);
        j = sharedpreferences.getInt(s, 0);
        sharedpreferences.edit().putInt(s, j + 1).apply();
    }

    private class FotoAlertType extends Enum
    {

        private static final FotoAlertType $VALUES[];
        public static final FotoAlertType FotoAlertApp;
        public static final FotoAlertType FotoAlertFun;
        public static final FotoAlertType FotoAlertNone;
        public static final FotoAlertType FotoAlertUpdate;

        public static FotoAlertType valueOf(String s)
        {
            return (FotoAlertType)Enum.valueOf(com/fotoable/alertad/FotoAlert$FotoAlertType, s);
        }

        public static FotoAlertType[] values()
        {
            return (FotoAlertType[])$VALUES.clone();
        }

        static 
        {
            FotoAlertNone = new FotoAlertType("FotoAlertNone", 0);
            FotoAlertUpdate = new FotoAlertType("FotoAlertUpdate", 1);
            FotoAlertApp = new FotoAlertType("FotoAlertApp", 2);
            FotoAlertFun = new FotoAlertType("FotoAlertFun", 3);
            $VALUES = (new FotoAlertType[] {
                FotoAlertNone, FotoAlertUpdate, FotoAlertApp, FotoAlertFun
            });
        }

        private FotoAlertType(String s, int j)
        {
            super(s, j);
        }
    }

}
