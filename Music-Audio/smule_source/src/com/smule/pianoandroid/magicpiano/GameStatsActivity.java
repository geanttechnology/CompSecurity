// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.b.a.l;
import com.smule.android.c.aa;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.b.a;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.e.d;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.r;
import com.smule.pianoandroid.utils.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, l, m, MagicApplication, 
//            ac, GameRewardsActivity

public class GameStatsActivity extends ag
{

    public static final String a = com/smule/pianoandroid/magicpiano/GameStatsActivity.getName();
    private List b;
    private boolean c;

    public GameStatsActivity()
    {
    }

    static Dialog a(GameStatsActivity gamestatsactivity, com.smule.pianoandroid.magicpiano.l l1)
    {
        return gamestatsactivity.a(l1);
    }

    private Dialog a(com.smule.pianoandroid.magicpiano.l l1)
    {
        AchievementDefinition achievementdefinition = l1.a;
        Dialog dialog = new Dialog(this, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        View view = getLayoutInflater().inflate(0x7f03001a, null, false);
        view.findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;
            final GameStatsActivity b;

            public void onClick(View view2)
            {
                a.dismiss();
            }

            
            {
                b = GameStatsActivity.this;
                a = dialog;
                super();
            }
        });
        Object obj = (TextView)view.findViewById(0x7f0a0066);
        ((TextView) (obj)).setText(achievementdefinition.title);
        ((TextView) (obj)).setTypeface(z.c(this));
        obj = (TextView)view.findViewById(0x7f0a0067);
        ((TextView) (obj)).setText(achievementdefinition.getDescription());
        ((TextView) (obj)).setTypeface(z.c(this));
        float f = ((TextView) (obj)).getPaint().measureText(achievementdefinition.getDescription());
        obj = (android.widget.RelativeLayout.LayoutParams)view.findViewById(0x7f0a0064).getLayoutParams();
        int i = j.a(44, this);
        i = Math.round(f) + i;
        if (((android.widget.RelativeLayout.LayoutParams) (obj)).width < i)
        {
            obj.width = i;
            view.findViewById(0x7f0a0064).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        obj = (LinearLayout)view.findViewById(0x7f0a0068);
        if (l1.d > 0)
        {
            View view1 = getLayoutInflater().inflate(0x7f030064, null);
            ((ImageView)view1.findViewById(0x7f0a0040)).setImageResource(0x7f020170);
            ((TextView)view1.findViewById(0x7f0a0069)).setText((new StringBuilder()).append("+").append(l1.d).append(" ").append(getText(0x7f0c025e)).toString());
            ((LinearLayout) (obj)).addView(view1);
        }
        if (achievementdefinition.awardXp > 0)
        {
            l1 = getLayoutInflater().inflate(0x7f030064, null);
            ((ImageView)l1.findViewById(0x7f0a0040)).setImageResource(0x7f020173);
            ((TextView)l1.findViewById(0x7f0a0069)).setText((new StringBuilder()).append("+").append(achievementdefinition.awardXp).append(" ").append(getText(0x7f0c02e2)).toString());
            ((LinearLayout) (obj)).addView(l1);
        }
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.show();
        return dialog;
    }

    static List a(GameStatsActivity gamestatsactivity, List list)
    {
        gamestatsactivity.b = list;
        return list;
    }

    static void a(GameStatsActivity gamestatsactivity)
    {
        gamestatsactivity.c();
    }

    private boolean a()
    {
        return (getResources().getConfiguration().screenLayout & 0xf) >= 3;
    }

    private void b()
    {
        if (b.isEmpty())
        {
            findViewById(0x7f0a00cb).setVisibility(0);
            findViewById(0x7f0a00c9).setVisibility(8);
        } else
        {
            findViewById(0x7f0a00c9).setVisibility(0);
            findViewById(0x7f0a00cb).setVisibility(8);
            TableLayout tablelayout;
            byte byte0;
            int i;
            if (a())
            {
                byte0 = 5;
            } else
            {
                byte0 = 4;
            }
            tablelayout = (TableLayout)findViewById(0x7f0a00ca);
            tablelayout.removeAllViews();
            i = 0;
            while (i < b.size()) 
            {
                TableRow tablerow = new TableRow(this);
                tablerow.setLayoutParams(new android.widget.TableRow.LayoutParams(-1, -2));
                int k = 0;
                while (k < byte0 && i < b.size()) 
                {
                    com.smule.pianoandroid.magicpiano.l l1 = (com.smule.pianoandroid.magicpiano.l)b.get(i);
                    View view = getLayoutInflater().inflate(0x7f030030, null);
                    ProgressBar progressbar = (ProgressBar)view.findViewById(0x7f0a00cf);
                    ImageView imageview;
                    TextView textview;
                    int i1;
                    if (l1.b == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = l1.b.getCompletionPercent();
                    }
                    imageview = (ImageView)view.findViewById(0x7f0a00cd);
                    textview = (TextView)view.findViewById(0x7f0a00ce);
                    if (l1.c)
                    {
                        l.a(imageview, l1.a.badgeUrl, 0x7f02003f);
                        view.findViewById(0x7f0a0063).setBackgroundResource(0x7f02003e);
                        imageview.setVisibility(0);
                        if (c)
                        {
                            i1 = 4;
                        } else
                        {
                            i1 = 0;
                        }
                        textview.setVisibility(i1);
                        textview.setOnClickListener(new android.view.View.OnClickListener(l1) {

                            final com.smule.pianoandroid.magicpiano.l a;
                            final GameStatsActivity b;

                            public void onClick(View view1)
                            {
                                com.smule.pianoandroid.e.a.a().a(a.a.uid);
                                a.b.display();
                                com.smule.pianoandroid.magicpiano.ac.a().a("NOTIFICATION_ACHIEVEMENTS", -1);
                                com.smule.pianoandroid.e.a.a().a(a.a);
                                view1 = new Intent(b, com/smule/pianoandroid/magicpiano/GameRewardsActivity);
                                view1.putExtra("ACHIEVEMENT_ID", a.a.uid);
                                b.startActivityForResult(view1, 215);
                            }

            
            {
                b = GameStatsActivity.this;
                a = l1;
                super();
            }
                        });
                        progressbar.setVisibility(8);
                        view.findViewById(0x7f0a00d0).setVisibility(8);
                    } else
                    {
                        view.findViewById(0x7f0a0063).setBackgroundResource(0x7f02003f);
                        imageview.setVisibility(8);
                        textview.setVisibility(8);
                        progressbar.setProgress(0);
                        view.findViewById(0x7f0a00d0).setVisibility(0);
                        progressbar.setProgressDrawable(new a(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), 0x7f020041)), 3));
                        progressbar.setProgress(i1);
                        ((TextView)view.findViewById(0x7f0a00d0)).setText(String.format("%d%%", new Object[] {
                            Integer.valueOf(i1)
                        }));
                    }
                    imageview.setOnClickListener(new android.view.View.OnClickListener(l1) {

                        final com.smule.pianoandroid.magicpiano.l a;
                        final GameStatsActivity b;

                        public void onClick(View view1)
                        {
                            if (GameStatsActivity.b(b))
                            {
                                com.smule.pianoandroid.magicpiano.GameStatsActivity.a(b, a);
                            }
                        }

            
            {
                b = GameStatsActivity.this;
                a = l1;
                super();
            }
                    });
                    progressbar.setOnClickListener(new android.view.View.OnClickListener(l1) {

                        final com.smule.pianoandroid.magicpiano.l a;
                        final GameStatsActivity b;

                        public void onClick(View view1)
                        {
                            com.smule.pianoandroid.magicpiano.GameStatsActivity.a(b, a);
                        }

            
            {
                b = GameStatsActivity.this;
                a = l1;
                super();
            }
                    });
                    ((TextView)view.findViewById(0x7f0a00d1)).setText(l1.a.title);
                    tablerow.addView(view);
                    k++;
                    i++;
                }
                tablelayout.addView(tablerow);
            }
        }
    }

    static boolean b(GameStatsActivity gamestatsactivity)
    {
        return gamestatsactivity.c;
    }

    static List c(GameStatsActivity gamestatsactivity)
    {
        return gamestatsactivity.b;
    }

    private void c()
    {
        (new AsyncTask() {

            final GameStatsActivity a;

            protected transient Void a(Void avoid[])
            {
                aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Loading ...");
                avoid = com.smule.pianoandroid.e.a.a().c();
                com.smule.pianoandroid.magicpiano.GameStatsActivity.a(a, new ArrayList());
                avoid = avoid.iterator();
                do
                {
                    if (avoid.hasNext())
                    {
                        AchievementDefinition achievementdefinition = (AchievementDefinition)avoid.next();
                        if (achievementdefinition.state.claimed && !GameStatsActivity.b(a))
                        {
                            aa.a(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, (new StringBuilder()).append("Filtering ").append(achievementdefinition).toString());
                            continue;
                        }
                        if (!achievementdefinition.state.claimed && GameStatsActivity.b(a))
                        {
                            continue;
                        }
                        com.smule.pianoandroid.magicpiano.l l1 = new com.smule.pianoandroid.magicpiano.l();
                        l1.d = 0;
                        Iterator iterator = achievementdefinition.rewards.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            GameReward gamereward = (GameReward)iterator.next();
                            if (gamereward.getRewardType() != com.smule.pianoandroid.data.model.GameReward.Type.COINS)
                            {
                                continue;
                            }
                            l1.d = gamereward.amount;
                            break;
                        } while (true);
                        l1.a = achievementdefinition;
                        l1.b = achievementdefinition.state;
                        boolean flag;
                        if (l1.b != null && l1.b.getCompletionPercent() >= 100)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        l1.c = flag;
                        GameStatsActivity.c(a).add(l1);
                        continue;
                    }
                    aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Loaded!!!");
                    Collections.sort(GameStatsActivity.c(a), new Comparator(this) {

                        final _cls7 a;

                        public int a(com.smule.pianoandroid.magicpiano.l l1, com.smule.pianoandroid.magicpiano.l l2)
                        {
                            if (l1.b == null && l2.b == null)
                            {
                                return l1.a.goals.size() - l1.a.goals.size();
                            }
                            if (l1.b == null)
                            {
                                return 1;
                            }
                            if (l2.b == null)
                            {
                                return -1;
                            }
                            if (GameStatsActivity.b(a.a))
                            {
                                return (new Long(l2.b.displayedAt)).compareTo(Long.valueOf(l1.b.displayedAt));
                            } else
                            {
                                return l2.b.getCompletionPercent() - l1.b.getCompletionPercent();
                            }
                        }

                        public int compare(Object obj, Object obj1)
                        {
                            return a((com.smule.pianoandroid.magicpiano.l)obj, (com.smule.pianoandroid.magicpiano.l)obj1);
                        }

            
            {
                a = _pcls7;
                super();
            }
                    });
                    aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Sorted!!!");
                    return null;
                } while (true);
            }

            protected void a(Void void1)
            {
                com.smule.pianoandroid.magicpiano.GameStatsActivity.d(a);
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
                a = GameStatsActivity.this;
                super();
            }
        }).execute(new Void[] {
            null, null, null
        });
    }

    static void d(GameStatsActivity gamestatsactivity)
    {
        gamestatsactivity.b();
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    protected void onActivityResult(int i, int k, Intent intent)
    {
        if (i == 215)
        {
            aa.c(a, String.format("User earned %d XP.", new Object[] {
                Integer.valueOf(k)
            }));
            w.a(new Runnable(k) {

                final int a;
                final GameStatsActivity b;

                public void run()
                {
                    e.a().b(a);
                    if (a > 0)
                    {
                        com.smule.pianoandroid.e.d.a().c();
                    }
                }

            
            {
                b = GameStatsActivity.this;
                a = i;
                super();
            }
            });
        }
        super.onActivityResult(i, k, intent);
    }

    public void onBackPressed()
    {
        o.e(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002f);
        onNewIntent(getIntent());
        findViewById(0x1020002);
        bundle = new ArrayList(2);
        bundle.add(getResources().getString(0x7f0c0144));
        bundle.add(getResources().getString(0x7f0c00ac));
        bundle = new m(this, 0x7f03006f, bundle);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setNavigationMode(1);
        getActionBar().setListNavigationCallbacks(bundle, new android.app.ActionBar.OnNavigationListener() {

            final GameStatsActivity a;

            public boolean onNavigationItemSelected(int i, long l1)
            {
                GameStatsActivity gamestatsactivity = a;
                boolean flag;
                if (i == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                gamestatsactivity.a(flag);
                aa.a(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "From menu");
                com.smule.pianoandroid.magicpiano.GameStatsActivity.a(a);
                return true;
            }

            
            {
                a = GameStatsActivity.this;
                super();
            }
        });
        q.q();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0000, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0a024c)
        {
            o.e(this);
            return true;
        } else
        {
            return super.onMenuItemSelected(i, menuitem);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        aa.a(a, "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        c = getIntent().getBooleanExtra("SHOW_COMPLETED", false);
        aa.a(a, (new StringBuilder()).append("Show completed ").append(c).toString());
    }

    protected void onResume()
    {
        super.onResume();
        com.smule.android.c.a.a(r.k);
        aa.a(a, "From onResume");
        ActionBar actionbar = getActionBar();
        int i;
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        actionbar.setSelectedNavigationItem(i);
        c();
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }

}
