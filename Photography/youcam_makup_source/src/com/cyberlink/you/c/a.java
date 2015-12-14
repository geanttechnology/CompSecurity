// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.c:
//            c, b

public class a extends Fragment
{

    private static final String a = com/cyberlink/you/c/a.getSimpleName();
    private static String b = null;
    private static String c = null;
    private boolean d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private b m;
    private Group n;
    private boolean o;
    private boolean p;
    private boolean q;
    private android.view.View.OnClickListener r;

    public a()
    {
        d = false;
        p = false;
        q = false;
        r = new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view)
            {
                while (a.getActivity() == null || a.a(a)) 
                {
                    return;
                }
                a.a(a, true);
                view = new Intent("android.media.action.IMAGE_CAPTURE");
                if (view.resolveActivity(a.getActivity().getPackageManager()) != null)
                {
                    a.a(com.cyberlink.you.utility.d.e());
                    view.putExtra("output", Uri.fromFile(new File(a.a())));
                    a.startActivityForResult(view, 1);
                    com.cyberlink.you.g.a().f(true);
                    a.b(a);
                    return;
                } else
                {
                    a.a(a, false);
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    static String a()
    {
        return b;
    }

    static String a(String s)
    {
        b = s;
        return s;
    }

    static boolean a(a a1)
    {
        return a1.d;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.d = flag;
        return flag;
    }

    private void b()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null && (fragmentactivity instanceof ChatDialogActivity))
        {
            ((ChatDialogActivity)fragmentactivity).e().b(false);
        }
    }

    static void b(a a1)
    {
        a1.b();
    }

    public void a(b b1)
    {
        m = b1;
    }

    public void a(String s, Map map)
    {
        if (m != null)
        {
            m.a(s, map);
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (getActivity() == null)
        {
            return;
        }
        i1;
        JVM INSTR tableswitch 0 7: default 64
    //                   0 65
    //                   1 129
    //                   2 64
    //                   3 64
    //                   4 322
    //                   5 117
    //                   6 123
    //                   7 253;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        if (j1 == -1)
        {
            intent = (ArrayList)intent.getExtras().getSerializable("import_images");
            HashMap hashmap = new HashMap();
            hashmap.put("importImages", intent);
            a("sendPhoto", hashmap);
        }
        d = false;
        return;
_L5:
        d = false;
        return;
_L6:
        d = false;
        return;
_L3:
        if (j1 != -1) goto _L9; else goto _L8
_L8:
        com.cyberlink.you.g.a().f(false);
        intent = getActivity();
        Object obj;
        obj = b;
        android.content.Context context = com.cyberlink.you.g.I();
        MediaScannerConnection.scanFile(context, new String[] {
            obj
        }, null, null);
        obj = com.cyberlink.you.utility.d.a(context, b);
        if (obj != null && intent != null)
        {
            try
            {
                intent = new ArrayList();
                intent.add(obj);
                obj = new HashMap();
                ((Map) (obj)).put("importImages", intent);
                a("sendPhoto", ((Map) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.e(a, "TODO: Handle Exception");
            }
        }
_L9:
        d = false;
        return;
_L7:
        if (j1 == -1)
        {
            ArrayList arraylist = intent.getParcelableArrayListExtra("location");
            intent = (Uri)intent.getParcelableExtra("snapshotUrl");
            HashMap hashmap2 = new HashMap();
            hashmap2.put("addresses", arraylist);
            hashmap2.put("snapshotPath", intent);
            a("shareLocation", hashmap2);
        }
        d = false;
        return;
_L4:
        if (j1 == -1 && intent != null)
        {
            intent = intent.getParcelableArrayListExtra("results");
            if (intent != null && intent.size() > 0)
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("selectFriends", intent);
                a("introduceFriend", hashmap1);
            }
        }
        d = false;
        return;
    }

    public void onAttach(Activity activity)
    {
        Log.d(a, "onAttach");
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        Log.d(a, "onCreate");
        n = (Group)getArguments().getParcelable("group");
        o = getArguments().getBoolean("enableExtraOp", true);
        p = getArguments().getBoolean("hideVoice4ImportPhoto", false);
        q = getArguments().getBoolean("singleSelect4ImportPhoto", false);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(p.u_fragment_chat_plus, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d(a, "onDestroy");
        g.setOnClickListener(null);
        h.setOnClickListener(null);
        e.setOnClickListener(null);
        f.setOnClickListener(null);
        i.setOnClickListener(null);
        j.setOnClickListener(null);
        k.setOnClickListener(null);
        l.setOnClickListener(null);
    }

    public void onDetach()
    {
        super.onDetach();
        Log.d(a, "onDetach");
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
        g = view.findViewById(o.photoLibrary);
        h = view.findViewById(o.camera);
        h.setOnClickListener(r);
        i = view.findViewById(o.scheduleSend);
        j = view.findViewById(o.selfDestruct);
        k = view.findViewById(o.voiceMessage);
        l = view.findViewById(o.introduceFriend);
        e = view.findViewById(o.videoCapture);
        f = view.findViewById(o.videoLibrary);
    }

}
