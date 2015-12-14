// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.e;
import com.socialin.android.d;
import com.socialin.android.dropbox.DropboxStartActivity;
import com.socialin.android.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package myobfuscated.bt:
//            c, j, i, d, 
//            b, h

public final class a extends BaseAdapter
{

    boolean a;
    private List b;
    private c c;
    private Context d;
    private int e;
    private int f;

    public a(c c1, Context context, List list)
    {
        b = new ArrayList();
        e = 80;
        f = 50;
        a = false;
        c = c1;
        d = context;
        b = list;
        e = (int)Utils.a(80F, context);
        f = (int)Utils.a(50F, context);
    }

    static c a(a a1)
    {
        return a1.c;
    }

    static void a(a a1, com.socialin.android.dropbox.a a2)
    {
        if (!a1.a)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        Object obj1;
        a1 = a1.c;
        obj1 = a1.getActivity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        Object obj;
        boolean flag;
        if (!(obj1 instanceof DropboxStartActivity))
        {
            break MISSING_BLOCK_LABEL_259;
        }
        obj = new JSONArray();
        ((JSONArray) (obj)).put(0, "");
        obj1 = (DropboxStartActivity)obj1;
        a1 = ((c) (a1)).c;
        flag = ((DropboxStartActivity) (obj1)).a;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        a1 = null;
        obj = ((JSONArray) (obj)).getString(0);
        a1 = ((a) (obj));
_L1:
        JSONException jsonexception;
        try
        {
            ((DropboxStartActivity) (obj1)).b.a(new myobfuscated.bt.j(a2, a1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            com.socialin.android.d.a("Dropbox: Select File", a1);
        }
        break MISSING_BLOCK_LABEL_111;
        jsonexception;
        com.socialin.android.d.a("Dropbox", jsonexception);
          goto _L1
        return;
        c c1 = a1.c;
        if (!c1.b())
        {
            m.a(c1.getActivity(), c1.g);
            String s1 = (new StringBuilder("https://api-content.dropbox.com/1/files/dropbox")).append(c1.a(a2)).toString();
            String s = c1.d;
            a1 = s;
            if (!s.endsWith(File.separator))
            {
                a1 = (new StringBuilder()).append(s).append(File.separator).toString();
            }
            a1 = (new StringBuilder()).append(a1).append(System.currentTimeMillis()).append("_").append(a2.a).toString();
            (new myobfuscated.bt.d(c1, c1.getActivity(), s1, a1)).a(new String[] {
                s1, a1
            });
        }
    }

    public final int getCount()
    {
        return b.size();
    }

    public final Object getItem(int l)
    {
        return b.get(l);
    }

    public final long getItemId(int l)
    {
        return (long)l;
    }

    public final View getView(int l, View view, ViewGroup viewgroup)
    {
        Object obj = (com.socialin.android.dropbox.a)b.get(l);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = LayoutInflater.from(d).inflate(0x7f0300b8, null);
        }
        if (((com.socialin.android.dropbox.a) (obj)).c)
        {
            com.bumptech.glide.b.b(d.getApplicationContext()).a((ImageView)viewgroup.findViewById(0x7f1003dd));
        }
        viewgroup.setClickable(true);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(((com.socialin.android.dropbox.a) (obj))) {

            private com.socialin.android.dropbox.a a;
            private a b;

            public final void onClick(View view1)
            {
                if (a.c)
                {
                    a.a(b).a(a.b);
                } else
                if ("dropboxMethodGet".equals(a.a(b).a))
                {
                    a.a(b, a);
                    return;
                }
            }

            
            {
                b = a.this;
                a = a2;
                super();
            }
        });
        view = (myobfuscated.bt.b)viewgroup.getTag(0x2f0e24fb);
        if (view == null)
        {
            view = new myobfuscated.bt.b();
            view.a = viewgroup.findViewById(0x7f1003dc);
            view.b = (ImageView)viewgroup.findViewById(0x7f1003dd);
            view.c = (TextView)viewgroup.findViewById(0x7f1003de);
            viewgroup.setTag(0x2f0e24fb, view);
        }
        ((myobfuscated.bt.b) (view)).c.setText(((com.socialin.android.dropbox.a) (obj)).a);
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)((myobfuscated.bt.b) (view)).c.getLayoutParams();
        ((myobfuscated.bt.b) (view)).c.setLayoutParams(layoutparams);
        ((myobfuscated.bt.b) (view)).b.getLayoutParams().width = f;
        ((myobfuscated.bt.b) (view)).b.getLayoutParams().height = f;
        if (((com.socialin.android.dropbox.a) (obj)).c)
        {
            ((myobfuscated.bt.b) (view)).a.getLayoutParams().width = f;
            ((myobfuscated.bt.b) (view)).a.getLayoutParams().height = f;
            ((myobfuscated.bt.b) (view)).b.setImageDrawable(c.getActivity().getResources().getDrawable(0x7f0201c8));
            ((myobfuscated.bt.b) (view)).b.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            return viewgroup;
        } else
        {
            ((myobfuscated.bt.b) (view)).a.getLayoutParams().width = e;
            ((myobfuscated.bt.b) (view)).a.getLayoutParams().height = e;
            ((myobfuscated.bt.b) (view)).b.setImageDrawable(c.getActivity().getResources().getDrawable(0x7f0206c6));
            c c1 = c;
            ImageView imageview = ((myobfuscated.bt.b) (view)).b;
            l = e;
            obj = (new StringBuilder("https://api-content.dropbox.com/1/thumbnails/dropbox")).append(c1.a(((com.socialin.android.dropbox.a) (obj)))).append("&size=128x128&format=jpeg").toString();
            obj = c1.j.a(obj).a(c1.i.a(0x7f020566));
            obj.a = new h(l, imageview);
            ((j) (obj)).a(imageview);
            ((myobfuscated.bt.b) (view)).b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            return viewgroup;
        }
    }

    public final boolean hasStableIds()
    {
        return true;
    }
}
