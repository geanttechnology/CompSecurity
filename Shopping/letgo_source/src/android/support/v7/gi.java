// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.parse.ParseUser;
import java.util.Map;

public interface gi
{

    public abstract void a();

    public abstract void a(Activity activity);

    public abstract void a(Application application);

    public abstract void a(Context context, String s, Map map, ParseUser parseuser);

    public abstract void a(ParseUser parseuser);

    public abstract void b();

    public abstract void b(Activity activity);

    public abstract void b(Context context, String s, Map map, ParseUser parseuser);

    public abstract void c(Activity activity);

    public abstract void d(Activity activity);

    public abstract void e(Activity activity);

    public abstract void f(Activity activity);
}
