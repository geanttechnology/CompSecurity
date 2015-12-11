.class public Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;
.super Landroid/os/AsyncTask;
.source "SettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/SettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "GetCacheSizeAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/SettingsFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/SettingsFragment;)V
    .locals 0

    .prologue
    .line 295
    iput-object p1, p0, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->this$0:Lco/vine/android/SettingsFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 295
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 307
    :try_start_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v1}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getCacheSize(Landroid/content/Context;)J

    move-result-wide v2

    invoke-static {v1, v2, v3}, Lco/vine/android/util/Util;->formatFileSize(Landroid/content/res/Resources;J)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 312
    :goto_0
    return-object v1

    .line 309
    :catch_0
    move-exception v0

    .line 310
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 312
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 295
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 299
    if-eqz p1, :cond_0

    .line 300
    iget-object v0, p0, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mClearCacheValue:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$000(Lco/vine/android/SettingsFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 302
    :cond_0
    return-void
.end method
