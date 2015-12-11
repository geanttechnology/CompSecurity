// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.ik;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public class ContactActivity extends b
{
    private static class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        private final String a;
        private final String b;
        private final ParseUser c;
        private final String d;
        private final String e;
        private final WeakReference f;
        private ProgressDialog g;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient Boolean a(Void avoid[])
        {
            if (iu.c(c) && TextUtils.isEmpty(c.getEmail()))
            {
                c.setEmail(d);
                try
                {
                    c.save();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    aqo.b(avoid, "Error saving user email", new Object[0]);
                }
            }
            avoid = new ParseObject("Contacts");
            avoid.put("title", a);
            avoid.put("description", (new StringBuilder()).append(b).append(" ").append(d).append(" ").append(e).toString());
            avoid.put("user", c);
            avoid.put("email", d);
            avoid.put("processed", Boolean.valueOf(false));
            try
            {
                avoid.save();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                aqo.b(avoid, "error saving user contact form", new Object[0]);
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }

        protected void a(Boolean boolean1)
        {
            Object obj;
label0:
            {
                iv.a(g);
                if (f == null)
                {
                    obj = null;
                } else
                {
                    obj = (Activity)f.get();
                }
                if (obj != null)
                {
                    if (!boolean1.booleanValue())
                    {
                        break label0;
                    }
                    Toast.makeText(((Context) (obj)), 0x7f090081, 1).show();
                    ((Activity) (obj)).finish();
                }
                return;
            }
            Toast.makeText(((Context) (obj)), 0x7f090080, 1).show();
        }

        protected void b(Boolean boolean1)
        {
            super.onCancelled(boolean1);
            iv.a(g);
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "ContactActivity$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ContactActivity$a#doInBackground", null);
              goto _L1
        }

        protected void onCancelled(Object obj)
        {
            b((Boolean)obj);
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "ContactActivity$a#onPostExecute", null);
_L1:
            a((Boolean)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ContactActivity$a#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            Object obj;
            if (f == null)
            {
                obj = null;
            } else
            {
                obj = (Activity)f.get();
            }
            if (obj != null && !((Activity) (obj)).isFinishing())
            {
                g = new ProgressDialog(((Context) (obj)));
                g.setMessage(((Activity) (obj)).getString(0x7f0900ba));
                g.setIndeterminate(true);
                g.show();
            }
        }

        public a(String s, String s1, ParseUser parseuser, Activity activity, String s2, String s3)
        {
            a = s;
            b = s1;
            c = parseuser;
            d = s2;
            e = s3;
            f = new WeakReference(activity);
        }
    }


    Button btnSend;
    EditText etContent;
    EditText etEmail;
    private ik n;
    Spinner spSubject;

    public ContactActivity()
    {
    }

    private boolean C()
    {
        return !TextUtils.isEmpty(etContent.getText().toString());
    }

    private boolean D()
    {
        return !TextUtils.isEmpty(etEmail.getText().toString());
    }

    private boolean E()
    {
        return spSubject.getSelectedItemPosition() != 0;
    }

    private void a(Context context)
    {
        context = ArrayAdapter.createFromResource(context, 0x7f0e0002, 0x1090008);
        context.setDropDownViewResource(0x1090009);
        spSubject.setAdapter(context);
    }

    private void c(int i)
    {
        if (spSubject == null) goto _L2; else goto _L1
_L1:
        TextView textview;
        try
        {
            textview = (TextView)spSubject.getChildAt(0);
        }
        catch (ClassCastException classcastexception)
        {
            aqo.a(classcastexception, "Error casting spinner to textView", new Object[0]);
            return;
        }
        if (textview == null) goto _L2; else goto _L3
_L3:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        i = getResources().getColor(0x7f0f0049);
_L4:
        textview.setTextColor(i);
_L2:
        return;
        i = 0xff000000;
          goto _L4
    }

    private void d(int i)
    {
        if (i == 0)
        {
            btnSend.setEnabled(false);
        } else
        {
            etContent.requestFocus();
            if (C() && D())
            {
                btnSend.setEnabled(true);
                return;
            }
        }
    }

    private boolean d(String s)
    {
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }

    private boolean l()
    {
        return C() && D() && E();
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            b(0x7f040019);
            a(0x7f0200d1);
            ButterKnife.bind(this);
            n = new ik();
            bundle = ParseUser.getCurrentUser().getEmail();
            if (!TextUtils.isEmpty(bundle))
            {
                etEmail.setText(bundle);
                int i = bundle.length();
                etEmail.setSelection(i);
                etEmail.requestFocus();
            }
            a(((Context) (this)));
        }
    }

    protected void afterTextChanged()
    {
        if (l())
        {
            btnSend.setEnabled(true);
            return;
        } else
        {
            btnSend.setEnabled(false);
            return;
        }
    }

    protected void k()
    {
        setContentView(0x7f04001b);
    }

    protected boolean m()
    {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
label0:
        {
            super.onConfigurationChanged(configuration);
            c(spSubject.getSelectedItemPosition());
            if (configuration.orientation == 1)
            {
                if (!D())
                {
                    break label0;
                }
                etContent.requestFocus();
            }
            return;
        }
        etEmail.requestFocus();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onItemSelected(int i)
    {
        c(i);
        d(i);
    }

    protected void onSendContactTap()
    {
        Object obj;
        String s;
        String s1;
label0:
        {
            obj = spSubject.getSelectedItem();
            if (obj != null)
            {
                obj = obj.toString();
                s = etContent.getText().toString();
                s1 = etEmail.getText().toString();
                boolean flag1 = TextUtils.isEmpty(s);
                boolean flag2 = TextUtils.isEmpty(s1);
                boolean flag;
                if (!d(s1))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag1 && !flag2 && !flag)
                {
                    break label0;
                }
                if (flag1)
                {
                    etContent.setError(getString(0x7f09006a));
                }
                if (flag2)
                {
                    etEmail.setError(getString(0x7f09006a));
                }
                if (flag)
                {
                    etEmail.setError(getString(0x7f090077));
                    etEmail.requestFocus();
                }
            }
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getString(0x7f0901d7, new Object[] {
            n.c()
        }));
        stringbuilder.append(" ,").append(getString(0x7f0901e0, new Object[] {
            n.a()
        }));
        stringbuilder.append(" ,").append(getString(0x7f0901cf, new Object[] {
            n.b()
        }));
        obj = new a(((String) (obj)), s, ParseUser.getCurrentUser(), this, s1, stringbuilder.toString());
        Void avoid[] = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((a) (obj)).execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
            return;
        }
    }
}
