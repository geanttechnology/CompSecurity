// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Patterns;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.NotificationNew;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals, BaseActivity, m, c, 
//            i

public class a
{

    public static int a = 0;
    public static int b = 1;
    public static int c = 2;

    public static int a()
    {
        int k = Integer.valueOf(Globals.d.getResources().getString(m.bc_multi_col)).intValue();
        if (k < 2)
        {
            return 2;
        } else
        {
            return k;
        }
    }

    public static Pair a(Context context)
    {
        if (context == null)
        {
            Log.e("BCUtils", "Invalid context");
            return Pair.create(Integer.valueOf(0), null);
        }
        Globals.c(context);
        context = AccountManager.c();
        if (context == null) goto _L2; else goto _L1
_L1:
        e.b(new Object[] {
            (new StringBuilder()).append("User Id : ").append(context).toString()
        });
        context = (NotificationNew)o.a(context).d();
_L7:
        BCTileImage bctileimage = BCTileImage.b();
        if (context == null) goto _L4; else goto _L3
_L3:
        int k = (int)((NotificationNew) (context)).countFriend + (int)((NotificationNew) (context)).countYou;
        if (((NotificationNew) (context)).file == null) goto _L6; else goto _L5
_L5:
        context = ((NotificationNew) (context)).file.b();
        if (((FileMetadata) (context)).originalUrl == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        context = ((FileMetadata) (context)).originalUrl.toString();
_L10:
        StringBuilder stringbuilder = (new StringBuilder()).append("The new count : '").append(k).append("', the post cover : '");
        if (context == null)
        {
            context = "";
        }
        e.b(new Object[] {
            stringbuilder.append(context).append("'").toString()
        });
_L8:
        return Pair.create(Integer.valueOf(k), BCTileImage.a(bctileimage));
_L2:
        e.b(new Object[] {
            "No user id."
        });
        context = null;
          goto _L7
_L4:
        e.b(new Object[] {
            "The notify new is null"
        });
        k = 0;
          goto _L8
        context;
        context.printStackTrace();
_L9:
        return Pair.create(Integer.valueOf(0), null);
        context;
        context.printStackTrace();
        continue; /* Loop/switch isn't completed */
        context;
        context.printStackTrace();
        continue; /* Loop/switch isn't completed */
        context;
        context.printStackTrace();
        if (true) goto _L9; else goto _L6
_L6:
        context = null;
          goto _L10
        context = null;
          goto _L10
    }

    public static void a(Context context, String s)
    {
        if (context == null)
        {
            Log.e("BCUtils", "Invalid context");
            return;
        }
        if (s == null || s.isEmpty())
        {
            Log.e("BCUtils", "Invalid GCM registration ID");
            return;
        }
        try
        {
            Globals.c(context);
            (new j(s) {

                final String a;

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

                protected Void a(Void void1)
                {
                    void1 = Globals.n().getApplicationContext();
                    String s1 = com.cyberlink.beautycircle.controller.gcm.a.c(void1);
                    com.cyberlink.beautycircle.controller.gcm.a.a(void1, a);
                    if (s1 == null || s1.isEmpty() || !a.equals(s1))
                    {
                        e.b(new Object[] {
                            "The registration Id is different, re-init BC network."
                        });
                        NetworkManager.a(AccountManager.a());
                    }
                    return null;
                }

            
            {
                a = s;
                super();
            }
            }).d(null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void a(Context context, String s, Runnable runnable)
    {
        if (context == null)
        {
            Log.e("BCUtils", "Invalid context");
            (new Handler(Looper.getMainLooper())).post(runnable);
            return;
        }
        try
        {
            Globals.c(context);
            com.cyberlink.beautycircle.c.a((Activity)context, -1L, s, runnable, true, null, null, "SELFIE");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        (new Handler(Looper.getMainLooper())).post(runnable);
    }

    public static void a(ImageView imageview, String s)
    {
        if (imageview == null)
        {
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals("Master")) goto _L4; else goto _L3
_L3:
        int k = i.bc_user_ico_master;
_L6:
        if (k != 0)
        {
            imageview.setVisibility(0);
            imageview.setImageResource(k);
            return;
        } else
        {
            imageview.setVisibility(8);
            return;
        }
_L4:
        if (s.equals("Expert"))
        {
            k = i.bc_user_ico_beautyists;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("Brand"))
        {
            k = i.bc_user_ico_brand;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("Publisher"))
        {
            k = i.bc_user_ico_mags;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("Blogger") && com.cyberlink.beautycircle.Globals.j())
        {
            k = i.bc_post_product_tag_s;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        k = 0;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static boolean a(Context context, Intent intent, int k, int l)
    {
        if (context == null)
        {
            Log.e("BCUtils", "Invalid context");
            return false;
        }
        if (intent == null)
        {
            Log.e("BCUtils", "Invalid intent");
            return false;
        }
        boolean flag;
        try
        {
            Globals.c(context);
            flag = com.cyberlink.beautycircle.controller.gcm.a.a(context, intent, k, l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    public static boolean a(TextView textview, int k, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = true;
        if (textview == null) goto _L2; else goto _L1
_L1:
        String s = textview.getText().toString();
        if (!flag || !s.isEmpty()) goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        if (!flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        textview.setSelected(flag1);
        flag1 = flag;
_L2:
        return flag1;
_L4:
        if (!s.isEmpty())
        {
            if (k == b)
            {
                if (Patterns.EMAIL_ADDRESS.matcher(s).matches())
                {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            if (k == c)
            {
                if (Patterns.PHONE.matcher(s).matches())
                {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            {
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int b()
    {
        return 2;
    }

}
