// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            cw, cy

final class cg
{

    private static final String p = com/flurry/android/cg.getSimpleName();

    private cg()
    {
    }

    public static List a(DataInput datainput)
        throws IOException
    {
        if (46586 != datainput.readUnsignedShort())
        {
            throw new IOException("Unexpected data format");
        } else
        {
            return b(datainput);
        }
    }

    public static void a(List list, DataOutput dataoutput)
        throws IOException
    {
        Iterator iterator;
        dataoutput.writeShort(46586);
        iterator = list.iterator();
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        list = (cw)iterator.next();
        dataoutput.writeShort(1);
        list.a(dataoutput);
        if (true) goto _L2; else goto _L1
        IOException ioexception;
        ioexception;
        cy.a(3, p, (new StringBuilder()).append("unable to write adLog with GUID: ").append(list.aA()).toString(), ioexception);
_L1:
        dataoutput.writeShort(0);
        return;
    }

    private static List b(DataInput datainput)
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            if (1 != datainput.readUnsignedShort())
            {
                return arraylist;
            }
            try
            {
                arraylist.add(new cw(datainput));
            }
            // Misplaced declaration of an exception variable
            catch (DataInput datainput)
            {
                cy.a(3, p, "unable to read adLog: ", datainput);
                return arraylist;
            }
        } while (true);
    }

}
