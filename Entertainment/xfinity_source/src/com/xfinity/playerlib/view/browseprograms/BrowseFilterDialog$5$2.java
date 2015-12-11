// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.FragmentManager;
import android.content.DialogInterface;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterDialog, BrowseFilterCategoriesPanel, DibicProgramFilter

class this._cls1
    implements android.content.lListener
{

    final is._cls0 this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        BrowseFilterDialog.access$300(_fld0);
    }

    istener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5

/* anonymous class */
    class BrowseFilterDialog._cls5 extends DefaultTaskExecutionListener
    {

        final BrowseFilterDialog this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            taskexecutionexception = BrowseFilterDialog.access$400(BrowseFilterDialog.this).createErrorDialogForThrowable(taskexecutionexception, new BrowseFilterDialog._cls5._cls1());
            taskexecutionexception.setOnCancelListener(new BrowseFilterDialog._cls5._cls2());
            taskexecutionexception.show(getFragmentManager(), "caldialogfragment");
        }

        public void onPostExecute(TagsRoot tagsroot)
        {
            tagsRoot = tagsroot;
            DibicProgramFilter dibicprogramfilter = getPendingFilter();
            BrowseFilterCategoriesPanel browsefiltercategoriespanel = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
            if (browsefiltercategoriespanel != null)
            {
                browsefiltercategoriespanel.initializeCategoriesList(tagsroot, dibicprogramfilter, category);
                browsefiltercategoriespanel.updateDownloadableCheckbox(dibicprogramfilter.isDownloadableOn());
                browsefiltercategoriespanel.updateHideLockedCheckbox(dibicprogramfilter.isHideLockOn());
                if (isDualPanel)
                {
                    dibicprogramfilter.registerOnChangeListener(browsefiltercategoriespanel.getFilterChangeListener());
                }
            }
            BrowseFilterDialog.access$300(BrowseFilterDialog.this);
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((TagsRoot)obj);
        }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1

/* anonymous class */
        class BrowseFilterDialog._cls5._cls1
            implements com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener
        {

            final BrowseFilterDialog._cls5 this$1;

            public void tryAgain()
            {
                initialize();
            }

                    
                    {
                        this$1 = BrowseFilterDialog._cls5.this;
                        super();
                    }
        }

    }

}
