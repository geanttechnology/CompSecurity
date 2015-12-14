// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DialogChooseDirectory
    implements android.content.DialogInterface.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    List a;
    File b;
    Context c;
    ListView d;

    private void a()
    {
        a.clear();
        File afile[] = b.listFiles();
        if (b.getParent() != null)
        {
            a.add(new File(".."));
        }
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    break;
                }
                File file = afile[i];
                if (file.isDirectory() && !file.isHidden())
                {
                    a.add(file);
                }
                i++;
            } while (true);
        }
        Collections.sort(a, new Comparator() {

            final DialogChooseDirectory a;

            public int a(File file1, File file2)
            {
                return file1.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
            }

            public int compare(Object obj, Object obj1)
            {
                return a((File)obj, (File)obj1);
            }

            
            {
                a = DialogChooseDirectory.this;
                super();
            }
        });
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < 0 || i >= a.size())
        {
            return;
        }
        if (((File)a.get(i)).getName().equals(".."))
        {
            b = b.getParentFile();
        } else
        {
            b = (File)a.get(i);
        }
        a();
        adapterview = new DirAdapter(0x1090003);
        d.setAdapter(adapterview);
    }

    private class DirAdapter extends ArrayAdapter
    {

        final DialogChooseDirectory this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = (TextView)super.getView(i, view, viewgroup);
            if (a.get(i) == null)
            {
                view.setText("..");
                view.setCompoundDrawablesWithIntrinsicBounds(c.getResources().getDrawable(com.fotoable.fotophotoselector.R.drawable.ic_parentdir), null, null, null);
                return view;
            } else
            {
                view.setText(((File)a.get(i)).getName());
                view.setCompoundDrawablesWithIntrinsicBounds(c.getResources().getDrawable(com.fotoable.fotophotoselector.R.drawable.ic_file), null, null, null);
                return view;
            }
        }

        public DirAdapter(int i)
        {
            this$0 = DialogChooseDirectory.this;
            super(c, i, a);
        }
    }

}
