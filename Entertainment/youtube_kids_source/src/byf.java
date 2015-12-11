// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import java.text.NumberFormat;

public final class byf
{

    public static Spanned a(dlb dlb1)
    {
        if (dlb1 == null)
        {
            return null;
        }
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        dlb1 = dlb1.b;
        int i1 = dlb1.length;
        int j = 0;
        int k = 0;
        int i = 0;
        while (j < i1) 
        {
            Object obj = dlb1[j];
            if (TextUtils.isEmpty(((dza) (obj)).b))
            {
                continue;
            }
            k = ((dza) (obj)).b.length() + k;
            spannablestringbuilder.append(((dza) (obj)).b);
            int l;
            byte byte0;
            if (((dza) (obj)).c)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            if (((dza) (obj)).d)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            l |= byte0;
            if (l != 0)
            {
                spannablestringbuilder.setSpan(new StyleSpan(l), i, k, 33);
            }
            if (((dza) (obj)).f)
            {
                spannablestringbuilder.setSpan(new byg(), i, k, 33);
            }
            if (false && false && ((dza) (obj)).e != null)
            {
                dlb1 = ((dza) (obj)).e;
                throw new NullPointerException();
            }
            l = k;
            i = k;
            k = l;
            j++;
        }
        return spannablestringbuilder;
    }

    public static dlb a(long l)
    {
        dlb dlb1 = new dlb();
        dza dza1 = new dza();
        dza1.b = NumberFormat.getInstance().format(l);
        dlb1.b = (new dza[] {
            dza1
        });
        return dlb1;
    }

    public static transient dlb a(String as[])
    {
        dlb dlb1 = new dlb();
        int j = as.length;
        dza adza[] = new dza[j];
        for (int i = 0; i < j; i++)
        {
            dza dza1 = new dza();
            dza1.b = as[i];
            adza[i] = dza1;
        }

        dlb1.b = adza;
        return dlb1;
    }

    public static dza a()
    {
        dza dza1 = new dza();
        dza1.c = true;
        return dza1;
    }
}
