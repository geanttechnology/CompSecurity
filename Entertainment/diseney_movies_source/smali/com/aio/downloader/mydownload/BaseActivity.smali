.class public abstract Lcom/aio/downloader/mydownload/BaseActivity;
.super Landroid/app/Activity;
.source "BaseActivity.java"

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
    .line 7
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/mydownload/BaseActivity;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, -0x1

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/mydownload/BaseActivity;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/mydownload/BaseActivity;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/mydownload/BaseActivity;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/mydownload/BaseActivity;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 3

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 47
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    const-string v1, "config"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/aio/downloader/mydownload/BaseActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/mydownload/BaseActivity;->setSp(Landroid/content/SharedPreferences;)V

    .line 48
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/mydownload/BaseActivity;->edit:Landroid/content/SharedPreferences$Editor;

    .line 49
    invoke-virtual {p0, v0}, Lcom/aio/downloader/mydownload/BaseActivity;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V

    .line 50
    return-void
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 27
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 28
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 21
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 22
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 15
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 16
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/aio/downloader/mydownload/BaseActivity;->edit:Landroid/content/SharedPreferences$Editor;

    .line 82
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/aio/downloader/mydownload/BaseActivity;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 74
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/aio/downloader/mydownload/BaseActivity;->sp:Landroid/content/SharedPreferences;

    .line 66
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/aio/downloader/mydownload/BaseActivity;->mContext:Landroid/content/Context;

    .line 58
    return-void
.end method
