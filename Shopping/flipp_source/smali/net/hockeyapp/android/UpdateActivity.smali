.class public Lnet/hockeyapp/android/UpdateActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lnet/hockeyapp/android/x;


# instance fields
.field protected a:Lnet/hockeyapp/android/d/d;

.field protected b:Lnet/hockeyapp/android/e/i;

.field private final c:I

.field private d:Lnet/hockeyapp/android/c/a;

.field private e:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 63
    const/4 v0, 0x0

    iput v0, p0, Lnet/hockeyapp/android/UpdateActivity;->c:I

    return-void
.end method

.method static synthetic a(Lnet/hockeyapp/android/UpdateActivity;)Lnet/hockeyapp/android/c/a;
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    iput-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    return-object v0
.end method

.method private c()Ljava/lang/String;
    .locals 3

    .prologue
    .line 233
    :try_start_0
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 234
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 235
    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 238
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, ""

    goto :goto_0
.end method


# virtual methods
.method protected final a()V
    .locals 3

    .prologue
    .line 152
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 153
    new-instance v1, Lnet/hockeyapp/android/r;

    invoke-direct {v1, p0}, Lnet/hockeyapp/android/r;-><init>(Lnet/hockeyapp/android/UpdateActivity;)V

    new-instance v2, Lnet/hockeyapp/android/d/d;

    invoke-direct {v2, p0, v0, v1}, Lnet/hockeyapp/android/d/d;-><init>(Landroid/content/Context;Ljava/lang/String;Lnet/hockeyapp/android/b/a;)V

    iput-object v2, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/d/d;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 154
    return-void
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 196
    const/16 v0, 0x1004

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 197
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 198
    return-void
.end method

.method public getCurrentVersionCode()I
    .locals 4

    .prologue
    .line 206
    const/4 v0, -0x1

    .line 209
    :try_start_0
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x80

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget v0, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 214
    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 284
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->e:Landroid/content/Context;

    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-virtual {v0, v1}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_0

    move v0, v6

    :goto_0
    if-nez v0, :cond_1

    .line 285
    new-instance v0, Lnet/hockeyapp/android/c/a;

    invoke-direct {v0}, Lnet/hockeyapp/android/c/a;-><init>()V

    iput-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    .line 286
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    const-string v1, "The permission to access the external storage permission is not set. Please contact the developer."

    iput-object v1, v0, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    .line 288
    new-instance v0, Lnet/hockeyapp/android/s;

    invoke-direct {v0, p0}, Lnet/hockeyapp/android/s;-><init>(Lnet/hockeyapp/android/UpdateActivity;)V

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 316
    :goto_1
    return-void

    :cond_0
    move v0, v7

    .line 284
    goto :goto_0

    .line 299
    :cond_1
    new-array v2, v6, [Ljava/lang/String;

    const-string v0, "value"

    aput-object v0, v2, v7

    const-string v3, "name = ? AND value = ?"

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_2

    new-array v4, v4, [Ljava/lang/String;

    const-string v0, "install_non_market_apps"

    aput-object v0, v4, v7

    const-string v0, "1"

    aput-object v0, v4, v6

    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/Settings$Global;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    :goto_2
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ne v0, v6, :cond_3

    move v0, v6

    :goto_3
    if-nez v0, :cond_4

    .line 300
    new-instance v0, Lnet/hockeyapp/android/c/a;

    invoke-direct {v0}, Lnet/hockeyapp/android/c/a;-><init>()V

    iput-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    .line 301
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    const-string v1, "The installation from unknown sources is not enabled. Please check the device settings."

    iput-object v1, v0, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    .line 303
    new-instance v0, Lnet/hockeyapp/android/t;

    invoke-direct {v0, p0}, Lnet/hockeyapp/android/t;-><init>(Lnet/hockeyapp/android/UpdateActivity;)V

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_1

    .line 299
    :cond_2
    new-array v4, v4, [Ljava/lang/String;

    const-string v0, "install_non_market_apps"

    aput-object v0, v4, v7

    const-string v0, "1"

    aput-object v0, v4, v6

    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/Settings$Secure;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_2

    :cond_3
    move v0, v7

    goto :goto_3

    .line 314
    :cond_4
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->a()V

    .line 315
    invoke-virtual {p1, v7}, Landroid/view/View;->setEnabled(Z)V

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    .line 87
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 89
    const-string v0, "App Update"

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 90
    new-instance v0, Lnet/hockeyapp/android/f/c;

    invoke-direct {v0, p0}, Lnet/hockeyapp/android/f/c;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->setContentView(Landroid/view/View;)V

    .line 92
    iput-object p0, p0, Lnet/hockeyapp/android/UpdateActivity;->e:Landroid/content/Context;

    .line 93
    new-instance v0, Lnet/hockeyapp/android/e/i;

    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "json"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lnet/hockeyapp/android/e/i;-><init>(Ljava/lang/String;Lnet/hockeyapp/android/x;)V

    iput-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->b:Lnet/hockeyapp/android/e/i;

    .line 94
    const/16 v0, 0x1002

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-direct {p0}, Lnet/hockeyapp/android/UpdateActivity;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/16 v0, 0x1003

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Version "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lnet/hockeyapp/android/UpdateActivity;->b:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lnet/hockeyapp/android/UpdateActivity;->b:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/16 v0, 0x1004

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/16 v0, 0x1005

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->clearCache(Z)V

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroyDrawingCache()V

    const-string v1, "https://sdk.hockeyapp.net/"

    iget-object v2, p0, Lnet/hockeyapp/android/UpdateActivity;->b:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->c()Ljava/lang/String;

    move-result-object v2

    const-string v3, "text/html"

    const-string v4, "utf-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    invoke-virtual {p0}, Lnet/hockeyapp/android/UpdateActivity;->getLastNonConfigurationInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/hockeyapp/android/d/d;

    iput-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    .line 97
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    iput-object p0, v0, Lnet/hockeyapp/android/d/d;->a:Landroid/content/Context;

    .line 100
    :cond_0
    return-void
.end method

.method protected onCreateDialog(I)Landroid/app/Dialog;
    .locals 3

    .prologue
    .line 320
    packed-switch p1, :pswitch_data_0

    .line 335
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 322
    :pswitch_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "An error has occured"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Error"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "OK"

    new-instance v2, Lnet/hockeyapp/android/u;

    invoke-direct {v2, p0}, Lnet/hockeyapp/android/u;-><init>(Lnet/hockeyapp/android/UpdateActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    goto :goto_0

    .line 320
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method protected onPrepareDialog(ILandroid/app/Dialog;)V
    .locals 1

    .prologue
    .line 340
    packed-switch p1, :pswitch_data_0

    .line 354
    :goto_0
    return-void

    .line 342
    :pswitch_0
    check-cast p2, Landroid/app/AlertDialog;

    .line 343
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    if-eqz v0, :cond_0

    .line 345
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->d:Lnet/hockeyapp/android/c/a;

    iget-object v0, v0, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    invoke-virtual {p2, v0}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 349
    :cond_0
    const-string v0, "An unknown error has occured."

    invoke-virtual {p2, v0}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 340
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onRetainNonConfigurationInstance()Ljava/lang/Object;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 140
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    iput-object v1, v0, Lnet/hockeyapp/android/d/d;->a:Landroid/content/Context;

    iput-object v1, v0, Lnet/hockeyapp/android/d/d;->b:Landroid/app/ProgressDialog;

    .line 143
    :cond_0
    iget-object v0, p0, Lnet/hockeyapp/android/UpdateActivity;->a:Lnet/hockeyapp/android/d/d;

    return-object v0
.end method
