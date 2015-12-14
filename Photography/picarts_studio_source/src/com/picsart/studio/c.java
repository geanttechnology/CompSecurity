// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;
import java.util.List;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity

final class c extends BaseAdapter
{

    final DrawingGalleryActivity a;

    private c(DrawingGalleryActivity drawinggalleryactivity)
    {
        a = drawinggalleryactivity;
        super();
    }

    c(DrawingGalleryActivity drawinggalleryactivity, byte byte0)
    {
        this(drawinggalleryactivity);
    }

    public final int getCount()
    {
        if (DrawingGalleryActivity.h(a) != null)
        {
            return DrawingGalleryActivity.h(a).size();
        } else
        {
            return 0;
        }
    }

    public final Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = a.getLayoutInflater().inflate(0x7f0300af, viewgroup, false);
        }
        float f;
        View view2;
        View view3;
        View view4;
        if (DrawingGalleryActivity.g(a).isItemChecked(i))
        {
            view1.findViewById(0x7f1003bd).setBackgroundResource(0x7f020556);
        } else
        {
            view1.findViewById(0x7f1003bd).setBackgroundResource(0x7f020560);
        }
        view = (ImageView)view1.findViewById(0x7f1000f2);
        viewgroup = (Project)DrawingGalleryActivity.h(a).get(i);
        view2 = view1.findViewById(0x7f1003ba);
        view3 = view1.findViewById(0x7f1003bb);
        view4 = view1.findViewById(0x7f1003bc);
        if (DrawingGalleryActivity.i(a) == null)
        {
            view2.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                private Project a;
                private c b;

                public final void onClick(View view5)
                {
                    DrawingGalleryActivity.b(b.a, a);
                }

            
            {
                b = c.this;
                a = project;
                super();
            }
            });
            view3.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                private Project a;
                private c b;

                public final void onClick(View view5)
                {
                    DrawingGalleryActivity.c(b.a, a);
                }

            
            {
                b = c.this;
                a = project;
                super();
            }
            });
            view4.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                private Project a;
                private c b;

                public final void onClick(View view5)
                {
                    DrawingGalleryActivity.d(b.a, a);
                }

            
            {
                b = c.this;
                a = project;
                super();
            }
            });
            view2.setEnabled(true);
            view2.setBackgroundResource(0x7f020560);
            view3.setEnabled(true);
            view3.setBackgroundResource(0x7f020560);
            view4.setEnabled(true);
            view4.setBackgroundResource(0x7f020560);
        } else
        {
            view2.setEnabled(false);
            view2.setBackgroundResource(0);
            view3.setEnabled(false);
            view3.setBackgroundResource(0);
            view4.setEnabled(false);
            view4.setBackgroundResource(0);
        }
        view1.setOnClickListener(new android.view.View.OnClickListener(viewgroup, i) {

            private Project a;
            private int b;
            private c c;

            public final void onClick(View view5)
            {
                if (DrawingGalleryActivity.i(c.a) == null)
                {
                    DrawingGalleryActivity.e(c.a, a);
                    return;
                }
                view5 = DrawingGalleryActivity.g(c.a);
                int j = b;
                boolean flag;
                if (!DrawingGalleryActivity.g(c.a).isItemChecked(b))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view5.setItemChecked(j, flag);
            }

            
            {
                c = c.this;
                a = project;
                b = i;
                super();
            }
        });
        view1.setOnLongClickListener(new android.view.View.OnLongClickListener(i) {

            private int a;
            private c b;

            public final boolean onLongClick(View view5)
            {
                DrawingGalleryActivity.g(b.a).setItemChecked(a, true);
                return true;
            }

            
            {
                b = c.this;
                a = i;
                super();
            }
        });
        ((TextView)view1.findViewById(0x7f1000f3)).setText(viewgroup.getDisplayName());
        f = (float)viewgroup.getSizeInBytes() / 1024F;
        if (f >= 1024F)
        {
            f /= 1024F;
            ((TextView)view1.findViewById(0x7f1003b9)).setText((new StringBuilder()).append(Math.round(f)).append("MB").toString());
        } else
        {
            ((TextView)view1.findViewById(0x7f1003b9)).setText((new StringBuilder()).append(Math.round(f)).append("KB").toString());
        }
        (new ModernAsyncTask(viewgroup, view) {

            private Project a;
            private ImageView b;
            private c c;

            protected final Object doInBackground(Object aobj[])
            {
                return DrawingGalleryActivity.a(c.a, a.getRootFolder().getAbsolutePath());
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                super.onPostExecute(obj);
                if (obj != null)
                {
                    b.setImageBitmap(((Bitmap) (obj)));
                }
            }

            
            {
                c = c.this;
                a = project;
                b = imageview;
                super();
            }
        }).execute(new Void[0]);
        return view1;
    }

    public final void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        if (DrawingGalleryActivity.h(a) == null || DrawingGalleryActivity.h(a).size() == 0)
        {
            a.findViewById(0x7f10013c).setVisibility(0);
            return;
        } else
        {
            a.findViewById(0x7f10013c).setVisibility(8);
            return;
        }
    }
}
