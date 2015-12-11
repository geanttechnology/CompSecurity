// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Dialog;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineLogin;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            SignUpNameAvatarFragment, ImagePicker

class this._cls0 extends AppSessionListener
{

    final SignUpNameAvatarFragment this$0;

    public void onGetTwitterUserComplete(String s, int i, String s1, TwitterUser twitteruser, VineLogin vinelogin)
    {
        if (i == 200 || twitteruser == null) goto _L2; else goto _L1
_L1:
        SignUpNameAvatarFragment.access$000(SignUpNameAvatarFragment.this).setText(twitteruser.name);
        SignUpNameAvatarFragment.access$300(SignUpNameAvatarFragment.this).setVisibility(0);
        SignUpNameAvatarFragment.access$402(SignUpNameAvatarFragment.this, null);
        if (twitteruser.defaultProfileImage) goto _L4; else goto _L3
_L3:
        s = new ImageKey(twitteruser.profileUrl);
        s1 = mAppController.getPhotoBitmap(s);
        SignUpNameAvatarFragment.access$500(SignUpNameAvatarFragment.this, s1);
        if (SignUpNameAvatarFragment.access$600(SignUpNameAvatarFragment.this))
        {
            SignUpNameAvatarFragment.access$700(SignUpNameAvatarFragment.this).setTag(null);
            SignUpNameAvatarFragment.access$800(SignUpNameAvatarFragment.this).saveProfileImage(s1);
            if (SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this) != null)
            {
                SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this).dismiss();
            }
        } else
        {
            SignUpNameAvatarFragment.access$700(SignUpNameAvatarFragment.this).setTag(s);
        }
_L8:
        SignUpNameAvatarFragment.access$1002(SignUpNameAvatarFragment.this, twitteruser);
_L6:
        return;
_L4:
        if (SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this) != null)
        {
            SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this).dismiss();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this) == null) goto _L6; else goto _L5
_L5:
        SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this).dismiss();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        hashmap = (UrlImage)hashmap.get((ImageKey)SignUpNameAvatarFragment.access$700(SignUpNameAvatarFragment.this).getTag());
        if (hashmap != null && hashmap.isValid())
        {
            SignUpNameAvatarFragment.access$500(SignUpNameAvatarFragment.this, ((UrlImage) (hashmap)).bitmap);
            SignUpNameAvatarFragment.access$800(SignUpNameAvatarFragment.this).saveProfileImage(((UrlImage) (hashmap)).bitmap);
            if (SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this) != null)
            {
                SignUpNameAvatarFragment.access$900(SignUpNameAvatarFragment.this).dismiss();
            }
        }
    }

    ()
    {
        this$0 = SignUpNameAvatarFragment.this;
        super();
    }
}
