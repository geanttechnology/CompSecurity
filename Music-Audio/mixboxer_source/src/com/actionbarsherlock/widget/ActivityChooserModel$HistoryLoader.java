// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.Context;
import android.os.Handler;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.actionbarsherlock.widget:
//            ActivityChooserModel

final class <init>
    implements Runnable
{

    final ActivityChooserModel this$0;

    public final void run()
    {
        Object obj;
        Object obj1;
        Exception exception;
        Object obj3;
        int i;
        try
        {
            obj = ActivityChooserModel.access$400(ActivityChooserModel.this).openFileInput(ActivityChooserModel.access$300(ActivityChooserModel.this));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        obj1 = Xml.newPullParser();
        ((XmlPullParser) (obj1)).setInput(((java.io.InputStream) (obj)), null);
        i = 0;
_L1:
        if (i == 1 || i == 2)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        i = ((XmlPullParser) (obj1)).next();
          goto _L1
        if (!"historical-records".equals(((XmlPullParser) (obj1)).getName()))
        {
            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        }
          goto _L2
        obj1;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error reading historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        ((FileInputStream) (obj)).close();
_L6:
        return;
_L2:
        obj3 = new ArrayList();
_L4:
        i = ((XmlPullParser) (obj1)).next();
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        if (i == 3 || i == 4) goto _L4; else goto _L3
_L3:
        if (!"historical-record".equals(((XmlPullParser) (obj1)).getName()))
        {
            throw new XmlPullParserException("Share records file not well-formed.");
        }
        break MISSING_BLOCK_LABEL_220;
        obj1;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error reading historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        ((List) (obj3)).add(new rd(((XmlPullParser) (obj1)).getAttributeValue(null, "activity"), Long.parseLong(((XmlPullParser) (obj1)).getAttributeValue(null, "time")), Float.parseFloat(((XmlPullParser) (obj1)).getAttributeValue(null, "weight"))));
          goto _L4
        exception;
        class _cls1
            implements Runnable
        {

            final ActivityChooserModel.HistoryLoader this$1;

            public void run()
            {
                ActivityChooserModel.access$800(this$0);
                ActivityChooserModel.access$900(this$0);
            }

            _cls1()
            {
                this$1 = ActivityChooserModel.HistoryLoader.this;
                super();
            }
        }

        IOException ioexception;
        Object obj2;
        Exception exception1;
        List list;
        int j;
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            catch (IOException ioexception1) { }
        }
        throw exception;
        obj2 = ActivityChooserModel.access$500(ActivityChooserModel.this);
        obj2;
        JVM INSTR monitorenter ;
        obj3 = new LinkedHashSet(((java.util.Collection) (obj3)));
        list = ActivityChooserModel.access$600(ActivityChooserModel.this);
        j = list.size() - 1;
_L8:
        if (j < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((Set) (obj3)).add((rd)list.get(j));
        j--;
        if (true) goto _L8; else goto _L7
_L7:
        if (list.size() != ((Set) (obj3)).size())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        obj2;
        JVM INSTR monitorexit ;
        if (obj == null) goto _L6; else goto _L9
_L9:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        list.clear();
        list.addAll(((java.util.Collection) (obj3)));
        ActivityChooserModel.access$702(ActivityChooserModel.this, true);
        ActivityChooserModel.access$1000(ActivityChooserModel.this).post(new _cls1());
        obj2;
        JVM INSTR monitorexit ;
        if (obj == null) goto _L6; else goto _L10
_L10:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return;
        }
        exception1;
        obj2;
        JVM INSTR monitorexit ;
        throw exception1;
        ioexception;
    }

    private _cls1()
    {
        this$0 = ActivityChooserModel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
