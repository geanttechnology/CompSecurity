// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.sticker.StickerFragment;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.sticker.g;
import com.cyberlink.you.utility.d;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.c:
//            d, a, b

public class c extends Fragment
{

    private static final String b = com/cyberlink/you/c/c.getSimpleName();
    public android.view.View.OnDragListener a;
    private final int c = 27;
    private final int d = 0;
    private a e;
    private StickerFragment f;
    private EditText g;
    private View h;
    private View i;
    private View j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private Group p;
    private final String q = "U:\\\\DBD";
    private com.cyberlink.you.c.d r;
    private android.view.View.OnClickListener s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;
    private g w;
    private b x;
    private android.view.View.OnFocusChangeListener y;
    private android.view.View.OnFocusChangeListener z;

    public c()
    {
        f = null;
        k = true;
        l = true;
        m = false;
        n = false;
        s = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(a.getActivity(), false);
                a.a(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false));
                c.a(a);
            }

            
            {
                a = c.this;
                super();
            }
        };
        t = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(a.getActivity(), false);
                a.a(Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false));
            }

            
            {
                a = c.this;
                super();
            }
        };
        u = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                if (c.b(a) == null)
                {
                    return;
                } else
                {
                    view = c.b(a).getText().toString();
                    HashMap hashmap = new HashMap();
                    hashmap.put("text", view);
                    a.a("sendText", hashmap);
                    return;
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        a = new android.view.View.OnDragListener() {

            final c a;

            public boolean onDrag(View view, DragEvent dragevent)
            {
                return true;
            }

            
            {
                a = c.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                a.a(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false));
            }

            
            {
                a = c.this;
                super();
            }
        };
        w = new g() {

            final c a;

            public void a(StickerObj stickerobj)
            {
                if (stickerobj != null)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("sticer", stickerobj);
                    a.a("sendSticker", hashmap);
                }
            }

            public void a(Emojicon emojicon)
            {
                if (emojicon != null)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("sticer", emojicon);
                    a.a("sendSticker", hashmap);
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        x = new b() {

            final c a;

            public void a(String s1, Map map)
            {
                a.a(s1, map);
            }

            
            {
                a = c.this;
                super();
            }
        };
        y = new android.view.View.OnFocusChangeListener() {

            final c a;

            public void onFocusChange(View view, boolean flag)
            {
                if (c.c(a) != null)
                {
                    c.c(a).onFocusChange(view, flag);
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
    }

    static void a(c c1)
    {
        c1.i();
    }

    static EditText b(c c1)
    {
        return c1.g;
    }

    static android.view.View.OnFocusChangeListener c(c c1)
    {
        return c1.z;
    }

    static View d(c c1)
    {
        return c1.j;
    }

    private void g()
    {
        Object obj = new android.view.ViewGroup.MarginLayoutParams(i.getLayoutParams());
        ((android.view.ViewGroup.MarginLayoutParams) (obj)).setMargins(27, 0, 27, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(((android.view.ViewGroup.MarginLayoutParams) (obj)));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15, -1);
        i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        h.setVisibility(8);
    }

    private void h()
    {
        i.setVisibility(8);
    }

    private void i()
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEARCH");
        intent.setData(Uri.parse("ybcbc://pick_post"));
        intent.putExtra("IsSearchLanding", true);
        intent.putExtra("ForShare", true);
        Object obj = getActivity().getPackageManager().queryIntentActivities(intent, 0).iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (ResolveInfo)((Iterator) (obj)).next();
            intent.setComponent(new ComponentName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name));
        }
        startActivityForResult(intent, 0);
    }

    public String a()
    {
        return g.getText().toString();
    }

    public void a(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        z = onfocuschangelistener;
    }

    public void a(com.cyberlink.you.c.d d1)
    {
        r = d1;
    }

    public void a(Emojicon emojicon)
    {
        if (g == null || emojicon == null)
        {
            return;
        }
        int i1 = g.getSelectionStart();
        int j1 = g.getSelectionEnd();
        if (i1 < 0)
        {
            g.append(emojicon.getEmoji());
            return;
        } else
        {
            g.getText().replace(Math.min(i1, j1), Math.max(i1, j1), emojicon.getEmoji(), 0, emojicon.getEmoji().length());
            return;
        }
    }

    public void a(String s1)
    {
        g.setText(s1);
    }

    public void a(String s1, Map map)
    {
        if (r != null)
        {
            r.a(s1, map);
        }
    }

    public void a(boolean flag)
    {
        a(Boolean.valueOf(false), Boolean.valueOf(flag), Boolean.valueOf(false));
    }

    public boolean a(Boolean boolean1, Boolean boolean2, Boolean boolean3)
    {
        return a(boolean1, boolean2, boolean3, false);
    }

    public boolean a(Boolean boolean1, Boolean boolean2, Boolean boolean3, boolean flag)
    {
label0:
        {
            boolean flag2 = false;
            boolean flag1 = flag2;
            if (e == null)
            {
                break label0;
            }
            flag1 = flag2;
            if (boolean1 == null)
            {
                break label0;
            }
            if (e.isVisible() == boolean1.booleanValue())
            {
                flag1 = flag2;
                if (!flag)
                {
                    break label0;
                }
            }
            if (boolean1.booleanValue())
            {
                getFragmentManager().beginTransaction().show(e).commitAllowingStateLoss();
            } else
            {
                getFragmentManager().beginTransaction().hide(e).commitAllowingStateLoss();
            }
            flag1 = true;
        }
label1:
        {
            flag2 = flag1;
            if (f == null)
            {
                break label1;
            }
            flag2 = flag1;
            if (boolean2 == null)
            {
                break label1;
            }
            if (f.isVisible() == boolean2.booleanValue())
            {
                flag2 = flag1;
                if (!flag)
                {
                    break label1;
                }
            }
            if (boolean2.booleanValue())
            {
                getFragmentManager().beginTransaction().show(f).commitAllowingStateLoss();
            } else
            {
                getFragmentManager().beginTransaction().hide(f).commitAllowingStateLoss();
            }
            flag2 = true;
        }
        return flag2;
    }

    public void b()
    {
        g.setText("");
    }

    public void b(boolean flag)
    {
        a(Boolean.valueOf(flag), Boolean.valueOf(false), Boolean.valueOf(false));
    }

    public void c()
    {
        g.post(new Runnable() {

            final c a;

            public void run()
            {
                c.b(a).requestFocusFromTouch();
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    public StickerFragment d()
    {
        return f;
    }

    public void e()
    {
        getView().setVisibility(0);
    }

    public void f()
    {
        getView().setVisibility(8);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Object obj = getChildFragmentManager().getFragments();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Fragment)((Iterator) (obj)).next()).onActivityResult(i1, j1, intent)) { }
        }
        if (i1 == 0 && j1 == -1 && r != null)
        {
            intent = intent.getStringExtra("Post");
            HashMap hashmap = new HashMap();
            hashmap.put("post", intent);
            r.a("sendBCPost", hashmap);
        }
    }

    public void onAttach(Activity activity)
    {
        Log.d(b, "onAttach");
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        Log.d(b, "onCreate");
        k = getArguments().getBoolean("enableChatPlus", false);
        l = getArguments().getBoolean("enableSticker", false);
        o = getArguments().getBoolean("enableExtraOp", true);
        p = (Group)getArguments().getParcelable("group");
        m = getArguments().getBoolean("hideVoice4ImportPhoto", false);
        n = getArguments().getBoolean("singleSelect4ImportPhoto", false);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(p.u_fragment_message_input, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d(b, "onDestroy");
    }

    public void onDestroyView()
    {
        j.setOnClickListener(null);
        i.setOnClickListener(null);
        h.setOnClickListener(null);
        g.setOnClickListener(null);
        g.setOnDragListener(null);
        g.setOnFocusChangeListener(null);
        if (l)
        {
            f.a(null);
        }
        if (k)
        {
            e.a(null);
        }
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        Log.d(b, "onDetach");
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        j = view.findViewById(o.sendBtn);
        j.setOnClickListener(u);
        i = view.findViewById(o.stickerBtn);
        i.setOnClickListener(t);
        h = view.findViewById(o.chatPlusBtn);
        h.setOnClickListener(s);
        g = (EditText)view.findViewById(o.inputEditText);
        g.setTextColor(Color.parseColor("#000000"));
        g.setOnClickListener(v);
        g.setOnDragListener(a);
        g.setOnFocusChangeListener(y);
        g.addTextChangedListener(new TextWatcher() {

            final c a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                charsequence = charsequence.toString().trim();
                if (charsequence != null && !charsequence.isEmpty())
                {
                    com.cyberlink.you.c.c.d(a).setEnabled(true);
                    return;
                } else
                {
                    com.cyberlink.you.c.c.d(a).setEnabled(false);
                    return;
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
        if (bundle == null)
        {
            if (k)
            {
                e = new a();
                view = new Bundle();
                view.putParcelable("group", p);
                view.putBoolean("enableExtraOp", o);
                view.putBoolean("hideVoice4ImportPhoto", m);
                view.putBoolean("singleSelect4ImportPhoto", n);
                e.setArguments(view);
                e.a(x);
                getChildFragmentManager().beginTransaction().add(o.chatPlusFragmentContainer, e, "ChatPlus").hide(e).commitAllowingStateLoss();
            }
            if (l)
            {
                f = new StickerFragment();
                view = new Bundle();
                view.putBoolean("Emoji", true);
                view.putBoolean("Shop", true);
                view.putBoolean("Setting", true);
                view.putInt("Mode", 0);
                f.setArguments(view);
                f.a(w);
                getChildFragmentManager().beginTransaction().add(o.stickerFragmentContainer, f, "Sticker").hide(f).commitAllowingStateLoss();
            }
        } else
        {
            if (l)
            {
                f = (StickerFragment)getChildFragmentManager().findFragmentByTag("Sticker");
                f.a(w);
            }
            if (k)
            {
                e = (a)getChildFragmentManager().findFragmentByTag("ChatPlus");
                e.a(x);
            }
            a(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), true);
        }
        if (!k)
        {
            g();
        }
        if (!l)
        {
            h();
        }
    }

}
