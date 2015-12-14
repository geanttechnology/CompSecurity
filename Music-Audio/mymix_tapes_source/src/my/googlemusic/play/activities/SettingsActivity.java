// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.soundcloud.android.crop.Crop;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.io.IOException;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogPremiumUser;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;
import my.googlemusic.play.utils.views.RobotoEditText;
import my.googlemusic.play.utils.views.RobotoTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            BadgeActivity

public class SettingsActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemSelectedListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.view.View.OnFocusChangeListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, TextWatcher
{
    private static class ViewHolder
    {

        private RelativeLayout adView;
        private AppBar appBar;
        private ImageButton btnBadge;
        private ImageButton btnBio;
        private ImageButton btnEmail;
        private ImageButton btnInstagram;
        private ImageButton btnLogout;
        private ImageButton btnName;
        private ImageButton btnPassword;
        private ImageButton btnPicture;
        private ImageButton btnUser;
        private ImageView imgBadge;
        private ImageView imgPicture;
        private Spinner spnDownload;
        private Spinner spnStreaming;
        private TextView txtBio;
        private TextView txtEmail;
        private TextView txtInstagram;
        private TextView txtName;
        private TextView txtPassword;
        private TextView txtUser;



/*
        static RelativeLayout access$002(ViewHolder viewholder, RelativeLayout relativelayout)
        {
            viewholder.adView = relativelayout;
            return relativelayout;
        }

*/




/*
        static ImageButton access$1002(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnEmail = imagebutton;
            return imagebutton;
        }

*/


/*
        static ImageView access$102(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.imgBadge = imageview;
            return imageview;
        }

*/



/*
        static ImageButton access$1102(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnBadge = imagebutton;
            return imagebutton;
        }

*/



/*
        static ImageButton access$1202(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnLogout = imagebutton;
            return imagebutton;
        }

*/



/*
        static ImageButton access$1302(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnPicture = imagebutton;
            return imagebutton;
        }

*/



/*
        static TextView access$1402(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtPassword = textview;
            return textview;
        }

*/



/*
        static TextView access$1502(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtInstagram = textview;
            return textview;
        }

*/



/*
        static ImageButton access$1602(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnPassword = imagebutton;
            return imagebutton;
        }

*/



/*
        static ImageView access$1702(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.imgPicture = imageview;
            return imageview;
        }

*/



/*
        static ImageButton access$1802(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnInstagram = imagebutton;
            return imagebutton;
        }

*/



/*
        static Spinner access$1902(ViewHolder viewholder, Spinner spinner)
        {
            viewholder.spnDownload = spinner;
            return spinner;
        }

*/



/*
        static Spinner access$2002(ViewHolder viewholder, Spinner spinner)
        {
            viewholder.spnStreaming = spinner;
            return spinner;
        }

*/


/*
        static AppBar access$2102(ViewHolder viewholder, AppBar appbar)
        {
            viewholder.appBar = appbar;
            return appbar;
        }

*/



/*
        static TextView access$302(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtBio = textview;
            return textview;
        }

*/



/*
        static ImageButton access$402(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnBio = imagebutton;
            return imagebutton;
        }

*/



/*
        static TextView access$502(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtName = textview;
            return textview;
        }

*/



/*
        static ImageButton access$602(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnName = imagebutton;
            return imagebutton;
        }

*/



/*
        static ImageButton access$702(ViewHolder viewholder, ImageButton imagebutton)
        {
            viewholder.btnUser = imagebutton;
            return imagebutton;
        }

*/



/*
        static TextView access$802(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtEmail = textview;
            return textview;
        }

*/



/*
        static TextView access$902(ViewHolder viewholder, TextView textview)
        {
            viewholder.txtUser = textview;
            return textview;
        }

*/

        private ViewHolder()
        {
        }

    }

    private static class ViewHolderDialog
    {

        EditText changeField;
        TextView txtTitleName;

        private ViewHolderDialog()
        {
        }

    }

    private static class ViewHolderDialogButton
    {

        RobotoTextView cancel;
        RobotoTextView save;

        private ViewHolderDialogButton()
        {
        }

    }

    private static class ViewHolderDialogName
    {

        EditText changeLastName;
        EditText changeName;
        View lineLastName;
        View lineName;
        TextView txtTitleName;

        private ViewHolderDialogName()
        {
        }

    }

    private static class ViewHolderDialogPassword
    {

        RobotoEditText changeConfirmNew;
        RobotoEditText changeNew;
        RobotoEditText changeOld;
        View lineConfirm;
        View lineNew;
        View lineOld;
        TextView txtTitleName;

        private ViewHolderDialogPassword()
        {
        }

    }


    static final boolean $assertionsDisabled;
    private static int REQUEST_PICTURE = 1;
    private final int EDIT_BIO = 5;
    private final int EDIT_EMAIL = 2;
    private final int EDIT_INSTAGRAM = 4;
    private final int EDIT_NAME = 0;
    private final int EDIT_PASSWORD = 3;
    private final int EDIT_USERNAME = 1;
    private final int PICK_FROM_GALLERY = 1;
    private final int QUALITY_HIGHT = 5;
    private final int QUALITY_LOW = 0;
    private final int QUALITY_MEDIUM = 3;
    private int currentType;
    private Connection mConnection;
    private ConnectionResult mConnectionResult;
    private int mCurrentQualityDownload;
    private int mCurrentQualityStream;
    private Dialog mDialog;
    private GoogleApiClient mGoogleApiClient;
    private ViewHolder mHolder;
    private ViewHolderDialog mHolderDialog;
    private ViewHolderDialogButton mHolderDialogButton;
    private ViewHolderDialogName mHolderDialogName;
    private ViewHolderDialogPassword mHolderDialogPassword;
    private boolean mIntentInProgress;
    private Server mServer;
    private User mUser;

    public SettingsActivity()
    {
    }

    private void changeBio()
    {
        Editable editable = mHolderDialog.changeField.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().length() == 0)
        {
            Toast.with(this).message("The biography field can't be empty.").show();
            return;
        } else
        {
            mServer.changeBio(editable.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        initData();
                        mHolder.txtBio.setText(mUser.getBio());
                        mDialog.cancel();
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void changeEmail()
    {
        Editable editable = mHolderDialog.changeField.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().length() == 0)
        {
            Toast.with(this).message("The email field can't be empty.").show();
            return;
        }
        if (!editable.toString().contains("@") || !editable.toString().contains("."))
        {
            Toast.with(this).message("Format email invalid.").show();
            return;
        } else
        {
            mServer.changeEmail(editable.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        initData();
                        mHolder.txtEmail.setText(mUser.getEmail());
                        mDialog.cancel();
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void changeInstagram()
    {
        Editable editable = mHolderDialog.changeField.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().length() == 0)
        {
            Toast.with(this).message("The instagram field can't be empty.").show();
            return;
        } else
        {
            mServer.changeInstagram(editable.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        initData();
                        mHolder.txtInstagram.setText(mUser.getInstagram());
                        mDialog.cancel();
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void changeName()
    {
        Editable editable = mHolderDialogName.changeName.getText();
        Editable editable1 = mHolderDialogName.changeLastName.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && editable1 == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().length() == 0)
        {
            Toast.with(this).message("The name field can't be empty.").show();
            return;
        } else
        {
            mServer.changeName(editable.toString(), editable1.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        initData();
                        mHolder.txtName.setText((new StringBuilder()).append(mUser.getName()).append(" ").append(mUser.getLastName()).toString());
                        mDialog.cancel();
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void changePassword()
    {
        Editable editable = mHolderDialogPassword.changeOld.getText();
        Editable editable1 = mHolderDialogPassword.changeNew.getText();
        Editable editable2 = mHolderDialogPassword.changeConfirmNew.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && editable1 == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && editable2 == null)
        {
            throw new AssertionError();
        }
        if (!editable1.toString().equals(editable2.toString()))
        {
            Toast.with(this).message("New passwords don't match.").show();
            return;
        }
        if (editable1.toString().length() < 6)
        {
            Toast.with(this).message("The password must have at least 6 characters.").show();
            return;
        } else
        {
            mServer.changePassword(editable.toString(), editable1.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        mDialog.cancel();
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void changeUsername()
    {
        Editable editable = mHolderDialog.changeField.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().length() == 0)
        {
            Toast.with(this).message("The username field can't be empty.").show();
            return;
        } else
        {
            mServer.changeUsername(editable.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final SettingsActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(SettingsActivity.this).message(response.getContent()).show();
                    }
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(SettingsActivity.this).message(obj.toString()).show();
                        initData();
                        mHolder.txtUser.setText(mUser.getUsername());
                        mDialog.cancel();
                        setResult(13000);
                    }
                }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        mConnection = Connection.with(this);
        mServer = ((App)getApplication()).getServer();
        mUser = mServer.getUser();
        mGoogleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(this)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).build();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        mHolder.txtBio = (TextView)findViewById(0x7f0d0161);
        mHolder.btnBio = (ImageButton)findViewById(0x7f0d015f);
        mHolder.txtName = (TextView)findViewById(0x7f0d015b);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d014f);
        mHolder.btnName = (ImageButton)findViewById(0x7f0d0159);
        mHolder.btnUser = (ImageButton)findViewById(0x7f0d015c);
        mHolder.txtEmail = (TextView)findViewById(0x7f0d0167);
        mHolder.txtUser = (TextView)findViewById(0x7f0d015e);
        mHolder.btnEmail = (ImageButton)findViewById(0x7f0d0165);
        mHolder.btnBadge = (ImageButton)findViewById(0x7f0d0155);
        mHolder.imgBadge = (ImageView)findViewById(0x7f0d0156);
        mHolder.btnLogout = (ImageButton)findViewById(0x7f0d0174);
        mHolder.btnPicture = (ImageButton)findViewById(0x7f0d0151);
        mHolder.txtPassword = (TextView)findViewById(0x7f0d016a);
        mHolder.txtInstagram = (TextView)findViewById(0x7f0d0164);
        mHolder.btnPassword = (ImageButton)findViewById(0x7f0d0168);
        mHolder.imgPicture = (ImageView)findViewById(0x7f0d0152);
        mHolder.btnInstagram = (ImageButton)findViewById(0x7f0d0162);
        mHolder.spnDownload = (Spinner)findViewById(0x7f0d0173);
        mHolder.spnStreaming = (Spinner)findViewById(0x7f0d016f);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Settings").back();
        TextView textview = mHolder.txtName;
        StringBuilder stringbuilder = (new StringBuilder()).append(mUser.getName()).append(" ");
        Object obj;
        if (mUser.getLastName().equals("null"))
        {
            obj = "";
        } else
        {
            obj = mUser.getLastName();
        }
        textview.setText(stringbuilder.append(((String) (obj))).toString());
        mHolder.txtUser.setText(mUser.getUsername());
        mHolder.txtEmail.setText(mUser.getEmail());
        textview = mHolder.txtBio;
        if (mUser.getBio().equals("null"))
        {
            obj = "";
        } else
        {
            obj = mUser.getBio();
        }
        textview.setText(((CharSequence) (obj)));
        textview = mHolder.txtInstagram;
        if (mUser.getInstagram().equals("null"))
        {
            obj = "";
        } else
        {
            obj = mUser.getInstagram();
        }
        textview.setText(((CharSequence) (obj)));
        mHolder.btnBio.setOnClickListener(this);
        mHolder.btnName.setOnClickListener(this);
        mHolder.btnUser.setOnClickListener(this);
        mHolder.btnBadge.setOnClickListener(this);
        mHolder.btnEmail.setOnClickListener(this);
        mHolder.btnLogout.setOnClickListener(this);
        mHolder.btnPicture.setOnClickListener(this);
        mHolder.btnPassword.setOnClickListener(this);
        mHolder.btnInstagram.setOnClickListener(this);
        obj = ArrayAdapter.createFromResource(this, 0x7f0b0003, 0x1090008);
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x1090009);
        mHolder.spnStreaming.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        mHolder.spnStreaming.setSelection(mServer.getStreamQuality());
        mHolder.spnStreaming.setOnItemSelectedListener(this);
        obj = ArrayAdapter.createFromResource(this, 0x7f0b0000, 0x1090008);
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x1090009);
        mHolder.spnDownload.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        mHolder.spnDownload.setSelection(mServer.getDownloadQuality());
        mHolder.spnDownload.setOnItemSelectedListener(this);
        Picasso.with(this).load(mServer.getLinkUserImage(mUser.getId())).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().error(0x1080078).into(mHolder.imgPicture);
    }

    private void logout()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, 0x7f0800e7));
        builder.setMessage("Are you sure?").setPositiveButton("Log Out", new android.content.DialogInterface.OnClickListener() {

            final SettingsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
                if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
                {
                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                    mGoogleApiClient.disconnect();
                    mGoogleApiClient.connect();
                    Toast.with(SettingsActivity.this).message("Logout from google plus").show();
                }
                mServer.logout();
                setResult(10000);
                finish();
            }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
        }).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final SettingsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    private void replaceInvalidCharacters(CharSequence charsequence, int i, String s)
    {
        if (charsequence.toString().contains(s))
        {
            charsequence = charsequence.toString().replace(s, "");
            mHolderDialog.changeField.setText(charsequence);
            mHolderDialog.changeField.setSelection(i);
        }
    }

    private void setQuality(AdapterView adapterview, int i)
    {
        mUser = mServer.getUser();
        if (adapterview == mHolder.spnStreaming)
        {
            if (mUser.getStreamQuality() != i)
            {
                mServer.setStreamQuality(i);
            }
        } else
        if (adapterview == mHolder.spnDownload && mUser.getDownloadQuality() != i)
        {
            mServer.setDownloadQuality(i);
            return;
        }
    }

    private void setSelection(AdapterView adapterview)
    {
        if (!Connection.with(this).isConnected())
        {
            Toast.with(this).message("Offline").show();
        } else
        {
            if (adapterview.getId() == mHolder.spnStreaming.getId())
            {
                mHolder.spnStreaming.setSelection(mCurrentQualityStream);
                return;
            }
            if (adapterview.getId() == mHolder.spnDownload.getId())
            {
                mHolder.spnDownload.setSelection(mCurrentQualityDownload);
                return;
            }
        }
    }

    private void userPicture()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select picture"), REQUEST_PICTURE);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void customDialogEdit(String s, int i)
    {
        Object obj;
        android.app.AlertDialog.Builder builder;
        builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, 0x7f0800e7));
        obj = getLayoutInflater();
        currentType = i;
        if (i != 3) goto _L2; else goto _L1
_L1:
        obj = ((LayoutInflater) (obj)).inflate(0x7f03004f, null);
        if (!$assertionsDisabled && obj == null)
        {
            throw new AssertionError();
        }
        mHolderDialogPassword = new ViewHolderDialogPassword();
        mHolderDialogPassword.lineNew = ((View) (obj)).findViewById(0x7f0d01c3);
        mHolderDialogPassword.lineOld = ((View) (obj)).findViewById(0x7f0d01c1);
        mHolderDialogPassword.txtTitleName = (TextView)((View) (obj)).findViewById(0x7f0d01bf);
        mHolderDialogPassword.lineConfirm = ((View) (obj)).findViewById(0x7f0d01c5);
        mHolderDialogPassword.changeOld = (RobotoEditText)((View) (obj)).findViewById(0x7f0d01c0);
        mHolderDialogPassword.changeNew = (RobotoEditText)((View) (obj)).findViewById(0x7f0d01c2);
        mHolderDialogPassword.changeConfirmNew = (RobotoEditText)((View) (obj)).findViewById(0x7f0d01c4);
        mHolderDialogPassword.changeOld.setText("");
        mHolderDialogPassword.changeNew.setText("");
        mHolderDialogPassword.changeConfirmNew.setText("");
        mHolderDialogPassword.txtTitleName.setText(s);
        mHolderDialogPassword.changeOld.setOnFocusChangeListener(this);
        mHolderDialogPassword.changeNew.setOnFocusChangeListener(this);
        mHolderDialogPassword.changeConfirmNew.setOnFocusChangeListener(this);
        s = ((String) (obj));
_L4:
        mHolderDialogButton = new ViewHolderDialogButton();
        mHolderDialogButton.save = (RobotoTextView)s.findViewById(0x7f0d0199);
        mHolderDialogButton.cancel = (RobotoTextView)s.findViewById(0x7f0d0198);
        mHolderDialogButton.save.setOnClickListener(this);
        mHolderDialogButton.cancel.setOnClickListener(this);
        builder.setView(s);
        mDialog = builder.create();
        mDialog.show();
        return;
_L2:
        if (i == 2 || i == 1 || i == 4 || i == 5)
        {
            obj = ((LayoutInflater) (obj)).inflate(0x7f03004d, null);
            if (!$assertionsDisabled && obj == null)
            {
                throw new AssertionError();
            }
            mHolderDialog = new ViewHolderDialog();
            mHolderDialog.txtTitleName = (TextView)((View) (obj)).findViewById(0x7f0d01b8);
            mHolderDialog.changeField = (EditText)((View) (obj)).findViewById(0x7f0d01b9);
            mHolderDialog.txtTitleName.setText(s);
            if (i == 1)
            {
                mHolderDialog.changeField.setText(mUser.getUsername());
                mHolderDialog.changeField.setHint("Username");
                mHolderDialog.changeField.addTextChangedListener(this);
                s = ((String) (obj));
            } else
            if (i == 2)
            {
                mHolderDialog.changeField.setText(mUser.getEmail());
                mHolderDialog.changeField.setHint("Email");
                s = ((String) (obj));
            } else
            if (i == 4)
            {
                mHolderDialog.changeField.setText(mUser.getInstagram());
                mHolderDialog.changeField.setHint("Instagram");
                s = ((String) (obj));
            } else
            {
                s = ((String) (obj));
                if (i == 5)
                {
                    mHolderDialog.changeField.setText(mUser.getBio());
                    mHolderDialog.changeField.setHint("Biography");
                    s = ((String) (obj));
                }
            }
        } else
        {
            obj = ((LayoutInflater) (obj)).inflate(0x7f03004e, null);
            if (!$assertionsDisabled && obj == null)
            {
                throw new AssertionError();
            }
            mHolderDialogName = new ViewHolderDialogName();
            mHolderDialogName.lineName = ((View) (obj)).findViewById(0x7f0d01bc);
            mHolderDialogName.txtTitleName = (TextView)((View) (obj)).findViewById(0x7f0d01b8);
            mHolderDialogName.changeName = (EditText)((View) (obj)).findViewById(0x7f0d01bb);
            mHolderDialogName.lineLastName = ((View) (obj)).findViewById(0x7f0d01be);
            mHolderDialogName.changeLastName = (EditText)((View) (obj)).findViewById(0x7f0d01bd);
            mHolderDialogName.txtTitleName.setText(s);
            mHolderDialogName.changeName.setText(mUser.getName());
            mHolderDialogName.changeLastName.setText(mUser.getLastName());
            mHolderDialogName.changeName.setOnFocusChangeListener(this);
            mHolderDialogName.changeLastName.setOnFocusChangeListener(this);
            s = ((String) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Object obj = new File(getFilesDir(), "test.jpg");
        if (i != REQUEST_PICTURE || j != -1) goto _L2; else goto _L1
_L1:
        obj = Uri.fromFile(((File) (obj)));
        (new Crop(intent.getData())).withAspect(256, 256).output(((Uri) (obj))).asSquare().start(this);
_L6:
        return;
_L2:
        if (i != 6709 || j != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        mHolder.imgPicture.setImageResource(0x7f020188);
        intent = null;
        obj = android.provider.MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(((File) (obj))));
        intent = ((Intent) (obj));
_L4:
        mServer.uploadImageUser(intent, new my.googlemusic.play.interfaces.Server.Callback() {

            final SettingsActivity this$0;

            public void onFailure(Response response)
            {
                if (response.getStatus() == 7)
                {
                    Toast.with(SettingsActivity.this).message(response.getContent()).show();
                }
            }

            public void onProgress(int k)
            {
            }

            public void onSuccess(Object obj1)
            {
                Picasso.with(SettingsActivity.this).load((Uri)obj1).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(mHolder.imgPicture);
                setResult(12000);
            }

            
            {
                this$0 = SettingsActivity.this;
                super();
            }
        });
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
        if (j != 0) goto _L6; else goto _L5
_L5:
        Picasso.with(this).load(mServer.getLinkUserImage(mUser.getId())).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(mHolder.imgPicture);
        return;
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onClick(View view)
    {
        if (!mServer.getUser().isSkip() || view == mHolder.btnLogout) goto _L2; else goto _L1
_L1:
        (new DialogSkipUser()).show(getSupportFragmentManager(), null);
_L4:
        return;
_L2:
        if (!Connection.with(this).isConnected() && view != mHolder.btnLogout)
        {
            Toast.with(this).message("Offline").show();
            return;
        }
        if (view == mHolder.btnName)
        {
            if (!$assertionsDisabled && mHolder.txtName.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Name", 0);
                return;
            }
        }
        if (view == mHolder.btnUser)
        {
            if (!$assertionsDisabled && mHolder.txtUser.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Username", 1);
                return;
            }
        }
        if (view == mHolder.btnEmail)
        {
            if (!$assertionsDisabled && mHolder.txtEmail.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Email", 2);
                return;
            }
        }
        if (view == mHolder.btnPassword)
        {
            if (!$assertionsDisabled && mHolder.txtPassword.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Password", 3);
                return;
            }
        }
        if (view == mHolder.btnPicture)
        {
            userPicture();
            return;
        }
        if (view == mHolder.btnBadge)
        {
            startActivity(new Intent(this, my/googlemusic/play/activities/BadgeActivity));
            return;
        }
        if (view == mHolder.btnInstagram)
        {
            if (!$assertionsDisabled && mHolder.txtInstagram.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Instagram", 4);
                return;
            }
        }
        if (view == mHolder.btnBio)
        {
            if (!$assertionsDisabled && mHolder.txtBio.getText() == null)
            {
                throw new AssertionError();
            } else
            {
                customDialogEdit("Change Biography", 5);
                return;
            }
        }
        if (view == mHolder.btnLogout)
        {
            logout();
            return;
        }
        if (view != mHolderDialogButton.save)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (currentType == 0)
        {
            changeName();
            return;
        }
        if (currentType == 1)
        {
            changeUsername();
            return;
        }
        if (currentType == 2)
        {
            changeEmail();
            return;
        }
        if (currentType == 3)
        {
            changePassword();
            return;
        }
        if (currentType == 4)
        {
            changeInstagram();
            return;
        }
        if (currentType != 5) goto _L4; else goto _L3
_L3:
        changeBio();
        return;
        if (view != mHolderDialogButton.cancel) goto _L4; else goto _L5
_L5:
        mDialog.cancel();
        return;
    }

    public void onConnected(Bundle bundle)
    {
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
    }

    public void onConnectionSuspended(int i)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030037);
        initData();
        initView();
        initAds();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (mHolderDialogPassword == null) goto _L2; else goto _L1
_L1:
        if (view != mHolderDialogPassword.changeOld) goto _L4; else goto _L3
_L3:
        mHolderDialogPassword.lineOld.setBackgroundColor(getResources().getColor(0x7f0c0020));
        mHolderDialogPassword.lineNew.setBackgroundColor(getResources().getColor(0x7f0c0024));
        mHolderDialogPassword.lineConfirm.setBackgroundColor(getResources().getColor(0x7f0c0024));
_L2:
        if (mHolderDialogName == null) goto _L6; else goto _L5
_L5:
        if (view != mHolderDialogName.changeName) goto _L8; else goto _L7
_L7:
        mHolderDialogName.lineName.setBackgroundColor(getResources().getColor(0x7f0c0020));
        mHolderDialogName.lineLastName.setBackgroundColor(getResources().getColor(0x7f0c0024));
_L6:
        return;
_L4:
        if (view == mHolderDialogPassword.changeNew)
        {
            mHolderDialogPassword.lineOld.setBackgroundColor(getResources().getColor(0x7f0c0024));
            mHolderDialogPassword.lineNew.setBackgroundColor(getResources().getColor(0x7f0c0020));
            mHolderDialogPassword.lineConfirm.setBackgroundColor(getResources().getColor(0x7f0c0024));
        } else
        if (view == mHolderDialogPassword.changeConfirmNew)
        {
            mHolderDialogPassword.lineOld.setBackgroundColor(getResources().getColor(0x7f0c0024));
            mHolderDialogPassword.lineNew.setBackgroundColor(getResources().getColor(0x7f0c0024));
            mHolderDialogPassword.lineConfirm.setBackgroundColor(getResources().getColor(0x7f0c0020));
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (view != mHolderDialogName.changeLastName) goto _L6; else goto _L9
_L9:
        mHolderDialogName.lineName.setBackgroundColor(getResources().getColor(0x7f0c0024));
        mHolderDialogName.lineLastName.setBackgroundColor(getResources().getColor(0x7f0c0020));
        return;
        if (true) goto _L2; else goto _L10
_L10:
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (!Connection.with(this).isConnected())
        {
            Toast.with(this).message("Offline").show();
            return;
        }
        i;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 83
    //                   1 158
    //                   2 200;
           goto _L1 _L2 _L3 _L4
_L1:
        mCurrentQualityStream = (int)mHolder.spnStreaming.getSelectedItemId();
        mCurrentQualityDownload = (int)mHolder.spnDownload.getSelectedItemId();
        return;
_L2:
        if (mUser.isSkip())
        {
            setSelection(adapterview);
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
        } else
        if (!mUser.isPremium())
        {
            setSelection(adapterview);
            (new DialogPremiumUser()).show(getSupportFragmentManager(), null);
        } else
        {
            setQuality(adapterview, 5);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mUser.isSkip())
        {
            setSelection(adapterview);
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
        } else
        {
            setQuality(adapterview, 3);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        setQuality(adapterview, 0);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    protected void onResume()
    {
        super.onResume();
        mUser = mServer.getUser();
        if (mServer.getUser().isPremium() && mHolder.adView.getVisibility() == 0)
        {
            mHolder.adView.setVisibility(8);
        }
        Picasso.with(this).load(mServer.getLinkBadge(mUser.getId(), mUser.getBadgeSecondary())).into(mHolder.imgBadge);
    }

    protected void onStart()
    {
        super.onStart();
        if (mGoogleApiClient != null)
        {
            mGoogleApiClient.connect();
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
        {
            mGoogleApiClient.disconnect();
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        replaceInvalidCharacters(charsequence, i, " ");
        replaceInvalidCharacters(charsequence, i, "@");
        replaceInvalidCharacters(charsequence, i, "#");
        replaceInvalidCharacters(charsequence, i, "$");
        replaceInvalidCharacters(charsequence, i, "%");
        replaceInvalidCharacters(charsequence, i, "&");
        replaceInvalidCharacters(charsequence, i, "-");
        replaceInvalidCharacters(charsequence, i, "+");
        replaceInvalidCharacters(charsequence, i, "(");
        replaceInvalidCharacters(charsequence, i, ")");
        replaceInvalidCharacters(charsequence, i, "*");
        replaceInvalidCharacters(charsequence, i, "\"");
        replaceInvalidCharacters(charsequence, i, "'");
        replaceInvalidCharacters(charsequence, i, ":");
        replaceInvalidCharacters(charsequence, i, ";");
        replaceInvalidCharacters(charsequence, i, "!");
        replaceInvalidCharacters(charsequence, i, "?");
        replaceInvalidCharacters(charsequence, i, ",");
        replaceInvalidCharacters(charsequence, i, "/");
        replaceInvalidCharacters(charsequence, i, ".");
        replaceInvalidCharacters(charsequence, i, "{");
        replaceInvalidCharacters(charsequence, i, "}");
        replaceInvalidCharacters(charsequence, i, "[");
        replaceInvalidCharacters(charsequence, i, "]");
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/activities/SettingsActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }






}
