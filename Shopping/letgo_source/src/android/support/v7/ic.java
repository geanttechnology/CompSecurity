// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Intent;
import com.abtnprojects.ambatana.ui.activities.ContactActivity;
import com.abtnprojects.ambatana.ui.activities.ProductActivity;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;
import com.abtnprojects.ambatana.ui.activities.chat.UserMessagesListActivity;
import com.abtnprojects.ambatana.ui.activities.posting.PostSuccessActivity;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.activities.profile.EditProfileActivity;
import com.abtnprojects.ambatana.ui.activities.profile.NotificationPreferenceActivity;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.parse.ParseUser;

public class ic
{

    final Activity a;

    public ic(Activity activity)
    {
        a = activity;
    }

    public void a()
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity);
        intent.putExtra("referral", "posting_completed");
        a.startActivity(intent);
    }

    public void a(Intent intent, ParseUser parseuser)
    {
        if (intent.getAction() == null)
        {
            throw new IllegalArgumentException("You must provide a valid action");
        }
        String s;
        byte byte0;
        if (intent.hasExtra("product_id"))
        {
            s = intent.getStringExtra("product_id");
        } else
        {
            s = null;
        }
        intent = intent.getAction();
        byte0 = -1;
        intent.hashCode();
        JVM INSTR lookupswitch 10: default 136
    //                   -1580673080: 208
    //                   -1078888306: 253
    //                   -535897978: 223
    //                   46417490: 315
    //                   54376010: 283
    //                   315782424: 268
    //                   1019558526: 238
    //                   1415454786: 331
    //                   1863732873: 299
    //                   1873350576: 193;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_331;
_L12:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            a.startActivity(new Intent(a, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity));
            return;

        case 1: // '\001'
            intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
            intent.putExtra("user_id", parseuser.getObjectId());
            a.startActivity(intent);
            return;

        case 2: // '\002'
            intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/profile/EditProfileActivity);
            a.startActivityForResult(intent, 5);
            return;

        case 3: // '\003'
            intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/chat/UserMessagesListActivity);
            a.startActivity(intent);
            return;

        case 4: // '\004'
            a.startActivity(new Intent(a, com/abtnprojects/ambatana/ui/activities/ContactActivity));
            return;

        case 5: // '\005'
            ((ProductActivity)a).e(s);
            return;

        case 6: // '\006'
            ((ProductActivity)a).F();
            return;

        case 7: // '\007'
            ((ProductActivity)a).I();
            return;

        case 8: // '\b'
            ((ProductActivity)a).C();
            return;

        case 9: // '\t'
            a.startActivity(new Intent(a, com/abtnprojects/ambatana/ui/activities/ProductListingActivity));
            break;
        }
        break MISSING_BLOCK_LABEL_535;
_L11:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_POSTING"))
        {
            byte0 = 0;
        }
          goto _L12
_L2:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_SELF_PROFILE"))
        {
            byte0 = 1;
        }
          goto _L12
_L4:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_EDIT_PROFILE"))
        {
            byte0 = 2;
        }
          goto _L12
_L8:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_MESSAGES"))
        {
            byte0 = 3;
        }
          goto _L12
_L3:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_CONTACT"))
        {
            byte0 = 4;
        }
          goto _L12
_L7:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_QUESTION"))
        {
            byte0 = 5;
        }
          goto _L12
_L6:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_OFFER"))
        {
            byte0 = 6;
        }
          goto _L12
_L10:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_FAV"))
        {
            byte0 = 7;
        }
          goto _L12
_L5:
        if (intent.equals("com.abtnprojects.ambatana.location.action.NAV_FRAUD"))
        {
            byte0 = 8;
        }
          goto _L12
        if (intent.equals("com.abtnprojects.ambatana.location.action.VIEW_LIST"))
        {
            byte0 = 9;
        }
          goto _L12
    }

    public void a(String s)
    {
        if (s != null && !s.trim().isEmpty())
        {
            Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/posting/PostSuccessActivity);
            intent.putExtra("product_id", s);
            a.startActivity(intent);
        }
    }

    public void b()
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/ContactActivity);
        a.startActivity(intent);
    }

    public void b(String s)
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
        intent.putExtra("user_id", s);
        intent.putExtra("referral", "posting_completed");
        a.startActivity(intent);
    }

    public void c()
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/profile/NotificationPreferenceActivity);
        a.startActivity(intent);
    }

    public void d()
    {
        Intent intent = new Intent(a, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        a.startActivity(intent);
        a.finish();
    }
}
