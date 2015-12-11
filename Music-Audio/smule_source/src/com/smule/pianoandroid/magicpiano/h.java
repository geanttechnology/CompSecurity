// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.e;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.utils.SwipeView;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.w;
import com.smule.pianoandroid.utils.y;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            DailyChallengeActivity, n, ac

class h extends AsyncTask
{

    final DailyChallengeActivity a;

    private h(DailyChallengeActivity dailychallengeactivity)
    {
        a = dailychallengeactivity;
        super();
        aa.a(com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(), "++ Locking");
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorenter ;
_L2:
        synchronized (DailyChallengeActivity.a(dailychallengeactivity))
        {
            if (com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(dailychallengeactivity) > 0)
            {
                DailyChallengeActivity.a(dailychallengeactivity).wait();
            }
            DailyChallengeActivity.c(dailychallengeactivity);
        }
        aa.a(com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(), "++ Locked");
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L3
_L3:
        dailychallengeactivity;
        obj;
        JVM INSTR monitorexit ;
        throw dailychallengeactivity;
    }

    h(DailyChallengeActivity dailychallengeactivity, DailyChallengeActivity._cls1 _pcls1)
    {
        this(dailychallengeactivity);
    }

    private void b(List list)
    {
        LinearLayout linearlayout = (LinearLayout)DailyChallengeActivity.d(a).findViewById(0x7f0a0128);
        linearlayout.removeAllViews();
        for (int i = 0; i < list.size() - 1; i++)
        {
            ImageView imageview = new ImageView(a.getBaseContext());
            imageview.setImageDrawable(a.getResources().getDrawable(0x7f0200ce));
            linearlayout.addView(imageview);
            ((android.widget.LinearLayout.LayoutParams)imageview.getLayoutParams()).setMargins(0, 0, a.getResources().getDimensionPixelSize(0x7f09008b), 0);
            imageview.requestLayout();
            com.smule.pianoandroid.magicpiano.DailyChallengeActivity.e(a).add(imageview);
        }

        list = new ImageView(a.getBaseContext());
        list.setImageDrawable(a.getResources().getDrawable(0x7f0200ce));
        linearlayout.addView(list);
        com.smule.pianoandroid.magicpiano.DailyChallengeActivity.e(a).add(list);
    }

    protected transient List a(Void avoid[])
    {
        avoid = e.a().e();
        DailyChallengeActivity.a(a, new ArrayList(avoid.size()));
        com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(a, new ArrayList(avoid.size()));
        return avoid;
    }

    protected void a(List list)
    {
        b(list);
        Object obj = (SwipeView)DailyChallengeActivity.d(a).findViewById(0x7f0a0127);
        ((SwipeView) (obj)).a(new w() {

            final h a;

            public View a(SwipeView swipeview, com.smule.android.network.models.ContestData.ContestInfo contestinfo)
            {
                swipeview = View.inflate(swipeview.getContext(), 0x7f030027, null);
                swipeview.setTag(contestinfo.contest.id);
                DailyChallengeActivity.f(a.a).add(swipeview.findViewById(0x7f0a00a9));
                SongV2 songv2 = ak.a().a(contestinfo.contest.songId);
                View view;
                TextView textview;
                TextView textview1;
                Object obj1;
                TextView textview2;
                Object obj2;
                if (songv2 != null)
                {
                    ((TextView)swipeview.findViewById(0x7f0a0037)).setText(songv2.title);
                    ((TextView)swipeview.findViewById(0x7f0a00a2)).setText(songv2.artist);
                } else
                {
                    ((TextView)swipeview.findViewById(0x7f0a0037)).setText("");
                }
                obj2 = DateFormat.format("EEEE", contestinfo.contest.end.longValue() * 1000L).toString();
                view = swipeview.findViewById(0x7f0a00a3);
                textview = (TextView)swipeview.findViewById(0x7f0a00a6);
                obj1 = e.a().a(contestinfo);
                textview1 = (TextView)swipeview.findViewById(0x7f0a00a8);
                textview2 = (TextView)swipeview.findViewById(0x7f0a00a7);
                textview2.setTextColor(a.a.getResources().getColor(0x7f080040));
                if (!contestinfo.isEnded())
                {
                    ((TextView)swipeview.findViewById(0x7f0a00a0)).setText(MessageFormat.format(a.a.getString(0x7f0c02e4), new Object[] {
                        a.a.getString(0x7f0c028f)
                    }));
                    if (((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).started.booleanValue() && ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).score != null && ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).submitState == com.smule.android.network.models.ContestData.SubmitState.NOT_SUBMITTED)
                    {
                        textview.setText(0x7f0c0279);
                        view.setBackgroundResource(0x7f02006b);
                        view.setOnClickListener(new android.view.View.OnClickListener(this, contestinfo, view) {

                            final com.smule.android.network.models.ContestData.ContestInfo a;
                            final View b;
                            final _cls1 c;

                            public void onClick(View view)
                            {
                                if (!a.isEnded())
                                {
                                    view = new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            com.smule.android.network.core.b.a(new Runnable(this) {

                                                final _cls1 a;

                                                public void run()
                                                {
                                                    e.a().c(a.a.a);
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    };
                                    o.a(c.a.a, view, null, c.a.a.getString(0x7f0c0048), c.a.a.getString(0x7f0c0047));
                                    b.setOnClickListener(null);
                                    return;
                                } else
                                {
                                    Toast.makeText(c.a.a.getApplicationContext(), c.a.a.getString(0x7f0c027b), 1).show();
                                    return;
                                }
                            }

            
            {
                c = _pcls1;
                a = contestinfo;
                b = view;
                super();
            }
                        });
                        textview1.setText(0x7f0c00c1);
                        textview2.setText(0x7f0c00c5);
                        return swipeview;
                    }
                    obj2 = ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).submitState;
                    com.smule.android.network.models.ContestData.SubmitState submitstate = ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).submitState;
                    if (obj2 != com.smule.android.network.models.ContestData.SubmitState.NOT_SUBMITTED || ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).started.booleanValue() && ((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).score == null)
                    {
                        textview.setText(0x7f0c026b);
                        if (Locale.getDefault().getLanguage().compareToIgnoreCase("pt") == 0)
                        {
                            textview.setTextSize(0, a.a.getResources().getDimensionPixelSize(0x7f090134));
                        }
                        swipeview.findViewById(0x7f0a00a5).setVisibility(0);
                        view.setBackgroundResource(0x7f020075);
                        view.setOnClickListener(new android.view.View.OnClickListener(this, songv2) {

                            final SongV2 a;
                            final _cls1 b;

                            public void onClick(View view)
                            {
                                if (a != null)
                                {
                                    DailyChallengeActivity.a(b.a.a, a.songId);
                                }
                            }

            
            {
                b = _pcls1;
                a = songv2;
                super();
            }
                        });
                        textview2.setText(0x7f0c00c3);
                        textview1.setText(MessageFormat.format(a.a.getString(0x7f0c00c2), new Object[] {
                            Integer.valueOf(e.j())
                        }));
                        return swipeview;
                    }
                    swipeview.findViewById(0x7f0a00a1).setVisibility(0);
                    textview2.setTextColor(a.a.getResources().getColor(0x7f080032));
                    textview2.setText(0x7f0c00e0);
                    obj1 = a.a.getString(0x7f0c0133);
                    ((TextView)swipeview.findViewById(0x7f0a00a4)).setText(MessageFormat.format(((String) (obj1)), new Object[] {
                        Integer.valueOf(e.j())
                    }));
                    textview.setText(0x7f0c01e0);
                    view.setBackgroundResource(0x7f02005f);
                    if (songv2 != null)
                    {
                        view.setOnClickListener(new android.view.View.OnClickListener(this, songv2) {

                            final SongV2 a;
                            final _cls1 b;

                            public void onClick(View view)
                            {
                                q.g(a.songId);
                                view = new Runnable(this) {

                                    final _cls3 a;

                                    public void run()
                                    {
                                        if (a.a != null)
                                        {
                                            q.h(a.a.songId);
                                            ac.a().a("NOTIFICATION_CHALLENGE", 0);
                                            DailyChallengeActivity.a(a.b.a.a, a.a);
                                        }
                                    }

            
            {
                a = _pcls3;
                super();
            }
                                };
                                view = n.a(b.a.a, 0x7f020123, b.a.a.getString(0x7f0c00bc), null, b.a.a.getString(0x7f0c00c6), b.a.a.getString(0x7f0c0154), b.a.a.getString(0x7f0c01e4), null, view);
                                view.setCancelable(true);
                                view.setCanceledOnTouchOutside(true);
                                view.show();
                            }

            
            {
                b = _pcls1;
                a = songv2;
                super();
            }
                        });
                    }
                    textview1.setText(String.format(a.a.getString(0x7f0c00c0), new Object[] {
                        contestinfo.contest.numWinners
                    }));
                    return swipeview;
                }
                ((TextView)swipeview.findViewById(0x7f0a00a0)).setText(MessageFormat.format(a.a.getString(0x7f0c02e4), new Object[] {
                    (new StringBuilder()).append(((String) (obj2)).substring(0, 1).toUpperCase()).append(((String) (obj2)).substring(1)).toString()
                }));
                textview.setText(0x7f0c026b);
                if (Locale.getDefault().getLanguage().compareToIgnoreCase("pt") == 0)
                {
                    textview.setTextSize(0, a.a.getResources().getDimensionPixelSize(0x7f090134));
                }
                view.setBackgroundResource(0x7f020075);
                swipeview.findViewById(0x7f0a00a5).setVisibility(0);
                view.setOnClickListener(new android.view.View.OnClickListener(this, songv2) {

                    final SongV2 a;
                    final _cls1 b;

                    public void onClick(View view)
                    {
                        if (a != null)
                        {
                            DailyChallengeActivity.a(b.a.a, a.songId);
                        }
                    }

            
            {
                b = _pcls1;
                a = songv2;
                super();
            }
                });
                if (e.a().d(contestinfo))
                {
                    textview1.setText(0x7f0c00bf);
                    return swipeview;
                }
                if (((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).started.booleanValue())
                {
                    textview2.setText(MessageFormat.format(a.a.getString(0x7f0c00c4), new Object[] {
                        contestinfo.contest.numWinners
                    }));
                    textview1.setText(a.a.getString(0x7f0c00be));
                    return swipeview;
                } else
                {
                    textview2.setText(0x7f0c00c3);
                    textview1.setText(0x7f0c00bd);
                    return swipeview;
                }
            }

            public volatile View a(SwipeView swipeview, Object obj1)
            {
                return a(swipeview, (com.smule.android.network.models.ContestData.ContestInfo)obj1);
            }

            
            {
                a = h.this;
                super();
            }
        }, list);
        ((SwipeView) (obj)).setSwipeListener(new y(list) {

            final List a;
            final h b;

            public void a(SwipeView swipeview, Integer integer, Integer integer1)
            {
                aa.a(com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(), (new StringBuilder()).append("swipeTo ").append(integer).append(" ").append(integer1).toString());
                if (integer.equals(integer1))
                {
                    if (DailyChallengeActivity.d(b.a).findViewById(0x7f0a0129).getVisibility() != 4);
                    return;
                } else
                {
                    DailyChallengeActivity.a(b.a, a, integer.intValue());
                    return;
                }
            }

            public void b(SwipeView swipeview, Integer integer, Integer integer1)
            {
                AnimationUtils.loadAnimation(b.a.getApplicationContext(), 0x7f040011).setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                    final _cls2 a;

                    public void onAnimationEnd(Animation animation)
                    {
                        DailyChallengeActivity.d(a.b.a).findViewById(0x7f0a0129).setVisibility(4);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                b = h.this;
                a = list;
                super();
            }
        });
        obj = e.a().g();
        if (obj != null)
        {
            Iterator iterator = ((com.smule.android.network.models.ContestData.ContestInfo) (obj)).contest.rewards.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((com.smule.android.network.models.ContestData.Reward)iterator.next()).type.equals("SONG"))
                {
                    o.a(a, ((com.smule.android.network.models.ContestData.ContestInfo) (obj)));
                }
            } while (true);
        }
        if (list != null && list.size() > 0)
        {
            com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(a, list, list.size() - 1);
        }
        aa.a(com.smule.pianoandroid.magicpiano.DailyChallengeActivity.b(), "++ UnLocking");
        synchronized (DailyChallengeActivity.a(a))
        {
            DailyChallengeActivity.g(a);
            DailyChallengeActivity.a(a).notify();
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}
