// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bumptech.glide.a;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.picsart.studio.profile.ProfileActivity;
import com.picsart.studio.utils.DynamicHeightImageView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Comment;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.w;
import com.socialin.android.picsart.upload.c;
import com.socialin.android.util.Utils;
import com.socialin.android.util.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.adapter:
//            r, ad, ae, ac

public final class ab extends r
{

    public int a;
    public int b;
    public boolean c;
    public List d;
    public ac e;
    private int f;
    private LayoutInflater g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private d m;
    private f n;

    public ab(Context context, com.socialin.android.adapter.a a1)
    {
        super(context, a1);
        f = 10;
        g = null;
        h = 0;
        i = 1;
        j = 2;
        c = false;
        d = new ArrayList();
        m = new d(context.getApplicationContext());
        this.context = context;
        g = LayoutInflater.from(context);
        k = context.getResources().getColor(0x7f0f0091);
        l = context.getResources().getColor(0x7f0f0099);
        n = new f(context.getApplicationContext());
    }

    static List a(ab ab1)
    {
        return ab1.d;
    }

    private List a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        int j1 = list.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            Comment comment = (Comment)list.get(i1);
            if (comment != null && !TextUtils.isEmpty(comment.text) && !comment.text.contains("[img]") && arraylist.size() < f)
            {
                arraylist.add(comment);
            }
        }

        return arraylist;
    }

    private void a(ImageItem imageitem, SpannableStringBuilder spannablestringbuilder, int i1)
    {
        ViewerUser vieweruser;
        int j1;
        int l1;
        vieweruser = imageitem.user;
        imageitem = imageitem.reposts;
        l1 = Math.min(imageitem.size(), 3);
        j1 = 0;
_L8:
        Object obj;
        if (j1 >= l1)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        obj = (ViewerUser)imageitem.get(j1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        int k1;
        obj1 = (new StringBuilder("@")).append(((ViewerUser) (obj)).username).toString();
        SpannableString spannablestring1 = new SpannableString(((CharSequence) (obj1)));
        spannablestring1.setSpan(new _cls18(context.getResources().getColor(0x7f0f0091), vieweruser, ((ViewerUser) (obj))), 0, ((String) (obj1)).length(), 17);
        spannablestringbuilder.append(spannablestring1);
        obj = (ImageItem)getItem(i1);
        obj1 = ((ImageItem) (obj)).reposts;
        k1 = Math.min(((List) (obj1)).size(), 3);
        if (j1 == 0 && k1 == 2)
        {
            spannablestringbuilder.append(" and ");
        } else
        if (j1 == 0 && k1 > 1)
        {
            spannablestringbuilder.append(", ");
        } else
        {
            if (j1 != 1 || ((List) (obj1)).size() != 3)
            {
                continue; /* Loop/switch isn't completed */
            }
            spannablestringbuilder.append(" and ");
        }
_L4:
        k1 = 0;
_L5:
        if (k1 != 0)
        {
            break MISSING_BLOCK_LABEL_357;
        }
_L2:
        j1++;
        continue; /* Loop/switch isn't completed */
        if (j1 != 1 || ((List) (obj1)).size() <= k1) goto _L4; else goto _L3
_L3:
        spannablestringbuilder.append(" and ");
        obj = (new StringBuilder()).append(String.valueOf((((ImageItem) (obj)).repostsCount - k1) + 1)).append(" others").toString();
        SpannableString spannablestring = new SpannableString(((CharSequence) (obj)));
        spannablestring.setSpan(new _cls19(context.getResources().getColor(0x7f0f0091), i1), 0, ((String) (obj)).length(), 17);
        spannablestringbuilder.append(spannablestring);
        k1 = 1;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(List list, TextView textview)
    {
        textview.setVisibility(0);
        textview.setText("");
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        List list1 = a(list);
        int j1 = list1.size();
        list = "";
        if (list1.isEmpty())
        {
            textview.setVisibility(8);
        } else
        {
            spannablestringbuilder.append("...\n");
            int i1 = 0;
            while (i1 < j1) 
            {
                Object obj1 = (Comment)list1.get(i1);
                Object obj = list;
                if (obj1 != null)
                {
                    if (((Comment) (obj1)).user == null)
                    {
                        obj = "username";
                    } else
                    {
                        obj = ((Comment) (obj1)).user.username;
                    }
                    obj1 = ((Comment) (obj1)).text.trim();
                    list = (new StringBuilder()).append(list).append("@").append(((String) (obj))).append(" ").append(((String) (obj1)).trim()).toString();
                    obj = "\n";
                    spannablestringbuilder.append(GalleryUtils.a(list, (Activity)context, 0xff000000, k, l));
                    spannablestringbuilder.append("\n");
                }
                i1++;
                list = ((List) (obj));
            }
        }
        textview.setMovementMethod(new w());
        textview.setText(spannablestringbuilder);
    }

    static ac b(ab ab1)
    {
        return ab1.e;
    }

    static Context c(ab ab1)
    {
        return ab1.context;
    }

    static Context d(ab ab1)
    {
        return ab1.context;
    }

    static com.socialin.android.adapter.a e(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a f(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a g(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a h(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a i(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a j(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a k(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a l(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a m(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a n(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a o(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a p(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a q(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a r(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a s(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a t(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a u(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a v(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a w(ab ab1)
    {
        return ab1.clickListener;
    }

    static com.socialin.android.adapter.a x(ab ab1)
    {
        return ab1.clickListener;
    }

    public final int a()
    {
        return d.size();
    }

    public final void a(long l1)
    {
        Iterator iterator = getItems().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ImageItem imageitem = (ImageItem)iterator.next();
            if (imageitem.id != l1)
            {
                continue;
            }
            remove(imageitem);
            break;
        } while (true);
    }

    public final boolean a(String s1, String s2)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            c c1 = (c)iterator.next();
            if (s1.equals(c1.c) && s2.equals(c1.a))
            {
                return true;
            }
        }

        return false;
    }

    public final int b(long l1)
    {
        int i1 = 0;
        for (int j1 = itemsList.size(); i1 < j1; i1++)
        {
            if (getItem(i1) != null && ((ImageItem)getItem(i1)).id == l1)
            {
                return i1;
            }
        }

        return -1;
    }

    public final void clear()
    {
        super.clear();
        if (!SocialinV3.getInstance().isRegistered())
        {
            d.clear();
        }
    }

    public final int getItemCount()
    {
        return itemsList.size() + d.size();
    }

    public final int getItemViewType(int i1)
    {
        if (!d.isEmpty() && d.size() > i1)
        {
            return j;
        }
        if (i1 == 0 && !SocialinV3.getInstance().isRegistered() && !c)
        {
            return 0;
        } else
        {
            return i;
        }
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i1)
    {
        super.onBindViewHolder(viewholder, i1);
        int j1 = getItemViewType(i1);
        if (j1 == 0 || j1 == j)
        {
            android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams layoutparams = new android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams(-1, -2);
            layoutparams.setFullSpan(true);
            viewholder.itemView.setLayoutParams(layoutparams);
            if (j1 == j)
            {
                ((android.view.ViewGroup.MarginLayoutParams)viewholder.itemView.getLayoutParams()).setMargins(-a, -b, -a, -b);
                if (d.size() >= i1 && (viewholder instanceof ad))
                {
                    Object obj = (c)d.get(i1);
                    viewholder = (ad)viewholder;
                    n.a((new StringBuilder("file://")).append(((c) (obj)).b).toString(), ((ad) (viewholder)).c, (e)((e)com.bumptech.glide.request.e.e(context.getApplicationContext()).a(0x7f020669)).b(0x7f020669), null);
                    if ("picsart".equals(((c) (obj)).a))
                    {
                        ((ad) (viewholder)).d.setText(context.getString(0x7f080388));
                    } else
                    {
                        obj = (new StringBuilder()).append(Character.toUpperCase(((c) (obj)).a.charAt(0))).append(((c) (obj)).a.substring(1)).toString();
                        ((ad) (viewholder)).d.setText(context.getString(0x7f0805c6, new Object[] {
                            obj
                        }));
                    }
                    ((ad) (viewholder)).b.setOnClickListener(new _cls1(i1));
                    ((ad) (viewholder)).a.setOnClickListener(new _cls12(i1));
                }
            }
        } else
        {
            int k1 = i1 - a();
            ImageItem imageitem = (ImageItem)getItem(k1);
            if (imageitem != null)
            {
                Object obj2 = imageitem.user;
                Object obj1;
                Object obj3;
                Object obj4;
                View view;
                if (obj2 != null && ((ViewerUser) (obj2)).id == SocialinV3.getInstance().getUser().id)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                obj1 = ((ae)viewholder).s;
                view = g.inflate(0x7f030171, null);
                obj3 = new PopupWindow(view, -2, -2);
                ((PopupWindow) (obj3)).setOutsideTouchable(true);
                ((PopupWindow) (obj3)).setFocusable(true);
                ((PopupWindow) (obj3)).setBackgroundDrawable(context.getResources().getDrawable(0x7f02002d));
                if (i1 != 0)
                {
                    view.findViewById(0x7f100736).setVisibility(8);
                } else
                {
                    view.findViewById(0x7f100736).setVisibility(0);
                    view.findViewById(0x7f100736).setOnClickListener(new _cls10(k1, ((PopupWindow) (obj3))));
                }
                view.findViewById(0x7f100734).setOnClickListener(new _cls11(k1, ((PopupWindow) (obj3))));
                view.findViewById(0x7f100735).setOnClickListener(new _cls13(k1, ((PopupWindow) (obj3))));
                view.findViewById(0x7f100737).setOnClickListener(new _cls14(k1, ((PopupWindow) (obj3))));
                obj4 = view.findViewById(0x7f100738);
                view = view.findViewById(0x7f100739);
                if (i1 != 0)
                {
                    ((View) (obj4)).setVisibility(0);
                    ((View) (obj4)).setOnClickListener(new _cls15(k1, ((PopupWindow) (obj3))));
                    view.setVisibility(0);
                    view.setOnClickListener(new _cls16(k1, ((PopupWindow) (obj3))));
                } else
                {
                    ((View) (obj4)).setVisibility(8);
                    view.setVisibility(8);
                }
                obj4 = ((PopupWindow) (obj3)).getContentView();
                ((View) (obj4)).measure(0, 0);
                ((View) (obj1)).setOnClickListener(new _cls17(((PopupWindow) (obj3)), ((View) (obj1)), ((View) (obj1)).getWidth() - ((View) (obj4)).getMeasuredWidth()));
                ((android.view.ViewGroup.MarginLayoutParams)viewholder.itemView.getLayoutParams()).setMargins(-a, -b, -a, -b);
                obj1 = (ae)viewholder;
                if (!(context instanceof ProfileActivity))
                {
                    viewholder = imageitem.reposts;
                    if (viewholder != null && !viewholder.isEmpty())
                    {
                        ((ae) (obj1)).f.setVisibility(0);
                        ((ae) (obj1)).i.setVisibility(0);
                        i1 = context.getResources().getColor(0x7f0f0093);
                        viewholder = new SpannableStringBuilder();
                        obj3 = (new StringBuilder()).append(context.getString(0x7f080565)).append(" ").toString();
                        obj4 = new SpannableString(((CharSequence) (obj3)));
                        ((SpannableString) (obj4)).setSpan(new ForegroundColorSpan(i1), 0, ((String) (obj3)).length(), 0);
                        viewholder.append(((CharSequence) (obj4)));
                        a(imageitem, viewholder, k1);
                        ((ae) (obj1)).i.setClickable(true);
                        ((ae) (obj1)).i.setText(viewholder, android.widget.TextView.BufferType.SPANNABLE);
                        ((ae) (obj1)).i.setMovementMethod(new w());
                    } else
                    {
                        ((ae) (obj1)).f.setVisibility(8);
                        ((ae) (obj1)).i.setVisibility(8);
                    }
                }
                viewholder = imageitem.user;
                if (viewholder != null && !((ViewerUser) (viewholder)).isOwnerFollowing && ((ViewerUser) (viewholder)).id != SocialinV3.getInstance().getUser().id && !c)
                {
                    ((ae) (obj1)).w.setVisibility(0);
                    ((ae) (obj1)).w.setOnClickListener(new _cls20(k1));
                    ((ae) (obj1)).w.setChecked(imageitem.user.isOwnerFollowing);
                } else
                {
                    ((ae) (obj1)).w.setVisibility(8);
                    ((ae) (obj1)).w.setClickable(false);
                }
                if (obj2 != null)
                {
                    viewholder = ((ViewerUser) (obj2)).getPhoto();
                } else
                {
                    viewholder = "";
                }
                if (viewholder.startsWith("http://graph.facebook"))
                {
                    viewholder = viewholder.replaceFirst("http", "https");
                }
                n.a(viewholder, ((ae) (obj1)).d, (e)((e)com.bumptech.glide.request.e.e(context.getApplicationContext()).a(0x7f020669)).b(0x7f020669), null);
                ((ae) (obj1)).c.setOnClickListener(new _cls21(k1));
                ((ae) (obj1)).e.setVisibility(4);
                if (obj2 != null && ((ViewerUser) (obj2)).isValidated)
                {
                    ((ae) (obj1)).e.setVisibility(0);
                }
                if (obj2 != null && !TextUtils.isEmpty(((ViewerUser) (obj2)).username))
                {
                    ((ae) (obj1)).g.setText((new StringBuilder("@")).append(((ViewerUser) (obj2)).username).toString());
                } else
                {
                    ((ae) (obj1)).g.setVisibility(4);
                }
                ((ae) (obj1)).g.setOnClickListener(new _cls22(k1));
                viewholder = new StringBuilder();
                if (imageitem.createdAt != null)
                {
                    viewholder.append((new StringBuilder()).append(GalleryUtils.b(imageitem.createdAt, context)).append(" / ").toString());
                }
                viewholder.append((new StringBuilder()).append(imageitem.viewsCount).append(" ").append(context.getString(0x7f08036b).toLowerCase()).toString());
                ((ae) (obj1)).h.setText(viewholder.toString());
                if (imageitem.address != null)
                {
                    viewholder = GalleryUtils.a(imageitem.address);
                } else
                {
                    viewholder = null;
                }
                if (TextUtils.isEmpty(viewholder))
                {
                    ((ae) (obj1)).j.setVisibility(8);
                    ((ae) (obj1)).j.setOnClickListener(null);
                } else
                {
                    ((ae) (obj1)).j.setVisibility(0);
                    ((ae) (obj1)).j.setText(viewholder);
                    ((ae) (obj1)).j.setOnClickListener(new _cls23(k1));
                }
                if (imageitem.tags != null && imageitem.tags.length > 0)
                {
                    ((ae) (obj1)).l.setMovementMethod(new w());
                    ((ae) (obj1)).l.setText(GalleryUtils.a((Activity)context, imageitem.tags, imageitem.title, k, l));
                    ((ae) (obj1)).l.setVisibility(0);
                } else
                {
                    ((ae) (obj1)).l.setVisibility(8);
                }
                if (!TextUtils.isEmpty(imageitem.title))
                {
                    viewholder = imageitem.title;
                    ((ae) (obj1)).k.setMovementMethod(new w());
                    ((ae) (obj1)).k.setText(GalleryUtils.a(viewholder, (Activity)context, 0xff000000, k, l));
                    ((ae) (obj1)).k.setVisibility(0);
                } else
                {
                    ((ae) (obj1)).k.setVisibility(8);
                }
                i1 = imageitem.commentsCount;
                a(imageitem.comments, ((ae) (obj1)).m);
                obj2 = new _cls24(k1);
                if (i1 > 0)
                {
                    obj3 = ((ae) (obj1)).o;
                    obj4 = (new StringBuilder()).append(i1).append(" ");
                    if (i1 == 1)
                    {
                        viewholder = context.getString(0x7f0802a7);
                    } else
                    {
                        viewholder = context.getString(0x7f0802a8);
                    }
                    ((TextView) (obj3)).setText(((StringBuilder) (obj4)).append(viewholder).toString());
                    ((ae) (obj1)).o.setOnClickListener(new _cls2(k1));
                    ((ae) (obj1)).o.setVisibility(0);
                } else
                {
                    ((ae) (obj1)).o.setVisibility(8);
                }
                ((ae) (obj1)).t.setOnClickListener(((android.view.View.OnClickListener) (obj2)));
                if (imageitem.likesCount > 0)
                {
                    obj2 = ((ae) (obj1)).n;
                    obj3 = (new StringBuilder()).append(imageitem.likesCount).append(" ");
                    if (imageitem.likesCount == 1)
                    {
                        viewholder = context.getString(0x7f0802ef);
                    } else
                    {
                        viewholder = context.getString(0x7f0802f3);
                    }
                    ((TextView) (obj2)).setText(((StringBuilder) (obj3)).append(viewholder).toString());
                    ((ae) (obj1)).n.setOnClickListener(new _cls3(k1));
                    ((ae) (obj1)).n.setVisibility(0);
                } else
                {
                    ((ae) (obj1)).n.setVisibility(8);
                }
                viewholder = ((ae) (obj1)).u;
                if (imageitem.isLiked && SocialinV3.getInstance().isRegistered())
                {
                    i1 = 0x7f02049e;
                } else
                {
                    i1 = 0x7f020799;
                }
                viewholder.setImageResource(i1);
                ((ae) (obj1)).u.setOnClickListener(new _cls4(k1));
                obj2 = imageitem.user;
                if (imageitem.repostsCount > 0)
                {
                    obj3 = ((ae) (obj1)).p;
                    obj4 = (new StringBuilder()).append(imageitem.repostsCount).append(" ");
                    if (imageitem.repostsCount == 1)
                    {
                        viewholder = context.getString(0x7f080339);
                    } else
                    {
                        viewholder = context.getString(0x7f08033b);
                    }
                    ((TextView) (obj3)).setText(((StringBuilder) (obj4)).append(viewholder).toString());
                    ((ae) (obj1)).p.setOnClickListener(new _cls5(k1));
                    ((ae) (obj1)).p.setVisibility(0);
                } else
                {
                    ((ae) (obj1)).p.setVisibility(8);
                }
                if (obj2 != null && ((ViewerUser) (obj2)).id != SocialinV3.getInstance().getUser().id)
                {
                    if (!imageitem.isReposting())
                    {
                        viewholder = ((ae) (obj1)).v;
                        if (imageitem.isReposted)
                        {
                            i1 = 0x7f0205f1;
                        } else
                        {
                            i1 = 0x7f02079a;
                        }
                        viewholder.setImageResource(i1);
                        ((ae) (obj1)).v.setVisibility(0);
                        ((ae) (obj1)).v.setOnClickListener(new _cls6(k1));
                    } else
                    {
                        viewholder = ((ae) (obj1)).v;
                        if (imageitem.isReposted)
                        {
                            i1 = 0x7f0205f1;
                        } else
                        {
                            i1 = 0x7f02079a;
                        }
                        viewholder.setImageResource(i1);
                        ((ae) (obj1)).v.setVisibility(0);
                        ((ae) (obj1)).v.setOnClickListener(null);
                    }
                } else
                {
                    ((ae) (obj1)).v.setVisibility(8);
                }
                viewholder = imageitem.user;
                if (imageitem.freeToEdit() || viewholder != null && ((ViewerUser) (viewholder)).id == SocialinV3.getInstance().getUser().id)
                {
                    ((ae) (obj1)).r.setVisibility(0);
                    ((ae) (obj1)).r.setOnClickListener(new _cls7(k1));
                } else
                {
                    ((ae) (obj1)).r.setVisibility(8);
                }
                ((ae) (obj1)).a.a = true;
                ((ae) (obj1)).a.setHeightRatio((float)imageitem.height / (float)imageitem.width);
                if (!imageitem.getMidleUrl().equals(((ae) (obj1)).a.getTag(0x2f0e24fb)) || !imageitem.getMidleUrl().equals(((ae) (obj1)).a.getTag(0x2f0e24fb)))
                {
                    com.bumptech.glide.b.b(m.a).a(((ae) (obj1)).a);
                    if (imageitem.getUrl().contains(".gif"))
                    {
                        m.a(imageitem.getUrl(), ((ae) (obj1)).a, com.bumptech.glide.request.e.b(l.a), null);
                    } else
                    {
                        viewholder = m;
                        String s1 = imageitem.getMidleUrl();
                        DynamicHeightImageView dynamicheightimageview = ((ae) (obj1)).a;
                        e e1 = com.bumptech.glide.request.e.b(l.a);
                        ((d) (viewholder)).b.g().a(s1).a(e1).a(com.bumptech.glide.a.a()).a(new com.picsart.studio.d._cls3(dynamicheightimageview, dynamicheightimageview));
                    }
                    ((ae) (obj1)).a.setTag(0x2f0e24fb, imageitem.getMidleUrl());
                }
                viewholder = new GestureDetector(context, this);
                viewholder.setOnDoubleTapListener(new _cls8(k1, ((ae) (obj1))));
                ((ae) (obj1)).q.setOnTouchListener(new _cls9(viewholder));
                if (h > 0 && h < 400)
                {
                    i1 = (int)Utils.a(40F, context);
                    ((ae) (obj1)).u.getLayoutParams().width = i1;
                    ((ae) (obj1)).u.getLayoutParams().height = i1;
                    ((ae) (obj1)).t.getLayoutParams().width = i1;
                    ((ae) (obj1)).t.getLayoutParams().height = i1;
                    ((ae) (obj1)).v.getLayoutParams().width = i1;
                    ((ae) (obj1)).v.getLayoutParams().height = i1;
                    ((ae) (obj1)).r.getLayoutParams().width = i1;
                    ((ae) (obj1)).r.getLayoutParams().height = i1;
                    return;
                }
            }
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i1)
    {
        if (i1 == 0)
        {
            if (context == null && viewgroup != null)
            {
                context = viewgroup.getContext();
            }
            viewgroup = myobfuscated.f.m.a(context, clickListener, viewgroup);
        } else
        {
            if (i1 == j)
            {
                return new ad(g.inflate(0x7f030262, viewgroup, false));
            }
            viewgroup = g.inflate(0x7f030209, viewgroup, false);
        }
        if (viewgroup != null)
        {
            viewgroup.measure(0, 0);
            h = viewgroup.getMeasuredWidth();
        } else
        {
            h = 0;
        }
        return new ae(viewgroup);
    }

    /* member class not found */
    class _cls18 {}


    /* member class not found */
    class _cls19 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls15 {}


    /* member class not found */
    class _cls16 {}


    /* member class not found */
    class _cls17 {}


    /* member class not found */
    class _cls20 {}


    /* member class not found */
    class _cls21 {}


    /* member class not found */
    class _cls22 {}


    /* member class not found */
    class _cls24 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls23 {}

}
