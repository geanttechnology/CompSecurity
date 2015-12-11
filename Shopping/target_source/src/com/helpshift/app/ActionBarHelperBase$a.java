// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.helpshift.widget.SimpleSearchView;
import com.helpshift.x;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.helpshift.app:
//            ActionBarHelperBase, e

private class a extends MenuInflater
{

    MenuInflater a;
    final ActionBarHelperBase b;

    private void a(int i)
    {
        Object obj;
        XmlResourceParser xmlresourceparser;
        Object obj2;
        int j;
        j = 0;
        obj = null;
        obj2 = null;
        xmlresourceparser = null;
        XmlResourceParser xmlresourceparser1 = b.a.getResources().getXml(i);
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        int k = xmlresourceparser1.getEventType();
        i = j;
        j = k;
          goto _L1
_L3:
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        k = xmlresourceparser1.next();
        i = j;
        j = k;
          goto _L1
_L10:
        j = i;
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        if (!xmlresourceparser1.getName().equals("item")) goto _L3; else goto _L2
_L2:
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        k = xmlresourceparser1.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "id", 0);
        j = i;
        if (k == 0) goto _L3; else goto _L4
_L4:
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        j = xmlresourceparser1.getAttributeIntValue("http://schemas.android.com/apk/res/android", "showAsAction", -1);
        if ((j & 2) == 0 && (j & 1) == 0)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        j = xmlresourceparser1.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "actionLayout", 0);
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        ActionBarHelperBase.c(b).put(Integer.valueOf(k), Integer.valueOf(j));
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        ActionBarHelperBase.d(b).add(Integer.valueOf(k));
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        String s = xmlresourceparser1.getAttributeValue("http://schemas.android.com/apk/res/android", "actionViewClass");
        j = i;
        if (s == null) goto _L3; else goto _L5
_L5:
        xmlresourceparser = xmlresourceparser1;
        obj = xmlresourceparser1;
        obj2 = xmlresourceparser1;
        ActionBarHelperBase.a(b).put(Integer.valueOf(k), s);
        j = i;
          goto _L3
        obj2;
        obj = xmlresourceparser;
        throw new InflateException("Error inflating menu XML", ((Throwable) (obj2)));
        Object obj1;
        obj1;
        if (obj != null)
        {
            ((XmlResourceParser) (obj)).close();
        }
        throw obj1;
_L9:
        j = 1;
          goto _L3
_L7:
        if (xmlresourceparser1 != null)
        {
            xmlresourceparser1.close();
        }
        return;
        obj1;
        obj = obj2;
        throw new InflateException("Error inflating menu XML", ((Throwable) (obj1)));
_L1:
        if (i != 0) goto _L7; else goto _L6
_L6:
        j;
        JVM INSTR tableswitch 1 2: default 432
    //                   1 368
    //                   2 84;
           goto _L8 _L9 _L10
_L8:
        j = i;
        if (true) goto _L3; else goto _L11
_L11:
    }

    public void inflate(int i, Menu menu)
    {
        a(i);
        a.inflate(i, menu);
        i = 0;
        while (i < menu.size()) 
        {
            try
            {
                e e1 = (e)menu.getItem(i);
                int j = e1.getItemId();
                if (ActionBarHelperBase.a(b).containsKey(Integer.valueOf(j)) && ((String)ActionBarHelperBase.a(b).get(Integer.valueOf(j))).equals("android.widget.SearchView"))
                {
                    SimpleSearchView simplesearchview = (SimpleSearchView)ActionBarHelperBase.b(b).inflate(com.helpshift.e.a.b, null);
                    simplesearchview.setId(j);
                    e1.setActionView(simplesearchview);
                }
                if (ActionBarHelperBase.c(b).containsKey(Integer.valueOf(e1.getItemId())))
                {
                    View view = ActionBarHelperBase.b(b).inflate(((Integer)ActionBarHelperBase.c(b).get(Integer.valueOf(e1.getItemId()))).intValue(), null);
                    view.setId(j);
                    e1.setActionView(view);
                }
            }
            catch (ClassCastException classcastexception)
            {
                x.a(ActionBarHelperBase.c(), "ClassCastException on hardware menu button click", classcastexception);
            }
            i++;
        }
    }

    public (ActionBarHelperBase actionbarhelperbase, Context context, MenuInflater menuinflater)
    {
        b = actionbarhelperbase;
        super(context);
        a = menuinflater;
    }
}
