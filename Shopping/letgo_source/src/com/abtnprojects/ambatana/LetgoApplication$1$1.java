// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.support.v7.aqo;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.SaveCallback;

// Referenced classes of package com.abtnprojects.ambatana:
//            LetgoApplication

class a
    implements SaveCallback
{

    final done a;

    public void done(ParseException parseexception)
    {
        if (parseexception != null)
        {
            aqo.b(parseexception, "Error saving parse installation", new Object[0]);
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/abtnprojects/ambatana/LetgoApplication$1

/* anonymous class */
    class LetgoApplication._cls1
        implements SaveCallback
    {

        final LetgoApplication a;

        public void done(ParseException parseexception)
        {
            if (parseexception != null)
            {
                aqo.b(parseexception, "Error subscribing to parse push", new Object[0]);
            }
            try
            {
                parseexception = ParseInstallation.getCurrentInstallation();
                parseexception.put("GCMSenderId", "914431496661");
                parseexception.saveInBackground(new LetgoApplication._cls1._cls1(this));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ParseException parseexception)
            {
                aqo.b(parseexception, "Error saving current installation", new Object[0]);
            }
        }

        public volatile void done(Throwable throwable)
        {
            done((ParseException)throwable);
        }

            
            {
                a = letgoapplication;
                super();
            }
    }

}
