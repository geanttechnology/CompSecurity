// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.d;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ContestItem;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.picsart.profile.fragment.aa;
import com.socialin.android.picsart.profile.view.GalleryItemViewPager;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            q, GalleryUtils, w

public final class p
{

    d a;
    public aa b;
    public BaseActivity c;
    public SharedPreferences d;
    public CompoundButton e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public Button i;
    public CompoundButton j;
    public CompoundButton k;

    public p(aa aa1, SharedPreferences sharedpreferences)
    {
        a = new q(this, (byte)0);
        b = aa1;
        c = (BaseActivity)aa1.getActivity();
        d = sharedpreferences;
        if (d == null)
        {
            d = c.getSharedPreferences((new StringBuilder("sinPref_")).append(aa1.getString(m.e(c, "app_name_short"))).toString(), 0);
        }
    }

    private void a(ViewerUser vieweruser, boolean flag)
    {
        if (!flag)
        {
            c.runOnUiThread(new _cls8());
        }
        if (vieweruser != null && !TextUtils.isEmpty(vieweruser.getPhoto()) && !"null".equals(vieweruser.getPhoto()))
        {
            (new _cls9(vieweruser)).start();
        }
    }

    public final void a()
    {
        Object obj2 = null;
        Object obj1 = b.a();
        Object obj;
        if (obj1 != null)
        {
            obj = GalleryUtils.b(((ImageItem) (obj1)).createdAt, c);
            Object obj3 = new StringBuilder();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(" / ").toString();
            } else
            {
                obj = " ";
            }
            obj = ((StringBuilder) (obj3)).append(((String) (obj))).append(Utils.a(((ImageItem) (obj1)).viewsCount)).append(" ").append(c.getString(0x7f08036b).toLowerCase()).toString();
            h.setText(((CharSequence) (obj)));
        }
        obj3 = b;
        obj1 = obj2;
        if (((aa) (obj3)).e != null)
        {
            obj1 = obj2;
            if (!((aa) (obj3)).e.isEmpty())
            {
                obj1 = obj2;
                if (((aa) (obj3)).c)
                {
                    if (((aa) (obj3)).d != null && ((aa) (obj3)).f != null)
                    {
                        obj = (ContestItem)((aa) (obj3)).e.get(((aa) (obj3)).f.getCurrentItem());
                    } else
                    {
                        obj = null;
                    }
                    obj1 = obj2;
                    if (obj != null)
                    {
                        obj1 = obj2;
                        if (((aa) (obj3)).b == 0)
                        {
                            obj1 = obj;
                        }
                    }
                }
            }
        }
        if (obj1 != null)
        {
            if (i != null)
            {
                obj = i;
                obj2 = c;
                int l;
                boolean flag;
                if (((ContestItem) (obj1)).voted)
                {
                    l = 0x7f08036e;
                } else
                {
                    l = 0x7f08036c;
                }
                ((Button) (obj)).setText(((BaseActivity) (obj2)).getString(l));
                obj = i;
                obj2 = c.getResources();
                if (((ContestItem) (obj1)).voted)
                {
                    l = 0x7f0f00dc;
                } else
                {
                    l = 0x7f0f0039;
                }
                ((Button) (obj)).setTextColor(((Resources) (obj2)).getColor(l));
                obj = i;
                if (!((ContestItem) (obj1)).voted)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((Button) (obj)).setClickable(flag);
                i.setOnClickListener(new _cls4(((ContestItem) (obj1))));
                i.setVisibility(0);
            }
            e.setVisibility(8);
        }
    }

    public final void a(ImageItem imageitem)
    {
        TextView textview = (TextView)b.getView().findViewById(0x7f10065f);
        Object obj = (TextView)b.getView().findViewById(0x7f10065e);
        if (imageitem.address != null && !TextUtils.isEmpty(imageitem.address.place))
        {
            String s = imageitem.address.place;
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setText(s);
            ((TextView) (obj)).setOnClickListener(new _cls5(imageitem));
        } else
        {
            ((TextView) (obj)).setText(null);
            ((TextView) (obj)).setVisibility(8);
        }
        obj = GalleryUtils.a(imageitem.tags, imageitem.title);
        if (obj != null && obj.length > 0)
        {
            imageitem = new SpannableStringBuilder();
            for (int l = 0; l < obj.length; l++)
            {
                String s1 = obj[l];
                SpannableString spannablestring = new SpannableString((new StringBuilder("#")).append(s1).toString());
                spannablestring.setSpan(new _cls6(s1), 0, spannablestring.length(), 17);
                imageitem.append(spannablestring);
                if (l != obj.length - 1)
                {
                    imageitem.append("  ");
                }
            }

        } else
        {
            imageitem = null;
        }
        if (imageitem != null)
        {
            textview.setVisibility(0);
            textview.setText(imageitem);
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        } else
        {
            textview.setText("");
            textview.setVisibility(8);
            return;
        }
    }

    public final void a(ImageItem imageitem, boolean flag)
    {
        Object obj = imageitem.user;
        a(((ViewerUser) (obj)), flag);
        if (obj != null)
        {
            if (((ViewerUser) (obj)).username != null && !"".equals(((ViewerUser) (obj)).username))
            {
                obj = (new StringBuilder("@")).append(((ViewerUser) (obj)).username).toString();
            } else
            {
                obj = "";
            }
            g.setText(((CharSequence) (obj)));
        } else
        {
            g.setText("");
        }
        a(imageitem);
        b(imageitem, false);
        c(imageitem, true);
        c.invalidateOptionsMenu();
    }

    public final void a(String s, boolean flag, ImageItem imageitem, String s1, boolean flag1)
    {
        boolean flag2 = FacebookUtils.isSessionValid();
        boolean flag3 = FacebookUtils.canIPost();
        if (flag2)
        {
            if (!flag && (!flag1 || !flag3))
            {
                GalleryUtils.a(c, imageitem, s, s1);
            } else
            {
                if (flag1 && !flag3)
                {
                    GalleryUtils.a(c, imageitem, s, s1);
                    return;
                }
                if (flag1)
                {
                    (new _cls2(imageitem, s)).start();
                    return;
                }
            }
        }
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            ImageItem imageitem = b.a();
            if (imageitem.user != null && imageitem.loaded)
            {
                if (imageitem.user.isOwnerFollowing || imageitem.user.id == SocialinV3.getInstance().getUser().id)
                {
                    e.setVisibility(8);
                } else
                {
                    e.setChecked(false);
                    e.setVisibility(0);
                }
            } else
            {
                e.setVisibility(8);
            }
        }
        b();
        c();
        a();
        d();
    }

    public final void a(boolean flag, long l)
    {
        if (b.getView() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Animation animation;
        View view;
        View view1;
        View view2;
        TextView textview;
        TextView textview1;
        TextView textview2;
        byte byte0;
        view = b.getView().findViewById(0x7f10059a);
        view1 = b.getView().findViewById(0x7f1000f5);
        view2 = b.getView().findViewById(0x7f100660);
        textview = (TextView)view2.findViewById(0x7f100661);
        textview1 = (TextView)b.getView().findViewById(0x7f10065f);
        textview2 = (TextView)b.getView().findViewById(0x7f10065e);
        animation = null;
        if (view1.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        byte byte1 = 8;
        byte0 = byte1;
        if (flag)
        {
            animation = AnimationUtils.loadAnimation(c, 0x7f040027);
            byte0 = byte1;
        }
_L4:
        view1.setVisibility(byte0);
        view.setVisibility(byte0);
        if (animation != null && l > 0L)
        {
            animation.setDuration(l);
            view1.startAnimation(animation);
            view.startAnimation(animation);
        }
        if (textview.getText() != null && !"".equals(textview.getText().toString().trim()))
        {
            textview.setVisibility(byte0);
            view2.setVisibility(byte0);
        }
        view1.setVisibility(byte0);
        if (flag && animation != null)
        {
            view1.startAnimation(animation);
        }
        view.setVisibility(byte0);
        if (flag && animation != null)
        {
            view.startAnimation(animation);
        }
        if (!TextUtils.isEmpty(textview1.getText()))
        {
            textview1.setVisibility(byte0);
        }
        if (!TextUtils.isEmpty(textview2.getText()))
        {
            textview2.setVisibility(byte0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag1 = false;
        byte0 = flag1;
        if (flag)
        {
            animation = AnimationUtils.loadAnimation(c, 0x7f040026);
            byte0 = flag1;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void b()
    {
        Object obj = b.a();
        Object obj1 = j;
        boolean flag;
        if (!((ImageItem) (obj)).isLiking())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CompoundButton) (obj1)).setEnabled(flag);
        j.setChecked(((ImageItem) (obj)).isLiked);
        obj1 = (TextView)b.getView().findViewById(0x7f10066f);
        if (((ImageItem) (obj)).likesCount == 0)
        {
            ((TextView) (obj1)).setVisibility(8);
            return;
        }
        ((TextView) (obj1)).setVisibility(0);
        StringBuilder stringbuilder = (new StringBuilder()).append(String.valueOf(((ImageItem) (obj)).likesCount)).append(" ");
        if (((ImageItem) (obj)).likesCount == 1)
        {
            obj = c.getString(0x7f0802ef).toLowerCase();
        } else
        {
            obj = c.getString(0x7f0802f3).toLowerCase();
        }
        ((TextView) (obj1)).setText(stringbuilder.append(((String) (obj))).toString());
    }

    public final void b(ImageItem imageitem)
    {
        if (imageitem != null)
        {
            Object obj = imageitem.user;
            if (obj != null)
            {
                a(((ViewerUser) (obj)), true);
                if (!TextUtils.isEmpty(((ViewerUser) (obj)).name))
                {
                    obj = ((ViewerUser) (obj)).name;
                } else
                if (!TextUtils.isEmpty(imageitem.user.username))
                {
                    obj = ((ViewerUser) (obj)).username;
                } else
                {
                    obj = "";
                }
                g.setText(((CharSequence) (obj)));
            }
            a(b.b());
            b(imageitem, false);
            c(imageitem, true);
            c.invalidateOptionsMenu();
        }
    }

    public final void b(ImageItem imageitem, boolean flag)
    {
        View view = b.getView().findViewById(0x7f100660);
        TextView textview = (TextView)view.findViewById(0x7f100661);
        view.setVisibility(8);
        Object obj;
        if (imageitem.origin != null)
        {
            obj = imageitem.origin.title;
        } else
        {
            obj = imageitem.title;
        }
        if (obj != null && !"".equals(((String) (obj)).trim()))
        {
            int l = c.getResources().getInteger(0x7f0e0018);
            if (!flag && ((String) (obj)).length() > l)
            {
                Object obj1;
                if (imageitem.origin != null)
                {
                    obj = imageitem.origin.title;
                } else
                {
                    obj = imageitem.title;
                }
                obj1 = GalleryUtils.a(((String) (obj)).substring(0, l), c);
                obj = new SpannableStringBuilder();
                ((SpannableStringBuilder) (obj)).append(((CharSequence) (obj1)));
                ((SpannableStringBuilder) (obj)).append(new SpannableString("..."));
                imageitem = new _cls10(imageitem);
                obj1 = new SpannableString(c.getString(0x7f08062a));
                ((SpannableString) (obj1)).setSpan(imageitem, 0, ((SpannableString) (obj1)).length(), 33);
                ((SpannableStringBuilder) (obj)).append(((CharSequence) (obj1)));
                textview.setText(((CharSequence) (obj)));
            } else
            {
                textview.setText(GalleryUtils.a(((String) (obj)), c));
            }
            textview.setMovementMethod(new w());
            textview.setVisibility(0);
            view.setVisibility(0);
            return;
        } else
        {
            textview.setText("");
            view.setVisibility(8);
            return;
        }
    }

    public final void c()
    {
        Object obj;
        Object obj1;
        Object obj2;
label0:
        {
            obj = b.a();
            if (obj != null)
            {
                long l = 1L;
                if (SocialinV3.getInstance().getUser() != null)
                {
                    l = SocialinV3.getInstance().getUser().id;
                }
                obj1 = k;
                boolean flag;
                boolean flag1;
                if (!((ImageItem) (obj)).isReposting())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ((CompoundButton) (obj1)).setEnabled(flag1);
                if (((ImageItem) (obj)).user != null && ((ImageItem) (obj)).user.id == l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    k.setVisibility(8);
                }
                k.setChecked(((ImageItem) (obj)).isReposted);
            }
            obj = b.a();
            if (obj != null)
            {
                obj1 = (TextView)b.getView().findViewById(0x7f100671);
                obj2 = Utils.a(((ImageItem) (obj)).repostsCount);
                if (!"0".equals(obj2))
                {
                    break label0;
                }
                ((TextView) (obj1)).setVisibility(8);
            }
            return;
        }
        ((TextView) (obj1)).setVisibility(0);
        obj2 = (new StringBuilder()).append(((String) (obj2))).append(" ");
        if (((ImageItem) (obj)).repostsCount == 1)
        {
            obj = c.getString(0x7f080339).toLowerCase();
        } else
        {
            obj = c.getString(0x7f08033b).toLowerCase();
        }
        ((TextView) (obj1)).setText(((StringBuilder) (obj2)).append(((String) (obj))).toString());
    }

    public final void c(ImageItem imageitem, boolean flag)
    {
        Object obj = Utils.a(imageitem.commentsCount);
        Object obj1 = (TextView)b.getView().findViewById(0x7f100670);
        if ("0".equals(obj))
        {
            ((TextView) (obj1)).setVisibility(8);
        } else
        {
            ((TextView) (obj1)).setVisibility(0);
            StringBuilder stringbuilder = (new StringBuilder()).append(((String) (obj))).append(" ");
            if (imageitem.commentsCount == 1)
            {
                obj = c.getString(0x7f0802a7).toLowerCase();
            } else
            {
                obj = c.getString(0x7f0802a8).toLowerCase();
            }
            ((TextView) (obj1)).setText(stringbuilder.append(((String) (obj))).toString());
        }
        j.setChecked(imageitem.isLiked);
        obj = Utils.a(imageitem.likesCount);
        obj1 = (TextView)b.getView().findViewById(0x7f10066f);
        if ("0".equals(obj))
        {
            ((TextView) (obj1)).setVisibility(8);
        } else
        {
            ((TextView) (obj1)).setVisibility(0);
            StringBuilder stringbuilder1 = (new StringBuilder()).append(((String) (obj))).append(" ");
            if (imageitem.likesCount == 1)
            {
                obj = c.getString(0x7f0802ef).toLowerCase();
            } else
            {
                obj = c.getString(0x7f0802f3).toLowerCase();
            }
            ((TextView) (obj1)).setText(stringbuilder1.append(((String) (obj))).toString());
        }
        k.setChecked(imageitem.isReposted);
        obj1 = Utils.a(imageitem.repostsCount);
        obj = (TextView)b.getView().findViewById(0x7f100671);
        if ("0".equals(obj1))
        {
            ((TextView) (obj)).setVisibility(8);
        } else
        {
            ((TextView) (obj)).setVisibility(0);
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(" ");
            if (imageitem.repostsCount == 1)
            {
                imageitem = c.getString(0x7f080339).toLowerCase();
            } else
            {
                imageitem = c.getString(0x7f08033b).toLowerCase();
            }
            ((TextView) (obj)).setText(((StringBuilder) (obj1)).append(imageitem).toString());
        }
        a(flag);
    }

    public final void d()
    {
        ImageItem imageitem;
label0:
        {
            imageitem = b.a();
            if (imageitem != null && imageitem.user != null)
            {
                if (!imageitem.freeToEdit() && SocialinV3.getInstance().getUser().id != imageitem.user.id)
                {
                    break label0;
                }
                k.setVisibility(8);
                View view = b.getView().findViewById(0x7f10066d);
                view.setVisibility(0);
                view.setOnClickListener(new _cls7(imageitem));
            }
            return;
        }
        boolean flag;
        long l;
        if (SocialinV3.getInstance().getUser() != null)
        {
            l = SocialinV3.getInstance().getUser().id;
        } else
        {
            l = 1L;
        }
        if (imageitem.user != null && imageitem.user.id == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            k.setVisibility(0);
        }
        b.getView().findViewById(0x7f10066d).setVisibility(8);
    }

    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls7 {}

}
