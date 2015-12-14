// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.picsart.studio.view.CommentListView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Comment;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.ViewerUsersResponse;
import com.socialin.android.apiv3.request.AddCommentParams;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.activity.SliderActivity;
import com.socialin.android.picsart.profile.adapter.ar;
import com.socialin.android.picsart.profile.adapter.as;
import com.socialin.android.picsart.profile.adapter.ay;
import com.socialin.android.picsart.profile.adapter.j;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.x;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import myobfuscated.cs.b;
import myobfuscated.f.m;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            am, an

public class al extends Fragment
    implements b
{

    public static final String a = (new StringBuilder()).append(com/socialin/android/picsart/profile/fragment/al.getSimpleName()).append(" - ").toString();
    private CommentListView A;
    private RecyclerView B;
    private View C;
    private AutoCompleteTextView D;
    private Button E;
    private ToggleButton F;
    private ToggleButton G;
    private TextView H;
    private View I;
    private View J;
    private View K;
    private View L;
    private View M;
    private View N;
    private j O;
    private ar P;
    private ay Q;
    private ay R;
    private com.socialin.android.adapter.b S;
    private BaseSocialinApiRequestController T;
    private BaseSocialinApiRequestController U;
    private BaseSocialinApiRequestController V;
    private BaseSocialinApiRequestController W;
    private BaseSocialinApiRequestController X;
    ImageItem b;
    android.view.View.OnClickListener c;
    View d;
    public String e;
    private final BaseSocialinApiRequestController f = RequestControllerFactory.createSearchUsersController();
    private final GetUsersParams g = new GetUsersParams();
    private android.widget.RadioGroup.OnCheckedChangeListener h;
    private SharedPreferences i;
    private ArrayList j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private ArrayList p;
    private AddCommentParams q;
    private ParamWithItemId r;
    private Activity s;
    private android.widget.AdapterView.OnItemLongClickListener t;
    private ImageView u;
    private RadioGroup v;
    private RadioButton w;
    private RadioButton x;
    private RadioButton y;
    private RadioButton z;

    public al()
    {
        h = new _cls1();
        j = new ArrayList();
        l = 0;
        m = false;
        n = false;
        o = false;
        q = new AddCommentParams();
        r = new ParamWithItemId();
        t = new _cls12();
        c = new _cls13();
        T = RequestControllerFactory.createAddCommentController();
        U = RequestControllerFactory.createGetItemLikesController();
        V = RequestControllerFactory.createGetItemRepostsController();
        W = RequestControllerFactory.createGetItemCommentsController();
        X = RequestControllerFactory.createGetItemMemboxesController();
    }

    static void A(al al1)
    {
        al1.b();
    }

    static void B(al al1)
    {
        al1.f();
    }

    static void C(al al1)
    {
        al1.g();
    }

    static void D(al al1)
    {
        al1.c();
    }

    static void E(al al1)
    {
        al1.d();
    }

    static void F(al al1)
    {
        al1.h();
    }

    static void G(al al1)
    {
        al1.l();
    }

    static void H(al al1)
    {
        al1.m();
    }

    static View I(al al1)
    {
        return al1.C;
    }

    static boolean J(al al1)
    {
        al1.m = true;
        return true;
    }

    static void K(al al1)
    {
        al1.b(false);
    }

    static View L(al al1)
    {
        return al1.L;
    }

    static View M(al al1)
    {
        return al1.M;
    }

    static boolean N(al al1)
    {
        al1.n = true;
        return true;
    }

    static boolean O(al al1)
    {
        al1.o = true;
        return true;
    }

    static RecyclerView P(al al1)
    {
        return al1.B;
    }

    static ArrayList a(al al1)
    {
        return al1.p;
    }

    public static void a(ay ay1, List list, boolean flag)
    {
        User user = SocialinV3.getInstance().getUser();
        if (!flag) goto _L2; else goto _L1
_L1:
        list.add(user);
        ay1.e();
        ay1.a(list);
        ay1.notifyDataSetChanged();
_L4:
        return;
_L2:
        if (list != null)
        {
            int j1 = list.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                if (((ViewerUser) (user)).id == ((ViewerUser)list.get(i1)).id)
                {
                    list.remove(i1);
                    ay1.e();
                    ay1.a(list);
                    ay1.notifyDataSetChanged();
                    return;
                }
                i1++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(al al1, int i1)
    {
        byte byte0 = 8;
        al1.l = i1;
        if (i1 == 0x7f10093e)
        {
            al1.d.setVisibility(8);
            al1.J.setVisibility(8);
            al1.K.setVisibility(8);
            al1.I.setVisibility(0);
            al1.B.setVisibility(8);
            al1.A.setVisibility(0);
            View view = al1.N;
            if (al1.m)
            {
                i1 = byte0;
            } else
            {
                i1 = 0;
            }
            view.setVisibility(i1);
            al1.A.setOnItemLongClickListener(al1.t);
            if (al1.O != null)
            {
                al1.A.setAdapter(al1.O);
                if (al1.O.isEmpty())
                {
                    al1.a(false);
                }
            }
        } else
        {
            if (i1 == 0x7f10093d)
            {
                al1.g();
                return;
            }
            if (i1 == 0x7f10093f)
            {
                al1.h();
                return;
            }
            if (i1 == 0x7f100940)
            {
                al1.I.setVisibility(8);
                al1.K.setVisibility(8);
                al1.d.setVisibility(8);
                al1.J.setVisibility(0);
                al1.B.setVisibility(0);
                al1.getView().findViewById(0x7f10094e).setVisibility(0);
                al1.A.setVisibility(8);
                al1.A.setOnItemLongClickListener(null);
                if (al1.P != null)
                {
                    al1.B.setAdapter(al1.P);
                    if (al1.P.isEmpty())
                    {
                        al1.a(false);
                        return;
                    }
                }
            }
        }
    }

    static void a(al al1, ViewerUsersResponse viewerusersresponse)
    {
        if (!al1.s.isFinishing() && al1.isAdded() && al1.S != null)
        {
            ArrayList arraylist = new ArrayList();
            al1.S.clear();
            arraylist.addAll(j());
            arraylist.addAll(al1.i());
            a(((List) (arraylist)), viewerusersresponse);
            al1.S.a(arraylist);
            al1.S.notifyDataSetChanged();
            al1.S.getFilter().filter(al1.D.getText());
        }
    }

    static void a(al al1, CharSequence charsequence, char ac[])
    {
        if (al1.getActivity() != null && !al1.getActivity().isFinishing())
        {
            al1.getActivity().runOnUiThread(new _cls16(al1, charsequence, ac));
        }
    }

    static void a(al al1, char ac[], String s1)
    {
        int i1;
        Pattern pattern = Pattern.compile("^[a-z0-9_-]{0,20}$");
        String s2 = s1.toString();
        int j1;
        char c1;
        int k1;
        if (al1.D.getSelectionStart() >= 0)
        {
            i1 = al1.D.getSelectionStart();
        } else
        {
            i1 = s1.length();
        }
        s1 = s2.substring(0, i1);
        j1 = ac.length;
        i1 = 0;
_L3:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        c1 = ac[i1];
        k1 = s1.lastIndexOf(c1);
        if (k1 < 0) goto _L2; else goto _L1
_L1:
        ac = s1.substring(k1);
        if (c1 == ac.charAt(0) && ac.length() == 1 && al1.S != null)
        {
            s1 = new ArrayList();
            al1.S.clear();
            s1.addAll(j());
            s1.addAll(al1.i());
            al1.S.a(s1);
            al1.S.notifyDataSetChanged();
            al1.S.getFilter().filter(al1.D.getText());
        }
        ac = ac.substring(1, ac.length());
_L4:
        if (TextUtils.isEmpty(ac) || !pattern.matcher(ac.toLowerCase()).matches())
        {
            ac = "";
        }
        if (!"".equals(ac))
        {
            if (al1.S != null)
            {
                s1 = new ArrayList();
                al1.S.a(s1);
                al1.S.notifyDataSetChanged();
                al1.S.getFilter().filter(al1.D.getText());
            }
            al1.g.query = ac;
            al1.f.doRequest();
        }
        return;
_L2:
        i1++;
          goto _L3
        ac = "";
          goto _L4
    }

    private static void a(List list, ViewerUsersResponse viewerusersresponse)
    {
        if (viewerusersresponse != null && viewerusersresponse.items != null)
        {
            viewerusersresponse = viewerusersresponse.items.iterator();
            do
            {
                if (!viewerusersresponse.hasNext())
                {
                    break;
                }
                Object obj = (ViewerUser)viewerusersresponse.next();
                obj = (new StringBuilder("@")).append(((ViewerUser) (obj)).username).toString();
                if (!list.contains(obj))
                {
                    list.add(obj);
                }
            } while (true);
        }
    }

    private void a(boolean flag)
    {
        byte byte0 = 8;
        boolean flag2 = false;
        int i1 = w.getId();
        int j1 = i1;
        if (l != 0)
        {
            boolean flag1;
            if (l == 0x7f10093d)
            {
                flag1 = Utils.a(b.likes);
                Object obj = r;
                long l1;
                if (b.origin != null)
                {
                    l1 = b.origin.id;
                } else
                {
                    l1 = b.id;
                }
                obj.itemId = l1;
                obj = r;
                if (b.likes != null)
                {
                    i1 = b.likes.size();
                } else
                {
                    i1 = 0;
                }
                obj.offset = i1;
                r.limit = 10;
                U.setRequestParams(r);
                U.setRequestCompleteListener(new _cls9());
                U.doRequest();
                i1 = x.getId();
            } else
            if (l == 0x7f10093e)
            {
                flag1 = Utils.a(b.comments);
                if (b.comments == null)
                {
                    b.comments = new ArrayList();
                }
                ArrayList arraylist = new ArrayList(b.comments);
                ParamWithItemId paramwithitemid1 = r;
                long l2;
                if (b.origin != null)
                {
                    l2 = b.origin.id;
                } else
                {
                    l2 = b.id;
                }
                paramwithitemid1.itemId = l2;
                r.offset = arraylist.size();
                r.limit = 10;
                W.setRequestParams(r);
                W.setRequestCompleteListener(new _cls8(arraylist));
                W.doRequest();
                i1 = w.getId();
            } else
            if (l == 0x7f10093f)
            {
                flag1 = Utils.a(b.reposts);
                ParamWithItemId paramwithitemid = r;
                long l3;
                if (b.origin != null)
                {
                    l3 = b.origin.id;
                } else
                {
                    l3 = b.id;
                }
                paramwithitemid.itemId = l3;
                paramwithitemid = r;
                if (b.reposts != null)
                {
                    i1 = b.reposts.size();
                } else
                {
                    i1 = 0;
                }
                paramwithitemid.offset = i1;
                r.limit = 10;
                V.setRequestParams(r);
                V.setRequestCompleteListener(new _cls10());
                V.doRequest();
                i1 = y.getId();
            } else
            if (l == 0x7f100940)
            {
                flag1 = Utils.a(b.streams);
                k();
                i1 = z.getId();
            } else
            {
                flag1 = false;
            }
            obj = C;
            if (flag1)
            {
                j1 = 0;
            } else
            {
                j1 = 8;
            }
            ((View) (obj)).setVisibility(j1);
            obj = N;
            if (flag1)
            {
                j1 = byte0;
            } else
            {
                j1 = 0;
            }
            ((View) (obj)).setVisibility(j1);
            if (!flag1)
            {
                flag2 = true;
            }
            b(flag2);
            j1 = i1;
        }
        if (flag)
        {
            v.check(j1);
        }
    }

    static int b(al al1, int i1)
    {
        al1.k = i1;
        return i1;
    }

    static Activity b(al al1)
    {
        return al1.s;
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            L.setVisibility(0);
            M.setVisibility(8);
            return;
        } else
        {
            L.setVisibility(8);
            M.setVisibility(0);
            return;
        }
    }

    static Button c(al al1)
    {
        return al1.E;
    }

    static AutoCompleteTextView d(al al1)
    {
        return al1.D;
    }

    static View e(al al1)
    {
        return al1.N;
    }

    private void e()
    {
        if (b != null)
        {
            G.setChecked(b.isReposted);
            int i1;
            if (b.isReposted)
            {
                i1 = s.getResources().getColor(0x7f0f0082);
            } else
            {
                i1 = -1;
            }
            K.setBackgroundColor(i1);
        }
    }

    private void f()
    {
        if (b != null && b.user != null)
        {
            x.setText(Utils.a(b.likesCount));
            y.setText(Utils.a(b.repostsCount));
            w.setText(Utils.a(b.commentsCount));
            z.setText(Utils.a(b.streamsCount));
        }
    }

    static void f(al al1)
    {
        al1.a(false);
    }

    static View g(al al1)
    {
        return al1.d;
    }

    private void g()
    {
        byte byte0 = 8;
        I.setVisibility(8);
        K.setVisibility(8);
        d.setVisibility(0);
        J.setVisibility(8);
        B.setVisibility(8);
        A.setVisibility(0);
        A.setOnItemLongClickListener(null);
        View view = N;
        if (!n)
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        if (Q != null)
        {
            A.setAdapter(Q);
            if (Q.isEmpty())
            {
                a(false);
            }
        }
        a();
    }

    static ToggleButton h(al al1)
    {
        return al1.F;
    }

    private void h()
    {
        byte byte0 = 8;
        I.setVisibility(8);
        d.setVisibility(8);
        J.setVisibility(8);
        B.setVisibility(8);
        A.setVisibility(0);
        View view = N;
        if (!o)
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        if (b.user.id != SocialinV3.getInstance().getUser().id)
        {
            K.setVisibility(0);
        }
        A.setOnItemLongClickListener(null);
        if (R != null)
        {
            A.setAdapter(R);
            if (R.isEmpty())
            {
                a(false);
            }
        }
        e();
    }

    static View i(al al1)
    {
        return al1.K;
    }

    private List i()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.comments.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Comment)iterator.next();
            obj = (new StringBuilder("@")).append(((Comment) (obj)).user.username).toString();
            if (!arraylist.contains(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        return arraylist;
    }

    static ToggleButton j(al al1)
    {
        return al1.G;
    }

    private static List j()
    {
        String s1 = SocialinV3.getInstance().getAppProps().getGalleryPromoTags();
        ArrayList arraylist = new ArrayList();
        if (s1 != null)
        {
            String as1[] = s1.split(",");
            int j1 = as1.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s2 = as1[i1];
                arraylist.add((new StringBuilder("#")).append(s2).toString());
            }

        }
        Collections.sort(arraylist, String.CASE_INSENSITIVE_ORDER);
        return arraylist;
    }

    private void k()
    {
        ParamWithItemId paramwithitemid = r;
        int i1;
        long l1;
        if (b.origin != null)
        {
            l1 = b.origin.id;
        } else
        {
            l1 = b.id;
        }
        paramwithitemid.itemId = l1;
        paramwithitemid = r;
        if (b.streams != null)
        {
            i1 = b.streams.size();
        } else
        {
            i1 = 0;
        }
        paramwithitemid.offset = i1;
        r.limit = 10;
        X.setRequestParams(r);
        X.setRequestCompleteListener(new _cls11());
        X.doRequest();
    }

    static void k(al al1)
    {
        al1.b.setReposting(true);
        al1.K.setEnabled(false);
        _cls6 _lcls6 = new _cls6(al1);
        _cls7 _lcls7 = new _cls7(al1);
        com.socialin.android.picsart.profile.util.x.b(al1.getActivity(), al1.b, _lcls6, _lcls7, al1.e);
        if (SocialinV3.getInstance().isRegistered())
        {
            if (!al1.b.isReposted)
            {
                al1.l();
            } else
            {
                al1.m();
            }
            if (!al1.b.isReposting())
            {
                al1.K.setOnClickListener(al1.c);
            } else
            {
                al1.K.setOnClickListener(null);
            }
            al1.b();
            return;
        } else
        {
            al1.e();
            return;
        }
    }

    static View l(al al1)
    {
        return al1.J;
    }

    private void l()
    {
        ImageItem imageitem = b;
        imageitem.repostsCount = imageitem.repostsCount + 1;
        b.isReposted = true;
        e();
        y.setText(Utils.a(b.repostsCount));
    }

    static TextView m(al al1)
    {
        return al1.H;
    }

    private void m()
    {
        ImageItem imageitem = b;
        imageitem.repostsCount = imageitem.repostsCount - 1;
        b.isReposted = false;
        e();
        y.setText(Utils.a(b.repostsCount));
    }

    static ImageItem n(al al1)
    {
        return al1.b;
    }

    static ImageView o(al al1)
    {
        return al1.u;
    }

    static ArrayList p(al al1)
    {
        return al1.j;
    }

    static int q(al al1)
    {
        return al1.k;
    }

    static com.socialin.android.adapter.b r(al al1)
    {
        return al1.S;
    }

    static ay s(al al1)
    {
        return al1.Q;
    }

    static String t(al al1)
    {
        return al1.e;
    }

    static ay u(al al1)
    {
        return al1.R;
    }

    static ar v(al al1)
    {
        return al1.P;
    }

    static SharedPreferences w(al al1)
    {
        return al1.i;
    }

    static j x(al al1)
    {
        return al1.O;
    }

    static RadioButton y(al al1)
    {
        return al1.w;
    }

    static CommentListView z(al al1)
    {
        return al1.A;
    }

    final void a()
    {
        if (b != null)
        {
            F.setChecked(b.isLiked);
            int i1;
            if (b.isLiked)
            {
                i1 = s.getResources().getColor(0x7f0f0081);
            } else
            {
                i1 = -1;
            }
            d.setBackgroundColor(i1);
        }
    }

    public final void a(Comment comment)
    {
        ImageItem imageitem = b;
        imageitem.commentsCount = imageitem.commentsCount - 1;
        int j1 = b.comments.size();
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < j1)
                {
                    if (!comment.id.equals(((Comment)b.comments.get(i1)).id))
                    {
                        break label0;
                    }
                    b.comments.remove(i1);
                }
                w.setText(Utils.a(b.commentsCount));
                b();
                return;
            }
            i1++;
        } while (true);
    }

    public final void a(String s1, boolean flag)
    {
        if (!SocialinV3.getInstance().isRegistered())
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("comment_screen", "comment"));
        }
        if (!com.socialin.android.util.s.a(s))
        {
            GalleryUtils.a(s);
        } else
        if (com.socialin.android.picsart.profile.util.y.a(getActivity(), e))
        {
            if (s1 == null || s1.trim().equals(""))
            {
                Utils.c(s, getString(0x7f08022c));
                return;
            }
            if (flag)
            {
                D.setText("");
            }
            View view = s.findViewById(0x7f100788);
            View view1 = s.findViewById(0x7f100787);
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(s);
            long l2 = b.id;
            String s2 = e;
            Object obj;
            long l1;
            if (b.user != null)
            {
                l1 = b.user.id;
            } else
            {
                l1 = -1L;
            }
            flag = b.isMature;
            if (b.tags == null)
            {
                obj = new JSONArray();
            } else
            {
                obj = new JSONArray(Arrays.asList(b.tags));
            }
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.PhotoCommentEvent(l2, s2, l1, flag, ((JSONArray) (obj))));
            view.setVisibility(0);
            view1.setVisibility(4);
            T.setRequestCompleteListener(new _cls3(view, view1));
            obj = q;
            if (b.origin != null)
            {
                l1 = b.origin.id;
            } else
            {
                l1 = b.id;
            }
            obj.itemId = l1;
            q.text = s1;
            T.setRequestParams(q);
            com.socialin.asyncnet.b.a().a(T.getRequestId());
            T.doRequest("addComment", q);
            b.detalisLoaded = false;
            return;
        }
    }

    final void b()
    {
        if (s.getIntent() != null && s.getIntent().hasExtra("currentItem"))
        {
            s.getIntent().putExtra("dataChanged", true);
            s.getIntent().removeExtra("currentItem");
            s.getIntent().putExtra("currentItem", b);
        }
    }

    final void c()
    {
        ImageItem imageitem = b;
        imageitem.likesCount = imageitem.likesCount + 1;
        b.isLiked = true;
        a();
        x.setText(Utils.a(b.likesCount));
    }

    final void d()
    {
        ImageItem imageitem = b;
        imageitem.likesCount = imageitem.likesCount - 1;
        b.isLiked = false;
        a();
        x.setText(Utils.a(b.likesCount));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!getActivity().getIntent().getBooleanExtra("keyboardHide", false) && !D.hasFocus())
        {
            D.requestFocus();
            ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(D, 2);
        }
        bundle = android.os.Build.VERSION.RELEASE;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Build.VERSION.RELEASE= ")).append(bundle).toString()
        });
        if (!"4.4.2".equals(bundle))
        {
            S = new com.socialin.android.adapter.b(s, 0x7f03002f, j());
            bundle = new char[2];
            Bundle _tmp = bundle;
            bundle[0] = '#';
            bundle[1] = '@';
            S.a = bundle;
            S.setNotifyOnChange(true);
            S.addAll(i());
            g.isFollowing = "1";
            f.setRequestParams(g);
            f.setRequestCompleteListener(new _cls17());
            D.setOnItemClickListener(new _cls14());
            D.setAdapter(S);
            D.addTextChangedListener(new _cls15(bundle));
        }
        if (b != null && s != null)
        {
            if (b.comments != null && O == null)
            {
                p = am.a(b.comments);
                bundle = p;
                Object obj = A;
                ViewerUser vieweruser = b.user;
                long l2 = b.id;
                long l1;
                if (b.user != null)
                {
                    l1 = b.user.id;
                } else
                {
                    l1 = -1L;
                }
                O = new j(this, bundle, ((android.widget.ListView) (obj)), vieweruser, Long.valueOf(l2), Long.valueOf(l1), b.isMature, b.tags, e);
            }
            if (b.likes != null && (Q == null || Q.getCount() <= 0))
            {
                Q = new ay(s, s.getLayoutInflater(), 0x7f030229);
                Q.a(new int[][] {
                    new int[] {
                        0, 1
                    }
                });
                Q.a = 0;
                Q.b = 600F;
                Q.a(new _cls18());
                Q.a(b.likes);
            }
            if (b.reposts != null)
            {
                if (R == null || R.getCount() <= 0)
                {
                    R = new ay(s, s.getLayoutInflater(), 0x7f030229);
                    R.a(new int[][] {
                        new int[] {
                            0, 1
                        }
                    });
                    R.a = 0;
                    R.b = 600F;
                    R.a(new _cls19());
                    R.a(b.reposts);
                }
            } else
            {
                R = new ay(s, s.getLayoutInflater(), 0x7f030229);
            }
            if (b.streams != null)
            {
                if (P == null || P.getItemCount() <= 0)
                {
                    bundle = new as(40, false, false);
                    P = new ar(s, bundle, new _cls2());
                } else
                {
                    P.clear();
                }
                for (bundle = b.streams.iterator(); bundle.hasNext(); P.add(obj))
                {
                    obj = (Stream)bundle.next();
                }

            }
            if (l == 0x7f10093e)
            {
                A.setAdapter(O);
            } else
            if (l == 0x7f10093d)
            {
                A.setAdapter(Q);
            } else
            if (l == 0x7f100940)
            {
                B.setAdapter(P);
            } else
            if (l == 0x7f10093f)
            {
                A.setAdapter(R);
            }
            if (!getActivity().getIntent().hasExtra("selectedTab") && O.getCount() == 0)
            {
                if (Q.getCount() > 0)
                {
                    l = 0x7f10093d;
                } else
                if (R.getCount() > 0)
                {
                    l = 0x7f10093f;
                } else
                if (P.getItemCount() > 0)
                {
                    l = 0x7f100940;
                }
                v.check(l);
            }
        }
        v.setOnCheckedChangeListener(h);
        E.setOnClickListener(c);
        u.setOnClickListener(c);
        d.setOnClickListener(c);
        J.setOnClickListener(c);
        N.setOnClickListener(c);
        if (b != null && !b.isReposting())
        {
            K.setOnClickListener(c);
        } else
        {
            K.setOnClickListener(null);
        }
        F.setOnClickListener(c);
        G.setOnClickListener(c);
        H.setOnClickListener(c);
        f();
        a(true);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (intent == null) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 3: default 48
    //                   4: 94
    //                   1236: 49
    //                   4543: 139;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L4:
        if (intent.hasExtra("path"))
        {
            a((new StringBuilder("[img]")).append(intent.getStringExtra("path")).append("[/img]").toString(), false);
            return;
        }
_L3:
        if (!intent.hasExtra("clipartIconUrl")) goto _L2; else goto _L6
_L6:
        a((new StringBuilder("[img]")).append(intent.getStringExtra("clipartIconUrl")).append("[/img]").toString(), false);
        return;
_L5:
        k();
        intent = b;
        intent.streamsCount = ((ImageItem) (intent)).streamsCount + 1;
        z.setText(Utils.a(b.streamsCount));
        return;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        s = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        i = s.getSharedPreferences((new StringBuilder("sinPref_")).append(getString(myobfuscated.f.m.e(s, "app_name_short"))).toString(), 0);
        bundle = getActivity().getIntent();
        if (!bundle.hasExtra("currentItem")) goto _L2; else goto _L1
_L1:
        b = (ImageItem)bundle.getParcelableExtra("currentItem");
        if (b != null) goto _L4; else goto _L3
_L3:
        Utils.a(s, 0x7f0805ca);
        s.finish();
_L6:
        return;
_L4:
        b.comments = new ArrayList();
        b.likes = new ArrayList();
        b.reposts = new ArrayList();
        b.streams = new ArrayList();
_L2:
        if (!bundle.hasExtra("selectedTab")) goto _L6; else goto _L5
_L5:
        byte byte0;
        bundle = bundle.getStringExtra("selectedTab");
        byte0 = -1;
        bundle.hashCode();
        JVM INSTR lookupswitch 4: default 232
    //                   -259066197: 318
    //                   -212346469: 273
    //                   -92651147: 288
    //                   2077018361: 303;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_318;
_L12:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            l = 0x7f10093e;
            return;

        case 1: // '\001'
            l = 0x7f10093d;
            return;

        case 2: // '\002'
            l = 0x7f10093f;
            return;

        case 3: // '\003'
            l = 0x7f100940;
            break;
        }
        break MISSING_BLOCK_LABEL_356;
_L9:
        if (bundle.equals("item.details.comments"))
        {
            byte0 = 0;
        }
          goto _L12
_L10:
        if (bundle.equals("item.details.likes"))
        {
            byte0 = 1;
        }
          goto _L12
_L11:
        if (bundle.equals("item.details.reposts"))
        {
            byte0 = 2;
        }
          goto _L12
        if (bundle.equals("item.details.memboxes"))
        {
            byte0 = 3;
        }
          goto _L12
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030207, viewgroup, false);
        I = s.findViewById(0x7f100786);
        I.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0x80000000), 0);
        D = (AutoCompleteTextView)I.findViewById(0x7f10078a);
        E = (Button)I.findViewById(0x7f100787);
        u = (ImageView)I.findViewById(0x7f10078b);
        N = layoutinflater.findViewById(0x7f10094f);
        d = s.findViewById(0x7f10078d);
        J = s.findViewById(0x7f100791);
        K = s.findViewById(0x7f10078f);
        F = (ToggleButton)s.findViewById(0x7f10078e);
        G = (ToggleButton)s.findViewById(0x7f100790);
        H = (TextView)s.findViewById(0x7f100792);
        v = (RadioGroup)layoutinflater.findViewById(0x7f10093c);
        x = (RadioButton)layoutinflater.findViewById(0x7f10093d);
        w = (RadioButton)layoutinflater.findViewById(0x7f10093e);
        y = (RadioButton)layoutinflater.findViewById(0x7f10093f);
        z = (RadioButton)layoutinflater.findViewById(0x7f100940);
        A = (CommentListView)layoutinflater.findViewById(0x7f100950);
        A.setSliderActionListener((SliderActivity)s);
        A.setOnItemLongClickListener(t);
        B = (RecyclerView)layoutinflater.findViewById(0x7f100951);
        viewgroup = new LinearLayoutManager(s, 1, false);
        B.setLayoutManager(viewgroup);
        B.addItemDecoration(new an(s));
        C = layoutinflater.findViewById(0x7f100953);
        j.add(new myobfuscated.ct.b(getString(0x7f08031f), 0x7f020382, 1));
        j.add(new myobfuscated.ct.b(getString(0x7f0802a1), 0x7f020437, 5));
        L = N.findViewById(0x7f100188);
        M = N.findViewById(0x7f10074b);
        return layoutinflater;
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls16 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls17 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls15 {}


    /* member class not found */
    class _cls18 {}


    /* member class not found */
    class _cls19 {}


    /* member class not found */
    class _cls2 {}

}
