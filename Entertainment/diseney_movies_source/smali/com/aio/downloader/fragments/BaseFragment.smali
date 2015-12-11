.class public Lcom/aio/downloader/fragments/BaseFragment;
.super Landroid/support/v4/app/Fragment;
.source "BaseFragment.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# instance fields
.field private edit:Landroid/content/SharedPreferences$Editor;

.field private mContext:Landroid/content/Context;

.field private myApp:Lcom/aio/downloader/mydownload/MyApplcation;

.field private sp:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/fragments/BaseFragment;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, -0x1

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/fragments/BaseFragment;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/fragments/BaseFragment;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/fragments/BaseFragment;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/aio/downloader/fragments/BaseFragment;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 50
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/fragments/BaseFragment;->setSp(Landroid/content/SharedPreferences;)V

    .line 51
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/fragments/BaseFragment;->edit:Landroid/content/SharedPreferences$Editor;

    .line 52
    invoke-virtual {p0, v0}, Lcom/aio/downloader/fragments/BaseFragment;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V

    .line 55
    return-void
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 30
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 31
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 24
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 25
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BaseFragment;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 18
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 19
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/aio/downloader/fragments/BaseFragment;->edit:Landroid/content/SharedPreferences$Editor;

    .line 87
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/aio/downloader/fragments/BaseFragment;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 79
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/aio/downloader/fragments/BaseFragment;->sp:Landroid/content/SharedPreferences;

    .line 71
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/aio/downloader/fragments/BaseFragment;->mContext:Landroid/content/Context;

    .line 63
    return-void
.end method
