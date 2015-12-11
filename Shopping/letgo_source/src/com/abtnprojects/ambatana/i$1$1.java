// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.net.Uri;
import android.support.v7.aqo;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

// Referenced classes of package com.abtnprojects.ambatana:
//            i

class a
    implements SaveCallback
{

    final done a;

    public void done(ParseException parseexception)
    {
        if (parseexception != null)
        {
            aqo.b(parseexception, "Error saving profile image", new Object[0]);
            i.a(a.a, 0x7f0900a0);
            return;
        } else
        {
            a.a.a(a.a);
            return;
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

    // Unreferenced inner class com/abtnprojects/ambatana/i$1

/* anonymous class */
    class i._cls1
        implements SaveCallback
    {

        final ParseFile a;
        final Uri b;
        final i c;

        public void done(ParseException parseexception)
        {
            if (parseexception == null)
            {
                i.a(c).put("avatar", a);
                i.a(c).put("processed", Boolean.valueOf(false));
                i.a(c).saveInBackground(new i._cls1._cls1(this));
                return;
            } else
            {
                aqo.b(parseexception, "Error saving profile image", new Object[0]);
                i.b(c, 0x7f0900a0);
                return;
            }
        }

        public volatile void done(Throwable throwable)
        {
            done((ParseException)throwable);
        }

            
            {
                c = j;
                a = parsefile;
                b = uri;
                super();
            }
    }

}
