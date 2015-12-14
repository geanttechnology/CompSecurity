// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.co;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.e;
import com.picsart.studio.utils.ItemControl;
import com.picsart.studio.view.LinearHorizontalRecyclerView;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.w;
import com.socialin.android.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cd.a;

// Referenced classes of package myobfuscated.co:
//            a, e, f, d

public class c extends RecyclerViewAdapter
{

    private Activity a;
    private a b;
    private List c;
    private List d;
    private List e;
    private com.socialin.android.e f;
    private int g;
    private int h;
    private int i;
    private int j;
    private j k;
    private e l;

    public c(Context context, com.socialin.android.e e1)
    {
        super(context);
        c = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        a = (Activity)context;
        f = e1;
        e1 = (new StringBuilder()).append(myobfuscated/co/c.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
        e1 = com.socialin.android.util.c.a(context.getResources(), 0x7f0201f8, null, e1);
        e1.getHeight();
        b = new a(context.getResources(), e1);
        k = com.bumptech.glide.b.b(context).i().a(0.6F);
        l = (e)((e)com.bumptech.glide.request.e.e(context).a(0x7f020669)).b(0x7f020669);
        i = context.getResources().getColor(0x7f0f0091);
        j = context.getResources().getColor(0x7f0f0099);
    }

    static com.socialin.android.adapter.a a(c c1)
    {
        return c1.clickListener;
    }

    private void a()
    {
        e.clear();
        d.clear();
        c.clear();
        g = 0;
        h = 0;
    }

    private void a(LinearLayout linearlayout, List list)
    {
        linearlayout.setVisibility(0);
        LinearHorizontalRecyclerView linearhorizontalrecyclerview = new LinearHorizontalRecyclerView(context);
        linearhorizontalrecyclerview.setLayoutManager(new LinearLayoutManager(context, 0, false));
        ArrayList arraylist = new ArrayList();
        com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem;
        for (list = list.iterator(); list.hasNext(); arraylist.add(notificationitem.item))
        {
            notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.next();
            if (notificationitem.item.user == null)
            {
                notificationitem.item.user = notificationitem.user;
            }
        }

        list = new myobfuscated.co.a(context, clickListener);
        list.addAll(arraylist);
        linearhorizontalrecyclerview.setAdapter(list);
        linearlayout.addView(linearhorizontalrecyclerview);
    }

    private void a(TextView textview, ArrayList arraylist, CharSequence charsequence, int i1)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            textview.setVisibility(8);
            return;
        }
        Object obj = arraylist.iterator();
        int k1;
        for (k1 = 0; ((Iterator) (obj)).hasNext(); k1 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((Iterator) (obj)).next()).user.name.length() + k1) { }
        obj = new DisplayMetrics();
        a.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        int j1 = ((DisplayMetrics) (obj)).widthPixels;
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        int l1;
        if (j1 > 480)
        {
            if (arraylist.size() < 3)
            {
                j1 = arraylist.size();
            } else
            {
                j1 = 3;
            }
        } else
        if (arraylist.size() < 2)
        {
            j1 = arraylist.size();
        } else
        {
            j1 = 2;
        }
        l1 = 0;
        while (l1 < j1) 
        {
            Object obj2 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)arraylist.get(l1)).user;
            if (obj2 != null)
            {
                myobfuscated.ct.c c1 = new myobfuscated.ct.c(i, j, i1, ((ViewerUser) (obj2))) {

                    private int b;
                    private ViewerUser c;
                    private c d;

                    public final void onClick(View view)
                    {
                        c.i(d).a(b, ItemControl.OWNER_NAME_TEXT, new Object[] {
                            c
                        });
                    }

            
            {
                d = c.this;
                b = k1;
                c = vieweruser;
                super(0xff000000, i1, j1, 1);
            }
                };
                Object obj1;
                if (l1 != j1 - 1)
                {
                    obj1 = ", ";
                } else
                {
                    obj1 = "";
                }
                if (k1 > 25 && ((ViewerUser) (obj2)).name.length() > 15)
                {
                    obj2 = (new StringBuilder()).append(((ViewerUser) (obj2)).name.substring(0, 12)).append("...").toString();
                } else
                {
                    obj2 = ((ViewerUser) (obj2)).name;
                }
                obj1 = new SpannableString((new StringBuilder()).append(((String) (obj2))).append(((String) (obj1))).toString());
                ((SpannableString) (obj1)).setSpan(c1, 0, ((SpannableString) (obj1)).length(), 33);
                ((SpannableString) (obj1)).setSpan(new StyleSpan(1), 0, ((SpannableString) (obj1)).length(), 33);
                spannablestringbuilder.append(((CharSequence) (obj1)));
            }
            l1++;
        }
        if (arraylist.size() > 1)
        {
            spannablestringbuilder.append(new SpannableString(charsequence));
        }
        textview.setMovementMethod(new w());
        textview.setText(spannablestringbuilder);
        textview.setVisibility(0);
    }

    static com.socialin.android.adapter.a b(c c1)
    {
        return c1.clickListener;
    }

    private boolean b()
    {
        return g > 0 && h > 0;
    }

    static com.socialin.android.adapter.a c(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a d(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a e(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a f(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a g(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a h(c c1)
    {
        return c1.clickListener;
    }

    static com.socialin.android.adapter.a i(c c1)
    {
        return c1.clickListener;
    }

    public final myobfuscated.co.e a(int i1)
    {
        if (b())
        {
            if (i1 == 0)
            {
                myobfuscated.co.e e1 = new myobfuscated.co.e();
                e1.a = context.getString(0x7f080309);
                return e1;
            }
            if (i1 == g + 1)
            {
                myobfuscated.co.e e2 = new myobfuscated.co.e();
                e2.a = context.getString(0x7f080329);
                return e2;
            }
            if (i1 <= g)
            {
                return (myobfuscated.co.e)super.getItem(i1 - 1);
            } else
            {
                return (myobfuscated.co.e)super.getItem(i1 - 2);
            }
        }
        if (i1 >= getItems().size())
        {
            return null;
        } else
        {
            return (myobfuscated.co.e)super.getItem(i1);
        }
    }

    public void clear()
    {
        a();
        super.clear();
        notifyDataSetChanged();
    }

    public Object getItem(int i1)
    {
        return a(i1);
    }

    public int getItemCount()
    {
        if (b())
        {
            return super.getItemCount() + 2;
        } else
        {
            return super.getItemCount();
        }
    }

    public int getItemViewType(int i1)
    {
        return !b() || i1 != 0 && i1 != g + 1 ? 1 : 0;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i1)
    {
        myobfuscated.co.f f1 = (myobfuscated.co.f)viewholder;
        super.onBindViewHolder(f1, i1);
        myobfuscated.co.e e1 = a(i1);
        if (b() && getItemViewType(i1) == 0)
        {
            f1.a.setText(e1.a);
        } else
        {
            f1.d.setVisibility(8);
            f1.n.setVisibility(8);
            f1.l.removeAllViews();
            f1.l.setVisibility(8);
            f1.m.setVisibility(8);
            f1.f.setVisibility(8);
            f1.g.setVisibility(0);
            f1.i.setVisibility(0);
            f1.k.setOnClickListener(null);
            com.bumptech.glide.b.a(a).b();
            if (e1 != null && e1.b.size() != 0)
            {
                d d1 = e1.c;
                com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e1.b.get(0);
                String s = notificationitem.action;
                boolean flag;
                if (notificationitem.type != null && notificationitem.type.equals("update_available"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f1.g.setOnClickListener(new android.view.View.OnClickListener(i1) {

                    private int a;
                    private c b;

                    public final void onClick(View view)
                    {
                        myobfuscated.co.c.a(b).a(a, ItemControl.IMAGE, new Object[] {
                            Integer.valueOf(0)
                        });
                    }

            
            {
                b = c.this;
                a = i1;
                super();
            }
                });
                f1.b.setOnClickListener(new android.view.View.OnClickListener(i1) {

                    private int a;
                    private c b;

                    public final void onClick(View view)
                    {
                        myobfuscated.co.c.b(b).a(a, ItemControl.OWNER_IMAGE, new Object[0]);
                    }

            
            {
                b = c.this;
                a = i1;
                super();
            }
                });
                if (d1.e == null || d1.e.trim().equals(""))
                {
                    viewholder = d1.d;
                } else
                {
                    viewholder = d1.e;
                }
                if (viewholder != null)
                {
                    if ("like_added".equalsIgnoreCase(s) && e1.b.size() > 1)
                    {
                        f1.f.setVisibility(0);
                        f1.f.setImageResource(0x7f0205a0);
                        f1.i.setVisibility(8);
                    } else
                    {
                        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                        viewholder = new SpannableString(viewholder);
                        viewholder.setSpan(new myobfuscated.ct.c(i, j, i1) {

                            private int b;
                            private c c;

                            public final void onClick(View view)
                            {
                                c.c(c).a(b, ItemControl.OWNER_IMAGE, new Object[0]);
                            }

            
            {
                c = c.this;
                b = k1;
                super(0xff000000, i1, j1, 1);
            }
                        }, 0, viewholder.length(), 17);
                        viewholder.setSpan(new StyleSpan(1), 0, viewholder.length(), 17);
                        spannablestringbuilder.append(viewholder);
                        spannablestringbuilder.append(" ");
                        boolean flag1;
                        boolean flag2;
                        if (s.equalsIgnoreCase("facebook_added") || s.equalsIgnoreCase("twitter_added"))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag1)
                        {
                            viewholder = "";
                        } else
                        {
                            viewholder = d1.b;
                        }
                        spannablestringbuilder.append(new SpannableString(viewholder));
                        viewholder = spannablestringbuilder.toString();
                        if (viewholder.contains("[img]") && viewholder.contains("[/img]"))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag1 && (viewholder.contains(SocialinV3.RESOURCE_URL) || viewholder.contains(SocialinV3.SHOP_PACKAGE_ICON_URL)))
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        if (flag1 || flag2)
                        {
                            String s1 = spannablestringbuilder.subSequence(viewholder.indexOf("\"[img]") + 6, viewholder.length() - 7).toString();
                            k.a(s1).a(f1.d);
                            f1.d.setVisibility(0);
                            f1.f.setVisibility(0);
                            f1.f.setImageResource(0x7f02059e);
                            if (!flag2)
                            {
                                f1.d.setOnClickListener(new android.view.View.OnClickListener(i1, s1) {

                                    private int a;
                                    private String b;
                                    private c c;

                                    public final void onClick(View view)
                                    {
                                        c.d(c).a(a, ItemControl.COMMENT_IMAGE, new Object[] {
                                            b
                                        });
                                    }

            
            {
                c = c.this;
                a = i1;
                b = s;
                super();
            }
                                });
                            } else
                            {
                                f1.d.setClickable(false);
                            }
                            spannablestringbuilder.replace(viewholder.indexOf("\"[img]"), viewholder.length(), "");
                        } else
                        {
                            f1.d.setVisibility(8);
                            f1.f.setVisibility(0);
                            f1.f.setImageResource(0x7f02059e);
                        }
                        if (spannablestringbuilder.length() > 80)
                        {
                            spannablestringbuilder.replace(80, spannablestringbuilder.length(), "...");
                        }
                        f1.i.setText(spannablestringbuilder);
                        f1.i.setMovementMethod(new w());
                    }
                }
                if ("like_added".equalsIgnoreCase(s) || "friend_like_added".equalsIgnoreCase(s))
                {
                    if ("like_added".equalsIgnoreCase(s))
                    {
                        if (e1.b.size() == 1)
                        {
                            f1.m.setVisibility(8);
                            f1.i.setVisibility(0);
                            f1.f.setVisibility(0);
                            f1.f.setImageResource(0x7f0205a0);
                        } else
                        {
                            a(f1.m, e1.b, d1.b, i1);
                        }
                    }
                    if ("friend_like_added".equalsIgnoreCase(s) && e1.b.size() > 1)
                    {
                        f1.g.setVisibility(8);
                    }
                }
                if ("photo_reposted".equalsIgnoreCase(s) || "user_photo_reposted".equalsIgnoreCase(s))
                {
                    f1.f.setVisibility(0);
                    f1.f.setImageResource(0x7f0205f0);
                    if (e1.b.size() > 1)
                    {
                        f1.g.setVisibility(8);
                        a(f1.l, e1.b);
                    } else
                    {
                        f1.g.setVisibility(0);
                    }
                }
                if ("photo_added".equalsIgnoreCase(s))
                {
                    f1.f.setVisibility(0);
                    f1.f.setImageResource(0x7f02059d);
                    if (e1.b.size() > 1)
                    {
                        f1.g.setVisibility(8);
                        a(f1.l, e1.b);
                    } else
                    {
                        f1.g.setVisibility(0);
                    }
                }
                if ("appboy_news".equals(s))
                {
                    f1.n.setText(d1.b);
                    f1.n.setVisibility(0);
                    f1.e.setVisibility(8);
                    f1.g.setVisibility(8);
                    f1.i.setVisibility(8);
                    f1.b.setOnClickListener(new android.view.View.OnClickListener(i1, d1) {

                        private int a;
                        private d b;
                        private c c;

                        public final void onClick(View view)
                        {
                            myobfuscated.co.c.e(c).a(a, ItemControl.APPBOY_NEWS, new Object[] {
                                b.c
                            });
                        }

            
            {
                c = c.this;
                a = i1;
                b = d1;
                super();
            }
                    });
                    f1.k.setOnClickListener(new android.view.View.OnClickListener(i1, d1) {

                        private int a;
                        private d b;
                        private c c;

                        public final void onClick(View view)
                        {
                            myobfuscated.co.c.f(c).a(a, ItemControl.APPBOY_NEWS, new Object[] {
                                b.c
                            });
                        }

            
            {
                c = c.this;
                a = i1;
                b = d1;
                super();
            }
                    });
                }
                if ("facebook_added".equalsIgnoreCase(s) || "twitter_added".equalsIgnoreCase(s))
                {
                    f1.n.setText(d1.b);
                    f1.n.setVisibility(0);
                    f1.h.setVisibility(8);
                    f1.g.setVisibility(8);
                }
                if (e1.c.f == 1)
                {
                    f1.n.setText(d1.b);
                    f1.n.setVisibility(0);
                    f1.i.setVisibility(8);
                    f1.g.setVisibility(8);
                    f1.k.setOnClickListener(new android.view.View.OnClickListener(i1) {

                        private int a;
                        private c b;

                        public final void onClick(View view)
                        {
                            c.g(b).a(a, null, new Object[0]);
                        }

            
            {
                b = c.this;
                a = i1;
                super();
            }
                    });
                }
                if ("follower_added".equals(s))
                {
                    f1.f.setVisibility(0);
                    f1.f.setImageResource(0x7f02059f);
                    f1.g.setVisibility(8);
                }
                if (f1.g.getVisibility() == 0)
                {
                    viewholder = d1.c;
                    if (TextUtils.isEmpty(viewholder))
                    {
                        if (!"following_added".equals(s))
                        {
                            f1.e.setImageDrawable(b);
                        }
                    } else
                    if ("following_added".equals(s))
                    {
                        (new f(context)).a(viewholder, f1.e, l, null);
                        f1.f.setVisibility(0);
                        f1.f.setImageResource(0x7f02059f);
                        f1.g.setOnClickListener(new android.view.View.OnClickListener(i1) {

                            private int a;
                            private c b;

                            public final void onClick(View view)
                            {
                                c.h(b).a(a, ItemControl.FOLLOW_USER, new Object[] {
                                    Integer.valueOf(0)
                                });
                            }

            
            {
                b = c.this;
                a = i1;
                super();
            }
                        });
                    } else
                    {
                        k.a(viewholder).a(f1.e);
                    }
                }
                f1.h.setVisibility(0);
                if (e1.c.f == 1)
                {
                    f1.c.setImageResource(0x7f020598);
                    ((FrameLayout)f1.b).setForeground(null);
                } else
                if ("appboy_news".equals(s))
                {
                    f1.c.setImageResource(0x7f020598);
                } else
                {
                    if (notificationitem.user == null)
                    {
                        viewholder = "";
                    } else
                    {
                        viewholder = notificationitem.user.getPhoto();
                    }
                    (new f(context)).a(viewholder, f1.c, l, null);
                    ((FrameLayout)f1.b).setForeground(context.getResources().getDrawable(0x7f020618));
                }
                if (d1.a != null)
                {
                    f1.j.setText(GalleryUtils.a(d1.a, context));
                }
                if (flag)
                {
                    f1.k.setLongClickable(false);
                    return;
                }
            }
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return new myobfuscated.co.f(LayoutInflater.from(context).inflate(0x7f030187, viewgroup, false));

        case 0: // '\0'
            return new myobfuscated.co.f(LayoutInflater.from(context).inflate(0x7f030174, viewgroup, false));
        }
    }

    public void setItems(List list)
    {
        super.setItems(list);
        notifyDataSetChanged();
        a();
        list = getItems().iterator();
_L5:
        if (!list.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (myobfuscated.co.e)list.next();
        if (!SocialinV3.getInstance().isRegistered()) goto _L4; else goto _L3
_L3:
        boolean flag;
        Iterator iterator = ((myobfuscated.co.e) (obj)).b.iterator();
        com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_375;
            }
            notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator.next();
        } while (notificationitem.read != 2 && notificationitem.read != 1);
        h = h + 1;
        flag = true;
_L11:
        if (!flag)
        {
            g = g + 1;
        }
_L6:
        if (((myobfuscated.co.e) (obj)).c.f == 2)
        {
            d.add(obj);
        } else
        if (((myobfuscated.co.e) (obj)).c.f == 0 || ((myobfuscated.co.e) (obj)).c.f == 1)
        {
            c.add(obj);
        }
          goto _L5
_L4:
        if (((myobfuscated.co.e) (obj)).c.f == 1)
        {
            e.add(obj);
            if (((myobfuscated.co.e) (obj)).d == 0)
            {
                g = g + 1;
            }
        }
          goto _L6
_L2:
        if (!b()) goto _L8; else goto _L7
_L7:
        ArrayList arraylist;
        Iterator iterator1;
        list = new ArrayList();
        obj = new ArrayList();
        arraylist = new ArrayList();
        iterator1 = getItems().iterator();
_L10:
        if (iterator1.hasNext())
        {
            myobfuscated.co.e e1 = (myobfuscated.co.e)iterator1.next();
            switch (e1.d)
            {
            default:
                arraylist.add(e1);
                break;

            case 0: // '\0'
                ((List) (obj)).add(e1);
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        list.addAll(((java.util.Collection) (obj)));
        list.addAll(arraylist);
        super.setItems(list);
_L8:
        f.a(g);
        return;
        if (true) goto _L10; else goto _L9
_L9:
        flag = false;
          goto _L11
    }
}
