// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.amazon.client.framework.acf.Components;
import com.amazon.client.framework.acf.MissingViewException;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.client.framework.acf.util:
//            Preconditions

public class Views
{

    private static final int VIEW_ID_MAX = 0x700000;
    private static final int VIEW_ID_MIN = 0x600000;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(0x600000);

    private Views()
    {
        throw new UnsupportedOperationException("do not instantiate");
    }

    private static Object checkAndCastResult(Object obj, int i, Class class1)
    {
        if (obj == null)
        {
            throw new MissingViewException(i, "Required view was not found for the given view.");
        }
        try
        {
            obj = class1.cast(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new MissingViewException(i, "Required view was not of the expected type.", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new MissingViewException(i, "Required view type class definition was not found.", ((Throwable) (obj)));
        }
        return obj;
    }

    private static Object checkAndCastResultNoThrow(Object obj, Class class1)
    {
        if (obj != null && class1.isAssignableFrom(obj.getClass()))
        {
            return class1.cast(obj);
        } else
        {
            return null;
        }
    }

    public static int generateViewId()
    {
        int i;
        int k;
        do
        {
            k = sNextGeneratedId.get();
            int j = k + 1;
            i = j;
            if (j > 0x700000)
            {
                i = 0x600000;
            }
        } while (!sNextGeneratedId.compareAndSet(k, i));
        return k;
    }

    public static Object optional(Activity activity, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (activity != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResultNoThrow(activity.findViewById(i), class1);
    }

    public static Object optional(Dialog dialog, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (dialog != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResultNoThrow(dialog.findViewById(i), class1);
    }

    public static Object optional(Context context, int i, Class class1)
    {
        context = (Activity)Components.optional(context, android/app/Activity);
        if (context == null)
        {
            return null;
        } else
        {
            return optional(((Activity) (context)), i, class1);
        }
    }

    public static Object optional(View view, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (view != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResultNoThrow(view.findViewById(i), class1);
    }

    public static Object required(Activity activity, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (activity != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResult(activity.findViewById(i), i, class1);
    }

    public static Object required(Dialog dialog, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (dialog != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResult(dialog.findViewById(i), i, class1);
    }

    public static Object required(Context context, int i, Class class1)
    {
        return required((Activity)Components.required(context, android/app/Activity), i, class1);
    }

    public static Object required(View view, int i, Class class1)
    {
        boolean flag1 = true;
        boolean flag;
        if (view != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot find a view without a root.");
        if (class1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot cast without a type.");
        return checkAndCastResult(view.findViewById(i), i, class1);
    }

}
