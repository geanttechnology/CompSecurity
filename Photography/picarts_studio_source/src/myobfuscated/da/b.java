// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.da;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.i;
import com.socialin.camera.masks.a;
import com.socialin.camera.masks.c;
import com.socialin.camera.masks.e;
import com.socialin.camera.masks.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.da:
//            c

public class b extends BaseAdapter
    implements android.widget.AdapterView.OnItemClickListener, i, f
{

    public final String a = (new StringBuilder()).append(myobfuscated/da/b.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    public SparseArray b;
    public int c;
    public e d;
    public int e;
    private View f[];
    private volatile ArrayList g;
    private c h;
    private String i;
    private String j;
    private Activity k;
    private com.socialin.android.net.a l;
    private myobfuscated.da.c m;

    public b(Activity activity, com.socialin.android.net.a a1, myobfuscated.da.c c1, c c2)
    {
        b = new SparseArray();
        h = null;
        c = -1;
        e = 0;
        k = activity;
        l = a1;
        m = c1;
        j = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(activity.getString(0x7f0808fb)).append("/").append(activity.getString(0x7f0808dc)).append("/masks_ver2/").toString();
        a(c2);
    }

    private String d(int i1)
    {
        Object obj;
        a a1;
        try
        {
            a1 = (a)g.get(i1);
            obj = (new StringBuilder()).append(a1.f).append(a1.g).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        try
        {
            i1 = a1.b;
        }
        catch (Exception exception)
        {
            return ((String) (obj));
        }
        return ((String) (obj));
    }

    public final void a(int i1)
    {
        if (d != null)
        {
            com.socialin.camera.masks.e.a(this, i1, l);
        }
    }

    public final void a(int i1, boolean flag)
    {
        if (c >= 0 && i1 == c && i1 < g.size())
        {
            ((Integer)getItem(i1)).intValue();
            a a1 = (a)g.get(i1);
            notifyDataSetChanged();
            if (a1.c != 0 && a1.c == 1)
            {
                Object obj = d(i1);
                obj = (new StringBuilder()).append(j).append(h.b).append("/").append(((String) (obj))).toString();
                if ((new File(((String) (obj)))).exists())
                {
                    a a2 = (a)g.get(i1);
                    i1 = a2.h;
                    if (m != null)
                    {
                        m.a(((String) (obj)), a2, flag);
                        return;
                    }
                } else
                {
                    d.a = i1;
                    d.b = ((String) (obj));
                    obj = d;
                    if (((e) (obj)).d == null || !((e) (obj)).d.isShowing())
                    {
                        Activity activity = ((e) (obj)).c;
                        if (activity != null)
                        {
                            obj.d = com.socialin.android.dialog.g.a(activity, null, activity.getString(0x7f08041c));
                            ((e) (obj)).d.setCancelable(true);
                            ((e) (obj)).d.setOnCancelListener(((android.content.DialogInterface.OnCancelListener) (obj)));
                        }
                    }
                    a(i1);
                    return;
                }
            }
        }
    }

    public final void a(c c1)
    {
        h = c1;
        i = c1.a(k);
        g = c1.c;
        c = -1;
        f = new View[g.size()];
    }

    public final String b(int i1)
    {
        String s1 = d(i1);
        String s = h.b;
        StringBuilder stringbuilder = (new StringBuilder()).append(a.a).append(s).append("/");
        s = "1024";
        if (PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW)
        {
            s = "640";
        }
        return stringbuilder.append(s).append("/").append(s1).toString();
    }

    public final void b(int i1, boolean flag)
    {
        c = i1;
        notifyDataSetChanged();
        a(i1, flag);
    }

    public final String c(int i1)
    {
        String s = d(i1);
        return (new StringBuilder()).append(j).append(h.b).append("/").append(s).toString();
    }

    public int getCount()
    {
        return g.size();
    }

    public Object getItem(int i1)
    {
        return Integer.valueOf(i1);
    }

    public long getItemId(int i1)
    {
        return (long)i1;
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        if (f[i1] == null)
        {
            viewgroup = LayoutInflater.from(k).inflate(0x7f030052, null);
            ((TextView)viewgroup.findViewById(0x7f100234)).setText((new StringBuilder()).append(i).append(" ").append(i1 + 1).toString());
            ImageView imageview = (ImageView)viewgroup.findViewById(0x7f100233);
            try
            {
                view = k.getAssets().open((new StringBuilder("masks/")).append(h.b).append("/").append(((a)g.get(i1)).e).toString());
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
                view = null;
            }
            view = com.socialin.android.util.c.a(view, null, null, a);
            if (view != null && !view.isRecycled())
            {
                view = new myobfuscated.cd.a(k.getResources(), view);
                b.put(i1, view);
                imageview.setImageDrawable((Drawable)b.get(i1));
            }
            f[i1] = viewgroup;
        }
        if (c == i1)
        {
            f[i1].findViewById(0x7f100235).setVisibility(0);
        } else
        {
            f[i1].findViewById(0x7f100235).setVisibility(8);
        }
        f[i1].setRotation(e);
        return f[i1];
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        b(i1, true);
    }
}
