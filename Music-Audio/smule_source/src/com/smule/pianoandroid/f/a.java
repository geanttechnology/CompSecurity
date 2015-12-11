// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.smule.android.c.i;
import com.smule.android.c.n;
import com.smule.android.c.o;
import com.smule.android.f.p;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.magicpiano.GoodJobActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.f:
//            b

public class a
{

    private static final String a = com/smule/pianoandroid/f/a.getName();
    private static a b;
    private Context c;
    private SharedPreferences d;

    private a(Context context)
    {
        c = context.getApplicationContext();
        d = c.getSharedPreferences(com/smule/pianoandroid/f/a.getName(), 0);
    }

    private int a(Activity activity, String s)
    {
        return activity.getResources().getIdentifier(s, "string", activity.getPackageName());
    }

    private Bundle a(Activity activity, String s, Object obj)
    {
        Bundle bundle = new Bundle();
        bundle.putString("description", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("description").toString())));
        bundle.putString("properties", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("properties").toString())));
        bundle.putString("link", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("link").toString())));
        bundle.putString("actions", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("actions").toString())));
        bundle.putString("message", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("message").toString())));
        bundle.putString("caption", String.format(activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("caption").toString()), new Object[] {
            obj
        }), new Object[0]));
        bundle.putString("name", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("name").toString())));
        bundle.putString("picture", activity.getResources().getString(a(activity, (new StringBuilder()).append(s).append("picture").toString())));
        return bundle;
    }

    public static a a(Context context)
    {
        com/smule/pianoandroid/f/a;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new a(context.getApplicationContext());
        }
        context = b;
        com/smule/pianoandroid/f/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private String a(int j)
    {
        return String.format(c.getResources().getString(0x7f0c0251), new Object[] {
            Integer.valueOf(j)
        });
    }

    private String a(String s)
    {
        return String.format(c.getResources().getString(0x7f0c024e), new Object[] {
            s
        });
    }

    private String a(String s, String s1)
    {
        return String.format(c.getResources().getString(0x7f0c0257), new Object[] {
            s, s1
        });
    }

    private void a(Activity activity, String s, int j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            String s1 = android.provider.Telephony.Sms.getDefaultSmsPackage(activity);
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("text/plain");
            intent1.putExtra("android.intent.extra.TEXT", s);
            if (s1 != null)
            {
                intent1.setPackage(s1);
            }
            activity.startActivityForResult(intent1, j);
            activity.startActivity(intent1);
            return;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("sms:"));
            intent.setType("vnd.android-dir/mms-sms");
            intent.putExtra("sms_body", s);
            activity.startActivityForResult(intent, j);
            return;
        }
    }

    private String b(int j)
    {
        return String.format(c.getResources().getString(0x7f0c0250), new Object[] {
            Integer.valueOf(j)
        });
    }

    private String b(String s)
    {
        return String.format(c.getResources().getString(0x7f0c024d), new Object[] {
            s
        });
    }

    private String b(String s, String s1)
    {
        return String.format(c.getResources().getString(0x7f0c024f), new Object[] {
            s, s1
        });
    }

    private void b(Activity activity, String s, int j)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Object obj = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (!((List) (obj)).isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                if (resolveinfo.activityInfo.packageName.toLowerCase().contains("twitter") || resolveinfo.activityInfo.name.toLowerCase().contains("twitter"))
                {
                    intent1.putExtra("android.intent.extra.TEXT", s);
                    intent1.setPackage(resolveinfo.activityInfo.packageName);
                    arraylist.add(intent1);
                }
            } while (true);
            s = Intent.createChooser((Intent)arraylist.remove(0), "Select app to share");
            s.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arraylist.toArray(new Parcelable[0]));
            activity.startActivityForResult(s, j);
        }
    }

    private void e(Activity activity, String s, String s1, String s2, int j)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(s2);
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", s1);
        activity.startActivityForResult(Intent.createChooser(intent, "Share via"), j);
    }

    public void a(Activity activity, int j, int k)
    {
        com.smule.android.facebook.a.a().a(activity, a(activity, "levelup.share.fb.", Integer.valueOf(j)), c.getResources().getString(0x7f0c010b));
    }

    public void a(Activity activity, AchievementDefinition achievementdefinition, int j)
    {
        com.smule.android.facebook.a.a().a(activity, a(activity, "achievement.share.fb.", achievementdefinition.title), c.getResources().getString(0x7f0c010c));
    }

    public void a(Activity activity, String s, String s1, String s2, int j)
    {
        s1 = ak.a().a(s1);
        if (s1 != null)
        {
            s1 = ((SongV2) (s1)).title;
            String s3 = b(s1, s2);
            com.smule.android.c.a.b(s, o.j, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
            e(activity, a(s1, s2), s3, "text/plain", j);
        }
    }

    public void a(Activity activity, String s, String s1, String s2, String s3, ScoreInfo scoreinfo)
    {
        if (ak.a().a(s1) != null)
        {
            Bundle bundle = new Bundle();
            if (scoreinfo != null)
            {
                bundle.putInt("score", scoreinfo.lastScore);
                bundle.putInt("max_score", scoreinfo.maxScore);
                bundle.putInt("stars", GoodJobActivity.a(scoreinfo.topScore, scoreinfo.maxScore));
            }
            bundle.putInt("max_stars", 3);
            if (s.equals("perform_android"))
            {
                bundle.putString("message", s2);
                bundle.putString("fb:explicitly_shared", "true");
            }
            bundle.putString("app", "Magic Piano");
            bundle.putString("type", "song");
            bundle.putString("track", s3);
            if (s.equals("play_android"))
            {
                s1 = null;
            } else
            {
                s1 = c.getResources().getString(0x7f0c010c);
            }
            com.smule.android.facebook.a.a().a(activity, (new StringBuilder()).append(b.a).append(s).toString(), bundle, s1);
        }
    }

    public void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = d.edit();
        editor.putBoolean("publishToTimeline", flag);
        p.a(editor);
    }

    public boolean a()
    {
        return d.getBoolean("publishToTimeline", true);
    }

    public void b(Activity activity, int j, int k)
    {
        e(activity, a(j), b(j), "text/plain", k);
    }

    public void b(Activity activity, AchievementDefinition achievementdefinition, int j)
    {
        e(activity, a(achievementdefinition.title), b(achievementdefinition.title), "text/plain", j);
    }

    public void b(Activity activity, String s, String s1, String s2, int j)
    {
        s1 = ak.a().a(s1);
        if (s1 != null)
        {
            s1 = ((SongV2) (s1)).title;
            String s3 = b(s1, s2);
            com.smule.android.c.a.b(s, o.g, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
            e(activity, a(s1, s2), s3, "message/rfc822", j);
        }
    }

    public void c(Activity activity, int j, int k)
    {
        e(activity, a(j), b(j), "message/rfc822", k);
    }

    public void c(Activity activity, AchievementDefinition achievementdefinition, int j)
    {
        e(activity, a(achievementdefinition.title), b(achievementdefinition.title), "message/rfc822", j);
    }

    public void c(Activity activity, String s, String s1, String s2, int j)
    {
        s1 = ak.a().a(s1);
        if (s1 != null)
        {
            s1 = b(((SongV2) (s1)).title, s2);
            com.smule.android.c.a.b(s, o.f, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
            a(activity, s1, j);
        }
    }

    public void d(Activity activity, int j, int k)
    {
        a(activity, a(j), k);
    }

    public void d(Activity activity, AchievementDefinition achievementdefinition, int j)
    {
        a(activity, b(achievementdefinition.title), j);
    }

    public void d(Activity activity, String s, String s1, String s2, int j)
    {
        s1 = ak.a().a(s1);
        if (s1 != null)
        {
            s1 = b(((SongV2) (s1)).title, s2);
            com.smule.android.c.a.b(s, o.c, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
            b(activity, s1, j);
        }
    }

    public void e(Activity activity, int j, int k)
    {
        b(activity, b(j), k);
    }

    public void e(Activity activity, AchievementDefinition achievementdefinition, int j)
    {
        b(activity, b(achievementdefinition.title), j);
    }

}
