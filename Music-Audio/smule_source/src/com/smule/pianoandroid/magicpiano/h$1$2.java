// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.e;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.utils.SwipeView;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.w;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            h, DailyChallengeActivity, n, ac

class a
    implements android.view.nClickListener
{

    final SongV2 a;
    final songId b;

    public void onClick(View view)
    {
        if (a != null)
        {
            DailyChallengeActivity.a(b.b.a, a.songId);
        }
    }

    a(a a1, SongV2 songv2)
    {
        b = a1;
        a = songv2;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1

/* anonymous class */
    class h._cls1
        implements w
    {

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
            Object obj;
            TextView textview2;
            Object obj1;
            if (songv2 != null)
            {
                ((TextView)swipeview.findViewById(0x7f0a0037)).setText(songv2.title);
                ((TextView)swipeview.findViewById(0x7f0a00a2)).setText(songv2.artist);
            } else
            {
                ((TextView)swipeview.findViewById(0x7f0a0037)).setText("");
            }
            obj1 = DateFormat.format("EEEE", contestinfo.contest.end.longValue() * 1000L).toString();
            view = swipeview.findViewById(0x7f0a00a3);
            textview = (TextView)swipeview.findViewById(0x7f0a00a6);
            obj = e.a().a(contestinfo);
            textview1 = (TextView)swipeview.findViewById(0x7f0a00a8);
            textview2 = (TextView)swipeview.findViewById(0x7f0a00a7);
            textview2.setTextColor(a.a.getResources().getColor(0x7f080040));
            if (!contestinfo.isEnded())
            {
                ((TextView)swipeview.findViewById(0x7f0a00a0)).setText(MessageFormat.format(a.a.getString(0x7f0c02e4), new Object[] {
                    a.a.getString(0x7f0c028f)
                }));
                if (((com.smule.android.network.models.ContestData.ContestUserState) (obj)).started.booleanValue() && ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).score != null && ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).submitState == com.smule.android.network.models.ContestData.SubmitState.NOT_SUBMITTED)
                {
                    textview.setText(0x7f0c0279);
                    view.setBackgroundResource(0x7f02006b);
                    view.setOnClickListener(new h._cls1._cls1(contestinfo, view));
                    textview1.setText(0x7f0c00c1);
                    textview2.setText(0x7f0c00c5);
                    return swipeview;
                }
                obj1 = ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).submitState;
                com.smule.android.network.models.ContestData.SubmitState submitstate = ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).submitState;
                if (obj1 != com.smule.android.network.models.ContestData.SubmitState.NOT_SUBMITTED || ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).started.booleanValue() && ((com.smule.android.network.models.ContestData.ContestUserState) (obj)).score == null)
                {
                    textview.setText(0x7f0c026b);
                    if (Locale.getDefault().getLanguage().compareToIgnoreCase("pt") == 0)
                    {
                        textview.setTextSize(0, a.a.getResources().getDimensionPixelSize(0x7f090134));
                    }
                    swipeview.findViewById(0x7f0a00a5).setVisibility(0);
                    view.setBackgroundResource(0x7f020075);
                    view.setOnClickListener(new h._cls1._cls2(this, songv2));
                    textview2.setText(0x7f0c00c3);
                    textview1.setText(MessageFormat.format(a.a.getString(0x7f0c00c2), new Object[] {
                        Integer.valueOf(e.j())
                    }));
                    return swipeview;
                }
                swipeview.findViewById(0x7f0a00a1).setVisibility(0);
                textview2.setTextColor(a.a.getResources().getColor(0x7f080032));
                textview2.setText(0x7f0c00e0);
                obj = a.a.getString(0x7f0c0133);
                ((TextView)swipeview.findViewById(0x7f0a00a4)).setText(MessageFormat.format(((String) (obj)), new Object[] {
                    Integer.valueOf(e.j())
                }));
                textview.setText(0x7f0c01e0);
                view.setBackgroundResource(0x7f02005f);
                if (songv2 != null)
                {
                    view.setOnClickListener(new h._cls1._cls3(songv2));
                }
                textview1.setText(String.format(a.a.getString(0x7f0c00c0), new Object[] {
                    contestinfo.contest.numWinners
                }));
                return swipeview;
            }
            ((TextView)swipeview.findViewById(0x7f0a00a0)).setText(MessageFormat.format(a.a.getString(0x7f0c02e4), new Object[] {
                (new StringBuilder()).append(((String) (obj1)).substring(0, 1).toUpperCase()).append(((String) (obj1)).substring(1)).toString()
            }));
            textview.setText(0x7f0c026b);
            if (Locale.getDefault().getLanguage().compareToIgnoreCase("pt") == 0)
            {
                textview.setTextSize(0, a.a.getResources().getDimensionPixelSize(0x7f090134));
            }
            view.setBackgroundResource(0x7f020075);
            swipeview.findViewById(0x7f0a00a5).setVisibility(0);
            view.setOnClickListener(new h._cls1._cls4(songv2));
            if (e.a().d(contestinfo))
            {
                textview1.setText(0x7f0c00bf);
                return swipeview;
            }
            if (((com.smule.android.network.models.ContestData.ContestUserState) (obj)).started.booleanValue())
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

        public volatile View a(SwipeView swipeview, Object obj)
        {
            return a(swipeview, (com.smule.android.network.models.ContestData.ContestInfo)obj);
        }

            
            {
                a = h1;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$1

/* anonymous class */
        class h._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final com.smule.android.network.models.ContestData.ContestInfo a;
            final View b;
            final h._cls1 c;

            public void onClick(View view)
            {
                if (!a.isEnded())
                {
                    view = new h._cls1._cls1._cls1(this);
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
                        c = h._cls1.this;
                        a = contestinfo;
                        b = view;
                        super();
                    }
        }


        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$1$1

/* anonymous class */
        class h._cls1._cls1._cls1
            implements Runnable
        {

            final h._cls1._cls1 a;

            public void run()
            {
                com.smule.android.network.core.b.a(new h._cls1._cls1._cls1._cls1(this));
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$1$1$1

/* anonymous class */
        class h._cls1._cls1._cls1._cls1
            implements Runnable
        {

            final h._cls1._cls1._cls1 a;

            public void run()
            {
                e.a().c(a.a.a);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$3

/* anonymous class */
        class h._cls1._cls3
            implements android.view.View.OnClickListener
        {

            final SongV2 a;
            final h._cls1 b;

            public void onClick(View view)
            {
                q.g(a.songId);
                view = new h._cls1._cls3._cls1(this);
                view = n.a(b.a.a, 0x7f020123, b.a.a.getString(0x7f0c00bc), null, b.a.a.getString(0x7f0c00c6), b.a.a.getString(0x7f0c0154), b.a.a.getString(0x7f0c01e4), null, view);
                view.setCancelable(true);
                view.setCanceledOnTouchOutside(true);
                view.show();
            }

                    
                    {
                        b = h._cls1.this;
                        a = songv2;
                        super();
                    }
        }


        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$3$1

/* anonymous class */
        class h._cls1._cls3._cls1
            implements Runnable
        {

            final h._cls1._cls3 a;

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
        }


        // Unreferenced inner class com/smule/pianoandroid/magicpiano/h$1$4

/* anonymous class */
        class h._cls1._cls4
            implements android.view.View.OnClickListener
        {

            final SongV2 a;
            final h._cls1 b;

            public void onClick(View view)
            {
                if (a != null)
                {
                    DailyChallengeActivity.a(b.a.a, a.songId);
                }
            }

                    
                    {
                        b = h._cls1.this;
                        a = songv2;
                        super();
                    }
        }

    }

}
