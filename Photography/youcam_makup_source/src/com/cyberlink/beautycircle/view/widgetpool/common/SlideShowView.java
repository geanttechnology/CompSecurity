// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Campaign;
import com.cyberlink.beautycircle.model.CampaignGroup;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.d.a;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView, p

public class SlideShowView extends FrameLayout
    implements a
{

    private boolean a;
    private long b;
    private long c;
    private float d;
    private final List e;
    private final android.widget.FrameLayout.LayoutParams f;
    private int g;
    private boolean h;
    private Runnable i = new Runnable() {

        final SlideShowView a;

        public void run()
        {
            if (com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).size() < 2)
            {
                return;
            }
            Object obj1 = (View)com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).get(com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.c(a));
            int j1 = (com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.c(a) + 1) % com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).size();
            Object obj = (UICImageView)com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).get(j1);
            if (!((UICImageView) (obj)).a())
            {
                ((UICImageView) (obj)).setImageURI((Uri)((UICImageView) (obj)).getTag());
                return;
            } else
            {
                com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a, j1);
                ((UICImageView) (obj)).setVisibility(0);
                float f1 = a.getWidth();
                float f2 = f1 / 3F;
                float f3 = f2 / 3F;
                obj = ObjectAnimator.ofFloat(obj, "translationX", new float[] {
                    f1, f2, f3, 0.0F
                }).setDuration(SlideShowView.d(a));
                obj1 = ObjectAnimator.ofFloat(obj1, "translationX", new float[] {
                    0.0F, f2 + (0.0F - f1), (0.0F - f1) + f3, 0.0F - f1
                }).setDuration(SlideShowView.d(a));
                AnimatorSet animatorset = new AnimatorSet();
                animatorset.playTogether(new Animator[] {
                    obj1, obj
                });
                animatorset.start();
                a.postDelayed(com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.e(a), SlideShowView.f(a));
                return;
            }
        }

            
            {
                a = SlideShowView.this;
                super();
            }
    };
    private boolean j;
    private float k;
    private p l;

    public SlideShowView(Context context)
    {
        this(context, null);
    }

    public SlideShowView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SlideShowView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = true;
        b = 10000L;
        c = 500L;
        d = 20F;
        e = new ArrayList();
        f = new android.widget.FrameLayout.LayoutParams(-1, -1);
        g = 0;
        h = true;
        j = false;
        k = 0.0F;
        l = null;
    }

    static int a(SlideShowView slideshowview, int i1)
    {
        slideshowview.g = i1;
        return i1;
    }

    static long a(SlideShowView slideshowview, long l1)
    {
        slideshowview.b = l1;
        return l1;
    }

    static List a(SlideShowView slideshowview)
    {
        return slideshowview.e;
    }

    private void a(Campaign campaign)
    {
        if (campaign != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        UICImageView uicimageview;
        uicimageview = new UICImageView(getContext());
        uicimageview.setTag(campaign);
        uicimageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        uicimageview.setLayoutParams(f);
        uicimageview.setVisibility(8);
        uicimageview.setImageLoadingListener(this);
        if (campaign.coverURL_720 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        uicimageview.setTag(campaign.coverURL_720);
_L4:
        if (campaign.link != null)
        {
            uicimageview.setOnClickListener(new android.view.View.OnClickListener(campaign) {

                final Campaign a;
                final SlideShowView b;

                public void onClick(View view)
                {
                    com.cyberlink.beautycircle.c.a(b.getContext(), a.link.toString(), 1);
                }

            
            {
                b = SlideShowView.this;
                a = campaign;
                super();
            }
            });
        }
        addView(uicimageview);
        e.add(uicimageview);
        return;
        if (campaign.coverURL_1080 == null) goto _L1; else goto _L3
_L3:
        uicimageview.setTag(campaign.coverURL_1080);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    static void a(SlideShowView slideshowview, Campaign campaign)
    {
        slideshowview.a(campaign);
    }

    private void a(boolean flag)
    {
        ViewParent viewparent1 = getParent();
        ViewParent viewparent = viewparent1;
        if (viewparent1 != null)
        {
            viewparent1.requestDisallowInterceptTouchEvent(flag);
            viewparent = viewparent1;
        }
        do
        {
            if (viewparent == null)
            {
                break;
            }
            if (viewparent instanceof SwipeRefreshLayout)
            {
                ViewParent viewparent2 = viewparent.getParent();
                viewparent = viewparent2;
                if (viewparent2 != null)
                {
                    viewparent2.requestDisallowInterceptTouchEvent(flag);
                    viewparent = viewparent2;
                }
            } else
            {
                viewparent = viewparent.getParent();
            }
        } while (true);
    }

    static boolean a(SlideShowView slideshowview, boolean flag)
    {
        slideshowview.h = flag;
        return flag;
    }

    static boolean b(SlideShowView slideshowview)
    {
        return slideshowview.a;
    }

    static int c(SlideShowView slideshowview)
    {
        return slideshowview.g;
    }

    static long d(SlideShowView slideshowview)
    {
        return slideshowview.c;
    }

    static Runnable e(SlideShowView slideshowview)
    {
        return slideshowview.i;
    }

    static long f(SlideShowView slideshowview)
    {
        return slideshowview.b;
    }

    static p g(SlideShowView slideshowview)
    {
        return slideshowview.l;
    }

    public void a(String s, View view)
    {
    }

    public void a(String s, View view, Bitmap bitmap)
    {
        b();
    }

    public void a(String s, View view, FailReason failreason)
    {
    }

    public boolean a()
    {
        return h;
    }

    public void b()
    {
        if (e.size() < 1)
        {
            return;
        } else
        {
            post(new Runnable() {

                final SlideShowView a;

                public void run()
                {
                    if (com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).size() == 0)
                    {
                        return;
                    }
                    UICImageView uicimageview = (UICImageView)com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).get(com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.c(a));
                    if (uicimageview.a())
                    {
                        ViewParent viewparent = a.getParent();
                        if (viewparent instanceof View)
                        {
                            ((View)viewparent).setVisibility(0);
                        }
                        if (a.getVisibility() != 0)
                        {
                            a.setVisibility(0);
                            if (SlideShowView.g(a) != null)
                            {
                                SlideShowView.g(a).a();
                            }
                        }
                        uicimageview.setVisibility(0);
                        int i1 = com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.c(a);
                        int j1 = com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).size();
                        uicimageview = (UICImageView)com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(a).get((i1 + 1) % j1);
                        if (!uicimageview.a())
                        {
                            uicimageview.setImageURI((Uri)uicimageview.getTag());
                            return;
                        } else
                        {
                            a.postDelayed(com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.e(a), SlideShowView.f(a));
                            return;
                        }
                    } else
                    {
                        uicimageview.setImageURI((Uri)uicimageview.getTag());
                        return;
                    }
                }

            
            {
                a = SlideShowView.this;
                super();
            }
            });
            return;
        }
    }

    public void b(String s, View view)
    {
    }

    public void c()
    {
        post(new Runnable() {

            final SlideShowView a;

            public void run()
            {
                a.removeCallbacks(com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.e(a));
            }

            
            {
                a = SlideShowView.this;
                super();
            }
        });
    }

    protected View getLeftSlideView()
    {
        int i1 = e.size();
        return (View)e.get(((g + i1) - 1) % i1);
    }

    protected View getRightSlideView()
    {
        return (View)e.get((g + 1) % e.size());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        if (e.size() <= 1 || !e.a)
        {
            return false;
        }
        i1 = motionevent.getAction();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (e.size() > 1)
        {
            c();
            a(true);
        }
        k = motionevent.getX();
_L9:
        return false;
_L2:
        if (i1 == 2)
        {
            if (!j)
            {
                if (Math.abs(motionevent.getX() - k) > d)
                {
                    j = true;
                    k = motionevent.getX();
                }
            } else
            if (e.a)
            {
                float f1 = k;
                k = motionevent.getX();
                float f4 = k;
                i1 = e.size();
                motionevent = (View)e.get(g);
                View view = (View)e.get(((g + i1) - 1) % i1);
                View view2 = (View)e.get((g + 1) % i1);
                f1 = (f4 - f1) + motionevent.getTranslationX();
                motionevent.setTranslationX(f1);
                if (f1 > 0.0F)
                {
                    view2.setVisibility(8);
                    view.setVisibility(0);
                    view.setTranslationX((float)(0 - getWidth()) + f1);
                } else
                if (f1 < 0.0F)
                {
                    view.setVisibility(8);
                    view2.setVisibility(0);
                    view2.setTranslationX((float)getWidth() + f1);
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i1 != 1 && i1 != 3) goto _L4; else goto _L3
_L3:
        float f2;
        float f5;
        View view1;
        a(false);
        b();
        if (!j)
        {
            continue; /* Loop/switch isn't completed */
        }
        f2 = (float)getWidth() / 2.0F;
        view1 = (View)e.get(g);
        f5 = view1.getTranslationX();
        if (f5 <= f2) goto _L6; else goto _L5
_L5:
        motionevent = getLeftSlideView();
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(view1, "translationX", new float[] {
                (float)getWidth()
            }), ObjectAnimator.ofFloat(motionevent, "translationX", new float[] {
                0.0F
            })
        });
        animatorset.setDuration(c / 2L).start();
        int j1 = g + 1;
        g = j1;
        g = j1 % e.size();
_L7:
        j = false;
        return true;
_L6:
        if (f5 < 0.0F - f2)
        {
            motionevent = getRightSlideView();
            AnimatorSet animatorset1 = new AnimatorSet();
            animatorset1.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(view1, "translationX", new float[] {
                    (float)(0 - getWidth())
                }), ObjectAnimator.ofFloat(motionevent, "translationX", new float[] {
                    0.0F
                })
            });
            animatorset1.setDuration(c / 2L).start();
            int k1 = g - 1;
            g = k1;
            g = (k1 + e.size()) % e.size();
        } else
        if (f5 != 0.0F)
        {
            float f3;
            AnimatorSet animatorset2;
            if (f5 > 0.0F)
            {
                motionevent = getLeftSlideView();
            } else
            {
                motionevent = getRightSlideView();
            }
            if (f5 > 0.0F)
            {
                f3 = 0 - getWidth();
            } else
            {
                f3 = getWidth();
            }
            animatorset2 = new AnimatorSet();
            animatorset2.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(view1, "translationX", new float[] {
                    0.0F
                }), ObjectAnimator.ofFloat(motionevent, "translationX", new float[] {
                    f3
                })
            });
            animatorset2.setDuration(c / 2L).start();
        }
        if (true) goto _L7; else goto _L4
_L4:
        com.perfectcorp.utility.e.e(new Object[] {
            Integer.valueOf(motionevent.getAction())
        });
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public void setCampaignGroup(CampaignGroup campaigngroup)
    {
        post(new Runnable(campaigngroup) {

            final CampaignGroup a;
            final SlideShowView b;

            public void run()
            {
                b.c();
                b.removeAllViews();
                com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b, 0);
                if (a == null || a.campaigns == null || a.campaigns.isEmpty())
                {
                    com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b, true);
                    b.setVisibility(8);
                } else
                {
                    com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b, false);
                }
                com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b).clear();
                if (a != null && a.campaigns != null)
                {
                    com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b, a.rotationPeriod);
                    Campaign campaign;
                    for (Iterator iterator = a.campaigns.iterator(); iterator.hasNext(); com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView.a(b, campaign))
                    {
                        campaign = (Campaign)iterator.next();
                    }

                }
                if (SlideShowView.b(b))
                {
                    b.b();
                }
            }

            
            {
                b = SlideShowView.this;
                a = campaigngroup;
                super();
            }
        });
    }

    public void setStatusChangeListener(p p)
    {
        l = p;
    }
}
