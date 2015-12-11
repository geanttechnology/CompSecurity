// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ProgressDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.photomanager.net.UploadPhotoNetLoader;
import com.ebay.mobile.sell.PhotosSpokeFragment;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.shell.app.FwActivity;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerView, PictureUrl, CropPhotoActivity, PhotoManagerViewAdapter

public class PhotoManagerFragment extends BaseFragment
    implements DialogFragmentCallback
{
    private static class EbayInvokeModule
    {

        public static final String STRING_CUSTOM_PICTURE_SET = "customPictureSet";
        public static final String STRING_EXTENSION_IN_DAYS = "extensionInDays";

        private EbayInvokeModule()
        {
        }
    }

    public static interface PhotoManagerHost
    {

        public abstract PhotoManagerViewAdapter getConfigChangeBackupAdapter();

        public abstract void uploadPhoto(UploadPhotoNetLoader uploadphotonetloader);

        public abstract String urlForUploadedPhoto();
    }


    protected static final int DIALOG_NOT_REMOVABLE = 4;
    public static final int DIALOG_SELECT_PHOTO_SOURCE = 1;
    protected static final int DIALOG_SELF_HOSTED_PHOTOS = 2;
    public static final int DIALOG_UNSAVED_CHANGES = 3;
    public static final String EXTRA_MAX_PHOTOS = "maxphotos";
    public static final String EXTRA_PICTURE_URLS = "photourls";
    public static final String EXTRA_PICTURE_URLS_W_STATE = "photourls_w_state";
    public static final String EXTRA_STOCK_PHOTO = "stockphoto";
    public static final String PHOTO_DIALOG_TAG = "photo_dialog";
    public static final String PHOTO_PROGRESS_TAG = "photo_progress";
    private static final int RESULT_PHOTO_FROM_CAMERA = 2;
    private static final int RESULT_PHOTO_FROM_CROP = 3;
    private static final int RESULT_PHOTO_FROM_GALLERY = 1;
    private static final String STATE_CAMERA_IMAGE_URI = "camera_image_uri";
    private static final String STATE_MAX_PHOTOS = "max_photos";
    public static final int UPLOAD_PROGRESS = 100;
    private static final int VERTICAL_SPACING = 10;
    private final String TAG = getClass().getSimpleName();
    protected PhotoManagerViewAdapter adapter;
    private Authentication authentication;
    private Uri cameraImageUri;
    private String customPictureSet;
    protected Uri delayedUploadUri;
    private String extensionInDays;
    protected int maxPhotos;
    protected DataSetObserver observer;
    private ArrayList savedPhotos;
    protected PhotoManagerView view;
    private boolean wasFragmentRetained;

    public PhotoManagerFragment()
    {
        maxPhotos = 0;
        wasFragmentRetained = false;
        savedPhotos = null;
        delayedUploadUri = null;
        observer = new DataSetObserver() {

            final PhotoManagerFragment this$0;

            public void onChanged()
            {
                super.onChanged();
                publishChanges();
            }

            
            {
                this$0 = PhotoManagerFragment.this;
                super();
            }
        };
    }

    private void aquirePhotoDialogClick(int i)
    {
        cameraImageUri = null;
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            try
            {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(Intent.createChooser(intent, getString(0x7f07078e)), 1);
                return;
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                Toast.makeText(getActivity(), 0x7f070780, 1).show();
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Toast.makeText(getActivity(), 0x7f07077e, 1).show();
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                Toast.makeText(getActivity(), 0x7f070780, 1).show();
            }
            return;

        case 0: // '\0'
            break;
        }
        Object obj;
        Object obj1;
        File file;
        boolean flag;
        boolean flag1;
        try
        {
            obj = Environment.getExternalStorageState();
            flag1 = "mounted".equals(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Toast.makeText(getActivity(), 0x7f070780, 1).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Toast.makeText(getActivity(), 0x7f070776, 1).show();
            return;
        }
        catch (IllegalStateException illegalstateexception1)
        {
            Toast.makeText(getActivity(), 0x7f070780, 1).show();
            return;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        flag = true;
        i = 1;
_L5:
        obj = (new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss")).format(new Date()).toString();
        if (i == 0 || !flag) goto _L4; else goto _L3
_L3:
        file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Android/data/com.ebay.mobile/photo/").toString());
        file.mkdirs();
        obj = File.createTempFile(((String) (obj)), "jpg", file);
_L6:
        cameraImageUri = Uri.fromFile(((File) (obj)));
        if (cameraImageUri == null)
        {
            cameraImageUri = getActivity().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        }
_L8:
        obj = new Intent("android.media.action.IMAGE_CAPTURE");
        ((Intent) (obj)).putExtra("output", cameraImageUri);
        startActivityForResult(((Intent) (obj)), 2);
        return;
_L2:
        flag1 = "mounted_ro".equals(obj);
        if (flag1)
        {
            i = 1;
            flag = false;
        } else
        {
            flag = false;
            i = 0;
        }
          goto _L5
_L4:
        obj = File.createTempFile(((String) (obj)), "jpg", getActivity().getCacheDir());
          goto _L6
        obj1;
        Log.e(TAG, (new StringBuilder()).append("IO Exception: ").append(obj1).toString());
        if (cameraImageUri != null) goto _L8; else goto _L7
_L7:
        cameraImageUri = getActivity().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
          goto _L8
        obj1;
        Log.e(TAG, (new StringBuilder()).append("Illegal argument exception: ").append(obj1).toString());
        if (cameraImageUri != null) goto _L8; else goto _L9
_L9:
        cameraImageUri = getActivity().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
          goto _L8
        Exception exception;
        exception;
        if (cameraImageUri == null)
        {
            cameraImageUri = getActivity().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        }
        throw exception;
          goto _L5
    }

    private void createUI()
    {
        view = (PhotoManagerView)getView().findViewById(0x7f1004b1);
        view.setVerticalSpacing(10);
        view.setFragment(this);
    }

    public static void hideProgress(Activity activity)
    {
        android.app.Fragment fragment = activity.getFragmentManager().findFragmentByTag("photo_progress");
        if (fragment != null)
        {
            activity.getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    private DialogFragment onCreateDialogFragment(int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder2;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            String s = getString(0x7f07077c);
            String s1 = getString(0x7f07077d);
            com.ebay.app.AlertDialogFragment.Builder builder3 = new com.ebay.app.AlertDialogFragment.Builder();
            builder3.setTitle(getString(0x7f0709ec));
            builder3.setItems(new String[] {
                s, s1
            });
            return builder3.createFromFragment(i, this);

        case 2: // '\002'
            com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
            builder.setTitle(getString(0x7f070775));
            builder.setMessage(getString(0x7f070777));
            builder.setPositiveButton(0x104000a);
            return builder.createFromFragment(i, this);

        case 3: // '\003'
            com.ebay.app.AlertDialogFragment.Builder builder1 = new com.ebay.app.AlertDialogFragment.Builder();
            builder1.setTitle(getString(0x7f07077b));
            builder1.setMessage(getString(0x7f07077a));
            builder1.setPositiveButton(0x7f070792);
            builder1.setNegativeButton(0x7f07078a);
            return builder1.createFromFragment(i, this);

        case 4: // '\004'
            builder2 = new com.ebay.app.AlertDialogFragment.Builder();
            break;
        }
        builder2.setMessage(getString(0x7f070778));
        builder2.setPositiveButton(0x104000a);
        return builder2.createFromFragment(i, this);
    }

    private void removeCameraImageFile()
    {
        final String filePath = cameraImageUri.getPath();
        cameraImageUri = null;
        (new Thread(new Runnable() {

            final PhotoManagerFragment this$0;
            final String val$filePath;

            public void run()
            {
                (new File(filePath)).delete();
            }

            
            {
                this$0 = PhotoManagerFragment.this;
                filePath = s;
                super();
            }
        })).start();
    }

    private static void showProgress(Activity activity)
    {
        ProgressDialogFragment progressdialogfragment = new ProgressDialogFragment();
        progressdialogfragment.title = "";
        progressdialogfragment.message = activity.getString(0x7f070789);
        progressdialogfragment.setTargetFragment(null, 100);
        progressdialogfragment.show(activity.getFragmentManager(), "photo_progress");
    }

    protected int getMaxAllowedPhotos()
    {
        return maxPhotos;
    }

    protected List getPictureUrls()
    {
        ArrayList arraylist;
label0:
        {
label1:
            {
                ArrayList arraylist1 = new ArrayList();
                ArrayList arraylist2 = new ArrayList();
                if (savedPhotos != null)
                {
                    for (Iterator iterator = savedPhotos.iterator(); iterator.hasNext(); arraylist2.add((String)iterator.next())) { }
                }
                if (getActivity().getIntent().hasExtra("photourls"))
                {
                    Iterator iterator2 = getActivity().getIntent().getStringArrayListExtra("photourls").iterator();
                    do
                    {
                        arraylist = arraylist1;
                        if (!iterator2.hasNext())
                        {
                            break;
                        }
                        arraylist2.add((String)iterator2.next());
                    } while (true);
                } else
                {
                    if (!getActivity().getIntent().hasExtra("photourls_w_state"))
                    {
                        break label1;
                    }
                    arraylist = getActivity().getIntent().getParcelableArrayListExtra("photourls_w_state");
                }
                for (Iterator iterator1 = (new ArrayList(new HashSet(arraylist2))).iterator(); iterator1.hasNext(); arraylist.add(new PictureUrl((String)iterator1.next(), true, false))) { }
                break label0;
            }
            throw new IllegalArgumentException("PhotoManager's photourls or photourls_w_state must be set");
        }
        return arraylist;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        createUI();
        if (savedPhotos == null && bundle != null)
        {
            savedPhotos = bundle.getStringArrayList("photourls");
        }
        if (!wasFragmentRetained)
        {
            wasFragmentRetained = true;
            authentication = MyApp.getPrefs().getAuthentication();
            cameraImageUri = null;
            customPictureSet = getActivity().getIntent().getStringExtra("customPictureSet");
            extensionInDays = getActivity().getIntent().getStringExtra("extensionInDays");
            if (bundle != null)
            {
                maxPhotos = bundle.getInt("max_photos");
                cameraImageUri = (Uri)bundle.getParcelable("camera_image_uri");
                customPictureSet = bundle.getString("customPictureSet");
                extensionInDays = bundle.getString("extensionInDays");
            } else
            {
                if (getActivity().getIntent().hasExtra("maxphotos"))
                {
                    maxPhotos = getActivity().getIntent().getIntExtra("maxphotos", 0);
                }
                customPictureSet = getActivity().getIntent().getStringExtra("customPictureSet");
                extensionInDays = getActivity().getIntent().getStringExtra("extensionInDays");
            }
            bundle = getActivity().getFragmentManager().findFragmentByTag("photo_dialog");
            if (bundle != null)
            {
                getActivity().getFragmentManager().beginTransaction().remove(bundle).commitAllowingStateLoss();
            }
        }
    }

    protected void onActivityResultSafe(int i, int j, Intent intent)
    {
        if (j != -1)
        {
            if (cameraImageUri != null)
            {
                removeCameraImageFile();
            }
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            Intent intent1 = new Intent(getActivity(), com/ebay/mobile/photomanager/CropPhotoActivity);
            intent1.setData(intent.getData());
            startActivityForResult(intent1, 3);
            return;

        case 2: // '\002'
            Intent intent2 = new Intent(getActivity(), com/ebay/mobile/photomanager/CropPhotoActivity);
            if (intent != null && intent.getData() != null)
            {
                intent2.setData(intent.getData());
            } else
            {
                intent2.setData(cameraImageUri);
            }
            startActivityForResult(intent2, 3);
            return;

        case 3: // '\003'
            break;
        }
        if (adapter != null)
        {
            uploadPhoto(intent.getData());
            return;
        } else
        {
            delayedUploadUri = intent.getData();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f0301a0, null);
        layoutinflater.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        layoutinflater.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhotoManagerFragment this$0;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = PhotoManagerFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        while (getActivity() == null || i != 1) 
        {
            return;
        }
        aquirePhotoDialogClick(j);
    }

    public void onResume()
    {
        PhotoManagerViewAdapter photomanagerviewadapter;
        super.onResume();
        photomanagerviewadapter = ((PhotoManagerHost)getActivity()).getConfigChangeBackupAdapter();
        if (photomanagerviewadapter == null) goto _L2; else goto _L1
_L1:
        adapter = photomanagerviewadapter;
        adapter.registerDataSetObserver(observer);
        view.setAdapter(adapter);
        onUploadComplete();
_L4:
        if (getMaxAllowedPhotos() <= 0)
        {
            Log.w(TAG, "PhotoManager's maxPhotos is less than or equal to zero");
        }
        return;
_L2:
        if (adapter == null && !(this instanceof PhotosSpokeFragment))
        {
            adapter = new PhotoManagerViewAdapter(getActivity(), getPictureUrls(), maxPhotos, 0);
            adapter.registerDataSetObserver(observer);
            view.setAdapter(adapter);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("max_photos", maxPhotos);
        bundle.putParcelable("camera_image_uri", cameraImageUri);
        if (customPictureSet != null)
        {
            bundle.putString("customPictureSet", customPictureSet);
        }
        if (extensionInDays != null)
        {
            bundle.putString("extensionInDays", extensionInDays);
        }
        if (adapter != null)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = adapter.getUrls().iterator(); iterator.hasNext(); arraylist.add(((PictureUrl)iterator.next()).url)) { }
            bundle.putStringArrayList("photourls", arraylist);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onUploadCanceled()
    {
        if (cameraImageUri != null)
        {
            removeCameraImageFile();
        }
    }

    public void onUploadComplete()
    {
        String s = ((PhotoManagerHost)getActivity()).urlForUploadedPhoto();
        if (s != null)
        {
            if (cameraImageUri != null)
            {
                removeCameraImageFile();
            }
            adapter.addAfterUpload(s);
            view.invalidateViews();
            publishChanges();
        }
    }

    protected void publishChanges()
    {
        if (adapter != null && adapter.modified())
        {
            Object obj = adapter.getUrls();
            ArrayList arraylist = null;
            String s = arraylist;
            if (((ArrayList) (obj)).size() > 0)
            {
                s = arraylist;
                if (((PictureUrl)((ArrayList) (obj)).get(0)).stockPhoto)
                {
                    s = ((PictureUrl)((ArrayList) (obj)).remove(0)).url;
                }
            }
            arraylist = new ArrayList();
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((PictureUrl)((Iterator) (obj)).next()).url)) { }
            if (savedPhotos != null)
            {
                for (obj = savedPhotos.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((String)((Iterator) (obj)).next())) { }
            }
            arraylist = new ArrayList(new HashSet(arraylist));
            obj = new Intent();
            ((Intent) (obj)).putExtra("photourls", arraylist);
            ((Intent) (obj)).putExtra("stockphoto", s);
            getActivity().setResult(-1, ((Intent) (obj)));
        }
    }

    public PhotoManagerViewAdapter removeAdapter()
    {
        PhotoManagerViewAdapter photomanagerviewadapter = adapter;
        adapter = null;
        view.setAdapter(null);
        if (photomanagerviewadapter != null)
        {
            photomanagerviewadapter.unregisterDataSetObserver(observer);
        }
        return photomanagerviewadapter;
    }

    protected void showDialog(int i)
    {
        DialogFragment dialogfragment = onCreateDialogFragment(i);
        if (dialogfragment != null)
        {
            dialogfragment.show(getFragmentManager(), "photo_dialog");
        }
    }

    protected void uploadPhoto(Uri uri)
    {
        if (uri != null)
        {
            showProgress(getActivity());
            Object obj;
            if (this instanceof PhotosSpokeFragment)
            {
                obj = ((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params")).draftSite;
            } else
            {
                obj = MyApp.getPrefs().getCurrentSite();
            }
            obj = EbayApiUtil.getTradingApi(((com.ebay.nautilus.domain.EbaySite) (obj)), getActivity(), authentication);
            uri = new UploadPhotoNetLoader(getFwActivity().getEbayContext(), getActivity().getContentResolver(), uri, ((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), customPictureSet, extensionInDays);
            ((PhotoManagerHost)getActivity()).uploadPhoto(uri);
        }
    }
}
