// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.preference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

// Referenced classes of package android.support.v4.preference:
//            PreferenceManagerCompat

public abstract class PreferenceFragment extends Fragment
    implements PreferenceManagerCompat.OnPreferenceTreeClickListener
{
    public static interface OnPreferenceStartFragmentCallback
    {

        public abstract boolean onPreferenceStartFragment(PreferenceFragment preferencefragment, Preference preference);
    }


    private static final int FIRST_REQUEST_CODE = 100;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private Handler mHandler;
    private boolean mHavePrefs;
    private boolean mInitDone;
    private ListView mList;
    private android.view.View.OnKeyListener mListOnKeyListener;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {

        final PreferenceFragment this$0;

        public void run()
        {
            mList.focusableViewAvailable(mList);
        }

            
            {
                this$0 = PreferenceFragment.this;
                super();
            }
    };

    public PreferenceFragment()
    {
        mHandler = new Handler() {

            final PreferenceFragment this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    bindPreferences();
                    break;
                }
            }

            
            {
                this$0 = PreferenceFragment.this;
                super();
            }
        };
        mListOnKeyListener = new android.view.View.OnKeyListener() {

            final PreferenceFragment this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (mList.getSelectedItem() instanceof Preference)
                {
                    mList.getSelectedView();
                }
                return false;
            }

            
            {
                this$0 = PreferenceFragment.this;
                super();
            }
        };
    }

    private void bindPreferences()
    {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if (preferencescreen != null)
        {
            preferencescreen.bind(getListView());
        }
    }

    private void ensureList()
    {
        if (mList != null)
        {
            return;
        }
        View view = getView();
        if (view == null)
        {
            throw new IllegalStateException("Content view not yet created");
        }
        view = view.findViewById(0x102000a);
        if (!(view instanceof ListView))
        {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        mList = (ListView)view;
        if (mList == null)
        {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        } else
        {
            mList.setOnKeyListener(mListOnKeyListener);
            mHandler.post(mRequestFocus);
            return;
        }
    }

    private void postBindPreferences()
    {
        if (mHandler.hasMessages(1))
        {
            return;
        } else
        {
            mHandler.obtainMessage(1).sendToTarget();
            return;
        }
    }

    private void requirePreferenceManager()
    {
        if (mPreferenceManager == null)
        {
            throw new RuntimeException("This should be called after super.onCreate.");
        } else
        {
            return;
        }
    }

    public void addPreferencesFromIntent(Intent intent)
    {
        requirePreferenceManager();
        setPreferenceScreen(PreferenceManagerCompat.inflateFromIntent(mPreferenceManager, intent, getPreferenceScreen()));
    }

    public void addPreferencesFromResource(int i)
    {
        requirePreferenceManager();
        setPreferenceScreen(PreferenceManagerCompat.inflateFromResource(mPreferenceManager, getActivity(), i, getPreferenceScreen()));
    }

    public Preference findPreference(CharSequence charsequence)
    {
        if (mPreferenceManager == null)
        {
            return null;
        } else
        {
            return mPreferenceManager.findPreference(charsequence);
        }
    }

    public ListView getListView()
    {
        ensureList();
        return mList;
    }

    public PreferenceManager getPreferenceManager()
    {
        return mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen()
    {
        return PreferenceManagerCompat.getPreferenceScreen(mPreferenceManager);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mHavePrefs)
        {
            bindPreferences();
        }
        mInitDone = true;
        if (bundle != null)
        {
            bundle = bundle.getBundle("android:preferences");
            if (bundle != null)
            {
                PreferenceScreen preferencescreen = getPreferenceScreen();
                if (preferencescreen != null)
                {
                    preferencescreen.restoreHierarchyState(bundle);
                }
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        PreferenceManagerCompat.dispatchActivityResult(mPreferenceManager, i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPreferenceManager = PreferenceManagerCompat.newInstance(getActivity(), 100);
        PreferenceManagerCompat.setFragment(mPreferenceManager, this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(android.support.v4.preferencefragment.R.layout.preference_list_fragment, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        PreferenceManagerCompat.dispatchActivityDestroy(mPreferenceManager);
    }

    public void onDestroyView()
    {
        mList = null;
        mHandler.removeCallbacks(mRequestFocus);
        mHandler.removeMessages(1);
        super.onDestroyView();
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference)
    {
        if (getActivity() instanceof OnPreferenceStartFragmentCallback)
        {
            return ((OnPreferenceStartFragmentCallback)getActivity()).onPreferenceStartFragment(this, preference);
        } else
        {
            return false;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if (preferencescreen != null)
        {
            Bundle bundle1 = new Bundle();
            preferencescreen.saveHierarchyState(bundle1);
            bundle.putBundle("android:preferences", bundle1);
        }
    }

    public void onStart()
    {
        super.onStart();
        PreferenceManagerCompat.setOnPreferenceTreeClickListener(mPreferenceManager, this);
    }

    public void onStop()
    {
        super.onStop();
        PreferenceManagerCompat.dispatchActivityStop(mPreferenceManager);
        PreferenceManagerCompat.setOnPreferenceTreeClickListener(mPreferenceManager, null);
    }

    public void setPreferenceScreen(PreferenceScreen preferencescreen)
    {
        if (PreferenceManagerCompat.setPreferences(mPreferenceManager, preferencescreen) && preferencescreen != null)
        {
            mHavePrefs = true;
            if (mInitDone)
            {
                postBindPreferences();
            }
        }
    }


}
