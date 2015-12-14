// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.AlbumsMetricsHelper;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            PersistentDialogFragment

public class RenameFragment extends PersistentDialogFragment
{
    static class BannedCharsFilter
        implements InputFilter
    {

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
        {
            for (k = i; k < j; k++)
            {
                if (RenameFragment.BANNED_NAME_CHARACTERS.contains(Character.valueOf(charsequence.charAt(k))))
                {
                    spanned = new char[j - i];
                    TextUtils.getChars(charsequence, i, k, spanned, 0);
                    l = 1;
                    k++;
                    while (k < j) 
                    {
                        char c = charsequence.charAt(k);
                        if (RenameFragment.BANNED_NAME_CHARACTERS.contains(Character.valueOf(c)))
                        {
                            l++;
                        } else
                        {
                            spanned[k - i - l] = c;
                        }
                        k++;
                    }
                    if (spanned.length == l)
                    {
                        return "";
                    } else
                    {
                        return new String(spanned, 0, spanned.length - l);
                    }
                }
            }

            return null;
        }

        BannedCharsFilter()
        {
        }
    }

    static class NoSpacePeriodAsFirstCharInputFilter
        implements InputFilter
    {

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
        {
            if (k == 0 && i != j)
            {
                l = 0;
                k = i;
                do
                {
                    if (k >= j)
                    {
                        break;
                    }
                    char c = charsequence.charAt(k);
                    if (c != '.' && c != ' ')
                    {
                        break;
                    }
                    l++;
                    k++;
                } while (true);
                if (j - i == l)
                {
                    return "";
                }
                if (l != 0)
                {
                    return charsequence.subSequence(i + l, j).toString();
                }
            }
            return null;
        }

        NoSpacePeriodAsFirstCharInputFilter()
        {
        }
    }


    public static final List BANNED_NAME_CHARACTERS = Collections.unmodifiableList(Arrays.asList(new Character[] {
        Character.valueOf('/'), Character.valueOf('\\'), Character.valueOf('|'), Character.valueOf('?'), Character.valueOf(':'), Character.valueOf('*'), Character.valueOf('<'), Character.valueOf('>'), Character.valueOf('"')
    }));
    private static final String TAG = com/amazon/gallery/framework/gallery/actions/RenameFragment.getName();
    private CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private DialogManager dialogManager;
    private MediaStoreHelper mediaStoreHelper;
    private ComponentProfiler profiler;
    private volatile boolean success;
    private TagDao tagDao;

    public RenameFragment()
    {
        success = false;
    }

    private Dialog createDialog(final Tag tagToRename)
    {
        Object obj = getActivity();
        View view = View.inflate(((android.content.Context) (obj)), 0x7f0300cd, null);
        final EditText editTextView = (EditText)view.findViewById(0x7f0c01c5);
        editTextView.setText(tagToRename.getLabel());
        editTextView.selectAll();
        editTextView.setFilters(new InputFilter[] {
            new NoSpacePeriodAsFirstCharInputFilter(), new BannedCharsFilter()
        });
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final RenameFragment this$0;
            final EditText val$editTextView;
            final Tag val$tagToRename;

            public void onClick(final DialogInterface context, int i)
            {
                context = getActivity();
                final String newName = editTextView.getText().toString();
                if (newName.length() == 0)
                {
                    Toast.makeText(context, context.getString(0x7f0e012d), 0).show();
                    return;
                } else
                {
                    String s2 = tagToRename.getLabel();
                    tagToRename.setLabel(newName);
                    BlockingSpinnerDialog blockingspinnerdialog = new BlockingSpinnerDialog(context, getRenameRunnable(tagToRename), context.getString(0x7f0e012f));
                    blockingspinnerdialog.setPostExecuteTask(s2. new Runnable() {

                        final _cls1 this$1;
                        final Activity val$context;
                        final String val$newName;
                        final String val$oldName;

                        public void run()
                        {
                            if (success)
                            {
                                Snackbar snackbar = Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e0130, new Object[] {
                                    newName
                                }), 0);
                                snackbar.setAction(0x7f0e01fc, new android.view.View.OnClickListener() {

                                    final _cls1 this$2;

                                    public void onClick(View view)
                                    {
                                        success = false;
                                        tagToRename.setLabel(oldName);
                                        view = new BlockingSpinnerDialog(context, getRenameRunnable(tagToRename), context.getString(0x7f0e012f));
                                        view.setPostExecuteTask(getRenameUndoPostExecutionRunnable(context));
                                        view.execute(new Void[0]);
                                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                });
                                snackbar.show();
                                return;
                            } else
                            {
                                Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e012e, new Object[] {
                                    oldName, newName
                                }), 0).show();
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls1;
                context = activity;
                newName = s;
                oldName = String.this;
                super();
            }
                    });
                    blockingspinnerdialog.execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = RenameFragment.this;
                editTextView = edittext;
                tagToRename = tag;
                super();
            }
        };
        tagToRename = ((Activity) (obj)).getString(0x7f0e0044);
        String s = ((Activity) (obj)).getString(0x7f0e0043);
        String s1 = ((Activity) (obj)).getString(0x7f0e0092);
        obj = dialogManager.createDialog(((Activity) (obj)), s, s1, null, onclicklistener);
        ((AlertDialog) (obj)).setTitle(tagToRename);
        ((AlertDialog) (obj)).setView(view);
        ((AlertDialog) (obj)).setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final RenameFragment this$0;
            final EditText val$editTextView;

            public void onShow(DialogInterface dialoginterface)
            {
                ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(editTextView, 1);
            }

            
            {
                this$0 = RenameFragment.this;
                editTextView = edittext;
                super();
            }
        });
        return ((Dialog) (obj));
    }

    public static RenameFragment getInstance(Tag tag, Profiler profiler1)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("OBJECT_ID", tag.getObjectId());
        tag = new RenameFragment();
        tag.setProfiler(profiler1);
        tag.setArguments(bundle);
        return tag;
    }

    private Runnable getRenameRunnable(final Tag tag)
    {
        return new Runnable() {

            final RenameFragment this$0;
            final Tag val$tag;

            public void run()
            {
                rename(tag);
            }

            
            {
                this$0 = RenameFragment.this;
                tag = tag1;
                super();
            }
        };
    }

    private Runnable getRenameUndoPostExecutionRunnable(final Activity context)
    {
        return new Runnable() {

            final RenameFragment this$0;
            final Activity val$context;

            public void run()
            {
                if (success)
                {
                    Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e01fe), 0).show();
                    return;
                } else
                {
                    Snackbar.make(context.findViewById(0x7f0c0122), context.getString(0x7f0e01fd), 0).show();
                    return;
                }
            }

            
            {
                this$0 = RenameFragment.this;
                context = activity;
                super();
            }
        };
    }

    File createFile(File file, String s)
    {
        return new File(file, s);
    }

    File createFile(String s)
    {
        return new File(s);
    }

    void init(BeanAwareActivity beanawareactivity)
    {
        dialogManager = (DialogManager)getApplicationBean(beanawareactivity, Keys.DIALOG_MANAGER);
        tagDao = (TagDao)getApplicationBean(beanawareactivity, Keys.TAG_DAO);
        mediaStoreHelper = (MediaStoreHelper)getApplicationBean(beanawareactivity, Keys.MEDIA_STORE_HELPER);
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)beanawareactivity.getApplicationBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        init((BeanAwareActivity)activity);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = (ObjectID)getArguments().getSerializable("OBJECT_ID");
        if (bundle != null)
        {
            bundle = tagDao.getTagById(bundle);
            if (bundle != null)
            {
                return createDialog(bundle);
            }
        }
        return null;
    }

    void rename(Tag tag)
    {
        if (tag.hasProperty(TagProperty.CLOUD))
        {
            long l = SystemClock.uptimeMillis();
            try
            {
                UpdateNodeRequest updatenoderequest = new UpdateNodeRequest(IdUtils.objectIdToNodeId(tag.getObjectId().getMostSignificantBits(), tag.getObjectId().getLeastSignificantBits()));
                updatenoderequest.setName(tag.getLabel());
                cloudDriveServiceClientManager.getForegroundCdsClient().updateNode(updatenoderequest);
            }
            // Misplaced declaration of an exception variable
            catch (Tag tag)
            {
                GLogger.ex(TAG, "Unable to update node with new name", tag);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Tag tag)
            {
                GLogger.d(TAG, "Unable to update node with new name - interrupted", new Object[0]);
                Thread.currentThread().interrupt();
                return;
            }
            success = true;
            tagDao.save(tag, true);
            if (profiler != null)
            {
                com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent metricsevent = com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.RenamePhotoAlbum;
                profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, "PhotoAlbumsView"));
                long l1 = SystemClock.uptimeMillis();
                profiler.trackTimer(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.RenamePhotoAlbumTime, l1 - l, AlbumsMetricsHelper.createMetricsExtra(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.RenamePhotoAlbumTime.name(), null, "PhotoAlbumsView"));
            }
        } else
        {
            success = renameLocalAlbum(tag);
        }
        GLogger.v(TAG, "Rename Tag: %s ", new Object[] {
            tag.getLabel()
        });
        GlobalMessagingBus.post(new ActionCompleteEvent());
    }

    boolean renameLocalAlbum(Tag tag)
    {
        Object obj = createFile(tag.getLocalPath());
        File file = createFile(((File) (obj)).getParentFile(), tag.getLabel());
        if (!((File) (obj)).renameTo(file))
        {
            Log.e(TAG, (new StringBuilder()).append("Can't change local dir name on rename request ").append(obj).append(" -> ").append(file).toString());
            return false;
        }
        mediaStoreHelper.updateMediaStorePath(((File) (obj)).getAbsolutePath(), file.getAbsolutePath());
        Map map = mediaStoreHelper.getTagIdByPath(file.getAbsolutePath());
        List list = tagDao.getTagsByPathPrefix(TagType.LOCAL_FOLDER, ((File) (obj)).getAbsolutePath());
        ArrayList arraylist = new ArrayList(list.size());
        int i = ((File) (obj)).getAbsolutePath().length();
        obj = list.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Tag tag1 = (Tag)((Iterator) (obj)).next();
            Object obj1 = tag1.getLocalPath();
            obj1 = (new StringBuilder()).append(file.getAbsolutePath()).append(((String) (obj1)).substring(i)).toString();
            tag1.setLocalPath(((String) (obj1)));
            obj1 = (ObjectID)map.get(obj1);
            if (obj1 != null)
            {
                if (tag1.getObjectId().equals(tag.getObjectId()))
                {
                    tag1.setLabel(tag.getLabel());
                    tag.setLocalPath(file.getAbsolutePath());
                    tag1.setDateCreatedMs((new Date()).getTime());
                }
                tag1.setObjectId(((ObjectID) (obj1)));
                arraylist.add(tag1);
            }
        } while (true);
        tagDao.save(arraylist, true);
        return true;
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, "AlbumsMetrics");
    }





/*
    static boolean access$102(RenameFragment renamefragment, boolean flag)
    {
        renamefragment.success = flag;
        return flag;
    }

*/

}
