.class public Lcom/igexin/sdk/bean/NotificationBean;
.super Lcom/igexin/sdk/bean/BaseBean;
.source "NotificationBean.java"


# instance fields
.field private banner_url:Ljava/lang/String;

.field private banner_url_src:Ljava/lang/String;

.field private content:Ljava/lang/String;

.field private is_noclear:Z

.field private is_noring:Z

.field private is_novibrate:Z

.field private logo:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private url_logo:Ljava/lang/String;

.field private url_logo_src:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 10
    invoke-direct {p0}, Lcom/igexin/sdk/bean/BaseBean;-><init>()V

    .line 14
    iput-boolean v1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noclear:Z

    .line 15
    iput-boolean v1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_novibrate:Z

    .line 16
    iput-boolean v1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noring:Z

    .line 17
    iput-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->logo:Ljava/lang/String;

    .line 18
    iput-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo:Ljava/lang/String;

    .line 19
    iput-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url:Ljava/lang/String;

    .line 21
    iput-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo_src:Ljava/lang/String;

    .line 22
    iput-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url_src:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getBanner_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url:Ljava/lang/String;

    return-object v0
.end method

.method public getBanner_url_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url_src:Ljava/lang/String;

    return-object v0
.end method

.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getLogo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->logo:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 66
    const-string/jumbo v0, ""

    .line 68
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->logo:Ljava/lang/String;

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl_logo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl_logo_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo_src:Ljava/lang/String;

    return-object v0
.end method

.method public isIs_noclear()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noclear:Z

    return v0
.end method

.method public isIs_noring()Z
    .locals 1

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noring:Z

    return v0
.end method

.method public isIs_novibrate()Z
    .locals 1

    .prologue
    .line 53
    iget-boolean v0, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_novibrate:Z

    return v0
.end method

.method public setBanner_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "banner_url"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public setBanner_url_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "banner_url_src"    # Ljava/lang/String;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->banner_url_src:Ljava/lang/String;

    .line 105
    return-void
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->content:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setIs_noclear(Z)V
    .locals 0
    .param p1, "is_noclear"    # Z

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noclear:Z

    .line 42
    return-void
.end method

.method public setIs_noring(Z)V
    .locals 0
    .param p1, "is_noring"    # Z

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_noring:Z

    .line 58
    return-void
.end method

.method public setIs_novibrate(Z)V
    .locals 0
    .param p1, "is_novibrate"    # Z

    .prologue
    .line 49
    iput-boolean p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->is_novibrate:Z

    .line 50
    return-void
.end method

.method public setLogo(Ljava/lang/String;)V
    .locals 0
    .param p1, "logo"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->logo:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->title:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setUrl_logo(Ljava/lang/String;)V
    .locals 0
    .param p1, "url_logo"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setUrl_logo_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "url_logo_src"    # Ljava/lang/String;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/igexin/sdk/bean/NotificationBean;->url_logo_src:Ljava/lang/String;

    .line 97
    return-void
.end method
