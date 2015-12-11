// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import b.a.a.d.d;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.content.af;
import com.wishabi.flipp.content.ah;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.ActionButton;
import com.wishabi.flipp.widget.ItemDetailImageView;
import com.wishabi.flipp.widget.RatingView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.app:
//            dl, cz, da, db, 
//            dc, de, dd, cy

public class cx extends dl
    implements android.app.LoaderManager.LoaderCallbacks
{

    de a;
    private long c;
    private ArrayList d;
    private float e;
    private af f;
    private int g;
    private LayoutInflater h;
    private ItemDetailImageView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private Button o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ActionButton s;
    private ActionButton t;
    private ActionButton u;
    private ViewGroup v;
    private ScrollView w;
    private View x;
    private MenuItem y;

    public cx()
    {
        e = 1.0F;
    }

    public static Bundle a(long l1, float f1)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("SAVE_STATE_ITEM_ID_KEY", l1);
        bundle.putFloat("SAVE_STATE_ITEM_RATIO_KEY", f1);
        return bundle;
    }

    private static Spanned a(af af1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        String s1 = af1.k;
        if (s1 != null && !s1.isEmpty())
        {
            spannablestringbuilder.append(Html.fromHtml((new StringBuilder("<small>")).append(s1).append("</small>").toString()));
            spannablestringbuilder.append(" ");
        }
        s1 = af1.j;
        if (s1 != null && !s1.isEmpty())
        {
            spannablestringbuilder.append(com.wishabi.flipp.util.q.a(s1, true));
        }
        af1 = af1.l;
        if (af1 != null && !af1.isEmpty())
        {
            if (spannablestringbuilder.length() > 0)
            {
                spannablestringbuilder.append(" ");
            }
            spannablestringbuilder.append(Html.fromHtml((new StringBuilder("<small>")).append(af1).append("</small>").toString()));
        }
        return spannablestringbuilder;
    }

    static View a(cx cx1)
    {
        return cx1.x;
    }

    public static cx a(Bundle bundle)
    {
        cx cx1 = new cx();
        cx1.setArguments(bundle);
        return cx1;
    }

    static void a(cx cx1, af af1)
    {
        float f1 = 0.0F;
        if (af1 == null || cx1.getActivity() == null)
        {
            cx1.f = null;
        } else
        {
            cx1.w.setVisibility(0);
            cx1.w.setAlpha(0.0F);
            cx1.w.animate().alpha(1.0F).setDuration(cx1.g);
            cx1.x.animate().alpha(0.0F).setDuration(cx1.g).setListener(new cz(cx1));
            cx1.f = af1;
            cx1.i.setRatio(cx1.e);
            cx1.i.setImageUrl(af1.g);
            Object obj = af1.f;
            Object obj1;
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                cx1.j.setText(((CharSequence) (obj)));
            } else
            {
                cx1.j.setVisibility(8);
            }
            if (cx1.y != null)
            {
                cx1.y.setVisible(true);
            }
            obj = a(cx1.f);
            if (cx1.f.y && ((Spanned) (obj)).length() > 0)
            {
                cx1.k.setText(a(cx1.f));
            } else
            {
                cx1.k.setVisibility(8);
            }
            obj = cx1.getResources();
            if (af1.p != null && af1.q != null)
            {
                b.a.a.b b1 = af.a.a(af1.q);
                obj = ((Resources) (obj)).getString(0x7f0e00d6, new Object[] {
                    af.b.a(b1)
                });
            } else
            if (af1.p != null)
            {
                obj1 = af.a.a(af1.p);
                obj = ((Resources) (obj)).getString(0x7f0e00d8, new Object[] {
                    af.b.a(((b.a.a.z) (obj1)))
                });
            } else
            if (af1.q != null)
            {
                obj1 = af.a.a(af1.q);
                obj = ((Resources) (obj)).getString(0x7f0e00d5, new Object[] {
                    af.b.a(((b.a.a.z) (obj1)))
                });
            } else
            {
                obj = null;
            }
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                cx1.l.setText(((CharSequence) (obj)));
            } else
            {
                cx1.l.setVisibility(8);
            }
            obj = cx1.getResources();
            if (af1.p != null && af1.q != null)
            {
                b.a.a.b b2 = af.a.a(af1.p);
                obj = ((Resources) (obj)).getString(0x7f0e00d7, new Object[] {
                    af.b.a(b2)
                });
            } else
            {
                obj = null;
            }
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                cx1.m.setText(((CharSequence) (obj)));
            } else
            {
                cx1.m.setVisibility(8);
            }
            obj = cx1.f.n;
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(cx1.getResources().getString(0x7f0e015b));
                spannablestringbuilder.append(" ");
                spannablestringbuilder.append(com.wishabi.flipp.util.q.a(((String) (obj)), true));
                cx1.n.setText(spannablestringbuilder);
            } else
            {
                cx1.n.setVisibility(8);
            }
            obj = af1.m;
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                SpannableStringBuilder spannablestringbuilder1 = new SpannableStringBuilder(((CharSequence) (obj)));
                if (af1.o)
                {
                    spannablestringbuilder1.append(" ");
                    spannablestringbuilder1.append(cx1.getResources().getString(0x7f0e00cd));
                    spannablestringbuilder1.setSpan(new ForegroundColorSpan(Color.rgb(255, 128, 0)), ((String) (obj)).length(), spannablestringbuilder1.length(), 33);
                }
                cx1.r.setTextColor(0xffff0000);
                cx1.r.setText(spannablestringbuilder1);
            } else
            if (cx1.f.y && af1.o)
            {
                cx1.r.setText(0x7f0e00cd);
                cx1.r.setTextColor(-32768);
            } else
            {
                cx1.r.setVisibility(8);
            }
            obj = af1.i;
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                cx1.p.setText(((CharSequence) (obj)));
            } else
            {
                cx1.p.setVisibility(8);
            }
            obj = af1.r;
            if (cx1.f.y && obj != null && !((String) (obj)).isEmpty())
            {
                cx1.q.setText(cx1.getResources().getString(0x7f0e00d4, new Object[] {
                    obj
                }));
            } else
            {
                cx1.q.setVisibility(8);
            }
            cx1.u.setOnClickListener(new da(cx1, af1));
            if (af1.t != null && af1.s != null)
            {
                cx1.u.setLabel(af1.t);
            } else
            {
                cx1.u.setVisibility(8);
            }
            cx1.s.setOnClickListener(new db(cx1));
            if (cx1.t != null)
            {
                cx1.t.setOnClickListener(new dc(cx1));
            }
            obj = af1.v;
            obj1 = cx1.getView();
            if (cx1.f.y && obj != null && !((List) (obj)).isEmpty() && obj1 != null && ((View) (obj1)).findViewById(0x7f0b00f0) == null)
            {
                Object obj2 = cx1.h.inflate(0x7f030039, cx1.v);
                if (obj2 != null)
                {
                    RatingView ratingview = (RatingView)((View) (obj2)).findViewById(0x7f0b00ef);
                    if (af1.u != null)
                    {
                        f1 = Float.parseFloat(af1.u);
                    }
                    ratingview.setRating((int)(f1 * 2.0F));
                    ((TextView)((View) (obj2)).findViewById(0x7f0b00ee)).setText(cx1.getResources().getString(0x7f0e0116, new Object[] {
                        Integer.valueOf(((List) (obj)).size())
                    }));
                    obj2 = (ViewGroup)((View) (obj2)).findViewById(0x7f0b00f0);
                    for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext();)
                    {
                        ah ah1 = (ah)iterator.next();
                        View view1 = cx1.h.inflate(0x7f030038, null);
                        if (view1 != null)
                        {
                            ((TextView)view1.findViewById(0x7f0b00ea)).setText(ah1.a);
                            ((TextView)view1.findViewById(0x7f0b00ec)).setText(ah1.e);
                            TextView textview1 = (TextView)view1.findViewById(0x7f0b00ed);
                            String s2 = ah1.c;
                            if (ah1.d == null)
                            {
                                obj = null;
                            } else
                            {
                                obj = af.c().a(af.b().a(ah1.d));
                            }
                            if (s2 != null && obj != null)
                            {
                                textview1.setText((new StringBuilder()).append(s2).append(" - ").append(((String) (obj))).toString());
                            } else
                            if (s2 != null)
                            {
                                textview1.setText(s2);
                            } else
                            if (obj != null)
                            {
                                textview1.setText(((CharSequence) (obj)));
                            }
                            ((RatingView)view1.findViewById(0x7f0b00eb)).setRating((int)(Float.parseFloat(ah1.b) * 2.0F));
                            ((ViewGroup) (obj2)).addView(view1);
                        }
                    }

                }
            }
            Object obj3 = af1.x;
            if (cx1.f.y && obj3 != null && !((List) (obj3)).isEmpty() && obj1 != null && ((View) (obj1)).findViewById(0x7f0b00dd) == null)
            {
                obj = cx1.h.inflate(0x7f030036, cx1.v);
                if (obj != null)
                {
                    obj = (ViewGroup)((View) (obj)).findViewById(0x7f0b00dd);
                    obj3 = ((List) (obj3)).iterator();
                    do
                    {
                        if (!((Iterator) (obj3)).hasNext())
                        {
                            break;
                        }
                        String s1 = (String)((Iterator) (obj3)).next();
                        TextView textview = (TextView)cx1.h.inflate(0x7f030035, null);
                        if (textview != null)
                        {
                            textview.setText(s1);
                            ((ViewGroup) (obj)).addView(textview);
                        }
                    } while (true);
                }
            }
            obj = af1.w;
            if (cx1.f.y && obj != null && !((List) (obj)).isEmpty() && obj1 != null && ((View) (obj1)).findViewById(0x7f0b00f3) == null)
            {
                af1 = cx1.h.inflate(0x7f03003b, cx1.v);
                if (af1 != null)
                {
                    af1 = (ViewGroup)af1.findViewById(0x7f0b00f3);
                    obj = ((List) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        Pair pair = (Pair)((Iterator) (obj)).next();
                        View view = cx1.h.inflate(0x7f03003a, null);
                        if (view != null)
                        {
                            ((TextView)view.findViewById(0x7f0b00f1)).setText(((String)pair.first).trim());
                            ((TextView)view.findViewById(0x7f0b00f2)).setText((CharSequence)pair.second);
                            af1.addView(view);
                        }
                    } while (true);
                }
            }
            af1 = cx1.getLoaderManager();
            if (af1 != null)
            {
                af1.initLoader(0, null, cx1);
                af1.initLoader(1, null, cx1);
                return;
            }
        }
    }

    public static cx b(long l1, float f1)
    {
        return a(a(l1, f1));
    }

    static af b(cx cx1)
    {
        return cx1.f;
    }

    static long c(cx cx1)
    {
        return cx1.c;
    }

    static ArrayList d(cx cx1)
    {
        return cx1.d;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = getResources().getInteger(0x10e0000);
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        switch (i1)
        {
        default:
            return null;

        case 0: // '\0'
            return new CursorLoader(bundle, i.g, null, "_id = ?", new String[] {
                Long.toString(c)
            }, null);

        case 1: // '\001'
            return com.wishabi.flipp.content.l.a(bundle, new long[] {
                c
            });
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!a())
        {
            menuinflater.inflate(0x7f100007, menu);
            y = menu.findItem(0x7f0b0158);
            if (y != null)
            {
                y.setVisible(false);
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Activity activity;
        setHasOptionsMenu(true);
        activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        h = layoutinflater;
        layoutinflater = layoutinflater.inflate(0x7f030037, viewgroup, false);
        if (layoutinflater == null) goto _L1; else goto _L3
_L3:
        v = (ViewGroup)layoutinflater.findViewById(0x7f0b00df);
        h.inflate(0x7f030034, v);
        i = (ItemDetailImageView)layoutinflater.findViewById(0x7f0b00e0);
        j = (TextView)layoutinflater.findViewById(0x7f0b00e1);
        k = (TextView)layoutinflater.findViewById(0x7f0b00e2);
        l = (TextView)layoutinflater.findViewById(0x7f0b00e5);
        m = (TextView)layoutinflater.findViewById(0x7f0b00e6);
        n = (TextView)layoutinflater.findViewById(0x7f0b00e3);
        r = (TextView)layoutinflater.findViewById(0x7f0b00e4);
        o = (Button)layoutinflater.findViewById(0x7f0b00e7);
        p = (TextView)layoutinflater.findViewById(0x7f0b00e8);
        q = (TextView)layoutinflater.findViewById(0x7f0b00e9);
        s = (ActionButton)layoutinflater.findViewById(0x7f0b008d);
        t = (ActionButton)layoutinflater.findViewById(0x7f0b00dc);
        u = (ActionButton)layoutinflater.findViewById(0x7f0b00db);
        w = (ScrollView)layoutinflater.findViewById(0x7f0b00de);
        x = layoutinflater.findViewById(0x7f0b0078);
        viewgroup = Typeface.createFromAsset(activity.getAssets(), "ProximaNova-Regular.otf");
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "ProximaNova-Bold.otf");
        j.setTypeface(viewgroup);
        k.setTypeface(typeface);
        n.setTypeface(typeface);
        r.setTypeface(typeface);
        o.setSingleLine();
        o.setVisibility(8);
        if (!a())
        {
            t.setVisibility(8);
        }
        if (bundle == null) goto _L5; else goto _L4
_L4:
        c = bundle.getLong("SAVE_STATE_ITEM_ID_KEY");
        e = bundle.getFloat("SAVE_STATE_ITEM_RATIO_KEY");
_L7:
        b(activity.getString(0x7f0e00d3));
        return layoutinflater;
_L5:
        viewgroup = getArguments();
        if (viewgroup != null)
        {
            c = viewgroup.getLong("SAVE_STATE_ITEM_ID_KEY");
            e = viewgroup.getFloat("SAVE_STATE_ITEM_RATIO_KEY");
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        loader.getId();
        JVM INSTR tableswitch 0 1: default 32
    //                   0 43
    //                   1 74;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalStateException("Invalid loader id requested");
_L2:
        loader = s;
        int i1;
        if (((Cursor) (obj)).getCount() == 0)
        {
            i1 = 0x7f0e002d;
        } else
        {
            i1 = 0x7f0e0157;
        }
        loader.setLabel(i1);
_L5:
        return;
_L3:
        d = (ArrayList)com.wishabi.flipp.content.l.a(((Cursor) (obj))).get(Long.valueOf(c));
        if (d == null || d.isEmpty() || getActivity() == null)
        {
            o.setVisibility(8);
        } else
        {
            loader = new SpannableStringBuilder("  ");
            obj = getResources().getDrawable(0x7f020053);
            if (obj != null)
            {
                int j1 = (int)((double)o.getTextSize() * 1.25D);
                ((Drawable) (obj)).setBounds(0, 0, j1, j1);
                loader.setSpan(new ImageSpan(((Drawable) (obj))), 0, 1, 33);
                loader.append(getResources().getQuantityString(0x7f0d0001, d.size(), new Object[] {
                    Integer.valueOf(d.size())
                }).toUpperCase(Locale.US));
                o.setText(loader, android.widget.TextView.BufferType.SPANNABLE);
                o.setOnClickListener(new dd(this));
                o.setVisibility(0);
            } else
            {
                o.setVisibility(8);
            }
        }
        if (f != null && a != null)
        {
            a.a(f);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        Activity activity;
        activity = getActivity();
        if (activity == null || f == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (menuitem.getItemId() != 0x7f0b0158) goto _L2; else goto _L1
_L1:
        menuitem = activity.getContentResolver().query(i.a, null, "_id = ?", new String[] {
            String.valueOf(f.c)
        }, null);
        if (menuitem == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (menuitem.moveToNext())
        {
            a.a.a(new com.wishabi.flipp.content.Flyer.Model(menuitem), c, o.f);
        }
        if (menuitem != null)
        {
            menuitem.close();
        }
        menuitem = new Intent("android.intent.action.SEND");
        menuitem.putExtra("android.intent.extra.TEXT", getResources().getString(0x7f0e012a, new Object[] {
            f.d, f.a()
        }));
        menuitem.setType("text/plain");
        activity.startActivity(Intent.createChooser(menuitem, null));
        return true;
        Exception exception;
        exception;
        menuitem = null;
_L4:
        if (menuitem != null)
        {
            menuitem.close();
        }
        throw exception;
_L2:
        return super.onOptionsItemSelected(menuitem);
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        super.onResume();
        Activity activity = getActivity();
        if (activity != null)
        {
            String s1 = com.wishabi.flipp.util.k.a(null);
            if (s1 != null)
            {
                (new cy(this, c, s1, activity)).execute(new Void[0]);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("SAVE_STATE_ITEM_ID_KEY", c);
        bundle.putFloat("SAVE_STATE_ITEM_RATIO_KEY", e);
    }
}
