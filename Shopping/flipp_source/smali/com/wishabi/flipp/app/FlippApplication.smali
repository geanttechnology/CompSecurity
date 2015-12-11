.class public Lcom/wishabi/flipp/app/FlippApplication;
.super Landroid/app/Application;
.source "SourceFile"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;
.implements Lcom/wishabi/flipp/app/d;


# static fields
.field private static final a:Ljava/lang/String;

.field private static c:Landroid/content/Context;

.field private static d:Landroid/os/Handler;


# instance fields
.field private b:Lcom/wishabi/flipp/app/c;

.field private final e:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

.field private f:Landroid/content/CursorLoader;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lcom/wishabi/flipp/app/FlippApplication;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/FlippApplication;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 79
    new-instance v0, Lcom/wishabi/flipp/app/aw;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/aw;-><init>(Lcom/wishabi/flipp/app/FlippApplication;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->e:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlippApplication;)V
    .locals 10

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v9, 0x0

    .line 42
    const-string v0, "com.wishabi.flipp.preferences"

    invoke-virtual {p0, v0, v9}, Lcom/wishabi/flipp/app/FlippApplication;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlippApplication;->c()Ljava/lang/String;

    move-result-object v1

    const-string v0, "GCM token:%s"

    new-array v3, v4, [Ljava/lang/Object;

    aput-object v1, v3, v9

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    const-string v0, "https://backflipp.wishabi.com/flipp/gcm/registration"

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlippApplication;->d()Ljava/lang/String;

    move-result-object v1

    const-string v0, "https://backflipp.wishabi.com/flipp/adm/registration"

    :cond_0
    if-nez v1, :cond_2

    new-instance v0, Lcom/wishabi/flipp/app/az;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/az;-><init>(Lcom/wishabi/flipp/app/FlippApplication;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/az;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    :try_start_0
    const-string v0, "com.amazon.device.messaging.ADM"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    new-instance v0, Lcom/amazon/device/messaging/ADM;

    invoke-direct {v0, p0}, Lcom/amazon/device/messaging/ADM;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/amazon/device/messaging/ADM;->startRegister()V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    :cond_1
    :goto_0
    return-void

    :cond_2
    const-string v3, "postal_code"

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v7

    invoke-virtual {v7, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v0, "locale"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v0, "postal_code"

    invoke-virtual {v7, v0, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v0, "allow_push"

    invoke-interface {v2, v0}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v1, "allow_push"

    const-string v0, "allow_push"

    invoke-interface {v2, v0, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_5

    const-string v0, "true"

    :goto_1
    invoke-virtual {v7, v1, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :cond_3
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    :try_start_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlippApplication;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v1

    :goto_2
    if-eqz v1, :cond_6

    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_6

    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :cond_5
    const-string v0, "false"

    goto :goto_1

    :cond_6
    if-eqz v1, :cond_7

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_7
    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    const-string v0, "merchant_ids"

    const-string v1, ","

    invoke-static {v1, v8}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :cond_8
    invoke-virtual {v7}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_1

    :try_start_3
    new-instance v1, Ljava/net/URL;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/net/MalformedURLException; {:try_start_3 .. :try_end_3} :catch_0

    new-instance v0, Lcom/wishabi/flipp/app/ba;

    invoke-direct {v0, p0, v1}, Lcom/wishabi/flipp/app/ba;-><init>(Lcom/wishabi/flipp/app/FlippApplication;Ljava/net/URL;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/ba;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    :catch_0
    move-exception v0

    goto/16 :goto_0

    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_3

    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method public static a(Ljava/lang/Runnable;)Z
    .locals 2

    .prologue
    .line 66
    const-class v1, Lcom/wishabi/flipp/app/FlippApplication;

    monitor-enter v1

    .line 67
    :try_start_0
    sget-object v0, Lcom/wishabi/flipp/app/FlippApplication;->d:Landroid/os/Handler;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/wishabi/flipp/app/FlippApplication;->d:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 68
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static b()Landroid/content/Context;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/wishabi/flipp/app/FlippApplication;->c:Landroid/content/Context;

    return-object v0
.end method

.method private c()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 190
    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {p0, v1, v4}, Lcom/wishabi/flipp/app/FlippApplication;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 193
    const-string v1, "gcm_registration_id"

    invoke-interface {v2, v1, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 195
    if-nez v1, :cond_1

    .line 214
    :cond_0
    :goto_0
    return-object v0

    .line 198
    :cond_1
    const-string v3, "gcm_application_version_id"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 201
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlippApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 202
    if-eqz v3, :cond_0

    .line 206
    :try_start_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlippApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlippApplication;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget v3, v3, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    if-ne v3, v2, :cond_0

    move-object v0, v1

    .line 214
    goto :goto_0

    .line 211
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 323
    :try_start_0
    const-string v0, "com.amazon.device.messaging.ADM"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 324
    new-instance v0, Lcom/amazon/device/messaging/ADM;

    invoke-direct {v0, p0}, Lcom/amazon/device/messaging/ADM;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/amazon/device/messaging/ADM;->getRegistrationId()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 326
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 186
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0, v1, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/net/Uri;)V

    .line 187
    return-void
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 138
    const-string v0, "d13259c95a0a44508d6479c605ca9ca2"

    invoke-static {p1, v0}, Lnet/hockeyapp/android/y;->a(Landroid/app/Activity;Ljava/lang/String;)V

    .line 139
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 181
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 169
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 12

    .prologue
    const-wide/16 v10, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 150
    const-string v0, "d13259c95a0a44508d6479c605ca9ca2"

    new-instance v3, Lcom/wishabi/flipp/app/ay;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ay;-><init>(Lcom/wishabi/flipp/app/FlippApplication;)V

    invoke-static {p1, v0, v3}, Lnet/hockeyapp/android/b;->a(Landroid/content/Context;Ljava/lang/String;Lnet/hockeyapp/android/g;)V

    .line 162
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/a;->c()V

    iget-object v3, v0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v4, "com.wishabi.flipp.preferences"

    invoke-virtual {v3, v4, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "install_sent"

    invoke-interface {v3, v4, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "referrer"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    const-string v5, "none"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    const-string v6, "referrer"

    invoke-virtual {v5, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "app_install"

    invoke-virtual {v0, v4, v5, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    :cond_0
    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v3, "install_sent"

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 165
    :cond_1
    iget-object v3, p0, Lcom/wishabi/flipp/app/FlippApplication;->b:Lcom/wishabi/flipp/app/c;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    if-eqz v0, :cond_5

    const-string v6, "app_open_last_recreate_nano"

    invoke-interface {v0, v6, v10, v11}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v6

    sub-long v6, v4, v6

    iget-wide v8, v3, Lcom/wishabi/flipp/app/c;->a:J

    cmp-long v6, v6, v8

    if-lez v6, :cond_5

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v6, "app_open_last_recreate_nano"

    invoke-interface {v0, v6, v10, v11}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move v0, v1

    :goto_0
    iget-wide v6, v3, Lcom/wishabi/flipp/app/c;->d:J

    sub-long/2addr v4, v6

    iget-wide v6, v3, Lcom/wishabi/flipp/app/c;->a:J

    cmp-long v4, v4, v6

    if-gtz v4, :cond_2

    move v1, v2

    :cond_2
    iget-boolean v4, v3, Lcom/wishabi/flipp/app/c;->c:Z

    if-nez v4, :cond_3

    if-eqz v0, :cond_4

    .line 166
    :cond_3
    :goto_1
    return-void

    .line 165
    :cond_4
    iput-boolean v2, v3, Lcom/wishabi/flipp/app/c;->c:Z

    if-nez v1, :cond_3

    iget-object v0, v3, Lcom/wishabi/flipp/app/c;->e:Lcom/wishabi/flipp/app/d;

    if-eqz v0, :cond_3

    iget-object v0, v3, Lcom/wishabi/flipp/app/c;->e:Lcom/wishabi/flipp/app/d;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/d;->a()V

    goto :goto_1

    :cond_5
    move v0, v2

    goto :goto_0
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 177
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->b:Lcom/wishabi/flipp/app/c;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, v0, Lcom/wishabi/flipp/app/c;->b:Ljava/lang/ref/WeakReference;

    .line 145
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 173
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlippApplication;->b:Lcom/wishabi/flipp/app/c;

    const/4 v0, 0x0

    iget-object v2, v1, Lcom/wishabi/flipp/app/c;->b:Ljava/lang/ref/WeakReference;

    if-eqz v2, :cond_0

    iget-object v0, v1, Lcom/wishabi/flipp/app/c;->b:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    :cond_0
    if-ne v0, p1, :cond_1

    const/4 v0, 0x0

    iput-boolean v0, v1, Lcom/wishabi/flipp/app/c;->c:Z

    :cond_1
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iput-wide v2, v1, Lcom/wishabi/flipp/app/c;->d:J

    .line 174
    return-void
.end method

.method public onCreate()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v3, 0x0

    .line 105
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 107
    sput-object p0, Lcom/wishabi/flipp/app/FlippApplication;->c:Landroid/content/Context;

    .line 108
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/wishabi/flipp/app/FlippApplication;->d:Landroid/os/Handler;

    .line 110
    invoke-virtual {p0, p0}, Lcom/wishabi/flipp/app/FlippApplication;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 111
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iput-object p0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeZone()Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v0, v7, v7}, Ljava/util/TimeZone;->getDisplayName(ZI)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->p:Ljava/lang/String;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v2, "android_id"

    invoke-static {v0, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->n:Ljava/lang/String;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v2, "android.permission.READ_PHONE_STATE"

    invoke-virtual {v0, v2}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v2, "phone"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->o:Ljava/lang/String;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ak;->a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ak;

    move-result-object v0

    const-string v2, "UA-43421620-4"

    invoke-virtual {v0, v2, v2}, Lcom/google/analytics/tracking/android/ak;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/ay;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->e:Lcom/google/analytics/tracking/android/ay;

    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v2

    new-instance v0, Lcom/wishabi/flipp/b/g;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/b/g;-><init>(Lcom/wishabi/flipp/b/a;)V

    invoke-interface {v2, v0}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    const-string v0, "advertising_id"

    invoke-interface {v2, v0, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->h:Ljava/lang/String;

    const-string v0, "is_lat"

    invoke-interface {v2, v0, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v1, Lcom/wishabi/flipp/b/a;->i:Z

    const-string v0, "postal_code"

    invoke-interface {v2, v0, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    const-string v0, "nan_hash"

    invoke-interface {v2, v0, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->q:Ljava/lang/String;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->q:Ljava/lang/String;

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "-"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->q:Ljava/lang/String;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v4, "nan_hash"

    iget-object v5, v1, Lcom/wishabi/flipp/b/a;->q:Ljava/lang/String;

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    :cond_0
    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->m:Landroid/content/ContentResolver;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v4, "window"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iget-object v4, v1, Lcom/wishabi/flipp/b/a;->l:Landroid/graphics/Point;

    invoke-virtual {v0, v4}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v4, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    if-eqz v0, :cond_1

    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {v0, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->j:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    new-instance v0, Lcom/wishabi/flipp/b/h;

    invoke-direct {v0, v1, v2}, Lcom/wishabi/flipp/b/h;-><init>(Lcom/wishabi/flipp/b/a;Landroid/content/SharedPreferences;)V

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/b/h;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v2, "576005129150479"

    invoke-static {v0, v2}, Lcom/facebook/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/AppEventsLogger;

    move-result-object v0

    iput-object v0, v1, Lcom/wishabi/flipp/b/a;->f:Lcom/facebook/AppEventsLogger;

    iget-object v0, v1, Lcom/wishabi/flipp/b/a;->j:Ljava/lang/String;

    invoke-static {v0}, Lcom/facebook/Settings;->setAppVersion(Ljava/lang/String;)V

    new-instance v0, Lcom/localytics/android/LocalyticsActivityLifecycleCallbacks;

    iget-object v1, v1, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/localytics/android/LocalyticsActivityLifecycleCallbacks;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 112
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    iput-object p0, v0, Lcom/wishabi/flipp/b/u;->b:Landroid/content/Context;

    new-instance v1, Landroid/os/Handler;

    iget-object v2, v0, Lcom/wishabi/flipp/b/u;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, v0, Lcom/wishabi/flipp/b/u;->c:Landroid/os/Handler;

    .line 114
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 115
    if-eqz v0, :cond_2

    .line 116
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlippApplication;->e:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 118
    const-string v1, "keep_search_history"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Lcom/wishabi/flipp/content/SearchTermProvider;->a(Z)V

    .line 122
    :cond_2
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    move-object v1, p0

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->f:Landroid/content/CursorLoader;

    .line 124
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->f:Landroid/content/CursorLoader;

    new-instance v1, Lcom/wishabi/flipp/app/ax;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ax;-><init>(Lcom/wishabi/flipp/app/FlippApplication;)V

    invoke-virtual {v0, v7, v1}, Landroid/content/CursorLoader;->registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V

    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->f:Landroid/content/CursorLoader;

    invoke-virtual {v0}, Landroid/content/CursorLoader;->startLoading()V

    .line 133
    new-instance v0, Lcom/wishabi/flipp/app/c;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/c;-><init>(Lcom/wishabi/flipp/app/d;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlippApplication;->b:Lcom/wishabi/flipp/app/c;

    .line 134
    return-void

    :cond_3
    move-object v0, v3

    .line 111
    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1
.end method
