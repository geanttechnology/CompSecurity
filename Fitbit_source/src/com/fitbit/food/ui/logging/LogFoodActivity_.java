// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fitbit.food.ui.logging;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fitbit.data.domain.MealType;
import com.fitbit.food.ui.logging.views.AddedFoodLogView;
import com.fitbit.food.ui.logging.views.ChooseMealTypeView;
import com.fitbit.food.ui.logging.views.EstimateCaloriesView;
import com.fitbit.food.ui.logging.views.FoodItemDescriptionView;
import com.fitbit.food.ui.logging.views.FoodLogDateView;
import com.fitbit.food.ui.logging.views.ServingSizeView;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import org.androidannotations.a.c.a;
import org.androidannotations.a.c.b;
import org.androidannotations.a.c.c;

// Referenced classes of package com.fitbit.food.ui.logging:
//            LogFoodActivity, FoodLogSaveModel

public final class LogFoodActivity_ extends LogFoodActivity
    implements org.androidannotations.a.c.a, b
{
    public static class a
    {

        private Context a;
        private final Intent b;
        private Fragment c;

        public Intent a()
        {
            return b;
        }

        public a a(int i)
        {
            b.setFlags(i);
            return this;
        }

        public a a(MealType mealtype)
        {
            b.putExtra("mealType", mealtype);
            return this;
        }

        public a a(LogFoodBaseActivity.Mode mode)
        {
            b.putExtra("mode", mode);
            return this;
        }

        public a a(Long long1)
        {
            b.putExtra("logEntryId", long1);
            return this;
        }

        public a a(Date date)
        {
            b.putExtra("logDate", date);
            return this;
        }

        public a a(boolean flag)
        {
            b.putExtra("isStartedFromScanned", flag);
            return this;
        }

        public a b(Long long1)
        {
            b.putExtra("foodEntityId", long1);
            return this;
        }

        public void b()
        {
            a.startActivity(b);
        }

        public void b(int i)
        {
            if (c != null)
            {
                c.startActivityForResult(b, i);
                return;
            }
            if (a instanceof Activity)
            {
                ((Activity)a).startActivityForResult(b, i);
                return;
            } else
            {
                a.startActivity(b);
                return;
            }
        }

        public a c(Long long1)
        {
            b.putExtra("foodServerId", long1);
            return this;
        }

        public a(Context context)
        {
            a = context;
            b = new Intent(context, com/fitbit/food/ui/logging/LogFoodActivity_);
        }

        public a(Fragment fragment)
        {
            c = fragment;
            a = fragment.getActivity();
            b = new Intent(a, com/fitbit/food/ui/logging/LogFoodActivity_);
        }
    }


    public static final String q = "logDate";
    public static final String r = "logEntryId";
    public static final String s = "mode";
    public static final String t = "mealType";
    public static final String u = "foodEntityId";
    public static final String v = "isStartedFromScanned";
    public static final String w = "foodServerId";
    private final c J = new c();

    public LogFoodActivity_()
    {
    }

    public static a a(Context context)
    {
        return new a(context);
    }

    public static a a(Fragment fragment)
    {
        return new a(fragment);
    }

    private void a(Bundle bundle)
    {
        c.a(this);
        p();
        b(bundle);
    }

    private void b(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            E = (AtomicBoolean)bundle.getSerializable("logging");
            A = (Date)bundle.getSerializable("logDate");
            B = (MealType)bundle.getSerializable("mealType");
            o = (FoodLogSaveModel)bundle.getSerializable("saveModel");
            return;
        }
    }

    private void p()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            if (bundle.containsKey("logDate"))
            {
                A = (Date)bundle.getSerializable("logDate");
            }
            if (bundle.containsKey("logEntryId"))
            {
                y = (Long)bundle.getSerializable("logEntryId");
            }
            if (bundle.containsKey("mode"))
            {
                x = (LogFoodBaseActivity.Mode)bundle.getSerializable("mode");
            }
            if (bundle.containsKey("mealType"))
            {
                B = (MealType)bundle.getSerializable("mealType");
            }
            if (bundle.containsKey("foodEntityId"))
            {
                b = (Long)bundle.getSerializable("foodEntityId");
            }
            if (bundle.containsKey("isStartedFromScanned"))
            {
                p = bundle.getBoolean("isStartedFromScanned");
            }
            if (bundle.containsKey("foodServerId"))
            {
                a = (Long)bundle.getSerializable("foodServerId");
            }
        }
    }

    public void a(org.androidannotations.a.c.a a1)
    {
        C = (ChooseMealTypeView)a1.findViewById(0x7f110150);
        D = a1.findViewById(0x7f11006c);
        d = (FoodItemDescriptionView)a1.findViewById(0x7f11014b);
        j = a1.findViewById(0x7f110156);
        c = (ScrollView)a1.findViewById(0x7f110149);
        k = (EstimateCaloriesView)a1.findViewById(0x7f11014f);
        l = a1.findViewById(0x7f11014d);
        h = (AddedFoodLogView)a1.findViewById(0x7f11014a);
        f = (TextView)a1.findViewById(0x7f110109);
        e = (ServingSizeView)a1.findViewById(0x7f11014c);
        i = a1.findViewById(0x7f110153);
        m = (TextView)a1.findViewById(0x7f11014e);
        g = (FoodLogDateView)a1.findViewById(0x7f110152);
        View view = a1.findViewById(0x7f110157);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final LogFoodActivity_ a;

                public void onClick(View view1)
                {
                    a.i();
                }

            
            {
                a = LogFoodActivity_.this;
                super();
            }
            });
        }
        view = a1.findViewById(0x7f1100e5);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final LogFoodActivity_ a;

                public void onClick(View view1)
                {
                    a.j();
                }

            
            {
                a = LogFoodActivity_.this;
                super();
            }
            });
        }
        view = a1.findViewById(0x7f110155);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final LogFoodActivity_ a;

                public void onClick(View view1)
                {
                    a.h();
                }

            
            {
                a = LogFoodActivity_.this;
                super();
            }
            });
        }
        a1 = a1.findViewById(0x7f110154);
        if (a1 != null)
        {
            a1.setOnClickListener(new android.view.View.OnClickListener() {

                final LogFoodActivity_ a;

                public void onClick(View view1)
                {
                    a.g();
                }

            
            {
                a = LogFoodActivity_.this;
                super();
            }
            });
        }
        c();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        switch (i)
        {
        default:
            return;

        case 4781: 
            g_(j);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        c c1 = c.a(J);
        a(bundle);
        super.onCreate(bundle);
        c.a(c1);
        setContentView(0x7f040031);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (org.androidannotations.a.b.a() < 5 && i == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("logging", E);
        bundle.putSerializable("logDate", A);
        bundle.putSerializable("mealType", B);
        bundle.putSerializable("saveModel", o);
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        J.a(this);
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        J.a(this);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        J.a(this);
    }

    public void setIntent(Intent intent)
    {
        super.setIntent(intent);
        p();
    }
}
