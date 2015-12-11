// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            VectorFragment

class <init> extends AsyncTask
{

    final VectorFragment this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Integer[])aobj);
    }

    protected transient String[] doInBackground(final Integer params[])
    {
        if (getActivity() == null)
        {
            return null;
        } else
        {
            class _cls1
                implements Runnable
            {

                final VectorFragment.LoadSearchVectorTask this$1;
                final Integer val$params[];

                public void run()
                {
                    if (endList || getActivity() == null)
                    {
                        return;
                    } else
                    {
                        class _cls1 extends MixerBoxAsyncHttpResponseHandler
                        {

                            final _cls1 this$2;

                            public void onFailure(Throwable throwable, String s)
                            {
                                super.onFailure(throwable, s);
                            }

                            public void onSuccess(String s)
                            {
                                boolean flag;
                                flag = false;
                                super.onSuccess(s);
                                if (s == null)
                                {
                                    return;
                                }
                                if (params[0].intValue() == -1)
                                {
                                    array.clear();
                                }
                                s = (new JSONObject(s)).getJSONObject("searchVideo").getJSONArray("items");
                                int i = ((flag) ? 1 : 0);
                                if (s.length() >= 20)
                                {
                                    break MISSING_BLOCK_LABEL_95;
                                }
                                endList = true;
                                i = ((flag) ? 1 : 0);
_L2:
                                if (i >= s.length())
                                {
                                    break; /* Loop/switch isn't completed */
                                }
                                JSONObject jsonobject = s.getJSONObject(i);
                                MixerBoxUtils.addMyItemToArray(array, jsonobject, getActivity(), i, s.length() - i - 1);
                                i++;
                                if (true) goto _L2; else goto _L1
                                s;
                                s.printStackTrace();
_L1:
                                if (array == null || getActivity() == null || f == null)
                                {
                                    llLoading.setVisibility(8);
                                    return;
                                } else
                                {
                                    lv.setAdapter(new VectorAdapter(getActivity(), f, array));
                                    ((ListView)lv.getRefreshableView()).setSelection(params[1].intValue() - params[2].intValue());
                                    llLoading.setVisibility(8);
                                    return;
                                }
                            }

                            _cls1(Context context)
                            {
                                this$2 = _cls1.this;
                                super(context);
                            }
                        }

                        MixerBoxClient.get(MixerBoxClient.getSearchUrl(vectorType, title, params[0].intValue() + 1), null, new _cls1(getActivity()));
                        return;
                    }
                }

            _cls1()
            {
                this$1 = VectorFragment.LoadSearchVectorTask.this;
                params = ainteger;
                super();
            }
            }

            getActivity().runOnUiThread(new _cls1());
            return null;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String[])obj);
    }

    protected void onPostExecute(String as[])
    {
        super.onPostExecute(as);
    }

    private _cls1()
    {
        this$0 = VectorFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
