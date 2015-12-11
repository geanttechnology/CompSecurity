// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.actionbarsherlock.widget:
//            ActivityChooserModel

final class <init>
    implements Runnable
{

    final ActivityChooserModel this$0;

    public final void run()
    {
        ArrayList arraylist;
        synchronized (ActivityChooserModel.access$500(ActivityChooserModel.this))
        {
            arraylist = new ArrayList(ActivityChooserModel.access$600(ActivityChooserModel.this));
        }
        obj = ActivityChooserModel.access$400(ActivityChooserModel.this).openFileOutput(ActivityChooserModel.access$300(ActivityChooserModel.this), 0);
        XmlSerializer xmlserializer = Xml.newSerializer();
        int j;
        xmlserializer.setOutput(((java.io.OutputStream) (obj)), null);
        xmlserializer.startDocument("UTF-8", Boolean.valueOf(true));
        xmlserializer.startTag(null, "historical-records");
        j = arraylist.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        <init> <init>1 = (this._cls0)arraylist.remove(0);
        xmlserializer.startTag(null, "historical-record");
        xmlserializer.attribute(null, "activity", <init>1.activity.flattenToString());
        xmlserializer.attribute(null, "time", String.valueOf(<init>1.time));
        xmlserializer.attribute(null, "weight", String.valueOf(<init>1.weight));
        xmlserializer.endTag(null, "historical-record");
        i++;
        if (true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error writing historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
_L3:
        return;
_L1:
        xmlserializer.endTag(null, "historical-records");
        xmlserializer.endDocument();
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
          goto _L3
        Object obj1;
        obj1;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error writing historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
          goto _L3
        obj1;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error writing historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
          goto _L3
        obj1;
        ActivityChooserModel.access$1100();
        (new StringBuilder()).append("Error writing historical recrod file: ").append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString();
        if (obj == null) goto _L3; else goto _L4
_L4:
        try
        {
            ((FileOutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj1;
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            catch (IOException ioexception) { }
        }
        throw obj1;
    }

    private ()
    {
        this$0 = ActivityChooserModel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
