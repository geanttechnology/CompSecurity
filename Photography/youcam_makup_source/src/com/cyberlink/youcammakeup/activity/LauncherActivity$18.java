// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.o;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, CameraLandscapeActivity, CameraActivity

class c
    implements android.view.
{

    final LauncherActivity a;
    private AnimatorSet b;
    private Toast c;

    private void a(View view)
    {
        if (LauncherActivity.e(a) && view.isClickable())
        {
            return;
        }
        if (!o.a())
        {
            if (c != null)
            {
                c.cancel();
                c = null;
            }
            c = Toast.makeText(a, 0x7f070062, 0);
            c.show();
            return;
        } else
        {
            com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
            Globals.d().a(false);
            float f = LauncherActivity.j(a).getHeight();
            view.setVisibility(8);
            view = ObjectAnimator.ofPropertyValuesHolder(LauncherActivity.i(a), new PropertyValuesHolder[] {
                PropertyValuesHolder.ofFloat("translationY", new float[] {
                    f
                })
            });
            ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(LauncherActivity.j(a), new PropertyValuesHolder[] {
                PropertyValuesHolder.ofFloat("translationY", new float[] {
                    -f
                })
            });
            AnimatorSet animatorset = (new AnimatorSet()).setDuration(300L);
            animatorset.playTogether(new Animator[] {
                view, objectanimator
            });
            animatorset.addListener(new ch() {

                final LauncherActivity._cls18 a;

                public void onAnimationEnd(Animator animator)
                {
                    com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.b));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.b));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.a, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    YMKLiveCamEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Source.a.a());
                    g.a(a.a, null, null, null);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a.a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a.a, false);
                    Globals.d().a(false);
                    if (LiveDemoConfigHelper.h().d())
                    {
                        animator = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
                    } else
                    {
                        animator = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
                    }
                    a.a.startActivity(animator);
                    a.a.finish();
                }

            
            {
                a = LauncherActivity._cls18.this;
                super();
            }
            });
            animatorset.start();
            return;
        }
    }

    private void a(View view, boolean flag)
    {
        if (!flag);
        float f;
        float f1;
        ObjectAnimator objectanimator;
        ObjectAnimator objectanimator1;
        ObjectAnimator objectanimator2;
        Object obj;
        Object obj1;
        if (flag)
        {
            f1 = 1.2F;
        } else
        {
            f1 = 1.0F;
        }
        if (flag)
        {
            f = 70F;
        } else
        {
            f = 0.0F;
        }
        view = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("rotation", new float[] {
                0.0F
            }), PropertyValuesHolder.ofFloat("scaleX", new float[] {
                f1
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                f1
            })
        });
        objectanimator = ObjectAnimator.ofFloat(LauncherActivity.i(a), "translationY", new float[] {
            f
        });
        objectanimator1 = ObjectAnimator.ofFloat(LauncherActivity.j(a), "translationY", new float[] {
            -f
        });
        objectanimator2 = ObjectAnimator.ofFloat(LauncherActivity.k(a), "translationY", new float[] {
            -f
        });
        obj = LauncherActivity.l(a);
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        obj = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                f1
            })
        });
        obj1 = LauncherActivity.m(a);
        if (flag)
        {
            f = (f + (float)LauncherActivity.m(a).getHeight()) / (float)LauncherActivity.m(a).getHeight();
        } else
        {
            f = 1.0F;
        }
        obj1 = ObjectAnimator.ofPropertyValuesHolder(obj1, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("scaleY", new float[] {
                f
            })
        });
        LauncherActivity.m(a).setPivotY(LauncherActivity.m(a).getHeight());
        b = (new AnimatorSet()).setDuration(100L);
        b.playTogether(new Animator[] {
            view, objectanimator, objectanimator1, objectanimator2, obj1, obj
        });
        b.start();
    }

    static void a(b b1, View view)
    {
        b1.a(view);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getActionMasked())
        {
        default:
            return true;

        case 0: // '\0'
            LauncherActivity.h(a).setSelected(true);
            a(view, true);
            return true;

        case 1: // '\001'
            LauncherActivity.h(a).setSelected(false);
            break;
        }
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        if (f >= 0.0F && f <= (float)view.getWidth() && f1 >= 0.0F && f1 <= (float)view.getHeight())
        {
            if (b != null && b.isRunning())
            {
                b.addListener(new ch(view) {

                    final View a;
                    final LauncherActivity._cls18 b;

                    public void onAnimationEnd(Animator animator)
                    {
                        com.cyberlink.youcammakeup.activity.LauncherActivity._cls18.a(b, a);
                    }

            
            {
                b = LauncherActivity._cls18.this;
                a = view;
                super();
            }
                });
                return true;
            } else
            {
                a(view);
                return true;
            }
        } else
        {
            a(view, false);
            return true;
        }
    }

    _cls2.a(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
        b = null;
        c = null;
    }
}
