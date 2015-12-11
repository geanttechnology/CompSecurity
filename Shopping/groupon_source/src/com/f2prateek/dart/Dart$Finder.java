// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.f2prateek.dart;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.f2prateek.dart:
//            Dart

public static abstract class <init> extends Enum
{

    private static final BUNDLE $VALUES[];
    public static final BUNDLE ACTIVITY;
    public static final BUNDLE BUNDLE;
    public static final BUNDLE FRAGMENT;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/f2prateek/dart/Dart$Finder, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    public abstract Object getExtra(Object obj, String s);

    static 
    {
        ACTIVITY = new Dart.Finder("ACTIVITY", 0) {

            public Object getExtra(Object obj, String s)
            {
                obj = ((Activity)obj).getIntent();
                if (obj == null)
                {
                    return null;
                } else
                {
                    return Dart.Finder.BUNDLE.getExtra(((Intent) (obj)).getExtras(), s);
                }
            }

        };
        FRAGMENT = new Dart.Finder("FRAGMENT", 1) {

            public Object getExtra(Object obj, String s)
            {
                obj = ((Fragment)obj).getArguments();
                return Dart.Finder.BUNDLE.getExtra(obj, s);
            }

        };
        BUNDLE = new Dart.Finder("BUNDLE", 2) {

            public Object getExtra(Object obj, String s)
            {
                if (obj == null)
                {
                    return null;
                } else
                {
                    return ((Bundle)obj).get(s);
                }
            }

        };
        $VALUES = (new .VALUES[] {
            ACTIVITY, FRAGMENT, BUNDLE
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
