// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TemplateButton extends LinearLayout
    implements Checkable
{

    private View a;
    private ImageView b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private android.view.View.OnClickListener h;
    private BitmapDrawable i;
    private TextView j;
    private LayoutType k;
    private boolean l;

    public TemplateButton(Context context, LayoutType layouttype, BeautyMode beautymode)
    {
        super(context);
        i = null;
        l = false;
        l = false;
        a(context, layouttype, beautymode);
    }

    public TemplateButton(Context context, LayoutType layouttype, BeautyMode beautymode, boolean flag)
    {
        super(context);
        i = null;
        l = false;
        l = flag;
        a(context, layouttype, beautymode);
    }

    static android.view.View.OnClickListener a(TemplateButton templatebutton)
    {
        return templatebutton.h;
    }

    private void a(Context context, LayoutType layouttype, BeautyMode beautymode)
    {
        boolean flag;
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        flag = false;
        if (beautymode == BeautyMode.s)
        {
            if (layouttype == LayoutType.a)
            {
                context.inflate(0x7f030171, this);
            } else
            {
                context.inflate(0x7f03016c, this);
            }
        } else
        if (beautymode == BeautyMode.x || beautymode == BeautyMode.j || beautymode == BeautyMode.k)
        {
            if (layouttype == LayoutType.a)
            {
                context.inflate(0x7f030173, this);
            } else
            {
                context.inflate(0x7f03016f, this);
            }
        } else
        if (BeautyMode.d(beautymode))
        {
            if (layouttype == LayoutType.a)
            {
                context.inflate(0x7f030172, this);
            } else
            {
                context.inflate(0x7f03016b, this);
            }
        } else
        if (layouttype == LayoutType.a)
        {
            context.inflate(0x7f030170, this);
        } else
        if (l)
        {
            context.inflate(0x7f03016e, this);
            flag = true;
        } else
        {
            context.inflate(0x7f03016a, this);
            flag = true;
        }
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        a = findViewById(0x7f0c0667);
        b = (ImageView)findViewById(0x7f0c0668);
        if (!flag || a == null) goto _L4; else goto _L3
_L3:
        beautymode = null;
        context = beautymode;
        BufferedInputStream bufferedinputstream = new BufferedInputStream(getContext().getAssets().open("makeup/pattern_general.png"));
        context = beautymode;
        beautymode = BitmapFactory.decodeStream(bufferedinputstream);
        context = beautymode;
        bufferedinputstream.close();
        context = beautymode;
_L5:
        if (context != null)
        {
            i = new BitmapDrawable(getResources(), context);
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                a.setBackgroundDrawable(i);
            } else
            {
                a.setBackground(i);
            }
        }
_L4:
        k = layouttype;
        j = (TextView)findViewById(0x7f0c066c);
        c = findViewById(0x7f0c066a);
        d = findViewById(0x7f0c066b);
        e = findViewById(0x7f0c0669);
        f = findViewById(0x7f0c066e);
        g = findViewById(0x7f0c0670);
        if (d != null)
        {
            d.setOnClickListener(new android.view.View.OnClickListener() {

                final TemplateButton a;

                public void onClick(View view)
                {
                    if (TemplateButton.a(a) != null)
                    {
                        TemplateButton.a(a).onClick(a);
                    }
                }

            
            {
                a = TemplateButton.this;
                super();
            }
            });
            return;
        }
          goto _L1
        beautymode;
        beautymode.printStackTrace();
          goto _L5
    }

    public void a(ag ag1, String s)
    {
        if (b != null)
        {
            b.setImageBitmap(null);
            ag1.a(s, b);
        }
    }

    public void a(boolean flag)
    {
        if (c != null)
        {
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            c.setVisibility(i1);
        }
    }

    public void b(boolean flag)
    {
        if (g != null)
        {
            View view = g;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public void c(boolean flag)
    {
        if (d != null)
        {
            View view = d;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public void d(boolean flag)
    {
        if (e != null)
        {
            View view = e;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public void e(boolean flag)
    {
        if (f != null)
        {
            View view = f;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public LayoutType getLayoutType()
    {
        return k;
    }

    public boolean isChecked()
    {
        return isSelected();
    }

    public void setChecked(boolean flag)
    {
        setSelected(flag);
    }

    public void setImage(Bitmap bitmap)
    {
        if (b != null)
        {
            b.setImageBitmap(bitmap);
        }
    }

    public void setImage(Drawable drawable)
    {
        if (b != null)
        {
            b.setImageDrawable(drawable);
        }
    }

    public void setImage(String s)
    {
        (new AsyncTask(s) {

            final String a;
            final TemplateButton b;

            protected transient Bitmap a(Void avoid[])
            {
                BufferedInputStream bufferedinputstream;
                if (a.indexOf("assets://") != 0)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                bufferedinputstream = new BufferedInputStream(b.getContext().getAssets().open(a.substring("assets://".length())));
                avoid = BitmapFactory.decodeStream(bufferedinputstream);
                bufferedinputstream.close();
                return avoid;
                avoid = BitmapFactory.decodeFile(a);
                return avoid;
                IOException ioexception;
                ioexception;
                avoid = null;
_L2:
                ioexception.printStackTrace();
                return avoid;
                ioexception;
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected void a(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    b.setImage(bitmap);
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
                b = TemplateButton.this;
                a = s;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setName(CharSequence charsequence)
    {
        if (j != null)
        {
            j.setText(charsequence);
        }
    }

    public void setNameVisibility(int i1)
    {
        if (j != null)
        {
            j.setVisibility(i1);
        }
    }

    public void setOnItemDelete(android.view.View.OnClickListener onclicklistener)
    {
        h = onclicklistener;
    }

    public void toggle()
    {
        boolean flag;
        if (!isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setSelected(flag);
    }

    private class LayoutType extends Enum
    {

        public static final LayoutType a;
        public static final LayoutType b;
        private static final LayoutType c[];

        public static LayoutType valueOf(String s)
        {
            return (LayoutType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/TemplateButton$LayoutType, s);
        }

        public static LayoutType[] values()
        {
            return (LayoutType[])c.clone();
        }

        static 
        {
            a = new LayoutType("MORE_TYPE", 0);
            b = new LayoutType("PATTERN_TYPE", 1);
            c = (new LayoutType[] {
                a, b
            });
        }

        private LayoutType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
