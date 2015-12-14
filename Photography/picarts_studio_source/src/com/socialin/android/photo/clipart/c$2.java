// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.view.View;
import android.widget.GridView;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.net.a;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cb.c;

// Referenced classes of package com.socialin.android.photo.clipart:
//            c, e

final class a
    implements d
{

    private GridView a;
    private com.socialin.android.photo.clipart.c b;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        if (c.b(b) != null && !c.b(b).isFinishing() && c.l(b).size() == 0)
        {
            a.setVisibility(8);
            b.e(0x7f1007e7).setVisibility(8);
            b.e(0x7f1007e5).setVisibility(0);
        }
        if (!"Specified stream doesn't exist".equals(exception.getMessage()) && b.isAdded())
        {
            Utils.b(c.b(b), b.getString(0x7f0805cb));
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
label0:
        {
            obj = (Stream)obj;
            if (b.isVisible() && b.a == com.socialin.android.photo.clipart.c.a(b))
            {
                com.socialin.android.photo.clipart.c.a(b, ((Stream) (obj)).items);
                if (c.b(b) != null && !c.b(b).isFinishing())
                {
                    String s;
                    for (obj = com.socialin.android.photo.clipart.c.c(b).iterator(); ((Iterator) (obj)).hasNext(); b.m.a(request.getLargeUrl(), com.socialin.android.photo.clipart.e.a(c.i(b), s), null, null, false))
                    {
                        request = (ImageItem)((Iterator) (obj)).next();
                        s = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(String.valueOf(((ImageItem) (request)).id)).toString();
                        if (com.socialin.android.photo.clipart.c.d(b) == null)
                        {
                            c.e(b);
                        }
                        Iterator iterator = com.socialin.android.photo.clipart.c.d(b).iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            c c1 = (c)iterator.next();
                            if (c1.d.substring(c1.d.lastIndexOf("/") + 1).equals(((ImageItem) (request)).title))
                            {
                                File file = new File(e.b(c.f(b), ((ImageItem) (request)).title));
                                if (!file.renameTo(new File(e.b(c.g(b), s))) && !file.delete())
                                {
                                    com.socialin.android.photo.clipart.c.a();
                                    (new StringBuilder("clipart icon is not deleted: ")).append(file.getAbsolutePath());
                                }
                                file = new File(com.socialin.android.photo.clipart.e.a(c.h(b), ((ImageItem) (request)).title));
                                if (!file.renameTo(new File(com.socialin.android.photo.clipart.e.a(c.i(b), s))) && !file.delete())
                                {
                                    com.socialin.android.photo.clipart.c.a();
                                    (new StringBuilder("clipart is not deleted: ")).append(file.getAbsolutePath());
                                }
                                iterator.remove();
                            }
                        } while (true);
                        if (c.j(b) != null)
                        {
                            Iterator iterator1 = c.j(b).iterator();
                            do
                            {
                                if (!iterator1.hasNext())
                                {
                                    break;
                                }
                                c c2 = (c)iterator1.next();
                                if (c2.d.substring(c2.d.lastIndexOf("/") + 1).equals(s))
                                {
                                    iterator1.remove();
                                }
                            } while (true);
                        }
                        b.m.a(request.getSmallUrl(), e.b(c.g(b), s), null, null, false);
                    }

                    c.k(b);
                    if (c.l(b).size() <= 0)
                    {
                        break label0;
                    }
                    b.e(0x7f1007e7).setVisibility(8);
                    a.setVisibility(0);
                    a.setChoiceMode(3);
                    if (a.getAdapter() == null)
                    {
                        a.setAdapter(b.k);
                    }
                    c.b(b).invalidateOptionsMenu();
                }
            }
            return;
        }
        a.setVisibility(8);
        b.e(0x7f1007e7).setVisibility(8);
        b.e(0x7f1007e5).setVisibility(0);
    }

    nstants(com.socialin.android.photo.clipart.c c1, GridView gridview)
    {
        b = c1;
        a = gridview;
        super();
    }
}
