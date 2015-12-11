// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.PIException;
import com.pointinside.products.AutocompleteRequestor;
import com.pointinside.products.AutocompleteResult;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.ui.util:
//            q

public class aa
{
    private static final class a
    {

        private final String mSearchTerm;
        private final Store mStore;

        public String a()
        {
            return mSearchTerm;
        }

        public Store b()
        {
            return mStore;
        }

        a(String s, Store store)
        {
            mSearchTerm = s;
            mStore = store;
        }
    }

    private static class b extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final c mObserver;

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

        protected transient List a(a aa1[])
        {
            if (aa1 == null || aa1[0] == null)
            {
                return Collections.emptyList();
            }
            List list = Collections.emptyList();
            try
            {
                aa1 = aa.a(aa1[0].a(), aa1[0].b());
            }
            // Misplaced declaration of an exception variable
            catch (a aa1[])
            {
                q.a("PiSuggestionUtils", (new StringBuilder()).append("Exception occurred : ").append(aa1.getMessage()).toString());
                mObserver.a(aa1.getLocalizedMessage());
                return list;
            }
            return aa1;
        }

        protected void a(List list)
        {
            super.onPostExecute(list);
            if (mObserver != null)
            {
                mObserver.a(list);
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "aa$b#doInBackground", null);
_L1:
            aobj = a((a[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "aa$b#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "aa$b#onPostExecute", null);
_L1:
            a((List)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "aa$b#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        b(c c1)
        {
            mObserver = c1;
        }
    }

    public static interface c
    {

        public abstract void a(String s);

        public abstract void a(List list);
    }


    private static final int MAX_RESULTS = 10;
    private static final String TAG = "PiSuggestionUtils";

    public static List a(String s, Store store)
        throws PIException
    {
        return b(s, store).fetchResult().getSuggestions();
    }

    public static void a(String s, Store store, c c1)
    {
        c1 = new b(c1);
        a aa1[] = new a[1];
        aa1[0] = new a(s, store);
        if (!(c1 instanceof AsyncTask))
        {
            c1.execute(aa1);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)c1, aa1);
            return;
        }
    }

    private static AutocompleteRequestor b(String s, Store store)
    {
        s = (new com.pointinside.products.AutocompleteRequestor.Builder(s)).maxSuggestionsLimit(10).classes(new com.pointinside.products.AutocompleteRequestor.AutocompleteClassType[] {
            com.pointinside.products.AutocompleteRequestor.AutocompleteClassType.autocomplete
        });
        if (store != null && store.getStoreId() != null)
        {
            s.storeID(store.getStoreId().a());
        }
        return s.build();
    }
}
