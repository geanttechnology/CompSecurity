// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.picsart.studio.EditingData;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.controllers.RemoveItemController;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.d;
import com.socialin.android.googleplus.a;
import com.socialin.android.photo.clipart.e;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.aj;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.upload:
//            a, b

final class a
    implements Runnable
{

    private Exception a;
    private oString b;

    public final void run()
    {
        String s;
        if (a != null)
        {
            s = a.getMessage();
        } else
        {
            s = "Unknown error";
        }
        if (b.b != null)
        {
            b.b.a(com.picsart.upload.a.a(b.b), s);
        }
        try
        {
            if (com.picsart.upload.a.d(b.b) != null)
            {
                AnalyticUtils.getInstance(com.picsart.upload.a.d(b.b)).track(new com.socialin.android.apiv3.events.Factory.ExportImageFaileEvent("picsart", "bin"));
            }
            return;
        }
        catch (Exception exception)
        {
            d.b("itemuploader", new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
    }

    a(a a1, Exception exception)
    {
        b = a1;
        a = exception;
        super();
    }

    // Unreferenced inner class com/picsart/upload/a$3

/* anonymous class */
    final class a._cls3
        implements com.socialin.asyncnet.d
    {

        final com.picsart.upload.b a;
        final com.picsart.upload.a b;
        private Handler c;

        public final volatile void onCancelRequest(Object obj, Request request)
        {
        }

        public final void onFailure(Exception exception, Request request)
        {
            c.post(new a._cls3._cls2(this, exception));
        }

        public final transient void onProgressUpdate(Integer ainteger[])
        {
            if (ainteger[0].intValue() != 100)
            {
                Intent intent = new Intent();
                intent.setAction("upload.progress");
                intent.putExtra("progress", ainteger[0]);
                intent.putExtra("id", b.a.j);
                intent.putExtra("path", b.a.b());
                intent.putExtra("title", b.a.c());
                com.picsart.upload.a.d(b).sendBroadcast(intent);
            }
        }

        public final void onSuccess(Object obj, Request request)
        {
            obj = (ImageItem)obj;
            c.post(new a._cls3._cls1(((ImageItem) (obj))));
        }

            
            {
                b = a1;
                c = handler;
                a = b1;
                super();
            }

        // Unreferenced inner class com/picsart/upload/a$3$1

/* anonymous class */
        final class a._cls3._cls1
            implements Runnable
        {

            final ImageItem a;
            private a._cls3 b;

            public final void run()
            {
                if (!a.message.matches("Your photo submitted to #[a-zA-Z]* contest")) goto _L2; else goto _L1
_L1:
                Object obj;
                obj = Pattern.compile("#[a-zA-Z]*").matcher(a.message);
                if (!((Matcher) (obj)).find())
                {
                    break MISSING_BLOCK_LABEL_774;
                }
                obj = ((Matcher) (obj)).group();
_L3:
                Object obj1;
                boolean flag;
                obj1 = EditingData.a(com.picsart.upload.a.c(b.b).getAbsolutePath());
                AnalyticUtils analyticutils;
                if (!TextUtils.isEmpty(((EditingData) (obj1)).b))
                {
                    obj1 = ((EditingData) (obj1)).b;
                } else
                {
                    obj1 = "unknown";
                }
                analyticutils = AnalyticUtils.getInstance(com.picsart.upload.a.d(b.b));
                if (obj == null)
                {
                    obj = null;
                }
                analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ContestSubmitEvent(((String) (obj)), ((String) (obj1)), true));
_L2:
                obj = b.b.a;
                obj1 = String.valueOf(a.id);
                if (((UploadItem) (obj)).g.size() == 9)
                {
                    ((UploadItem) (obj)).g.set(8, obj1);
                } else
                {
                    ((UploadItem) (obj)).g.add(8, obj1);
                }
                obj = b.b.a;
                obj1 = a.url;
                if (((UploadItem) (obj)).g.size() == 10)
                {
                    ((UploadItem) (obj)).g.set(9, obj1);
                } else
                {
                    ((UploadItem) (obj)).g.add(9, obj1);
                }
                if (b.b.a.k == 4 || b.b.c())
                {
                    obj = new RemoveItemController();
                    obj1 = new ParamWithItemId();
                    obj1.itemId = a.id;
                    ((RemoveItemController) (obj)).setRequestParams(((com.socialin.android.apiv3.request.RequestParams) (obj1)));
                    com.socialin.asyncnet.b.a().a(((RemoveItemController) (obj)).getRequestId());
                    ((RemoveItemController) (obj)).doRequest("removeItem", ((ParamWithItemId) (obj1)));
                } else
                if (a.freeToEdit() && "picsart".equals(com.picsart.upload.a.a(b.b)))
                {
                    y.a(com.picsart.upload.a.d(b.b), a, "freetoedit.invite");
                }
                com.picsart.upload.a.e(b.b);
                if (b.a != null)
                {
                    b.a.a(com.picsart.upload.a.a(b.b));
                }
                obj = b.b.a;
                if (com.socialin.android.picsart.upload.UploadItem.Type.STICKER.equals(((UploadItem) (obj)).i))
                {
                    obj = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(b.b.a.e()).toString();
                    if (!(new File(e.a(com.picsart.upload.a.d(b.b), b.b.a.c()))).renameTo(new File(e.c(com.picsart.upload.a.d(b.b), ((String) (obj))))))
                    {
                        (new File(e.a(com.picsart.upload.a.d(b.b), b.b.a.c()))).delete();
                    }
                    if (!(new File(e.b(com.picsart.upload.a.d(b.b), b.b.a.c()))).renameTo(new File(e.d(com.picsart.upload.a.d(b.b), ((String) (obj))))))
                    {
                        (new File(e.b(com.picsart.upload.a.d(b.b), b.b.a.c()))).delete();
                    }
                    com.picsart.upload.a.d(b.b).sendBroadcast(new Intent("picsart.clipart.uploaded.action"));
                }
                try
                {
                    if (com.picsart.upload.a.d(b.b) != null)
                    {
                        AnalyticUtils.getInstance(com.picsart.upload.a.d(b.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("picsart", "bin")).setOwner(true));
                    }
                }
                catch (Exception exception)
                {
                    d.b("itemuploader", new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                    });
                }
                obj = com.picsart.upload.a.d(b.b).getSharedPreferences((new StringBuilder("sinPref_")).append(com.picsart.upload.a.d(b.b).getString(m.e(com.picsart.upload.a.d(b.b), "app_name_short"))).toString(), 0);
                if (obj != null && ((SharedPreferences) (obj)).getBoolean("enable_gp_action_add", false))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    obj = new a(com.picsart.upload.a.d(b.b));
                    obj.b = new a._cls3._cls1._cls1(this, ((a) (obj)));
                    ((a) (obj)).a(true);
                }
                return;
                obj;
                ((Exception) (obj)).printStackTrace();
                obj = null;
                  goto _L3
            }

                    
                    {
                        b = a._cls3.this;
                        a = imageitem;
                        super();
                    }
        }


        // Unreferenced inner class com/picsart/upload/a$3$1$1

/* anonymous class */
        final class a._cls3._cls1._cls1
            implements aj
        {

            private a a;
            private a._cls3._cls1 b;

            public final void a()
            {
                a.a(0, b.a, null);
            }

            public final void b()
            {
            }

                    
                    {
                        b = _pcls1;
                        a = a1;
                        super();
                    }
        }

    }

}
