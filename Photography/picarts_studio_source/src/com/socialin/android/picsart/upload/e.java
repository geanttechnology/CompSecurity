// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.picsart.studio.view.EditTextBackEvent;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.request.LocationParams;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.util.ab;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.b;
import com.socialin.gson.Gson;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.upload:
//            i, g, f, h

public final class e
{

    String a;
    Activity b;
    Adress c;
    android.view.View.OnClickListener d;
    EditTextBackEvent e;
    CheckBox f;
    TextView g;
    ImageButton h;
    View i;
    View j;
    ImageView k;
    ImageView l;
    ab m;
    boolean n;
    boolean o;
    Handler p;
    f q;
    boolean r;
    private String s;
    private List t;
    private List u;
    private BaseSocialinApiRequestController v;
    private BaseSocialinApiRequestController w;

    public e(Activity activity)
    {
label0:
        {
            super();
            a = "";
            c = null;
            n = false;
            o = false;
            p = new Handler();
            t = new ArrayList();
            u = new ArrayList();
            v = RequestControllerFactory.createSearchTagsByLocationController();
            w = RequestControllerFactory.createSearchFollowingsController();
            r = false;
            b = activity;
            d = new i(this, activity);
            n = false;
            activity = activity.getIntent();
            if (activity.hasExtra("popularTags"))
            {
                s = activity.getStringExtra("popularTags");
                if (!TextUtils.isEmpty(s))
                {
                    break label0;
                }
            }
            s = SocialinV3.getInstance().getAppProps().getGalleryPromoTags();
        }
        if (activity.hasExtra("gifEditorExport"))
        {
            r = activity.getBooleanExtra("gifEditorExport", false);
        }
        activity = b;
        m.c = (new StringBuilder()).append(activity.getString(0x7f0808fb)).append("/").append(activity.getString(0x7f0808c0)).toString();
        m.d = (new StringBuilder()).append(activity.getString(0x7f08097c)).append("_").append(SocialinV3.getInstance().getUser().id).append(".txt").toString();
        m.e = (new StringBuilder()).append(activity.getString(0x7f08097b)).append("_").append(SocialinV3.getInstance().getUser().id).append(".json").toString();
    }

    public static List a(String s1)
    {
        s1 = Pattern.compile("\\s?#(\\w+)\\s?").matcher(s1);
        ArrayList arraylist = new ArrayList();
        for (; s1.find(); arraylist.add(s1.group(1))) { }
        return arraylist;
    }

    static void a(e e1)
    {
        View view1 = e1.b.findViewById(0x7f10097b);
        View view = e1.b.findViewById(0x7f100995);
        Rect rect = new Rect();
        view1.getWindowVisibleDisplayFrame(rect);
        int k1 = view1.getRootView().getHeight() - rect.bottom - rect.top;
        if (k1 > 128)
        {
            View view2 = e1.b.findViewById(0x7f100992);
            int l1 = e1.b.getResources().getDisplayMetrics().heightPixels;
            int j1 = myobfuscated.f.m.c(view2);
            int i1 = j1;
            if (j1 > l1)
            {
                i1 = 0;
            }
            i1 = l1 - k1 - i1;
            if (i1 > 0)
            {
                view.getLayoutParams().height = i1;
            }
        } else
        {
            view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        }
        view.requestLayout();
    }

    static void a(e e1, String s1, char c1)
    {
        if (!e1.b.isFinishing() && !e1.o)
        {
            e1.k.setTag(Character.toString(c1));
            ImageView imageview = e1.k;
            int i1;
            int j1;
            if ('@' == c1)
            {
                i1 = 0x7f0206e0;
            } else
            {
                i1 = 0x7f020502;
            }
            imageview.setImageResource(i1);
            e1.i.setVisibility(8);
            e1.j.setVisibility(0);
            myobfuscated.f.m.a(e1.b, e1.e);
            e1.o = true;
            j1 = e1.e.getLineCount();
            i1 = j1;
            if (j1 > 3)
            {
                i1 = 3;
            }
            e1.e.setLines(i1);
            e1.m.a(s1, c1);
            (new Handler()).postDelayed(new _cls5(e1), 300L);
        }
    }

    static void b(e e1)
    {
        if (!e1.n)
        {
            View view = e1.b.findViewById(0x7f100994);
            GetUsersParams getusersparams = new GetUsersParams();
            getusersparams.username = SocialinV3.getInstance().getUser().username;
            getusersparams.offset = e1.m.b.size();
            getusersparams.limit = 60;
            e1.w.setRequestParams(getusersparams);
            e1.w.setRequestCompleteListener(new g(e1, view, false));
            view.setVisibility(8);
            e1.w.doRequest("search_inside_following");
        }
    }

    final void a()
    {
        if (!b.isFinishing() && o)
        {
            Object obj = b;
            EditTextBackEvent edittextbackevent = e;
            if (obj != null && !((Activity) (obj)).isFinishing())
            {
                ((InputMethodManager)((Activity) (obj)).getSystemService("input_method")).hideSoftInputFromWindow(edittextbackevent.getWindowToken(), 0);
            }
            i.setVisibility(0);
            j.setVisibility(8);
            o = false;
            e.setLines(6);
            e.clearFocus();
            obj = e.getText().toString().trim();
            if ("#".equals(obj) || "@".equals(obj))
            {
                e.setText("");
            }
            (new Handler()).postDelayed(new _cls6(), 300L);
        }
    }

    final void a(View view)
    {
        view.setOnTouchListener(new _cls4(view));
    }

    public final void a(ImageItem imageitem)
    {
        if (imageitem == null) goto _L2; else goto _L1
_L1:
        String s1 = imageitem.title;
        Iterator iterator = imageitem.getTagsList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s2 = (String)iterator.next();
            s2 = (new StringBuilder("#")).append(s2).toString();
            if (!s1.toLowerCase().contains(s2.toLowerCase()))
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(s1);
                if (s1.isEmpty())
                {
                    s1 = "";
                } else
                {
                    s1 = " ";
                }
                s1 = stringbuilder.append(s1).append(s2).toString();
            }
        } while (true);
        if (s1 != null)
        {
            q.a = false;
            e.setText(s1);
            e.setSelection(e.length());
            q.a = true;
        }
        c = imageitem.address;
        if (c == null) goto _L4; else goto _L3
_L3:
        Adress adress = c;
        Object obj = "";
        if (adress == null) goto _L6; else goto _L5
_L5:
        if (adress.country == null) goto _L8; else goto _L7
_L7:
        obj = adress.country;
_L11:
        Object obj1;
        StringBuilder stringbuilder1;
        if (!"".equals(obj))
        {
            obj1 = ",";
        } else
        {
            obj1 = "";
        }
        stringbuilder1 = (new StringBuilder()).append(((String) (obj)));
        if (adress.city == null || "".equals(adress.city))
        {
            break MISSING_BLOCK_LABEL_504;
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append(adress.city).toString();
_L14:
        obj1 = stringbuilder1.append(((String) (obj))).toString();
        if (!"".equals(obj1))
        {
            obj = ",";
        } else
        {
            obj = "";
        }
        obj1 = (new StringBuilder()).append(((String) (obj1)));
        if (adress.place == null) goto _L10; else goto _L9
_L9:
        obj = (new StringBuilder()).append(((String) (obj))).append(adress.place).toString();
_L12:
        obj = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
_L6:
        c();
_L13:
        g.setText(((CharSequence) (obj)));
        obj1 = h;
        byte byte0;
        if (((String) (obj)).isEmpty())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        ((ImageButton) (obj1)).setVisibility(byte0);
        f.setChecked(imageitem.isPublic);
        obj = (CheckBox)b.findViewById(0x7f100517);
        ((CheckBox) (obj)).setChecked(imageitem.isMature);
        if (imageitem.isMature)
        {
            ((CheckBox) (obj)).setEnabled(false);
        }
_L2:
        return;
_L8:
        obj = "";
          goto _L11
_L10:
        obj = "";
          goto _L12
        obj;
        com.socialin.android.d.b((new StringBuilder("upload:getItemCallback")).append(obj).toString());
        obj = "";
          goto _L6
_L4:
        c = new Adress();
        obj = "";
          goto _L13
        obj = "";
          goto _L14
    }

    final boolean a(char c1)
    {
        Object obj;
        NullPointerException nullpointerexception;
        Object obj1;
        int i1;
        try
        {
            obj = myobfuscated.f.m.a(c1);
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a("readFromCache", exception);
            return false;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if ('@' != c1) goto _L4; else goto _L3
_L3:
        obj = FileUtils.c(((java.io.File) (obj)));
        if (obj == null) goto _L2; else goto _L5
_L5:
        obj = ((JSONObject) (obj)).optJSONArray("data");
        u.clear();
        i1 = 0;
_L12:
        if (i1 >= ((JSONArray) (obj)).length()) goto _L7; else goto _L6
_L6:
        obj1 = ((JSONArray) (obj)).optJSONObject(i1);
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        obj1 = (ViewerUser)com.socialin.android.c.a().fromJson(((JSONObject) (obj1)).toString(), com/socialin/android/apiv3/model/ViewerUser);
        u.add(obj1);
          goto _L9
_L7:
        obj = m;
        obj1 = u;
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ab) (obj)).c.clear();
        ((ab) (obj)).c.addAll(((java.util.Collection) (obj1)));
        i1 = ((ab) (obj)).c.size() - 1;
_L11:
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ViewerUser vieweruser = (ViewerUser)((ab) (obj)).c.get(i1);
        if (!((ab) (obj)).b.contains(vieweruser))
        {
            ((ab) (obj)).b.add(vieweruser);
            ((ab) (obj)).d.add((new StringBuilder()).append(Character.toString('@')).append(vieweruser.username).toString());
        }
        i1--;
        if (true) goto _L11; else goto _L10
_L10:
        break; /* Loop/switch isn't completed */
        nullpointerexception;
        com.socialin.android.d.b("upload", "readCachedUsers", nullpointerexception);
        break; /* Loop/switch isn't completed */
_L4:
        if ('#' != c1)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = myobfuscated.f.m.b(myobfuscated.f.m.a(c1));
        if (!TextUtils.isEmpty(s1))
        {
            t.clear();
            String as[] = s1.split(",");
            Collections.addAll(t, as);
            if (!t.isEmpty())
            {
                m.a(t);
            }
        }
        break; /* Loop/switch isn't completed */
_L9:
        i1++;
        if (true) goto _L12; else goto _L2
_L2:
        return true;
    }

    final List b()
    {
        ArrayList arraylist = new ArrayList();
        if (s != null)
        {
            String as[] = s.split(",");
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s1 = as[i1];
                arraylist.add((new StringBuilder("#")).append(s1).toString());
            }

        }
        Collections.sort(arraylist, String.CASE_INSENSITIVE_ORDER);
        return arraylist;
    }

    public final void b(String s1)
    {
        if (s1 == null)
        {
            Utils.b(b, 0x7f08024e);
            b.finish();
            return;
        } else
        {
            (new com.picsart.studio.d(b.getApplicationContext())).a((new StringBuilder("file:///")).append(s1).toString(), l, com.bumptech.glide.request.e.b(l.e));
            return;
        }
    }

    final void c()
    {
        if (c != null)
        {
            LocationParams locationparams = new LocationParams();
            locationparams.latitude = c.getLatitude();
            locationparams.longitude = c.getLongitude();
            locationparams.locationCategoryId = c.venueId;
            v.setRequestCompleteListener(new h(this, (byte)0));
            com.socialin.asyncnet.b.a().a(v.getRequestId());
            v.setRequestParams(locationparams);
            v.doRequest("search_by_location", locationparams);
        }
    }

    public final void c(String s1)
    {
        if (TextUtils.isEmpty(s1) || "null".equals(s1))
        {
            l.setBackgroundColor(b.getResources().getColor(0x7f0f0095));
            return;
        } else
        {
            Object obj = l;
            Activity activity = b;
            myobfuscated.cs.c.a = ((ImageView) (obj));
            myobfuscated.cs.c.b = (com.bumptech.glide.request.e)((com.bumptech.glide.request.e)com.bumptech.glide.request.e.b(l.a).b(new ColorDrawable(activity.getResources().getColor(0x7f0f0095)))).a(new ColorDrawable(activity.getResources().getColor(0x7f0f0095)));
            obj = new myobfuscated.cs.c();
            (new com.picsart.studio.d(b.getApplicationContext())).a(s1, l, ((com.bumptech.glide.request.d) (obj)), myobfuscated.cs.c.b);
            l.setVisibility(0);
            return;
        }
    }

    public final String d()
    {
        return TextUtils.join(",", a(a));
    }

    public final int e()
    {
        return !f.isChecked() ? 0 : 1;
    }

    public final void f()
    {
        if (!FileUtils.a()) goto _L2; else goto _L1
_L1:
        boolean flag;
        Iterator iterator = a(a).iterator();
        flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            s1 = (new StringBuilder("#")).append(s1).toString();
            if (!t.contains(s1))
            {
                t.add(s1);
                flag = true;
            }
        } while (true);
        if (!flag) goto _L2; else goto _L3
_L3:
        String s2 = TextUtils.join(",", t);
        Object obj = myobfuscated.f.m.a('#');
        if (obj == null) goto _L5; else goto _L4
_L4:
        Object obj1 = new OutputStreamWriter(new FileOutputStream(((java.io.File) (obj))));
        obj = obj1;
        ((OutputStreamWriter) (obj1)).write(s2);
        obj = obj1;
        ((OutputStreamWriter) (obj1)).flush();
        obj = obj1;
        ((OutputStreamWriter) (obj1)).close();
_L12:
        if (obj1 == null) goto _L2; else goto _L6
_L6:
        ((OutputStreamWriter) (obj1)).close();
_L2:
        return;
        obj;
        com.socialin.android.d.a("writeTagsToFile", ((Throwable) (obj)));
        return;
        Exception exception;
        exception;
        obj1 = null;
_L10:
        obj = obj1;
        com.socialin.android.d.a("writeTagsToFile", exception);
        if (obj1 == null) goto _L2; else goto _L7
_L7:
        try
        {
            ((OutputStreamWriter) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.a("writeTagsToFile", ((Throwable) (obj)));
        }
        return;
        obj1;
        obj = null;
_L9:
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.a("writeTagsToFile", ioexception);
            }
        }
        throw obj1;
        obj1;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
          goto _L10
_L5:
        obj1 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final void g()
    {
        int k1 = 0;
        Object obj = Pattern.compile("\\s?@(\\w+)\\s?").matcher(a);
        ArrayList arraylist = new ArrayList();
        for (; ((Matcher) (obj)).find(); arraylist.add(((Matcher) (obj)).group(1))) { }
        obj = arraylist.iterator();
        int i1 = 0;
        int j1 = 0;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (String)((Iterator) (obj)).next();
            obj1 = m.a((new StringBuilder()).append(Character.toString('@')).append(((String) (obj1))).toString());
            if (obj1 != null && !u.contains(obj1))
            {
                u.add(obj1);
                int l1 = u.size();
                m.getClass();
                j1 = i1;
                if (l1 > 30)
                {
                    j1 = i1 + 1;
                }
                i1 = j1;
                j1 = 1;
            }
        } while (true);
        if (i1 > 0)
        {
            for (; k1 < i1; k1++)
            {
                u.remove(k1);
            }

        }
        if (j1 != 0)
        {
            myobfuscated.f.m.a(u);
        }
    }

    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls4 {}

}
