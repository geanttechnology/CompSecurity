// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import java.lang.reflect.Field;
import net.tsz.afinal.annotation.view.EventListener;
import net.tsz.afinal.annotation.view.Select;
import net.tsz.afinal.annotation.view.ViewInject;

public class FinalActivity extends Activity
{

    public FinalActivity()
    {
    }

    private void initView()
    {
        Field afield[] = getClass().getDeclaredFields();
        if (afield == null || afield.length <= 0) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = afield.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        Field field = afield[i];
        Object obj = (ViewInject)field.getAnnotation(net/tsz/afinal/annotation/view/ViewInject);
        if (obj != null)
        {
            int k = ((ViewInject) (obj)).id();
            String s;
            try
            {
                field.setAccessible(true);
                field.set(this, findViewById(k));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            s = ((ViewInject) (obj)).click();
            if (!TextUtils.isEmpty(s))
            {
                setViewClickListener(field, s);
            }
            s = ((ViewInject) (obj)).longClick();
            if (!TextUtils.isEmpty(s))
            {
                setViewLongClickListener(field, s);
            }
            s = ((ViewInject) (obj)).itemClick();
            if (!TextUtils.isEmpty(s))
            {
                setItemClickListener(field, s);
            }
            s = ((ViewInject) (obj)).itemLongClick();
            if (!TextUtils.isEmpty(s))
            {
                setItemLongClickListener(field, s);
            }
            obj = ((ViewInject) (obj)).select();
            if (!TextUtils.isEmpty(((Select) (obj)).selected()))
            {
                setViewSelectListener(field, ((Select) (obj)).selected(), ((Select) (obj)).noSelected());
            }
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void setItemClickListener(Field field, String s)
    {
        try
        {
            field = ((Field) (field.get(this)));
            if (field instanceof AbsListView)
            {
                ((AbsListView)field).setOnItemClickListener((new EventListener(this)).itemClick(s));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    private void setItemLongClickListener(Field field, String s)
    {
        try
        {
            field = ((Field) (field.get(this)));
            if (field instanceof AbsListView)
            {
                ((AbsListView)field).setOnItemLongClickListener((new EventListener(this)).itemLongClick(s));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    private void setViewClickListener(Field field, String s)
    {
        try
        {
            field = ((Field) (field.get(this)));
            if (field instanceof View)
            {
                ((View)field).setOnClickListener((new EventListener(this)).click(s));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    private void setViewLongClickListener(Field field, String s)
    {
        try
        {
            field = ((Field) (field.get(this)));
            if (field instanceof View)
            {
                ((View)field).setOnLongClickListener((new EventListener(this)).longClick(s));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    private void setViewSelectListener(Field field, String s, String s1)
    {
        try
        {
            field = ((Field) (field.get(this)));
            if (field instanceof View)
            {
                ((AbsListView)field).setOnItemSelectedListener((new EventListener(this)).select(s).noSelect(s1));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        initView();
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        initView();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        initView();
    }
}
