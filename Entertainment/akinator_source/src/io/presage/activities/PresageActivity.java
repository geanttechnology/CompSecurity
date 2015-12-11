// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import io.presage.utils.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

// Referenced classes of package io.presage.activities:
//            a

public class PresageActivity extends Activity
{
    public static abstract class ActivityHandler
    {

        protected Activity a;

        public void onCreate(Bundle bundle)
        {
        }

        public void onDestroy()
        {
        }

        public void onPause()
        {
        }

        public void onRestart()
        {
        }

        public void onResume()
        {
        }

        public void onSaveInstanceState(Bundle bundle)
        {
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public ActivityHandler(Activity activity)
        {
            a = activity;
        }
    }


    public static final String a = null;
    private static final Map b = new a();
    private ActivityHandler c;

    public PresageActivity()
    {
        c = null;
    }

    public void onBackPressed()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (c != null)
        {
            c.onCreate(bundle);
            return;
        }
        Object obj = getIntent().getExtras();
        if (obj != null)
        {
            obj = ((Bundle) (obj)).getString("activity_handler");
            Class class1 = (Class)b.get(obj);
            if (class1 != null)
            {
                try
                {
                    c = (ActivityHandler)class1.getConstructor(new Class[] {
                        android/app/Activity
                    }).newInstance(new Object[] {
                        this
                    });
                    e.b(new String[] {
                        "Activity handler", c.getClass().getName(), "onCreate"
                    });
                    c.onCreate(bundle);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
            } else
            {
                e.c(new String[] {
                    "PresageActivity called with a wrong handler", obj, ". Possible handlers are", Arrays.toString(b.keySet().toArray())
                });
            }
        } else
        {
            e.c(new String[] {
                "PresageActivity called without any extra."
            });
        }
        e.c(new String[] {
            "Finishing the activity."
        });
        finish();
    }

    protected void onDestroy()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onDestroy"
        });
        c.onDestroy();
        super.onDestroy();
    }

    protected void onPause()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onPause"
        });
        c.onPause();
        super.onPause();
    }

    protected void onRestart()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onRestart"
        });
        super.onRestart();
        c.onRestart();
    }

    protected void onResume()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onResume"
        });
        super.onResume();
        c.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onSaveInstanceState"
        });
        c.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onStart"
        });
        super.onStart();
        c.onStart();
    }

    protected void onStop()
    {
        e.b(new String[] {
            "Activity handler", c.getClass().getName(), "onStop"
        });
        c.onStop();
        super.onStop();
    }

}
