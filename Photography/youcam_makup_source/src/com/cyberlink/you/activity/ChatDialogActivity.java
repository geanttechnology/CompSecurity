// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.you.BaseFragmentActivity;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.a;
import com.cyberlink.you.c.c;
import com.cyberlink.you.c.e;
import com.cyberlink.you.chat.UnreadCountManager;
import com.cyberlink.you.chat.aa;
import com.cyberlink.you.chat.ab;
import com.cyberlink.you.chat.ad;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.chat.j;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.chat.w;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.k;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.m;
import com.cyberlink.you.o;
import com.cyberlink.you.q;
import com.cyberlink.you.r;
import com.cyberlink.you.sticker.StickerFragment;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.h;
import com.cyberlink.you.utility.i;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StreamMgmt;
import org.jivesoftware.smack.util.p;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.you.activity:
//            d, AboutPageActivity, MessageSettingActivity, e, 
//            StickerShopDetailActivity, f, h, i, 
//            b, j

public class ChatDialogActivity extends BaseFragmentActivity
{

    private static com.cyberlink.you.activity.i Z = null;
    private static boolean aa = false;
    private static com.cyberlink.you.activity.h ab = null;
    private static final int ao;
    private static ThreadGroup ap = new ThreadGroup("NetAsyncTask");
    private static ThreadGroup aq = new ThreadGroup("SingleAsyncTask");
    private static ThreadPoolExecutor ar;
    public static ThreadPoolExecutor b;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private View A;
    private TextView B;
    private View C;
    private ImageView D;
    private RelativeLayout E;
    private SwipeRefreshLayout F;
    private Map G;
    private com.cyberlink.you.activity.e H;
    private TextView I;
    private View J;
    private View K;
    private View L;
    private final Object M = new Object();
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private Map W;
    private List X;
    private int Y;
    l a;
    private w aA;
    private com.cyberlink.you.b.c aB;
    private com.cyberlink.you.chat.o aC;
    private aa aD;
    private com.cyberlink.you.activity.d aE;
    private com.cyberlink.you.activity.d aF;
    private com.cyberlink.you.activity.d aG;
    private com.cyberlink.you.activity.d aH;
    private com.cyberlink.you.activity.d aI;
    private com.cyberlink.you.activity.d aJ;
    private com.cyberlink.you.activity.d aK;
    private com.cyberlink.you.activity.d aL;
    private com.cyberlink.you.activity.d aM;
    private com.cyberlink.you.activity.d aN;
    private com.cyberlink.you.activity.d aO;
    private com.cyberlink.you.activity.d aP;
    private com.cyberlink.you.activity.d aQ;
    private android.view.View.OnClickListener aR;
    private android.view.View.OnClickListener aS;
    private android.view.View.OnClickListener aT;
    private android.view.View.OnClickListener aU;
    private android.widget.AdapterView.OnItemClickListener aV;
    private com.cyberlink.you.utility.o ac;
    private AssetFileDescriptor ad;
    private long ae;
    private Map af;
    private GestureDetectorCompat ag;
    private MessageObj ah;
    private ChatDialogMode ai;
    private AsyncTask aj;
    private Timer ak;
    private int al;
    private int am;
    private List an;
    private com.cyberlink.you.activity.b as;
    private com.cyberlink.you.chat.UnreadCountManager.OnUnreadCountListner at;
    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener au;
    private com.cyberlink.you.c.j av;
    private android.view.View.OnFocusChangeListener aw;
    private android.view.View.OnLayoutChangeListener ax;
    private com.cyberlink.you.c.d ay;
    private android.view.View.OnClickListener az;
    com.cyberlink.you.chat.l c;
    ad d;
    private final int e = 5;
    private final int f = 999;
    private final int g = 1000;
    private final float h = 0.76F;
    private final float i = 0.5F;
    private final float j = 0.95F;
    private Group o;
    private c p;
    private e q;
    private ImageView r;
    private ImageView s;
    private Button t;
    private View u;
    private TextView v;
    private TextView w;
    private ListView x;
    private TextView y;
    private TextView z;

    public ChatDialogActivity()
    {
        L = null;
        N = false;
        O = false;
        P = false;
        Q = false;
        R = true;
        S = 0;
        T = 1000;
        U = false;
        V = false;
        X = new ArrayList();
        Y = -1;
        ac = null;
        af = new HashMap();
        ag = null;
        ah = null;
        ai = com.cyberlink.you.activity.ChatDialogMode.a;
        aj = null;
        al = 0;
        am = 0;
        as = null;
        at = new com.cyberlink.you.chat.UnreadCountManager.OnUnreadCountListner() {

            final ChatDialogActivity a;

            public void a(com.cyberlink.you.chat.UnreadCountManager.OnUnreadCountListner.Type type)
            {
                if (com.cyberlink.you.activity.ChatDialogActivity.b(a) != null && (type.equals(com.cyberlink.you.chat.UnreadCountManager.OnUnreadCountListner.Type.a) || type.equals(com.cyberlink.you.chat.UnreadCountManager.OnUnreadCountListner.Type.c)))
                {
                    UnreadCountManager.b().b(com.cyberlink.you.activity.ChatDialogActivity.b(a).c, false);
                    a.d();
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        au = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final ChatDialogActivity a;

            public void onRefresh()
            {
                com.cyberlink.you.activity.ChatDialogActivity.i(a).setRefreshing(false);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        av = new com.cyberlink.you.c.j() {

            final ChatDialogActivity a;

            public void a()
            {
                boolean flag;
                if (!com.cyberlink.you.activity.ChatDialogActivity.k(a).d().isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a.a(flag);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aw = new android.view.View.OnFocusChangeListener() {

            final ChatDialogActivity a;

            public void onFocusChange(View view, boolean flag)
            {
                if (com.cyberlink.you.activity.ChatDialogActivity.k(a) != null && flag)
                {
                    com.cyberlink.you.activity.ChatDialogActivity.k(a).b();
                    view = com.cyberlink.you.activity.ChatDialogActivity.k(a).d();
                    com.cyberlink.you.activity.ChatDialogActivity.a(a, view);
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        ax = new android.view.View.OnLayoutChangeListener() {

            final ChatDialogActivity a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (com.cyberlink.you.activity.b.a(com.cyberlink.you.activity.ChatDialogActivity.l(a)) && l1 - j1 < l2 - j2 && com.cyberlink.you.activity.ChatDialogActivity.c(a).getLastVisiblePosition() != com.cyberlink.you.activity.ChatDialogActivity.c(a).getCount() - 1)
                {
                    com.cyberlink.you.activity.ChatDialogActivity.m(a);
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        ay = new com.cyberlink.you.c.d() {

            final ChatDialogActivity a;

            public void a(String s1, Map map)
            {
                if (!s1.equals("sendText") && !s1.equals("sendPhoto") && !s1.equals("sendSticker") && !s1.equals("scheduleSend") && !s1.equals("selfDestruct")) goto _L2; else goto _L1
_L1:
                if (!map.containsKey("text")) goto _L4; else goto _L3
_L3:
                s1 = (String)map.get("text");
                if (com.cyberlink.you.activity.ChatDialogActivity.n(a).getVisibility() != 8) goto _L6; else goto _L5
_L5:
                com.cyberlink.you.activity.ChatDialogActivity.a(a, s1);
_L8:
                return;
_L6:
                com.cyberlink.you.activity.ChatDialogActivity.b(a, s1);
                return;
_L4:
                if (map.containsKey("sticer"))
                {
                    s1 = ((String) (map.get("sticer")));
                    if (s1 instanceof StickerObj)
                    {
                        a.a((StickerObj)s1);
                        return;
                    }
                    if (s1 instanceof Emojicon)
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.o(a).a((Emojicon)s1);
                        return;
                    }
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (s1.equals("sendBCPost"))
                {
                    s1 = ((String) (map.get("post")));
                    if (s1 instanceof String)
                    {
                        s1 = (String)s1;
                        com.cyberlink.you.activity.ChatDialogActivity.c(a, s1);
                        return;
                    }
                }
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        az = new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aA = new w() {

            final ChatDialogActivity a;

            public String a(b b1)
            {
                if (b1.a())
                {
                    return com.cyberlink.you.activity.ChatDialogActivity.a(a, b1);
                }
                if (b1.g() == com.cyberlink.you.database.MessageObj.MessageType.h)
                {
                    return com.cyberlink.you.activity.ChatDialogActivity.b(a, b1);
                } else
                {
                    return com.cyberlink.you.activity.ChatDialogActivity.c(a, b1);
                }
            }

            public boolean a()
            {
                return false;
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aB = new com.cyberlink.you.b.c() {

            final ChatDialogActivity a;

            public boolean a(b b1, Map map)
            {
                String s1;
                String s2;
                String s3;
                if (b1 != null)
                {
                    s2 = b1.i();
                    s1 = b1.o();
                } else
                {
                    s1 = null;
                    s2 = null;
                }
                s3 = (String)map.get("eventType");
                if (!s3.equals("group.group.created") && !s3.equals("group.group.updated") && !s3.equals("group.member.leaved") && !s3.equals("group.member.created") && !s3.equals("group.member.deleted") && !s3.equals("media.media.created") && !s3.equals("group.admin.created") && !s3.equals("group.admin.deleted") && !s3.equals("media.album.created") && !s3.equals("media.media.deleted") && !s3.equals("media.album.deleted") && !s3.equals("group.display.name.updated")) goto _L2; else goto _L1
_L1:
                com.cyberlink.you.activity.ChatDialogActivity.a(a, s3, (String)map.get("groupId"), (String)map.get("userId"), s2);
_L4:
                return true;
_L2:
                if (!s3.equals("chat.message.recalled"))
                {
                    if (s3.equals("user.display.name.updated") || s3.equals("user.avatar.updated") || s3.equals("user.status.updated") || s3.equals("user.coverart.updated"))
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.d(a, s1);
                    } else
                    if (s3.equals("friend.friend.unblocked") || s3.equals("friend.friend.blocked"))
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.e(a, (String)map.get("userId"));
                    } else
                    if (s3.equals("group.group.disabled") || s3.equals("group.group.enabled"))
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.f(a, (String)map.get("groupId"));
                    } else
                    if (s3.equals("friend.friend.broke.up") && com.cyberlink.you.activity.ChatDialogActivity.b(a).e.equals("Dual") && com.cyberlink.you.activity.ChatDialogActivity.b(a).c.equals(b1.o()))
                    {
                        a.finish();
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aC = new com.cyberlink.you.chat.o() {

            final ChatDialogActivity a;

            public void a(boolean flag)
            {
                com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new Runnable(this, flag) {

                    final boolean a;
                    final _cls10 b;

                    public void run()
                    {
                        ChatDialogActivity.u(b.a);
                        if (a)
                        {
                            ChatDialogActivity.v(b.a);
                            return;
                        } else
                        {
                            b.a.b(false);
                            return;
                        }
                    }

            
            {
                b = _pcls10;
                a = flag;
                super();
            }
                });
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aD = new aa() {

            final ChatDialogActivity a;

            public boolean a(StreamMgmt streammgmt)
            {
                String s1;
                if (streammgmt != null)
                {
                    if ((s1 = streammgmt.q()) != null)
                    {
                        Log.d("ChatDialogActivity", (new StringBuilder()).append("StreamMgmt: ").append(s1).toString());
                        String s2 = streammgmt.d();
                        com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new Runnable(this, s1, streammgmt, s2) {

                            final String a;
                            final StreamMgmt b;
                            final String c;
                            final _cls11 d;

                            public void run()
                            {
                                Object obj = com.cyberlink.you.activity.ChatDialogActivity.p(d.a);
                                obj;
                                JVM INSTR monitorenter ;
                                MessageObj messageobj;
                                Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: ").append(a).toString());
                                messageobj = (MessageObj)com.cyberlink.you.activity.ChatDialogActivity.w(d.a).get(a);
                                if (messageobj != null)
                                {
                                    break MISSING_BLOCK_LABEL_71;
                                }
                                obj;
                                JVM INSTR monitorexit ;
                                return;
                                if (b.c() != null)
                                {
                                    messageobj.a(b.c());
                                }
                                if (c == null || !c.equals("nack"))
                                {
                                    break MISSING_BLOCK_LABEL_174;
                                }
                                messageobj.c("3");
                                Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: STATUS_SEND_FAIL ").append(a).toString());
_L1:
                                obj;
                                JVM INSTR monitorexit ;
                                Exception exception;
                                if (com.cyberlink.you.activity.ChatDialogActivity.a(d.a) != null)
                                {
                                    com.cyberlink.you.activity.ChatDialogActivity.a(d.a).notifyDataSetChanged();
                                    return;
                                } else
                                {
                                    Log.d("ChatDialogActivity", "mMessageAdapter != null");
                                    return;
                                }
                                messageobj.c("0");
                                Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: STATUS_NORMAL ").append(a).toString());
                                if (com.cyberlink.you.activity.ChatDialogActivity.a(d.a) != null)
                                {
                                    com.cyberlink.you.activity.ChatDialogActivity.a(d.a).b(messageobj);
                                }
                                if (com.cyberlink.you.activity.ChatDialogActivity.a(d.a) != null)
                                {
                                    com.cyberlink.you.activity.ChatDialogActivity.m(d.a);
                                }
                                  goto _L1
                                exception;
                                obj;
                                JVM INSTR monitorexit ;
                                throw exception;
                            }

            
            {
                d = _pcls11;
                a = s1;
                b = streammgmt;
                c = s2;
                super();
            }
                        });
                        return true;
                    }
                }
                return false;
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        c = new com.cyberlink.you.chat.l() {

            final ChatDialogActivity a;

            static void a(_cls13 _pcls13)
            {
                _pcls13.c();
            }

            private void c()
            {
                int i1 = (com.cyberlink.you.activity.ChatDialogActivity.a(a).getCount() - 1) + com.cyberlink.you.activity.ChatDialogActivity.c(a).getHeaderViewsCount();
                if (i1 > com.cyberlink.you.activity.ChatDialogActivity.e(a) - 1 && i1 == com.cyberlink.you.activity.ChatDialogActivity.c(a).getLastVisiblePosition())
                {
                    com.cyberlink.you.activity.ChatDialogActivity.b(a, false);
                }
            }

            public void a()
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = ChatDialogActivity.x(a).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (b)iterator.next();
                    obj = com.cyberlink.you.activity.ChatDialogActivity.d(a, ((b) (obj)));
                    if (obj != null)
                    {
                        arraylist.add(obj);
                    }
                } while (true);
                if (!arraylist.isEmpty())
                {
                    com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new Runnable(this, arraylist) {

                        final List a;
                        final _cls13 b;

                        public void run()
                        {
                            synchronized (com.cyberlink.you.activity.ChatDialogActivity.p(b.a))
                            {
                                if (com.cyberlink.you.activity.ChatDialogActivity.a(b.a) != null)
                                {
                                    Log.d("ChatDialogActivity", "Sort archive message");
                                    com.cyberlink.you.activity._cls13.a(b);
                                    com.cyberlink.you.activity.ChatDialogActivity.a(b.a).a(a, true);
                                    com.cyberlink.you.activity.e.a(com.cyberlink.you.activity.ChatDialogActivity.a(b.a), new com.cyberlink.you.database.g());
                                }
                            }
                            return;
                            exception;
                            obj;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                b = _pcls13;
                a = list;
                super();
            }
                    });
                }
                a.b(false);
            }

            public void b()
            {
                a.b(true);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aE = new com.cyberlink.you.activity.d(this, 1, r.u_forward);
        aF = new com.cyberlink.you.activity.d(this, aE.a + 1, r.u_copy);
        aG = new com.cyberlink.you.activity.d(this, aF.a + 1, r.u_menu_delete);
        aH = new com.cyberlink.you.activity.d(this, aG.a + 1, r.u_menu_resend);
        aI = new com.cyberlink.you.activity.d(this, aH.a + 1, r.u_call_back);
        aJ = new com.cyberlink.you.activity.d(this, aI.a + 1, r.u_menu_details);
        aK = new com.cyberlink.you.activity.d(this, aJ.a + 1, r.u_menu_open);
        aL = new com.cyberlink.you.activity.d(this, aK.a + 1, r.u_forward_photo_with_comment);
        aM = new com.cyberlink.you.activity.d(this, aL.a + 1, r.u_save_to_my_device);
        aN = new com.cyberlink.you.activity.d(this, aM.a + 1, r.u_save_to_my_album);
        aO = new com.cyberlink.you.activity.d(this, aN.a + 1, r.u_save_to_group_album);
        aP = new com.cyberlink.you.activity.d(this, aO.a + 1, r.u_menu_cancel_message);
        aQ = new com.cyberlink.you.activity.d(this, aP.a + 1, r.u_menu_reply);
        d = new ad() {

            final ChatDialogActivity a;

            public boolean a(boolean flag, MessageObj messageobj)
            {
                if (!String.valueOf(com.cyberlink.you.activity.ChatDialogActivity.b(a).b).equals(messageobj.c()))
                {
                    return false;
                } else
                {
                    com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new Runnable(this, flag, messageobj) {

                        final boolean a;
                        final MessageObj b;
                        final _cls32 c;

                        public void run()
                        {
                            Object obj = com.cyberlink.you.activity.ChatDialogActivity.p(c.a);
                            obj;
                            JVM INSTR monitorenter ;
                            Object obj1;
                            if (a)
                            {
                                break MISSING_BLOCK_LABEL_182;
                            }
                            if (!com.cyberlink.you.activity.ChatDialogActivity.w(c.a).containsKey(b.b()))
                            {
                                break MISSING_BLOCK_LABEL_81;
                            }
                            obj1 = (MessageObj)com.cyberlink.you.activity.ChatDialogActivity.w(c.a).get(b.b());
                            if (obj1 == null)
                            {
                                break MISSING_BLOCK_LABEL_81;
                            }
                            ((MessageObj) (obj1)).c("3");
                            if (com.cyberlink.you.activity.ChatDialogActivity.a(c.a) == null || com.cyberlink.you.activity.e.a(com.cyberlink.you.activity.ChatDialogActivity.a(c.a)) == null)
                            {
                                break MISSING_BLOCK_LABEL_182;
                            }
                            obj1 = com.cyberlink.you.activity.e.a(com.cyberlink.you.activity.ChatDialogActivity.a(c.a)).iterator();
_L2:
                            MessageObj messageobj;
                            do
                            {
                                if (!((Iterator) (obj1)).hasNext())
                                {
                                    break MISSING_BLOCK_LABEL_182;
                                }
                                messageobj = (MessageObj)((Iterator) (obj1)).next();
                            } while (messageobj == null);
                            if (messageobj.b() == null || !messageobj.b().equals(b.b())) goto _L2; else goto _L1
_L1:
                            messageobj.c("3");
                            if (com.cyberlink.you.activity.ChatDialogActivity.a(c.a) != null)
                            {
                                com.cyberlink.you.activity.ChatDialogActivity.a(c.a).notifyDataSetChanged();
                            }
                            obj;
                            JVM INSTR monitorexit ;
                            return;
                            Exception exception;
                            exception;
                            obj;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                c = _pcls32;
                a = flag;
                b = messageobj;
                super();
            }
                    });
                    return true;
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aR = new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                SparseBooleanArray sparsebooleanarray;
                int i1;
                int j1;
                view = new ArrayList();
                sparsebooleanarray = com.cyberlink.you.activity.ChatDialogActivity.c(a).getCheckedItemPositions();
                j1 = com.cyberlink.you.activity.ChatDialogActivity.c(a).getHeaderViewsCount();
                i1 = 0;
_L8:
                if (i1 < com.cyberlink.you.activity.ChatDialogActivity.a(a).getCount() && sparsebooleanarray.size() > 0 && view.size() != sparsebooleanarray.size()) goto _L2; else goto _L1
_L1:
                if (!ChatDialogActivity.M(a).equals(com.cyberlink.you.activity.ChatDialogMode.b)) goto _L4; else goto _L3
_L3:
                view = new android.app.AlertDialog.Builder(com.cyberlink.you.activity.ChatDialogActivity.g(a), 3);
                view.setTitle(a.getString(r.u_delete_message_title));
                view.setMessage(a.getString(r.u_delete_message_content));
                view.setNegativeButton(a.getString(r.u_cancel_text), new android.content.DialogInterface.OnClickListener(this) {

                    final _cls34 a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                    }

            
            {
                a = _pcls34;
                super();
            }
                });
                view.show();
_L6:
                return;
_L2:
                if (sparsebooleanarray.get(i1 + j1))
                {
                    view.add(com.cyberlink.you.activity.ChatDialogActivity.a(a).b(i1));
                }
                i1++;
                continue; /* Loop/switch isn't completed */
_L4:
                if (!ChatDialogActivity.M(a).equals(com.cyberlink.you.activity.ChatDialogMode.c)) goto _L6; else goto _L5
_L5:
                return;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aS = new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.activity.ChatDialogActivity.a(a, com.cyberlink.you.activity.ChatDialogMode.a, 0);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aT = new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.activity.ChatDialogActivity.f(a).startAnimation(AnimationUtils.loadAnimation(com.cyberlink.you.activity.ChatDialogActivity.g(a), com.cyberlink.you.k.exit_to_bottom));
                com.cyberlink.you.activity.ChatDialogActivity.f(a).setVisibility(4);
                com.cyberlink.you.activity.ChatDialogActivity.b(a, false);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aU = new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                ChatDialogActivity.Q(a);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
        aV = new android.widget.AdapterView.OnItemClickListener() {

            final ChatDialogActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                if (!ChatDialogActivity.M(a).equals(com.cyberlink.you.activity.ChatDialogMode.a))
                {
                    ((com.cyberlink.you.d.d)view.getTag()).s.setSelected(com.cyberlink.you.activity.ChatDialogActivity.c(a).isItemChecked(i1));
                    ChatDialogActivity.R(a);
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        };
    }

    private void A()
    {
        l().runOnUiThread(new Runnable() {

            final ChatDialogActivity a;

            public void run()
            {
                int i1;
                if (com.cyberlink.you.activity.ChatDialogActivity.b(a).i)
                {
                    i1 = 0;
                } else
                {
                    i1 = 4;
                }
                ChatDialogActivity.P(a).setVisibility(i1);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        });
    }

    static void A(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.o();
    }

    private void B()
    {
        Object obj = l();
        if (obj == null)
        {
            return;
        }
        boolean flag = com.cyberlink.you.chat.n.a().d();
        boolean flag1 = flag;
        byte byte0;
        if (!flag)
        {
            if (com.cyberlink.you.a.a().c())
            {
                obj = ((Activity) (obj)).getResources().getString(r.u_connecting);
                if (!com.cyberlink.you.g.a().b())
                {
                    flag = true;
                } else
                {
                    obj = (new StringBuilder()).append(((String) (obj))).append(" (").append(com.cyberlink.you.a.a().d()).append(")").toString();
                }
                y.setText(((CharSequence) (obj)));
                flag1 = flag;
            } else
            {
                y.setText(((Activity) (obj)).getResources().getString(r.u_error_no_network));
                flag1 = flag;
            }
        }
        obj = y;
        if (flag1)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        ((TextView) (obj)).setVisibility(byte0);
    }

    static void B(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.A();
    }

    private void C()
    {
        int i1 = x.getCheckedItemCount();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        t.setEnabled(false);
_L8:
        String s1 = (new StringBuilder()).append(" (").append(i1).append(")").toString();
        if (!ai.equals(com.cyberlink.you.activity.ChatDialogMode.b)) goto _L4; else goto _L3
_L3:
        t.setText((new StringBuilder()).append(getResources().getString(r.u_menu_delete)).append(s1).toString());
_L6:
        return;
_L2:
        if (!t.isEnabled())
        {
            t.setEnabled(true);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!ai.equals(com.cyberlink.you.activity.ChatDialogMode.c)) goto _L6; else goto _L5
_L5:
        t.setText((new StringBuilder()).append(getResources().getString(r.u_call_back)).append(s1).toString());
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static void C(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.n();
    }

    private void D()
    {
        startActivity(new Intent(this, com/cyberlink/you/activity/AboutPageActivity));
    }

    static void D(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.t();
    }

    private void E()
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("ybc://notifications/?tab=messages"));
        intent.setPackage(getPackageName());
        startActivity(intent);
    }

    static void E(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.u();
    }

    private void F()
    {
        if (o != null)
        {
            Intent intent = new Intent(this, com/cyberlink/you/activity/MessageSettingActivity);
            intent.putExtra("Group", o);
            startActivityForResult(intent, 22);
        }
    }

    static void F(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.z();
    }

    static void G(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.y();
    }

    private boolean G()
    {
        return q != null;
    }

    static void H(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.p();
    }

    static List I(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.an;
    }

    static android.widget.AdapterView.OnItemClickListener J(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.aV;
    }

    static int K(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.Y;
    }

    static void L(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.r();
    }

    static ChatDialogMode M(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ai;
    }

    static Map N(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.W;
    }

    static Timer O(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ak;
    }

    static RelativeLayout P(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.E;
    }

    static void Q(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.F();
    }

    static void R(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.C();
    }

    static View S(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.K;
    }

    static boolean T(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.G();
    }

    static int a(ChatDialogActivity chatdialogactivity, int i1)
    {
        chatdialogactivity.am = i1;
        return i1;
    }

    static long a(ChatDialogActivity chatdialogactivity, long l1)
    {
        chatdialogactivity.ae = l1;
        return l1;
    }

    static AsyncTask a(ChatDialogActivity chatdialogactivity, AsyncTask asynctask)
    {
        chatdialogactivity.aj = asynctask;
        return asynctask;
    }

    static com.cyberlink.you.activity.e a(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.H;
    }

    static MessageObj a(ChatDialogActivity chatdialogactivity, MessageObj messageobj)
    {
        chatdialogactivity.ah = messageobj;
        return messageobj;
    }

    static com.cyberlink.you.utility.o a(ChatDialogActivity chatdialogactivity, com.cyberlink.you.utility.o o1)
    {
        chatdialogactivity.ac = o1;
        return o1;
    }

    static String a(ChatDialogActivity chatdialogactivity, b b1)
    {
        return chatdialogactivity.c(b1);
    }

    private String a(b b1)
    {
        if (b1.p().equals(o.c) || b1.p().equals(com.cyberlink.you.g.a().f()) && b1.l().equals(o.c))
        {
            if (b1.g() == com.cyberlink.you.database.MessageObj.MessageType.e)
            {
                d(b1);
                return com/cyberlink/you/activity/ChatDialogActivity.toString();
            }
            MessageObj messageobj = b1.a(String.valueOf(o.b));
            Object obj = new StringBuffer();
            ((StringBuffer) (obj)).append("[").append("ChatDialogActivity").append("]");
            ((StringBuffer) (obj)).append(" onReceive: messageId=").append(b1.i());
            ULogUtility.a(((StringBuffer) (obj)).toString(), "Receive");
            String s1 = messageobj.i();
            Friend friend = i(s1);
            obj = friend;
            if (friend == null)
            {
                obj = (new l()).a(s1);
            }
            a(messageobj, s1, ((Friend) (obj)));
            if (R && V && messageobj.e() == com.cyberlink.you.database.MessageObj.MessageType.a)
            {
                runOnUiThread(new Runnable(messageobj) {

                    final MessageObj a;
                    final ChatDialogActivity b;

                    public void run()
                    {
                        b.a(com.cyberlink.you.database.MessageObj.MessageType.a, (new StringBuilder()).append("Echo ").append(a.g()).toString());
                    }

            
            {
                b = ChatDialogActivity.this;
                a = messageobj;
                super();
            }
                });
            }
            if (P)
            {
                return null;
            }
            if (!b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())))
            {
                e(b1);
            }
            return com/cyberlink/you/activity/ChatDialogActivity.toString();
        } else
        {
            return null;
        }
    }

    private void a(long l1)
    {
        (new AsyncTask(l1) {

            final long a;
            final ChatDialogActivity b;

            protected transient Group a(Void avoid[])
            {
                avoid = (new StringBuilder()).append(a).append("@u.cyberlink.com").toString();
                com.cyberlink.you.e.f().b(avoid);
                return null;
            }

            public void a(Group group)
            {
                if (group != null)
                {
                    com.cyberlink.you.activity.ChatDialogActivity.a(b, group);
                    return;
                } else
                {
                    com.cyberlink.you.activity.ChatDialogActivity.b(b, a);
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Group)obj);
            }

            
            {
                b = ChatDialogActivity.this;
                a = l1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void a(Bundle bundle)
    {
label0:
        {
            if (bundle == null)
            {
                p = new c();
                Bundle bundle1 = new Bundle();
                bundle1.putBoolean("enableChatPlus", true);
                bundle1.putBoolean("enableSticker", false);
                p.setArguments(bundle1);
                p.a(ay);
                p.a(aw);
                getSupportFragmentManager().beginTransaction().add(o.menuFragmentContainer, p, "MessageInput").show(p).commitAllowingStateLoss();
                a(true);
            } else
            {
                p = (c)getSupportFragmentManager().findFragmentByTag("MessageInput");
                p.a(ay);
                p.a(aw);
                a(true);
            }
            if (getIntent().getBooleanExtra("createNewMessage", false))
            {
                if (bundle != null)
                {
                    break label0;
                }
                q = new e();
                q.a(av);
                getSupportFragmentManager().beginTransaction().add(o.selectFollowersFragmentContainer, q, "SelectFollower").show(q).commitAllowingStateLoss();
                a(false);
            }
            return;
        }
        q = (e)getSupportFragmentManager().findFragmentByTag("SelectFollower");
        q.a(av);
        a(false);
    }

    private void a(TextView textview)
    {
        com.cyberlink.you.utility.d.a(textview);
    }

    private void a(ChatDialogMode chatdialogmode, int i1)
    {
        p.a(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false));
        com.cyberlink.you.utility.d.a(l(), false);
        ai = chatdialogmode;
        if (ai.equals(com.cyberlink.you.activity.ChatDialogMode.a))
        {
            x.clearChoices();
            x.setChoiceMode(0);
            J.setVisibility(8);
            p.e();
        } else
        {
            x.setChoiceMode(2);
            x.setItemChecked(i1, true);
            J.setVisibility(0);
            p.f();
            C();
        }
        H.notifyDataSetChanged();
    }

    static void a(ChatDialogActivity chatdialogactivity, TextView textview)
    {
        chatdialogactivity.a(textview);
    }

    static void a(ChatDialogActivity chatdialogactivity, ChatDialogMode chatdialogmode, int i1)
    {
        chatdialogactivity.a(chatdialogmode, i1);
    }

    static void a(ChatDialogActivity chatdialogactivity, Group group)
    {
        chatdialogactivity.b(group);
    }

    static void a(ChatDialogActivity chatdialogactivity, com.cyberlink.you.database.MessageObj.MessageType messagetype, String s1)
    {
        chatdialogactivity.b(messagetype, s1);
    }

    static void a(ChatDialogActivity chatdialogactivity, MessageObj messageobj, String s1)
    {
        chatdialogactivity.a(messageobj, s1);
    }

    static void a(ChatDialogActivity chatdialogactivity, StickerPackObj stickerpackobj)
    {
        chatdialogactivity.a(stickerpackobj);
    }

    static void a(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.a(s1);
    }

    static void a(ChatDialogActivity chatdialogactivity, String s1, MessageObj messageobj)
    {
        chatdialogactivity.a(s1, messageobj);
    }

    static void a(ChatDialogActivity chatdialogactivity, String s1, String s2, String s3, String s4)
    {
        chatdialogactivity.a(s1, s2, s3, s4);
    }

    static void a(ChatDialogActivity chatdialogactivity, List list)
    {
        chatdialogactivity.a(list);
    }

    static void a(Group group, List list)
    {
        b(group, list);
    }

    private void a(MessageObj messageobj, String s1)
    {
    }

    private void a(MessageObj messageobj, String s1, Friend friend)
    {
        boolean flag;
        if (friend != null)
        {
            friend = friend.b();
        } else
        {
            friend = "";
        }
        flag = com.cyberlink.you.g.a().b(s1);
        l().runOnUiThread(new Runnable(flag, messageobj, friend) {

            final boolean a;
            final MessageObj b;
            final String c;
            final ChatDialogActivity d;

            public void run()
            {
                Object obj = com.cyberlink.you.activity.ChatDialogActivity.p(d);
                obj;
                JVM INSTR monitorenter ;
                if (com.cyberlink.you.activity.ChatDialogActivity.a(d) == null) goto _L2; else goto _L1
_L1:
                if (a) goto _L4; else goto _L3
_L3:
                int i1;
                int j1;
                i1 = (com.cyberlink.you.activity.ChatDialogActivity.a(d).getCount() - 1) + com.cyberlink.you.activity.ChatDialogActivity.c(d).getHeaderViewsCount();
                j1 = com.cyberlink.you.activity.ChatDialogActivity.c(d).getLastVisiblePosition();
                if (i1 != j1) goto _L6; else goto _L5
_L5:
                com.cyberlink.you.activity.ChatDialogActivity.b(d, false);
_L8:
                if (com.cyberlink.you.activity.ChatDialogActivity.q(d) == null)
                {
                    com.cyberlink.you.activity.ChatDialogActivity.a(d, new com.cyberlink.you.utility.o());
                    com.cyberlink.you.activity.ChatDialogActivity.q(d).a(5);
                }
                if (!com.cyberlink.you.activity.ChatDialogActivity.r(d) && SystemClock.uptimeMillis() - ChatDialogActivity.s(d) > 2000L && com.cyberlink.you.activity.ChatDialogActivity.q(d).a(ChatDialogActivity.t(d), false))
                {
                    com.cyberlink.you.activity.ChatDialogActivity.a(d, SystemClock.uptimeMillis());
                }
_L4:
                com.cyberlink.you.activity.ChatDialogActivity.a(d).d(b);
_L2:
                obj;
                JVM INSTR monitorexit ;
                return;
_L6:
                if (i1 <= j1) goto _L8; else goto _L7
_L7:
                com.cyberlink.you.activity.ChatDialogActivity.a(d, b, c);
                  goto _L8
                Exception exception;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                d = ChatDialogActivity.this;
                a = flag;
                b = messageobj;
                c = s1;
                super();
            }
        });
    }

    private void a(StickerPackObj stickerpackobj)
    {
        Intent intent = new Intent(l(), com/cyberlink/you/activity/StickerShopDetailActivity);
        intent.putExtra("stickerPckObj", stickerpackobj);
        intent.putExtra("isPurchased", false);
        l().startActivityForResult(intent, 6);
    }

    private void a(String s1)
    {
        int i1 = 1000;
        if (!s1.equals("")) goto _L2; else goto _L1
_L1:
        if (R)
        {
            S = S + 1;
            if (S != 5);
            if (S == 10)
            {
                U = true;
                Toast.makeText(l(), "Cheat Code Enabled", 1).show();
            }
        }
_L4:
        return;
_L2:
        if (!R || !U)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = s1.toLowerCase(Locale.getDefault());
        if (((String) (obj)).startsWith("$$message"))
        {
            int j1 = NumberUtils.toInt(((String) (obj)).substring(9).trim(), -1);
            if (j1 != -1)
            {
                StringBuilder stringbuilder;
                boolean flag;
                if (j1 <= 1000)
                {
                    i1 = j1;
                }
                (new Thread(new Runnable(i1) {

                    final int a;
                    final ChatDialogActivity b;

                    public void run()
                    {
                        Thread.currentThread().setName("Auto send message");
                        String s2 = org.jivesoftware.smack.util.p.a(6);
                        int k1 = 1;
                        while (k1 <= a) 
                        {
                            b.runOnUiThread(new Runnable(this, s2, k1) {

                                final String a;
                                final int b;
                                final _cls42 c;

                                public void run()
                                {
                                    c.b.a(com.cyberlink.you.database.MessageObj.MessageType.a, (new StringBuilder()).append("Auto sent message (").append(a).append(") #").append(b).toString());
                                }

            
            {
                c = _pcls42;
                a = s1;
                b = i1;
                super();
            }
                            });
                            try
                            {
                                Thread.sleep(com.cyberlink.you.activity.ChatDialogActivity.j(b));
                            }
                            catch (InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                            }
                            k1++;
                        }
                    }

            
            {
                b = ChatDialogActivity.this;
                a = i1;
                super();
            }
                })).start();
                p.b();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).startsWith("$$sticker"))
        {
            j1 = NumberUtils.toInt(((String) (obj)).substring(9).trim(), -1);
            if (j1 != -1)
            {
                if (j1 <= 1000)
                {
                    i1 = j1;
                }
                (new Thread(new Runnable(i1) {

                    final int a;
                    final ChatDialogActivity b;

                    public void run()
                    {
                        List list;
                        int l1;
                        int i2;
                        Thread.currentThread().setName("auto send sticker");
                        list = com.cyberlink.you.e.i().a();
                        i2 = 1;
                        l1 = 0;
_L9:
                        if (i2 > list.size()) goto _L2; else goto _L1
_L1:
                        List list1;
                        int k1;
                        list1 = com.cyberlink.you.e.h().b(((StickerPackObj)list.get(i2 - 1)).b());
                        k1 = l1;
                        if (list1 == null) goto _L4; else goto _L3
_L3:
                        int j2 = 1;
_L7:
                        k1 = l1;
                        if (j2 >= list1.size()) goto _L4; else goto _L5
_L5:
                        k1 = l1 + 1;
                        b.runOnUiThread(new Runnable(this, list1, j2 - 1) {

                            final List a;
                            final int b;
                            final _cls43 c;

                            public void run()
                            {
                                c.b.a((StickerObj)a.get(b));
                            }

            
            {
                c = _pcls43;
                a = list;
                b = i1;
                super();
            }
                        });
                        try
                        {
                            Thread.sleep(com.cyberlink.you.activity.ChatDialogActivity.j(b));
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                        if (k1 < a) goto _L6; else goto _L4
_L4:
                        i2++;
                        l1 = k1;
                        continue; /* Loop/switch isn't completed */
_L6:
                        j2++;
                        l1 = k1;
                        if (true) goto _L7; else goto _L2
_L2:
                        return;
                        if (true) goto _L9; else goto _L8
_L8:
                    }

            
            {
                b = ChatDialogActivity.this;
                a = i1;
                super();
            }
                })).start();
                p.b();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).startsWith("$$delay"))
        {
            j1 = NumberUtils.toInt(((String) (obj)).substring(7).trim(), -1);
            if (j1 != -1)
            {
                i1 = j1;
                if (j1 < 100)
                {
                    i1 = j1 * 1000;
                }
                T = i1;
                Toast.makeText(l(), (new StringBuilder()).append("delay ").append(i1).append(" ms").toString(), 1).show();
                p.b();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equals("$$echo"))
        {
            if (!V)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            V = flag;
            obj = l();
            stringbuilder = (new StringBuilder()).append("Echo ");
            if (V)
            {
                s1 = "Enabled";
            } else
            {
                s1 = "Disabled";
            }
            Toast.makeText(((Context) (obj)), stringbuilder.append(s1).toString(), 1).show();
            p.b();
            return;
        }
        if (((String) (obj)).equals("$$format"))
        {
            com.cyberlink.you.utility.d.a(true);
            Toast.makeText(l(), "time format : mm:ss.SSS", 1).show();
            p.b();
            return;
        }
        if (((String) (obj)).equals("$$logout"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equals("$$init"))
        {
            com.cyberlink.you.b.a.a().b();
        } else
        if (((String) (obj)).equals("$$log"))
        {
            D();
            p.b();
            return;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        a(com.cyberlink.you.database.MessageObj.MessageType.a, s1);
        p.b();
        p.c();
        return;
    }

    private void a(String s1, ImageView imageview)
    {
        LoadImageUtils.a(this, (Friend)af.get(s1), imageview);
        Friend friend = i(s1);
        if (friend != null)
        {
            LoadImageUtils.a(this, friend, imageview);
        } else
        if (s1 != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
            arraylist.add(new BasicNameValuePair("userId", s1));
            a.a("user", "userInfo", arraylist, new com.cyberlink.you.friends.p(imageview) {

                final ImageView a;
                final ChatDialogActivity b;

                public void a(String s2, String s3, String s4, String s5)
                {
                    if (s4 == null)
                    {
                        Log.d("ChatDialogActivity", "Response is null");
                        return;
                    }
                    if (!s4.equals("200"))
                    {
                        Log.d("ChatDialogActivity", (new StringBuilder()).append("statusCode=").append(s4).toString());
                        return;
                    } else
                    {
                        s2 = com.cyberlink.you.utility.h.a(com.cyberlink.you.utility.h.a(s5));
                        com.cyberlink.you.e.g().a(s2);
                        com.cyberlink.you.activity.ChatDialogActivity.g(b).runOnUiThread(new Runnable(this, s2) {

                            final Friend a;
                            final _cls33 b;

                            public void run()
                            {
                                LoadImageUtils.a(b.b, a, b.a);
                            }

            
            {
                b = _pcls33;
                a = friend;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                b = ChatDialogActivity.this;
                a = imageview;
                super();
            }
            });
            return;
        }
    }

    private void a(String s1, MessageObj messageobj)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(messageobj);
        com.cyberlink.you.chat.ab.a().b(s1, arraylist);
    }

    private void a(String s1, String s2, String s3, String s4)
    {
        Log.d("ChatDialogActivity", "[handleGroupUpdate]");
        if (o != null)
        {
            if (s2 == null || !s2.equals(String.valueOf(o.b)))
            {
                Log.d("ChatDialogActivity", "[handleGroupUpdate] not this group");
                return;
            }
            if (s1.equals("group.member.leaved") || s1.equals("group.member.deleted"))
            {
                if (s3 != null && !s3.equals(String.valueOf(com.cyberlink.you.g.a().g())))
                {
                    long l1 = Long.parseLong(s3);
                    if (W != null && W.containsKey(Long.valueOf(l1)))
                    {
                        W.remove(Long.valueOf(l1));
                    }
                } else
                if (s3 != null && s3.equals(String.valueOf(com.cyberlink.you.g.a().g())) && s1.equals("group.member.deleted"))
                {
                    finish();
                    return;
                }
            }
            if (s1.equals("group.member.created"))
            {
                e(s3);
            }
            s2 = com.cyberlink.you.e.f().a(s2);
            if (s2 == null)
            {
                Log.d("ChatDialogActivity", "[handleGroupUpdate] group does not in database");
                return;
            }
            o.b(s2);
            if (s4 != null)
            {
                s2 = com.cyberlink.you.e.d().a(s4);
                l().runOnUiThread(new Runnable(s1, s4, s2) {

                    final String a;
                    final String b;
                    final MessageObj c;
                    final ChatDialogActivity d;

                    public void run()
                    {
                        if (!a.equals("group.member.leaved") && !a.equals("group.member.created") && !a.equals("group.member.deleted") && !a.equals("group.admin.created") && !a.equals("group.admin.deleted") && !a.equals("media.album.deleted") && !a.equals("group.display.name.updated")) goto _L2; else goto _L1
_L1:
                        if (b != null && c != null && com.cyberlink.you.activity.ChatDialogActivity.a(d) != null)
                        {
                            com.cyberlink.you.activity.ChatDialogActivity.a(d).d(c);
                        }
_L4:
                        ChatDialogActivity.F(d);
                        return;
_L2:
                        if (a.equals("media.media.created") && com.cyberlink.you.activity.ChatDialogActivity.a(d) != null)
                        {
                            com.cyberlink.you.activity.ChatDialogActivity.a(d).notifyDataSetChanged();
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                d = ChatDialogActivity.this;
                a = s1;
                b = s2;
                c = messageobj;
                super();
            }
                });
                return;
            }
        }
    }

    private void a(List list)
    {
        (new AsyncTask(list) {

            final List a;
            final ChatDialogActivity b;

            protected transient Group a(Void avoid[])
            {
                if (a == null || a.isEmpty())
                {
                    return null;
                } else
                {
                    return com.cyberlink.you.e.f().a(a);
                }
            }

            public void a(Group group)
            {
                com.cyberlink.you.activity.ChatDialogActivity.a(b, group);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Group)obj);
            }

            
            {
                b = ChatDialogActivity.this;
                a = list;
                super();
            }
        }).executeOnExecutor(ar, new Void[0]);
    }

    private void a(List list, Group group)
    {
        group.f = com.cyberlink.you.utility.d.a(list);
        com.cyberlink.you.e.f().a(String.valueOf(group.b), group, "DisplayName");
        ChatListHandler.d(group.b);
    }

    private void a(List list, com.cyberlink.you.database.MessageObj.MessageType messagetype, String s1)
    {
        if (list != null && !list.isEmpty())
        {
            String s2;
            if (list.size() == 1)
            {
                s2 = "Dual";
            } else
            {
                s2 = "Circle";
            }
            messagetype = new com.cyberlink.you.activity.f(this, messagetype, s1);
            com.cyberlink.you.friends.k.a(a, list, s2, messagetype, messagetype).a();
            b(true);
        }
    }

    private static void a(Message message, String s1)
    {
        com.cyberlink.you.chat.ab.a().b(message.r(), s1, message);
    }

    static boolean a(ChatDialogActivity chatdialogactivity, boolean flag)
    {
        chatdialogactivity.N = flag;
        return flag;
    }

    private boolean a(Group group, boolean flag)
    {
        Object obj2 = com.cyberlink.you.g.a().e();
        Object obj = com.cyberlink.you.e.l().a(Long.valueOf(group.b));
        Object obj1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", ((String) (obj2))));
        arraylist.add(new BasicNameValuePair("groupId", String.valueOf(group.b)));
        arraylist.add(new BasicNameValuePair("pageIndex", String.valueOf(1)));
        arraylist.add(new BasicNameValuePair("pageSize", String.valueOf(200)));
        obj2 = a.a("group", "listGroupMembers", arraylist);
        if (obj2 != null && ((Pair) (obj2)).first != null && ((String)((Pair) (obj2)).first).equals("200"))
        {
            obj2 = b((String)((Pair) (obj2)).second);
            ((List) (obj1)).addAll(((java.util.Collection) (obj2)));
            a(((List) (obj2)), group);
            flag = true;
        } else
        {
            Log.d("ChatDialogActivity", (new StringBuilder()).append("[queryGroupMemberFromServer] fail : result = ").append(obj2).toString());
            flag = false;
        }
        if (obj != null && ((List) (obj)).size() > 0 && flag)
        {
            obj1 = ((List) (obj1)).iterator();
label0:
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                obj2 = (Friend)((Iterator) (obj1)).next();
                Iterator iterator = ((List) (obj)).iterator();
                Long long2;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    long2 = (Long)iterator.next();
                } while (long2.longValue() != ((Friend) (obj2)).a);
                ((List) (obj)).remove(long2);
            } while (true);
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); Log.d("ChatDialogActivity", "Delete from getGroupMemberDao"))
            {
                Long long1 = (Long)((Iterator) (obj)).next();
                com.cyberlink.you.e.l().b(Long.valueOf(group.b), long1);
                if (W != null && W.containsKey(long1))
                {
                    W.remove(long1);
                }
            }

        }
        return flag;
    }

    static boolean a(MessageObj messageobj)
    {
        return b(messageobj);
    }

    static int b(ChatDialogActivity chatdialogactivity, int i1)
    {
        chatdialogactivity.Y = i1;
        return i1;
    }

    static Group b(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.o;
    }

    static StickerObj b(ChatDialogActivity chatdialogactivity, MessageObj messageobj)
    {
        return chatdialogactivity.c(messageobj);
    }

    static String b(ChatDialogActivity chatdialogactivity, b b1)
    {
        return chatdialogactivity.b(b1);
    }

    private String b(b b1)
    {
        if (!b1.p().equals(o.c) || P)
        {
            return null;
        } else
        {
            return com/cyberlink/you/activity/ChatDialogActivity.toString();
        }
    }

    private List b(String s1)
    {
        ArrayList arraylist;
        int i1;
        arraylist = new ArrayList();
        s1 = com.cyberlink.you.utility.h.b(s1);
        if (s1 == null)
        {
            return arraylist;
        }
        i1 = 0;
_L2:
        if (i1 >= s1.length())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        Friend friend = com.cyberlink.you.utility.h.a(s1.getJSONObject(i1));
        if (friend == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        Friend friend1;
        arraylist.add(friend);
        if (com.cyberlink.you.e.g().a(String.valueOf(friend.a)) == null)
        {
            com.cyberlink.you.e.g().a(friend);
        }
        if (W == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        W.put(Long.valueOf(friend.a), friend);
        com.cyberlink.you.e.l().c(Long.valueOf(o.b), Long.valueOf(friend.a));
        if (!o.e.equals("Dual"))
        {
            break MISSING_BLOCK_LABEL_202;
        }
        friend1 = com.cyberlink.you.e.g().a(String.valueOf(friend.a));
        if (friend1 != null)
        {
            try
            {
                W.put(Long.valueOf(friend.a), friend1);
            }
            catch (JSONException jsonexception)
            {
                Log.e("ChatDialogActivity", Log.getStackTraceString(jsonexception));
            }
        }
        break MISSING_BLOCK_LABEL_202;
        return arraylist;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void b(long l1)
    {
        (new AsyncTask(l1) {

            final long a;
            final ChatDialogActivity b;

            protected transient Group a(Void avoid[])
            {
                return com.cyberlink.you.e.f().a(String.valueOf(a));
            }

            public void a(Group group)
            {
                if (group != null)
                {
                    com.cyberlink.you.activity.ChatDialogActivity.a(b, group);
                    return;
                } else
                {
                    b.c();
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Group)obj);
            }

            
            {
                b = ChatDialogActivity.this;
                a = l1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static void b(ChatDialogActivity chatdialogactivity, long l1)
    {
        chatdialogactivity.c(l1);
    }

    static void b(ChatDialogActivity chatdialogactivity, Group group)
    {
        chatdialogactivity.d(group);
    }

    static void b(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.c(s1);
    }

    static void b(ChatDialogActivity chatdialogactivity, boolean flag)
    {
        chatdialogactivity.d(flag);
    }

    private void b(Group group)
    {
        if (o != null)
        {
            b(o, true);
        }
        o = group;
        if (group != null)
        {
            Log.d("ChatDialogActivity", (new StringBuilder()).append("[resetGroup] reset group=").append(group).toString());
            a(group);
            (new AsyncTask() {

                final ChatDialogActivity a;

                protected transient Void a(Void avoid[])
                {
                    Thread.currentThread().setName("onCreate");
                    ChatDialogActivity.v(a);
                    com.cyberlink.you.activity.ChatDialogActivity.b(a, com.cyberlink.you.activity.ChatDialogActivity.b(a));
                    com.cyberlink.you.chat.j.a(a.c);
                    com.cyberlink.you.chat.ab.a().a(a.d);
                    return null;
                }

                public void a(Void void1)
                {
                    ChatDialogActivity.A(a);
                    ChatDialogActivity.B(a);
                    ChatDialogActivity.C(a);
                    ChatDialogActivity.D(a);
                    ChatDialogActivity.E(a);
                    ChatDialogActivity.F(a);
                    ChatDialogActivity.G(a);
                    ChatDialogActivity.H(a);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                public void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            a(((Group) (null)));
            z();
            return;
        }
    }

    private static void b(Group group, List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = list.iterator();
_L6:
        if (!iterator.hasNext()) goto _L1; else goto _L3
_L3:
        MessageObj messageobj = (MessageObj)iterator.next();
        if (aa) goto _L1; else goto _L4
_L4:
        list = messageobj.i();
        if (b(messageobj)) goto _L1; else goto _L5
_L5:
        if (group.e.equals("Dual"))
        {
            list = group.c;
        } else
        {
            list = (new StringBuilder()).append(group.c).append("/").append(list).toString();
        }
        list = new Message(list, org.jivesoftware.smack.packet.Message.Type.b);
        list.a(new DeliveryReceipt(messageobj.b()));
        a(list, messageobj.b());
          goto _L6
    }

    private void b(Group group, boolean flag)
    {
        if (group == null)
        {
            return;
        }
        if (flag)
        {
            group.o = a();
        }
        (new AsyncTask(flag, group) {

            final boolean a;
            final Group b;
            final ChatDialogActivity c;

            protected transient Void a(Void avoid[])
            {
                Thread.currentThread().setName("updateLastRead");
                avoid = new ArrayList();
                if (a)
                {
                    avoid.add("DraftText");
                }
                if (com.cyberlink.you.activity.ChatDialogActivity.a(c) != null && com.cyberlink.you.activity.ChatDialogActivity.a(c).a() > 0)
                {
                    b.k = com.cyberlink.you.activity.ChatDialogActivity.a(c).b(com.cyberlink.you.activity.ChatDialogActivity.a(c).a() - 1).d().getTime();
                    avoid.add("LastRead");
                }
                com.cyberlink.you.e.f().a(String.valueOf(b.b), b, avoid);
                UnreadCountManager.b().a(b.c);
                com.cyberlink.you.utility.i.a(String.valueOf(b.b));
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                c = ChatDialogActivity.this;
                a = flag;
                b = group;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void b(com.cyberlink.you.database.MessageObj.MessageType messagetype, String s1)
    {
        Log.d("ChatDialogActivity", (new StringBuilder()).append("[doSendMessage] do send message. type=").append(messagetype).toString());
        String s2 = o.c;
        messagetype = com.cyberlink.you.chat.d.a(String.valueOf(o.b), messagetype, s1);
        if (messagetype == null)
        {
            return;
        } else
        {
            messagetype.b(new Date());
            (new AsyncTask(messagetype, s2) {

                final MessageObj a;
                final String b;
                final ChatDialogActivity c;

                protected transient Void a(Void avoid[])
                {
                    Thread.currentThread().setName("insert_messageObj");
                    com.cyberlink.you.e.d().a(a);
                    return null;
                }

                protected void a(Void void1)
                {
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(c) != null)
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.a(c).c(a);
                        com.cyberlink.you.activity.ChatDialogActivity.m(c);
                    }
                    com.cyberlink.you.activity.ChatDialogActivity.a(c, b, a);
                    if (ChatDialogActivity.O(c) != null)
                    {
                        ChatDialogActivity.O(c).schedule(new com.cyberlink.you.activity.j(c), 1000L);
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                c = ChatDialogActivity.this;
                a = messageobj;
                b = s1;
                super();
            }
            }).executeOnExecutor(ar, new Void[0]);
            return;
        }
    }

    private static boolean b(MessageObj messageobj)
    {
        boolean flag = false;
        String s1 = String.valueOf(com.cyberlink.you.g.a().g());
        messageobj = messageobj.i();
        if (messageobj != null)
        {
            flag = messageobj.equals(s1);
        }
        return flag;
    }

    static ListView c(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.x;
    }

    private StickerObj c(MessageObj messageobj)
    {
        Object obj = null;
        long l1;
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.k))
        {
            l1 = NumberUtils.toLong(messageobj.b("stickerId"), -1L);
        } else
        {
            l1 = NumberUtils.toLong(messageobj.g(), -1L);
        }
        messageobj = obj;
        if (l1 != -1L)
        {
            messageobj = com.cyberlink.you.e.h().a(l1);
        }
        return messageobj;
    }

    static String c(ChatDialogActivity chatdialogactivity, b b1)
    {
        return chatdialogactivity.a(b1);
    }

    private String c(b b1)
    {
        X.add(b1);
        if (b1.p().equals(o.c) && b1.g() == com.cyberlink.you.database.MessageObj.MessageType.e)
        {
            d(b1);
        }
        return null;
    }

    private void c(long l1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Long.valueOf(l1));
        a(arraylist, ((com.cyberlink.you.database.MessageObj.MessageType) (null)), ((String) (null)));
    }

    static void c(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.d(s1);
    }

    static void c(ChatDialogActivity chatdialogactivity, boolean flag)
    {
        chatdialogactivity.c(flag);
    }

    private void c(String s1)
    {
        if (ah != null)
        {
            String s2;
            if (ah.e().equals(com.cyberlink.you.database.MessageObj.MessageType.m))
            {
                s2 = ah.b("replyText");
            } else
            {
                s2 = ah.g();
            }
            s1 = com.cyberlink.you.chat.d.a(ah.b(), s2, ah.i(), s1);
            a(com.cyberlink.you.database.MessageObj.MessageType.m, s1);
            ah = null;
        }
        A.setVisibility(8);
        p.b();
    }

    private void c(boolean flag)
    {
        boolean flag1 = p.a(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false));
        com.cyberlink.you.utility.d.a(l(), false);
        if (!flag1 && flag)
        {
            finish();
        }
    }

    private boolean c(Group group)
    {
        Group group1 = com.cyberlink.you.e.f().a(String.valueOf(group.b));
        group = com.cyberlink.you.e.l().a(Long.valueOf(group.b));
        return group != null && group1 != null && group1.g == (long)group.size();
    }

    static MessageObj d(ChatDialogActivity chatdialogactivity, b b1)
    {
        return chatdialogactivity.f(b1);
    }

    static void d(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.k();
    }

    static void d(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.f(s1);
    }

    private void d(b b1)
    {
        b1 = (DeliveryReceipt)b1.a("received", "urn:xmpp:receipts");
        if (b1 != null)
        {
            b1 = b1.c();
            l().runOnUiThread(new Runnable(b1) {

                final String a;
                final ChatDialogActivity b;

                public void run()
                {
                    Object obj = com.cyberlink.you.activity.ChatDialogActivity.p(b);
                    obj;
                    JVM INSTR monitorenter ;
                    Object obj1 = com.cyberlink.you.e.d().a(a);
                    if (obj1 != null)
                    {
                        break MISSING_BLOCK_LABEL_83;
                    }
                    obj1 = new StringBuffer();
                    ((StringBuffer) (obj1)).append("[").append("ChatDialogActivity").append("]");
                    ((StringBuffer) (obj1)).append(" onHandleReceiveDeliveryReceipt: messageId=").append(a);
                    ((StringBuffer) (obj1)).append(", messageObj is null");
                    ULogUtility.a(((StringBuffer) (obj1)).toString(), "Receive");
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    MessageObj messageobj = (MessageObj)com.cyberlink.you.activity.ChatDialogActivity.w(b).get(((MessageObj) (obj1)).b());
                    if (messageobj != null)
                    {
                        break MISSING_BLOCK_LABEL_156;
                    }
                    obj1 = new StringBuffer();
                    ((StringBuffer) (obj1)).append("[").append("ChatDialogActivity").append("]");
                    ((StringBuffer) (obj1)).append(" onHandleReceiveDeliveryReceipt: readMessageObj is null");
                    ULogUtility.a(((StringBuffer) (obj1)).toString(), "Receive");
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    obj1;
                    obj;
                    JVM INSTR monitorexit ;
                    throw obj1;
                    messageobj.a(((MessageObj) (obj1)).h());
                    if (messageobj.j() == "3" || messageobj.j() == "2")
                    {
                        messageobj.c("0");
                    }
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(b) != null && com.cyberlink.you.activity.ChatDialogActivity.a(b).b(messageobj))
                    {
                        com.cyberlink.you.activity.e.a(com.cyberlink.you.activity.ChatDialogActivity.a(b), new com.cyberlink.you.database.g());
                    }
                    obj;
                    JVM INSTR monitorexit ;
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(b) != null)
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.a(b).notifyDataSetChanged();
                    }
                    return;
                }

            
            {
                b = ChatDialogActivity.this;
                a = s1;
                super();
            }
            });
        }
    }

    private void d(Group group)
    {
        boolean flag1 = true;
        if (W == null)
        {
            W = new HashMap();
        }
        boolean flag;
        boolean flag2;
        if (group.f == null || group.f.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (c(group))
        {
            Log.d("ChatDialogActivity", "[queryAndSyncGroupMember] GroupInfo.numberOfMember and GroupMemberList count is same");
            flag = flag1;
        } else
        {
            obj = a.b(String.valueOf(group.b));
            flag = flag1;
            if (obj != null)
            {
                com.cyberlink.you.e.f().a(((Group) (obj)));
                flag = flag1;
                if (a(((Group) (obj)), flag2))
                {
                    flag = false;
                }
            }
        }
        if (flag)
        {
            Object obj = com.cyberlink.you.e.g().a(group.b);
            Friend friend;
            for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); W.put(Long.valueOf(friend.a), friend))
            {
                friend = (Friend)iterator.next();
            }

            if (flag2)
            {
                a(((List) (obj)), group);
            }
        }
    }

    private void d(String s1)
    {
        a(com.cyberlink.you.database.MessageObj.MessageType.n, com.cyberlink.you.chat.d.a(s1));
    }

    private void d(boolean flag)
    {
        View view = getCurrentFocus();
        x.post(new Runnable(flag, view) {

            final boolean a;
            final View b;
            final ChatDialogActivity c;

            public void run()
            {
                if (com.cyberlink.you.activity.ChatDialogActivity.a(c) != null && !com.cyberlink.you.activity.ChatDialogActivity.a(c).isEmpty())
                {
                    if (a)
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.c(c).requestFocusFromTouch();
                    }
                    com.cyberlink.you.activity.ChatDialogActivity.c(c).setSelection(com.cyberlink.you.activity.ChatDialogActivity.a(c).getCount() - 1);
                    if (a && b != null)
                    {
                        b.requestFocusFromTouch();
                    }
                }
            }

            
            {
                c = ChatDialogActivity.this;
                a = flag;
                b = view;
                super();
            }
        });
    }

    static int e(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.am;
    }

    static void e(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.g(s1);
    }

    private void e(b b1)
    {
        if ((DeliveryReceiptRequest)b1.a("request", "urn:xmpp:receipts") != null)
        {
            Object obj;
            if (o.e.equals("Dual"))
            {
                obj = org.jivesoftware.smack.util.p.d(b1.o());
            } else
            {
                obj = b1.o();
            }
            obj = new Message(((String) (obj)), org.jivesoftware.smack.packet.Message.Type.b);
            ((Message) (obj)).a(new DeliveryReceipt(b1.i()));
            a(((Message) (obj)), b1.i());
        }
    }

    private void e(String s1)
    {
        if (s1 != null && !s1.equals(String.valueOf(com.cyberlink.you.g.a().g()))) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Friend friend = com.cyberlink.you.e.g().a(s1);
        if (friend == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (W != null)
        {
            W.put(Long.valueOf(friend.a), friend);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Friend friend1 = i(s1);
        if (friend1 != null)
        {
            if (W != null)
            {
                W.put(Long.valueOf(friend1.a), friend1);
                return;
            }
        } else
        {
            (new AsyncTask(s1) {

                final String a;
                final ChatDialogActivity b;

                protected transient Void a(Void avoid[])
                {
                    Thread.currentThread().setName("updateGroupMember4AddNewMember AsyncTask");
                    avoid = b.a.a(a);
                    if (avoid != null)
                    {
                        com.cyberlink.you.e.g().a(avoid);
                        if (ChatDialogActivity.N(b) != null)
                        {
                            ChatDialogActivity.N(b).put(Long.valueOf(((Friend) (avoid)).a), avoid);
                        }
                    }
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                b = ChatDialogActivity.this;
                a = s1;
                super();
            }
            }).executeOnExecutor(b, new Void[0]);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static TextView f(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.z;
    }

    private MessageObj f(b b1)
    {
        if (H == null || H.isEmpty() || !b1.k().before(H.b(0).d()))
        {
            String s1 = com.cyberlink.you.g.a().f();
            if (b1.p().equals(o.c) && b1.l().equals(s1) || b1.p().equals(s1) && b1.l().equals(o.c))
            {
                while (false) 
                {
                    if (!b1.p().equals(String.valueOf(com.cyberlink.you.g.a().g())) && !P && !b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())))
                    {
                        e(b1);
                    }
                    b1 = b1.a(String.valueOf(o.b));
                    if (b1 != null)
                    {
                        return b1;
                    }
                }
            } else
            {
                while (false) 
                {
                    if (!b1.p().equals(String.valueOf(com.cyberlink.you.g.a().g())) && !P && !b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())))
                    {
                        e(b1);
                    }
                    b1 = b1.a(String.valueOf(o.b));
                    if (b1 != null)
                    {
                        return b1;
                    }
                }
            }
        }
        return null;
    }

    static ThreadGroup f()
    {
        return ap;
    }

    static void f(ChatDialogActivity chatdialogactivity, String s1)
    {
        chatdialogactivity.h(s1);
    }

    private void f(String s1)
    {
        s1 = org.jivesoftware.smack.util.p.a(s1);
        if (s1 != null)
        {
            if (af.containsKey(s1))
            {
                af.remove(s1);
            }
            Friend friend = i(s1);
            if (friend != null)
            {
                boolean flag1 = false;
                long l1 = Long.valueOf(s1).longValue();
                boolean flag = flag1;
                if (W != null)
                {
                    flag = flag1;
                    if (W.containsKey(Long.valueOf(l1)))
                    {
                        flag = flag1;
                        if (friend != null)
                        {
                            W.put(Long.valueOf(l1), friend);
                            flag = true;
                        }
                    }
                }
                flag1 = flag;
                if (o.e.equals("Dual"))
                {
                    s1 = com.cyberlink.you.e.f().b(friend.c);
                    flag1 = flag;
                    if (s1 != null)
                    {
                        flag1 = flag;
                        if (o.b == ((Group) (s1)).b)
                        {
                            o = s1;
                            flag1 = true;
                        }
                    }
                }
                if (flag1 && l() != null)
                {
                    l().runOnUiThread(new Runnable() {

                        final ChatDialogActivity a;

                        public void run()
                        {
                            synchronized (com.cyberlink.you.activity.ChatDialogActivity.p(a))
                            {
                                if (com.cyberlink.you.activity.ChatDialogActivity.a(a) != null)
                                {
                                    com.cyberlink.you.activity.ChatDialogActivity.a(a).notifyDataSetChanged();
                                }
                                ChatDialogActivity.F(a);
                            }
                            return;
                            exception;
                            obj;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    static Activity g(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.l();
    }

    static Friend g(ChatDialogActivity chatdialogactivity, String s1)
    {
        return chatdialogactivity.i(s1);
    }

    static ThreadGroup g()
    {
        return aq;
    }

    private void g(String s1)
    {
        if (s1 != null && o.e.equals("Dual"))
        {
            long l1 = Long.valueOf(s1).longValue();
            if (W != null && W.containsKey(Long.valueOf(l1)))
            {
                s1 = com.cyberlink.you.e.g().a(s1);
                if (s1 != null)
                {
                    W.put(Long.valueOf(l1), s1);
                    return;
                }
            }
        }
    }

    static int h()
    {
        return k;
    }

    private void h(String s1)
    {
        while (s1 == null || o.b != Long.valueOf(s1).longValue()) 
        {
            return;
        }
        s1 = com.cyberlink.you.e.f().a(s1);
        if (s1 == null)
        {
            Log.d("ChatDialogActivity", "[handleGroupUpdate] group does not in database");
            return;
        } else
        {
            o.b(s1);
            A();
            return;
        }
    }

    static boolean h(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.N;
    }

    static int i()
    {
        return m;
    }

    static SwipeRefreshLayout i(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.F;
    }

    private Friend i(String s1)
    {
        long l1 = Long.parseLong(s1);
        Friend friend;
        if (W == null)
        {
            friend = null;
        } else
        {
            friend = (Friend)W.get(Long.valueOf(l1));
        }
        if (friend != null)
        {
            return friend;
        }
        boolean flag;
        if (af.containsKey(s1))
        {
            if (af.get(s1) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return (Friend)af.get(s1);
        } else
        {
            Friend friend1 = com.cyberlink.you.e.g().a(s1);
            af.put(s1, friend1);
            return friend1;
        }
    }

    static int j()
    {
        return l;
    }

    static int j(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.T;
    }

    static e k(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.q;
    }

    private void k()
    {
        if (aj == null)
        {
            aj = new AsyncTask() {

                final ChatDialogActivity a;

                protected transient List a(Void avoid[])
                {
                    Object obj;
                    long l1;
                    obj = null;
                    Thread.currentThread().setName("messageQueryTask");
                    l1 = System.currentTimeMillis();
                    avoid = obj;
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(a) == null) goto _L2; else goto _L1
_L1:
                    avoid = obj;
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(a).isEmpty()) goto _L2; else goto _L3
_L3:
                    int i1 = 0;
_L6:
                    if (i1 >= com.cyberlink.you.activity.ChatDialogActivity.a(a).getCount())
                    {
                        break MISSING_BLOCK_LABEL_195;
                    }
                    if (com.cyberlink.you.activity.ChatDialogActivity.a(a).b(i1).e() == com.cyberlink.you.database.MessageObj.MessageType.g) goto _L5; else goto _L4
_L4:
                    avoid = com.cyberlink.you.activity.ChatDialogActivity.a(a).b(i1);
_L7:
                    avoid = com.cyberlink.you.e.d().a(String.valueOf(com.cyberlink.you.activity.ChatDialogActivity.b(a).b), String.valueOf(avoid.d().getTime()));
_L2:
                    if (avoid != null)
                    {
                        Collections.sort(avoid, new com.cyberlink.you.database.g());
                    }
                    Log.d("ChatDialogActivity", (new StringBuilder()).append("query message list ").append(String.valueOf((new StringBuilder()).append(System.currentTimeMillis() - l1).append(" ms").toString())).toString());
                    return avoid;
_L5:
                    i1++;
                      goto _L6
                    avoid = null;
                      goto _L7
                }

                protected void a(List list)
                {
                    if (list == null)
                    {
                        return;
                    }
                    if (!list.isEmpty() && com.cyberlink.you.activity.ChatDialogActivity.a(a) != null)
                    {
                        int i1 = com.cyberlink.you.activity.ChatDialogActivity.a(a).getCount();
                        com.cyberlink.you.activity.ChatDialogActivity.a(a).a(list, false);
                        int j1 = com.cyberlink.you.activity.ChatDialogActivity.a(a).getCount();
                        com.cyberlink.you.activity.ChatDialogActivity.c(a).setSelection(j1 - i1);
                    }
                    com.cyberlink.you.activity.ChatDialogActivity.a(a, null);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((List)obj);
                }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
            };
            aj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private Activity l()
    {
        return this;
    }

    static com.cyberlink.you.activity.b l(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.as;
    }

    private void m()
    {
        if (!getIntent().hasExtra("Group")) goto _L2; else goto _L1
_L1:
        Group group = (Group)getIntent().getParcelableExtra("Group");
        if (group == null) goto _L4; else goto _L3
_L3:
        b(group);
_L6:
        return;
_L4:
        c();
        return;
_L2:
        if (getIntent().hasExtra("groupId"))
        {
            Long long1 = Long.valueOf(l().getIntent().getLongExtra("groupId", 0L));
            if (long1.longValue() != 0L)
            {
                b(long1.longValue());
                return;
            } else
            {
                c();
                return;
            }
        }
        if (getIntent().hasExtra("userId"))
        {
            Long long2 = Long.valueOf(l().getIntent().getLongExtra("userId", 0L));
            if (long2.longValue() != 0L)
            {
                a(long2.longValue());
                return;
            } else
            {
                c();
                return;
            }
        }
        if (!G())
        {
            c();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void m(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.q();
    }

    static View n(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.A;
    }

    private void n()
    {
        String s1 = getIntent().getStringExtra("defaultText");
        if (s1 != null)
        {
            try
            {
                p.a(s1);
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_44;
        }
        p.a(o.o);
        return;
    }

    static c o(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.p;
    }

    private void o()
    {
        TextView textview = (TextView)findViewById(o.coverInputBarText);
        if (textview != null)
        {
            String s1;
            if (o != null && o.e != null)
            {
                if (o.e.equals("Dual"))
                {
                    s1 = String.format(getResources().getString(r.u_chat_dialog_disabled_message), new Object[] {
                        o.f
                    });
                } else
                {
                    s1 = String.format(getResources().getString(r.u_chat_dialog_group_disabled), new Object[0]);
                }
            } else
            {
                s1 = String.format(getResources().getString(r.u_chat_dialog_group_disabled), new Object[0]);
            }
            textview.setText(s1);
        }
    }

    static Object p(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.M;
    }

    private void p()
    {
        Intent intent = getIntent();
        if (intent.hasExtra("sendPost"))
        {
            d(intent.getStringExtra("sendPost"));
        }
    }

    static com.cyberlink.you.utility.o q(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ac;
    }

    private void q()
    {
        d(true);
    }

    private void r()
    {
        if (o != null)
        {
            ab = new com.cyberlink.you.activity.h(o);
            ab.start();
        }
    }

    static boolean r(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.P;
    }

    static long s(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ae;
    }

    private void s()
    {
        if (o != null)
        {
            Z = new com.cyberlink.you.activity.i(o);
            aa = false;
            Z.start();
        }
    }

    static AssetFileDescriptor t(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ad;
    }

    private void t()
    {
        if (o != null)
        {
            ((NotificationManager)getSystemService("notification")).cancel(o.c, 1);
        }
    }

    private void u()
    {
        if (o != null)
        {
            UnreadCountManager.b().a(at);
            d();
        }
    }

    static void u(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.B();
    }

    private void v()
    {
        DisplayMetrics displaymetrics = com.cyberlink.you.g.I().getResources().getDisplayMetrics();
        k = (int)((float)displaymetrics.widthPixels * 0.76F);
        m = (int)((float)(displaymetrics.widthPixels - getResources().getDimensionPixelSize(m.recv_avatar_image_width)) * 0.76F);
    }

    static void v(ChatDialogActivity chatdialogactivity)
    {
        chatdialogactivity.s();
    }

    static Map w(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.G;
    }

    private void w()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        l().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float f1 = (float)displaymetrics.widthPixels / 1080F;
        int i1 = (int)Math.ceil(((float)150 / (float)134) * (128F * f1));
        int j1 = (int)v.getPaint().measureText(v.getText().toString());
        int k1 = displaymetrics.widthPixels;
        w.setMaxWidth(k1 - i1 - j1 - i1);
    }

    static List x(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.X;
    }

    private void x()
    {
        n = (int)((float)com.cyberlink.you.g.I().getResources().getDisplayMetrics().widthPixels * 0.95F);
    }

    static GestureDetectorCompat y(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.ag;
    }

    private void y()
    {
        if (G())
        {
            s.setVisibility(8);
            return;
        } else
        {
            s.setVisibility(0);
            return;
        }
    }

    static com.cyberlink.you.chat.o z(ChatDialogActivity chatdialogactivity)
    {
        return chatdialogactivity.aC;
    }

    private void z()
    {
        if (o != null)
        {
            if (!o.e.equals("Dual"))
            {
                if (o.g < 999L)
                {
                    v.setText((new StringBuilder()).append(" (").append(o.g).append(")").toString());
                } else
                {
                    v.setText(" (999+)");
                }
            }
            if (o.g == 1L && (o.f == null || o.f.isEmpty()))
            {
                o.f = getString(r.u_group_empty_room);
            }
            w.setText(o.f);
            return;
        }
        if (q != null)
        {
            w.setText(getString(r.u_new_message));
            return;
        } else
        {
            w.setText("");
            return;
        }
    }

    public String a()
    {
        return p.a();
    }

    public void a(Group group)
    {
        G.clear();
        if (group != null)
        {
            com.cyberlink.you.chat.n.a().a(aA);
            com.cyberlink.you.chat.n.a().a(aD);
            com.cyberlink.you.b.a.a().a(aB);
            (new AsyncTask(group) {

                final Group a;
                final ChatDialogActivity b;

                protected transient Pair a(Void avoid[])
                {
                    Thread.currentThread().setName("resetMessageList AsyncTask");
                    long l1 = System.currentTimeMillis();
                    avoid = com.cyberlink.you.e.d().a(String.valueOf(a.b), null);
                    if (avoid != null)
                    {
                        Collections.sort(avoid, new com.cyberlink.you.database.g());
                    }
                    List list = com.cyberlink.you.e.d().d(String.valueOf(a.b));
                    Log.d("ChatDialogActivity", (new StringBuilder()).append("get message list ").append(String.valueOf((new StringBuilder()).append(System.currentTimeMillis() - l1).append(" ms").toString())).toString());
                    return Pair.create(avoid, list);
                }

                protected void a(Pair pair)
                {
                    Object obj;
                    int i1;
                    if (pair == null)
                    {
                        return;
                    }
                    obj = (List)pair.first;
                    if (obj == null)
                    {
                        obj = new ArrayList();
                    }
                    pair = (List)pair.second;
                    if (pair == null)
                    {
                        pair = new ArrayList();
                    }
                    i1 = ((List) (obj)).size() - 1;
_L3:
                    if (i1 < 0)
                    {
                        break MISSING_BLOCK_LABEL_303;
                    }
                    if (((MessageObj)((List) (obj)).get(i1)).d().getTime() > a.k) goto _L2; else goto _L1
_L1:
                    MessageObj messageobj;
                    if (((List) (obj)).size() - 1 - i1 < 5)
                    {
                        break MISSING_BLOCK_LABEL_303;
                    }
                    messageobj = MessageObj.d(new Date(a.k));
                    ((List) (obj)).add(i1 + 1, messageobj);
_L4:
                    com.cyberlink.you.activity.ChatDialogActivity.a(b).clear();
                    com.cyberlink.you.activity.ChatDialogActivity.a(b).a(((List) (obj)), true);
                    com.cyberlink.you.activity.ChatDialogActivity.a(b).a(ChatDialogActivity.I(b), true);
                    com.cyberlink.you.activity.ChatDialogActivity.a(b).a(pair);
                    com.cyberlink.you.activity.ChatDialogActivity.c(b).setOnItemClickListener(ChatDialogActivity.J(b));
                    com.cyberlink.you.activity.ChatDialogActivity.c(b).setAdapter(com.cyberlink.you.activity.ChatDialogActivity.a(b));
                    com.cyberlink.you.activity.ChatDialogActivity.b(b, com.cyberlink.you.activity.ChatDialogActivity.a(b).getCount() - 1);
                    if (messageobj != null)
                    {
                        com.cyberlink.you.activity.ChatDialogActivity.b(b, com.cyberlink.you.activity.ChatDialogActivity.a(b).a(messageobj) - 1);
                    }
                    com.cyberlink.you.activity.ChatDialogActivity.c(b).setSelection(ChatDialogActivity.K(b));
                    b.d();
                    ChatDialogActivity.L(b);
                    return;
_L2:
                    i1--;
                      goto _L3
                    messageobj = null;
                      goto _L4
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Pair)obj);
                }

            
            {
                b = ChatDialogActivity.this;
                a = group;
                super();
            }
            }).executeOnExecutor(ar, new Void[0]);
            return;
        } else
        {
            com.cyberlink.you.chat.n.a().b(aA);
            com.cyberlink.you.chat.n.a().b(aD);
            com.cyberlink.you.b.a.a().b(aB);
            H.clear();
            return;
        }
    }

    public void a(com.cyberlink.you.database.MessageObj.MessageType messagetype, String s1)
    {
        if (o == null && q != null)
        {
            Log.d("ChatDialogActivity", "[sendMessage] create group fisrt");
            a(q.d(), messagetype, s1);
            return;
        } else
        {
            b();
            b(messagetype, s1);
            return;
        }
    }

    public void a(StickerObj stickerobj)
    {
        Object obj = com.cyberlink.you.e.i().a(stickerobj.c()).d();
        if (((String) (obj)).equals("Static"))
        {
            obj = com.cyberlink.you.database.MessageObj.MessageType.c;
        } else
        if (((String) (obj)).equals("Animation"))
        {
            obj = com.cyberlink.you.database.MessageObj.MessageType.d;
        } else
        {
            obj = com.cyberlink.you.database.MessageObj.MessageType.i;
        }
        a(((com.cyberlink.you.database.MessageObj.MessageType) (obj)), Long.toString(stickerobj.b()));
        p.a(false);
    }

    public void a(boolean flag)
    {
        if (p == null || l() == null || getSupportFragmentManager() == null)
        {
            return;
        }
        if (flag)
        {
            try
            {
                getSupportFragmentManager().beginTransaction().show(p).commitAllowingStateLoss();
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }
        getSupportFragmentManager().beginTransaction().hide(p).commitAllowingStateLoss();
        return;
    }

    public void b()
    {
        if (q != null)
        {
            getSupportFragmentManager().beginTransaction().remove(q).commit();
            q = null;
        }
    }

    public void b(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final ChatDialogActivity b;

            public void run()
            {
                if (ChatDialogActivity.S(b) != null)
                {
                    View view = ChatDialogActivity.S(b);
                    int i1;
                    if (a)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    view.setVisibility(i1);
                }
            }

            
            {
                b = ChatDialogActivity.this;
                a = flag;
                super();
            }
        });
    }

    public void c()
    {
        Log.d("ChatDialogActivity", "[OnCreate] This group doesn't exit! ");
        Toast.makeText(l(), r.u_query_friend_error, 1).show();
        finish();
    }

    public void d()
    {
    }

    public c e()
    {
        return p;
    }

    public void finish()
    {
        E();
        super.finish();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 1 22: default 112
    //                   1 113
    //                   2 290
    //                   3 112
    //                   4 393
    //                   5 430
    //                   6 440
    //                   7 456
    //                   8 112
    //                   9 112
    //                   10 112
    //                   11 112
    //                   12 112
    //                   13 112
    //                   14 112
    //                   15 112
    //                   16 112
    //                   17 112
    //                   18 112
    //                   19 112
    //                   20 496
    //                   21 507
    //                   22 518;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L7 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L8 _L9 _L10
_L1:
        return;
_L2:
        if (j1 == -1 && (intent = intent.getExtras()) != null)
        {
            if ((Group)intent.getParcelable("Group") != null)
            {
                z();
            }
            long al1[] = intent.getLongArray("deleteMembers");
            if (al1 != null)
            {
                j1 = al1.length;
                for (i1 = 0; i1 < j1; i1++)
                {
                    long l1 = al1[i1];
                    if (W != null && W.containsKey(Long.valueOf(l1)))
                    {
                        W.remove(Long.valueOf(l1));
                    }
                }

            }
            intent = intent.getParcelableArrayList("addMembers");
            if (intent != null)
            {
                intent = intent.iterator();
                while (intent.hasNext()) 
                {
                    Friend friend = (Friend)intent.next();
                    if (W != null)
                    {
                        W.put(Long.valueOf(friend.a), friend);
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j1 == -1 && o.e.equals("Dual"))
        {
            intent = (Friend)intent.getParcelableExtra("data");
            if (intent != null)
            {
                if (W != null)
                {
                    W.put(Long.valueOf(((Friend) (intent)).a), intent);
                }
                o.f = intent.b();
                com.cyberlink.you.e.f().a(o, true);
                z();
                if (H != null)
                {
                    H.notifyDataSetChanged();
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 == -1 && o.e.equals("Dual") && intent.getBooleanExtra("isBrokenUp", false))
        {
            finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (j1 == -1)
        {
            finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j1 == -1)
        {
            p.d().a();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (j1 == -1)
        {
            intent = intent.getExtras();
            Intent intent1 = new Intent(this, com/cyberlink/you/activity/ChatDialogActivity);
            intent1.putExtras(intent);
            startActivity(intent1);
            finish();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        p.onActivityResult(i1, j1, intent);
        return;
_L9:
        p.onActivityResult(i1, j1, intent);
        return;
_L10:
        if (j1 != -1) goto _L1; else goto _L11
_L11:
        if (!intent.hasExtra("Group"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = (Group)intent.getParcelableExtra("Group");
        if (o == null || intent == null) goto _L1; else goto _L12
_L12:
        o.a(intent);
        z();
        return;
        if (!intent.hasExtra("isLeaveGroup") || !intent.getBooleanExtra("isLeaveGroup", false)) goto _L1; else goto _L13
_L13:
        finish();
        return;
    }

    public void onBackPressed()
    {
        if (ai.equals(com.cyberlink.you.activity.ChatDialogMode.a))
        {
            c(true);
            return;
        } else
        {
            a(com.cyberlink.you.activity.ChatDialogMode.a, 0);
            return;
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (menuitem != null && H != null) goto _L2; else goto _L1
_L1:
        Log.d("ChatDialogActivity", (new StringBuilder()).append("[onContextItemSelected] MenuItem = ").append(menuitem).append(" , mMessageAdapter = ").append(H).toString());
_L4:
        return false;
_L2:
        int i1;
        i1 = menuitem.getItemId();
        menuitem = menuitem.getIntent();
        if (menuitem == null) goto _L4; else goto _L3
_L3:
        MessageObj messageobj;
        int j1;
        if (!menuitem.hasExtra("data"))
        {
            Log.d("ChatDialogActivity", "[onContextItemSelected] No data");
            return false;
        }
        j1 = menuitem.getIntExtra("data", -1);
        if (j1 == -1)
        {
            Log.d("ChatDialogActivity", "[onContextItemSelected] Get Wrong Index");
            return false;
        }
        int k1 = x.getHeaderViewsCount();
        messageobj = H.b(j1 - k1);
        if (i1 != aF.a) goto _L6; else goto _L5
_L5:
        H.g(messageobj);
_L8:
        return true;
_L6:
        if (i1 == aG.a)
        {
            a(com.cyberlink.you.activity.ChatDialogMode.b, j1);
        } else
        if (i1 == aH.a)
        {
            H.h(messageobj);
        } else
        if (i1 != aI.a)
        {
            if (i1 == aJ.a)
            {
                H.k(messageobj);
            } else
            if (i1 == aK.a)
            {
                H.j(messageobj);
            } else
            if (i1 == aP.a)
            {
                H.i(messageobj);
            } else
            if (i1 == aQ.a)
            {
                ah = messageobj;
                A.setVisibility(0);
                if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.m))
                {
                    menuitem = messageobj.b("replyText");
                } else
                {
                    menuitem = messageobj.g();
                }
                B.setText(menuitem);
                a(messageobj.i(), D);
            } else
            {
                Log.d("ChatDialogActivity", (new StringBuilder()).append("[onContextItemSelected] No matched Click id : ").append(i1).toString());
                return false;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onContextMenuClosed(Menu menu)
    {
        super.onContextMenuClosed(menu);
        if (L != null)
        {
            L.setEnabled(true);
            L = null;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Log.v("ChatDialogActivity", "onCreate");
        super.onCreate(bundle);
        ad = getResources().openRawResourceFd(q.msg_receive_chatroom);
        an = new ArrayList();
        setContentView(com.cyberlink.you.p.u_activity_chat_dialog);
        F = (SwipeRefreshLayout)findViewById(o.swipe_container);
        F.setOnRefreshListener(au);
        if (!com.cyberlink.you.g.a().b())
        {
            F.setEnabled(false);
        } else
        {
            F.setEnabled(true);
        }
        r = (ImageView)findViewById(o.ChatDialogBackBtn);
        r.setOnClickListener(az);
        t = (Button)findViewById(o.ChatDialogSelectDone);
        t.setOnClickListener(aR);
        u = findViewById(o.ChatDialogSelectCancel);
        u.setOnClickListener(aS);
        J = findViewById(o.ChatDialogEditConfirmArea);
        K = findViewById(o.waitingCursor);
        I = (TextView)findViewById(o.chatRoomBadge);
        s = (ImageView)findViewById(o.ChatDialogMoreBtn);
        s.setOnClickListener(aU);
        w = (TextView)findViewById(o.ChatDialogTopBarTitle);
        v = (TextView)findViewById(o.ChatDialogTopBarTitleCount);
        y = (TextView)findViewById(o.noConnectionText);
        z = (TextView)findViewById(o.newMessageText);
        z.setOnClickListener(aT);
        A = findViewById(o.ReplyMessageLayout);
        D = (ImageView)findViewById(o.replyAvatar);
        B = (TextView)findViewById(o.replyText);
        B.setMaxWidth(com.cyberlink.you.g.I().getResources().getDisplayMetrics().widthPixels - 300);
        C = findViewById(o.replyClose);
        C.setOnClickListener(new android.view.View.OnClickListener() {

            final ChatDialogActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.activity.ChatDialogActivity.n(a).setVisibility(8);
                com.cyberlink.you.activity.ChatDialogActivity.a(a, null);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        });
        E = (RelativeLayout)findViewById(o.coverInputBarArea);
        E.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ChatDialogActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        });
        ((RelativeLayout)findViewById(o.messageListLayout)).addOnLayoutChangeListener(ax);
        x = (ListView)findViewById(o.ChatDialogListView);
        x.setSelector(0x106000d);
        as = new com.cyberlink.you.activity.b(this);
        x.setOnScrollListener(as);
        x.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ChatDialogActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (ChatDialogActivity.y(a) == null)
                {
                    return false;
                } else
                {
                    return ChatDialogActivity.y(a).onTouchEvent(motionevent);
                }
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        });
        ag = new GestureDetectorCompat(this, new android.view.GestureDetector.SimpleOnGestureListener() {

            final ChatDialogActivity a;

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                com.cyberlink.you.activity.ChatDialogActivity.c(a, false);
                return false;
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        });
        v();
        x();
        w();
        a(bundle);
        z();
        y();
        ak = new Timer();
        if (com.cyberlink.you.g.a().b())
        {
            U = true;
        }
        (new AsyncTask() {

            final ChatDialogActivity a;

            protected transient Void a(Void avoid[])
            {
                Thread.currentThread().setName("onCreate");
                a.a = new l(com.cyberlink.you.activity.ChatDialogActivity.g(a));
                ChatDialogActivity.v(a);
                com.cyberlink.you.chat.n.a().a(ChatDialogActivity.z(a));
                return null;
            }

            public void a(Void void1)
            {
                if (com.cyberlink.you.chat.j.c())
                {
                    a.b(true);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = ChatDialogActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        H = new com.cyberlink.you.activity.e(this, l(), com.cyberlink.you.p.u_view_item_send_text_msg, new ArrayList());
        G = new HashMap();
        m();
        stopwatch.stop();
        Log.v("ChatDialogActivity", (new StringBuilder()).append("onCreate exit ").append(stopwatch.getTime()).append(" ms").toString());
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        if (contextmenu != null && view != null && H != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        L = view;
        L.setEnabled(false);
        obj = (Integer)view.getTag();
        if (obj == null) goto _L1; else goto _L3
_L3:
        int i1 = ((Integer) (obj)).intValue();
        if (i1 < 0) goto _L1; else goto _L4
_L4:
        Intent intent;
        Object obj1;
        int k1;
        k1 = H.getItemViewType(i1);
        obj1 = H.b(i1);
        obj = new ArrayList();
        intent = new Intent();
        intent.putExtra("data", i1 + x.getHeaderViewsCount());
        if (!H.a(0, k1)) goto _L6; else goto _L5
_L5:
        if (!com.cyberlink.you.chat.d.e(((MessageObj) (obj1)))) goto _L8; else goto _L7
_L7:
        ((List) (obj)).add(aH);
_L6:
        if (((List) (obj)).size() != 0) goto _L10; else goto _L9
_L9:
        Log.d("ChatDialogActivity", "[onCreateContextMenu]Original Rule");
        if (7 != k1 && k1 != 0 && 5 != k1 && 13 != k1) goto _L12; else goto _L11
_L11:
        ((List) (obj)).add(aF);
        if (!((MessageObj) (obj1)).j().equals("0") && !((MessageObj) (obj1)).j().equals("6") && !((MessageObj) (obj1)).j().equals("5"))
        {
            ((List) (obj)).add(aH);
        }
          goto _L10
_L8:
        if (com.cyberlink.you.chat.d.c(((MessageObj) (obj1))))
        {
            ((List) (obj)).add(aP);
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (9 != k1 && 2 != k1 && 8 != k1 && 1 != k1 && 11 != k1 && 4 != k1) goto _L14; else goto _L13
_L13:
        ((List) (obj)).add(aG);
        ((List) (obj)).add(aH);
        ((List) (obj)).add(aJ);
        ((List) (obj)).add(aK);
        ((List) (obj)).add(aI);
        if (9 == k1 || 8 == k1 || 11 == k1)
        {
            ((List) (obj)).remove(aI);
        }
        if (!((MessageObj) (obj1)).j().equals("0") && !((MessageObj) (obj1)).j().equals("6") && !((MessageObj) (obj1)).j().equals("5")) goto _L16; else goto _L15
_L15:
        ((List) (obj)).remove(aH);
_L17:
        obj1 = c(((MessageObj) (obj1)));
        if (obj1 != null)
        {
            long l1 = ((StickerObj) (obj1)).c();
            obj1 = com.cyberlink.you.e.i().a(l1);
            if (obj1 == null || !((StickerPackObj) (obj1)).q() || ((StickerPackObj) (obj1)).j().equals(com.cyberlink.you.database.StickerPackObj.Status.a))
            {
                ((List) (obj)).remove(aK);
            }
        }
        continue; /* Loop/switch isn't completed */
_L16:
        if (((MessageObj) (obj1)).j().equals("3"))
        {
            ((List) (obj)).remove(aI);
        }
        if (true) goto _L17; else goto _L14
_L14:
        if (10 != k1 && 3 != k1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((List) (obj)).add(aE);
        ((List) (obj)).add(aL);
        if (10 == k1 || 3 == k1)
        {
            boolean flag;
            if (3 == k1)
            {
                if (com.cyberlink.you.chat.d.b(((MessageObj) (obj1))))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = true;
            }
            if (flag)
            {
                ((List) (obj)).add(aM);
                ((List) (obj)).add(aN);
                ((List) (obj)).add(aO);
            }
        }
        ((List) (obj)).add(aG);
        ((List) (obj)).add(aH);
        ((List) (obj)).add(aI);
        if (k1 == 10)
        {
            ((List) (obj)).remove(aI);
        }
        if (((MessageObj) (obj1)).j().equals("0") || ((MessageObj) (obj1)).j().equals("6") || ((MessageObj) (obj1)).j().equals("5"))
        {
            ((List) (obj)).remove(aH);
        } else
        if (((MessageObj) (obj1)).k().equals("4") || ((MessageObj) (obj1)).j().equals("3"))
        {
            ((List) (obj)).remove(aI);
        }
        if (true) goto _L10; else goto _L18
_L18:
        Log.d("ChatDialogActivity", (new StringBuilder()).append("[onCreateContextMenu] Not matched message Type : ").append(k1).toString());
        return;
_L10:
        if (((List) (obj)).size() > 0)
        {
            for (int j1 = 0; j1 < ((List) (obj)).size(); j1++)
            {
                obj1 = (com.cyberlink.you.activity.d)((List) (obj)).get(j1);
                contextmenu.add(0, ((com.cyberlink.you.activity.d) (obj1)).a, j1 + 1, getResources().getString(((com.cyberlink.you.activity.d) (obj1)).b)).setIntent(intent);
            }

        }
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        return;
        if (true) goto _L6; else goto _L19
_L19:
    }

    protected void onDestroy()
    {
        try
        {
            ad.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        if (x instanceof ViewGroup)
        {
            for (int i1 = 0; i1 < x.getChildCount(); i1++)
            {
                Object obj = x.getChildAt(i1);
                if (!(((View) (obj)).getTag() instanceof com.cyberlink.you.d.d))
                {
                    continue;
                }
                obj = (com.cyberlink.you.d.d)((View) (obj)).getTag();
                if (obj == null)
                {
                    continue;
                }
                if (((com.cyberlink.you.d.d) (obj)).p != null)
                {
                    ((com.cyberlink.you.d.d) (obj)).p.setOnClickListener(null);
                }
                if (((com.cyberlink.you.d.d) (obj)).b != null)
                {
                    ((com.cyberlink.you.d.d) (obj)).b.setOnClickListener(null);
                }
            }

        }
        if (x != null)
        {
            x.setOnScrollListener(null);
        }
        if (W != null)
        {
            W.clear();
        }
        if (Z != null)
        {
            Z.a();
        }
        if (ab != null)
        {
            ab.a();
        }
        com.cyberlink.you.chat.n.a().b(aA);
        com.cyberlink.you.chat.n.a().b(aD);
        com.cyberlink.you.b.a.a().b(aB);
        com.cyberlink.you.chat.n.a().b(aC);
        com.cyberlink.you.chat.j.b(c);
        com.cyberlink.you.chat.ab.a().b(d);
        if (a != null)
        {
            a.b();
        }
        if (x != null)
        {
            x.setOnScrollListener(null);
            x.setOnTouchListener(null);
        }
        if (r != null)
        {
            r.setOnClickListener(null);
        }
        if (s != null)
        {
            s.setOnClickListener(null);
        }
        if (p != null)
        {
            p.a(null);
            p.a(null);
        }
        if (ak != null)
        {
            ak.cancel();
            ak = null;
        }
        o = null;
        super.onDestroy();
        Log.d("ChatDialogActivity", "onDestroy");
    }

    public void onPause()
    {
        super.onPause();
        P = true;
        aa = true;
        UnreadCountManager.b().b(at);
        b(o, true);
        com.cyberlink.you.a.a().b(getClass().getSimpleName());
    }

    protected void onResume()
    {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Log.v("ChatDialogActivity", "onResume");
        super.onResume();
        com.cyberlink.you.a.a().a(getClass().getSimpleName());
        u();
        B();
        if (!com.cyberlink.you.chat.n.a().d())
        {
            b(false);
        }
        if (H != null)
        {
            H.notifyDataSetChanged();
            if (Q)
            {
                Q = false;
                q();
            }
        }
        if (P)
        {
            s();
            r();
        }
        t();
        P = false;
        stopwatch.stop();
        Log.v("ChatDialogActivity", (new StringBuilder()).append("onResume exit ").append(stopwatch.getTime()).append(" ms").toString());
    }

    public void startActivityForResult(Intent intent, int i1, Bundle bundle)
    {
        try
        {
            if (H != null)
            {
                al = H.getCount();
            }
            super.startActivityForResult(intent, i1, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
        }
    }

    static 
    {
        ao = Runtime.getRuntime().availableProcessors();
        b = new ThreadPoolExecutor(ao + 1, ao * 5 + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(com.cyberlink.you.activity.ChatDialogActivity.f(), runnable, (new StringBuilder()).append("Network AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
        ar = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(com.cyberlink.you.activity.ChatDialogActivity.g(), runnable, (new StringBuilder()).append("Single AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
    }

    private class ChatDialogMode extends Enum
    {

        public static final ChatDialogMode a;
        public static final ChatDialogMode b;
        public static final ChatDialogMode c;
        private static final ChatDialogMode d[];

        public static ChatDialogMode valueOf(String s1)
        {
            return (ChatDialogMode)Enum.valueOf(com/cyberlink/you/activity/ChatDialogActivity$ChatDialogMode, s1);
        }

        public static ChatDialogMode[] values()
        {
            return (ChatDialogMode[])d.clone();
        }

        static 
        {
            a = new ChatDialogMode("NORMAL", 0);
            b = new ChatDialogMode("DELETE", 1);
            c = new ChatDialogMode("RECALL", 2);
            d = (new ChatDialogMode[] {
                a, b, c
            });
        }

        private ChatDialogMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
