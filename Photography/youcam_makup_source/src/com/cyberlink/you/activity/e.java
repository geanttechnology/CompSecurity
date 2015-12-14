// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.you.d.b;
import com.cyberlink.you.d.c;
import com.cyberlink.you.d.d;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.l;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.g;
import com.cyberlink.you.m;
import com.cyberlink.you.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.sticker.EmojiHelper;
import com.cyberlink.you.sticker.StickerFragment;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.h;
import com.cyberlink.you.widgetpool.common.GifImageView;
import com.cyberlink.you.widgetpool.common.PhotoThumbImageView;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, j, a, c, 
//            g

class e extends ArrayAdapter
{

    final ChatDialogActivity a;
    private final int b = Math.round(TypedValue.applyDimension(1, 150F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private int c;
    private final int d = Math.round(TypedValue.applyDimension(1, 110F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private final int e = Math.round(TypedValue.applyDimension(1, 130F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private final int f = Math.round(TypedValue.applyDimension(1, 16F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private final int g = Math.round(TypedValue.applyDimension(1, 30F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private final int h = Math.round(TypedValue.applyDimension(1, 32F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
    private List i;
    private List j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;

    public e(ChatDialogActivity chatdialogactivity, Context context, int i1, List list)
    {
        a = chatdialogactivity;
        super(context, i1);
        c = Math.round(TypedValue.applyDimension(1, 100F, com.cyberlink.you.g.I().getResources().getDisplayMetrics()));
        k = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(com.cyberlink.you.activity.ChatDialogActivity.g(a.a), false);
            }

            
            {
                a = e.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(a.a);
            }

            
            {
                a = e.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                view = (Integer)view.getTag();
                if (view != null)
                {
                    int j1 = view.intValue();
                    view = a.b(j1);
                    if (view != null && view.g() != null)
                    {
                        view = com.cyberlink.you.activity.ChatDialogActivity.b(a.a, view);
                        if (view != null)
                        {
                            long l1 = view.c();
                            StickerPackObj stickerpackobj = com.cyberlink.you.e.i().a(l1);
                            if (stickerpackobj != null)
                            {
                                if (stickerpackobj.q() && !stickerpackobj.j().equals(com.cyberlink.you.database.StickerPackObj.Status.a))
                                {
                                    if (!com.cyberlink.you.activity.ChatDialogActivity.o(a.a).d().isVisible())
                                    {
                                        com.cyberlink.you.activity.ChatDialogActivity.o(a.a).a(true);
                                    }
                                    com.cyberlink.you.activity.ChatDialogActivity.o(a.a).d().a(view.c());
                                    return;
                                } else
                                {
                                    ChatDialogActivity.a(a.a, stickerpackobj);
                                    return;
                                }
                            } else
                            {
                                view = ProgressDialog.show(com.cyberlink.you.activity.ChatDialogActivity.g(a.a), "", a.a.getString(r.u_loading), true);
                                (new com.cyberlink.you.activity.c(a.a, l1, new com.cyberlink.you.activity.g(this, view) {

                                    final ProgressDialog a;
                                    final _cls5 b;

                                    public void a(StickerPackObj stickerpackobj)
                                    {
                                        if (a != null && a.isShowing())
                                        {
                                            a.dismiss();
                                        }
                                        if (stickerpackobj == null)
                                        {
                                            return;
                                        } else
                                        {
                                            com.cyberlink.you.e.i().a(stickerpackobj);
                                            ChatDialogActivity.a(b.a.a, stickerpackobj);
                                            return;
                                        }
                                    }

            
            {
                b = _pcls5;
                a = progressdialog;
                super();
            }
                                })).executeOnExecutor(com.cyberlink.you.activity.ChatDialogActivity.b, new Void[0]);
                                return;
                            }
                        }
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                view = (Integer)view.getTag();
                if (view != null)
                {
                    int j1 = view.intValue();
                    view = a.b(j1);
                    if (view != null && view.g() != null)
                    {
                        try
                        {
                            long l1 = Long.valueOf(view.b("postId")).longValue();
                            e.a(a, l1);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                view = (Integer)view.getTag();
                if (view != null)
                {
                    int j1 = view.intValue();
                    view = a.b(j1);
                    if (view != null && view.g() != null)
                    {
                        try
                        {
                            long l1 = Long.valueOf(view.i()).longValue();
                            com.cyberlink.you.activity.e.b(a, l1);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                view = (Integer)view.getTag();
                if (view != null)
                {
                    int j1 = view.intValue();
                    view = a.b(j1);
                    if (view != null && view.g() != null)
                    {
                        try
                        {
                            long l1 = Long.valueOf(view.b("authorUserId")).longValue();
                            com.cyberlink.you.activity.e.b(a, l1);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        i = list;
        j = new ArrayList();
    }

    private View a(int i1, int j1, ViewGroup viewgroup, d d1)
    {
        LayoutInflater layoutinflater = (LayoutInflater)com.cyberlink.you.activity.ChatDialogActivity.g(a).getSystemService("layout_inflater");
        if (j1 == 0)
        {
            viewgroup = com.cyberlink.you.d.c.a(d1, layoutinflater, viewgroup);
            d1.e.setOnClickListener(k);
            d1.m = com.cyberlink.you.activity.ChatDialogActivity.h() - c(i1);
            a.registerForContextMenu(d1.e);
        } else
        if (j1 == 1)
        {
            viewgroup = com.cyberlink.you.d.c.b(d1, layoutinflater, viewgroup);
            d1.c.setOnClickListener(m);
            a.registerForContextMenu(d1.c);
        } else
        if (j1 == 2)
        {
            viewgroup = com.cyberlink.you.d.c.c(d1, layoutinflater, viewgroup);
            d1.d.setOnClickListener(m);
            a.registerForContextMenu(d1.d);
        } else
        if (j1 == 4)
        {
            viewgroup = com.cyberlink.you.d.c.d(d1, layoutinflater, viewgroup);
            d1.c.setOnClickListener(m);
            a.registerForContextMenu(d1.c);
        } else
        if (j1 == 6)
        {
            viewgroup = com.cyberlink.you.d.c.e(d1, layoutinflater, viewgroup);
            d1.p.setOnClickListener(n);
            d1.x.setOnClickListener(p);
            a.registerForContextMenu(d1.p);
        } else
        if (j1 == 7)
        {
            viewgroup = com.cyberlink.you.d.b.a(d1, layoutinflater, viewgroup);
            a.registerForContextMenu(d1.e);
            d1.e.setOnClickListener(k);
            d1.b.setOnClickListener(o);
            d1.m = ChatDialogActivity.i() - c(i1);
        } else
        if (j1 == 8)
        {
            viewgroup = com.cyberlink.you.d.b.b(d1, layoutinflater, viewgroup);
            d1.c.setOnClickListener(m);
            d1.b.setOnClickListener(o);
            a.registerForContextMenu(d1.c);
        } else
        if (j1 == 9)
        {
            viewgroup = com.cyberlink.you.d.b.c(d1, layoutinflater, viewgroup);
            d1.d.setOnClickListener(m);
            d1.b.setOnClickListener(o);
            a.registerForContextMenu(d1.d);
        } else
        if (j1 == 11)
        {
            viewgroup = com.cyberlink.you.d.b.d(d1, layoutinflater, viewgroup);
            d1.c.setOnClickListener(m);
            d1.b.setOnClickListener(o);
            a.registerForContextMenu(d1.c);
        } else
        if (j1 == 12)
        {
            viewgroup = com.cyberlink.you.d.b.e(d1, layoutinflater, viewgroup);
            viewgroup.findViewById(o.update_text).setOnClickListener(l);
            d1.m = ChatDialogActivity.j();
        } else
        if (j1 == 14)
        {
            viewgroup = com.cyberlink.you.d.b.f(d1, layoutinflater, viewgroup);
            d1.p.setOnClickListener(n);
            d1.b.setOnClickListener(o);
            d1.x.setOnClickListener(p);
            a.registerForContextMenu(d1.p);
        } else
        if (j1 == 15)
        {
            viewgroup = layoutinflater.inflate(p.u_view_item_date_msg, viewgroup, false);
            d1.n = (TextView)viewgroup.findViewById(o.dateView);
        } else
        if (j1 == 18)
        {
            viewgroup = layoutinflater.inflate(p.u_view_item_unread_line_msg, viewgroup, false);
        } else
        if (j1 == 16 || j1 == 17)
        {
            viewgroup = layoutinflater.inflate(p.u_view_item_event_msg, viewgroup, false);
            d1.o = (TextView)viewgroup.findViewById(o.eventView);
            d1.o.setTag(Integer.valueOf(i1));
        } else
        if (a(0, j1))
        {
            viewgroup = com.cyberlink.you.d.c.a(d1, layoutinflater, viewgroup);
            d1.e.setOnClickListener(k);
            d1.m = com.cyberlink.you.activity.ChatDialogActivity.h() - c(i1);
            a.registerForContextMenu(d1.e);
        } else
        if (a(7, j1))
        {
            viewgroup = com.cyberlink.you.d.b.a(d1, layoutinflater, viewgroup);
            d1.e.setOnClickListener(k);
            d1.m = com.cyberlink.you.activity.ChatDialogActivity.h() - c(i1);
            a.registerForContextMenu(d1.e);
        } else
        {
            viewgroup = null;
        }
        if (d1.m != 0 && d1.e != null)
        {
            d1.e.setMaxWidth(d1.m);
        }
        return viewgroup;
    }

    static List a(e e1)
    {
        return e1.j;
    }

    private void a(int i1, View view, int j1)
    {
        if (view == null)
        {
            Log.d("ChatDialogActivity", "[updateListener] get null convertView");
        } else
        {
            d d1 = (d)view.getTag();
            if (d1 != null)
            {
                int k1 = com.cyberlink.you.activity.ChatDialogActivity.c(a).getHeaderViewsCount();
                if (d1.s != null)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.s.setVisibility(8);
                    } else
                    if (isEnabled(j1))
                    {
                        d1.s.setVisibility(0);
                        d1.s.setSelected(com.cyberlink.you.activity.ChatDialogActivity.c(a).isItemChecked(k1 + j1));
                    } else
                    {
                        d1.s.setVisibility(4);
                    }
                }
                if (i1 == 0)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.e.setLongClickable(true);
                        d1.e.setClickable(true);
                        return;
                    } else
                    {
                        d1.e.setLongClickable(false);
                        d1.e.setClickable(false);
                        return;
                    }
                }
                if (i1 == 1)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.c.setLongClickable(true);
                        d1.c.setClickable(true);
                        return;
                    } else
                    {
                        d1.c.setLongClickable(false);
                        d1.c.setClickable(false);
                        return;
                    }
                }
                if (i1 == 2)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.d.setLongClickable(true);
                        d1.d.setClickable(true);
                        return;
                    } else
                    {
                        d1.d.setLongClickable(false);
                        d1.d.setClickable(false);
                        return;
                    }
                }
                if (i1 == 4)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.c.setLongClickable(true);
                        d1.c.setClickable(true);
                        return;
                    } else
                    {
                        d1.c.setLongClickable(false);
                        d1.c.setClickable(false);
                        return;
                    }
                }
                if (i1 == 7)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.e.setLongClickable(true);
                        d1.e.setClickable(true);
                        d1.b.setClickable(true);
                        return;
                    } else
                    {
                        d1.e.setLongClickable(false);
                        d1.e.setClickable(false);
                        d1.b.setClickable(false);
                        return;
                    }
                }
                if (i1 == 8)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.c.setLongClickable(true);
                        d1.c.setClickable(true);
                        d1.b.setClickable(true);
                        return;
                    } else
                    {
                        d1.c.setLongClickable(false);
                        d1.c.setClickable(false);
                        d1.b.setClickable(false);
                        return;
                    }
                }
                if (i1 == 9)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.d.setLongClickable(true);
                        d1.d.setClickable(true);
                        d1.b.setClickable(true);
                        return;
                    } else
                    {
                        d1.d.setLongClickable(false);
                        d1.d.setClickable(false);
                        d1.b.setClickable(false);
                        return;
                    }
                }
                if (i1 == 11)
                {
                    if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                    {
                        d1.c.setLongClickable(true);
                        d1.c.setClickable(true);
                        d1.b.setClickable(true);
                        return;
                    } else
                    {
                        d1.c.setLongClickable(false);
                        d1.c.setClickable(false);
                        d1.b.setClickable(false);
                        return;
                    }
                }
                if (i1 != 15 && i1 != 18)
                {
                    if (i1 == 16 || i1 == 17)
                    {
                        if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                        {
                            d1.o.setLongClickable(true);
                            return;
                        } else
                        {
                            d1.o.setLongClickable(false);
                            return;
                        }
                    }
                    if (i1 == 12)
                    {
                        if (ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
                        {
                            view.findViewById(o.update_text).setLongClickable(true);
                            return;
                        } else
                        {
                            view.findViewById(o.update_text).setLongClickable(false);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void a(int i1, d d1, int j1)
    {
        if (i != null && j1 < getCount()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = b(j1);
        if (!a(0, i1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!com.cyberlink.you.chat.d.b(((MessageObj) (obj)))) goto _L4; else goto _L3
_L3:
        if (d1.g != null)
        {
            if (com.cyberlink.you.g.a().q().before(((MessageObj) (obj)).d()))
            {
                j1 = (int)com.cyberlink.you.activity.ChatDialogActivity.b(a).g - 1;
                int k1 = ((MessageObj) (obj)).h();
                if (j1 >= k1)
                {
                    j1 = k1;
                }
                if (j1 != 0)
                {
                    if (com.cyberlink.you.activity.ChatDialogActivity.b(a).e.equals("Dual"))
                    {
                        d1.g.setText(a.getString(r.u_chat_dialog_read));
                    } else
                    {
                        String s = String.format(a.getResources().getString(r.u_chat_dialog_read_by), new Object[] {
                            Integer.valueOf(j1)
                        });
                        d1.g.setText(s);
                    }
                } else
                {
                    d1.g.setText("");
                }
            } else
            {
                d1.g.setText("");
            }
        }
        if (d1.q != null)
        {
            d1.q.setVisibility(8);
        }
        if (d1.h != null)
        {
            d1.h.setText(com.cyberlink.you.utility.d.c(((MessageObj) (obj)).d()));
        }
        if (d1.r != null)
        {
            d1.r.setVisibility(8);
        }
_L6:
        if (!((MessageObj) (obj)).e().equals(com.cyberlink.you.database.MessageObj.MessageType.j))
        {
            if (d1.j != null)
            {
                d1.j.setVisibility(0);
            }
            d1.h.setVisibility(0);
        }
        if (i1 == 0)
        {
            if (EmojiHelper.a(com.cyberlink.you.activity.ChatDialogActivity.g(a), ((MessageObj) (obj)).g()))
            {
                ((EmojiconTextView)d1.e).setEmojiconSize(h);
            }
            d1.e.setText(((MessageObj) (obj)).g());
            ChatDialogActivity.a(a, d1.e);
            d1.f.setBackgroundResource(n.u_img_chats_bg_02);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (com.cyberlink.you.chat.d.e(((MessageObj) (obj))))
        {
            if (d1.g != null)
            {
                d1.g.setText("");
            }
            if (d1.q != null)
            {
                d1.q.setVisibility(0);
            }
            if (d1.h != null)
            {
                d1.h.setText("");
            }
            if (d1.r != null)
            {
                d1.r.setVisibility(8);
            }
        } else
        if (com.cyberlink.you.chat.d.c(((MessageObj) (obj))) || com.cyberlink.you.chat.d.d(((MessageObj) (obj))))
        {
            if (d1.g != null)
            {
                d1.g.setText("");
            }
            if (d1.q != null)
            {
                d1.q.setVisibility(8);
            }
            if (d1.h != null)
            {
                d1.h.setText("");
            }
            if (d1.r != null)
            {
                if (com.cyberlink.you.chat.d.a(((MessageObj) (obj))) && !com.cyberlink.you.chat.d.d(((MessageObj) (obj))))
                {
                    d1.r.setVisibility(8);
                } else
                {
                    Date date = ((MessageObj) (obj)).n();
                    if (date == null)
                    {
                        d1.r.setVisibility(0);
                    } else
                    if ((new Date()).getTime() - date.getTime() >= 1000L)
                    {
                        d1.r.setVisibility(0);
                    } else
                    {
                        d1.r.setVisibility(8);
                    }
                }
            }
        } else
        {
            if (d1.g != null)
            {
                d1.g.setText("");
            }
            if (d1.q != null)
            {
                d1.q.setVisibility(8);
            }
            if (d1.h != null)
            {
                d1.h.setText("");
            }
            if (d1.r != null)
            {
                d1.r.setVisibility(8);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (i1 == 1)
        {
            obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
            if (obj != null)
            {
                Pair pair = b(((StickerObj) (obj)).j(), ((StickerObj) (obj)).k());
                d1.c.getLayoutParams().height = ((Integer)pair.second).intValue();
                d1.c.getLayoutParams().width = ((Integer)pair.first).intValue();
                LoadImageUtils.a(getContext(), ((StickerObj) (obj)), false, d1.c, com.cyberlink.you.activity.ChatDialogActivity.h(a));
                return;
            }
        } else
        if (i1 == 2)
        {
            obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
            if (obj != null)
            {
                File file = new File(((StickerObj) (obj)).g());
                if (!file.getPath().equals("_") && file.exists())
                {
                    d1.d.setGifImage(file);
                } else
                {
                    Object obj1 = new File(com.cyberlink.you.utility.d.a(((StickerObj) (obj)).c()));
                    if (!((File) (obj1)).exists())
                    {
                        ((File) (obj1)).mkdir();
                    }
                    obj1 = (new StringBuilder()).append(obj1).append(File.separator).append(Long.toString(((StickerObj) (obj)).b())).toString();
                    ((StickerObj) (obj)).a(((String) (obj1)));
                    com.cyberlink.you.e.h().a(((StickerObj) (obj)).b(), ((StickerObj) (obj)));
                    LoadImageUtils.a(((StickerObj) (obj)).f(), d1.d, ((String) (obj1)));
                }
                if (com.cyberlink.you.activity.ChatDialogActivity.h(a))
                {
                    d1.d.a();
                    return;
                } else
                {
                    d1.d.b();
                    return;
                }
            }
        } else
        if (i1 == 4)
        {
            obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
            if (obj != null)
            {
                Pair pair1 = b(((StickerObj) (obj)).j(), ((StickerObj) (obj)).k());
                d1.c.getLayoutParams().height = ((Integer)pair1.second).intValue();
                d1.c.getLayoutParams().width = ((Integer)pair1.first).intValue();
                LoadImageUtils.a(getContext(), ((StickerObj) (obj)), d1.c, com.cyberlink.you.activity.ChatDialogActivity.h(a));
                return;
            }
        } else
        if (i1 == 6)
        {
            String s1 = ((MessageObj) (obj)).b("authorThumbnail");
            String s4 = ((MessageObj) (obj)).b("authorName");
            String s6 = ((MessageObj) (obj)).b("postTitle");
            String s8 = ((MessageObj) (obj)).b("postThumbnail");
            String s10 = ((MessageObj) (obj)).b("likeCount");
            String s12 = ((MessageObj) (obj)).b("replyCount");
            String s14 = ((MessageObj) (obj)).b("circleInCount");
            String s16 = ((MessageObj) (obj)).b("category");
            String s18 = ((MessageObj) (obj)).b("width");
            obj = ((MessageObj) (obj)).b("height");
            d1.e.setText(s6);
            d1.u.setText(s10);
            d1.v.setText(s12);
            d1.w.setText(s14);
            d1.y.setText(s4);
            d1.z.setText(s16);
            PhotoThumbImageView.a(d1.t, Integer.valueOf(s18).intValue(), Integer.valueOf(((String) (obj))).intValue());
            LoadImageUtils.a(s1, d1.x);
            LoadImageUtils.b(s8, d1.t);
            return;
        } else
        {
            d1.e.setText("Unknown message.");
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        if (a(7, i1))
        {
            if (!((MessageObj) (obj)).e().equals(com.cyberlink.you.database.MessageObj.MessageType.j))
            {
                String s2 = ((MessageObj) (obj)).i();
                b(d1.b, d1.a, null, s2);
                if (d1.j != null)
                {
                    d1.j.setVisibility(0);
                }
            }
            d1.h.setText(com.cyberlink.you.utility.d.c(((MessageObj) (obj)).d()));
            if (i1 == 7)
            {
                if (EmojiHelper.a(com.cyberlink.you.activity.ChatDialogActivity.g(a), ((MessageObj) (obj)).g()))
                {
                    ((EmojiconTextView)d1.e).setEmojiconSize(48);
                }
                d1.f.setBackgroundResource(n.u_img_chats_bg_01);
                d1.e.setText(((MessageObj) (obj)).g());
                ChatDialogActivity.a(a, d1.e);
                return;
            }
            if (i1 == 8)
            {
                obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
                if (obj != null)
                {
                    Pair pair2 = b(((StickerObj) (obj)).j(), ((StickerObj) (obj)).k());
                    d1.c.getLayoutParams().height = ((Integer)pair2.second).intValue();
                    d1.c.getLayoutParams().width = ((Integer)pair2.first).intValue();
                    LoadImageUtils.a(getContext(), ((StickerObj) (obj)), false, d1.c, com.cyberlink.you.activity.ChatDialogActivity.h(a));
                    return;
                }
            } else
            if (i1 == 9)
            {
                obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
                if (obj != null)
                {
                    File file1 = new File(((StickerObj) (obj)).g());
                    if (!file1.getPath().equals("_") && file1.exists())
                    {
                        d1.d.setGifImage(file1);
                    } else
                    {
                        Object obj2 = new File(com.cyberlink.you.utility.d.a(((StickerObj) (obj)).c()));
                        if (!((File) (obj2)).exists())
                        {
                            ((File) (obj2)).mkdir();
                        }
                        obj2 = (new StringBuilder()).append(obj2).append(File.separator).append(Long.toString(((StickerObj) (obj)).b())).toString();
                        ((StickerObj) (obj)).a(((String) (obj2)));
                        com.cyberlink.you.e.h().a(((StickerObj) (obj)).b(), ((StickerObj) (obj)));
                        LoadImageUtils.a(((StickerObj) (obj)).f(), d1.d, ((String) (obj2)));
                    }
                    if (com.cyberlink.you.activity.ChatDialogActivity.h(a))
                    {
                        d1.d.a();
                        return;
                    } else
                    {
                        d1.d.b();
                        return;
                    }
                }
            } else
            if (i1 == 11)
            {
                obj = com.cyberlink.you.activity.ChatDialogActivity.b(a, ((MessageObj) (obj)));
                if (obj != null)
                {
                    Pair pair3 = b(((StickerObj) (obj)).j(), ((StickerObj) (obj)).k());
                    d1.c.getLayoutParams().height = ((Integer)pair3.second).intValue();
                    d1.c.getLayoutParams().width = ((Integer)pair3.first).intValue();
                    LoadImageUtils.a(getContext(), ((StickerObj) (obj)), d1.c, com.cyberlink.you.activity.ChatDialogActivity.h(a));
                    return;
                }
            } else
            {
                if (i1 == 14)
                {
                    String s3 = ((MessageObj) (obj)).b("authorThumbnail");
                    String s5 = ((MessageObj) (obj)).b("authorName");
                    String s7 = ((MessageObj) (obj)).b("postTitle");
                    String s9 = ((MessageObj) (obj)).b("postThumbnail");
                    String s11 = ((MessageObj) (obj)).b("likeCount");
                    String s13 = ((MessageObj) (obj)).b("replyCount");
                    String s15 = ((MessageObj) (obj)).b("circleInCount");
                    String s17 = ((MessageObj) (obj)).b("category");
                    String s19 = ((MessageObj) (obj)).b("width");
                    obj = ((MessageObj) (obj)).b("height");
                    d1.e.setText(s7);
                    d1.u.setText(s11);
                    d1.v.setText(s13);
                    d1.w.setText(s15);
                    d1.y.setText(s5);
                    d1.z.setText(s17);
                    PhotoThumbImageView.a(d1.t, Integer.valueOf(s19).intValue(), Integer.valueOf(((String) (obj))).intValue());
                    LoadImageUtils.a(s3, d1.x);
                    LoadImageUtils.b(s9, d1.t);
                    return;
                }
                if (i1 == 12)
                {
                    b(null, d1.e, Integer.valueOf(r.u_need_update_description), ((MessageObj) (obj)).i());
                    d1.h.setText(com.cyberlink.you.utility.d.c(((MessageObj) (obj)).d()));
                    return;
                } else
                {
                    d1.e.setText("Unknown message.");
                    return;
                }
            }
        } else
        {
            Log.d("ChatDialogActivity", (new StringBuilder()).append("viewType ").append(i1).append(" not update").toString());
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void a(long l1)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse((new StringBuilder()).append("ybcbc://post/").append(l1).toString()));
        Object obj = a.getPackageManager().queryIntentActivities(intent, 0).iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (ResolveInfo)((Iterator) (obj)).next();
            intent.setComponent(new ComponentName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name));
        }
        a.startActivity(intent);
    }

    private void a(ImageView imageview, TextView textview, Integer integer, Friend friend)
    {
label0:
        {
            if (textview != null)
            {
                if (friend.b() != null && !friend.b().isEmpty())
                {
                    if (integer != null)
                    {
                        textview.setText(a.getString(integer.intValue(), new Object[] {
                            friend.b()
                        }));
                    } else
                    {
                        textview.setText(friend.b());
                    }
                } else
                {
                    textview.setText("");
                }
            }
            if (imageview != null)
            {
                if (friend.b == null || friend.b.isEmpty())
                {
                    break label0;
                }
                LoadImageUtils.a(getContext(), friend, imageview);
            }
            return;
        }
        imageview.setImageResource(n.u_pic_default);
    }

    private void a(ImageView imageview, TextView textview, Integer integer, String s)
    {
        Object obj = new Object();
        if (textview != null)
        {
            textview.setText("");
            textview.setTag(obj);
        }
        if (imageview != null)
        {
            imageview.setImageResource(n.u_pic_default);
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        arraylist.add(new BasicNameValuePair("userId", s));
        a.a.a("user", "userInfo", arraylist, new com.cyberlink.you.friends.p(textview, obj, imageview, integer) {

            final TextView a;
            final Object b;
            final ImageView c;
            final Integer d;
            final e e;

            public void a(String s1, String s2, String s3, String s4)
            {
                if (s3 == null)
                {
                    Log.d("ChatDialogActivity", "Response is null");
                    return;
                }
                if (!s3.equals("200"))
                {
                    Log.d("ChatDialogActivity", (new StringBuilder()).append("statusCode=").append(s3).toString());
                    return;
                }
                s1 = com.cyberlink.you.utility.h.a(com.cyberlink.you.utility.h.c(s4));
                com.cyberlink.you.e.g().a(s1);
                if (ChatDialogActivity.N(e.a) != null)
                {
                    ChatDialogActivity.N(e.a).put(Long.valueOf(((Friend) (s1)).a), s1);
                }
                com.cyberlink.you.activity.ChatDialogActivity.g(e.a).runOnUiThread(new Runnable(this, s1) {

                    final Friend a;
                    final _cls1 b;

                    public void run()
                    {
                        Object obj = b.a.getTag();
                        if (obj != null && obj == b.b)
                        {
                            e.a(b.e, b.c, b.a, b.d, a);
                        }
                    }

            
            {
                b = _pcls1;
                a = friend;
                super();
            }
                });
            }

            
            {
                e = e.this;
                a = textview;
                b = obj;
                c = imageview;
                d = integer;
                super();
            }
        });
    }

    static void a(e e1, long l1)
    {
        e1.a(l1);
    }

    static void a(e e1, ImageView imageview, TextView textview, Integer integer, Friend friend)
    {
        e1.a(imageview, textview, integer, friend);
    }

    static void a(e e1, com.cyberlink.you.database.g g1)
    {
        e1.a(g1);
    }

    private void a(d d1, MessageObj messageobj)
    {
        if (!messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.b)) goto _L2; else goto _L1
_L1:
        d1.o.setVisibility(0);
        String s = String.format(a.getResources().getString(r.u_event_group_member_leave), new Object[] {
            messageobj.g()
        });
        d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s).toString());
_L4:
        return;
_L2:
        if (!messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.c))
        {
            break; /* Loop/switch isn't completed */
        }
        if (com.cyberlink.you.activity.ChatDialogActivity.b(a) != null)
        {
            if (com.cyberlink.you.activity.ChatDialogActivity.b(a).e.equals("ChatRoom"))
            {
                d1.o.setVisibility(0);
                String s1 = String.format(a.getResources().getString(r.u_event_chat_member_create), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s1).toString());
                return;
            }
            if (Group.a(com.cyberlink.you.activity.ChatDialogActivity.b(a).e))
            {
                d1.o.setVisibility(0);
                String s2 = String.format(a.getResources().getString(r.u_event_group_member_create), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s2).toString());
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.d))
        {
            if (com.cyberlink.you.activity.ChatDialogActivity.b(a).e.equals("ChatRoom"))
            {
                d1.o.setVisibility(0);
                String s3 = String.format(a.getResources().getString(r.u_event_chat_member_delete), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s3).toString());
                return;
            }
            if (Group.a(com.cyberlink.you.activity.ChatDialogActivity.b(a).e))
            {
                d1.o.setVisibility(0);
                String s4 = String.format(a.getResources().getString(r.u_event_group_member_delete), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s4).toString());
                return;
            }
        } else
        {
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.g))
            {
                d1.o.setVisibility(0);
                String s5 = String.format(a.getResources().getString(r.u_event_group_admin_create), new Object[] {
                    messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s5).toString());
                return;
            }
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.f))
            {
                d1.o.setVisibility(0);
                String s6 = String.format(a.getResources().getString(r.u_event_group_admin_delete), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s6).toString());
                return;
            }
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.e))
            {
                d1.o.setVisibility(0);
                String s7 = String.format(a.getResources().getString(r.u_event_group_photo_create), new Object[] {
                    ""
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.b(messageobj.d())).append("\n").append(s7).toString());
                return;
            }
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.i))
            {
                d1.o.setVisibility(0);
                String s8 = String.format(a.getResources().getString(r.u_event_group_album_create), new Object[] {
                    ""
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.b(messageobj.d())).append("\n").append(s8).toString());
                return;
            }
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.j))
            {
                d1.o.setVisibility(0);
                String s9 = String.format(a.getResources().getString(r.u_event_group_album_delete), new Object[] {
                    ""
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.b(messageobj.d())).append("\n").append(s9).append("\n").append(messageobj.g()).toString());
                return;
            }
            if (messageobj.f().equals(com.cyberlink.you.database.MessageObj.MemberStatus.l))
            {
                d1.o.setVisibility(0);
                String s10 = String.format(a.getResources().getString(r.u_event_group_display_name_update), new Object[] {
                    "", messageobj.g()
                });
                d1.o.setText((new StringBuilder()).append(com.cyberlink.you.utility.d.a(messageobj.d())).append("\n").append(s10).toString());
                return;
            } else
            {
                d1.o.setVisibility(8);
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void a(com.cyberlink.you.database.g g1)
    {
        Collections.sort(i, new com.cyberlink.you.database.g());
        notifyDataSetChanged();
    }

    private boolean a(int i1, MessageObj messageobj)
    {
        return a(i1, f(messageobj));
    }

    private Pair b(int i1, int j1)
    {
        if (j1 > i1)
        {
            float f1 = (float)d / (float)i1;
            return Pair.create(Integer.valueOf(d), Integer.valueOf(Math.round(f1 * (float)j1)));
        } else
        {
            return Pair.create(Integer.valueOf(Math.round(((float)d / (float)j1) * (float)i1)), Integer.valueOf(d));
        }
    }

    private void b(int i1, d d1, int j1)
    {
        if (i1 == 0 || i1 == 7)
        {
            d1.e.setTag(Integer.valueOf(j1));
        }
        if (i1 == 2 || i1 == 9)
        {
            d1.d.setTag(Integer.valueOf(j1));
        }
        if (i1 == 1 || i1 == 8 || i1 == 4 || i1 == 11)
        {
            d1.c.setTag(Integer.valueOf(j1));
        }
        if (i1 == 6 || i1 == 14)
        {
            d1.p.setTag(Integer.valueOf(j1));
            d1.x.setTag(Integer.valueOf(j1));
        }
        if (a(7, i1))
        {
            d1.b.setTag(Integer.valueOf(j1));
        }
    }

    private void b(long l1)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse((new StringBuilder()).append("ybcbc://me/").append(l1).toString()));
        Object obj = a.getPackageManager().queryIntentActivities(intent, 0).iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (ResolveInfo)((Iterator) (obj)).next();
            intent.setComponent(new ComponentName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name));
        }
        a.startActivity(intent);
    }

    private void b(ImageView imageview, TextView textview, Integer integer, String s)
    {
        Friend friend = com.cyberlink.you.activity.ChatDialogActivity.g(a, s);
        if (friend != null)
        {
            a(imageview, textview, integer, friend);
        } else
        if (s != null)
        {
            a(imageview, textview, integer, s);
            return;
        }
    }

    static void b(e e1, long l1)
    {
        e1.b(l1);
    }

    private int c(int i1)
    {
        boolean flag = false;
        int j1 = ((flag) ? 1 : 0);
        if (!ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
        {
            j1 = ((flag) ? 1 : 0);
            if (isEnabled(i1))
            {
                j1 = a.getResources().getDimensionPixelSize(m.chat_item_check_box_margin_left) + a.getResources().getDimensionPixelSize(m.chat_item_check_box_margin_right) + a.getResources().getDimensionPixelSize(m.checkbox_size_small);
            }
        }
        return j1;
    }

    private boolean d(int i1)
    {
        for (MessageObj messageobj = b(i1); !a(0, messageobj) || com.cyberlink.you.chat.d.e(messageobj) || com.cyberlink.you.chat.d.c(messageobj);)
        {
            return false;
        }

        return true;
    }

    private boolean e(int i1)
    {
        for (MessageObj messageobj = b(i1); a(15, messageobj) || com.cyberlink.you.chat.d.c(messageobj);)
        {
            return false;
        }

        return true;
    }

    private int l(MessageObj messageobj)
    {
        int i1 = i.size() - 1;
        int j1 = -1;
        do
        {
            if (i1 < 0 || ((MessageObj)i.get(i1)).d().getTime() <= messageobj.d().getTime())
            {
                return j1;
            }
            j1 = i1;
            i1--;
        } while (true);
    }

    public int a()
    {
        return i.size();
    }

    public int a(MessageObj messageobj)
    {
        int j1 = i.indexOf(messageobj);
        int i1 = j1;
        if (j1 == -1)
        {
            int k1 = j.indexOf(messageobj);
            i1 = k1;
            if (k1 != -1)
            {
                i1 = k1 + i.size();
            }
        }
        return i1;
    }

    public void a(MessageObj messageobj, boolean flag)
    {
        while (messageobj == null || flag && ChatDialogActivity.w(a).containsKey(messageobj.b())) 
        {
            return;
        }
        int i1;
        long l1;
        long l2;
        if (!i.isEmpty())
        {
            if (!com.cyberlink.you.utility.d.a(((MessageObj)i.get(i.size() - 1)).d(), messageobj.d()))
            {
                i.add(MessageObj.c(messageobj.d()));
            }
        } else
        {
            i.add(MessageObj.c(messageobj.d()));
        }
        ChatDialogActivity.w(a).put(messageobj.b(), messageobj);
        l1 = System.currentTimeMillis();
        i1 = l(messageobj);
        if (i1 < 0)
        {
            i.add(messageobj);
        } else
        {
            i.add(i1, messageobj);
        }
        l2 = System.currentTimeMillis();
        Log.d("ChatDialogActivity", (new StringBuilder()).append("add message ").append(String.valueOf(l2 - l1)).append(" ms").toString());
        notifyDataSetChanged();
    }

    public void a(List list)
    {
        j.addAll(list);
        MessageObj messageobj;
        for (list = list.iterator(); list.hasNext(); ChatDialogActivity.w(a).put(messageobj.b(), messageobj))
        {
            messageobj = (MessageObj)list.next();
        }

    }

    public void a(List list, boolean flag)
    {
        boolean flag1 = false;
        int i1 = 0;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MessageObj messageobj = (MessageObj)iterator.next();
            if (ChatDialogActivity.w(a).containsKey(messageobj.b()))
            {
                iterator.remove();
            }
        } while (true);
        if (list.isEmpty())
        {
            return;
        }
        if (i.isEmpty())
        {
            i.add(MessageObj.c(((MessageObj)list.get(0)).d()));
            for (; i1 < list.size() - 1; i1++)
            {
                ChatDialogActivity.w(a).put(((MessageObj)list.get(i1)).b(), list.get(i1));
                i.add(list.get(i1));
                if (!com.cyberlink.you.utility.d.a(((MessageObj)list.get(i1)).d(), ((MessageObj)list.get(i1 + 1)).d()))
                {
                    i.add(MessageObj.c(((MessageObj)list.get(i1 + 1)).d()));
                }
            }

            ChatDialogActivity.w(a).put(((MessageObj)list.get(list.size() - 1)).b(), list.get(list.size() - 1));
            i.add(list.get(list.size() - 1));
        } else
        if (flag)
        {
            int j1 = ((flag1) ? 1 : 0);
            if (!com.cyberlink.you.utility.d.a(((MessageObj)i.get(i.size() - 1)).d(), ((MessageObj)list.get(0)).d()))
            {
                i.add(MessageObj.c(((MessageObj)list.get(0)).d()));
                j1 = ((flag1) ? 1 : 0);
            }
            for (; j1 < list.size() - 1; j1++)
            {
                ChatDialogActivity.w(a).put(((MessageObj)list.get(j1)).b(), list.get(j1));
                i.add(list.get(j1));
                if (!com.cyberlink.you.utility.d.a(((MessageObj)list.get(j1)).d(), ((MessageObj)list.get(j1 + 1)).d()))
                {
                    i.add(MessageObj.c(((MessageObj)list.get(j1 + 1)).d()));
                }
            }

            ChatDialogActivity.w(a).put(((MessageObj)list.get(list.size() - 1)).b(), list.get(list.size() - 1));
            i.add(list.get(list.size() - 1));
        } else
        {
            if (com.cyberlink.you.utility.d.a(((MessageObj)i.get(0)).d(), ((MessageObj)list.get(list.size() - 1)).d()))
            {
                i.remove(0);
            }
            for (int k1 = list.size() - 1; k1 > 0; k1--)
            {
                ChatDialogActivity.w(a).put(((MessageObj)list.get(k1)).b(), list.get(k1));
                i.add(0, list.get(k1));
                if (!com.cyberlink.you.utility.d.a(((MessageObj)list.get(k1)).d(), ((MessageObj)list.get(k1 - 1)).d()))
                {
                    i.add(0, MessageObj.c(((MessageObj)list.get(k1 - 1)).d()));
                }
            }

            ChatDialogActivity.w(a).put(((MessageObj)list.get(0)).b(), list.get(0));
            i.add(0, list.get(0));
            i.add(0, MessageObj.c(((MessageObj)list.get(0)).d()));
        }
        notifyDataSetChanged();
    }

    public boolean a(int i1)
    {
        return i1 >= i.size();
    }

    public boolean a(int i1, int j1)
    {
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (j1 < 0 || j1 >= 7) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (7 != i1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j1 < 7 || j1 >= 15)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (15 == i1)
        {
            if (j1 < 15)
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void add(Object obj)
    {
        d((MessageObj)obj);
    }

    public MessageObj b(int i1)
    {
        if (!a(i1))
        {
            return (MessageObj)i.get(i1);
        } else
        {
            return (MessageObj)j.get(i1 - i.size());
        }
    }

    public boolean b(MessageObj messageobj)
    {
        for (Iterator iterator = j.iterator(); iterator.hasNext();)
        {
            MessageObj messageobj1 = (MessageObj)iterator.next();
            if (messageobj1 != null && messageobj1.b() != null && messageobj != null && messageobj.b() != null && messageobj1.b().equals(messageobj.b()))
            {
                j.remove(messageobj1);
                a(messageobj, false);
                notifyDataSetChanged();
                return true;
            }
        }

        return false;
    }

    public void c(MessageObj messageobj)
    {
        j.add(messageobj);
        ChatDialogActivity.w(a).put(messageobj.b(), messageobj);
        notifyDataSetChanged();
    }

    public void clear()
    {
        super.clear();
        i.clear();
        j.clear();
    }

    public void d(MessageObj messageobj)
    {
        a(messageobj, true);
    }

    public void e(MessageObj messageobj)
    {
        i.remove(messageobj);
        j.remove(messageobj);
        if (ChatDialogActivity.w(a).containsKey(messageobj.b()))
        {
            ChatDialogActivity.w(a).remove(messageobj.b());
        }
        notifyDataSetChanged();
    }

    public int f(MessageObj messageobj)
    {
        if (messageobj != null)
        {
            if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.h)
            {
                return 16;
            }
            if (messageobj.e() != com.cyberlink.you.database.MessageObj.MessageType.g)
            {
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.l)
                {
                    return 18;
                }
                if (ChatDialogActivity.a(messageobj))
                {
                    if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.a)
                    {
                        return 0;
                    }
                    if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.c)
                    {
                        return 1;
                    }
                    if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.d)
                    {
                        return 2;
                    }
                    if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.i)
                    {
                        return 4;
                    }
                    if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.m)
                    {
                        return 5;
                    }
                    return messageobj.e() != com.cyberlink.you.database.MessageObj.MessageType.n ? 3 : 6;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.a)
                {
                    return 7;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.c)
                {
                    return 8;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.d)
                {
                    return 9;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.i)
                {
                    return 11;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.m)
                {
                    return 13;
                }
                if (messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.j)
                {
                    return 12;
                }
                return messageobj.e() != com.cyberlink.you.database.MessageObj.MessageType.n ? 10 : 14;
            }
        }
        return 15;
    }

    public void g(MessageObj messageobj)
    {
        Log.d("ChatDialogActivity", "[handleOnCopyMessageButtonClick]");
        if (messageobj == null)
        {
            return;
        }
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.m))
        {
            messageobj = messageobj.b("replyText");
        } else
        {
            messageobj = messageobj.g();
        }
        ((ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("U", messageobj));
    }

    public int getCount()
    {
        return i.size() + j.size();
    }

    public Object getItem(int i1)
    {
        return b(i1);
    }

    public long getItemId(int i1)
    {
        return 0L;
    }

    public int getItemViewType(int i1)
    {
        if (i == null)
        {
            Log.e("ChatDialogActivity", "list is null");
            return 15;
        }
        if (i1 >= i.size() && i1 < getCount())
        {
            return f((MessageObj)j.get(i1 - i.size()));
        }
        if (i1 > getCount())
        {
            Log.e("ChatDialogActivity", (new StringBuilder()).append("position ").append(i1).append(" >= size ").append(i.size()).toString());
            return 15;
        } else
        {
            return f((MessageObj)i.get(i1));
        }
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        int k1 = getItemViewType(i1);
        View view1;
        if (view == null)
        {
            view = new d();
            View view2 = a(i1, k1, viewgroup, view);
            viewgroup = view;
            view1 = view2;
            if (view2 != null)
            {
                view2.setTag(view);
                view1 = view2;
                viewgroup = view;
            }
        } else
        {
            int j1 = 0;
            d d1 = (d)view.getTag();
            if (k1 == 0)
            {
                j1 = com.cyberlink.you.activity.ChatDialogActivity.h();
            } else
            if (k1 == 7)
            {
                j1 = ChatDialogActivity.i();
            }
            j1 -= c(i1);
            viewgroup = d1;
            view1 = view;
            if (d1.m != j1)
            {
                viewgroup = d1;
                view1 = view;
                if (j1 > 0)
                {
                    d1.m = j1;
                    d1.e.setMaxWidth(d1.m);
                    viewgroup = d1;
                    view1 = view;
                }
            }
        }
        view = b(i1);
        if (k1 == 15)
        {
            ((d) (viewgroup)).n.setText(com.cyberlink.you.utility.d.b(view.d()));
        } else
        if (k1 == 16)
        {
            a(viewgroup, view);
        } else
        {
            b(k1, viewgroup, i1);
            a(k1, viewgroup, i1);
        }
        a(k1, view1, i1);
        return view1;
    }

    public int getViewTypeCount()
    {
        return 19;
    }

    public void h(MessageObj messageobj)
    {
        Log.d("ChatDialogActivity", "[handleOnResendMessageButtonClick]");
        if (messageobj != null)
        {
            if (ChatDialogActivity.a(a) != null)
            {
                ChatDialogActivity.a(a).e(messageobj);
            }
            Object obj = new ArrayList();
            messageobj.a(new Date());
            messageobj.b(new Date());
            ((List) (obj)).add("SendTime");
            boolean flag = false;
            if (messageobj.j().equals("2") || messageobj.j().equals("3"))
            {
                messageobj.c("2");
                ((List) (obj)).add("Status");
                com.cyberlink.you.e.d().a(messageobj.b(), messageobj, ((List) (obj)));
                if (ChatDialogActivity.a(a) != null)
                {
                    ChatDialogActivity.a(a).c(messageobj);
                }
                obj = com.cyberlink.you.activity.ChatDialogActivity.b(a).c;
                ChatDialogActivity.a(a, ((String) (obj)), messageobj);
                flag = true;
            }
            if (flag && ChatDialogActivity.O(a) != null)
            {
                ChatDialogActivity.O(a).schedule(new j(a), 1000L);
                return;
            }
        }
    }

    public void i(MessageObj messageobj)
    {
        if (messageobj != null)
        {
            (new a(a, messageobj)).executeOnExecutor(com.cyberlink.you.activity.ChatDialogActivity.b, new Void[0]);
        }
    }

    public boolean isEnabled(int i1)
    {
        if (!ChatDialogActivity.M(a).equals(ChatDialogActivity.ChatDialogMode.a))
        {
            if (ChatDialogActivity.M(a).equals(com.cyberlink.you.activity.ChatDialogActivity.ChatDialogMode.b))
            {
                return e(i1);
            }
            if (ChatDialogActivity.M(a).equals(com.cyberlink.you.activity.ChatDialogActivity.ChatDialogMode.c))
            {
                return d(i1);
            }
        }
        return true;
    }

    public void j(MessageObj messageobj)
    {
        Log.d("ChatDialogActivity", "[handleOnOpenMessageButtonClick]");
        int i1;
        if (messageobj != null)
        {
            if ((9 == (i1 = f(messageobj)) || 2 == i1 || 8 == i1 || 1 == i1 || 11 == i1 || 4 == i1) && (messageobj = com.cyberlink.you.activity.ChatDialogActivity.b(a, messageobj)) != null)
            {
                if (!com.cyberlink.you.activity.ChatDialogActivity.o(a).d().isVisible())
                {
                    com.cyberlink.you.activity.ChatDialogActivity.o(a).a(true);
                }
                com.cyberlink.you.activity.ChatDialogActivity.o(a).d().a(messageobj.c());
                return;
            }
        }
    }

    public void k(MessageObj messageobj)
    {
        Log.d("ChatDialogActivity", "[handleOnDetailMessageButtonClick]");
        int i1;
        if (messageobj != null)
        {
            if ((9 == (i1 = f(messageobj)) || 2 == i1 || 8 == i1 || 1 == i1 || 11 == i1 || 4 == i1) && (messageobj = com.cyberlink.you.activity.ChatDialogActivity.b(a, messageobj)) != null)
            {
                StickerPackObj stickerpackobj = com.cyberlink.you.e.i().a(messageobj.c());
                if (stickerpackobj != null)
                {
                    ChatDialogActivity.a(a, stickerpackobj);
                    return;
                } else
                {
                    ProgressDialog progressdialog = ProgressDialog.show(com.cyberlink.you.activity.ChatDialogActivity.g(a), "", a.getString(r.u_loading), true);
                    (new com.cyberlink.you.activity.c(a, messageobj.c(), new com.cyberlink.you.activity.g(progressdialog) {

                        final ProgressDialog a;
                        final e b;

                        public void a(StickerPackObj stickerpackobj1)
                        {
                            if (a != null && a.isShowing())
                            {
                                a.dismiss();
                            }
                            if (stickerpackobj1 == null)
                            {
                                return;
                            } else
                            {
                                com.cyberlink.you.e.i().a(stickerpackobj1);
                                ChatDialogActivity.a(b.a, stickerpackobj1);
                                return;
                            }
                        }

            
            {
                b = e.this;
                a = progressdialog;
                super();
            }
                    })).executeOnExecutor(com.cyberlink.you.activity.ChatDialogActivity.b, new Void[0]);
                    return;
                }
            }
        }
    }

    public void remove(Object obj)
    {
        e((MessageObj)obj);
    }
}
