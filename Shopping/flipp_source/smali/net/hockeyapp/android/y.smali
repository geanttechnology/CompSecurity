.class public final Lnet/hockeyapp/android/y;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Lnet/hockeyapp/android/d/a;

.field private static b:Lnet/hockeyapp/android/z;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 54
    sput-object v0, Lnet/hockeyapp/android/y;->a:Lnet/hockeyapp/android/d/a;

    .line 59
    sput-object v0, Lnet/hockeyapp/android/y;->b:Lnet/hockeyapp/android/z;

    return-void
.end method

.method public static a()Ljava/lang/Boolean;
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 216
    :try_start_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 219
    :goto_1
    return-object v0

    :cond_0
    move v0, v1

    .line 216
    goto :goto_0

    .line 219
    :catch_0
    move-exception v0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_1
.end method

.method public static a(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;)",
            "Ljava/lang/Boolean;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 227
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 229
    if-eqz v0, :cond_2

    .line 230
    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 232
    iget v2, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v2, v2, 0xf

    const/4 v3, 0x3

    if-eq v2, v3, :cond_0

    iget v0, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v0, 0xf

    const/4 v2, 0x4

    if-ne v0, v2, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 238
    :goto_1
    return-object v0

    :cond_1
    move v0, v1

    .line 232
    goto :goto_0

    .line 238
    :cond_2
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_1
.end method

.method public static a(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 68
    const-string v2, "https://sdk.hockeyapp.net/"

    const/4 v0, 0x0

    sput-object v0, Lnet/hockeyapp/android/y;->b:Lnet/hockeyapp/android/z;

    new-instance v3, Ljava/lang/ref/WeakReference;

    invoke-direct {v3, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-static {}, Lnet/hockeyapp/android/y;->a()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    if-eqz v0, :cond_4

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v4, "hockey_update_dialog"

    invoke-virtual {v0, v4}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    :goto_0
    if-nez v0, :cond_2

    :cond_0
    invoke-static {v3}, Lnet/hockeyapp/android/y;->b(Ljava/lang/ref/WeakReference;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lnet/hockeyapp/android/y;->a:Lnet/hockeyapp/android/d/a;

    if-eqz v0, :cond_1

    sget-object v0, Lnet/hockeyapp/android/y;->a:Lnet/hockeyapp/android/d/a;

    invoke-virtual {v0}, Lnet/hockeyapp/android/d/a;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v0

    sget-object v4, Landroid/os/AsyncTask$Status;->FINISHED:Landroid/os/AsyncTask$Status;

    if-ne v0, v4, :cond_5

    :cond_1
    new-instance v0, Lnet/hockeyapp/android/d/a;

    invoke-direct {v0, v3, v2, p1}, Lnet/hockeyapp/android/d/a;-><init>(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lnet/hockeyapp/android/y;->a:Lnet/hockeyapp/android/d/a;

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/d/a;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 69
    :cond_2
    :goto_1
    return-void

    :cond_3
    move v0, v1

    .line 68
    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_0

    :cond_5
    sget-object v1, Lnet/hockeyapp/android/y;->a:Lnet/hockeyapp/android/d/a;

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    iput-object v0, v1, Lnet/hockeyapp/android/d/a;->c:Landroid/app/Activity;

    iget-object v0, v1, Lnet/hockeyapp/android/d/a;->c:Landroid/app/Activity;

    if-eqz v0, :cond_2

    iget-object v0, v1, Lnet/hockeyapp/android/d/a;->c:Landroid/app/Activity;

    invoke-static {v0}, Lnet/hockeyapp/android/a;->a(Landroid/content/Context;)V

    goto :goto_1
.end method

.method public static b()Lnet/hockeyapp/android/z;
    .locals 1

    .prologue
    .line 245
    sget-object v0, Lnet/hockeyapp/android/y;->b:Lnet/hockeyapp/android/z;

    return-object v0
.end method

.method private static b(Ljava/lang/ref/WeakReference;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;)Z"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 143
    .line 145
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 146
    if-eqz v0, :cond_0

    .line 148
    :try_start_0
    invoke-virtual {v0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v0}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/content/pm/PackageManager;->getInstallerPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 149
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x9

    if-lt v3, v4, :cond_2

    .line 150
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    move v2, v0

    .line 160
    :cond_0
    :goto_1
    return v2

    :cond_1
    move v0, v2

    .line 150
    goto :goto_0

    .line 153
    :cond_2
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->length()I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-lez v0, :cond_3

    :goto_2
    move v2, v1

    .line 157
    goto :goto_1

    :cond_3
    move v1, v2

    .line 153
    goto :goto_2

    :catch_0
    move-exception v0

    goto :goto_1
.end method
