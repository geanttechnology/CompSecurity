// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;
import com.cyberlink.youcammakeup.utility.bn;
import java.io.BufferedInputStream;
import java.io.IOException;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            e, c, b, a, 
//            d

public class LooksGridItem extends FrameLayout
    implements Checkable
{

    private final String a;
    private ImageView b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private Context h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private ProgressBar p;
    private a q;
    private android.view.View.OnClickListener r;
    private float s;

    public LooksGridItem(Context context, AttributeSet attributeset, int i1)
    {
        this(context, null);
    }

    public LooksGridItem(Context context, android.view.View.OnClickListener onclicklistener)
    {
        super(context);
        a = "LooksGridItem";
        h = context;
        r = onclicklistener;
        a(((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301f6, this));
    }

    static View a(LooksGridItem looksgriditem)
    {
        return looksgriditem.n;
    }

    private void a(View view)
    {
        b = (ImageView)view.findViewById(0x7f0c08a1);
        b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        c = view.findViewById(0x7f0c08a5);
        d = (TextView)view.findViewById(0x7f0c08a6);
        e = (TextView)view.findViewById(0x7f0c08a4);
        f = (TextView)view.findViewById(0x7f0c08a3);
        g = view.findViewById(0x7f0c08a2);
        i = view.findViewById(0x7f0c08a0);
        j = view.findViewById(0x7f0c051b);
        k = view.findViewById(0x7f0c08a7);
        l = view.findViewById(0x7f0c089f);
        n = view.findViewById(0x7f0c08a9);
        m = view.findViewById(0x7f0c08ac);
        o = view.findViewById(0x7f0c08aa);
        p = (ProgressBar)view.findViewById(0x7f0c08ab);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final LooksGridItem a;

            public void onClick(View view1)
            {
                if (!LooksGridItem.c(a).isEnabled())
                {
                    return;
                } else
                {
                    LooksGridItem.c(a).setEnabled(false);
                    LooksGridItem.d(a).onClick(a);
                    return;
                }
            }

            
            {
                a = LooksGridItem.this;
                super();
            }
        });
        s = aj.a(((Activity)h).getWindowManager().getDefaultDisplay(), new ak(360F, 9F, new String[] {
            ""
        })).floatValue();
    }

    static View b(LooksGridItem looksgriditem)
    {
        return looksgriditem.o;
    }

    static View c(LooksGridItem looksgriditem)
    {
        return looksgriditem.m;
    }

    static android.view.View.OnClickListener d(LooksGridItem looksgriditem)
    {
        return looksgriditem.r;
    }

    static Context e(LooksGridItem looksgriditem)
    {
        return looksgriditem.h;
    }

    static ImageView f(LooksGridItem looksgriditem)
    {
        return looksgriditem.b;
    }

    public void a()
    {
        b.setImageResource(0x7f0208a4);
    }

    public void a(ag ag1, MakeupItemMetadata makeupitemmetadata)
    {
        if (b != null)
        {
            bn.a(ag1, makeupitemmetadata, b, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a);
        }
    }

    public void a(ag ag1, String s1)
    {
        if (b != null)
        {
            b.setImageBitmap(null);
            ag1.a(s1, b);
        }
    }

    public void a(Boolean boolean1)
    {
        if (c == null)
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            c.setVisibility(0);
            e.setVisibility(8);
            return;
        } else
        {
            c.setVisibility(8);
            e.setVisibility(0);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            j.setVisibility(0);
            i.setVisibility(8);
            return;
        } else
        {
            j.setVisibility(8);
            i.setVisibility(0);
            return;
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        if (!flag)
        {
            q = new e(this);
            return;
        }
        if (flag1)
        {
            q = new c(this);
            return;
        } else
        {
            q = new b(this);
            return;
        }
    }

    public void b()
    {
        q = q.a();
    }

    public void b(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        k.setVisibility(i1);
    }

    public void c(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (l != null)
        {
            l.setVisibility(i1);
        }
    }

    public boolean c()
    {
        return q instanceof d;
    }

    public void d(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        n.setVisibility(i1);
    }

    public void e(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        m.setVisibility(i1);
        m.setEnabled(true);
    }

    public boolean getCurViewStateDownloadable()
    {
        return !(q instanceof c);
    }

    public float getDefaultNameFontSize()
    {
        return s;
    }

    public TextView getNameTextView()
    {
        return e;
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setImage(int i1)
    {
        b.setImageResource(i1);
    }

    public void setImage(Bitmap bitmap)
    {
        b.setImageBitmap(bitmap);
    }

    public void setImage(String s1)
    {
        a();
        if (s1 == null)
        {
            return;
        } else
        {
            (new AsyncTask(s1) {

                final String a;
                final LooksGridItem b;

                protected transient Bitmap a(Void avoid[])
                {
                    if (a.indexOf("assets://") == 0)
                    {
                        try
                        {
                            avoid = BitmapFactory.decodeStream(new BufferedInputStream(LooksGridItem.e(b).getAssets().open(a.substring("assets://".length()))));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            avoid.printStackTrace();
                            return null;
                        }
                        return avoid;
                    } else
                    {
                        return BitmapFactory.decodeFile(a);
                    }
                }

                protected void a(Bitmap bitmap)
                {
                    if (bitmap != null)
                    {
                        LooksGridItem.f(b).setImageBitmap(bitmap);
                        return;
                    } else
                    {
                        b.a();
                        return;
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Bitmap)obj);
                }

            
            {
                b = LooksGridItem.this;
                a = s1;
                super();
            }
            }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void setName(CharSequence charsequence)
    {
        e.setText(charsequence);
    }

    public void setNameFontSize(float f1)
    {
        e.setTextSize(f1);
        d.setTextSize(f1);
        f.setTextSize(f1);
    }

    public void setNameMaxLines(int i1)
    {
        e.setMaxLines(i1);
    }

    public void setPreviewImage(Bitmap bitmap)
    {
        if (b != null)
        {
            b.setImageBitmap(bitmap);
        }
    }

    public void setProgress(int i1)
    {
        if (i1 < 0 || i1 > 100)
        {
            return;
        }
        if (o.getVisibility() != 0)
        {
            o.setVisibility(0);
        }
        p.setProgress(i1);
    }

    public void setVendorName(CharSequence charsequence)
    {
        if (charsequence != null && charsequence.length() > 0)
        {
            g.setVisibility(0);
            f.setText(charsequence);
            return;
        } else
        {
            g.setVisibility(4);
            f.setText("");
            return;
        }
    }

    public void toggle()
    {
    }
}
