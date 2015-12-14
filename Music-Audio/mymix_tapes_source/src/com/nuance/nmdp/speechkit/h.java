// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import cv;
import java.util.LinkedList;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            GenericRecognition

final class h
    implements bf
{
    static final class a
        implements GenericRecognition
    {

        private final boolean a;
        private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary b;
        private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary c = null;

        public final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getAppserverResult()
        {
            return c;
        }

        public final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary getFullResult()
        {
            return b;
        }

        public final boolean isFinalResult()
        {
            return a;
        }

        a(com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary)
        {
            PdxValue pdxvalue;
            b = dictionary;
            pdxvalue = dictionary.get("appserver_results");
            if (pdxvalue == null || pdxvalue.getType() != 2) goto _L2; else goto _L1
_L1:
            boolean flag;
            c = (com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary)pdxvalue;
            if (dictionary == null)
            {
                dictionary = null;
            } else
            {
                dictionary = c.get("final_response");
            }
            if (dictionary == null || dictionary.getType() != 1 || ((com.nuance.nmdp.speechkit.util.pdx.PdxValue.Integer)dictionary).get() != 0) goto _L4; else goto _L3
_L3:
            flag = false;
_L6:
            a = flag;
            return;
_L2:
_L4:
            flag = true;
            if (true) goto _L6; else goto _L5
_L5:
        }
    }


    private LinkedList a;
    private boolean b;

    h()
    {
        a = new LinkedList();
        b = false;
    }

    private boolean a(cv cv1)
    {
        cv1 = new a(com.nuance.nmdp.speechkit.recognitionresult.b.a(cv1));
        boolean flag;
        if (!cv1.isFinalResult())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            b = flag;
            a.add(cv1);
        }
        // Misplaced declaration of an exception variable
        catch (cv cv1)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Error parsing result");
            return false;
        }
        return true;
    }

    public final boolean a()
    {
        return b;
    }

    public final volatile boolean a(Object obj)
    {
        return a((cv)obj);
    }

    public final Object b()
    {
        if (!a.isEmpty())
        {
            return (GenericRecognition)a.remove();
        } else
        {
            return null;
        }
    }
}
