// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.soundcloud.android.crop.Crop;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.login.Loader;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;
import my.googlemusic.play.utils.views.RobotoEditText;

// Referenced classes of package my.googlemusic.play.activities:
//            CreateAccountStepThreeActivity

public class CreateAccountStepTwoActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, TextWatcher, android.view.View.OnLongClickListener, android.view.View.OnTouchListener, my.googlemusic.play.utils.login.Loader.OnLoginListener
{
    private static class ViewHolder
    {

        private ImageView back;
        private Button create;
        private ImageView imageUser;
        private ProgressBar loading;
        private TextView progress;
        private RobotoEditText username;



/*
        static ImageView access$102(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.back = imageview;
            return imageview;
        }

*/



/*
        static Button access$202(ViewHolder viewholder, Button button)
        {
            viewholder.create = button;
            return button;
        }

*/



/*
        static ProgressBar access$302(ViewHolder viewholder, ProgressBar progressbar)
        {
            viewholder.loading = progressbar;
            return progressbar;
        }

*/



/*
        static ImageView access$402(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.imageUser = imageview;
            return imageview;
        }

*/



/*
        static RobotoEditText access$502(ViewHolder viewholder, RobotoEditText robotoedittext)
        {
            viewholder.username = robotoedittext;
            return robotoedittext;
        }

*/



/*
        static TextView access$602(ViewHolder viewholder, TextView textview)
        {
            viewholder.progress = textview;
            return textview;
        }

*/

        private ViewHolder()
        {
        }

    }


    public static final String EXTRA_USER_EMAIL = "email";
    public static final String EXTRA_USER_NAME = "name";
    public static final String EXTRA_USER_PASSWORD = "password";
    private static int REQUEST_PICTURE = 1;
    private String mEmail;
    private ViewHolder mHolder;
    private Bitmap mImage;
    private Loader mLoader;
    private String mName;
    private String mPassword;
    private Server mServer;

    public CreateAccountStepTwoActivity()
    {
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
        mLoader = new Loader(this, this);
        mName = getIntent().getStringExtra("name");
        mEmail = getIntent().getStringExtra("email");
        mPassword = getIntent().getStringExtra("password");
    }

    private void initPickPicture()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select picture"), REQUEST_PICTURE);
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f03001f);
        mHolder = new ViewHolder();
        mHolder.back = (ImageView)findViewById(0x7f0d00a1);
        mHolder.create = (Button)findViewById(0x7f0d00a4);
        mHolder.loading = (ProgressBar)findViewById(0x7f0d00a6);
        mHolder.imageUser = (ImageView)findViewById(0x7f0d00a2);
        mHolder.username = (RobotoEditText)findViewById(0x7f0d00a3);
        mHolder.progress = (TextView)findViewById(0x7f0d00a5);
        mHolder.username.setOnClickListener(this);
        mHolder.username.setOnTouchListener(this);
        mHolder.username.setOnLongClickListener(this);
        mHolder.username.addTextChangedListener(this);
        mHolder.back.setOnClickListener(this);
        mHolder.create.setOnClickListener(this);
        mHolder.imageUser.setOnClickListener(this);
    }

    private void replaceInvalidCharacters(CharSequence charsequence, int i, String s)
    {
        if (charsequence.toString().contains(s))
        {
            charsequence = charsequence.toString().replace(s, "");
            mHolder.username.setText(charsequence);
            mHolder.username.setSelection(i);
        }
    }

    private void setButtonEnabled(boolean flag, String s)
    {
        if (flag)
        {
            s = "Create account";
        }
        int i;
        if (flag)
        {
            i = getResources().getColor(0x7f0c0020);
        } else
        {
            i = 0xff888888;
        }
        mHolder.create.setText(s);
        mHolder.create.setBackgroundColor(i);
        mHolder.create.setEnabled(flag);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean isVerify()
    {
        String s = mHolder.username.getText().toString();
        if (mHolder.username.getText().toString().equals(""))
        {
            Toast.with(this).message("Please choose an username.").show();
            return false;
        }
        if (s.contains("#"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("&"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("/"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("$"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("%"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("?"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        } else
        {
            return true;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Object obj = new File(getFilesDir(), "tmp.jpg");
        if (i != REQUEST_PICTURE || j != -1) goto _L2; else goto _L1
_L1:
        obj = Uri.fromFile(((File) (obj)));
        (new Crop(intent.getData())).withAspect(256, 256).output(((Uri) (obj))).asSquare().start(this);
_L4:
        return;
_L2:
        if (i != 6709 || j != -1) goto _L4; else goto _L3
_L3:
        Object obj1;
        mHolder.imageUser.setImageResource(0x7f020188);
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            mImage = android.provider.MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(((File) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
        }
        obj = null;
        intent = ((Intent) (obj));
        bytearrayoutputstream = new ByteArrayOutputStream();
        intent = ((Intent) (obj));
        obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/user_profile/").toString());
        if (!((File) (obj1)).exists())
        {
            ((File) (obj1)).mkdir();
        }
        mImage.compress(android.graphics.Bitmap.CompressFormat.JPEG, 40, bytearrayoutputstream);
        obj = new File(((File) (obj1)).getAbsolutePath(), "tmp.jpg");
        intent = ((Intent) (obj));
        obj1 = new FileOutputStream(((File) (obj)));
        intent = ((Intent) (obj));
        ((FileOutputStream) (obj1)).write(bytearrayoutputstream.toByteArray());
        intent = ((Intent) (obj));
        ((FileOutputStream) (obj1)).flush();
        intent = ((Intent) (obj));
        ((FileOutputStream) (obj1)).close();
        intent = ((Intent) (obj));
_L6:
        Picasso.with(this).load(intent).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(mHolder.imageUser);
        return;
        Exception exception;
        exception;
_L7:
        exception.printStackTrace();
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        intent = ((Intent) (obj1));
          goto _L7
    }

    public void onClick(View view)
    {
        if (view == mHolder.back)
        {
            finish();
        } else
        {
            if (view == mHolder.imageUser)
            {
                initPickPicture();
                return;
            }
            if (view == mHolder.create && isVerify())
            {
                setButtonEnabled(false, "Creating account...");
                mServer.createAccount(mHolder.username.getText().toString(), mEmail, mName, mPassword, new my.googlemusic.play.interfaces.Server.Callback() {

                    final CreateAccountStepTwoActivity this$0;

                    public void onFailure(Response response)
                    {
                        if (response.getStatus() == 7)
                        {
                            Toast.with(CreateAccountStepTwoActivity.this).message(response.getContent()).show();
                        }
                        setButtonEnabled(true, "");
                    }

                    public void onProgress(int i)
                    {
                    }

                    public void onSuccess(Object obj)
                    {
label0:
                        {
                            if (obj instanceof User)
                            {
                                setButtonEnabled(false, "Uploading user photo...");
                                if (mImage == null)
                                {
                                    break label0;
                                }
                    /* block-local class not found */
                    class _cls1 {}

                                mServer.uploadImageUser(mImage, new _cls1());
                                Toast.with(CreateAccountStepTwoActivity.this).message(((User)obj).getMessage()).show();
                            }
                            return;
                        }
                        mLoader.initLoader();
                    }

            
            {
                this$0 = CreateAccountStepTwoActivity.this;
                super();
            }
                });
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initView();
        initData();
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

    public void onLoaderFinish()
    {
        startActivity(new Intent(this, my/googlemusic/play/activities/CreateAccountStepThreeActivity));
        finish();
    }

    public boolean onLongClick(View view)
    {
        return true;
    }

    public void onProcessFinish(Object obj)
    {
        mHolder.progress.setVisibility(4);
        mHolder.loading.setVisibility(0);
        onLoaderFinish();
    }

    public void onProcessStart(Object obj)
    {
        mHolder.progress.setVisibility(0);
        mHolder.loading.setVisibility(4);
        mHolder.create.setTextSize(12F);
        mHolder.create.setText(obj.toString());
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

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocus();
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        return true;
    }





}
