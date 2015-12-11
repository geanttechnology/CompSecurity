// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import com.google.a.a.e;

// Referenced classes of package com.target.ui.util.deep_link:
//            e

public class f
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a PROMOTION;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/deep_link/f$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            PROMOTION = new a("PROMOTION", 0);
            $VALUES = (new a[] {
                PROMOTION
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b CUSTOM_ACTION;
        public static final b DIALOG_FRAGMENT;
        public static final b FRAGMENT;
        public static final b NONE;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/util/deep_link/f$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            CUSTOM_ACTION = new b("CUSTOM_ACTION", 0);
            DIALOG_FRAGMENT = new b("DIALOG_FRAGMENT", 1);
            FRAGMENT = new b("FRAGMENT", 2);
            NONE = new b("NONE", 3);
            $VALUES = (new b[] {
                CUSTOM_ACTION, DIALOG_FRAGMENT, FRAGMENT, NONE
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private final a mCustomAction;
    private final com.target.ui.util.deep_link.e mDeepLinkArguments;
    private final DialogFragment mDialogResult;
    private final Fragment mFragmentResult;
    private final b mReportType;
    private final Uri mUri;

    public f(Uri uri)
    {
        this(uri, null, null, null, new com.target.ui.util.deep_link.e(), b.NONE);
    }

    public f(Uri uri, DialogFragment dialogfragment)
    {
        this(uri, null, dialogfragment, null, new com.target.ui.util.deep_link.e(), b.DIALOG_FRAGMENT);
    }

    public f(Uri uri, Fragment fragment)
    {
        this(uri, fragment, new com.target.ui.util.deep_link.e());
    }

    private f(Uri uri, Fragment fragment, DialogFragment dialogfragment, a a1, com.target.ui.util.deep_link.e e1, b b1)
    {
        mUri = uri;
        mFragmentResult = fragment;
        mCustomAction = a1;
        mDialogResult = dialogfragment;
        mDeepLinkArguments = e1;
        mReportType = b1;
    }

    public f(Uri uri, Fragment fragment, com.target.ui.util.deep_link.e e1)
    {
        this(uri, fragment, null, null, e1, b.FRAGMENT);
    }

    public f(Uri uri, a a1, com.target.ui.util.deep_link.e e1)
        throws IllegalArgumentException
    {
        this(uri, null, null, a1, e1, b.CUSTOM_ACTION);
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[];

            static 
            {
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[a.PROMOTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.CustomAction[a1.ordinal()])
        {
        default:
            throw new IllegalArgumentException("Unknown CUSTOM_ACTION");

        case 1: // '\001'
            break;
        }
        if (!e1.c().b())
        {
            throw new IllegalArgumentException("PROMOTION missing PromotionParams");
        } else
        {
            return;
        }
    }

    public e a()
    {
        return com.google.a.a.e.c(mCustomAction);
    }

    public com.target.ui.util.deep_link.e b()
    {
        return mDeepLinkArguments;
    }

    public e c()
    {
        return com.google.a.a.e.c(mDialogResult);
    }

    public e d()
    {
        return com.google.a.a.e.c(mFragmentResult);
    }

    public b e()
    {
        return mReportType;
    }

    public e f()
    {
        return com.google.a.a.e.c(mUri);
    }
}
