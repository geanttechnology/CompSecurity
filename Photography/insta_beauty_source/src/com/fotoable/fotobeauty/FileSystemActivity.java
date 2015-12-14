// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bog;
import bok;
import boo;
import com.wantu.setting.BackPathActionBarView;
import com.wantu.setting.CommonBottomView;
import com.wantu.setting.FileAdapter;
import java.io.File;
import java.util.ArrayList;
import sm;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity

public class FileSystemActivity extends FullscreenActivity
    implements android.widget.AdapterView.OnItemClickListener, bog, bok, boo
{

    String a;
    private BackPathActionBarView b;
    private CommonBottomView c;
    private ListView d;
    private TextView e;
    private FileAdapter f;
    private ArrayList g;
    private File h;
    private ArrayList i;
    private String j;
    private TextView k;

    public FileSystemActivity()
    {
        a = "FileSystemActivity";
        g = new ArrayList();
    }

    private ArrayList f(String s)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        s = new File(s);
        if (s.isDirectory())
        {
            s = s.listFiles();
            if (s != null)
            {
                for (int l = 0; l < s.length; l++)
                {
                    if (s[l].isDirectory() && !h(a(s[l])).contains("."))
                    {
                        arraylist.add(a(s[l]));
                        arraylist1.add(s[l]);
                    }
                }

                b(arraylist1);
                k.setVisibility(4);
                if (arraylist1.isEmpty())
                {
                    k.setVisibility(0);
                }
                return arraylist;
            }
        }
        return null;
    }

    private ArrayList g(String s)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        s = (new File(s)).getParentFile();
        if (s != null && s.isDirectory())
        {
            k.setVisibility(4);
            File afile[] = s.listFiles();
            if (s.getAbsolutePath().toString().contains("storage") || s.getAbsolutePath().toString().contains(getPackageName()))
            {
                if (afile == null)
                {
                    e();
                    return null;
                }
            } else
            {
                e();
                return null;
            }
            b(s);
            for (int l = 0; l < afile.length; l++)
            {
                if (afile[l].isDirectory() && !h(a(afile[l])).contains("."))
                {
                    arraylist.add(a(afile[l]));
                    arraylist1.add(afile[l]);
                }
            }

        } else
        {
            e();
            return null;
        }
        c(g().getName());
        b(arraylist1);
        return arraylist;
    }

    private String h(String s)
    {
        return s.substring(s.lastIndexOf("/") + 1, s.length());
    }

    private ArrayList h()
    {
        String s = d(j);
        File file = new File(s);
        c(file.getName());
        b(file);
        e.setText(s);
        return f(s);
    }

    public String a(File file)
    {
        return file.getAbsolutePath();
    }

    public void a()
    {
        b = (BackPathActionBarView)findViewById(0x7f0d00b3);
        c = (CommonBottomView)findViewById(0x7f0d00b6);
        e = (TextView)findViewById(0x7f0d00b4);
        d = (ListView)findViewById(0x7f0d00b5);
        k = (TextView)findViewById(0x7f0d00b7);
        j = sm.a();
        if (j.endsWith("/"))
        {
            j = d(j);
        }
        g = h();
        f = new FileAdapter(getApplicationContext(), 0x7f030056, g);
    }

    public void a(int l)
    {
label0:
        {
            ((File)f().get(l)).getName();
            File file = (File)f().get(l);
            if (file.isDirectory())
            {
                b(file);
                g = f(a(g()));
                if (g != null)
                {
                    break label0;
                }
                Toast.makeText(this, 0x7f0600d1, 0).show();
            }
            return;
        }
        c(g().getName());
        a(g);
    }

    public void a(String s)
    {
        sm.a(s);
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            e.setText(a(g()));
            f.updateItems(arraylist);
        }
    }

    public void b()
    {
        b.setBackTopLayerListener(this);
        c.setOnClickCreateFolderListener(this);
        f.setOnSelectedBtnItemCall(this);
        f.setCurrentPathName(j);
        d.setAdapter(f);
        d.setOnItemClickListener(this);
        b.saveButtomIsShow(true);
    }

    public void b(File file)
    {
        h = file;
    }

    public void b(ArrayList arraylist)
    {
        i = arraylist;
    }

    public boolean b(String s)
    {
        s = new File(s);
        return !s.isDirectory() || s.listFiles() == null;
    }

    public void c()
    {
        k.setVisibility(4);
        d();
    }

    public void c(String s)
    {
        b.setTextViewText(s);
    }

    public String d(String s)
    {
        int l = 0;
        int i1;
        int j1;
        for (i1 = 0; l < s.length(); i1 = j1)
        {
            j1 = i1;
            if (s.charAt(l) == '/')
            {
                j1 = i1 + 1;
            }
            l++;
        }

        if (i1 > 1)
        {
            return s.substring(0, s.lastIndexOf("/"));
        } else
        {
            return s.substring(s.lastIndexOf("/"), s.lastIndexOf("/") + 1);
        }
    }

    public void d()
    {
        String s = a(g());
        if (s != null)
        {
            g = g(s);
            if (g != null)
            {
                a(g);
            }
        }
    }

    public void e()
    {
        finish();
    }

    public void e(String s)
    {
        File file;
label0:
        {
            s = (new StringBuilder()).append(a(g())).append("/").append(s).toString();
            file = new File(s.toString());
            if (file != null)
            {
                if (!file.exists())
                {
                    break label0;
                }
                Toast.makeText(this, 0x7f060107, 1).show();
            }
            return;
        }
        if (file.mkdir())
        {
            g.add(s);
            f().add(file);
            a(g);
            return;
        } else
        {
            Toast.makeText(this, 0x7f060190, 1).show();
            return;
        }
    }

    public ArrayList f()
    {
        return i;
    }

    public File g()
    {
        return h;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030024);
        a();
        b();
    }

    public void onItemClick(AdapterView adapterview, View view, int l, long l1)
    {
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 4)
        {
            d();
            return false;
        } else
        {
            return super.onKeyDown(l, keyevent);
        }
    }
}
