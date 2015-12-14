// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddPhotoController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateItemParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.s;
import java.util.Map;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            as

public class p extends Fragment
{

    private static final String h = com/socialin/android/picsart/profile/fragment/p.getSimpleName();
    private static final String i = (new StringBuilder()).append(h).append(" - ").toString();
    AddPhotoController a;
    BaseSocialinApiRequestController b;
    UpdateItemParams c;
    String d;
    int e;
    int f;
    com.socialin.asyncnet.d g;
    private as j;
    private Map k;
    private g l;
    private boolean m;
    private int n;
    private String o;
    private String p;
    private ImageItem q;
    private android.view.View.OnClickListener r;
    private android.view.View.OnClickListener s;
    private a t;
    private com.socialin.android.dialog.c u;

    public p()
    {
        a = new AddPhotoController();
        b = RequestControllerFactory.createUpdateItemController();
        c = new UpdateItemParams();
        k = null;
        m = true;
        n = 0;
        e = 0;
        p = "picsart";
        r = new _cls1();
        g = new _cls4();
        s = new _cls5();
        u = new _cls6();
    }

    public static Bundle a(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSubmitAvailable", flag);
        return bundle;
    }

    static ImageItem a(p p1)
    {
        return p1.q;
    }

    static void a(p p1, String s1, ImageItem imageitem)
    {
        p1.a(s1, imageitem);
    }

    static void a(p p1, String s1, ImageItem imageitem, int i1)
    {
        String s2 = s1.substring(s1.lastIndexOf("."), s1.length());
        Object obj;
        Object obj1;
        String as1[];
        EditingData editingdata;
        int l1;
        boolean flag;
        long l2;
        if (s2 != null)
        {
            if (s2.equalsIgnoreCase(".jpeg") || s2.equalsIgnoreCase(".jpg"))
            {
                s2 = "jpg";
            } else
            if (s2.equalsIgnoreCase(".png"))
            {
                s2 = "png";
            } else
            if (s2.equalsIgnoreCase(".gif"))
            {
                s2 = "gif";
            } else
            {
                s2 = "jpg";
            }
        } else
        {
            s2 = "jpg";
        }
        editingdata = EditingData.a(s1);
        flag = false;
        l1 = 0;
        l2 = -1L;
        as1 = null;
        obj1 = new JSONArray();
        int k1;
        if (imageitem != null)
        {
            as1 = imageitem.tags;
            if (as1 != null && as1.length > 0)
            {
                int i2 = as1.length;
                int j1 = 0;
                do
                {
                    obj = obj1;
                    if (j1 >= i2)
                    {
                        break;
                    }
                    ((JSONArray) (obj1)).put(as1[j1]);
                    j1++;
                } while (true);
            } else
            {
                obj = null;
            }
            l2 = imageitem.id;
            imageitem = imageitem.title;
        } else
        {
            obj = obj1;
            imageitem = as1;
        }
        k1 = ((flag) ? 1 : 0);
        if (!s1.isEmpty())
        {
            obj1 = new android.graphics.BitmapFactory.Options();
            obj1.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s1, ((android.graphics.BitmapFactory.Options) (obj1)));
            k1 = ((android.graphics.BitmapFactory.Options) (obj1)).outHeight;
            l1 = ((android.graphics.BitmapFactory.Options) (obj1)).outWidth;
        }
        s1 = com.picsart.studio.utils.c.a(p1.getActivity(), null);
        AnalyticUtils.trackImageExport(p1.getActivity(), "picsart", editingdata, s2, k1, l1, s1, l2, imageitem, ((JSONArray) (obj)), i1);
    }

    private void a(String s1, ImageItem imageitem)
    {
        try
        {
            o = s1;
            q = imageitem;
            s1 = new f(getActivity());
            s1.a = null;
            s1.b = null;
            s1.e = 0x7f0301f5;
            s1.g = false;
            s1 = s1.a(getString(0x7f08006d), r).a();
            imageitem = (TextView)s1.findViewById(0x7f1008f7);
            _cls8 _lcls8 = new _cls8();
            SpannableString spannablestring = new SpannableString((new StringBuilder(" ")).append(getString(0x7f0800fb)).toString());
            spannablestring.setSpan(_lcls8, 0, spannablestring.length(), 17);
            imageitem.setMovementMethod(LinkMovementMethod.getInstance());
            imageitem.setText(spannablestring);
            imageitem.setPadding(0, 50, 0, 50);
            s1.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        if (d.b)
        {
            com.socialin.android.d.b(h, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
            });
            return;
        } else
        {
            ExceptionReportService.report(getActivity(), s1, SocialinV3.getInstance().getUser().id);
            return;
        }
    }

    static String b(p p1)
    {
        return p1.o;
    }

    static g c(p p1)
    {
        return p1.l;
    }

    static String d()
    {
        return i;
    }

    static void d(p p1)
    {
        if (p1.t == null)
        {
            b b1 = (new b()).a(1, 0x7f0c0181);
            b1.f = 0x7f0300a5;
            b1.e = 0x7f0205bd;
            b1.a = p1.getString(0x7f0800fb);
            b1.h = false;
            b1 = b1.a(p1.getString(0x7f080311));
            b1.g = true;
            p1.t = b1.a();
            p1.t.a(p1.u);
        }
        p1.t.show(p1.getActivity().getFragmentManager(), "contest_rules_confirm_dialog");
    }

    static int e(p p1)
    {
        return p1.f;
    }

    static String e()
    {
        return h;
    }

    static String f(p p1)
    {
        return p1.d;
    }

    static String g(p p1)
    {
        return p1.p;
    }

    static as h(p p1)
    {
        return p1.j;
    }

    static String i(p p1)
    {
        p1.o = null;
        return null;
    }

    static ImageItem j(p p1)
    {
        p1.q = null;
        return null;
    }

    static Map k(p p1)
    {
        return p1.k;
    }

    public final void a()
    {
        Activity activity = getActivity();
        g g1 = l;
        boolean flag;
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DialogUtils.showDialog(activity, g1, flag);
    }

    public final void b()
    {
        Activity activity = getActivity();
        g g1 = l;
        boolean flag;
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DialogUtils.dismissDialog(activity, g1, flag);
    }

    final void b(boolean flag)
    {
        Object obj = (TextView)getView().findViewById(0x7f10090b);
        int i1 = SocialinV3.getInstance().getAppProps().getData().getSubmissionLimit();
        SpannableString spannablestring = new SpannableString(String.valueOf(i1));
        spannablestring.setSpan(new StyleSpan(1), 0, spannablestring.length(), 17);
        SpannableString spannablestring1 = new SpannableString(String.valueOf(e));
        spannablestring1.setSpan(new StyleSpan(1), 0, spannablestring1.length(), 17);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(new SpannableString((new StringBuilder()).append(getString(0x7f0800ed)).append(" ").toString()));
        spannablestringbuilder.append(spannablestring);
        spannablestringbuilder.append(new SpannableString((new StringBuilder(", ")).append(getString(0x7f0800f1)).append(" ").toString()));
        spannablestringbuilder.append(spannablestring1);
        ((TextView) (obj)).setText(spannablestringbuilder);
        obj = getView().findViewById(0x7f10090c);
        if (!flag && m && e < i1)
        {
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).setOnClickListener(new _cls7());
            return;
        } else
        {
            ((View) (obj)).setVisibility(8);
            return;
        }
    }

    public final void c()
    {
        if (getActivity() != null && !getActivity().isFinishing())
        {
            Object obj = getActivity();
            boolean flag;
            if (SocialinV3.getInstance().getUser() == null)
            {
                flag = false;
            } else
            if (!SocialinV3.getInstance().isRegistered())
            {
                com.socialin.android.d.b(i, "User is not registered!");
                if (com.socialin.android.util.s.a(((android.content.Context) (obj))))
                {
                    Intent intent = new Intent(getActivity(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity);
                    intent.putExtra("from", "ContestMe");
                    if (((Activity) (obj)).getIntent() != null && ((Activity) (obj)).getIntent().getExtras() != null)
                    {
                        intent.putExtras(((Activity) (obj)).getIntent().getExtras());
                    }
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setFlags(0x24000000);
                    startActivityForResult(intent, 11);
                } else
                {
                    GalleryUtils.a(((Activity) (obj)));
                }
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                obj = new Intent();
                ((Intent) (obj)).setClassName(getActivity().getPackageName(), "com.picsart.studio.ImagePickerActivity");
                ((Intent) (obj)).putExtra("showCameraEffects", true);
                ((Intent) (obj)).putExtra("getPath", false);
                ((Intent) (obj)).putExtra("contest_item", true);
                myobfuscated.cv.c.a(((Intent) (obj)), getActivity());
                startActivityForResult(((Intent) (obj)), 10);
                return;
            }
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        Object obj;
        super.onActivityResult(i1, j1, intent);
        obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j1 != -1) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR tableswitch 10 11: default 56
    //                   10 80
    //                   11 73;
           goto _L5 _L6 _L7
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L4:
        if (j1 == 4540)
        {
            j.a(true, false);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        c();
          goto _L4
_L6:
        Object obj1;
        Activity activity = getActivity();
        if (intent.hasExtra("source"))
        {
            try
            {
                p = (new JSONObject(intent.getExtras().getString("source"))).getString("from");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((JSONException) (obj)).printStackTrace();
            }
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ContestUploadEvent("my_submissions"));
        obj = null;
        obj1 = obj;
        if (!intent.hasExtra("item"))
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj1 = obj;
        obj = (ImageItem)intent.getExtras().getParcelable("item");
_L9:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        obj1 = obj;
        if (activity.getIntent() == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        obj1 = obj;
        if (activity.getIntent().hasExtra("item"))
        {
            obj1 = obj;
            try
            {
                obj = (ImageItem)activity.getIntent().getExtras().getParcelable("item");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (d.b)
                {
                    com.socialin.android.d.b(h, new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
                    });
                    obj = obj1;
                } else
                {
                    ExceptionReportService.report(getActivity(), ((Throwable) (obj)), SocialinV3.getInstance().getUser().id);
                    obj = obj1;
                }
            }
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            if (!((ImageItem) (obj)).isPublic)
            {
                q = ((ImageItem) (obj));
                myobfuscated.f.m.a(getActivity(), s);
            } else
            {
                a(null, ((ImageItem) (obj)));
            }
        } else
        {
            String s3 = intent.getExtras().getString("path");
            i1 = intent.getExtras().getInt("degree");
            if (intent.hasExtra("bufferData"))
            {
                k = (Map)intent.getSerializableExtra("bufferData");
            }
            String s1;
            String s2;
            if (intent.hasExtra("origFile"))
            {
                s1 = intent.getStringExtra("origFile");
            } else
            {
                s1 = null;
            }
            if (SocialinV3.getInstance().isRegistered())
            {
                s2 = SocialinV3.getInstance().getUser().username;
            } else
            {
                s2 = null;
            }
            if (intent.hasExtra("source"))
            {
                intent = intent.getStringExtra("source");
            } else
            {
                intent = null;
            }
            if (k != null)
            {
                a();
                (new _cls2(intent, s1, s2)).start();
            } else
            if (i1 != 0)
            {
                a();
                (new _cls3(s3, i1, intent, s1, s2)).start();
            } else
            {
                b();
                getActivity().runOnUiThread(new _cls11(intent, s3, s1, s2));
            }
        }
          goto _L4
        obj = null;
          goto _L9
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return getActivity().getLayoutInflater().inflate(0x7f0301f9, viewgroup, false);
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        l = new g(getActivity());
        l.setIndeterminate(true);
        l.setCancelable(true);
        l.setMessage(getActivity().getString(0x7f080679));
        if (getArguments() != null && getArguments().containsKey("isSubmitAvailable"))
        {
            m = getArguments().getBoolean("isSubmitAvailable");
        }
        view = getFragmentManager().beginTransaction();
        j = new as(this);
        view.replace(0x7f10090d, j, "my.submitted.grid").commit();
        b(true);
        view = getActivity().getIntent();
        if (view != null)
        {
            if (view.hasExtra("contestName"))
            {
                d = view.getStringExtra("contestName");
            }
            if (view.hasExtra("contestType"))
            {
                n = view.getIntExtra("contestType", n);
            }
        }
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls11 {}

}
