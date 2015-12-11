// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.a.h;

public class com.target.ui.fragment.product.search.a
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(String s);

        public abstract void b(String s);

        public abstract void c(String s);
    }

    public static class b
    {

        private final BroadcastReceiver mBroadcastReceiver;

        public BroadcastReceiver a()
        {
            return mBroadcastReceiver;
        }

        b(BroadcastReceiver broadcastreceiver)
        {
            mBroadcastReceiver = broadcastreceiver;
        }
    }

    private static final class c extends Enum
    {

        private static final c $VALUES[];
        public static final c NONE;
        public static final c SEARCH_BY_TEXT;
        public static final c SEARCH_BY_VOICE;
        public static final c SEARCH_CLEARED;
        public static final c SEARCH_EDIT;

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/target/ui/fragment/product/search/a$c, s);
        }

        public static c[] values()
        {
            return (c[])$VALUES.clone();
        }

        static 
        {
            SEARCH_BY_VOICE = new c("SEARCH_BY_VOICE", 0);
            SEARCH_BY_TEXT = new c("SEARCH_BY_TEXT", 1);
            SEARCH_EDIT = new c("SEARCH_EDIT", 2);
            SEARCH_CLEARED = new c("SEARCH_CLEARED", 3);
            NONE = new c("NONE", 4);
            $VALUES = (new c[] {
                SEARCH_BY_VOICE, SEARCH_BY_TEXT, SEARCH_EDIT, SEARCH_CLEARED, NONE
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String SEARCH_INTENT_EVENT = "search_broadcast_intent";
    private static final String SEARCH_INTENT_SEARCH_BY_TEXT = "search_by_text";
    private static final String SEARCH_INTENT_SEARCH_BY_VOICE = "search_by_voice";
    private static final String SEARCH_INTENT_SEARCH_TYPE = "search_type";

    public static b a(Context context, a a1)
    {
        a1 = new BroadcastReceiver(a1) {

            final a val$listener;

            public void onReceive(Context context1, Intent intent)
            {
                if (listener == null)
                {
                    return;
                }
                static class _cls2
                {

                    static final int $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType[];

                    static 
                    {
                        $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType = new int[c.values().length];
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType[c.SEARCH_CLEARED.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType[c.SEARCH_BY_TEXT.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType[c.SEARCH_BY_VOICE.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$target$ui$fragment$product$search$SearchBroadcast$SearchType[c.SEARCH_EDIT.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls2..SwitchMap.com.target.ui.fragment.product.search.SearchBroadcast.SearchType[com.target.ui.fragment.product.search.a.a(intent).ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    listener.a();
                    return;

                case 2: // '\002'
                    listener.a(com.target.ui.fragment.product.search.a.b(intent));
                    return;

                case 3: // '\003'
                    listener.c(com.target.ui.fragment.product.search.a.c(intent));
                    return;

                case 4: // '\004'
                    listener.b(com.target.ui.fragment.product.search.a.b(intent));
                    break;
                }
            }

            
            {
                listener = a1;
                super();
            }
        };
        b b1 = new b(a1);
        h.a(context).a(a1, new IntentFilter("search_broadcast_intent"));
        return b1;
    }

    static c a(Intent intent)
    {
        return d(intent);
    }

    public static void a(Context context)
    {
        Intent intent = new Intent("search_broadcast_intent");
        intent.putExtra("search_type", c.SEARCH_CLEARED.ordinal());
        h.a(context).a(intent);
    }

    public static void a(Context context, b b1)
    {
        if (b1 == null)
        {
            return;
        } else
        {
            h.a(context).a(b1.a());
            return;
        }
    }

    public static void a(Context context, String s)
    {
        Intent intent = new Intent("search_broadcast_intent");
        intent.putExtra("search_by_voice", s);
        intent.putExtra("search_type", c.SEARCH_BY_VOICE.ordinal());
        h.a(context).a(intent);
    }

    static String b(Intent intent)
    {
        return e(intent);
    }

    public static void b(Context context, String s)
    {
        Intent intent = new Intent("search_broadcast_intent");
        intent.putExtra("search_by_text", s);
        intent.putExtra("search_type", c.SEARCH_BY_TEXT.ordinal());
        h.a(context).a(intent);
    }

    static String c(Intent intent)
    {
        return f(intent);
    }

    public static void c(Context context, String s)
    {
        Intent intent = new Intent("search_broadcast_intent");
        intent.putExtra("search_by_text", s);
        intent.putExtra("search_type", c.SEARCH_EDIT.ordinal());
        h.a(context).a(intent);
    }

    private static c d(Intent intent)
    {
        if (intent == null)
        {
            return c.NONE;
        } else
        {
            return c.values()[intent.getIntExtra("search_type", c.NONE.ordinal())];
        }
    }

    private static String e(Intent intent)
    {
        if (intent == null)
        {
            intent = "";
        } else
        {
            String s = intent.getStringExtra("search_by_text");
            intent = s;
            if (s == null)
            {
                return "";
            }
        }
        return intent;
    }

    private static String f(Intent intent)
    {
        if (intent == null)
        {
            intent = "";
        } else
        {
            String s = intent.getStringExtra("search_by_voice");
            intent = s;
            if (s == null)
            {
                return "";
            }
        }
        return intent;
    }
}
