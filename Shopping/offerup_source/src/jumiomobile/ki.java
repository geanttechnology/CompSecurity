// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;

// Referenced classes of package jumiomobile:
//            lm

public class ki extends Fragment
{

    protected lm a;

    public ki()
    {
    }

    protected void a(String s)
    {
        if (getActivity() instanceof AppCompatActivity)
        {
            ActionBar actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
            if (actionbar != null)
            {
                s = new SpannableString(s);
                s.setSpan(new AbsoluteSizeSpan(20, true), 0, s.length(), 33);
                actionbar.setTitle(s);
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            a = (lm)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            activity = new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement PropertiesFragmentCallback").toString());
            activity.setStackTrace(classcastexception.getStackTrace());
            throw activity;
        }
    }
}
