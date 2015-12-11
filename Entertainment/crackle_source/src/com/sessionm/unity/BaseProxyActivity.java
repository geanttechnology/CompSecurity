// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BaseProxyActivity extends Activity
{

    public BaseProxyActivity()
    {
    }

    protected static void copyPlayerPrefs(Context context, String as[])
    {
        if (context.getSharedPreferences(context.getPackageName(), 0).getAll().isEmpty())
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName(), 0).edit();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = as[i];
                if (!context.getSharedPreferences(((String) (obj)), 0).getAll().isEmpty())
                {
                    obj = context.getSharedPreferences(((String) (obj)), 0).getAll();
                    Iterator iterator = ((Map) (obj)).entrySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)obj).next();
                        Object obj1 = entry.getValue();
                        if (obj1.getClass() == java/lang/Integer)
                        {
                            ((android.content.SharedPreferences.Editor)editor).putInt((String)entry.getKey(), ((Integer)obj1).intValue());
                        } else
                        if (obj1.getClass() == java/lang/Float)
                        {
                            ((android.content.SharedPreferences.Editor)editor).putFloat((String)entry.getKey(), ((Float)obj1).floatValue());
                        } else
                        if (obj1.getClass() == java/lang/String)
                        {
                            ((android.content.SharedPreferences.Editor)editor).putString((String)entry.getKey(), (String)obj1);
                        }
                    } while (true);
                    ((android.content.SharedPreferences.Editor)editor).commit();
                }
                i++;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        i = 1;
        super.onCreate(bundle);
        Bundle bundle1;
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            i = 0;
        }
        bundle = new Intent(this, Class.forName((new String[] {
            "com.sessionm.unity.BaseActivity", "com.sessionm.unity.BaseNativeActivity"
        })[i]));
        bundle.addFlags(0x10000);
        bundle1 = getIntent().getExtras();
        if (bundle1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        bundle.putExtras(bundle1);
        startActivity(bundle);
        finish();
        return;
        bundle;
        finish();
        return;
        bundle;
        finish();
        throw bundle;
    }
}
