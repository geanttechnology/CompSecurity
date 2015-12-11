// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.e;
import android.support.v7.aqo;
import android.support.v7.cu;
import android.support.v7.fl;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.abtnprojects.ambatana:
//            d

public class i extends fl
{

    private final ParseUser e;

    public i(e e1, ViewSwitcher viewswitcher, ImageView imageview, ParseUser parseuser)
    {
        super(e1, viewswitcher, imageview);
        e = parseuser;
    }

    static ParseUser a(i j)
    {
        return j.e;
    }

    static void a(i j, int k)
    {
        j.a(k);
    }

    static void b(i j, int k)
    {
        j.a(k);
    }

    public Void a(cu cu1)
    {
        cu1 = (d)cu1.e();
        Object obj;
        String s;
        if (cu1 == null)
        {
            obj = null;
        } else
        {
            obj = ((d) (cu1)).a;
        }
        if (cu1 == null)
        {
            cu1 = null;
        } else
        {
            cu1 = ((d) (cu1)).b;
        }
        s = (new StringBuilder()).append(e.getObjectId()).append(".jpg").toString();
        if (obj == null)
        {
            obj = null;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, bytearrayoutputstream);
            obj = bytearrayoutputstream.toByteArray();
        }
        if (obj != null)
        {
            obj = new ParseFile(s, ((byte []) (obj)));
            ((ParseFile) (obj)).saveInBackground(new SaveCallback(((ParseFile) (obj)), cu1) {

                final ParseFile a;
                final Uri b;
                final i c;

                public void done(ParseException parseexception)
                {
                    if (parseexception == null)
                    {
                        i.a(c).put("avatar", a);
                        i.a(c).put("processed", Boolean.valueOf(false));
                        i.a(c).saveInBackground(new SaveCallback(this) {

                            final _cls1 a;

                            public void done(ParseException parseexception)
                            {
                                if (parseexception != null)
                                {
                                    aqo.b(parseexception, "Error saving profile image", new Object[0]);
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
                a = _pcls1;
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

            
            {
                c = i.this;
                a = parsefile;
                b = uri;
                super();
            }
            });
            return null;
        } else
        {
            aqo.d("imageData is null", new Object[0]);
            a(0x7f0900a0);
            return null;
        }
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }
}
