// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.github.kevinsawicki.http.HttpRequest;
import com.picsart.studio.EditingData;
import com.picsart.studio.ItemType;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddPhotoController;
import com.socialin.android.apiv3.controllers.RemoveItemController;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.request.UploadParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.deviantart.b;
import com.socialin.android.dropbox.DropboxUploadRemote;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.clipart.e;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.twitter.TwitterPostRemote;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.aj;
import com.socialin.android.util.an;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import io.branch.referral.g;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import myobfuscated.cy.d;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.upload:
//            b, UploadService, c

public final class a
    implements android.os.Handler.Callback
{

    UploadItem a;
    HandlerThread b;
    Handler c;
    String d;
    boolean e;
    AddPhotoController f;
    private Context g;
    private com.picsart.upload.b h;
    private boolean i;
    private File j;
    private int k;
    private File l;
    private boolean m;

    private a()
    {
        h = new com.picsart.upload.b(this, (byte)0);
        i = false;
        e = false;
        j = null;
        k = hashCode();
        l = null;
        m = false;
    }

    public static a a(UploadItem uploaditem, Context context)
    {
        a a1 = new a();
        a1.a = uploaditem;
        a1.g = context;
        return a1;
    }

    static String a(a a1)
    {
        return a1.d;
    }

    static void a(a a1, int i1)
    {
        a1.a(i1);
    }

    static void a(a a1, com.picsart.upload.b b1, String s1)
    {
        String s2;
        if (a1.l != null && a1.l.exists())
        {
            s2 = a1.l.getAbsolutePath();
        } else
        {
            s2 = a1.j.getAbsolutePath();
        }
        s1 = new TwitterPostRemote(s2, a1.a.c(), s1, a1.g);
        s1.setTwitterSessionListener(a1. new aj(b1) {

            final com.picsart.upload.b a;
            final a b;

            public final void a()
            {
                b.c.post(new Runnable(this) {

                    private _cls7 a;

                    public final void run()
                    {
                        a.a.a("twitter");
                        try
                        {
                            if (com.picsart.upload.a.d(a.b) != null)
                            {
                                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("twitter", "url")).setPicsArtPlus(true));
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            com.socialin.android.d.b("itemuploader", new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                        }
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
            }

            public final void b()
            {
                b.c.post(new Runnable(this) {

                    private _cls7 a;

                    public final void run()
                    {
                        a.a.a("twitter", "");
                        try
                        {
                            if (com.picsart.upload.a.d(a.b) != null)
                            {
                                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("twitter", "url")).setPicsArtPlus(true));
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            com.socialin.android.d.b("itemuploader", new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                        }
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
            }

            
            {
                b = a.this;
                a = b1;
                super();
            }
        });
        s1.doTwitterPost();
    }

    static void a(a a1, String s1)
    {
        a1.a.g(s1);
        a1.h();
    }

    private void a(com.picsart.upload.b b1)
    {
        UploadParams uploadparams;
        boolean flag;
label0:
        {
            flag = true;
            if (!"picsart".equals(d) || !a.i() || !TextUtils.isEmpty(a.e()))
            {
                if (!"picsart.resized".equals(d))
                {
                    break label0;
                }
                boolean flag1;
                if (l != null)
                {
                    flag1 = l.exists();
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    break label0;
                }
            }
            b1.a(d, "");
            return;
        }
        Handler handler = new Handler();
        uploadparams = new UploadParams();
        uploadparams.apiKey = (String)a.g.get(6);
        uploadparams.title = a.c();
        uploadparams.desc = (String)a.g.get(2);
        uploadparams.tags = a.d();
        int i1;
        if (a.f[8] > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        uploadparams.isMature = i1;
        if (a.f[7] > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        uploadparams.isPublic = i1;
        if ("picsart".equals(d))
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        uploadparams.isOriginal = i1;
        if (TextUtils.isEmpty(a.e())) goto _L2; else goto _L1
_L1:
        uploadparams.id = a.e();
_L4:
        uploadparams.imagePath = j.getAbsolutePath();
_L5:
        uploadparams.timestamp = (String)a.g.get(5);
        uploadparams.location = a.h;
        uploadparams.type = String.valueOf(a.i.toString()).toLowerCase(Locale.ENGLISH);
        f = new AddPhotoController();
        f.setRequestParams(uploadparams);
        f.setRequestCompleteListener(new com.socialin.asyncnet.d(handler, b1) {

            final com.picsart.upload.b a;
            final a b;
            private Handler c;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                c.post(new Runnable(this, exception) {

                    private Exception a;
                    private _cls3 b;

                    public final void run()
                    {
                        String s1;
                        if (a != null)
                        {
                            s1 = a.getMessage();
                        } else
                        {
                            s1 = "Unknown error";
                        }
                        if (b.a != null)
                        {
                            b.a.a(a.a(b.b), s1);
                        }
                        try
                        {
                            if (com.picsart.upload.a.d(b.b) != null)
                            {
                                AnalyticUtils.getInstance(com.picsart.upload.a.d(b.b)).track(new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("picsart", "bin"));
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            com.socialin.android.d.b("itemuploader", new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                        }
                    }

            
            {
                b = _pcls3;
                a = exception;
                super();
            }
                });
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
                c.post(new Runnable(this, ((ImageItem) (obj))) {

                    final ImageItem a;
                    private _cls3 b;

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
                        if (a.freeToEdit() && "picsart".equals(a.a(b.b)))
                        {
                            y.a(com.picsart.upload.a.d(b.b), a, "freetoedit.invite");
                        }
                        com.picsart.upload.a.e(b.b);
                        if (b.a != null)
                        {
                            b.a.a(a.a(b.b));
                        }
                        obj = b.b.a;
                        if (com.socialin.android.picsart.upload.UploadItem.Type.STICKER.equals(((UploadItem) (obj)).i))
                        {
                            obj = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(b.b.a.e()).toString();
                            if (!(new File(com.socialin.android.photo.clipart.e.a(com.picsart.upload.a.d(b.b), b.b.a.c()))).renameTo(new File(com.socialin.android.photo.clipart.e.c(com.picsart.upload.a.d(b.b), ((String) (obj))))))
                            {
                                (new File(com.socialin.android.photo.clipart.e.a(com.picsart.upload.a.d(b.b), b.b.a.c()))).delete();
                            }
                            if (!(new File(com.socialin.android.photo.clipart.e.b(com.picsart.upload.a.d(b.b), b.b.a.c()))).renameTo(new File(com.socialin.android.photo.clipart.e.d(com.picsart.upload.a.d(b.b), ((String) (obj))))))
                            {
                                (new File(com.socialin.android.photo.clipart.e.b(com.picsart.upload.a.d(b.b), b.b.a.c()))).delete();
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
                            com.socialin.android.d.b("itemuploader", new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                        }
                        obj = com.picsart.upload.a.d(b.b).getSharedPreferences((new StringBuilder("sinPref_")).append(com.picsart.upload.a.d(b.b).getString(myobfuscated.f.m.e(com.picsart.upload.a.d(b.b), "app_name_short"))).toString(), 0);
                        if (obj != null && ((SharedPreferences) (obj)).getBoolean("enable_gp_action_add", false))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            obj = new com.socialin.android.googleplus.a(com.picsart.upload.a.d(b.b));
                            obj.b = new aj(this, ((com.socialin.android.googleplus.a) (obj))) {

                                private com.socialin.android.googleplus.a a;
                                private _cls1 b;

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
                            };
                            ((com.socialin.android.googleplus.a) (obj)).a(true);
                        }
                        return;
                        obj;
                        ((Exception) (obj)).printStackTrace();
                        obj = null;
                          goto _L3
                    }

            
            {
                b = _pcls3;
                a = imageitem;
                super();
            }
                });
            }

            
            {
                b = a.this;
                c = handler;
                a = b1;
                super();
            }
        });
        if (a.k != 4 && !c())
        {
            Utils.b(k);
            f.doRequest();
            return;
        } else
        {
            a("picsart.upload.delete", String.valueOf(a.j));
            b.quit();
            return;
        }
_L2:
        if (l == null) goto _L4; else goto _L3
_L3:
        uploadparams.imagePath = l.getAbsolutePath();
          goto _L5
    }

    private void a(String s1)
    {
        if (!"picsart".equals(s1)) goto _L2; else goto _L1
_L1:
        a(h);
_L4:
        return;
_L2:
        String s3;
        Object obj;
        b b1;
        Object obj1;
        if ("facebook".equals(s1))
        {
            s1 = h;
            String s4 = (String)a.g.get(7);
            String s2 = (new StringBuilder("http://picsart.com/i/")).append(a.e()).toString();
            if (s4 == null || TextUtils.isEmpty(s4) || s4.equals("invalid"))
            {
                s1.a("facebook", "");
                return;
            } else
            {
                com.socialin.android.facebook.util.a a1 = new com.socialin.android.facebook.util.a();
                a1.a = new aj(s1) {

                    final com.picsart.upload.b a;
                    final a b;

                    public final void a()
                    {
                        b.c.post(new Runnable(this) {

                            private _cls4 a;

                            public final void run()
                            {
                                a.a.a("facebook");
                                try
                                {
                                    if (com.picsart.upload.a.d(a.b) != null)
                                    {
                                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("facebook", "bin")).setPicsArtPlus(true));
                                    }
                                    return;
                                }
                                catch (Exception exception)
                                {
                                    com.socialin.android.d.b("itemuploader", new Object[] {
                                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                    });
                                }
                            }

            
            {
                a = _pcls4;
                super();
            }
                        });
                    }

                    public final void b()
                    {
                        b.c.post(new Runnable(this) {

                            private _cls4 a;

                            public final void run()
                            {
                                a.a.a("facebook", "");
                                try
                                {
                                    if (com.picsart.upload.a.d(a.b) != null)
                                    {
                                        AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("facebook", "bin")).setPicsArtPlus(true));
                                    }
                                    return;
                                }
                                catch (Exception exception)
                                {
                                    com.socialin.android.d.b("itemuploader", new Object[] {
                                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                    });
                                }
                            }

            
            {
                a = _pcls4;
                super();
            }
                        });
                    }

            
            {
                b = a.this;
                a = b1;
                super();
            }
                };
                myobfuscated.cy.d.a(g, "facebook", "photo_share_facebook", Long.parseLong(a.e()), new g(a1, s2) {

                    private com.socialin.android.facebook.util.a a;
                    private String b;
                    private a c;

                    public final void a(String s5, io.branch.referral.m m1)
                    {
                        Object obj2;
                        String s6;
                        String s7;
                        int i1;
                        int j1;
                        if (!TextUtils.isEmpty(c.a.c()))
                        {
                            m1 = (new StringBuilder()).append(c.a.c()).append("\n").toString();
                        } else
                        {
                            m1 = "";
                        }
                        obj2 = (new StringBuilder()).append(m1).append(com.picsart.upload.a.d(c).getString(0x7f0805f3)).append(" #PicsArt").toString();
                        m1 = ((io.branch.referral.m) (obj2));
                        if (!TextUtils.isEmpty(s5))
                        {
                            m1 = (new StringBuilder()).append(((String) (obj2))).append("\n").append(s5).toString();
                        }
                        obj2 = a;
                        s5 = c.a.h;
                        s6 = c.a.f();
                        s7 = b;
                        i1 = c.a.l;
                        j1 = c.a.m;
                        if (!FacebookUtils.isSessionValid())
                        {
                            if (((com.socialin.android.facebook.util.a) (obj2)).a != null)
                            {
                                ((com.socialin.android.facebook.util.a) (obj2)).a.b();
                            }
                            return;
                        }
                        if (s5 != null)
                        {
                            s5 = ((Adress) (s5)).venueId;
                        } else
                        {
                            s5 = null;
                        }
                        FacebookUtils.postStoryAddPhoto(s6, s7, m1, null, i1, j1, s5, ((com.socialin.android.facebook.util.a) (obj2)).b);
                    }

            
            {
                c = a.this;
                a = a2;
                b = s1;
                super();
            }
                });
                return;
            }
        }
        if ("twitter".equals(s1))
        {
            s1 = h;
            myobfuscated.cy.d.a(g, "twitter", "photo_share_twitter", Long.parseLong(a.e()), new g(s1) {

                final com.picsart.upload.b a;
                final a b;

                public final void a(String s5, io.branch.referral.m m1)
                {
                    if (TextUtils.isEmpty(s5))
                    {
                        if (b.a.e() != null)
                        {
                            s5 = (new StringBuilder("http://picsart.com/i/")).append(b.a.e()).toString();
                        } else
                        {
                            s5 = null;
                        }
                    }
                    (new an(this, s5) {

                        private String a;
                        private _cls6 b;

                        protected final Object doInBackground(Object aobj[])
                        {
                            a.a(b.b, b.a, a);
                            return Boolean.valueOf(true);
                        }

            
            {
                b = _pcls6;
                a = s1;
                super();
            }
                    }).a(new Void[0]);
                }

            
            {
                b = a.this;
                a = b1;
                super();
            }
            });
            return;
        }
        if ("dropbox".equals(s1))
        {
            s1 = h;
            DropboxUploadRemote dropboxuploadremote = new DropboxUploadRemote(g, j.getAbsolutePath());
            dropboxuploadremote.setDropboxSessionListener(new aj(s1) {

                final com.picsart.upload.b a;
                final a b;

                public final void a()
                {
                    b.c.post(new Runnable(this) {

                        private _cls8 a;

                        public final void run()
                        {
                            a.a.a("dropbox");
                            try
                            {
                                if (com.picsart.upload.a.d(a.b) != null)
                                {
                                    AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("dropbox", "bin")).setPicsArtPlus(true));
                                }
                                return;
                            }
                            catch (Exception exception)
                            {
                                com.socialin.android.d.b("itemuploader", new Object[] {
                                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                });
                            }
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                }

                public final void b()
                {
                    b.c.post(new Runnable(this) {

                        private _cls8 a;

                        public final void run()
                        {
                            a.a.a("dropbox", "");
                            try
                            {
                                if (com.picsart.upload.a.d(a.b) != null)
                                {
                                    AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("dropbox", "bin")).setPicsArtPlus(true));
                                }
                                return;
                            }
                            catch (Exception exception)
                            {
                                com.socialin.android.d.b("itemuploader", new Object[] {
                                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                                });
                            }
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                }

            
            {
                b = a.this;
                a = b1;
                super();
            }
            });
            dropboxuploadremote.doDropboxUpload();
            return;
        }
        if (!"deviantart".equals(s1))
        {
            break MISSING_BLOCK_LABEL_707;
        }
        obj = h;
        if (TextUtils.isEmpty(a.c()))
        {
            s1 = (new StringBuilder()).append(g.getString(0x7f0808af)).append(".com").toString();
        } else
        {
            s1 = a.c();
        }
        if (TextUtils.isEmpty(a.d()))
        {
            s3 = "";
        } else
        {
            s3 = a.d();
        }
        b1 = new b(g);
        b1.c = new aj(((com.picsart.upload.b) (obj))) {

            final com.picsart.upload.b a;
            final a b;

            public final void a()
            {
                b.c.post(new Runnable(this) {

                    private _cls9 a;

                    public final void run()
                    {
                        a.a.a("deviantart");
                        try
                        {
                            if (com.picsart.upload.a.d(a.b) != null)
                            {
                                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("devianart", "bin")).setPicsArtPlus(true));
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            return;
                        }
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            public final void b()
            {
                b.c.post(new Runnable(this) {

                    private _cls9 a;

                    public final void run()
                    {
                        a.a.a("deviantart", "");
                        try
                        {
                            if (com.picsart.upload.a.d(a.b) != null)
                            {
                                AnalyticUtils.getInstance(com.picsart.upload.a.d(a.b)).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageFaileEvent("deviantart", "bin")).setPicsArtPlus(true));
                            }
                            return;
                        }
                        catch (Exception exception)
                        {
                            com.socialin.android.d.a("upload", exception);
                        }
                    }

            
            {
                a = _pcls9;
                super();
            }
                });
            }

            
            {
                b = a.this;
                a = b1;
                super();
            }
        };
        obj = j.getAbsolutePath();
        obj1 = a.e();
        if (!b1.b())
        {
            b1.a();
            return;
        }
        File file = new File(((String) (obj)));
        obj = b1.d.getString(0x7f08041e);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = (new StringBuilder()).append(b1.d.getString(0x7f080409)).append(" http://picsart.com/i/").append(((String) (obj1))).toString();
        }
        obj1 = HttpRequest.a("https://www.deviantart.com/api/draft15/stash/submit");
        ((HttpRequest) (obj1)).a("file", file.getName(), "image/*", file);
        ((HttpRequest) (obj1)).b("access_token", b1.b.getString("oauth2AccessToken", null));
        ((HttpRequest) (obj1)).b("title", s1);
        ((HttpRequest) (obj1)).b("artist_comments", ((String) (obj)));
        ((HttpRequest) (obj1)).b("keywords", s3);
        ((HttpRequest) (obj1)).b("folder", "PicsArt");
        if (!((HttpRequest) (obj1)).c())
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = ((HttpRequest) (obj1)).e();
        try
        {
            s1 = new JSONObject(s1);
            com.socialin.android.d.b(b.a, new Object[] {
                (new StringBuilder(" submit to Sta.sh response :::::::::: ")).append(s1.toString()).toString()
            });
            if ("success".equals(s1.getString("status")))
            {
                if (b1.c != null)
                {
                    b1.c.a();
                    return;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            try
            {
                com.socialin.android.d.b(b.a, "uploadCallback", s1);
                b1.a();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.socialin.android.d.b(b.a, "doDeviantartUpload", s1);
            }
            b1.a();
            return;
        }
        b1.a();
        return;
        if ("tumblr".equals(s1))
        {
            s1 = h;
            myobfuscated.cy.d.a(g, "tumblr", "photo_share_tumblr", Long.parseLong(a.e()), new g(s1) {

                private com.picsart.upload.b a;
                private a b;

                public final void a(String s5, io.branch.referral.m m1)
                {
label0:
                    {
                        if (TextUtils.isEmpty(s5))
                        {
                            m1 = new StringBuilder("http://picsart.com/i/");
                            if (b.a.e() != null)
                            {
                                s5 = b.a.e();
                            } else
                            {
                                s5 = "";
                            }
                            s5 = m1.append(s5).toString();
                        }
                        s5 = (new com.socialin.android.tumblr.b(com.picsart.upload.a.d(b))).a(b.a.f(), b.a.c(), b.a.d(), s5, b.a.l, b.a.m);
                        if (a != null)
                        {
                            if (s5 == null || !s5.contains("id"))
                            {
                                break label0;
                            }
                            a.a("tumblr");
                        }
                        return;
                    }
                    a.a("tumblr", s5);
                }

            
            {
                b = a.this;
                a = b1;
                super();
            }
            });
            return;
        }
        if ("picsart.resized".equals(s1))
        {
            a(h);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(String s1, String s2)
    {
        Intent intent = new Intent(g, com/picsart/upload/UploadService);
        intent.setAction(s1);
        if (s2 != null)
        {
            intent.putExtra("extra.message", s2);
        }
        g.startService(intent);
    }

    private void b(int i1)
    {
        a(i1);
        h();
        a("picsart.upload.check", ((String) (null)));
        b.quit();
    }

    static void b(a a1)
    {
        a1.f();
    }

    static void b(a a1, String s1)
    {
        a1.a(s1, ((String) (null)));
    }

    static File c(a a1)
    {
        return a1.j;
    }

    static void c(a a1, String s1)
    {
        a1.a.f(s1);
        a1.h();
    }

    static Context d(a a1)
    {
        return a1.g;
    }

    static void e(a a1)
    {
        String s1;
        EditingData editingdata;
        editingdata = EditingData.a(a1.j.getAbsolutePath(), null);
        s1 = "unknown";
        final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.socialin.android.util.FileUtils.ImageFileFormat.values().length];
                try
                {
                    a[com.socialin.android.util.FileUtils.ImageFileFormat.PNG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.socialin.android.util.FileUtils.ImageFileFormat.JPEG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.socialin.android.util.FileUtils.ImageFileFormat.GIF.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[FileUtils.d(a1.j.getAbsolutePath()).ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 145
    //                   2 153
    //                   3 161;
           goto _L1 _L2 _L3 _L4
_L1:
        int i1;
        long l2;
        i1 = -1;
        l2 = Utils.c(a1.k);
        int j1 = Integer.parseInt(String.valueOf(l2));
        i1 = j1;
_L6:
        JSONArray jsonarray;
        String as[] = a1.a.d().split(",");
        jsonarray = new JSONArray();
        int l1 = as.length;
        for (int k1 = 0; k1 < l1; k1++)
        {
            jsonarray.put(as[k1]);
        }

        break; /* Loop/switch isn't completed */
_L2:
        s1 = "png";
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = "jpg";
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = "gif";
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.socialin.android.d.b("itemuploader", "trackExport: convert uploadDuration to Long", exception);
        if (true) goto _L6; else goto _L5
_L5:
        double d1;
        double d2;
label0:
        {
            double d3 = editingdata.n;
            double d4 = editingdata.m;
            if (d3 != -1D)
            {
                d2 = d3;
                d1 = d4;
                if (d4 != -1D)
                {
                    break label0;
                }
            }
            Location location = com.picsart.studio.utils.c.a(a1.g, null);
            d2 = d3;
            d1 = d4;
            if (location != null)
            {
                d2 = location.getLatitude();
                d1 = location.getLongitude();
            }
        }
        String s3 = a1.a.e();
        if (TextUtils.isEmpty(s3))
        {
            s3 = "-1";
        }
        AnalyticUtils.getInstance(a1.g).track(new com.socialin.android.apiv3.events.EventsFactory.PhotoUploadEvent(editingdata, Long.parseLong(s3), "", a1.a.c(), jsonarray, a1.a.m, a1.a.l, i1, "picsart", s1, d2, d1));
        if (a1.a.i() && "picsart.resized".equals(a1.d))
        {
            String s2 = a1.j.getAbsolutePath();
            if (SocialinV3.getInstance().isRegistered())
            {
                a1 = String.valueOf(SocialinV3.getInstance().getUser().id);
            } else
            {
                a1 = null;
            }
            myobfuscated.f.m.a(s2, a1, editingdata.c().toString());
        }
        return;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void f()
    {
        if (b != null && b.isAlive())
        {
            b.quit();
        }
        try
        {
            (new StringBuilder("starting itemuploader item: ")).append(a.h().toString(4));
        }
        catch (JSONException jsonexception)
        {
            com.socialin.android.d.b("itemuploader", new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(jsonexception.getMessage()).toString()
            });
        }
        b = new HandlerThread((new StringBuilder("item_uploader_thread_")).append(System.currentTimeMillis()).toString());
        b.start();
        b.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            private a a;

            public final void uncaughtException(Thread thread, Throwable throwable)
            {
                throwable.printStackTrace();
                a.a(a, a.a(a));
                if (a.a.j() || a.a.k())
                {
                    a.a(a, a.a.k);
                    com.picsart.upload.a.b(a, "picsart.upload.check");
                    return;
                } else
                {
                    com.picsart.upload.a.b(a);
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        c = new Handler(b.getLooper(), this);
        if (m)
        {
            c.sendEmptyMessage(2);
            return;
        } else
        {
            c.sendEmptyMessage(1);
            return;
        }
    }

    static void f(a a1)
    {
        a1.g();
    }

    private void g()
    {
_L3:
        if (m)
        {
            if (a.d(d))
            {
                a(d);
            } else
            if (a.k())
            {
                b(3);
            } else
            {
                b(2);
                return;
            }
        }
        if (c())
        {
            a(4);
            b.quit();
            return;
        }
        if (a.l())
        {
            byte byte0;
            if (a.k())
            {
                byte0 = 3;
            } else
            {
                byte0 = 2;
            }
            b(byte0);
            return;
        }
        boolean flag;
        if (!FileUtils.a())
        {
            flag = false;
        } else
        {
            SharedPreferences sharedpreferences = g.getSharedPreferences("socialin", 0);
            if (!s.a(g) || !s.b(g) && sharedpreferences.getBoolean("wifi_only_upload", false))
            {
                flag = false;
            } else
            {
                flag = true;
            }
        }
        if (!flag)
        {
            c.sendEmptyMessageDelayed(1, 60000L);
            return;
        }
        if (!j.exists())
        {
            a(2);
            a("picsart.upload.delete", String.valueOf(a.j));
            b.quit();
            return;
        }
_L5:
        List list;
        if (a.i())
        {
            list = Arrays.asList(UploadItem.c);
        } else
        {
            list = Arrays.asList(UploadItem.b);
        }
        if (d != null) goto _L2; else goto _L1
_L1:
        d = (String)list.get(0);
_L4:
        if (a.d(d))
        {
            (new StringBuilder("uploadToNextNetwork: ")).append(d);
            a.d = d;
            h();
            a(d);
            return;
        }
          goto _L3
_L2:
        int j1 = list.indexOf(d) + 1;
        int i1 = j1;
        if (j1 >= list.size())
        {
            i1 = 0;
        }
        d = (String)list.get(i1);
        if (d.equals("facebook") && TextUtils.isEmpty(a.e())) goto _L5; else goto _L4
    }

    static void g(a a1)
    {
        a1.h();
    }

    private void h()
    {
        g.getContentResolver().update(c.a, a.a(), (new StringBuilder("_id=")).append(a.j).toString(), null);
    }

    final void a(int i1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (i1 != 1)
        {
            flag = false;
        }
        i = flag;
        a.k = i1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = i;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a(File file, File file1, boolean flag)
    {
        m = flag;
        if (a() || e())
        {
            return false;
        } else
        {
            j = file;
            l = file1;
            a(1);
            f();
            return true;
        }
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        e = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = a.k;
        boolean flag;
        if (i1 == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.k();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 30
    //                   2 37;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        g();
        continue; /* Loop/switch isn't completed */
_L3:
        a(d);
        if (true) goto _L1; else goto _L4
_L4:
    }
}
