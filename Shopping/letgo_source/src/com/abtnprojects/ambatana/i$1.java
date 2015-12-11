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

class b
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
            i.a(c).saveInBackground(new SaveCallback() {

                final i._cls1 a;

                public void done(ParseException parseexception1)
                {
                    if (parseexception1 != null)
                    {
                        aqo.b(parseexception1, "Error saving profile image", new Object[0]);
                        i.a(a.c, 0x7f0900a0);
                        return;
                    } else
                    {
                        a.c.a(a.b);
                        return;
                    }
                }

                public volatile void done(Throwable throwable)
                {
                    done((ParseException)throwable);
                }

            
            {
                a = i._cls1.this;
                super();
            }
            });
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

    _cls1.a(i j, ParseFile parsefile, Uri uri)
    {
        c = j;
        a = parsefile;
        b = uri;
        super();
    }
}
