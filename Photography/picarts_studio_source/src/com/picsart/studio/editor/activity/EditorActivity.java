// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.widget.Toast;
import com.picsart.studio.EditingData;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.b;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.fragment.MotionFragment;
import com.picsart.studio.editor.fragment.SquareFitFragment;
import com.picsart.studio.editor.fragment.TiltShiftFragment;
import com.picsart.studio.editor.fragment.aa;
import com.picsart.studio.editor.fragment.d;
import com.picsart.studio.editor.fragment.f;
import com.picsart.studio.editor.fragment.g;
import com.picsart.studio.editor.fragment.h;
import com.picsart.studio.editor.fragment.i;
import com.picsart.studio.editor.fragment.j;
import com.picsart.studio.editor.fragment.k;
import com.picsart.studio.editor.fragment.l;
import com.picsart.studio.editor.fragment.n;
import com.picsart.studio.editor.fragment.p;
import com.picsart.studio.editor.fragment.q;
import com.picsart.studio.editor.fragment.r;
import com.picsart.studio.editor.fragment.s;
import com.picsart.studio.editor.fragment.t;
import com.picsart.studio.editor.fragment.u;
import com.picsart.studio.editor.fragment.v;
import com.picsart.studio.editor.fragment.x;
import com.picsart.studio.editor.fragment.y;
import com.picsart.studio.editor.fragment.z;
import com.picsart.studio.editor.helper.a;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.editor.history.ResizeAction;
import com.picsart.studio.editor.item.CalloutItem;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.photo.callout.SelectCalloutActivity;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.lensflare.SelectLensFlareActivity;
import com.socialin.android.photo.sticker.SelectStickerActivity;
import com.socialin.android.photo.tools.ResizeDialogActivity;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import myobfuscated.f.m;
import org.json.JSONObject;

public class EditorActivity extends BaseActivity
    implements c
{

    private static EditorActivity b;
    public List a;
    private Dialog c;
    private List d;
    private boolean e;
    private TimeCalculator f;
    private boolean g;
    private boolean h;
    private final com.picsart.studio.editor.h i = new com.picsart.studio.editor.h() {

        private EditorActivity a;

        public final void a()
        {
            com.picsart.studio.editor.e.a().a(null, true);
            com.picsart.studio.editor.activity.EditorActivity.a(a, false);
        }

            
            {
                a = EditorActivity.this;
                super();
            }
    };

    public EditorActivity()
    {
        b = this;
    }

    static Bitmap a(EditorActivity editoractivity, String s1, HashMap hashmap)
    {
        return w.a(hashmap, s1, m.d(s1), PicsartContext.a(editoractivity));
    }

    public static EditorActivity a()
    {
        return b;
    }

    static com.picsart.studio.editor.h a(EditorActivity editoractivity)
    {
        return editoractivity.i;
    }

    private void a(Bundle bundle, Runnable runnable)
    {
        Object obj;
        String s1;
label0:
        {
            if (bundle != null)
            {
                obj = bundle.getString("origin", "unknown");
                s1 = bundle.getString("path");
                if (bundle.containsKey("editing_data"))
                {
                    obj = (EditingData)bundle.getParcelable("editing_data");
                } else
                if (!TextUtils.isEmpty(s1) && FileUtils.d(s1) == com.socialin.android.util.FileUtils.ImageFileFormat.JPEG)
                {
                    obj = EditingData.a(s1, ((String) (obj)));
                } else
                {
                    obj = EditingData.a(com.picsart.studio.utils.c.a(this, null), ((String) (obj)));
                }
                if (!bundle.containsKey("project"))
                {
                    break label0;
                }
                bundle = bundle.getString("project");
                com.picsart.studio.editor.e.a().a(bundle);
                runnable.run();
            }
            return;
        }
        if (bundle.containsKey("bitmap.key"))
        {
            int i1 = bundle.getInt("bitmap.key", 0);
            com.picsart.studio.editor.e.a().a(com.picsart.studio.editor.helper.a.a().a(i1), ((EditingData) (obj)), UUID.randomUUID().toString());
            runnable.run();
            return;
        } else
        {
            HashMap hashmap = (HashMap)bundle.getSerializable("bufferData");
            (new ModernAsyncTask(bundle.getString("raw.data"), s1, hashmap, ((EditingData) (obj)), runnable) {

                private String a;
                private String b;
                private HashMap c;
                private EditingData d;
                private Runnable e;
                private EditorActivity f;

                protected final Object doInBackground(Object aobj[])
                {
                    if (a != null)
                    {
                        return w.g(a);
                    } else
                    {
                        return com.picsart.studio.editor.activity.EditorActivity.a(f, b, c);
                    }
                }

                protected final void onPostExecute(Object obj1)
                {
                    obj1 = (Bitmap)obj1;
                    if (obj1 != null)
                    {
                        com.picsart.studio.editor.e.a().a(((Bitmap) (obj1)), d, UUID.randomUUID().toString());
                        e.run();
                    } else
                    {
                        Toast.makeText(f, "Something went wrong", 0).show();
                        f.c();
                    }
                    f.e();
                }

                protected final void onPreExecute()
                {
                    super.onPreExecute();
                    f.d();
                }

            
            {
                f = EditorActivity.this;
                a = s1;
                b = s2;
                c = hashmap;
                d = editingdata;
                e = runnable;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    static void a(EditorActivity editoractivity, int i1, int j1)
    {
        if (editoractivity.a.get(0) instanceof r)
        {
            com.picsart.studio.editor.e.a().b(ResizeAction.create(i1, j1));
        }
    }

    static void a(EditorActivity editoractivity, Bitmap bitmap, String s1, android.graphics.Bitmap.CompressFormat compressformat, String s2)
    {
        (editoractivity. new ModernAsyncTask(s1, bitmap, compressformat, s2) {

            private File a;
            private String b;
            private Bitmap c;
            private android.graphics.Bitmap.CompressFormat d;
            private String e;
            private EditorActivity f;

            protected final Object doInBackground(Object aobj[])
            {
                a = w.a(b.substring(0, b.lastIndexOf("/")), b.substring(b.lastIndexOf("/") + 1), c, f, d, true);
                com.picsart.studio.editor.activity.EditorActivity.d(f).b();
                aobj = com.picsart.studio.editor.e.a().e;
                aobj.i = (int)((long)((EditingData) (aobj)).i + com.picsart.studio.editor.activity.EditorActivity.d(f).d());
                com.picsart.studio.editor.activity.EditorActivity.d(f).a();
                String s3 = b;
                if (SocialinV3.getInstance().isRegistered())
                {
                    aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
                } else
                {
                    aobj = null;
                }
                m.a(s3, ((String) (aobj)), com.picsart.studio.editor.e.a().e.c().toString());
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                super.onPostExecute((Void)obj);
                if (a != null)
                {
                    Utils.a(f, b);
                    com.picsart.studio.editor.activity.EditorActivity.a(f, "savetogallery");
                    com.picsart.studio.editor.activity.EditorActivity.a(f, b, e);
                    com.picsart.studio.editor.activity.EditorActivity.a(f, true);
                } else
                {
                    Utils.a(f, 0x7f0804a0);
                }
                c.recycle();
                f.e();
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                f.d();
            }

            
            {
                f = EditorActivity.this;
                b = s1;
                c = bitmap;
                d = compressformat;
                e = s2;
                super();
                a = null;
            }
        }).execute(new Void[0]);
    }

    static void a(EditorActivity editoractivity, String s1)
    {
        editoractivity.a(s1);
    }

    static void a(EditorActivity editoractivity, String s1, String s2)
    {
        int j1 = 0;
        EditingData editingdata = EditingData.a(s1);
        int i1;
        if (!s1.isEmpty())
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s1, options);
            i1 = options.outHeight;
            j1 = options.outWidth;
        } else
        {
            i1 = 0;
        }
        s1 = "";
        if (s2 == null) goto _L2; else goto _L1
_L1:
        if (!s2.equalsIgnoreCase(".jpeg") && !s2.equalsIgnoreCase(".jpg")) goto _L4; else goto _L3
_L3:
        s1 = "jpg";
_L6:
        AnalyticUtils.trackImageExport(editoractivity, "local", editingdata, s1, i1, j1, com.picsart.studio.utils.c.a(editoractivity, null));
        return;
_L4:
        if (s2.equalsIgnoreCase(".png"))
        {
            s1 = "png";
        } else
        if (s2.equalsIgnoreCase(".gif"))
        {
            s1 = "gif";
        } else
        if (s2.equalsIgnoreCase(".webm"))
        {
            s1 = "webm";
        } else
        if (s2.equalsIgnoreCase(".mp4"))
        {
            s1 = "mp4";
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = "jpg";
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(String s1)
    {
        if (!isFinishing() && g && !a.isEmpty() && a.size() > 0)
        {
            i i1 = (i)a.get(0);
            if (i1 != null)
            {
                if (i1.b)
                {
                    com.socialin.android.picsart.profile.invite.i.a(this, s1);
                }
                i1.c();
            }
        }
    }

    static boolean a(EditorActivity editoractivity, boolean flag)
    {
        editoractivity.h = flag;
        return flag;
    }

    static void b(EditorActivity editoractivity)
    {
        editoractivity.h();
    }

    static void b(EditorActivity editoractivity, String s1)
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 6: default 64
    //                   -1727082830: 135
    //                   11576841: 105
    //                   1111669925: 180
    //                   1293361956: 165
    //                   1318040329: 150
    //                   1391073851: 120;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        byte0;
        JVM INSTR tableswitch 0 5: default 104
    //                   0 195
    //                   1 200
    //                   2 215
    //                   3 244
    //                   4 244
    //                   5 244;
           goto _L8 _L9 _L10 _L11 _L12 _L12 _L12
_L8:
        return;
_L3:
        if (s1.equals("button_ok"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (s1.equals("button_saveSD"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s1.equals("button_uploadToPicsinId"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s1.equals("button_postFB"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s1.equals("button_tweet"))
        {
            byte0 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s1.equals("button_postInstagram"))
        {
            byte0 = 5;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        editoractivity.i();
        return;
_L10:
        AnalyticUtils.getInstance(editoractivity).trackLocalAction("main:cancel_dialog_save");
        editoractivity.f();
        return;
_L11:
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(editoractivity).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("editor_exist_save_screen", "upload_to_pa"));
        }
_L12:
        if (editoractivity.getExternalCacheDir() == null) goto _L8; else goto _L13
_L13:
        (editoractivity. new ModernAsyncTask((new StringBuilder()).append(editoractivity.getExternalCacheDir().getAbsolutePath()).append(File.separator).append(System.currentTimeMillis()).toString(), s1) {

            private String a;
            private String b;
            private EditorActivity c;

            protected final Object doInBackground(Object aobj[])
            {
                com.socialin.android.brushlib.util.b.b(com.picsart.studio.editor.e.a().b, a);
                com.picsart.studio.editor.activity.EditorActivity.d(c).b();
                aobj = com.picsart.studio.editor.e.a().e;
                aobj.i = (int)((long)((EditingData) (aobj)).i + com.picsart.studio.editor.activity.EditorActivity.d(c).d());
                com.picsart.studio.editor.activity.EditorActivity.d(c).a();
                String s2 = a;
                if (SocialinV3.getInstance().isRegistered())
                {
                    aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
                } else
                {
                    aobj = null;
                }
                m.a(s2, ((String) (aobj)), com.picsart.studio.editor.e.a().e.c().toString());
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                byte byte1;
                super.onPostExecute((Void)obj);
                obj = b;
                byte1 = -1;
                ((String) (obj)).hashCode();
                JVM INSTR lookupswitch 4: default 60
            //                           -1727082830: 151
            //                           1111669925: 109
            //                           1293361956: 137
            //                           1318040329: 123;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                byte1;
                JVM INSTR tableswitch 0 3: default 92
            //                           0 165
            //                           1 180
            //                           2 194
            //                           3 208;
                   goto _L6 _L7 _L8 _L9 _L10
_L6:
                com.picsart.studio.editor.activity.EditorActivity.a(c, true);
                c.e();
                return;
_L3:
                if (((String) (obj)).equals("button_postInstagram"))
                {
                    byte1 = 0;
                }
                  goto _L1
_L5:
                if (((String) (obj)).equals("button_postFB"))
                {
                    byte1 = 1;
                }
                  goto _L1
_L4:
                if (((String) (obj)).equals("button_tweet"))
                {
                    byte1 = 2;
                }
                  goto _L1
_L2:
                if (((String) (obj)).equals("button_uploadToPicsinId"))
                {
                    byte1 = 3;
                }
                  goto _L1
_L7:
                myobfuscated.cv.c.a(c, a);
                  goto _L6
_L8:
                FacebookUtils.startAdapterActivity(c, a);
                  goto _L6
_L9:
                myobfuscated.cv.c.a(a, c);
                  goto _L6
_L10:
                myobfuscated.cv.c.a(c, a);
                  goto _L6
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                c.d();
            }

            
            {
                c = EditorActivity.this;
                a = s1;
                b = s2;
                super();
            }
        }).execute(new Void[0]);
        return;
        if (true) goto _L1; else goto _L14
_L14:
    }

    private static boolean b(Tool tool)
    {
        final class _cls6
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[RequestCode.values().length];
                try
                {
                    b[RequestCode.SELECT_TEXT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    b[RequestCode.SELECT_CALLOUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    b[RequestCode.SELECT_LENS_FLARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    b[RequestCode.SELECT_CLIPART.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    b[RequestCode.SELECT_PHOTO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    b[RequestCode.SELECT_FRAME.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    b[RequestCode.SELECT_STICKER.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    b[RequestCode.OPEN_RESIZE_DIALOG.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    b[RequestCode.SHARE_PHOTO.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    b[RequestCode.SAVE_PHOTO.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    b[RequestCode.CLOSE_CONFIRM.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                a = new int[Tool.values().length];
                try
                {
                    a[Tool.VIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    a[Tool.EFFECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    a[Tool.SQUARE_FIT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[Tool.MASK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[Tool.DRAW.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[Tool.TEXT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[Tool.CALLOUT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[Tool.LENS_FLARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[Tool.CLIPART.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[Tool.PHOTO.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[Tool.STICKER.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[Tool.FRAME.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[Tool.FRAME_PHOTO.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[Tool.SHAPE_MASK.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[Tool.BORDER.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[Tool.CROP.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[Tool.FREE_CROP.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[Tool.SHAPE_CROP.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[Tool.SELECTION.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[Tool.CLONE.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[Tool.MOTION.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[Tool.STRETCH.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[Tool.CURVES.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[Tool.ADJUST.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[Tool.ENHANCE.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[Tool.TILT_SHIFT.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[Tool.RESIZE.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Tool.TRANSFORM.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Tool.PERSPECTIVE.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Tool.GIFEXPORT.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }

            private class RequestCode extends Enum
            {

                private static final RequestCode $VALUES[];
                public static final RequestCode CLOSE_CONFIRM;
                public static final RequestCode EDIT_CALLOUT;
                public static final RequestCode EDIT_TEXT;
                public static final RequestCode OPEN_RESIZE_DIALOG;
                public static final RequestCode SAVE_PHOTO;
                public static final RequestCode SELECT_CALLOUT;
                public static final RequestCode SELECT_CLIPART;
                public static final RequestCode SELECT_FRAME;
                public static final RequestCode SELECT_LENS_FLARE;
                public static final RequestCode SELECT_PHOTO;
                public static final RequestCode SELECT_STICKER;
                public static final RequestCode SELECT_TEXT;
                public static final RequestCode SHARE_PHOTO;

                public static RequestCode fromInt(int i1)
                {
                    RequestCode arequestcode[] = values();
                    if (i1 < 0 || i1 >= arequestcode.length)
                    {
                        return null;
                    } else
                    {
                        return values()[i1];
                    }
                }

                public static RequestCode valueOf(String s1)
                {
                    return (RequestCode)Enum.valueOf(com/picsart/studio/editor/activity/EditorActivity$RequestCode, s1);
                }

                public static RequestCode[] values()
                {
                    return (RequestCode[])$VALUES.clone();
                }

                public final int toInt()
                {
                    return ordinal();
                }

                static 
                {
                    SELECT_CLIPART = new RequestCode("SELECT_CLIPART", 0);
                    SELECT_STICKER = new RequestCode("SELECT_STICKER", 1);
                    SELECT_TEXT = new RequestCode("SELECT_TEXT", 2);
                    EDIT_TEXT = new RequestCode("EDIT_TEXT", 3);
                    SELECT_CALLOUT = new RequestCode("SELECT_CALLOUT", 4);
                    SELECT_LENS_FLARE = new RequestCode("SELECT_LENS_FLARE", 5);
                    SELECT_PHOTO = new RequestCode("SELECT_PHOTO", 6);
                    SAVE_PHOTO = new RequestCode("SAVE_PHOTO", 7);
                    EDIT_CALLOUT = new RequestCode("EDIT_CALLOUT", 8);
                    OPEN_RESIZE_DIALOG = new RequestCode("OPEN_RESIZE_DIALOG", 9);
                    CLOSE_CONFIRM = new RequestCode("CLOSE_CONFIRM", 10);
                    SELECT_FRAME = new RequestCode("SELECT_FRAME", 11);
                    SHARE_PHOTO = new RequestCode("SHARE_PHOTO", 12);
                    $VALUES = (new RequestCode[] {
                        SELECT_CLIPART, SELECT_STICKER, SELECT_TEXT, EDIT_TEXT, SELECT_CALLOUT, SELECT_LENS_FLARE, SELECT_PHOTO, SAVE_PHOTO, EDIT_CALLOUT, OPEN_RESIZE_DIALOG, 
                        CLOSE_CONFIRM, SELECT_FRAME, SHARE_PHOTO
                    });
                }

                private RequestCode(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        }

        switch (com.picsart.studio.editor.activity._cls6.a[tool.ordinal()])
        {
        default:
            return false;

        case 4: // '\004'
        case 5: // '\005'
        case 19: // '\023'
            return true;
        }
    }

    static boolean c(EditorActivity editoractivity)
    {
        return editoractivity.e;
    }

    static TimeCalculator d(EditorActivity editoractivity)
    {
        return editoractivity.f;
    }

    static boolean e(EditorActivity editoractivity)
    {
        return editoractivity.g;
    }

    static EditorActivity g()
    {
        return b;
    }

    private void h()
    {
        b();
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        d.clear();
    }

    private void i()
    {
        Object obj = getIntent().getExtras();
        if (obj != null)
        {
            Object obj1 = (HashMap)((Bundle) (obj)).getSerializable("bufferData");
            obj = ((Bundle) (obj)).getString("path");
            if (obj == null)
            {
                if (obj1 != null)
                {
                    obj = (String)((HashMap) (obj1)).get("path");
                } else
                {
                    obj = "";
                }
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && com.picsart.studio.editor.e.a().b() && !com.picsart.studio.editor.e.a().c.a())
            {
                obj1 = new File(((String) (obj)));
                obj = new File(((File) (obj1)).getParentFile(), (new StringBuilder("orig_w")).append(com.picsart.studio.editor.e.a().b.getWidth()).append("_h").append(com.picsart.studio.editor.e.a().b.getHeight()).toString());
                if (((File) (obj1)).renameTo(((File) (obj))))
                {
                    obj1 = com.picsart.studio.editor.e.a().c();
                    w.a(((File) (obj)).getAbsolutePath(), ((Bitmap) (obj1)));
                    ((Bitmap) (obj1)).recycle();
                }
            }
        }
        com.picsart.studio.editor.b.a();
        com.picsart.studio.editor.e.a().d();
        a("close");
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("is_editor_active", false).apply();
        finish();
    }

    public final void a(Fragment fragment)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/sticker/SelectStickerActivity);
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_STICKER.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_STICKER.toInt());
            return;
        }
    }

    public final void a(Fragment fragment, int i1)
    {
        Intent intent = new Intent(this, com/picsart/studio/ImagePickerActivity);
        intent.putExtra("fromDrawing", false);
        intent.putExtra("showCameraEffects", false);
        i1 = PicsartContext.a.getAddPhotoMaxCount() - i1;
        if (i1 <= 0)
        {
            Toast.makeText(this, getString(0x7f080402), 0).show();
            return;
        }
        intent.putExtra("from", "collage");
        intent.putExtra("multipleCheckMode", true);
        intent.putExtra("itemsCount", i1);
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_PHOTO.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_PHOTO.toInt());
            return;
        }
    }

    public final void a(Fragment fragment, CalloutItem calloutitem)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/callout/SelectCalloutActivity);
        if (calloutitem == null)
        {
            intent.putExtra("callout", com.socialin.android.photo.callout.a.a);
            if (fragment != null)
            {
                startActivityFromFragment(fragment, intent, RequestCode.SELECT_CALLOUT.toInt());
                return;
            } else
            {
                startActivityForResult(intent, RequestCode.SELECT_CALLOUT.toInt());
                return;
            }
        }
        intent.putExtra("currentText", calloutitem.e);
        intent.putExtra("callout", calloutitem.f);
        intent.putExtra("currentCalloutStyleIndex", calloutitem.g);
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.EDIT_CALLOUT.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.EDIT_CALLOUT.toInt());
            return;
        }
    }

    public final void a(Fragment fragment, TextItem textitem)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "textart");
        if (textitem != null)
        {
            intent.putExtra("action", "edit");
            intent.putExtra("style", textitem.a);
            intent.putExtra("text", textitem.b);
            if (fragment != null)
            {
                startActivityFromFragment(fragment, intent, RequestCode.EDIT_TEXT.toInt());
                return;
            } else
            {
                startActivityForResult(intent, RequestCode.EDIT_TEXT.toInt());
                return;
            }
        }
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_TEXT.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_TEXT.toInt());
            return;
        }
    }

    public final void a(Tool tool)
    {
        if (com.picsart.studio.editor.e.a().b() && !isFinishing() && g)
        {
            Bundle bundle = new Bundle(1);
            bundle.putString("source", "editor");
            Bitmap bitmap;
            if (b(tool))
            {
                bitmap = com.picsart.studio.editor.e.a().c();
            } else
            {
                bitmap = com.picsart.studio.editor.e.a().b;
            }
            a(tool, ((c) (this)), bitmap, bundle, true);
        }
    }

    public final void a(Tool tool, c c1, Bitmap bitmap, Bundle bundle, boolean flag)
    {
        if (tool == null || isFinishing() || !g) goto _L2; else goto _L1
_L1:
        com.picsart.studio.editor.activity._cls6.a[tool.ordinal()];
        JVM INSTR tableswitch 1 30: default 160
    //                   1 239
    //                   2 250
    //                   3 261
    //                   4 272
    //                   5 283
    //                   6 294
    //                   7 315
    //                   8 336
    //                   9 357
    //                   10 378
    //                   11 399
    //                   12 410
    //                   13 421
    //                   14 432
    //                   15 453
    //                   16 469
    //                   17 480
    //                   18 491
    //                   19 512
    //                   20 523
    //                   21 534
    //                   22 545
    //                   23 556
    //                   24 567
    //                   25 583
    //                   26 594
    //                   27 605
    //                   28 667
    //                   29 678
    //                   30 689;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33
_L3:
        tool = null;
_L36:
        if (tool == null) goto _L2; else goto _L34
_L34:
        try
        {
            tool.a(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Tool tool)
        {
            tool = new com.socialin.android.dialog.b();
            tool.b = getString(0x7f08094c);
            tool.h = false;
            tool.a().show(getFragmentManager(), null);
            System.gc();
            return;
        }
        tool.a(c1);
        if (bundle != null)
        {
            tool.setArguments(bundle);
        }
        c1 = getFragmentManager().beginTransaction();
        bitmap = tool.h();
        if (tool.f())
        {
            if (flag)
            {
                c1.replace(0x7f10013a, tool, bitmap);
            } else
            {
                c1.add(0x7f10013a, tool, bitmap);
            }
        } else
        {
            c1.add(tool, bitmap);
        }
        c1.commit();
        a.add(tool);
_L2:
        return;
_L4:
        tool = new r();
        continue; /* Loop/switch isn't completed */
_L5:
        tool = new j();
        continue; /* Loop/switch isn't completed */
_L6:
        tool = new SquareFitFragment();
        continue; /* Loop/switch isn't completed */
_L7:
        tool = new s();
        continue; /* Loop/switch isn't completed */
_L8:
        tool = new h();
        continue; /* Loop/switch isn't completed */
_L9:
        tool = new q();
        ((q)tool).d = RequestCode.SELECT_TEXT;
        continue; /* Loop/switch isn't completed */
_L10:
        tool = new q();
        ((q)tool).d = RequestCode.SELECT_CALLOUT;
        continue; /* Loop/switch isn't completed */
_L11:
        tool = new q();
        ((q)tool).d = RequestCode.SELECT_LENS_FLARE;
        continue; /* Loop/switch isn't completed */
_L12:
        tool = new q();
        ((q)tool).d = RequestCode.SELECT_CLIPART;
        continue; /* Loop/switch isn't completed */
_L13:
        tool = new q();
        ((q)tool).d = RequestCode.SELECT_PHOTO;
        continue; /* Loop/switch isn't completed */
_L14:
        tool = new x();
        continue; /* Loop/switch isn't completed */
_L15:
        tool = new l();
        continue; /* Loop/switch isn't completed */
_L16:
        tool = new z();
        continue; /* Loop/switch isn't completed */
_L17:
        tool = new v();
        ((v)tool).c = com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK;
        continue; /* Loop/switch isn't completed */
_L18:
        tool = new d();
        tool.setRetainInstance(true);
        continue; /* Loop/switch isn't completed */
_L19:
        tool = new f();
        continue; /* Loop/switch isn't completed */
_L20:
        tool = new n();
        continue; /* Loop/switch isn't completed */
_L21:
        tool = new v();
        ((v)tool).c = com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP;
        continue; /* Loop/switch isn't completed */
_L22:
        tool = new u();
        continue; /* Loop/switch isn't completed */
_L23:
        tool = new com.picsart.studio.editor.fragment.e();
        continue; /* Loop/switch isn't completed */
_L24:
        tool = new MotionFragment();
        continue; /* Loop/switch isn't completed */
_L25:
        tool = new y();
        continue; /* Loop/switch isn't completed */
_L26:
        tool = new g();
        continue; /* Loop/switch isn't completed */
_L27:
        tool = new com.picsart.studio.editor.fragment.b();
        tool.setRetainInstance(true);
        continue; /* Loop/switch isn't completed */
_L28:
        tool = new k();
        continue; /* Loop/switch isn't completed */
_L29:
        tool = new TiltShiftFragment();
        continue; /* Loop/switch isn't completed */
_L30:
        tool = new Intent(this, com/socialin/android/photo/tools/ResizeDialogActivity);
        tool.putExtra("width", com.picsart.studio.editor.e.a().b.getWidth());
        tool.putExtra("height", com.picsart.studio.editor.e.a().b.getHeight());
        startActivityForResult(tool, RequestCode.OPEN_RESIZE_DIALOG.toInt());
        tool = null;
        continue; /* Loop/switch isn't completed */
_L31:
        tool = new aa();
        continue; /* Loop/switch isn't completed */
_L32:
        tool = new t();
        continue; /* Loop/switch isn't completed */
_L33:
        tool = new p();
        if (true) goto _L36; else goto _L35
_L35:
        tool;
        tool.printStackTrace();
        return;
    }

    public final void a(i i1)
    {
        getFragmentManager().beginTransaction().remove(i1).commit();
        a(Tool.VIEW);
        if (com.picsart.studio.editor.e.a().b())
        {
            com.picsart.studio.editor.e.a().d.clearTmpDirectory();
        }
    }

    public final void a(i i1, Bitmap bitmap, EditorAction editoraction)
    {
        if (com.picsart.studio.editor.e.a().b())
        {
            com.picsart.studio.editor.e.a().a(bitmap);
            com.picsart.studio.editor.e.a().a(editoraction);
        } else
        {
            d.add(new Runnable(bitmap, editoraction) {

                private Bitmap a;
                private EditorAction b;

                public final void run()
                {
                    com.picsart.studio.editor.e.a().a(a);
                    com.picsart.studio.editor.e.a().a(b);
                }

            
            {
                a = bitmap;
                b = editoraction;
                super();
            }
            });
        }
        getFragmentManager().beginTransaction().remove(i1).commit();
        a(Tool.VIEW);
        com.picsart.studio.editor.e.a().d.clearTmpDirectory();
    }

    public final void a(Runnable runnable)
    {
        if (com.picsart.studio.editor.e.a().b())
        {
            runnable.run();
            return;
        } else
        {
            d.add(runnable);
            return;
        }
    }

    public final void b()
    {
        Iterator iterator = a.iterator();
        while (iterator.hasNext()) 
        {
            i i1 = (i)iterator.next();
            Bitmap bitmap;
            if (b(i1.e()))
            {
                bitmap = com.picsart.studio.editor.e.a().c();
            } else
            {
                bitmap = com.picsart.studio.editor.e.a().b;
            }
            i1.a(bitmap);
        }
    }

    public final void b(Fragment fragment)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "clipart");
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_CLIPART.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_CLIPART.toInt());
            return;
        }
    }

    public final void c()
    {
        if (com.picsart.studio.editor.e.a().b() && !com.picsart.studio.editor.e.a().c.a())
        {
            if (!h)
            {
                startActivityForResult(new Intent(this, com/socialin/android/dialog/CancelDialogActivity), RequestCode.CLOSE_CONFIRM.toInt());
                return;
            } else
            {
                i();
                return;
            }
        } else
        {
            i();
            return;
        }
    }

    public final void c(Fragment fragment)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/lensflare/SelectLensFlareActivity);
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_LENS_FLARE.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_LENS_FLARE.toInt());
            return;
        }
    }

    public final void d()
    {
        if (!isFinishing() && g)
        {
            c.show();
        }
    }

    public final void d(Fragment fragment)
    {
        Intent intent = new Intent(this, com/socialin/android/photo/clipart/SelectClipArtFrameActivity);
        intent.putExtra("category", "frame");
        if (fragment != null)
        {
            startActivityFromFragment(fragment, intent, RequestCode.SELECT_FRAME.toInt());
            return;
        } else
        {
            startActivityForResult(intent, RequestCode.SELECT_FRAME.toInt());
            return;
        }
    }

    public final void e()
    {
        if (!isFinishing() && g)
        {
            c.dismiss();
        }
    }

    public final void f()
    {
        Intent intent = new Intent(this, com/socialin/android/activity/SaveToSdCardDialogActivity);
        intent.putExtra("subFolderName", getString(0x7f0808fb));
        intent.putExtra("isReturnResult", true);
        startActivityForResult(intent, RequestCode.SAVE_PHOTO.toInt());
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        RequestCode requestcode = RequestCode.fromInt(i1);
        if (i1 == 1123 && a.get(0) != null)
        {
            ((i)a.get(0)).b = false;
        }
        if (i1 == 1124 && j1 == -1 && a.get(0) != null)
        {
            ((i)a.get(0)).g();
        }
        if (j1 == -1 && requestcode != null)
        {
            if (intent == null)
            {
                intent = null;
            } else
            {
                intent = intent.getExtras();
            }
            a(new Runnable(intent, requestcode) {

                private Bundle a;
                private RequestCode b;
                private EditorActivity c;

                public final void run()
                {
                    if (a == null) goto _L2; else goto _L1
_L1:
                    a.putString("source", "editor");
                    com.picsart.studio.editor.activity._cls6.b[b.ordinal()];
                    JVM INSTR tableswitch 1 11: default 88
                //                               1 89
                //                               2 115
                //                               3 141
                //                               4 167
                //                               5 193
                //                               6 256
                //                               7 282
                //                               8 308
                //                               9 364
                //                               10 364
                //                               11 457;
                       goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L12
_L2:
                    return;
_L3:
                    c.a(Tool.TEXT, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L4:
                    c.a(Tool.CALLOUT, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L5:
                    c.a(Tool.LENS_FLARE, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L6:
                    c.a(Tool.CLIPART, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L7:
                    c.a(Tool.PHOTO, c, com.picsart.studio.editor.e.a().b, a, true);
                    com.socialin.android.picsart.profile.invite.i.a(c.getApplicationContext()).edit().remove("invite_new_user_redeem_dialog_stop").apply();
                    com.socialin.android.picsart.profile.invite.i.a(c, 2000L);
                    return;
_L8:
                    c.a(Tool.FRAME, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L9:
                    c.a(Tool.STICKER, c, com.picsart.studio.editor.e.a().b, a, true);
                    return;
_L10:
                    AnalyticUtils.getInstance(c).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_resize"));
                    com.picsart.studio.editor.e.a().e.c("resize");
                    com.picsart.studio.editor.activity.EditorActivity.a(c, a.getInt("width"), a.getInt("height"));
                    return;
_L11:
                    String s1 = a.getString("dstPath");
                    android.graphics.Bitmap.CompressFormat compressformat1 = (android.graphics.Bitmap.CompressFormat)a.getSerializable("format");
                    String s2 = a.getString("fileExtension", "");
                    android.graphics.Bitmap.CompressFormat compressformat = compressformat1;
                    if (compressformat1 == null)
                    {
                        if (".jpg".equals(s2))
                        {
                            compressformat = android.graphics.Bitmap.CompressFormat.JPEG;
                        } else
                        {
                            compressformat = compressformat1;
                            if (".png".equals(s2))
                            {
                                compressformat = android.graphics.Bitmap.CompressFormat.PNG;
                            }
                        }
                    }
                    com.picsart.studio.editor.activity.EditorActivity.a(c, com.picsart.studio.editor.e.a().c(), s1, compressformat, s2);
                    return;
_L12:
                    com.picsart.studio.editor.activity.EditorActivity.b(c, a.getString("button"));
                    return;
                }

            
            {
                c = EditorActivity.this;
                a = bundle;
                b = requestcode;
                super();
            }
            });
        }
        if (j1 == 0 && requestcode != null && requestcode == RequestCode.SELECT_PHOTO)
        {
            a(new Runnable() {

                private EditorActivity a;

                public final void run()
                {
                    com.socialin.android.picsart.profile.invite.i.a(a.getApplicationContext()).edit().remove("invite_new_user_redeem_dialog_stop").apply();
                    com.socialin.android.picsart.profile.invite.i.a(a, 0L);
                }

            
            {
                a = EditorActivity.this;
                super();
            }
            });
        }
    }

    public void onBackPressed()
    {
        if (a.size() == 1 && (a.get(0) instanceof r))
        {
            c();
            return;
        } else
        {
            ((i)a.get(a.size() - 1)).d();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = true;
        f = new TimeCalculator();
        d = new ArrayList(1);
        a = new ArrayList(1);
        AnalyticUtils.getInstance(this);
        setContentView(0x7f03001f);
        c = new AppCompatDialog(this, 0x7f0c0184);
        c.setContentView(0x7f0300a6);
        c.setCancelable(false);
        c.setCanceledOnTouchOutside(false);
        if (bundle != null) goto _L2; else goto _L1
_L1:
        a(Tool.VIEW, this, ((Bitmap) (null)), ((Bundle) (null)), true);
_L5:
        a(getIntent().getExtras(), new Runnable() {

            private EditorActivity a;

            public final void run()
            {
                com.picsart.studio.editor.activity.EditorActivity.b(a);
                a.e();
                if ("action.photo.for.collage".equals(a.getIntent().getAction()))
                {
                    a.a(null, 0);
                }
            }

            
            {
                a = EditorActivity.this;
                super();
            }
        });
_L3:
        a(new Runnable() {

            private EditorActivity a;

            public final void run()
            {
                if (com.picsart.studio.editor.e.a().b())
                {
                    com.picsart.studio.editor.e.a().c.a(com.picsart.studio.editor.activity.EditorActivity.a(a));
                }
            }

            
            {
                a = EditorActivity.this;
                super();
            }
        });
        return;
_L2:
        h = bundle.getBoolean("savedAfterLastChange");
        String as[] = bundle.getStringArray("fragmentTags");
        if (as != null)
        {
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                Object obj = as[i1];
                obj = (i)getFragmentManager().findFragmentByTag(((String) (obj)));
                ((i) (obj)).a(this);
                a.add(obj);
            }

        }
        if (!com.picsart.studio.editor.e.a().b())
        {
            continue; /* Loop/switch isn't completed */
        }
        h();
          goto _L3
        if (!bundle.containsKey("projectDirectory")) goto _L5; else goto _L4
_L4:
        (new ModernAsyncTask(bundle.getString("projectDirectory")) {

            private String a;
            private EditorActivity b;

            protected final Object doInBackground(Object aobj[])
            {
                com.picsart.studio.editor.e.a().a(a);
                return null;
            }

            protected final void onPostExecute(Object obj1)
            {
                super.onPostExecute((Void)obj1);
                b.e();
                com.picsart.studio.editor.activity.EditorActivity.b(b);
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                b.d();
            }

            
            {
                b = EditorActivity.this;
                a = s1;
                super();
            }
        }).execute(new Void[0]);
          goto _L3
        if (true) goto _L5; else goto _L6
_L6:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.picsart.studio.editor.e.a().a(new Runnable() {

            private EditorActivity a;

            public final void run()
            {
                if (!com.picsart.studio.editor.activity.EditorActivity.c(a) && a == com.picsart.studio.editor.activity.EditorActivity.g())
                {
                    com.picsart.studio.editor.e.a().d();
                }
            }

            
            {
                a = EditorActivity.this;
                super();
            }
        }, false);
        a.clear();
        if (c != null)
        {
            c.dismiss();
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        com.picsart.studio.editor.e.a().d();
        a(Tool.VIEW, this, ((Bitmap) (null)), ((Bundle) (null)), true);
        a(intent.getExtras(), new Runnable() {

            private EditorActivity a;

            public final void run()
            {
                a.b();
                a.e();
                if ("action.photo.for.collage".equals(a.getIntent().getAction()))
                {
                    a.a(null, 0);
                }
            }

            
            {
                a = EditorActivity.this;
                super();
            }
        });
    }

    protected void onPause()
    {
        super.onPause();
        f.b();
        if (com.picsart.studio.editor.e.a().b())
        {
            com.picsart.studio.editor.e.a().c.b(i);
            EditingData editingdata = com.picsart.studio.editor.e.a().e;
            editingdata.i = (int)((long)editingdata.i + f.d());
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (com.picsart.studio.editor.e.a().b())
        {
            com.picsart.studio.editor.e.a().c.a(i);
        }
        com.socialin.android.picsart.profile.invite.i.a(this).edit().putBoolean("is_editor_active", true).apply();
        f.a();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        String as[] = new String[a.size()];
        for (int i1 = 0; i1 < a.size(); i1++)
        {
            as[i1] = ((i)a.get(i1)).getTag();
        }

        bundle.putStringArray("fragmentTags", as);
        if (com.picsart.studio.editor.e.a().b())
        {
            bundle.putString("projectDirectory", com.picsart.studio.editor.e.a().d.getDirectory());
        }
        bundle.putBoolean("savedAfterLastChange", h);
        e = true;
    }

    protected void onStart()
    {
        super.onStart();
        g = true;
    }

    protected void onStop()
    {
        super.onStop();
        if (isFinishing())
        {
            g = false;
        }
    }

    // Unreferenced inner class com/picsart/studio/editor/activity/EditorActivity$12

/* anonymous class */
    public final class _cls12 extends ModernAsyncTask
    {

        private EditorActivity a;

        protected final Object doInBackground(Object aobj[])
        {
            aobj = null;
            Object obj = null;
            if (com.picsart.studio.editor.e.a().b())
            {
                String s1 = (new StringBuilder()).append(com.picsart.studio.editor.e.a().d.getTmpDirectory()).append(File.separator).append(UUID.randomUUID()).append(".jpg").toString();
                com.socialin.android.brushlib.util.b.b(com.picsart.studio.editor.e.a().c(), s1);
                com.picsart.studio.editor.activity.EditorActivity.d(a).b();
                aobj = com.picsart.studio.editor.e.a().e;
                aobj.i = (int)((long)((EditingData) (aobj)).i + com.picsart.studio.editor.activity.EditorActivity.d(a).d());
                com.picsart.studio.editor.activity.EditorActivity.d(a).a();
                aobj = obj;
                if (SocialinV3.getInstance().isRegistered())
                {
                    aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
                }
                m.a(s1, ((String) (aobj)), com.picsart.studio.editor.e.a().e.c().toString());
                aobj = s1;
            }
            return ((Object) (aobj));
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (String)obj;
            super.onPostExecute(obj);
            if (obj != null && com.picsart.studio.editor.e.a().b() && !a.isFinishing() && com.picsart.studio.editor.activity.EditorActivity.e(a))
            {
                myobfuscated.cv.c.a(a, RequestCode.SHARE_PHOTO.toInt(), true, ((String) (obj)), com.picsart.studio.editor.e.a().b.getWidth(), com.picsart.studio.editor.e.a().b.getHeight(), "editor", "share_to_pa");
                a.overridePendingTransition(0x7f040026, 0x7f040027);
            }
            com.picsart.studio.editor.activity.EditorActivity.a(a, true);
            a.e();
            com.picsart.studio.editor.activity.EditorActivity.a(a, "export");
        }

        protected final void onPreExecute()
        {
            super.onPreExecute();
            a.d();
        }

            public 
            {
                a = EditorActivity.this;
                super();
            }
    }

}
