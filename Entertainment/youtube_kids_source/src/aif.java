// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Build;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class aif extends bmr
{

    private ahs a;

    aif(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        android.content.Context context = ahs.e(a);
        bmi bmi = ahs.c(a).b();
        bkn bkn = ahs.c(a).h();
        android.content.SharedPreferences sharedpreferences = ahs.c(a).i();
        ahs ahs1 = a;
        String s = ahs.f(a);
        Object obj = String.valueOf(Build.MANUFACTURER.toUpperCase());
        String s1 = String.valueOf(Build.MODEL);
        s1 = (new StringBuilder(String.valueOf(obj).length() + 1 + String.valueOf(s1).length())).append(((String) (obj))).append(" ").append(s1).toString();
        HashMap hashmap;
        if (a.c(ahs1.a))
        {
            obj = "tablet";
        } else
        {
            obj = "phone";
        }
        obj = String.format("android-%s-%s", new Object[] {
            obj, a.g(ahs1.a)
        });
        hashmap = new HashMap();
        hashmap.put("device", cgh.a.name());
        hashmap.put("id", s);
        hashmap.put("name", s1);
        hashmap.put("app", obj);
        hashmap.put("mdx-version", "3");
        hashmap.put("theme", ahs1.d.b);
        if (!ahs1.e.a().isEmpty())
        {
            hashmap.put("capabilities", TextUtils.join(",", ahs1.e.a()));
        }
        obj = Collections.unmodifiableMap(hashmap);
        obj = new akj(context, bmi, bkn, sharedpreferences, new cei(ahs1.h(), ahs1.c(), a.B(), a.y(), ahs1.i(), ((Map) (obj))), a.b(), ahs.g(a), a.i(), a.h(), ahs.f(a), ahs.h(a).t(), ahs.b(a).a.c, ahs.a(a));
        ahs.c(a).d().a(obj);
        return obj;
    }
}
