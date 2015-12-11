// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;

class SharedPreferencesUtil
{

    SharedPreferencesUtil()
    {
    }

    static void saveAsync(Context context, String s, String s1, String s2)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.putString(s1, s2);
        saveEditorAsync(context);
    }

    static void saveEditorAsync(android.content.SharedPreferences.Editor editor)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            editor.apply();
            return;
        } else
        {
            (new Thread(new Runnable(editor) {

                final android.content.SharedPreferences.Editor val$editor;

                public void run()
                {
                    editor.commit();
                }

            
            {
                editor = editor1;
                super();
            }
            })).start();
            return;
        }
    }
}
