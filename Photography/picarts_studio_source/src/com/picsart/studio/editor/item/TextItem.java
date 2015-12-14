// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.gizmo.DefaultGizmo;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.util.d;
import com.socialin.android.util.n;
import com.socialin.android.util.w;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.item:
//            TransformingItem, a, c

public final class TextItem extends TransformingItem
    implements a
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TextItem(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int k)
        {
            return new TextItem[k];
        }

    };
    private Rect A;
    private Path B;
    private Path C;
    private RectF D;
    public TextArtStyle a;
    public String b;
    public String c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    private String j[];
    private Rect s;
    private Paint t;
    private Paint u;
    private float v;
    private float w;
    private float x;
    private Bitmap y;
    private Rect z;

    private TextItem()
    {
        b = "PicsArt";
        j = (new String[] {
            b
        });
        c = null;
        s = new Rect();
        d = true;
        e = 50;
        v = 0.9F;
        f = false;
        g = true;
        h = 0;
        z = new Rect();
        A = new Rect();
        B = new Path();
        C = new Path();
        D = new RectF();
        u();
    }

    private TextItem(Parcel parcel)
    {
        super(parcel);
        b = "PicsArt";
        j = (new String[] {
            b
        });
        c = null;
        s = new Rect();
        d = true;
        e = 50;
        v = 0.9F;
        f = false;
        g = true;
        h = 0;
        z = new Rect();
        A = new Rect();
        B = new Path();
        C = new Path();
        D = new RectF();
        u();
        a((TextArtStyle)parcel.readParcelable(com/socialin/android/photo/textart/TextArtStyle.getClassLoader()));
        a(parcel.readString());
    }

    TextItem(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    private void a(android.graphics.Paint.Align align)
    {
        t.setTextAlign(align);
        u.setTextAlign(align);
    }

    private static android.graphics.Paint.Align b(TextArtStyle textartstyle)
    {
        switch (textartstyle.getAlignment())
        {
        default:
            return android.graphics.Paint.Align.LEFT;

        case 17: // '\021'
            return android.graphics.Paint.Align.CENTER;

        case 21: // '\025'
            return android.graphics.Paint.Align.RIGHT;
        }
    }

    public static TextItem b()
    {
        return new TextItem();
    }

    private void u()
    {
        t = new Paint();
        t.setStyle(android.graphics.Paint.Style.FILL);
        t.setAntiAlias(true);
        t.setTextSize(80F);
        t.setFilterBitmap(true);
        u = new Paint();
        u.setTextSize(80F);
        u.setStyle(android.graphics.Paint.Style.STROKE);
        u.setStrokeWidth(2.5F);
        u.setAntiAlias(true);
        u.setFilterBitmap(true);
    }

    private int v()
    {
        switch (a.getAlignment())
        {
        default:
            return 0;

        case 17: // '\021'
            return s.centerX();

        case 21: // '\025'
            return s.right;
        }
    }

    private int w()
    {
        return (int)((3F * t.getFontSpacing()) / 4F);
    }

    public final Gizmo a(Resources resources)
    {
        return DefaultGizmo.a(resources, this);
    }

    public final TextItem a(TextArtStyle textartstyle)
    {
        a = textartstyle;
        t.setColor(textartstyle.getFillColor());
        u.setColor(textartstyle.getStrokeColor());
        android.graphics.Typeface typeface = TypefaceSpec.getTypeFace(EditorActivity.a(), textartstyle.getTypefaceSpec());
        t.setTypeface(typeface);
        u.setTypeface(typeface);
        h();
        textartstyle = b(textartstyle);
        if (d)
        {
            a(((android.graphics.Paint.Align) (textartstyle)));
        }
        o();
        return this;
    }

    public final TextItem a(String s1)
    {
        b = s1;
        if (!d || !f) goto _L2; else goto _L1
_L1:
        if (s1.contains("\n"))
        {
            c = s1;
            b = s1.replaceAll("\n", " ");
        } else
        {
            c = null;
        }
_L4:
        j = b.split("\n");
        h();
        if (d && f)
        {
            q();
        }
        f();
        o();
        return this;
_L2:
        if (c != null)
        {
            b = c;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(boolean flag)
    {
        d = flag;
        if (!flag)
        {
            a(android.graphics.Paint.Align.LEFT);
        } else
        {
            a(b(a));
        }
        h();
        f();
        o();
    }

    public final void b(Canvas canvas)
    {
        t.setAlpha(Color.alpha(m));
        t.setXfermode(com.socialin.android.util.d.a(this.l));
        u.setAlpha(Color.alpha(m));
        u.setXfermode(com.socialin.android.util.d.a(this.l));
        if (a.hasGradient())
        {
            LinearGradient lineargradient = new LinearGradient(0.0F, 0.0F, 0.0F, s.height(), a.getFillColor(), a.getFillGradientBottomColor(), android.graphics.Shader.TileMode.CLAMP);
            t.setShader(lineargradient);
        } else
        {
            t.setShader(null);
        }
        if (y == null) goto _L2; else goto _L1
_L1:
        canvas.drawBitmap(y, 0.0F, 0.0F, t);
_L4:
        return;
_L2:
        if (!d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f)
        {
            float f1;
            if (g)
            {
                f1 = -s.bottom;
            } else
            {
                f1 = -s.top;
            }
            if (a.hasStroke())
            {
                canvas.drawTextOnPath(b, C, 0.0F, f1, u);
            }
            canvas.drawTextOnPath(b, C, 0.0F, f1, t);
            return;
        }
        int j1 = s.height() - s.bottom;
        int l1 = v();
        int j2 = w();
        if (a.hasStroke())
        {
            B.rewind();
            int k = 0;
            while (k < j.length) 
            {
                u.getTextPath(j[k], 0, j[k].length(), -s.left + l1, k * j2 + j1, B);
                canvas.drawPath(B, u);
                t.getTextPath(j[k], 0, j[k].length(), -s.left + l1, k * j2 + j1, B);
                canvas.drawPath(B, t);
                B.rewind();
                k++;
            }
        } else
        {
            int l = 0;
            while (l < j.length) 
            {
                canvas.drawText(j[l], 0, j[l].length(), -s.left + l1, l * j2 + j1, t);
                l++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        String as[] = j;
        int i2 = as.length;
        int i1 = 0;
        float f2 = 0.0F;
        while (i1 < i2) 
        {
            String s1 = as[i1];
            float f3 = 0.0F;
            int k1 = 0;
            while (k1 < s1.length()) 
            {
                A.setEmpty();
                t.getTextBounds(s1, k1, k1 + 1, A);
                f3 = Math.max(f3, A.width());
                if (a.hasStroke())
                {
                    B.rewind();
                    u.getTextPath(s1, k1, k1 + 1, (f3 - (float)A.width()) / 2.0F + f2, v * t.getTextSize() * (float)(k1 + 1), B);
                    canvas.drawPath(B, u);
                    B.rewind();
                    t.getTextPath(s1, k1, k1 + 1, (f3 - (float)A.width()) / 2.0F + f2, v * t.getTextSize() * (float)(k1 + 1), B);
                    canvas.drawPath(B, t);
                } else
                {
                    float f4 = (f3 - (float)A.width()) / 2.0F;
                    float f6 = v;
                    float f7 = t.getTextSize();
                    canvas.drawText(s1, k1, k1 + 1, f2 + f4, (float)(k1 + 1) * (f6 * f7), t);
                }
                k1++;
            }
            float f5 = (float)w() / 3F;
            i1++;
            f2 += f3 + f5;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final boolean c()
    {
        return false;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void e()
    {
        if (o != null)
        {
            o.a(this);
        }
    }

    public final void f()
    {
        int k;
        if (this != null && a != null && a.getTypefaceSpec() != null && "font_2.ttf".equals(a.getTypefaceSpec().getFontName()))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k != 0 || g() && (!f || !d))
        {
            Object obj = com.socialin.android.util.w.a(new n((int)i(), (int)j()), PicsartContext.a());
            y = Bitmap.createBitmap(((n) (obj)).a, ((n) (obj)).b, android.graphics.Bitmap.Config.ARGB_8888);
            obj = new Canvas(y);
            if (d)
            {
                if (!f)
                {
                    int j1 = s.height() - s.bottom;
                    int l1 = v();
                    int j2 = w();
                    if (a.hasStroke())
                    {
                        for (k = 0; k < j.length; k++)
                        {
                            ((Canvas) (obj)).drawText(j[k], 0, j[k].length(), -s.left + l1, k * j2 + j1, u);
                            ((Canvas) (obj)).drawText(j[k], 0, j[k].length(), -s.left + l1, k * j2 + j1, t);
                        }

                    } else
                    {
                        for (int l = 0; l < j.length; l++)
                        {
                            ((Canvas) (obj)).drawText(j[l], 0, j[l].length(), -s.left + l1, l * j2 + j1, t);
                        }

                    }
                }
            } else
            {
                String as[] = j;
                int k2 = as.length;
                int k1 = 0;
                float f3 = 0.0F;
                while (k1 < k2) 
                {
                    String s1 = as[k1];
                    float f2 = 0.0F;
                    int i2 = 0;
                    int i1 = 0;
                    float f1 = 0.0F;
                    while (i2 < s1.length()) 
                    {
                        if (Character.isLowSurrogate(s1.charAt(i2)))
                        {
                            i1++;
                        } else
                        {
                            float f4;
                            float f5;
                            byte byte0;
                            if (Character.isHighSurrogate(s1.charAt(i2)))
                            {
                                byte0 = 2;
                            } else
                            {
                                byte0 = 1;
                            }
                            A.setEmpty();
                            t.getTextBounds(s1, i2, i2 + byte0, A);
                            if (Character.isHighSurrogate(s1.charAt(i2)))
                            {
                                f2 = 0.1F * (float)A.width() * (float)i1;
                            }
                            f1 = Math.max(f1, A.width());
                            f4 = f3 + (f1 - (float)A.width()) / 2.0F;
                            f5 = v * t.getTextSize() * (float)((i2 + 1) - i1) + f2;
                            if (a.hasStroke())
                            {
                                ((Canvas) (obj)).drawText(s1, i2, i2 + byte0, f4, f5, u);
                            }
                            ((Canvas) (obj)).drawText(s1, i2, i2 + byte0, f4, f5, t);
                        }
                        i2++;
                    }
                    f2 = (float)w() / 3F;
                    k1++;
                    f3 += f2 + f1;
                }
            }
        } else
        if (y != null)
        {
            y.recycle();
            y = null;
        }
    }

    public final boolean g()
    {
        boolean flag1 = false;
        int k = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (k < b.length())
                {
                    if (Character.getType(b.codePointAt(k)) != 28)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k++;
        } while (true);
    }

    public final void h()
    {
        s.setEmpty();
        z.setEmpty();
        if (d)
        {
            s.setEmpty();
            if (f && c != null)
            {
                t.getTextBounds(b, 0, b.length(), s);
            } else
            {
                int i1 = w();
                int k = 0;
                while (k < j.length) 
                {
                    t.getTextBounds(j[k], 0, j[k].length(), z);
                    Rect rect = z;
                    rect.top = rect.top + k * i1;
                    rect = z;
                    rect.bottom = rect.bottom + k * i1;
                    s.union(z);
                    k++;
                }
            }
            return;
        }
        String as[] = j;
        int l1 = as.length;
        int l = 0;
        float f2 = 0.0F;
        float f1;
        float f3;
        float f5;
        for (f1 = 0.0F; l < l1; f1 += f5 + f3)
        {
            String s1 = as[l];
            int j1 = 0;
            int k1 = 0;
            f3 = 0.0F;
            while (j1 < s1.length()) 
            {
                if (Character.isLowSurrogate(s1.charAt(j1)))
                {
                    k1++;
                } else
                {
                    byte byte0 = 1;
                    if (Character.isHighSurrogate(s1.charAt(j1)))
                    {
                        byte0 = 2;
                    }
                    A.setEmpty();
                    t.getTextBounds(s1, j1, byte0 + j1, A);
                    f3 = Math.max(f3, A.width());
                }
                j1++;
            }
            f5 = (float)w() / 3F;
            float f6 = k1;
            float f7 = v;
            float f8 = t.getTextSize();
            f2 = Math.max(f2, 0.1F * f3 * f6 + (float)(s1.length() - k1) * (f7 * f8));
            l++;
        }

        float f4 = (float)w() / 3F;
        s.set(0, -(int)f2, (int)(f1 - f4), 0);
    }

    public final List h_()
    {
        return m.h();
    }

    public final float i()
    {
        if (!f || !d)
        {
            return (float)s.width();
        } else
        {
            return w;
        }
    }

    public final float j()
    {
        if (!f || !d)
        {
            return (float)s.height();
        } else
        {
            return x;
        }
    }

    public final int p()
    {
        return (int)((720F * (float)e) / 100F) - 360;
    }

    public final Path q()
    {
        float f2 = (float)((double)(s.width() * 180) / ((double)h * 3.1415926535897931D));
        float f1 = (float)Math.sin(Math.toRadians((float)h / 2.0F));
        float f3 = (float)Math.cos(Math.toRadians((float)h / 2.0F));
        float f4 = s.height() / 2;
        if (h <= 180)
        {
            f1 *= 2.0F * f2;
        } else
        {
            f1 = 2.0F * f2;
        }
        w = f1;
        x = (1.0F - f3) * f2 + f4 * (1.0F + f3);
        f3 = w / 2.0F;
        if (g)
        {
            f1 = -(f2 - x);
        } else
        {
            f1 = f2;
        }
        D.set(f3 - f2, f1 - f2, f3 + f2, f1 + f2);
        C.rewind();
        if (g)
        {
            C.addArc(D, 90F + (float)h * 0.5F, -h);
        } else
        {
            C.addArc(D, 270F - (float)h * 0.5F, h);
        }
        return C;
    }

    public final void writeToParcel(Parcel parcel, int k)
    {
        super.writeToParcel(parcel, k);
        parcel.writeParcelable(a, k);
        parcel.writeString(b);
    }

}
