// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.a;
import com.smule.android.f.p;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.au;
import com.smule.android.network.managers.d;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.PerformanceV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.magicpiano.DailyChallengeActivity;
import com.smule.pianoandroid.magicpiano.GameStatsActivity;
import com.smule.pianoandroid.magicpiano.GlobeActivity;
import com.smule.pianoandroid.magicpiano.LevelProgressActivity;
import com.smule.pianoandroid.magicpiano.MagicActivity;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.PianoWebActivity;
import com.smule.pianoandroid.magicpiano.PreSongActivity;
import com.smule.pianoandroid.magicpiano.ProductListActivity;
import com.smule.pianoandroid.magicpiano.ProductListFragment;
import com.smule.pianoandroid.magicpiano.PurchaseActivity_;
import com.smule.pianoandroid.magicpiano.SettingsActivity;
import com.smule.pianoandroid.magicpiano.SoloActivity;
import com.smule.pianoandroid.magicpiano.ac;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.ap;
import com.smule.pianoandroid.magicpiano.ar;
import com.smule.pianoandroid.magicpiano.n;
import com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity;
import com.smule.pianoandroid.magicpiano.registration.b;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.smule.pianoandroid.utils:
//            z, r, q, j, 
//            i, p

public class o
{

    public static final String a = com/smule/pianoandroid/utils/o.getName();
    public static final UriMatcher b;
    public static long c = 0L;
    public static Boolean d;
    public static Boolean e;
    private static Context f;

    public o()
    {
    }

    public static Dialog a(Context context, String s, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        Dialog dialog = new Dialog(context, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        View view = ((Activity)context).getLayoutInflater().inflate(0x7f03004c, null, false);
        ((TextView)view.findViewById(0x7f0a0037)).setTypeface(z.c(context));
        Button button = (Button)view.findViewById(0x7f0a0183);
        button.setTypeface(com.smule.pianoandroid.utils.z.d(context));
        if (s != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f0a0118);
            textview.setTypeface(com.smule.pianoandroid.utils.z.e(context));
            textview.setText(s);
        } else
        {
            Log.e(a, "no email set for dialog!");
        }
        button.setOnClickListener(new android.view.View.OnClickListener(dialog, onclicklistener) {

            final Dialog a;
            final android.view.View.OnClickListener b;

            public void onClick(View view1)
            {
                a.dismiss();
                b.onClick(view1);
            }

            
            {
                a = dialog;
                b = onclicklistener;
                super();
            }
        });
        s = (Button)view.findViewById(0x7f0a0184);
        s.setTypeface(com.smule.pianoandroid.utils.z.d(context));
        s.setOnClickListener(new android.view.View.OnClickListener(dialog, onclicklistener1) {

            final Dialog a;
            final android.view.View.OnClickListener b;

            public void onClick(View view1)
            {
                a.dismiss();
                b.onClick(view1);
            }

            
            {
                a = dialog;
                b = onclicklistener;
                super();
            }
        });
        dialog.setContentView(view);
        dialog.show();
        return dialog;
    }

    public static Dialog a(Context context, String s, String s1, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        Dialog dialog = new Dialog(context, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        View view = ((Activity)context).getLayoutInflater().inflate(0x7f030038, null, false);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.show();
        ((TextView)view.findViewById(0x7f0a0037)).setTypeface(z.c(context));
        TextView textview = (TextView)view.findViewById(0x7f0a0117);
        textview.setTypeface(com.smule.pianoandroid.utils.z.a(context));
        if (s != null)
        {
            textview.setText(s);
        } else
        {
            textview.setVisibility(4);
        }
        s = (TextView)view.findViewById(0x7f0a0118);
        s.setTypeface(com.smule.pianoandroid.utils.z.b(context));
        s.setText((new StringBuilder()).append("(").append(s1.toString()).append(")").toString());
        s = (Button)view.findViewById(0x7f0a011a);
        s.setTypeface(com.smule.pianoandroid.utils.z.d(context));
        s.setOnClickListener(onclicklistener1);
        s = (Button)view.findViewById(0x7f0a011b);
        s.setTypeface(com.smule.pianoandroid.utils.z.d(context));
        s.setOnClickListener(onclicklistener);
        return dialog;
    }

    public static void a()
    {
        if (!d.booleanValue())
        {
            d = Boolean.valueOf(true);
            p.a(f.getSharedPreferences("magic_piano_prefs", 0).edit().putBoolean("SONG_HAS_BEEN_PLAYED", d.booleanValue()));
        }
    }

    public static void a(Activity activity, int k, String s, Runnable runnable)
    {
        activity = n.a(activity, 0x7f0200f3, activity.getString(0x7f0c02db), null, String.format(activity.getString(0x7f0c02c3), new Object[] {
            s, Integer.valueOf(k), Integer.valueOf(k)
        }), activity.getString(0x7f0c0042), activity.getString(0x7f0c01e0), null, runnable);
        activity.setCancelable(true);
        activity.show();
    }

    public static void a(Activity activity, Uri uri)
    {
        int k;
        Log.d(a, (new StringBuilder()).append("Deep linking uri ").append(uri).toString());
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.i);
        if ("http".equals(uri.getScheme()) || "https".equals(uri.getScheme()))
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            activity.startActivity(intent);
            return;
        }
        k = b.match(uri);
        Log.d(a, (new StringBuilder()).append("Deep link type ").append(k).toString());
        k;
        JVM INSTR tableswitch 0 24: default 236
    //                   0 320
    //                   1 278
    //                   2 278
    //                   3 278
    //                   4 335
    //                   5 424
    //                   6 236
    //                   7 370
    //                   8 370
    //                   9 439
    //                   10 236
    //                   11 335
    //                   12 463
    //                   13 409
    //                   14 236
    //                   15 236
    //                   16 278
    //                   17 278
    //                   18 478
    //                   19 493
    //                   20 493
    //                   21 508
    //                   22 532
    //                   23 547
    //                   24 559;
           goto _L1 _L2 _L3 _L3 _L3 _L4 _L5 _L1 _L6 _L6 _L7 _L1 _L4 _L8 _L9 _L1 _L1 _L3 _L3 _L10 _L11 _L11 _L12 _L13 _L14 _L15
_L15:
        break MISSING_BLOCK_LABEL_559;
_L1:
        Log.e("Notification", (new StringBuilder()).append("Unrecognized push notification! Uri : ").append(uri).toString());
        activity.overridePendingTransition(0x7f040014, 0x7f04001b);
        e(activity);
        return;
_L3:
        Intent intent1 = new Intent(activity.getApplicationContext(), com/smule/pianoandroid/magicpiano/ProductListActivity);
_L16:
        intent1.setData(uri);
        intent1.addFlags(0x4000000);
        q.B();
        activity.startActivity(intent1);
        activity.finish();
        return;
_L2:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/ProductListActivity);
        continue; /* Loop/switch isn't completed */
_L4:
        Intent intent2 = new Intent(activity, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
        intent1 = intent2;
        if (k == 11)
        {
            intent2.putExtra("SHOW_SPONSORPAY", true);
            intent1 = intent2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (UserManager.n().h())
        {
            intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/SettingsActivity);
        } else
        {
            intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/ProductListActivity);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/SettingsActivity);
        continue; /* Loop/switch isn't completed */
_L5:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/GlobeActivity);
        continue; /* Loop/switch isn't completed */
_L7:
        uri = new Runnable(activity) {

            final Activity a;

            public void run()
            {
                a.overridePendingTransition(0x7f040014, 0x7f04001b);
                com.smule.pianoandroid.utils.o.e(a);
            }

            
            {
                a = activity;
                super();
            }
        };
        a(activity, ((Runnable) (uri)), ((Runnable) (uri)), activity.getString(0x7f0c021c), ((String) (null)));
        return;
_L8:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
        continue; /* Loop/switch isn't completed */
_L10:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/SoloActivity);
        continue; /* Loop/switch isn't completed */
_L11:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/GameStatsActivity);
        continue; /* Loop/switch isn't completed */
_L12:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/GameStatsActivity);
        intent1.putExtra("SHOW_COMPLETED", true);
        continue; /* Loop/switch isn't completed */
_L13:
        intent1 = new Intent(activity, com/smule/pianoandroid/magicpiano/LevelProgressActivity);
        if (true) goto _L16; else goto _L14
_L14:
        PianoWebActivity.a(activity, PianoWebActivity.f);
        activity.finish();
        return;
        PianoWebActivity.a(activity, PianoWebActivity.g);
        activity.finish();
        return;
    }

    public static void a(Activity activity, com.smule.android.network.models.ContestData.ContestInfo contestinfo)
    {
        Dialog dialog = new Dialog(activity, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        View view = activity.getLayoutInflater().inflate(0x7f030026, null, false);
        com.smule.pianoandroid.utils.j.a(view, activity);
        view.findViewById(0x7f0a0088).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;

            public void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = dialog;
                super();
            }
        });
        activity = MessageFormat.format(activity.getString(0x7f0c004b), new Object[] {
            contestinfo.contest.numWinners
        });
        ((TextView)view.findViewById(0x7f0a006d)).setText(activity);
        view.findViewById(0x7f0a002a).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;

            public void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = dialog;
                super();
            }
        });
        activity = contestinfo.contest.rewards.iterator();
        do
        {
            if (!activity.hasNext())
            {
                break;
            }
            contestinfo = (com.smule.android.network.models.ContestData.Reward)activity.next();
            if (!((com.smule.android.network.models.ContestData.Reward) (contestinfo)).type.equals("SONG"))
            {
                continue;
            }
            activity = ak.a().a(((com.smule.android.network.models.ContestData.Reward) (contestinfo)).value);
            if (activity != null)
            {
                ((TextView)view.findViewById(0x7f0a0096)).setText(((SongV2) (activity)).title);
                ((TextView)view.findViewById(0x7f0a009f)).setText(((SongV2) (activity)).artist);
            }
            break;
        } while (true);
        dialog.setContentView(view);
        dialog.show();
    }

    public static void a(Activity activity, ListingV2 listingv2)
    {
        com.smule.pianoandroid.utils.q.a(listingv2.productId, ProductListFragment.a, listingv2.price);
        n n1 = n.a(activity, 0x7f020120, MessageFormat.format(activity.getString(0x7f0c0190), new Object[] {
            Integer.valueOf(listingv2.price - com.smule.android.network.managers.d.a().e())
        }), null, activity.getString(0x7f0c0126), activity.getString(0x7f0c0124), activity.getString(0x7f0c0025), null, null);
        n1.a(new Runnable(activity, n1) {

            final Activity a;
            final n b;

            public void run()
            {
                String s = com.smule.android.network.managers.a.a().a("piandroid.offers", "free_smoola_button_offers", "tapjoy");
                ap.a(a, (ViewGroup)b.findViewById(0x7f0a0063), s);
                b.dismiss();
            }

            
            {
                a = activity;
                b = n1;
                super();
            }
        });
        n1.b(new Runnable(activity, listingv2, n1) {

            final Activity a;
            final ListingV2 b;
            final n c;

            public void run()
            {
                List list = com.smule.android.network.managers.ap.a().f();
                if (r.a(a) && list != null && !list.isEmpty())
                {
                    Intent intent = new Intent(a, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
                    intent.putExtra(com.smule.pianoandroid.utils.i.a, b.listingId);
                    intent.putExtra(com.smule.pianoandroid.utils.i.b, b.b());
                    a.startActivityForResult(intent, 214);
                    a.overridePendingTransition(0x7f040013, 0x7f040015);
                } else
                {
                    com.smule.android.network.core.b.d().p();
                }
                c.dismiss();
            }

            
            {
                a = activity;
                b = listingv2;
                c = n1;
                super();
            }
        });
        n1.setCancelable(true);
        n1.show();
    }

    public static void a(Activity activity, ListingV2 listingv2, Integer integer, Runnable runnable)
    {
        String s2 = activity.getString(0x7f0c02c0);
        String s;
        String s1;
        boolean flag;
        if (listingv2.isFree || listingv2.price <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = activity.getString(0x7f0c0042);
        s = activity.getString(0x7f0c02bf);
        if (integer != null && flag)
        {
            activity.getString(0x7f0c0046);
            s1 = activity.getString(0x7f0c01c0);
            if (Locale.getDefault().getLanguage().compareTo(Locale.KOREA.getLanguage()) == 0 || Locale.getDefault().getLanguage().compareTo(Locale.JAPAN.getLanguage()) == 0)
            {
                integer = String.format(activity.getString(0x7f0c02be), new Object[] {
                    Integer.valueOf(com.smule.pianoandroid.e.e.a().f()), listingv2.song.title, integer
                });
                s = null;
            } else
            {
                integer = String.format(activity.getString(0x7f0c02be), new Object[] {
                    Integer.valueOf(com.smule.pianoandroid.e.e.a().f()), integer, listingv2.song.title
                });
                s = null;
            }
        } else
        if (integer != null && !flag)
        {
            if (Locale.getDefault().getLanguage().compareTo(Locale.KOREA.getLanguage()) == 0 || Locale.getDefault().getLanguage().compareTo(Locale.JAPAN.getLanguage()) == 0)
            {
                integer = String.format(activity.getString(0x7f0c02c1), new Object[] {
                    integer, Integer.valueOf(listingv2.price), listingv2.song.title
                });
            } else
            {
                integer = String.format(activity.getString(0x7f0c02c1), new Object[] {
                    integer, listingv2.song.title, Integer.valueOf(listingv2.price)
                });
            }
        } else
        {
            if (flag)
            {
                b(listingv2, activity, runnable);
                return;
            }
            if (com.smule.android.network.managers.d.a().e() < listingv2.price)
            {
                a(activity, listingv2);
                return;
            } else
            {
                com.smule.pianoandroid.magicpiano.e.a(activity, listingv2, runnable).show();
                return;
            }
        }
        if (s != null)
        {
            listingv2 = new Runnable(listingv2, activity, runnable) {

                final ListingV2 a;
                final Activity b;
                final Runnable c;

                public void run()
                {
                    com.smule.pianoandroid.utils.o.a(a, b, c);
                }

            
            {
                a = listingv2;
                b = activity;
                c = runnable;
                super();
            }
            };
        } else
        {
            listingv2 = null;
        }
        activity = n.a(activity, 0x7f020120, s2, null, integer, s1, s, null, listingv2);
        activity.setCancelable(true);
        activity.show();
    }

    public static void a(Activity activity, Runnable runnable, Runnable runnable1, String s, String s1)
    {
        if (UserManager.n().h())
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            com.smule.pianoandroid.magicpiano.registration.e.a();
            com.smule.pianoandroid.magicpiano.registration.e.a(runnable);
            com.smule.pianoandroid.magicpiano.registration.e.b(runnable1);
            runnable = RegistrationEntryActivity.a(activity, false, true, null, null, s);
            runnable.putExtra("SIGN_IN_MESSAGE", s1);
            activity.startActivity(runnable);
            return;
        }
    }

    public static void a(Activity activity, boolean flag, Runnable runnable)
    {
        if (UserManager.n().h())
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            com.smule.android.c.a.a(false);
            com.smule.pianoandroid.magicpiano.registration.e.a();
            com.smule.pianoandroid.magicpiano.registration.e.a(runnable);
            activity.startActivity(RegistrationEntryActivity.a(activity, false, flag, null, null, null));
            return;
        }
    }

    public static void a(Context context)
    {
        f = context;
        context = f.getSharedPreferences("magic_piano_prefs", 0);
        e = Boolean.valueOf(context.getBoolean("DC_MODAL_SHOWN", false));
        d = Boolean.valueOf(context.getBoolean("SONG_HAS_BEEN_PLAYED", false));
    }

    public static void a(Context context, int k, int l)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(context.getResources().getString(k)).setCancelable(true).setPositiveButton(context.getResources().getString(l), new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

        });
        builder.create().show();
    }

    public static void a(Context context, boolean flag, int k, String s, String s1, String s2, String s3)
    {
        Intent intent;
        if (flag)
        {
            intent = new Intent(context, com/smule/pianoandroid/magicpiano/MagicActivity);
            intent.putExtra("SONG_DIFFICULTY", 3);
        } else
        if (com.smule.pianoandroid.utils.i.d().b() && !com.smule.pianoandroid.magicpiano.c.a.a().h())
        {
            intent = new Intent(context, com/smule/pianoandroid/magicpiano/MagicActivity);
            intent.putExtra("SONG_DIFFICULTY", 1);
        } else
        {
            intent = new Intent(context, com/smule/pianoandroid/magicpiano/PreSongActivity);
        }
        intent.putExtra("SONG_MODE", k);
        intent.putExtra("CREATE_ACTIVITY_ON_FINISH", false);
        intent.putExtra("SONG_MIDI_EXTRA", s);
        intent.putExtra("SONG_NAME_EXTRA", s1);
        intent.putExtra("SONG_UID_EXTRA", s2);
        intent.putExtra("SONG_COMPOSER_EXTRA", s3);
        intent.putExtra("SONG_OWNED", Boolean.valueOf(i.a().c(s2)));
        if (flag)
        {
            ((Activity)context).startActivityForResult(intent, 213);
            return;
        } else
        {
            context.startActivity(intent);
            return;
        }
    }

    public static void a(FragmentActivity fragmentactivity, Runnable runnable, Runnable runnable1)
    {
        com.smule.pianoandroid.magicpiano.registration.e.a();
        com.smule.pianoandroid.magicpiano.registration.e.a(runnable);
        com.smule.pianoandroid.magicpiano.registration.e.b(runnable1);
        b b1 = new b(fragmentactivity);
        b1.a(fragmentactivity.getString(0x7f0c0054), "");
        ((ag)fragmentactivity).p = b1;
        b1.a(new Runnable(fragmentactivity, runnable, runnable1) {

            final FragmentActivity a;
            final Runnable b;
            final Runnable c;

            public void run()
            {
                com.smule.pianoandroid.utils.o.a(a, b, c);
            }

            
            {
                a = fragmentactivity;
                b = runnable;
                c = runnable1;
                super();
            }
        });
        UserManager.n().a(new NavigationUtils._cls23(fragmentactivity, b1, runnable1));
    }

    public static void a(FragmentActivity fragmentactivity, Runnable runnable, Runnable runnable1, String s, String s1)
    {
        if (UserManager.n().h())
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            com.smule.pianoandroid.magicpiano.registration.e.a();
            com.smule.pianoandroid.magicpiano.registration.e.a(runnable);
            com.smule.pianoandroid.magicpiano.registration.e.b(runnable1);
            ar.a(fragmentactivity, s, s1, runnable1).show();
            q.t();
            return;
        }
    }

    public static void a(EditText edittext, Button button)
    {
        a(edittext, ((EditText) (null)), button);
    }

    public static void a(EditText edittext, EditText edittext1, Button button)
    {
        edittext.addTextChangedListener(new TextWatcher(edittext, edittext1, button) {

            final EditText a;
            final EditText b;
            final Button c;

            public void afterTextChanged(Editable editable)
            {
                com.smule.pianoandroid.utils.o.b(a, b, c);
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            
            {
                a = edittext;
                b = edittext1;
                c = button;
                super();
            }
        });
        if (edittext1 != null)
        {
            edittext1.addTextChangedListener(new TextWatcher(edittext, edittext1, button) {

                final EditText a;
                final EditText b;
                final Button c;

                public void afterTextChanged(Editable editable)
                {
                    com.smule.pianoandroid.utils.o.b(a, b, c);
                }

                public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
                {
                }

                public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
                {
                }

            
            {
                a = edittext;
                b = edittext1;
                c = button;
                super();
            }
            });
        }
        android.widget.TextView.OnEditorActionListener oneditoractionlistener = new android.widget.TextView.OnEditorActionListener(button) {

            final Button a;

            public boolean onEditorAction(TextView textview, int k, KeyEvent keyevent)
            {
                if (a.isEnabled())
                {
                    a.performClick();
                }
                return true;
            }

            
            {
                a = button;
                super();
            }
        };
        if (edittext1 != null)
        {
            edittext1.setOnEditorActionListener(oneditoractionlistener);
        } else
        {
            edittext.setOnEditorActionListener(oneditoractionlistener);
        }
        c(edittext, edittext1, button);
    }

    static void a(ListingV2 listingv2, Activity activity, Runnable runnable)
    {
        b(listingv2, activity, runnable);
    }

    public static boolean a(Activity activity)
    {
        return r.a(activity) && UserManager.n().h();
    }

    public static boolean a(Activity activity, Runnable runnable)
    {
        if (!r.a(activity))
        {
            ((MagicApplication)(MagicApplication)activity.getApplicationContext()).showToast(activity.getResources().getString(0x7f0c0045), 0);
            return false;
        }
        if (UserManager.n().h())
        {
            return true;
        } else
        {
            b(activity, runnable);
            return false;
        }
    }

    public static Dialog b(Activity activity, boolean flag, Runnable runnable)
    {
        String s;
        String s1;
        if (flag)
        {
            s = activity.getString(0x7f0c0223);
            s1 = com.smule.android.network.managers.a.a().a("piandroid.offers", "fb-login.reward", "0");
            int k;
            try
            {
                k = ((JsonNode)com.smule.android.f.e.a().readValue(s1, com/fasterxml/jackson/databind/JsonNode)).intValue();
            }
            catch (IOException ioexception)
            {
                Log.e(a, "IOException attempting to read fb-login settings");
                k = 0;
            }
            if (k == 0)
            {
                if (runnable != null)
                {
                    runnable.run();
                }
                return null;
            }
            ioexception = String.format(activity.getString(0x7f0c0222), new Object[] {
                Integer.valueOf(k)
            });
        } else
        {
            s = activity.getString(0x7f0c0221);
            ioexception = activity.getString(0x7f0c0220);
        }
        activity = n.a(activity, 0x7f02010e, s, null, ioexception, activity.getString(0x7f0c01c0), null, runnable, null);
        activity.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(runnable) {

            final Runnable a;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (a != null)
                {
                    a.run();
                }
            }

            
            {
                a = runnable;
                super();
            }
        });
        activity.show();
        return activity;
    }

    public static void b()
    {
        if (!e.booleanValue())
        {
            e = Boolean.valueOf(true);
            p.a(f.getSharedPreferences("magic_piano_prefs", 0).edit().putBoolean("DC_MODAL_SHOWN", e.booleanValue()));
        }
    }

    public static void b(Activity activity)
    {
        if (e.booleanValue() || !d.booleanValue())
        {
            return;
        } else
        {
            Dialog dialog = new Dialog(activity, 0x7f0d007f);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View view = activity.getLayoutInflater().inflate(0x7f030028, null, false);
            com.smule.pianoandroid.utils.j.a(view, activity);
            view.findViewById(0x7f0a0088).setOnClickListener(new android.view.View.OnClickListener(dialog) {

                final Dialog a;

                public void onClick(View view1)
                {
                    a.dismiss();
                }

            
            {
                a = dialog;
                super();
            }
            });
            Object obj = MessageFormat.format(activity.getString(0x7f0c004e), new Object[] {
                Integer.valueOf(com.smule.android.network.managers.e.j())
            });
            ((TextView)view.findViewById(0x7f0a00aa)).setText(((CharSequence) (obj)));
            view.findViewById(0x7f0a008b).setOnClickListener(new android.view.View.OnClickListener(dialog) {

                final Dialog a;

                public void onClick(View view1)
                {
                    a.dismiss();
                }

            
            {
                a = dialog;
                super();
            }
            });
            view.findViewById(0x7f0a008c).setOnClickListener(new android.view.View.OnClickListener(dialog, activity) {

                final Dialog a;
                final Activity b;

                public void onClick(View view1)
                {
                    a.dismiss();
                    view1 = new Intent(b.getApplicationContext(), com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
                    b.startActivity(view1);
                    b.finish();
                }

            
            {
                a = dialog;
                b = activity;
                super();
            }
            });
            obj = (ToggleButton)view.findViewById(0x7f0a00ad);
            com.smule.pianoandroid.utils.z.a(((View) (obj)), com.smule.pianoandroid.utils.z.e(activity));
            ((ToggleButton) (obj)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    compoundbutton = ac.a();
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    compoundbutton.a(flag);
                }

            });
            b();
            dialog.setContentView(view);
            dialog.show();
            return;
        }
    }

    public static void b(Activity activity, Runnable runnable)
    {
        a(activity, true, runnable);
    }

    static void b(EditText edittext, EditText edittext1, Button button)
    {
        c(edittext, edittext1, button);
    }

    private static void b(ListingV2 listingv2, Activity activity, Runnable runnable)
    {
        if (com.smule.android.network.managers.d.a().e() >= listingv2.price)
        {
            runnable.run();
            return;
        } else
        {
            a(activity, listingv2);
            return;
        }
    }

    public static void c()
    {
        long l = System.currentTimeMillis();
        if (l - c > 0x493e0L)
        {
            String s = MagicApplication.getContext().getResources().getString(0x7f0c0045);
            MagicApplication.getInstance().showToast(s, 0);
            c = l;
        }
    }

    public static void c(Activity activity)
    {
        activity.startActivity(new Intent(activity, com/smule/pianoandroid/magicpiano/ProductListActivity));
        activity.finish();
    }

    public static void c(Activity activity, Runnable runnable)
    {
        Dialog dialog = new Dialog(activity, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        View view = activity.getLayoutInflater().inflate(0x7f030052, null, false);
        com.smule.pianoandroid.utils.j.a(view, activity);
        view.findViewById(0x7f0a0087).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;

            public void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = dialog;
                super();
            }
        });
        view.findViewById(0x7f0a0086).setOnClickListener(new android.view.View.OnClickListener(dialog, runnable) {

            final Dialog a;
            final Runnable b;

            public void onClick(View view1)
            {
                a.dismiss();
                b.run();
            }

            
            {
                a = dialog;
                b = runnable;
                super();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    private static void c(EditText edittext, EditText edittext1, Button button)
    {
        button.setClickable(true);
        if (edittext.getText().toString().length() > 0 && (edittext1 == null || edittext1.getText().toString().length() > 0))
        {
            button.setEnabled(true);
            return;
        } else
        {
            button.setEnabled(false);
            return;
        }
    }

    public static void d(Activity activity)
    {
        activity.startActivity(new Intent(activity.getApplicationContext(), com/smule/pianoandroid/magicpiano/GlobeActivity));
        activity.finish();
    }

    public static void d(Activity activity, Runnable runnable)
    {
        Dialog dialog = new Dialog(activity, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        activity = activity.getLayoutInflater().inflate(0x7f030020, null, false);
        activity.findViewById(0x7f0a008b).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = dialog;
                super();
            }
        });
        activity.findViewById(0x7f0a008c).setOnClickListener(new android.view.View.OnClickListener(dialog, runnable) {

            final Dialog a;
            final Runnable b;

            public void onClick(View view)
            {
                a.dismiss();
                b.run();
            }

            
            {
                a = dialog;
                b = runnable;
                super();
            }
        });
        dialog.setContentView(activity);
        dialog.show();
    }

    public static void e(Activity activity)
    {
        if (!(activity instanceof ProductListActivity))
        {
            Intent intent = new Intent(activity.getApplicationContext(), com/smule/pianoandroid/magicpiano/ProductListActivity);
            intent.addFlags(0x4000000);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    static 
    {
        b = new UriMatcher(-1);
        b.addURI("com.smule.android.magicpiano", "home", 0);
        b.addURI("com.smule.android.magicpiano", "songbook", 1);
        b.addURI("com.smule.android.magicpiano", "songbook/section/*", 17);
        b.addURI("com.smule.android.magicpiano", "songbook/section/*/song/*", 2);
        b.addURI("com.smule.android.magicpiano", "songbook/*", 1);
        b.addURI("com.smule.android.magicpiano", "songbook/*/*", 1);
        b.addURI("com.smule.android.magicpiano", "songbook/*/*/*", 1);
        b.addURI("com.smule.android.magicpiano", "smoola", 4);
        b.addURI("com.smule.android.magicpiano", "globe", 5);
        b.addURI("com.smule.android.magicpiano", "globe/performance/*", 6);
        b.addURI("com.smule.android.magicpiano", "profile/newsfeed", 7);
        b.addURI("com.smule.magicpiano", "home", 0);
        b.addURI("com.smule.magicpiano", "songbook", 1);
        b.addURI("com.smule.magicpiano", "songbook/section/*", 17);
        b.addURI("com.smule.magicpiano", "songbook/section/*/song/*", 2);
        b.addURI("com.smule.magicpiano", "songbook/*", 1);
        b.addURI("com.smule.magicpiano", "songbook/*/*", 1);
        b.addURI("com.smule.magicpiano", "songbook/*/*/*", 1);
        b.addURI("com.smule.magicpiano", "smoola", 4);
        b.addURI("com.smule.magicpiano", "globe", 5);
        b.addURI("com.smule.magicpiano", "globe/performance/*", 6);
        b.addURI("com.smule.magicpiano", "profile/newsfeed", 7);
        b.addURI("songbook", null, 1);
        b.addURI("songbook", "*", 17);
        b.addURI("perform", "song/*", 16);
        b.addURI("globe", null, 5);
        b.addURI("profile", null, 8);
        b.addURI("purchase", null, 4);
        b.addURI("offers", null, 4);
        b.addURI("offers", "sponsorpay", 11);
        b.addURI("offers", "fyber", 11);
        b.addURI("login", null, 9);
        b.addURI("dailychallenge", null, 12);
        b.addURI("sponsorpay", null, 11);
        b.addURI("settings", null, 13);
        b.addURI("solo", null, 18);
        b.addURI("achievements", null, 19);
        b.addURI("achievements", "inprogress", 20);
        b.addURI("achievements", "completed", 21);
        b.addURI("level", null, 22);
        b.addURI("privacy", null, 23);
        b.addURI("terms", null, 24);
    }

    // Unreferenced inner class com/smule/pianoandroid/utils/NavigationUtils$2

/* anonymous class */
    final class NavigationUtils._cls2
        implements NetworkResponseCallback
    {

        final Activity a;
        final com.smule.pianoandroid.utils.p b;
        final PerformanceV2 c;

        public void handleResponse(com.smule.android.network.core.o o1)
        {
            if (o1 != null && o1.a == com.smule.android.network.core.p.a && o1.b == 0)
            {
                a.runOnUiThread(new NavigationUtils._cls2._cls1(this));
            } else
            {
                o.c();
                com.smule.android.network.core.b.a(o1);
                if (b != null)
                {
                    b.a(Boolean.valueOf(false), c);
                    return;
                }
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((com.smule.android.network.core.o)obj);
        }
    }


    // Unreferenced inner class com/smule/pianoandroid/utils/NavigationUtils$2$1

/* anonymous class */
    class NavigationUtils._cls2._cls1
        implements Runnable
    {

        final NavigationUtils._cls2 a;

        public void run()
        {
            if (a.b != null)
            {
                PerformanceV2 performancev2 = a.c;
                performancev2.totalLoves = performancev2.totalLoves + 1;
                a.b.a(Boolean.valueOf(true), a.c);
            }
        }

            
            {
                a = _pcls2;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/utils/NavigationUtils$23

/* anonymous class */
    final class NavigationUtils._cls23
        implements com.smule.android.network.managers.UserManager.AccountResponseCallback
    {

        final FragmentActivity a;
        final b b;
        final Runnable c;

        public void handleResponse(au au1)
        {
            a.runOnUiThread(new NavigationUtils._cls23._cls1(this, au1));
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((au)obj);
        }

            
            {
                a = fragmentactivity;
                b = b1;
                c = runnable;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/utils/NavigationUtils$23$1

/* anonymous class */
    class NavigationUtils._cls23._cls1
        implements Runnable
    {

        final au a;
        final NavigationUtils._cls23 b;

        public void run()
        {
            if (a.a.a != com.smule.android.network.core.p.a)
            {
                b.b.f();
                b.c.run();
            }
            if (a.a.a())
            {
                com.smule.android.c.a.a(true);
                if (!b.a.isFinishing())
                {
                    ((ag)b.a).p = null;
                    b.b.a();
                }
                Intent intent = RegistrationEntryActivity.a(b.a, true, true, a.mHandle, a.mEmail, null);
                q.B();
                b.a.startActivity(intent);
                return;
            }
            if (a.a.b == 65)
            {
                com.smule.android.c.a.a(false);
                b.b.a();
                b.c.run();
                return;
            } else
            {
                b.b.g();
                com.smule.android.network.core.b.a(a.a);
                b.c.run();
                return;
            }
        }

            
            {
                b = _pcls23;
                a = au1;
                super();
            }
    }

}
