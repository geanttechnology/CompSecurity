.class public Lcom/comcast/cim/model/user/CurrentUser;
.super Ljava/lang/Object;
.source "CurrentUser.java"


# instance fields
.field private preferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "preferences"    # Landroid/content/SharedPreferences;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/model/user/CurrentUser;->preferences:Landroid/content/SharedPreferences;

    .line 14
    return-void
.end method


# virtual methods
.method public forget()V
    .locals 3

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/CurrentUser;->getKey()Ljava/lang/String;

    move-result-object v1

    .line 38
    .local v1, "previousKey":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/CurrentUser;->getEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 39
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "currentUser"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 40
    const-string v2, "previousUser"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 41
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 42
    return-void
.end method

.method protected getEditor()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/cim/model/user/CurrentUser;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/cim/model/user/CurrentUser;->preferences:Landroid/content/SharedPreferences;

    const-string v1, "currentUser"

    const-string v2, "unknownUser"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPreviousKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/model/user/CurrentUser;->preferences:Landroid/content/SharedPreferences;

    const-string v1, "previousUser"

    const-string v2, "unknownUser"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/CurrentUser;->getKey()Ljava/lang/String;

    move-result-object v1

    .line 18
    .local v1, "previousKey":Ljava/lang/String;
    const-string v2, "unknownUser"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 19
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/CurrentUser;->getPreviousKey()Ljava/lang/String;

    move-result-object v1

    .line 21
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/model/user/CurrentUser;->getEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 22
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "currentUser"

    invoke-interface {v0, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 23
    const-string v2, "previousUser"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 24
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 25
    return-object v1
.end method
